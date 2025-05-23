package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorEagerConcatMap<T, R> implements Observable.Operator<R, T> {
    final int bufferSize;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    private final int maxConcurrent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class EagerInnerSubscriber<T> extends Subscriber<T> {
        volatile boolean done;
        Throwable error;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432670nl;
        final EagerOuterSubscriber<?, T> parent;
        final Queue<Object> queue;

        public EagerInnerSubscriber(EagerOuterSubscriber<?, T> eagerOuterSubscriber, int i3) {
            Queue<Object> spscAtomicArrayQueue;
            this.parent = eagerOuterSubscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                spscAtomicArrayQueue = new SpscArrayQueue<>(i3);
            } else {
                spscAtomicArrayQueue = new SpscAtomicArrayQueue<>(i3);
            }
            this.queue = spscAtomicArrayQueue;
            this.f432670nl = NotificationLite.instance();
            request(i3);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.error = th5;
            this.done = true;
            this.parent.drain();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.queue.offer(this.f432670nl.next(t16));
            this.parent.drain();
        }

        void requestMore(long j3) {
            request(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class EagerOuterProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;
        final EagerOuterSubscriber<?, ?> parent;

        public EagerOuterProducer(EagerOuterSubscriber<?, ?> eagerOuterSubscriber) {
            this.parent = eagerOuterSubscriber;
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 > 0) {
                    BackpressureUtils.getAndAddRequest(this, j3);
                    this.parent.drain();
                    return;
                }
                return;
            }
            throw new IllegalStateException("n >= 0 required but it was " + j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class EagerOuterSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final Func1<? super T, ? extends Observable<? extends R>> mapper;
        private EagerOuterProducer sharedProducer;
        final Queue<EagerInnerSubscriber<R>> subscribers = new LinkedList();
        final AtomicInteger wip = new AtomicInteger();

        public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> func1, int i3, int i16, Subscriber<? super R> subscriber) {
            long j3;
            this.mapper = func1;
            this.bufferSize = i3;
            this.actual = subscriber;
            if (i16 == Integer.MAX_VALUE) {
                j3 = Long.MAX_VALUE;
            } else {
                j3 = i16;
            }
            request(j3);
        }

        void cleanup() {
            ArrayList arrayList;
            synchronized (this.subscribers) {
                arrayList = new ArrayList(this.subscribers);
                this.subscribers.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Subscription) it.next()).unsubscribe();
            }
        }

        void drain() {
            EagerInnerSubscriber<R> peek;
            boolean z16;
            boolean z17;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            EagerOuterProducer eagerOuterProducer = this.sharedProducer;
            Subscriber<? super R> subscriber = this.actual;
            NotificationLite instance = NotificationLite.instance();
            int i3 = 1;
            while (!this.cancelled) {
                boolean z18 = this.done;
                synchronized (this.subscribers) {
                    peek = this.subscribers.peek();
                }
                boolean z19 = false;
                if (peek == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z18) {
                    Throwable th5 = this.error;
                    if (th5 != null) {
                        cleanup();
                        subscriber.onError(th5);
                        return;
                    } else if (z16) {
                        subscriber.onCompleted();
                        return;
                    }
                }
                if (!z16) {
                    long j3 = eagerOuterProducer.get();
                    Queue<Object> queue = peek.queue;
                    long j16 = 0;
                    while (true) {
                        boolean z26 = peek.done;
                        Object peek2 = queue.peek();
                        if (peek2 == null) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z26) {
                            Throwable th6 = peek.error;
                            if (th6 != null) {
                                cleanup();
                                subscriber.onError(th6);
                                return;
                            } else if (z17) {
                                synchronized (this.subscribers) {
                                    this.subscribers.poll();
                                }
                                peek.unsubscribe();
                                request(1L);
                                z19 = true;
                                break;
                            }
                        }
                        if (z17 || j3 == j16) {
                            break;
                        }
                        queue.poll();
                        try {
                            subscriber.onNext((Object) instance.getValue(peek2));
                            j16++;
                        } catch (Throwable th7) {
                            Exceptions.throwOrReport(th7, subscriber, peek2);
                            return;
                        }
                    }
                    if (j16 != 0) {
                        if (j3 != Long.MAX_VALUE) {
                            BackpressureUtils.produced(eagerOuterProducer, j16);
                        }
                        if (!z19) {
                            peek.requestMore(j16);
                        }
                    }
                    if (z19) {
                        continue;
                    }
                }
                i3 = this.wip.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
            cleanup();
        }

        void init() {
            this.sharedProducer = new EagerOuterProducer(this);
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    EagerOuterSubscriber.this.cancelled = true;
                    if (EagerOuterSubscriber.this.wip.getAndIncrement() == 0) {
                        EagerOuterSubscriber.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.sharedProducer);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.error = th5;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            try {
                Observable<? extends R> call = this.mapper.call(t16);
                if (this.cancelled) {
                    return;
                }
                EagerInnerSubscriber<R> eagerInnerSubscriber = new EagerInnerSubscriber<>(this, this.bufferSize);
                synchronized (this.subscribers) {
                    if (this.cancelled) {
                        return;
                    }
                    this.subscribers.add(eagerInnerSubscriber);
                    if (this.cancelled) {
                        return;
                    }
                    call.unsafeSubscribe(eagerInnerSubscriber);
                    drain();
                }
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, this.actual, t16);
            }
        }
    }

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i3, int i16) {
        this.mapper = func1;
        this.bufferSize = i3;
        this.maxConcurrent = i16;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        EagerOuterSubscriber eagerOuterSubscriber = new EagerOuterSubscriber(this.mapper, this.bufferSize, this.maxConcurrent, subscriber);
        eagerOuterSubscriber.init();
        return eagerOuterSubscriber;
    }
}
