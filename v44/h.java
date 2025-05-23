package v44;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.mainframe.api.IGuildJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lv44/h;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "radius", "a", "Lv44/g;", "shareActionSheet", "", "b", "Landroid/app/Activity;", "curActivity", "preView", "c", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f440969a = new h();

    h() {
    }

    @JvmStatic
    @NotNull
    public static final Bitmap a(@NotNull Bitmap bitmap, float radius) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        canvas.drawRoundRect(rectF, radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        Intrinsics.checkNotNullExpressionValue(output, "output");
        return output;
    }

    private final void b(g shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(26);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026etItem.ACTION_SEND_TO_PC)");
        arrayList.add(build);
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build2);
        if (((IGuildJumpApi) QRoute.api(IGuildJumpApi.class)).isGuildUser()) {
            ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(171);
            Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026m.ACTION_SEND_TO_CHANNEL)");
            arrayList.add(build3);
        }
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build4);
        if (QLog.isColorLevel()) {
            QLog.d("robot.qr.ShareActionUtilForMyCard", 2, " showMyQrCodeActionSheet()");
        }
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
        arrayList.add(build5);
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
        arrayList.add(build6);
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build7 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build7, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build7);
        ShareActionSheetBuilder.ActionSheetItem build8 = ShareActionSheetBuilder.ActionSheetItem.build(1);
        Intrinsics.checkNotNullExpressionValue(build8, "build(ShareActionSheetBu\u2026heetItem.ACTION_COPYLINK)");
        arrayList2.add(build8);
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
    }

    @NotNull
    public final g c(@NotNull Activity curActivity, @NotNull Bitmap preView) {
        Intrinsics.checkNotNullParameter(curActivity, "curActivity");
        Intrinsics.checkNotNullParameter(preView, "preView");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        curActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
        param.canceledOnTouchOutside = true;
        param.context = curActivity;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        g gVar = new g(16.0f, 16.0f, 16.0f, param);
        gVar.s0(preView);
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        gVar.setIntentForStartForwardRecentActivity(intent);
        gVar.setRowVisibility(8, 0, 0);
        b(gVar);
        return gVar;
    }
}
