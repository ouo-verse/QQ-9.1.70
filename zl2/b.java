package zl2;

import com.tencent.mobileqq.qzoneplayer.player.CachedMediaPlayer;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.k;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f452750a;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface a {
        void a(CachedMediaPlayer cachedMediaPlayer);
    }

    public static boolean b() {
        return f452750a;
    }

    public static void d(boolean z16) {
        f452750a = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc == null) {
            return;
        }
        feedVideoExternalFunc.initVideoSdk(kVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() {
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
        if (feedVideoExternalFunc == null) {
            return false;
        }
        if (feedVideoExternalFunc.isDebugVersion()) {
            return FeedVideoEnv.externalFunc.isSuperPlayerEnabled() && !FeedVideoEnv.externalFunc.isForceDisableSuperPlayer();
        }
        return FeedVideoEnv.externalFunc.isSuperPlayerEnabled();
    }
}
