package z40;

import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.immersive.layer.base.b {
    @Override // com.tencent.biz.qqcircle.immersive.layer.base.b
    protected List<Part> g(com.tencent.biz.qqcircle.immersive.layer.base.a aVar) {
        if (!(aVar instanceof com.tencent.biz.qqcircle.immersive.layer.biz.a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b(((com.tencent.biz.qqcircle.immersive.layer.biz.a) aVar).b()));
        return arrayList;
    }
}
