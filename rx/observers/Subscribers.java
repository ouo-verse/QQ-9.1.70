package rx.observers;

import rx.Observer;
import rx.Subscriber;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Subscribers {
    Subscribers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1) {
        if (action1 != null) {
            return new Subscriber<T>() { // from class: rx.observers.Subscribers.2
                @Override // rx.Observer
                public final void onError(Throwable th5) {
                    throw new OnErrorNotImplementedException(th5);
                }

                @Override // rx.Observer
                public final void onNext(T t16) {
                    Action1.this.call(t16);
                }

                @Override // rx.Observer
                public final void onCompleted() {
                }
            };
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> Subscriber<T> empty() {
        return from(Observers.empty());
    }

    public static <T> Subscriber<T> from(final Observer<? super T> observer) {
        return new Subscriber<T>() { // from class: rx.observers.Subscribers.1
            @Override // rx.Observer
            public void onCompleted() {
                Observer.this.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                Observer.this.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                Observer.this.onNext(t16);
            }
        };
    }

    public static <T> Subscriber<T> wrap(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.observers.Subscribers.5
            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                subscriber.onNext(t16);
            }
        };
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1, final Action1<Throwable> action12) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action12 != null) {
            return new Subscriber<T>() { // from class: rx.observers.Subscribers.3
                @Override // rx.Observer
                public final void onError(Throwable th5) {
                    Action1.this.call(th5);
                }

                @Override // rx.Observer
                public final void onNext(T t16) {
                    action1.call(t16);
                }

                @Override // rx.Observer
                public final void onCompleted() {
                }
            };
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1, final Action1<Throwable> action12, final Action0 action0) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action12 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        if (action0 != null) {
            return new Subscriber<T>() { // from class: rx.observers.Subscribers.4
                @Override // rx.Observer
                public final void onCompleted() {
                    Action0.this.call();
                }

                @Override // rx.Observer
                public final void onError(Throwable th5) {
                    action12.call(th5);
                }

                @Override // rx.Observer
                public final void onNext(T t16) {
                    action1.call(t16);
                }
            };
        }
        throw new IllegalArgumentException("onComplete can not be null");
    }
}
