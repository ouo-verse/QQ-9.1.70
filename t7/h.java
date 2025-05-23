package t7;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import t7.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J0\u0010\u0011\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0015"}, d2 = {"Lt7/h;", "", "Landroid/view/View;", "view", "", "bitmapWidth", "bitmapHeight", "Landroid/graphics/Bitmap;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "c", "Lt7/h$a;", "listener", "", "e", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f435520a = new h();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lt7/h$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "filePath", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public interface a {
        void a(Bitmap bitmap, String filePath);
    }

    h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String c(Activity activity, Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        AssetFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = 0;
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null && activity != null) {
            long currentTimeMillis = System.currentTimeMillis();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str = "temp_intimate_share_" + currentTimeMillis + (peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null) + ".jpg";
            File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "intimate").getAbsolutePath()));
            file.mkdirs();
            if (file.canWrite()) {
                File file2 = new File(file.getAbsolutePath(), str);
                String absolutePath = file2.getAbsolutePath();
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    } catch (Exception e16) {
                        e = e16;
                        bufferedOutputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (autoCloseOutputStream != 0) {
                        }
                        throw th;
                    }
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                        bufferedOutputStream.flush();
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e17) {
                            QLog.e("QZNTArkUploadUtil", 1, e17.getMessage());
                        }
                        return absolutePath;
                    } catch (Exception e18) {
                        e = e18;
                        QLog.e("QZNTArkUploadUtil", 1, e.getMessage());
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Exception e19) {
                                QLog.e("QZNTArkUploadUtil", 1, e19.getMessage());
                            }
                        }
                        return null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    autoCloseOutputStream = "intimate";
                    if (autoCloseOutputStream != 0) {
                        try {
                            autoCloseOutputStream.close();
                        } catch (Exception e26) {
                            QLog.e("QZNTArkUploadUtil", 1, e26.getMessage());
                        }
                    }
                    throw th;
                }
            }
        }
        return null;
    }

    private final Bitmap d(View view, float bitmapWidth, float bitmapHeight) {
        int dpToPx = ImmersiveUtils.dpToPx(bitmapWidth);
        int dpToPx2 = ImmersiveUtils.dpToPx(bitmapHeight);
        UIUtil uIUtil = UIUtil.f112434a;
        view.measure(View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, bitmapWidth, uIUtil.x().getDisplayMetrics()), 1073741824), View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, bitmapHeight, uIUtil.x().getDisplayMetrics()), 1073741824));
        view.layout(0, 0, dpToPx, dpToPx2);
        Bitmap bitmap = Bitmap.createBitmap(dpToPx, dpToPx2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0);
        view.draw(canvas);
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Activity activity, final Bitmap bitmap, final a listener) {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        final String c16 = f435520a.c(activity, bitmap);
        if (TextUtils.isEmpty(c16)) {
            QLog.e("QZNTArkUploadUtil", 1, "filePath is null");
        } else {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: t7.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.g(h.a.this, bitmap, c16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(a listener, Bitmap bitmap, String str) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        listener.a(bitmap, str);
    }

    public final void e(final Activity activity, View view, float bitmapWidth, float bitmapHeight, final a listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final Bitmap d16 = d(view, bitmapWidth, bitmapHeight);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: t7.f
            @Override // java.lang.Runnable
            public final void run() {
                h.f(activity, d16, listener);
            }
        });
    }
}
