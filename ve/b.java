package ve;

import com.qzone.reborn.feedx.part.bg;
import com.qzone.reborn.feedx.part.cb;
import com.qzone.reborn.feedx.part.cc;
import com.qzone.reborn.feedx.part.ce;
import com.qzone.reborn.feedx.part.cf;
import com.qzone.reborn.feedx.part.p;
import com.qzone.reborn.feedx.part.userhome.QZoneFamousUserHomeTitlePart;
import com.qzone.reborn.feedx.part.userhome.o;
import com.qzone.reborn.feedx.part.userhome.t;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class b extends j {
    @Override // ve.j
    public List<Part> a(i iVar) {
        ArrayList arrayList = new ArrayList(super.a(iVar));
        arrayList.add(new p());
        arrayList.add(new t());
        arrayList.add(new QZoneFamousUserHomeTitlePart());
        arrayList.add(new o());
        arrayList.add(new com.qzone.reborn.feedx.part.userhome.e());
        arrayList.add(new bg());
        arrayList.add(new ce());
        arrayList.add(new cf());
        arrayList.add(new cb());
        arrayList.add(new cc("page_launch_user_home"));
        arrayList.add(new com.qzone.reborn.feedx.part.userhome.i());
        return arrayList;
    }
}
