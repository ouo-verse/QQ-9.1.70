package te3;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.utils.StackPrinter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lte3/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "width", "height", "", "bSync", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f435891a = new b();

    b() {
    }

    public final void a(Activity activity, int width, int height, boolean bSync) {
        boolean c16 = activity == null ? false : xk3.b.f448110a.c(activity);
        QLog.i("ZPlanEngineServiceHelper_", 1, "resizeBackBuffer isTopEngineAc:" + c16 + ",width:" + width + ", height:" + height + ", activity:" + activity + ", stack:" + new StackPrinter("resizeBackBuffer"));
        if (c16) {
            ZPlanServiceHelper.I.G0(width, height, bSync);
        }
    }
}
