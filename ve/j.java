package ve;

import com.qzone.reborn.feedx.part.QZoneFeedxCommentOperationPart;
import com.qzone.reborn.feedx.part.QZoneFeedxForwardOperationPart;
import com.qzone.reborn.feedx.part.QZoneFeedxInteractOperateDialogPart;
import com.qzone.reborn.feedx.part.aj;
import com.qzone.reborn.feedx.part.aw;
import com.qzone.reborn.feedx.part.ax;
import com.qzone.reborn.feedx.part.bf;
import com.qzone.reborn.feedx.part.bh;
import com.qzone.reborn.feedx.part.r;
import com.qzone.reborn.feedx.part.v;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class j {
    public List<Part> a(i iVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new aj());
        arrayList.add(new bh());
        arrayList.add(new QZoneFeedxCommentOperationPart());
        arrayList.add(new QZoneFeedxForwardOperationPart());
        arrayList.add(new QZoneFeedxInteractOperateDialogPart());
        arrayList.add(new aw());
        arrayList.add(new r());
        arrayList.add(new v(iVar.a()));
        arrayList.add(new bf());
        arrayList.add(new ax());
        return arrayList;
    }

    public abstract List<Part> b(i iVar);

    public List<Part> c(i iVar) {
        ArrayList arrayList = new ArrayList();
        if (iVar == null) {
            return arrayList;
        }
        List<Part> a16 = a(iVar);
        if (a16 != null) {
            arrayList.addAll(a16);
        }
        List<Part> b16 = b(iVar);
        if (b16 != null) {
            arrayList.addAll(b16);
        }
        return arrayList;
    }
}
