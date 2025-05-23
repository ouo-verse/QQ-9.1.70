package xz;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\n\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000bH\u0007J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000eH\u0007\u00a8\u0006\u001a"}, d2 = {"Lxz/j;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "videoLayout", "Lcom/tencent/biz/pubaccount/weishi/player/l;", QCircleScheme.AttrDetail.VIDEO_INFO, "", "c", tl.h.F, "", "e", "f", "", "g", "shape", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", NodeProps.VISIBLE, "i", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f449144a = new j();

    j() {
    }

    @JvmStatic
    public static final boolean b(Activity activity) {
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(activity)) {
            x.j("WSVideoFloatingUtils", "[checkFloatingWindowPermission] has permission!");
            return true;
        }
        x.f("WSVideoFloatingUtils", "[checkFloatingWindowPermission] no permission!");
        ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(activity);
        return false;
    }

    @JvmStatic
    public static final void c(Context context, View videoLayout, l videoInfo) {
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).enterFloatingScreen(context, videoLayout, d(e(videoInfo)), 10);
    }

    @JvmStatic
    public static final FloatingScreenParams d(int shape) {
        FloatingScreenParams build = new FloatingScreenParams.FloatingBuilder().setShapeType(shape).setCanZoom(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "FloatingBuilder()\n      \u2026\n                .build()");
        return build;
    }

    @JvmStatic
    public static final int e(l videoInfo) {
        return g(videoInfo) ? 2 : 1;
    }

    @JvmStatic
    public static final int f(l videoInfo) {
        return g(videoInfo) ? 2 : 0;
    }

    @JvmStatic
    public static final void h() {
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen();
    }

    @JvmStatic
    public static final void i(final boolean visible) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: xz.i
            @Override // java.lang.Runnable
            public final void run() {
                j.j(visible);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(boolean z16) {
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), z16, 10);
    }

    @JvmStatic
    public static final boolean g(l videoInfo) {
        if (videoInfo != null) {
            return com.tencent.biz.pubaccount.weishi.player.i.C(videoInfo.f81167b, videoInfo.f81168c);
        }
        return false;
    }
}
