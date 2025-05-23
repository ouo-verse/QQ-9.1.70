package xh;

import com.qzone.reborn.albumx.common.convert.bean.CommonStGPS;
import com.tencent.qqnt.kernel.nativeinterface.StGPS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/StGPS;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStGPS;", "a", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f {
    public static final CommonStGPS a(StGPS stGPS) {
        Intrinsics.checkNotNullParameter(stGPS, "<this>");
        CommonStGPS commonStGPS = new CommonStGPS();
        commonStGPS.j(stGPS.lat);
        commonStGPS.k(stGPS.lon);
        commonStGPS.g(stGPS.eType);
        commonStGPS.f(stGPS.alt);
        return commonStGPS;
    }

    public static final StGPS b(CommonStGPS commonStGPS) {
        Intrinsics.checkNotNullParameter(commonStGPS, "<this>");
        StGPS stGPS = new StGPS();
        stGPS.lat = commonStGPS.getCom.tencent.biz.qqcircle.QCircleSchemeAttr.Polymerize.LAT java.lang.String();
        stGPS.lon = commonStGPS.getLon();
        stGPS.eType = commonStGPS.getEType();
        stGPS.alt = commonStGPS.getAlt();
        return stGPS;
    }
}
