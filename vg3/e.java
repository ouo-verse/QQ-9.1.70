package vg3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleBubbleConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J8\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u00a8\u0006\u0018"}, d2 = {"Lvg3/e;", "", "Lcom/tencent/image/URLDrawable;", "d", "", "c", "Landroid/widget/FrameLayout;", "containerLayout", "Landroid/view/View;", "switchAnchorView", "", "e", "Lcom/tencent/common/app/AppInterface;", "app", "friendUin", "", "a", "Landroid/content/Context;", "context", "anchorView", "Landroid/widget/ImageView;", "b", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f441630a = new e();

    e() {
    }

    private final boolean a(AppInterface app, String friendUin) {
        if (app == null) {
            QLog.e("ZPlanCoupleSettingBubblePlayHelper", 1, "checkNeedShowZPlanSettingBubble false, app invalid.");
            return false;
        }
        if (!((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature()) {
            QLog.i("ZPlanCoupleSettingBubblePlayHelper", 1, "checkNeedShowZPlanSettingBubble false, not in white list.");
            return false;
        }
        if (((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(friendUin)) {
            QLog.i("ZPlanCoupleSettingBubblePlayHelper", 1, "checkNeedShowZPlanSettingBubble false, coupleSceneSwitch on.");
            return false;
        }
        String selfUin = app.getCurrentUin();
        IZPlanCoupleSceneHelper iZPlanCoupleSceneHelper = (IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class);
        Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
        if (!iZPlanCoupleSceneHelper.getSettingBubbleShownMark(selfUin)) {
            return true;
        }
        QLog.i("ZPlanCoupleSettingBubblePlayHelper", 1, "checkNeedShowZPlanSettingBubble false, hasAlreadyShown.");
        return false;
    }

    private final String c() {
        List<ZPlanCoupleBubbleConfig> zPlanSettingBubbles = ((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getZPlanSettingBubbles();
        if (!zPlanSettingBubbles.isEmpty() && zPlanSettingBubbles.get(0) != null) {
            ZPlanCoupleBubbleConfig zPlanCoupleBubbleConfig = zPlanSettingBubbles.get(0);
            if (zPlanCoupleBubbleConfig == null) {
                return null;
            }
            return zPlanCoupleBubbleConfig.getPicUrl();
        }
        QLog.e("ZPlanCoupleSettingBubblePlayHelper", 1, "getBubbleURLFromConfig failed, bubble config invalid.");
        return null;
    }

    private final URLDrawable d() {
        String c16 = c();
        if (TextUtils.isEmpty(c16)) {
            QLog.e("ZPlanCoupleSettingBubblePlayHelper", 1, "addZPlanSettingBubbleIfNeed failed, url in bubble config invalid.");
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        return URLDrawable.getDrawable(c16, obtain);
    }

    private final int e(FrameLayout containerLayout, View switchAnchorView) {
        int[] iArr = new int[2];
        switchAnchorView.getLocationInWindow(iArr);
        QLog.i("ZPlanCoupleSettingBubblePlayHelper", 1, "switchLocation, x: " + iArr[0] + ", y: " + iArr[1]);
        int[] iArr2 = new int[2];
        containerLayout.getLocationInWindow(iArr2);
        return ((iArr[1] - ViewUtils.dpToPx(79.0f)) - iArr2[1]) + ViewUtils.dip2px(5.0f);
    }

    @Nullable
    public final ImageView b(@Nullable AppInterface app, @Nullable Context context, @NotNull String friendUin, @Nullable FrameLayout containerLayout, @Nullable View anchorView) {
        int e16;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (context != null && containerLayout != null && anchorView != null) {
            boolean a16 = a(app, friendUin);
            if (!a16) {
                return null;
            }
            QLog.i("ZPlanCoupleSettingBubblePlayHelper", 1, "anchorView width: " + anchorView.getWidth() + ", viewHeight: " + anchorView.getHeight() + ", needShow: " + a16);
            URLDrawable d16 = d();
            if (d16 == null || (e16 = e(containerLayout, anchorView)) <= 0) {
                return null;
            }
            ImageView imageView = new ImageView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(255.0f), ViewUtils.dpToPx(79.0f));
            layoutParams.gravity = 5;
            layoutParams.rightMargin = 0;
            layoutParams.topMargin = e16;
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageDrawable(d16);
            return imageView;
        }
        QLog.e("ZPlanCoupleSettingBubblePlayHelper", 1, "createSettingBubbleIfNeed failed, containerLayout or anchorView invalid.");
        return null;
    }
}
