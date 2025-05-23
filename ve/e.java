package ve;

import com.qzone.reborn.feedx.part.t;
import com.qzone.reborn.part.plusnew.QzoneNewPlusMenuContainerPart;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends b {

    /* renamed from: a, reason: collision with root package name */
    private com.qzone.reborn.part.plus.e f441485a;

    @Override // ve.j
    public List<Part> b(i iVar) {
        ArrayList arrayList = new ArrayList();
        com.qzone.reborn.part.plus.e eVar = new com.qzone.reborn.part.plus.e(iVar.c(), gdt_analysis_event.EVENT_MOTIVE_CLOSE);
        this.f441485a = eVar;
        arrayList.add(eVar);
        arrayList.add(new QzoneNewPlusMenuContainerPart(iVar.c(), gdt_analysis_event.EVENT_MOTIVE_CLOSE));
        arrayList.add(new t());
        arrayList.add(new com.qzone.reborn.feedx.part.a());
        return arrayList;
    }
}
