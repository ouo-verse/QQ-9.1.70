package wc;

import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.part.ah;
import com.qzone.reborn.comment.part.ai;
import com.qzone.reborn.comment.part.al;
import com.qzone.reborn.comment.part.h;
import com.qzone.reborn.comment.part.p;
import com.qzone.reborn.comment.part.u;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lwc/a;", "", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "", "Lcom/tencent/biz/richframework/part/Part;", "c", "b", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public abstract class a {
    public final List<Part> a(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ai(initParams));
        arrayList.add(new p(initParams));
        arrayList.add(new ah(initParams));
        arrayList.add(new u(initParams));
        arrayList.add(new al(initParams));
        if (initParams.getEnableEmo()) {
            arrayList.add(new h(initParams));
        }
        return arrayList;
    }

    public abstract List<Part> b(QZoneCommentPanelParams initParams);

    public final List<Part> c(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        ArrayList arrayList = new ArrayList();
        List<Part> a16 = a(initParams);
        if (a16 != null) {
            arrayList.addAll(a16);
        }
        List<Part> b16 = b(initParams);
        if (b16 != null) {
            arrayList.addAll(b16);
        }
        return arrayList;
    }
}
