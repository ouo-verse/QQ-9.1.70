package q32;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lq32/f;", "", "", "g", h.F, "Lcom/tencent/icgame/common/api/IAegisLogApi;", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "logger", "", "b", "Z", "isStopped", "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "preloadMiniAppTask", "Landroid/os/MessageQueue$IdleHandler;", "d", "Landroid/os/MessageQueue$IdleHandler;", "idleHandler", "<init>", "()V", "e", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a f428301e = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi logger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isStopped;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable preloadMiniAppTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MessageQueue.IdleHandler idleHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lq32/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public f() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.logger = (IAegisLogApi) api;
        this.preloadMiniAppTask = new Runnable() { // from class: q32.c
            @Override // java.lang.Runnable
            public final void run() {
                f.e(f.this);
            }
        };
        this.idleHandler = new MessageQueue.IdleHandler() { // from class: q32.d
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean d16;
                d16 = f.d(f.this);
                return d16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ThreadManagerV2.excute(this$0.preloadMiniAppTask, 16, null, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStopped) {
            return;
        }
        boolean isSwitchOn = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).isSwitchOn(ICGameQMCCConfigKeysKt.KEY_ICGAME_ENABLE_LANDING_PAGE_MINI_APP_PRELOAD, false);
        this$0.logger.i("MiniAppPreLoader", "preloadMiniApp preload open " + isSwitchOn);
        if (!isSwitchOn) {
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).preDownloadPkg("1112222915", "release", new IMiniCallback() { // from class: q32.e
            @Override // com.tencent.mobileqq.mini.api.IMiniCallback
            public final void onCallbackResult(boolean z16, Bundle bundle) {
                f.f(f.this, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(f this$0, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.logger.i("MiniAppPreLoader", "preDownload done,success:" + z16 + ",retCode:" + bundle.get("retCode") + ",retMsg:" + bundle.get("errMsg"));
    }

    public final void g() {
        this.isStopped = false;
        Looper.myQueue().addIdleHandler(this.idleHandler);
    }

    public final void h() {
        this.isStopped = true;
        Looper.myQueue().removeIdleHandler(this.idleHandler);
        ThreadManagerV2.removeJob(this.preloadMiniAppTask, 16);
    }
}
