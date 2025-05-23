package xy;

import UserGrowth.stFirstPageSubjectInfo;
import UserGrowth.stGetFirstPageMsgListRsp;
import UserGrowth.stMsgContent;
import UserGrowth.stNotifyMsg;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSMsgPageRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yy.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tH\u0002J\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tH\u0002J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001c\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lxy/d;", "", "Ljz/a;", "params", "LUserGrowth/stGetFirstPageMsgListRsp;", "response", "Lyy/b;", tl.h.F, "responseModel", "Lkz/a;", "listener", "", "i", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "g", "", "subjectId", "LUserGrowth/stNotifyMsg;", "msgInfo", "index", "", "isLastMsgInSection", "Lyy/c;", "d", "LUserGrowth/stFirstPageSubjectInfo;", "subjectInfo", "e", "f", "", "a", "Ljava/lang/String;", "mAttachInfo", "<init>", "()V", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo;

    private final yy.c d(int subjectId, stNotifyMsg msgInfo, int index, boolean isLastMsgInSection) {
        c.a aVar;
        stMsgContent stmsgcontent = msgInfo.content;
        int i3 = stmsgcontent != null ? stmsgcontent.templateID : -2;
        x.j("WSMsgDataFetcher", "[WSMsgDataFetcher.java][buildMsgContentData] msgID:" + msgInfo.msgID);
        if (index == 0 && isLastMsgInSection) {
            aVar = new c.a(true, true, true, true);
        } else if (index == 0) {
            aVar = new c.a(true, true, false, false);
        } else if (isLastMsgInSection) {
            aVar = new c.a(false, false, true, true);
        } else {
            aVar = new c.a(false, false, false, false);
        }
        return new yy.c(i3, subjectId, null, null, msgInfo, aVar);
    }

    private final yy.c e(stFirstPageSubjectInfo subjectInfo) {
        c.C11639c c11639c = new c.C11639c(subjectInfo.ID, subjectInfo.name, subjectInfo.redCount, subjectInfo.schema);
        x.j("WSMsgDataFetcher", "[WSMsgDataFetcher.java][buildMsgSectionData] subjectInfo.ID:" + subjectInfo.ID + ", subjectInfo.name:" + subjectInfo.name);
        return new yy.c(-2, subjectInfo.ID, c11639c, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(j errorInfo, kz.a<?> listener) {
        x.f("WSMsgDataFetcher", "[WSMsgDataFetcher.java][handleFailOnUIThread] response errorCode:" + errorInfo.a() + ", errorMsg:" + errorInfo.b());
        if (listener != null) {
            listener.onFailure(errorInfo.a(), errorInfo.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yy.b h(jz.a params, stGetFirstPageMsgListRsp response) {
        String str = response.attachInfo;
        Intrinsics.checkNotNullExpressionValue(str, "response.attachInfo");
        this.mAttachInfo = str;
        ArrayList arrayList = new ArrayList();
        ArrayList<stFirstPageSubjectInfo> arrayList2 = response.subjectList;
        if (arrayList2 != null) {
            Iterator<stFirstPageSubjectInfo> it = arrayList2.iterator();
            while (it.hasNext()) {
                stFirstPageSubjectInfo subjectInfo = it.next();
                Intrinsics.checkNotNullExpressionValue(subjectInfo, "subjectInfo");
                arrayList.add(e(subjectInfo));
                Iterator<stNotifyMsg> it5 = subjectInfo.topContent.iterator();
                int i3 = 0;
                while (it5.hasNext()) {
                    int i16 = i3 + 1;
                    stNotifyMsg msgInfo = it5.next();
                    boolean z16 = true;
                    if (i3 != subjectInfo.topContent.size() - 1) {
                        z16 = false;
                    }
                    int i17 = subjectInfo.ID;
                    Intrinsics.checkNotNullExpressionValue(msgInfo, "msgInfo");
                    arrayList.add(d(i17, msgInfo, i3, z16));
                    i3 = i16;
                }
            }
        } else {
            x.f("WSMsgDataFetcher", "[WSMsgDataFetcher.java][handleSuccessOnSubThread] response.subjectList is null!");
        }
        return new yy.b(params.a(), params.b(), response.attachInfo, response.IsFinished, arrayList, response.topRedCount);
    }

    public final boolean f(jz.a params, kz.a<yy.b> listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean a16 = params.a();
        boolean b16 = params.b();
        if (a16 || b16) {
            this.mAttachInfo = "";
        }
        String str = this.mAttachInfo;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttachInfo");
            str = null;
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSMsgPageRequest(str)).b(new b(params, listener));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(yy.b responseModel, kz.a<yy.b> listener) {
        if (listener != null) {
            listener.onSuccess(responseModel);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J*\u0010\t\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u0011"}, d2 = {"xy/d$b", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stGetFirstPageMsgListRsp;", "Lyy/b;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "t", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "data", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetFirstPageMsgListRsp, yy.b> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jz.a f449014b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kz.a<yy.b> f449015c;

        b(jz.a aVar, kz.a<yy.b> aVar2) {
            this.f449014b = aVar;
            this.f449015c = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
            super.b(errorInfo);
            d.this.g(errorInfo, this.f449015c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public yy.b c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetFirstPageMsgListRsp> request, stGetFirstPageMsgListRsp t16, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return d.this.h(this.f449014b, t16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(yy.b data) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.d(data);
            d.this.i(data, this.f449015c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
        }
    }
}
