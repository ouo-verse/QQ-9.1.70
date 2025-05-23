package xh;

import com.qzone.reborn.albumx.common.convert.bean.CommonStLBS;
import com.tencent.qqnt.kernel.nativeinterface.StGPS;
import com.tencent.qqnt.kernel.nativeinterface.StLBS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/StLBS;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "a", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {
    public static final CommonStLBS a(StLBS stLBS) {
        Intrinsics.checkNotNullParameter(stLBS, "<this>");
        CommonStLBS commonStLBS = new CommonStLBS();
        StGPS stGPS = stLBS.gps;
        Intrinsics.checkNotNullExpressionValue(stGPS, "this.gps");
        commonStLBS.g(f.a(stGPS));
        String str = stLBS.location;
        Intrinsics.checkNotNullExpressionValue(str, "this.location");
        commonStLBS.k(str);
        String str2 = stLBS.address;
        Intrinsics.checkNotNullExpressionValue(str2, "this.address");
        commonStLBS.f(str2);
        String str3 = stLBS.lbsId;
        Intrinsics.checkNotNullExpressionValue(str3, "this.lbsId");
        commonStLBS.j(str3);
        return commonStLBS;
    }

    public static final StLBS b(CommonStLBS commonStLBS) {
        Intrinsics.checkNotNullParameter(commonStLBS, "<this>");
        StLBS stLBS = new StLBS();
        stLBS.gps = f.b(commonStLBS.getGps());
        stLBS.location = commonStLBS.getLocation();
        stLBS.address = commonStLBS.getAddress();
        stLBS.lbsId = commonStLBS.getLbsId();
        return stLBS;
    }
}
