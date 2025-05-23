package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* loaded from: classes29.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements Observable.OnSubscribe<T>, Observer<T>, Subscription {
    static final PublishProducer<?>[] EMPTY = new PublishProducer[0];
    static final PublishProducer<?>[] TERMINATED = new PublishProducer[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final ParentSubscriber<T> parent;
    final int prefetch;
    volatile Producer producer;
    final Queue<T> queue;
    volatile PublishProducer<T>[] subscribers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        final OnSubscribePublishMulticast<T> state;

        public ParentSubscriber(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.state = onSubscribePublishMulticast;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.state.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.state.onNext(t16);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.state.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static final class PublishProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = 960704844171597367L;
        final Subscriber<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(Subscriber<? super T> subscriber, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = subscriber;
            this.parent = onSubscribePublishMulticast;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 != 0) {
                    BackpressureUtils.getAndAddRequest(this, j3);
                    this.parent.drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j3);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int i3, boolean z16) {
        if (i3 > 0) {
            this.prefetch = i3;
            this.delayError = z16;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i3);
            } else {
                this.queue = new SpscAtomicArrayQueue(i3);
            }
            this.subscribers = (PublishProducer<T>[]) EMPTY;
            this.parent = new ParentSubscriber<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i3);
    }

    boolean add(PublishProducer<T> publishProducer) {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<?>[] publishProducerArr2 = TERMINATED;
        if (publishProducerArr == publishProducerArr2) {
            return false;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr3 = this.subscribers;
            if (publishProducerArr3 == publishProducerArr2) {
                return false;
            }
            int length = publishProducerArr3.length;
            PublishProducer<T>[] publishProducerArr4 = new PublishProducer[length + 1];
            System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, length);
            publishProducerArr4[length] = publishProducer;
            this.subscribers = publishProducerArr4;
            return true;
        }
    }

    boolean checkTerminated(boolean z16, boolean z17) {
        int i3 = 0;
        if (z16) {
            if (this.delayError) {
                if (z17) {
                    PublishProducer<T>[] terminate = terminate();
                    Throwable th5 = this.error;
                    if (th5 != null) {
                        int length = terminate.length;
                        while (i3 < length) {
                            terminate[i3].actual.onError(th5);
                            i3++;
                        }
                    } else {
                        int length2 = terminate.length;
                        while (i3 < length2) {
                            terminate[i3].actual.onCompleted();
                            i3++;
                        }
                    }
                    return true;
                }
            } else {
                Throwable th6 = this.error;
                if (th6 != null) {
                    this.queue.clear();
                    PublishProducer<T>[] terminate2 = terminate();
                    int length3 = terminate2.length;
                    while (i3 < length3) {
                        terminate2[i3].actual.onError(th6);
                        i3++;
                    }
                    return true;
                }
                if (z17) {
                    PublishProducer<T>[] terminate3 = terminate();
                    int length4 = terminate3.length;
                    while (i3 < length4) {
                        terminate3[i3].actual.onCompleted();
                        i3++;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    void drain() {
        boolean z16;
        if (getAndIncrement() != 0) {
            return;
        }
        Queue<T> queue = this.queue;
        int i3 = 0;
        do {
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            int length = publishProducerArr.length;
            long j3 = Long.MAX_VALUE;
            for (PublishProducer<T> publishProducer : publishProducerArr) {
                j3 = Math.min(j3, publishProducer.get());
            }
            if (length != 0) {
                long j16 = 0;
                while (j16 != j3) {
                    boolean z17 = this.done;
                    T poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (checkTerminated(z17, z16)) {
                        return;
                    }
                    if (z16) {
                        break;
                    }
                    for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                        publishProducer2.actual.onNext(poll);
                    }
                    j16++;
                }
                if (j16 == j3 && checkTerminated(this.done, queue.isEmpty())) {
                    return;
                }
                if (j16 != 0) {
                    Producer producer = this.producer;
                    if (producer != null) {
                        producer.request(j16);
                    }
                    for (PublishProducer<T> publishProducer3 : publishProducerArr) {
                        BackpressureUtils.produced(publishProducer3, j16);
                    }
                }
            }
            i3 = addAndGet(-i3);
        } while (i3 != 0);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
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
        if (!this.queue.offer(t16)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    void remove(PublishProducer<T> publishProducer) {
        PublishProducer<?>[] publishProducerArr;
        PublishProducer[] publishProducerArr2;
        PublishProducer<T>[] publishProducerArr3 = this.subscribers;
        PublishProducer<?>[] publishProducerArr4 = TERMINATED;
        if (publishProducerArr3 != publishProducerArr4 && publishProducerArr3 != (publishProducerArr = EMPTY)) {
            synchronized (this) {
                PublishProducer<T>[] publishProducerArr5 = this.subscribers;
                if (publishProducerArr5 != publishProducerArr4 && publishProducerArr5 != publishProducerArr) {
                    int length = publishProducerArr5.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (publishProducerArr5[i3] == publishProducer) {
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
                        publishProducerArr2 = EMPTY;
                    } else {
                        PublishProducer[] publishProducerArr6 = new PublishProducer[length - 1];
                        System.arraycopy(publishProducerArr5, 0, publishProducerArr6, 0, i3);
                        System.arraycopy(publishProducerArr5, i3 + 1, publishProducerArr6, i3, (length - i3) - 1);
                        publishProducerArr2 = publishProducerArr6;
                    }
                    this.subscribers = publishProducerArr2;
                }
            }
        }
    }

    void setProducer(Producer producer) {
        this.producer = producer;
        producer.request(this.prefetch);
    }

    public Subscriber<T> subscriber() {
        return this.parent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    PublishProducer<T>[] terminate() {
        PublishProducer<T>[] publishProducerArr = this.subscribers;
        PublishProducer<T>[] publishProducerArr2 = (PublishProducer<T>[]) TERMINATED;
        if (publishProducerArr != publishProducerArr2) {
            synchronized (this) {
                publishProducerArr = this.subscribers;
                if (publishProducerArr != publishProducerArr2) {
                    this.subscribers = publishProducerArr2;
                }
            }
        }
        return publishProducerArr;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        PublishProducer<T> publishProducer = new PublishProducer<>(subscriber, this);
        subscriber.add(publishProducer);
        subscriber.setProducer(publishProducer);
        if (add(publishProducer)) {
            if (publishProducer.isUnsubscribed()) {
                remove(publishProducer);
                return;
            } else {
                drain();
                return;
            }
        }
        Throwable th5 = this.error;
        if (th5 != null) {
            subscriber.onError(th5);
        } else {
            subscriber.onCompleted();
        }
    }
}
