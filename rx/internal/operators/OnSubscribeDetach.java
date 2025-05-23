package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeDetach<T> implements Observable.OnSubscribe<T> {
    final Observable<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DetachProducer<T> implements Producer, Subscription {
        final DetachSubscriber<T> parent;

        public DetachProducer(DetachSubscriber<T> detachSubscriber) {
            this.parent = detachSubscriber;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.parent.isUnsubscribed();
        }

        @Override // rx.Producer
        public void request(long j3) {
            this.parent.innerRequest(j3);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.parent.innerUnsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DetachSubscriber<T> extends Subscriber<T> {
        final AtomicReference<Subscriber<? super T>> actual;
        final AtomicReference<Producer> producer = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        public DetachSubscriber(Subscriber<? super T> subscriber) {
            this.actual = new AtomicReference<>(subscriber);
        }

        void innerRequest(long j3) {
            if (j3 >= 0) {
                Producer producer = this.producer.get();
                if (producer != null) {
                    producer.request(j3);
                    return;
                }
                BackpressureUtils.getAndAddRequest(this.requested, j3);
                Producer producer2 = this.producer.get();
                if (producer2 != null && producer2 != TerminatedProducer.INSTANCE) {
                    producer2.request(this.requested.getAndSet(0L));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j3);
        }

        void innerUnsubscribe() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            this.actual.lazySet(null);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onError(th5);
            } else {
                RxJavaHooks.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            Subscriber<? super T> subscriber = this.actual.get();
            if (subscriber != null) {
                subscriber.onNext(t16);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            if (c.a(this.producer, null, producer)) {
                producer.request(this.requested.getAndSet(0L));
            } else if (this.producer.get() == TerminatedProducer.INSTANCE) {
            } else {
                throw new IllegalStateException("Producer already set!");
            }
        }
    }

    public OnSubscribeDetach(Observable<T> observable) {
        this.source = observable;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        DetachSubscriber detachSubscriber = new DetachSubscriber(subscriber);
        DetachProducer detachProducer = new DetachProducer(detachSubscriber);
        subscriber.add(detachProducer);
        subscriber.setProducer(detachProducer);
        this.source.unsafeSubscribe(detachSubscriber);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum TerminatedProducer implements Producer {
        INSTANCE;

        @Override // rx.Producer
        public void request(long j3) {
        }
    }
}
