package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorMapNotification<T, R> implements Observable.Operator<R, T> {
    final Func0<? extends R> onCompleted;
    final Func1<? super Throwable, ? extends R> onError;
    final Func1<? super T, ? extends R> onNext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MapNotificationSubscriber<T, R> extends Subscriber<T> {
        static final long COMPLETED_FLAG = Long.MIN_VALUE;
        static final long REQUESTED_MASK = Long.MAX_VALUE;
        final Subscriber<? super R> actual;
        final Func0<? extends R> onCompleted;
        final Func1<? super Throwable, ? extends R> onError;
        final Func1<? super T, ? extends R> onNext;
        long produced;
        R value;
        final AtomicLong requested = new AtomicLong();
        final AtomicLong missedRequested = new AtomicLong();
        final AtomicReference<Producer> producer = new AtomicReference<>();

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
            this.actual = subscriber;
            this.onNext = func1;
            this.onError = func12;
            this.onCompleted = func0;
        }

        void accountProduced() {
            long j3 = this.produced;
            if (j3 != 0 && this.producer.get() != null) {
                BackpressureUtils.produced(this.requested, j3);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            accountProduced();
            try {
                this.value = this.onCompleted.call();
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, this.actual);
            }
            tryEmit();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            accountProduced();
            try {
                this.value = this.onError.call(th5);
            } catch (Throwable th6) {
                Exceptions.throwOrReport(th6, this.actual, th5);
            }
            tryEmit();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            try {
                this.produced++;
                this.actual.onNext(this.onNext.call(t16));
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, this.actual, t16);
            }
        }

        void requestInner(long j3) {
            if (j3 >= 0) {
                if (j3 == 0) {
                    return;
                }
                while (true) {
                    long j16 = this.requested.get();
                    if ((j16 & Long.MIN_VALUE) != 0) {
                        long j17 = Long.MAX_VALUE & j16;
                        if (this.requested.compareAndSet(j16, Long.MIN_VALUE | BackpressureUtils.addCap(j17, j3))) {
                            if (j17 == 0) {
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onNext(this.value);
                                }
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onCompleted();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.requested.compareAndSet(j16, BackpressureUtils.addCap(j16, j3))) {
                            AtomicReference<Producer> atomicReference = this.producer;
                            Producer producer = atomicReference.get();
                            if (producer != null) {
                                producer.request(j3);
                                return;
                            }
                            BackpressureUtils.getAndAddRequest(this.missedRequested, j3);
                            Producer producer2 = atomicReference.get();
                            if (producer2 != null) {
                                long andSet = this.missedRequested.getAndSet(0L);
                                if (andSet != 0) {
                                    producer2.request(andSet);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j3);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            if (c.a(this.producer, null, producer)) {
                long andSet = this.missedRequested.getAndSet(0L);
                if (andSet != 0) {
                    producer.request(andSet);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Producer already set!");
        }

        void tryEmit() {
            long j3;
            do {
                j3 = this.requested.get();
                if ((j3 & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.requested.compareAndSet(j3, Long.MIN_VALUE | j3));
            if (j3 != 0 || this.producer.get() == null) {
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onNext(this.value);
                }
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onCompleted();
                }
            }
        }
    }

    public OperatorMapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        this.onNext = func1;
        this.onError = func12;
        this.onCompleted = func0;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        final MapNotificationSubscriber mapNotificationSubscriber = new MapNotificationSubscriber(subscriber, this.onNext, this.onError, this.onCompleted);
        subscriber.add(mapNotificationSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorMapNotification.1
            @Override // rx.Producer
            public void request(long j3) {
                mapNotificationSubscriber.requestInner(j3);
            }
        });
        return mapNotificationSubscriber;
    }
}
