package tz0;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f437927a;

    /* renamed from: b, reason: collision with root package name */
    public static Executor f437928b = new ExecutorC11314a();

    /* compiled from: P */
    /* renamed from: tz0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class ExecutorC11314a implements Executor {
        ExecutorC11314a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public static final Context a() {
        return f437927a;
    }

    public static final void b(Context context) {
        c(context);
    }

    public static final void c(Context context) {
        f437927a = context;
    }
}
