package yz;

import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.k;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0002H\u0016R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lyz/h;", "Lyz/b;", "Ljz/e;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "listener", "", "a", "", "I", "getScene", "()I", "scene", "", "b", "Ljava/lang/String;", "getSubTabId", "()Ljava/lang/String;", "subTabId", "<init>", "(ILjava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String subTabId;

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J2\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"yz/h$a", "Ljz/c;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "", VideoTemplateParser.ITEM_LIST, "", "isRefresh", "isFirst", "", "extObject", "", "d0", "", "errorCode", "", "errorMsg", "i", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a implements jz.c<j> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ jz.e<List<j>> f451582d;

        a(jz.e<List<j>> eVar) {
            this.f451582d = eVar;
        }

        @Override // jz.c
        public void d0(List<j> itemList, boolean isRefresh, boolean isFirst, Object extObject) {
            jz.e<List<j>> eVar = this.f451582d;
            if (eVar != null) {
                eVar.a(itemList, isRefresh, isFirst, extObject);
            }
        }

        @Override // jz.c
        public void i(int errorCode, String errorMsg, boolean isFirst, boolean isRefresh) {
            jz.e<List<j>> eVar = this.f451582d;
            if (eVar != null) {
                eVar.i(errorCode, errorMsg, isFirst, isRefresh);
            }
        }
    }

    public h(int i3, String subTabId) {
        Intrinsics.checkNotNullParameter(subTabId, "subTabId");
        this.scene = i3;
        this.subTabId = subTabId;
    }

    @Override // yz.b
    public boolean a(jz.e<List<j>> listener) {
        k kVar = new k(this.scene, false, false);
        kVar.n(this.subTabId);
        WSVerticalDataManager.j().g(kVar, new a(listener));
        return false;
    }
}
