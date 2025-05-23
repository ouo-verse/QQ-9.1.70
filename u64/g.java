package u64;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.view.View;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J*\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lu64/g;", "", "", "g", "Landroid/view/View;", "view", "Landroid/app/Activity;", "f", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "radius", "Lkotlin/Function1;", "", "callback", "c", "", "b", "J", "mLastClickTime", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f438512a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mLastClickTime;

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Bitmap bitmap, int i3, com.tencent.qqnt.avatar.meta.refresh.c ref) {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(ref, "$ref");
        final Bitmap process = new StackBlurManager(bitmap).process(i3);
        Intrinsics.checkNotNullExpressionValue(process, "blurManager.process(radius)");
        final Function1 function1 = (Function1) ref.get();
        if (function1 != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: u64.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.e(Function1.this, process);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 it, Bitmap blurBitmap) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(blurBitmap, "$blurBitmap");
        it.invoke(blurBitmap);
    }

    public final void c(@NotNull final Bitmap bitmap, final int radius, @NotNull Function1<? super Bitmap, Unit> callback) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (radius <= 0) {
            callback.invoke(bitmap);
        } else {
            final com.tencent.qqnt.avatar.meta.refresh.c cVar = new com.tencent.qqnt.avatar.meta.refresh.c(callback);
            ThreadManagerV2.excute(new Runnable() { // from class: u64.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.d(bitmap, radius, cVar);
                }
            }, 16, null, true);
        }
    }

    @Nullable
    public final Activity f(@Nullable View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public final boolean g() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - mLastClickTime;
        if (1 <= j3 && j3 < 500) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (!QLog.isColorLevel()) {
                return true;
            }
            QLog.i("RobotUIUtils", 2, "time:" + currentTimeMillis + ", mLastClickTIme:" + mLastClickTime + ", timeDiff:" + j3);
            return true;
        }
        mLastClickTime = currentTimeMillis;
        return false;
    }
}
