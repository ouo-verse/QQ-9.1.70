package st0;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h {
    public static String a(String str, Class cls) {
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        String name = cls.getPackage().getName();
        iAegisLogApi.i("ICGamePostProguardPkgNameUtil", str + ": getName name=" + name);
        return name;
    }
}
