package rx.android.plugins;

import androidx.lifecycle.c;
import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Beta;

/* loaded from: classes29.dex */
public final class RxAndroidPlugins {
    private static final RxAndroidPlugins INSTANCE = new RxAndroidPlugins();
    private final AtomicReference<RxAndroidSchedulersHook> schedulersHook = new AtomicReference<>();

    RxAndroidPlugins() {
    }

    public static RxAndroidPlugins getInstance() {
        return INSTANCE;
    }

    public RxAndroidSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            c.a(this.schedulersHook, null, RxAndroidSchedulersHook.getDefaultInstance());
        }
        return this.schedulersHook.get();
    }

    public void registerSchedulersHook(RxAndroidSchedulersHook rxAndroidSchedulersHook) {
        if (c.a(this.schedulersHook, null, rxAndroidSchedulersHook)) {
            return;
        }
        throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
    }

    @Beta
    public void reset() {
        this.schedulersHook.set(null);
    }
}
