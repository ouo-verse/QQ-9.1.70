package wc;

import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.part.ak;
import com.qzone.reborn.comment.part.m;
import com.tencent.biz.richframework.part.Part;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lwc/c;", "Lwc/a;", "Lcom/qzone/reborn/comment/bean/QZoneCommentPanelParams;", "initParams", "", "Lcom/tencent/biz/richframework/part/Part;", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends a {
    @Override // wc.a
    public List<Part> b(QZoneCommentPanelParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        ArrayList arrayList = new ArrayList();
        if (initParams.getEnableAt()) {
            arrayList.add(new com.qzone.reborn.comment.part.c(initParams));
        }
        if (initParams.getShowSharePanel()) {
            arrayList.add(new ak(initParams));
        }
        arrayList.add(new m(initParams));
        return arrayList;
    }
}
