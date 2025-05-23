package rx.plugins;

import rx.Completable;
import rx.annotations.Experimental;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public abstract class RxJavaCompletableExecutionHook {
    @Deprecated
    public Completable.CompletableOnSubscribe onCreate(Completable.CompletableOnSubscribe completableOnSubscribe) {
        return completableOnSubscribe;
    }

    @Deprecated
    public Completable.CompletableOperator onLift(Completable.CompletableOperator completableOperator) {
        return completableOperator;
    }

    @Deprecated
    public Throwable onSubscribeError(Throwable th5) {
        return th5;
    }

    @Deprecated
    public Completable.CompletableOnSubscribe onSubscribeStart(Completable completable, Completable.CompletableOnSubscribe completableOnSubscribe) {
        return completableOnSubscribe;
    }
}
