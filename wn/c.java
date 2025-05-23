package wn;

import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qzone.model.PhotoInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lwn/c;", "Lrk/c;", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "e", "Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", "k", "()Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;", DomainData.DOMAIN_NAME, "(Lcom/qzone/reborn/repair/bean/QZoneRepairTaskStateBean;)V", "initBean", "Ljava/util/ArrayList;", "Lcooperation/qzone/model/PhotoInfo;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "l", "()Ljava/util/ArrayList;", "o", "(Ljava/util/ArrayList;)V", s4.c.PICS, "", "g", "I", "j", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "from", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends rk.c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneRepairTaskStateBean initBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<PhotoInfo> pics = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* renamed from: j, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    /* renamed from: k, reason: from getter */
    public final QZoneRepairTaskStateBean getInitBean() {
        return this.initBean;
    }

    public final ArrayList<PhotoInfo> l() {
        return this.pics;
    }

    public final void m(int i3) {
        this.from = i3;
    }

    public final void n(QZoneRepairTaskStateBean qZoneRepairTaskStateBean) {
        this.initBean = qZoneRepairTaskStateBean;
    }

    public final void o(ArrayList<PhotoInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.pics = arrayList;
    }
}
