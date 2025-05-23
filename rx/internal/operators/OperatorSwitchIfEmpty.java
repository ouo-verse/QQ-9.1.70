package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorSwitchIfEmpty<T> implements Observable.Operator<T, T> {
    private final Observable<? extends T> alternate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AlternateSubscriber<T> extends Subscriber<T> {
        private final ProducerArbiter arbiter;
        private final Subscriber<? super T> child;

        AlternateSubscriber(Subscriber<? super T> subscriber, ProducerArbiter producerArbiter) {
            this.child = subscriber;
            this.arbiter = producerArbiter;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.child.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.child.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.child.onNext(t16);
            this.arbiter.produced(1L);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Observable<? extends T> alternate;
        private final ProducerArbiter arbiter;
        private final Subscriber<? super T> child;
        private boolean empty = true;
        private final SerialSubscription ssub;

        ParentSubscriber(Subscriber<? super T> subscriber, SerialSubscription serialSubscription, ProducerArbiter producerArbiter, Observable<? extends T> observable) {
            this.child = subscriber;
            this.ssub = serialSubscription;
            this.arbiter = producerArbiter;
            this.alternate = observable;
        }

        private void subscribeToAlternate() {
            AlternateSubscriber alternateSubscriber = new AlternateSubscriber(this.child, this.arbiter);
            this.ssub.set(alternateSubscriber);
            this.alternate.unsafeSubscribe(alternateSubscriber);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.empty) {
                this.child.onCompleted();
            } else if (!this.child.isUnsubscribed()) {
                subscribeToAlternate();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.child.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.empty = false;
            this.child.onNext(t16);
            this.arbiter.produced(1L);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }
    }

    public OperatorSwitchIfEmpty(Observable<? extends T> observable) {
        this.alternate = observable;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerialSubscription serialSubscription = new SerialSubscription();
        ProducerArbiter producerArbiter = new ProducerArbiter();
        ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber, serialSubscription, producerArbiter, this.alternate);
        serialSubscription.set(parentSubscriber);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        return parentSubscriber;
    }
}
