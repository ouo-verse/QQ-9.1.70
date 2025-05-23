package vc3;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lvc3/c;", "", "", "isPortrait", "Landroid/view/View;", "textureView", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f441386a = new c();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View view, boolean z16) {
        int width = view.getWidth();
        int height = view.getHeight();
        QLog.i("ZootopiaEngineScreenUtils", 1, "mTextureView: width= " + width + ", height=" + height);
        ZPlanServiceHelper.I.T0(z16, width, height);
    }

    public final void b(final boolean isPortrait, final View textureView) {
        ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
        boolean n06 = zPlanServiceHelper.n0();
        QLog.i("ZootopiaEngineScreenUtils", 1, "isPortrait=" + isPortrait + ", engineOrientation=" + n06);
        if (textureView != null) {
            textureView.post(new Runnable() { // from class: vc3.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.c(textureView, isPortrait);
                }
            });
        } else if (isPortrait != n06) {
            zPlanServiceHelper.S0(isPortrait);
        }
    }
}
