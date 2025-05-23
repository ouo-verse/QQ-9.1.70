package yl0;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.gdt.tangram.ad.AdArea;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g {
    public static e a(BusinessFeedData businessFeedData, AdArea adArea, boolean z16, String str, boolean z17) {
        com.tencent.gdt.tangram.ad.qzone.b bVar = new com.tencent.gdt.tangram.ad.qzone.b(businessFeedData);
        e eVar = new e();
        eVar.f(bVar.f());
        eVar.e(bVar.e());
        eVar.j(z16);
        if (!TextUtils.isEmpty(str)) {
            eVar.l(str);
        }
        eVar.b(adArea);
        if (businessFeedData != null && businessFeedData.getOperationInfoV2() != null && z17) {
            eVar.k(businessFeedData.getOperationInfoV2().hasReportExposure > 0);
        }
        return eVar;
    }
}
