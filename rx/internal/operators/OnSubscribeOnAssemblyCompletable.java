package rx.internal.operators;

import rx.Completable;
import rx.Subscription;
import rx.exceptions.AssemblyStackTraceException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeOnAssemblyCompletable<T> implements Completable.CompletableOnSubscribe {
    public static volatile boolean fullStackTrace;
    final Completable.CompletableOnSubscribe source;
    final String stacktrace = OnSubscribeOnAssembly.createStacktrace();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class OnAssemblyCompletableSubscriber implements Completable.CompletableSubscriber {
        final Completable.CompletableSubscriber actual;
        final String stacktrace;

        public OnAssemblyCompletableSubscriber(Completable.CompletableSubscriber completableSubscriber, String str) {
            this.actual = completableSubscriber;
            this.stacktrace = str;
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onError(Throwable th5) {
            this.actual.onError(new AssemblyStackTraceException(this.stacktrace, th5));
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onSubscribe(Subscription subscription) {
            this.actual.onSubscribe(subscription);
        }
    }

    public OnSubscribeOnAssemblyCompletable(Completable.CompletableOnSubscribe completableOnSubscribe) {
        this.source = completableOnSubscribe;
    }

    @Override // rx.functions.Action1
    public void call(Completable.CompletableSubscriber completableSubscriber) {
        this.source.call(new OnAssemblyCompletableSubscriber(completableSubscriber, this.stacktrace));
    }
}
