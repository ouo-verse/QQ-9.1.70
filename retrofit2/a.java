package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes29.dex */
final class a implements Executor {

    /* renamed from: d, reason: collision with root package name */
    private final Handler f431191d = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f431191d.post(runnable);
    }
}
