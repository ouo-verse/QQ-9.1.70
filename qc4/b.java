package qc4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lqc4/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "cancelable", "Landroid/app/Dialog;", "c", "Landroid/content/Context;", "context", "Landroid/view/View;", "contentView", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f428851a = new b();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Dialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.setCancelable(true);
    }

    public final Dialog b(Context context, View contentView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Dialog dialog = new Dialog(context, R.style.f243290e);
        dialog.setContentView(contentView);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        if (window != null) {
            window.setWindowAnimations(R.style.f243280d);
        }
        if (window != null) {
            window.setLayout(-1, -2);
        }
        return dialog;
    }

    public final Dialog c(Activity activity, boolean cancelable) {
        if (activity == null) {
            return null;
        }
        final Dialog dialog = new Dialog(activity, R.style.qZoneInputDialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.f167676dz);
        View findViewById = dialog.findViewById(R.id.jg_);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (cancelable) {
            dialog.setCancelable(true);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: qc4.a
            @Override // java.lang.Runnable
            public final void run() {
                b.e(dialog);
            }
        }, 5000L);
        return dialog;
    }

    public static /* synthetic */ Dialog d(b bVar, Activity activity, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return bVar.c(activity, z16);
    }
}
