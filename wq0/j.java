package wq0;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lwq0/j;", "", "", "e", "Landroid/content/Context;", "context", "isPreCreate", "gestureEnabled", "Lwq0/l;", "b", "d", "f", "Lcom/tencent/aio/widget/textView/param/b;", "param", "Landroid/text/Layout;", TtmlNode.TAG_LAYOUT, "", "a", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "DEVICE_MODEL", "c", "Z", "justifySwitchOn", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f446044a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String DEVICE_MODEL = DeviceInfoMonitor.getModel();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final boolean justifySwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_justify_textView_9020_115882830", true);

    j() {
    }

    public static /* synthetic */ l c(j jVar, Context context, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return jVar.b(context, z16, z17);
    }

    private final boolean e() {
        if (Build.VERSION.SDK_INT > 28) {
            return true;
        }
        return false;
    }

    public final void a(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull Layout layout) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(layout, "layout");
        d.INSTANCE.a(param, layout);
    }

    @NotNull
    public final l b(@NotNull Context context, boolean isPreCreate, boolean gestureEnabled) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f()) {
            return new d(context, isPreCreate);
        }
        return new k(context, gestureEnabled);
    }

    @NotNull
    public final l d(@NotNull Context context, boolean isPreCreate) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (justifySwitchOn) {
            return new h(context);
        }
        if (f()) {
            return new d(context, isPreCreate);
        }
        return new k(context, false, 2, null);
    }

    public final boolean f() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026ava, ProcessConstant.ALL)");
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("guild_text_to_static_switch", false);
        boolean e16 = e();
        if (QLog.isDebugVersion()) {
            QLog.i("GuildTextUtils", 2, "TEXT_TO_STATIC_SWITCH. enabled: " + isFeatureSwitchEnable + ", " + e16);
        }
        if (!isFeatureSwitchEnable || !e16) {
            return false;
        }
        return true;
    }
}
