package ve;

import com.qzone.reborn.feedx.block.r;
import com.qzone.reborn.feedx.part.ch;
import com.qzone.reborn.feedx.part.cn;
import com.qzone.reborn.feedx.part.cp;
import com.qzone.reborn.feedx.part.o;
import com.qzone.reborn.feedx.part.userhome.QZoneUserHomeRedirectFamousPart;
import com.qzone.reborn.feedx.part.userhome.p;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class m extends c {
    @Override // ve.j
    public List<Part> b(i iVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new p());
        arrayList.add(new cp());
        arrayList.add(new ch());
        arrayList.add(new r());
        arrayList.add(new cn());
        arrayList.add(new o());
        arrayList.add(new com.qzone.reborn.feedx.part.userhome.j());
        arrayList.add(new QZoneUserHomeRedirectFamousPart());
        return arrayList;
    }
}
