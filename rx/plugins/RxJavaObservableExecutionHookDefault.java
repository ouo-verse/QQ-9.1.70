package rx.plugins;

/* compiled from: P */
/* loaded from: classes29.dex */
final class RxJavaObservableExecutionHookDefault extends RxJavaObservableExecutionHook {
    private static final RxJavaObservableExecutionHookDefault INSTANCE = new RxJavaObservableExecutionHookDefault();

    RxJavaObservableExecutionHookDefault() {
    }

    public static RxJavaObservableExecutionHook getInstance() {
        return INSTANCE;
    }
}
