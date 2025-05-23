package rx.plugins;

/* compiled from: P */
/* loaded from: classes29.dex */
final class RxJavaSingleExecutionHookDefault extends RxJavaSingleExecutionHook {
    private static final RxJavaSingleExecutionHookDefault INSTANCE = new RxJavaSingleExecutionHookDefault();

    RxJavaSingleExecutionHookDefault() {
    }

    public static RxJavaSingleExecutionHook getInstance() {
        return INSTANCE;
    }
}
