package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

/* loaded from: classes29.dex */
public final class OperatorTakeUntilPredicate<T> implements Observable.Operator<T, T> {
    final Func1<? super T, Boolean> stopPredicate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public final class ParentSubscriber extends Subscriber<T> {
        private final Subscriber<? super T> child;
        private boolean done;

        ParentSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        void downstreamRequest(long j3) {
            request(j3);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.child.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.done) {
                this.child.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.child.onNext(t16);
            try {
                if (OperatorTakeUntilPredicate.this.stopPredicate.call(t16).booleanValue()) {
                    this.done = true;
                    this.child.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th5) {
                this.done = true;
                Exceptions.throwOrReport(th5, this.child, t16);
                unsubscribe();
            }
        }
    }

    public OperatorTakeUntilPredicate(Func1<? super T, Boolean> func1) {
        this.stopPredicate = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTakeUntilPredicate.1
            @Override // rx.Producer
            public void request(long j3) {
                parentSubscriber.downstreamRequest(j3);
            }
        });
        return parentSubscriber;
    }
}
