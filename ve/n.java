package ve;

import com.qzone.reborn.feedx.part.bb;
import com.qzone.reborn.feedx.part.t;
import com.qzone.reborn.feedx.part.userhome.QZoneUserHomeMemorySealPart;
import com.qzone.reborn.feedx.part.userhome.QZoneUserHomeRedirectFamousPart;
import com.qzone.reborn.part.plusnew.QzoneNewPlusMenuContainerPart;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class n extends c {

    /* renamed from: a, reason: collision with root package name */
    private com.qzone.reborn.part.plus.e f441496a;

    /* renamed from: b, reason: collision with root package name */
    private com.qzone.reborn.part.plus.d f441497b;

    @Override // ve.j
    public List<Part> b(i iVar) {
        ArrayList arrayList = new ArrayList();
        if (com.qzone.reborn.a.f52169a.d("exp_qzone_compactmode_pluspanel", "_B")) {
            com.qzone.reborn.part.plus.d dVar = new com.qzone.reborn.part.plus.d(iVar, gdt_analysis_event.EVENT_MOTIVE_CLOSE);
            this.f441497b = dVar;
            arrayList.add(dVar);
        } else {
            com.qzone.reborn.part.plus.e eVar = new com.qzone.reborn.part.plus.e(iVar.c(), gdt_analysis_event.EVENT_MOTIVE_CLOSE);
            this.f441496a = eVar;
            arrayList.add(eVar);
        }
        arrayList.add(new QzoneNewPlusMenuContainerPart(iVar.c(), gdt_analysis_event.EVENT_MOTIVE_CLOSE));
        arrayList.add(new QZoneUserHomeMemorySealPart());
        arrayList.add(new t());
        arrayList.add(new QZoneUserHomeRedirectFamousPart());
        if (bb.INSTANCE.a()) {
            arrayList.add(new bb());
        }
        arrayList.add(new com.qzone.reborn.feedx.part.a());
        return arrayList;
    }
}
