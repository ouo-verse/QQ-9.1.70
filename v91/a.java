package v91;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.main.IASFragment;
import com.tencent.mobileqq.auto.engine.main.b;
import com.tencent.mobileqq.auto.engine.main.fragment.c;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends b {
    @Override // com.tencent.mobileqq.auto.engine.main.b
    public IASFragment a(View view, ASEnterBean aSEnterBean) {
        Activity activity;
        if (view != null && (view.getContext() instanceof Activity)) {
            activity = (Activity) view.getContext();
        } else {
            activity = null;
        }
        return c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).l(activity, (ViewGroup) view, aSEnterBean);
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void c(boolean z16) {
        c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).c(z16);
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public boolean d() {
        return c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).d();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void e() {
        c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).e();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void f() {
        c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).f();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void g() {
        super.g();
        c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).g();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void h() {
        super.h();
        c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).h();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void i() {
        c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).i();
    }

    @Override // com.tencent.mobileqq.auto.engine.main.b
    public void j(Activity activity) {
        c.k(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).j(activity);
    }
}
