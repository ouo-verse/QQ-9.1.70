package t74;

import com.tencent.av.opengl.effects.v;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends v {
    @Override // com.tencent.av.opengl.effects.v
    public int[] g() {
        if (((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableGLSurfaceTypeConfigure()) {
            return super.g();
        }
        return new int[]{12351, 12430, 12329, 0, 12352, 4, 12344};
    }

    public void j() {
        super.h();
    }

    public void k() {
        super.i();
    }
}
