package r10;

import UserGrowth.stGetSimpleCommentListRsp;
import UserGrowth.stSimpleMetaComment;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSScrollCommentRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH\u0002J\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tH\u0002J\u001c\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lr10/d;", "", "Ljz/a;", "params", "LUserGrowth/stGetSimpleCommentListRsp;", "response", "Ls10/a;", "f", "responseModel", "Lkz/a;", "listener", "", "g", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "e", "Ls10/b;", "", "d", "", "a", "Ljava/lang/String;", "mAttachInfo", "b", "Z", "mIsFinished", "<init>", "()V", "c", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFinished;

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(j errorInfo, kz.a<?> listener) {
        x.f("WSScrollCommentDataFetcher", "[WSScrollCommentDataFetcher.java][handleFailOnUIThread] response errorCode:" + errorInfo.a() + ", errorMsg:" + errorInfo.b());
        if (listener != null) {
            listener.onFailure(errorInfo.a(), errorInfo.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s10.a f(jz.a params, stGetSimpleCommentListRsp response) {
        String str = response.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str, "response.attachInfo");
        this.mAttachInfo = str;
        this.mIsFinished = response.isFinished;
        ArrayList arrayList = new ArrayList();
        ArrayList<stSimpleMetaComment> arrayList2 = response.comments;
        if (arrayList2 != null) {
            x.f("WSMsgDataFetcher", "[WSScrollCommentDataFetcher.java][handleSuccessOnSubThread] response.comments size:" + arrayList2.size());
            arrayList.addAll(response.comments);
        } else {
            x.f("WSMsgDataFetcher", "[WSScrollCommentDataFetcher.java][handleSuccessOnSubThread] response.comments is null!");
        }
        boolean z16 = response.isFinished;
        ArrayList<stSimpleMetaComment> arrayList3 = response.comments;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "response.comments");
        return new s10.a(z16, arrayList3);
    }

    public final boolean d(s10.b params, kz.a<s10.a> listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (params.a()) {
            this.mAttachInfo = "";
            this.mIsFinished = false;
        }
        if (this.mIsFinished) {
            return true;
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSScrollCommentRequest(this.mAttachInfo, params.getFeedId())).b(new b(params, listener));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(s10.a responseModel, kz.a<s10.a> listener) {
        if (listener != null) {
            listener.onSuccess(responseModel);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J*\u0010\t\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u0011"}, d2 = {"r10/d$b", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stGetSimpleCommentListRsp;", "Ls10/a;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "t", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "data", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetSimpleCommentListRsp, s10.a> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s10.b f430474b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kz.a<s10.a> f430475c;

        b(s10.b bVar, kz.a<s10.a> aVar) {
            this.f430474b = bVar;
            this.f430475c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
            super.b(errorInfo);
            d.this.e(errorInfo, this.f430475c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public s10.a c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetSimpleCommentListRsp> request, stGetSimpleCommentListRsp t16, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return d.this.f(this.f430474b, t16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(s10.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.d(data);
            d.this.g(data, this.f430475c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
        }
    }
}
