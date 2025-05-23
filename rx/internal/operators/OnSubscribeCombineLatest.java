package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    final int bufferSize;
    final FuncN<? extends R> combiner;
    final boolean delayError;
    final Observable<? extends T>[] sources;
    final Iterable<? extends Observable<? extends T>> sourcesIterable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CombinerSubscriber<T, R> extends Subscriber<T> {
        boolean done;
        final int index;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432660nl = NotificationLite.instance();
        final LatestCoordinator<T, R> parent;

        public CombinerSubscriber(LatestCoordinator<T, R> latestCoordinator, int i3) {
            this.parent = latestCoordinator;
            this.index = i3;
            request(latestCoordinator.bufferSize);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.combine(null, this.index);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.done) {
                RxJavaHooks.onError(th5);
                return;
            }
            this.parent.onError(th5);
            this.done = true;
            this.parent.combine(null, this.index);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (this.done) {
                return;
            }
            this.parent.combine(this.f432660nl.next(t16), this.index);
        }

        public void requestMore(long j3) {
            request(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
        static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final Subscriber<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final FuncN<? extends R> combiner;
        int complete;
        final int count;
        final boolean delayError;
        volatile boolean done;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        final SpscLinkedArrayQueue<Object> queue;
        final AtomicLong requested;
        final CombinerSubscriber<T, R>[] subscribers;

        public LatestCoordinator(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i3, int i16, boolean z16) {
            this.actual = subscriber;
            this.combiner = funcN;
            this.count = i3;
            this.bufferSize = i16;
            this.delayError = z16;
            Object[] objArr = new Object[i3];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new CombinerSubscriber[i3];
            this.queue = new SpscLinkedArrayQueue<>(i16);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        void cancel(Queue<?> queue) {
            queue.clear();
            for (CombinerSubscriber<T, R> combinerSubscriber : this.subscribers) {
                combinerSubscriber.unsubscribe();
            }
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<?> subscriber, Queue<?> queue, boolean z18) {
            if (this.cancelled) {
                cancel(queue);
                return true;
            }
            if (z16) {
                if (z18) {
                    if (z17) {
                        Throwable th5 = this.error.get();
                        if (th5 != null) {
                            subscriber.onError(th5);
                        } else {
                            subscriber.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th6 = this.error.get();
                if (th6 != null) {
                    cancel(queue);
                    subscriber.onError(th6);
                    return true;
                }
                if (z17) {
                    subscriber.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }

        void combine(Object obj, int i3) {
            boolean z16;
            CombinerSubscriber<T, R> combinerSubscriber = this.subscribers[i3];
            synchronized (this) {
                Object[] objArr = this.latest;
                int length = objArr.length;
                Object obj2 = objArr[i3];
                int i16 = this.active;
                Object obj3 = MISSING;
                if (obj2 == obj3) {
                    i16++;
                    this.active = i16;
                }
                int i17 = this.complete;
                if (obj == null) {
                    i17++;
                    this.complete = i17;
                } else {
                    objArr[i3] = combinerSubscriber.f432660nl.getValue(obj);
                }
                boolean z17 = false;
                if (i16 == length) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (i17 == length || (obj == null && obj2 == obj3)) {
                    z17 = true;
                }
                if (!z17) {
                    if (obj != null && z16) {
                        this.queue.offer(combinerSubscriber, this.latest.clone());
                    } else if (obj == null && this.error.get() != null && (obj2 == obj3 || !this.delayError)) {
                        this.done = true;
                    }
                } else {
                    this.done = true;
                }
            }
            if (!z16 && obj != null) {
                combinerSubscriber.requestMore(1L);
            } else {
                drain();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
        
            if (r3 == 0) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009d, code lost:
        
            if (r13 == Long.MAX_VALUE) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009f, code lost:
        
            rx.internal.operators.BackpressureUtils.produced(r10, r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:
        
            r12 = addAndGet(-r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
        
            if (r12 != 0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            long j3;
            boolean z16;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Subscriber<? super R> subscriber = this.actual;
            boolean z17 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int i3 = 1;
            while (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue, z17)) {
                long j16 = atomicLong.get();
                long j17 = 0;
                while (true) {
                    if (j17 != j16) {
                        boolean z18 = this.done;
                        CombinerSubscriber combinerSubscriber = (CombinerSubscriber) spscLinkedArrayQueue.peek();
                        if (combinerSubscriber == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        long j18 = j17;
                        if (checkTerminated(z18, z16, subscriber, spscLinkedArrayQueue, z17)) {
                            return;
                        }
                        if (z16) {
                            j3 = j18;
                            break;
                        }
                        spscLinkedArrayQueue.poll();
                        Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                        if (objArr == null) {
                            this.cancelled = true;
                            cancel(spscLinkedArrayQueue);
                            subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                            return;
                        }
                        try {
                            subscriber.onNext(this.combiner.call(objArr));
                            combinerSubscriber.requestMore(1L);
                            j17 = j18 + 1;
                        } catch (Throwable th5) {
                            this.cancelled = true;
                            cancel(spscLinkedArrayQueue);
                            subscriber.onError(th5);
                            return;
                        }
                    } else {
                        j3 = j17;
                        break;
                    }
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        void onError(Throwable th5) {
            Throwable th6;
            Throwable th7;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th6 = atomicReference.get();
                if (th6 != null) {
                    if (th6 instanceof CompositeException) {
                        ArrayList arrayList = new ArrayList(((CompositeException) th6).getExceptions());
                        arrayList.add(th5);
                        th7 = new CompositeException(arrayList);
                    } else {
                        th7 = new CompositeException(Arrays.asList(th6, th5));
                    }
                } else {
                    th7 = th5;
                }
            } while (!c.a(atomicReference, th6, th7));
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 != 0) {
                    BackpressureUtils.getAndAddRequest(this.requested, j3);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j3);
        }

        public void subscribe(Observable<? extends T>[] observableArr) {
            CombinerSubscriber<T, R>[] combinerSubscriberArr = this.subscribers;
            int length = combinerSubscriberArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                combinerSubscriberArr[i3] = new CombinerSubscriber<>(this, i3);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i16 = 0; i16 < length && !this.cancelled; i16++) {
                observableArr[i16].subscribe((Subscriber<? super Object>) combinerSubscriberArr[i16]);
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        this(null, iterable, funcN, RxRingBuffer.SIZE, false);
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] observableArr, Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN, int i3, boolean z16) {
        this.sources = observableArr;
        this.sourcesIterable = iterable;
        this.combiner = funcN;
        this.bufferSize = i3;
        this.delayError = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0049  */
    @Override // rx.functions.Action1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void call(Subscriber<? super R> subscriber) {
        int length;
        int i3;
        Observable<? extends T>[] observableArr = this.sources;
        if (observableArr == null) {
            Iterable<? extends Observable<? extends T>> iterable = this.sourcesIterable;
            if (iterable instanceof List) {
                List list = (List) iterable;
                observableArr = (Observable[]) list.toArray(new Observable[list.size()]);
                length = observableArr.length;
            } else {
                Observable<? extends T>[] observableArr2 = new Observable[8];
                int i16 = 0;
                for (Observable<? extends T> observable : iterable) {
                    if (i16 == observableArr2.length) {
                        Observable<? extends T>[] observableArr3 = new Observable[(i16 >> 2) + i16];
                        System.arraycopy(observableArr2, 0, observableArr3, 0, i16);
                        observableArr2 = observableArr3;
                    }
                    observableArr2[i16] = observable;
                    i16++;
                }
                observableArr = observableArr2;
                i3 = i16;
                if (i3 != 0) {
                    subscriber.onCompleted();
                    return;
                } else {
                    new LatestCoordinator(subscriber, this.combiner, i3, this.bufferSize, this.delayError).subscribe(observableArr);
                    return;
                }
            }
        } else {
            length = observableArr.length;
        }
        i3 = length;
        if (i3 != 0) {
        }
    }
}
