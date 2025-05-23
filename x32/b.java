package x32;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.common.ratelimit.RateLimitConfig;
import com.tencent.icgame.common.ratelimit.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lx32/b;", "", "", "rateKey", "", "starTime", "Lcom/tencent/icgame/common/ratelimit/a;", "callback", "", "d", "step", "e", "b", "Lcom/tencent/icgame/common/ratelimit/c;", "a", "Lcom/tencent/icgame/common/ratelimit/c;", "getConfig", "()Lcom/tencent/icgame/common/ratelimit/c;", DownloadInfo.spKey_Config, "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Lcom/tencent/icgame/common/ratelimit/d;", "c", "Lcom/tencent/icgame/common/ratelimit/d;", "mRateLimitController", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "<init>", "(Lcom/tencent/icgame/common/ratelimit/c;)V", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RateLimitConfig config;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mRateLimitController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    public b(@NotNull RateLimitConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.mRateLimitController = new d(config);
        this.mHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, String rateKey, long j3, com.tencent.icgame.common.ratelimit.a callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rateKey, "$rateKey");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.e(rateKey, "changeThreadContext", j3);
        this$0.d(rateKey, SystemClock.elapsedRealtime(), callback);
    }

    private final void d(String rateKey, long starTime, com.tencent.icgame.common.ratelimit.a callback) {
        long elapsedRealtime;
        boolean a16;
        synchronized (this.mRateLimitController) {
            e(rateKey, "waitLock", starTime);
            elapsedRealtime = SystemClock.elapsedRealtime();
            a16 = this.mRateLimitController.a(rateKey);
            Unit unit = Unit.INSTANCE;
        }
        e(rateKey, "checkAndLimitRate", elapsedRealtime);
        callback.a(Boolean.valueOf(a16));
    }

    private final void e(String rateKey, String step, long starTime) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - starTime;
        if (elapsedRealtime > this.config.getMaxCheckInterval()) {
            this.mAegisLog.a("ICGameSsoRateLimitController", rateKey + " " + step + " \u65f6\u95f4\u8fc7\u957f\u544a\u8b66\uff0cgap=" + elapsedRealtime);
        }
    }

    public final void b(@NotNull final String rateKey, @NotNull final com.tencent.icgame.common.ratelimit.a callback) {
        Intrinsics.checkNotNullParameter(rateKey, "rateKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            this.mHandler.post(new Runnable() { // from class: x32.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(b.this, rateKey, elapsedRealtime, callback);
                }
            });
        } else {
            d(rateKey, elapsedRealtime, callback);
        }
    }
}
