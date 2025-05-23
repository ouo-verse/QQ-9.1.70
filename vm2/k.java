package vm2;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.view.video.VideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0005J\u001e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u001b\u0010\u001a\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010!\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001f\u00a8\u0006$"}, d2 = {"Lvm2/k;", "", "", "slopeOrigin", "e", "", "businessType", "", "l", "i", "toggle", "", tl.h.F, "g", "c", "Lcom/tencent/richmediabrowser/view/video/VideoView;", "videoView", "Lcom/tencent/mobileqq/richmediabrowser/presenter/f;", "aioVideoPresenter", "Ljava/lang/Runnable;", "showSubtitleTimeoutRunnable", "j", "", "Ljava/lang/StackTraceElement;", "stackTrace", "", "b", "([Ljava/lang/StackTraceElement;)Ljava/lang/String;", "", "fileSize", "f", "Lcom/tencent/mobileqq/stt/sub/a;", DownloadInfo.spKey_Config, "d", "<init>", "()V", "qq-richmediabrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f441884a = new k();

    k() {
    }

    private final double e(double slopeOrigin) {
        return slopeOrigin / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(com.tencent.mobileqq.richmediabrowser.presenter.f aioVideoPresenter, Runnable showSubtitleTimeoutRunnable) {
        Intrinsics.checkNotNullParameter(aioVideoPresenter, "$aioVideoPresenter");
        Intrinsics.checkNotNullParameter(showSubtitleTimeoutRunnable, "$showSubtitleTimeoutRunnable");
        aioVideoPresenter.g();
        ThreadManager.getUIHandler().removeCallbacks(showSubtitleTimeoutRunnable);
    }

    @NotNull
    public final String b(@NotNull StackTraceElement[] stackTrace) {
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        if (stackTrace.length > 3) {
            String methodName = stackTrace[3].getMethodName();
            Intrinsics.checkNotNullExpressionValue(methodName, "stackTrace[3].methodName");
            return methodName;
        }
        return "";
    }

    public final int c() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeInt(com.tencent.mobileqq.richmediabrowser.h.a().m() + "aio_short_video_click_times", 0);
    }

    public final long d(long fileSize, @NotNull com.tencent.mobileqq.stt.sub.a config) {
        Intrinsics.checkNotNullParameter(config, "config");
        long e16 = config.e();
        if (fileSize > e16) {
            return e16;
        }
        return fileSize;
    }

    public final int f(long fileSize) {
        com.tencent.mobileqq.stt.sub.a config = com.tencent.mobileqq.stt.sub.a.b();
        double c16 = config.c();
        double e16 = e(config.d());
        Intrinsics.checkNotNullExpressionValue(config, "config");
        double d16 = c16 + (e16 * d(fileSize, config));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("aioVideoViewSubtitle, videoTimeout: ");
        int i3 = (int) d16;
        sb5.append(i3);
        QLog.i("VideoSubtitleUtils", 1, sb5.toString());
        return i3;
    }

    public final boolean g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "peak")).isFeatureSwitchEnable("video_subtitle_display_toggle", true);
    }

    public final void h(boolean toggle) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("aio_video_subtitle_switch", toggle);
    }

    public final boolean i(int businessType) {
        if (!l(businessType)) {
            return false;
        }
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("aio_video_subtitle_switch", false);
    }

    public final void j(@NotNull VideoView videoView, @NotNull final com.tencent.mobileqq.richmediabrowser.presenter.f aioVideoPresenter, @NotNull final Runnable showSubtitleTimeoutRunnable) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(aioVideoPresenter, "aioVideoPresenter");
        Intrinsics.checkNotNullParameter(showSubtitleTimeoutRunnable, "showSubtitleTimeoutRunnable");
        videoView.mVideoView.postDelayed(new Runnable() { // from class: vm2.j
            @Override // java.lang.Runnable
            public final void run() {
                k.k(com.tencent.mobileqq.richmediabrowser.presenter.f.this, showSubtitleTimeoutRunnable);
            }
        }, 360L);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("aioVideoViewSubtitle, , stopSubtitleLoadingStatus, ");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "currentThread().stackTrace");
        sb5.append(b(stackTrace));
        QLog.i("VideoSubtitleUtils", 1, sb5.toString());
    }

    public final boolean l(int businessType) {
        if (g() && !RichMediaBrowserUtils.f(businessType)) {
            return true;
        }
        return false;
    }
}
