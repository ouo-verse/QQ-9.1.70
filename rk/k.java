package rk;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.List;
import k8.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR2\u0010/\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b\u00a8\u00065"}, d2 = {"Lrk/k;", "Lrk/c;", "", "e", "Z", "o", "()Z", "r", "(Z)V", "isFromPhotoSearch", "", "Lcom/qzone/album/data/model/PhotoCacheData;", "f", "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/List;", "v", "(Ljava/util/List;)V", s4.c.PICS, "Lk8/c$a;", "g", "Lk8/c$a;", "j", "()Lk8/c$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lk8/c$a;)V", WadlProxyConsts.EXTRA_DATA, "", tl.h.F, "J", DomainData.DOMAIN_NAME, "()J", "w", "(J)V", "uin", "i", "k", "t", "hasMore", "Ljava/util/ArrayList;", "Lcooperation/qzone/model/PhotoParam;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "l", "()Ljava/util/ArrayList;", "u", "(Ljava/util/ArrayList;)V", "photoParamList", "p", ReportConstant.COSTREPORT_PREFIX, "isFromTimeline", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFromPhotoSearch;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private c.a extraData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long uin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasMore;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isFromTimeline;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<PhotoCacheData> pics = new ArrayList();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ArrayList<PhotoParam> photoParamList = new ArrayList<>();

    /* renamed from: j, reason: from getter */
    public final c.a getExtraData() {
        return this.extraData;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ArrayList<PhotoParam> l() {
        return this.photoParamList;
    }

    public final List<PhotoCacheData> m() {
        return this.pics;
    }

    /* renamed from: n, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsFromPhotoSearch() {
        return this.isFromPhotoSearch;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsFromTimeline() {
        return this.isFromTimeline;
    }

    public final void q(c.a aVar) {
        this.extraData = aVar;
    }

    public final void r(boolean z16) {
        this.isFromPhotoSearch = z16;
    }

    public final void s(boolean z16) {
        this.isFromTimeline = z16;
    }

    public final void t(boolean z16) {
        this.hasMore = z16;
    }

    public final void u(ArrayList<PhotoParam> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.photoParamList = arrayList;
    }

    public final void v(List<PhotoCacheData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.pics = list;
    }

    public final void w(long j3) {
        this.uin = j3;
    }
}
