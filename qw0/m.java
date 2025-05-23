package qw0;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static IAegisLogApi f430247a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public static int b(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    private static boolean c() {
        if (TextUtils.equals(Build.MANUFACTURER, "OPPO") && Build.VERSION.SDK_INT == 25) {
            f430247a.i("ICGameUIUtil", "is oppo 7.1.1, use post ui task to show toast");
            return true;
        }
        return false;
    }

    public static void e(CharSequence charSequence, boolean z16) {
        f(charSequence, z16, 1);
    }

    public static void f(final CharSequence charSequence, final boolean z16, final int i3) {
        f430247a.i("ICGameUIUtil", "showToast, text=" + ((Object) charSequence) + ",longToast=" + z16 + ",toastType=" + i3);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId() && !c()) {
            g(charSequence, z16, i3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: qw0.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.g(charSequence, z16, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(CharSequence charSequence, boolean z16, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        a.a(BaseApplication.getContext(), 0, charSequence, z16 ? 1 : 0).show();
                        return;
                    } else {
                        a.a(BaseApplication.getContext(), 0, charSequence, z16 ? 1 : 0).show();
                        return;
                    }
                }
                a.a(BaseApplication.getContext(), 2, charSequence, z16 ? 1 : 0).show();
                return;
            }
            a.a(BaseApplication.getContext(), 0, charSequence, z16 ? 1 : 0).show();
            return;
        }
        a.a(BaseApplication.getContext(), 1, charSequence, z16 ? 1 : 0).show();
    }

    public static void h(int i3, boolean z16, int i16) {
        f(BaseApplication.getContext().getText(i3), z16, i16);
    }
}
