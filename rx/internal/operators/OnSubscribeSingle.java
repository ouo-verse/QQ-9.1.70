package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OnSubscribeSingle<T> implements Single.OnSubscribe<T> {
    private final Observable<T> observable;

    public OnSubscribeSingle(Observable<T> observable) {
        this.observable = observable;
    }

    public static <T> OnSubscribeSingle<T> create(Observable<T> observable) {
        return new OnSubscribeSingle<>(observable);
    }

    @Override // rx.functions.Action1
    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.OnSubscribeSingle.1
            private T emission;
            private boolean emittedTooMany;
            private boolean itemEmitted;

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.emittedTooMany) {
                    if (this.itemEmitted) {
                        singleSubscriber.onSuccess(this.emission);
                    } else {
                        singleSubscriber.onError(new NoSuchElementException("Observable emitted no items"));
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                singleSubscriber.onError(th5);
                unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                if (this.itemEmitted) {
                    this.emittedTooMany = true;
                    singleSubscriber.onError(new IllegalArgumentException("Observable emitted too many elements"));
                    unsubscribe();
                } else {
                    this.itemEmitted = true;
                    this.emission = t16;
                }
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(2L);
            }
        };
        singleSubscriber.add(subscriber);
        this.observable.unsafeSubscribe(subscriber);
    }
}
