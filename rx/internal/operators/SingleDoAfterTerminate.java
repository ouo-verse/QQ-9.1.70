package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SingleDoAfterTerminate<T> implements Single.OnSubscribe<T> {
    final Action0 action;
    final Single<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SingleDoAfterTerminateSubscriber<T> extends SingleSubscriber<T> {
        final Action0 action;
        final SingleSubscriber<? super T> actual;

        public SingleDoAfterTerminateSubscriber(SingleSubscriber<? super T> singleSubscriber, Action0 action0) {
            this.actual = singleSubscriber;
            this.action = action0;
        }

        void doAction() {
            try {
                this.action.call();
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                RxJavaHooks.onError(th5);
            }
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th5) {
            try {
                this.actual.onError(th5);
            } finally {
                doAction();
            }
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t16) {
            try {
                this.actual.onSuccess(t16);
            } finally {
                doAction();
            }
        }
    }

    public SingleDoAfterTerminate(Single<T> single, Action0 action0) {
        this.source = single;
        this.action = action0;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        SingleDoAfterTerminateSubscriber singleDoAfterTerminateSubscriber = new SingleDoAfterTerminateSubscriber(singleSubscriber, this.action);
        singleSubscriber.add(singleDoAfterTerminateSubscriber);
        this.source.subscribe(singleDoAfterTerminateSubscriber);
    }
}
