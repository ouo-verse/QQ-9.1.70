package tm;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.business.service.media.c;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.qzone.media.QZoneMediaBusiness;
import ho.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends b implements ho.a {
    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (context == null) {
            QLog.e("QZoneOpenPublishSchemaLauncher", 1, "[parseScheme] context is null");
            return false;
        }
        if (qZoneSchemeBean == null) {
            QLog.e("QZoneOpenPublishSchemaLauncher", 1, "parseScheme  schemeBean == null");
            return false;
        }
        if (qZoneSchemeBean.getAttrs() == null) {
            QLog.e("QZoneOpenPublishSchemaLauncher", 1, "[parseScheme] schemeBean.getAttrs() is null");
            return false;
        }
        if (TextUtils.isEmpty(qZoneSchemeBean.getPageAction())) {
            QLog.e("QZoneOpenPublishSchemaLauncher", 1, "parseScheme  scheme pageAction == null");
            return false;
        }
        QLog.e("QZoneOpenPublishSchemaLauncher", 1, "launch  scheme");
        c cVar = new c(QZoneMediaBusiness.QZONE_SHUOSHUO_UPLOAD_PIC);
        Bundle bundle = new Bundle();
        cVar.f45832e = bundle;
        com.qzone.common.business.service.b.f().h().v(cVar);
        String str = qZoneSchemeBean.getAttrs().get("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        if (str != null && !str.isEmpty()) {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
        } else {
            bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        }
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkBySchema(context, QCircleScheme.Q_CIRCLE_ACTION_OPEN_QQPUBLISH, qZoneSchemeBean.getAttrs(), bundle);
        return true;
    }
}
