package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.AssemblyStackTraceException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeOnAssemblySingle<T> implements Single.OnSubscribe<T> {
    public static volatile boolean fullStackTrace;
    final Single.OnSubscribe<T> source;
    final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class OnAssemblySingleSubscriber<T> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final String stacktrace;

        public OnAssemblySingleSubscriber(SingleSubscriber<? super T> singleSubscriber, String str) {
            this.actual = singleSubscriber;
            this.stacktrace = str;
            singleSubscriber.add(this);
        }

        @Override // rx.SingleSubscriber
        public void onError(Throwable th5) {
            this.actual.onError(new AssemblyStackTraceException(this.stacktrace, th5));
        }

        @Override // rx.SingleSubscriber
        public void onSuccess(T t16) {
            this.actual.onSuccess(t16);
        }
    }

    public OnSubscribeOnAssemblySingle(Single.OnSubscribe<T> onSubscribe) {
        this.source = onSubscribe;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        this.source.call(new OnAssemblySingleSubscriber(singleSubscriber, this.stacktrace));
    }
}
