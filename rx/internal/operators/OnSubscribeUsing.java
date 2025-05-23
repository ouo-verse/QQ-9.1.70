package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeUsing<T, Resource> implements Observable.OnSubscribe<T> {
    private final Action1<? super Resource> dispose;
    private final boolean disposeEagerly;
    private final Func1<? super Resource, ? extends Observable<? extends T>> observableFactory;
    private final Func0<Resource> resourceFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DisposeAction<Resource> extends AtomicBoolean implements Action0, Subscription {
        private static final long serialVersionUID = 4262875056400218316L;
        private Action1<? super Resource> dispose;
        private Resource resource;

        DisposeAction(Action1<? super Resource> action1, Resource resource) {
            this.dispose = action1;
            this.resource = resource;
            lazySet(false);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, rx.functions.Action1<? super Resource>] */
        @Override // rx.functions.Action0
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r06 = (Resource) null;
                try {
                    this.dispose.call(this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            call();
        }
    }

    public OnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1, boolean z16) {
        this.resourceFactory = func0;
        this.observableFactory = func1;
        this.dispose = action1;
        this.disposeEagerly = z16;
    }

    private Throwable dispose(Action0 action0) {
        try {
            action0.call();
            return null;
        } catch (Throwable th5) {
            return th5;
        }
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        Observable<? extends T> doAfterTerminate;
        try {
            Resource call = this.resourceFactory.call();
            DisposeAction disposeAction = new DisposeAction(this.dispose, call);
            subscriber.add(disposeAction);
            try {
                Observable<? extends T> call2 = this.observableFactory.call(call);
                if (this.disposeEagerly) {
                    doAfterTerminate = call2.doOnTerminate(disposeAction);
                } else {
                    doAfterTerminate = call2.doAfterTerminate(disposeAction);
                }
                try {
                    doAfterTerminate.unsafeSubscribe(Subscribers.wrap(subscriber));
                } catch (Throwable th5) {
                    Throwable dispose = dispose(disposeAction);
                    Exceptions.throwIfFatal(th5);
                    Exceptions.throwIfFatal(dispose);
                    if (dispose != null) {
                        subscriber.onError(new CompositeException(th5, dispose));
                    } else {
                        subscriber.onError(th5);
                    }
                }
            } catch (Throwable th6) {
                Throwable dispose2 = dispose(disposeAction);
                Exceptions.throwIfFatal(th6);
                Exceptions.throwIfFatal(dispose2);
                if (dispose2 != null) {
                    subscriber.onError(new CompositeException(th6, dispose2));
                } else {
                    subscriber.onError(th6);
                }
            }
        } catch (Throwable th7) {
            Exceptions.throwOrReport(th7, subscriber);
        }
    }
}
