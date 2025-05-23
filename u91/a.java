package u91;

import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends com.tencent.mobileqq.auto.engine.enter.a {
    public a(ASPluginBean aSPluginBean) {
        super(aSPluginBean);
    }

    @Override // s91.a
    public void a(ASEnterBean aSEnterBean) {
        if (aSEnterBean != null && aSEnterBean.getAttrs() != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", aSEnterBean);
            QCircleReportFirstLogin.recordFirstLoginSource(aSEnterBean.getAttrs());
            ((IQCircleNativeFrameApi) QRoute.api(IQCircleNativeFrameApi.class)).enterNativePage(bundle);
        }
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a, s91.a
    public void b(ASEnterBean aSEnterBean) {
        QCircleReportFirstLogin.recordFirstLoginSource(aSEnterBean.getAttrs());
        super.b(aSEnterBean);
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a
    protected String e(String str, HashMap<String, String> hashMap) {
        StringBuilder sb5 = new StringBuilder(QCircleScheme.Q_CIRCLE_SCHEME_PREFIX + str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (hashMap != null) {
            for (String str2 : hashMap.keySet()) {
                String str3 = hashMap.get(str2);
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(str3);
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.auto.engine.enter.a
    protected String f() {
        return "com.tencent.biz.qcircleshadow.local.fragment.qcircle.QCirclePluginLoadingFragment";
    }
}
