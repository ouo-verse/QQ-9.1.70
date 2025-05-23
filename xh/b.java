package xh;

import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.tencent.qqnt.kernel.nativeinterface.BatchInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchInfoBanner;
import com.tencent.qqnt.kernel.nativeinterface.Entry;
import com.tencent.qqnt.kernel.nativeinterface.StLBS;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/BatchInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {
    public static final CommonBatchInfo a(BatchInfo batchInfo) {
        Intrinsics.checkNotNullParameter(batchInfo, "<this>");
        CommonBatchInfo commonBatchInfo = new CommonBatchInfo();
        commonBatchInfo.s(batchInfo.linkId);
        String str = batchInfo.desc;
        Intrinsics.checkNotNullExpressionValue(str, "this.desc");
        commonBatchInfo.q(str);
        String str2 = batchInfo.showTime;
        Intrinsics.checkNotNullExpressionValue(str2, "this.showTime");
        commonBatchInfo.w(str2);
        StUser stUser = batchInfo.user;
        Intrinsics.checkNotNullExpressionValue(stUser, "this.user");
        commonBatchInfo.A(i.a(stUser));
        commonBatchInfo.z(batchInfo.uploadNumber);
        StLBS stLBS = batchInfo.lbs;
        Intrinsics.checkNotNullExpressionValue(stLBS, "this.lbs");
        commonBatchInfo.r(g.a(stLBS));
        commonBatchInfo.t(batchInfo.linkType);
        String str3 = batchInfo.subTitle;
        Intrinsics.checkNotNullExpressionValue(str3, "this.subTitle");
        commonBatchInfo.x(str3);
        ArrayList<StMedia> arrayList = batchInfo.medias;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.medias");
        for (StMedia it : arrayList) {
            List<CommonStMedia> j3 = commonBatchInfo.j();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            j3.add(h.b(it));
        }
        commonBatchInfo.v(batchInfo.originUploadNumber);
        ArrayList<Entry> arrayList2 = batchInfo.ext;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "this.ext");
        for (Entry entry : arrayList2) {
            List<CommonEntry> c16 = commonBatchInfo.c();
            CommonEntry commonEntry = new CommonEntry();
            String str4 = entry.key;
            Intrinsics.checkNotNullExpressionValue(str4, "it.key");
            commonEntry.c(str4);
            String str5 = entry.value;
            Intrinsics.checkNotNullExpressionValue(str5, "it.value");
            commonEntry.f(str5);
            commonEntry.e(entry.numberKey);
            c16.add(commonEntry);
        }
        BatchInfoBanner batchInfoBanner = batchInfo.banner;
        Intrinsics.checkNotNullExpressionValue(batchInfoBanner, "this.banner");
        commonBatchInfo.p(fb.a.d(batchInfoBanner));
        return commonBatchInfo;
    }
}
