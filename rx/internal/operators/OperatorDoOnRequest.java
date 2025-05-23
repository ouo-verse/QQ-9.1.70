package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorDoOnRequest<T> implements Observable.Operator<T, T> {
    final Action1<Long> request;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;

        ParentSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            request(0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestMore(long j3) {
            request(j3);
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
        }
    }

    public OperatorDoOnRequest(Action1<Long> action1) {
        this.request = action1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorDoOnRequest.1
            @Override // rx.Producer
            public void request(long j3) {
                OperatorDoOnRequest.this.request.call(Long.valueOf(j3));
                parentSubscriber.requestMore(j3);
            }
        });
        subscriber.add(parentSubscriber);
        return parentSubscriber;
    }
}
