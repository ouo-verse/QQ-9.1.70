package rb4;

import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import com.tencent.sqshow.zootopia.samestyle.ZPlanVideoClipInfo;
import com.tencent.sqshow.zootopia.samestyle.ZplanEntranceInfo;
import com.tencent.sqshow.zootopia.samestyle.data.MaterialWrapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import nv4.m;
import nv4.o;
import pu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u00a8\u0006\u0006"}, d2 = {"Lnv4/m;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "a", "Lnv4/o;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoClipInfo;", "b", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final ZPlanVideoClipInfo b(o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        String coverUrl = oVar.f421441a;
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        return new ZPlanVideoClipInfo(coverUrl, oVar.f421442b, oVar.f421443c);
    }

    public static final ZPlanTemplate a(m mVar) {
        List list;
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        o[] vedioClipList = mVar.f421426k;
        Intrinsics.checkNotNullExpressionValue(vedioClipList, "vedioClipList");
        ArrayList arrayList = new ArrayList(vedioClipList.length);
        for (o videoClipInfo : vedioClipList) {
            Intrinsics.checkNotNullExpressionValue(videoClipInfo, "videoClipInfo");
            arrayList.add(b(videoClipInfo));
        }
        nv4.a aVar = mVar.f421434s;
        ZplanEntranceInfo zplanEntranceInfo = null;
        if ((aVar != null ? aVar.f421388d : null) != null) {
            MaterialWrapper.Companion companion = MaterialWrapper.INSTANCE;
            g gVar = aVar.f421388d;
            Intrinsics.checkNotNullExpressionValue(gVar, "arSdk.iconMaterial");
            MaterialWrapper b16 = companion.b(gVar);
            nv4.a aVar2 = mVar.f421434s;
            zplanEntranceInfo = new ZplanEntranceInfo(b16, aVar2.f421385a, aVar2.f421386b, aVar2.f421387c);
        }
        ZplanEntranceInfo zplanEntranceInfo2 = zplanEntranceInfo;
        int i3 = mVar.f421416a;
        String templateResourceName = mVar.f421417b;
        String templateDisplayName = mVar.f421427l;
        String desc = mVar.f421424i;
        int i16 = mVar.f421420e;
        boolean z16 = mVar.f421422g;
        long j3 = mVar.f421425j;
        String coverUrl = mVar.f421423h;
        String previewUrl = mVar.f421421f;
        String resourceUrl = mVar.f421418c;
        long j16 = mVar.f421429n;
        int[] playerGender = mVar.f421430o;
        Intrinsics.checkNotNullExpressionValue(playerGender, "playerGender");
        list = ArraysKt___ArraysKt.toList(playerGender);
        boolean z17 = mVar.f421431p;
        String circleTemplateId = mVar.f421432q;
        boolean z18 = mVar.f421435t;
        Intrinsics.checkNotNullExpressionValue(templateResourceName, "templateResourceName");
        Intrinsics.checkNotNullExpressionValue(templateDisplayName, "templateDisplayName");
        Intrinsics.checkNotNullExpressionValue(desc, "desc");
        Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
        Intrinsics.checkNotNullExpressionValue(previewUrl, "previewUrl");
        Intrinsics.checkNotNullExpressionValue(resourceUrl, "resourceUrl");
        Intrinsics.checkNotNullExpressionValue(circleTemplateId, "circleTemplateId");
        return new ZPlanTemplate(i3, templateResourceName, templateDisplayName, desc, coverUrl, i16, z16, j3, previewUrl, resourceUrl, arrayList, j16, list, z17, circleTemplateId, zplanEntranceInfo2, z18);
    }
}
