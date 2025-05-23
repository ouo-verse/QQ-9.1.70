package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.SynchronizedQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observables.ConnectableObservable;
import rx.subscriptions.Subscriptions;

/* loaded from: classes29.dex */
public final class OperatorPublish<T> extends ConnectableObservable<T> {
    final AtomicReference<PublishSubscriber<T>> current;
    final Observable<? extends T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long NOT_REQUESTED = -4611686018427387904L;
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        final PublishSubscriber<T> parent;

        public InnerProducer(PublishSubscriber<T> publishSubscriber, Subscriber<? super T> subscriber) {
            this.parent = publishSubscriber;
            this.child = subscriber;
            lazySet(NOT_REQUESTED);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public long produced(long j3) {
            long j16;
            long j17;
            if (j3 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j16 = get();
                if (j16 != NOT_REQUESTED) {
                    if (j16 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j17 = j16 - j3;
                    if (j17 < 0) {
                        throw new IllegalStateException("More produced (" + j3 + ") than requested (" + j16 + ")");
                    }
                } else {
                    throw new IllegalStateException("Produced without request");
                }
            } while (!compareAndSet(j16, j17));
            return j17;
        }

        @Override // rx.Producer
        public void request(long j3) {
            long j16;
            long j17;
            if (j3 < 0) {
                return;
            }
            do {
                j16 = get();
                if (j16 == Long.MIN_VALUE) {
                    return;
                }
                if (j16 >= 0 && j3 == 0) {
                    return;
                }
                if (j16 == NOT_REQUESTED) {
                    j17 = j3;
                } else {
                    j17 = j16 + j3;
                    if (j17 < 0) {
                        j17 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j16, j17));
            this.parent.dispatch();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.dispatch();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static final class PublishSubscriber<T> extends Subscriber<T> {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final AtomicReference<PublishSubscriber<T>> current;
        boolean emitting;
        boolean missed;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432676nl;
        final AtomicReference<InnerProducer[]> producers;
        final Queue<Object> queue;
        final AtomicBoolean shouldConnect;
        volatile Object terminalEvent;

        public PublishSubscriber(AtomicReference<PublishSubscriber<T>> atomicReference) {
            Queue<Object> synchronizedQueue;
            if (UnsafeAccess.isUnsafeAvailable()) {
                synchronizedQueue = new SpscArrayQueue<>(RxRingBuffer.SIZE);
            } else {
                synchronizedQueue = new SynchronizedQueue<>(RxRingBuffer.SIZE);
            }
            this.queue = synchronizedQueue;
            this.f432676nl = NotificationLite.instance();
            this.producers = new AtomicReference<>(EMPTY);
            this.current = atomicReference;
            this.shouldConnect = new AtomicBoolean();
        }

        boolean add(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            innerProducer.getClass();
            do {
                innerProducerArr = this.producers.get();
                if (innerProducerArr == TERMINATED) {
                    return false;
                }
                int length = innerProducerArr.length;
                innerProducerArr2 = new InnerProducer[length + 1];
                System.arraycopy(innerProducerArr, 0, innerProducerArr2, 0, length);
                innerProducerArr2[length] = innerProducer;
            } while (!c.a(this.producers, innerProducerArr, innerProducerArr2));
            return true;
        }

        boolean checkTerminated(Object obj, boolean z16) {
            int i3 = 0;
            if (obj != null) {
                if (this.f432676nl.isCompleted(obj)) {
                    if (z16) {
                        c.a(this.current, this, null);
                        try {
                            InnerProducer[] andSet = this.producers.getAndSet(TERMINATED);
                            int length = andSet.length;
                            while (i3 < length) {
                                andSet[i3].child.onCompleted();
                                i3++;
                            }
                            return true;
                        } finally {
                        }
                    }
                } else {
                    Throwable error = this.f432676nl.getError(obj);
                    c.a(this.current, this, null);
                    try {
                        InnerProducer[] andSet2 = this.producers.getAndSet(TERMINATED);
                        int length2 = andSet2.length;
                        while (i3 < length2) {
                            andSet2[i3].child.onError(error);
                            i3++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        void dispatch() {
            boolean z16;
            boolean z17;
            long j3;
            boolean z18;
            synchronized (this) {
                boolean z19 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        Object obj = this.terminalEvent;
                        boolean isEmpty = this.queue.isEmpty();
                        if (checkTerminated(obj, isEmpty)) {
                            return;
                        }
                        if (!isEmpty) {
                            InnerProducer[] innerProducerArr = this.producers.get();
                            int length = innerProducerArr.length;
                            long j16 = Long.MAX_VALUE;
                            int i3 = 0;
                            for (InnerProducer innerProducer : innerProducerArr) {
                                long j17 = innerProducer.get();
                                if (j17 >= 0) {
                                    j16 = Math.min(j16, j17);
                                } else if (j17 == Long.MIN_VALUE) {
                                    i3++;
                                }
                            }
                            if (length == i3) {
                                Object obj2 = this.terminalEvent;
                                if (this.queue.poll() == null) {
                                    z17 = z19;
                                } else {
                                    z17 = false;
                                }
                                if (checkTerminated(obj2, z17)) {
                                    return;
                                } else {
                                    request(1L);
                                }
                            } else {
                                int i16 = 0;
                                while (true) {
                                    j3 = i16;
                                    if (j3 >= j16) {
                                        break;
                                    }
                                    Object obj3 = this.terminalEvent;
                                    Object poll = this.queue.poll();
                                    if (poll == null) {
                                        z18 = z19;
                                    } else {
                                        z18 = false;
                                    }
                                    if (checkTerminated(obj3, z18)) {
                                        return;
                                    }
                                    if (z18) {
                                        isEmpty = z18;
                                        break;
                                    }
                                    T value = this.f432676nl.getValue(poll);
                                    for (InnerProducer innerProducer2 : innerProducerArr) {
                                        if (innerProducer2.get() > 0) {
                                            try {
                                                innerProducer2.child.onNext(value);
                                                innerProducer2.produced(1L);
                                            } catch (Throwable th5) {
                                                innerProducer2.unsubscribe();
                                                Exceptions.throwOrReport(th5, innerProducer2.child, value);
                                            }
                                        }
                                    }
                                    i16++;
                                    isEmpty = z18;
                                    z19 = true;
                                }
                                if (i16 > 0) {
                                    request(j3);
                                }
                                if (j16 != 0 && !isEmpty) {
                                    z19 = true;
                                }
                            }
                        }
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    this.emitting = false;
                                    try {
                                        return;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        z16 = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th7) {
                                                th = th7;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.missed = false;
                            } catch (Throwable th8) {
                                th = th8;
                                z16 = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th9) {
                            th = th9;
                            if (!z16) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        z16 = false;
                    }
                }
            }
        }

        void init() {
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorPublish.PublishSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    PublishSubscriber.this.producers.getAndSet(PublishSubscriber.TERMINATED);
                    PublishSubscriber publishSubscriber = PublishSubscriber.this;
                    c.a(publishSubscriber.current, publishSubscriber, null);
                }
            }));
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.terminalEvent == null) {
                this.terminalEvent = this.f432676nl.completed();
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.terminalEvent == null) {
                this.terminalEvent = this.f432676nl.error(th5);
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!this.queue.offer(this.f432676nl.next(t16))) {
                onError(new MissingBackpressureException());
            } else {
                dispatch();
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RxRingBuffer.SIZE);
        }

        void remove(InnerProducer<T> innerProducer) {
            InnerProducer[] innerProducerArr;
            InnerProducer[] innerProducerArr2;
            do {
                innerProducerArr = this.producers.get();
                if (innerProducerArr != EMPTY && innerProducerArr != TERMINATED) {
                    int length = innerProducerArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (innerProducerArr[i3].equals(innerProducer)) {
                                break;
                            } else {
                                i3++;
                            }
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 < 0) {
                        return;
                    }
                    if (length == 1) {
                        innerProducerArr2 = EMPTY;
                    } else {
                        InnerProducer[] innerProducerArr3 = new InnerProducer[length - 1];
                        System.arraycopy(innerProducerArr, 0, innerProducerArr3, 0, i3);
                        System.arraycopy(innerProducerArr, i3 + 1, innerProducerArr3, i3, (length - i3) - 1);
                        innerProducerArr2 = innerProducerArr3;
                    }
                } else {
                    return;
                }
            } while (!c.a(this.producers, innerProducerArr, innerProducerArr2));
        }
    }

    OperatorPublish(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<PublishSubscriber<T>> atomicReference) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorPublish.1
            @Override // rx.functions.Action1
            public void call(Subscriber<? super T> subscriber) {
                while (true) {
                    PublishSubscriber publishSubscriber = (PublishSubscriber) atomicReference.get();
                    if (publishSubscriber == null || publishSubscriber.isUnsubscribed()) {
                        PublishSubscriber publishSubscriber2 = new PublishSubscriber(atomicReference);
                        publishSubscriber2.init();
                        if (c.a(atomicReference, publishSubscriber, publishSubscriber2)) {
                            publishSubscriber = publishSubscriber2;
                        } else {
                            continue;
                        }
                    }
                    InnerProducer<T> innerProducer = new InnerProducer<>(publishSubscriber, subscriber);
                    if (publishSubscriber.add((InnerProducer) innerProducer)) {
                        subscriber.add(innerProducer);
                        subscriber.setProducer(innerProducer);
                        return;
                    }
                }
            }
        }, observable, atomicReference);
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> action1) {
        PublishSubscriber<T> publishSubscriber;
        while (true) {
            publishSubscriber = this.current.get();
            if (publishSubscriber != null && !publishSubscriber.isUnsubscribed()) {
                break;
            }
            PublishSubscriber<T> publishSubscriber2 = new PublishSubscriber<>(this.current);
            publishSubscriber2.init();
            if (c.a(this.current, publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z16 = false;
        if (!publishSubscriber.shouldConnect.get() && publishSubscriber.shouldConnect.compareAndSet(false, true)) {
            z16 = true;
        }
        action1.call(publishSubscriber);
        if (z16) {
            this.source.unsafeSubscribe(publishSubscriber);
        }
    }

    public static <T, R> Observable<R> create(Observable<? extends T> observable, Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return create(observable, func1, false);
    }

    public static <T, R> Observable<R> create(final Observable<? extends T> observable, final Func1<? super Observable<T>, ? extends Observable<R>> func1, final boolean z16) {
        return Observable.create(new Observable.OnSubscribe<R>() { // from class: rx.internal.operators.OperatorPublish.2
            @Override // rx.functions.Action1
            public void call(final Subscriber<? super R> subscriber) {
                final OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(RxRingBuffer.SIZE, z16);
                Subscriber<R> subscriber2 = new Subscriber<R>() { // from class: rx.internal.operators.OperatorPublish.2.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        onSubscribePublishMulticast.unsubscribe();
                        subscriber.onError(th5);
                    }

                    @Override // rx.Observer
                    public void onNext(R r16) {
                        subscriber.onNext(r16);
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer producer) {
                        subscriber.setProducer(producer);
                    }
                };
                subscriber.add(onSubscribePublishMulticast);
                subscriber.add(subscriber2);
                ((Observable) func1.call(Observable.create(onSubscribePublishMulticast))).unsafeSubscribe(subscriber2);
                observable.unsafeSubscribe(onSubscribePublishMulticast.subscriber());
            }
        });
    }
}
