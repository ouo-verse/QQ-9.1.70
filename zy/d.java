package zy;

import UserGrowth.stGetSubjectMsgDetailRsp;
import UserGrowth.stMsgContentPersonInfo;
import UserGrowth.stNotifyMsg;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSMsgDetailRequest;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yy.WSMsgDetailData;
import yy.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\u0006\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b&\u0010'J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JD\u0010\u000e\u001a\u00020\r2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J@\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0004j\b\u0012\u0004\u0012\u00020\t`\u00062\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J&\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00112\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018J \u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0011R\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010!R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010!R\u0016\u0010\u0017\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010$R\u0016\u0010%\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$\u00a8\u0006("}, d2 = {"Lzy/d;", "", "LUserGrowth/stGetSubjectMsgDetailRsp;", "response", "Ljava/util/ArrayList;", "Lyy/c;", "Lkotlin/collections/ArrayList;", "f", "sectionList", "LUserGrowth/stNotifyMsg;", "messages", "", "msgOfSubjectID", "", "d", "Ljz/a;", "params", "", "hasRead", "b", "subjectId", "hasReadSection", "g", "needReadStatus", "Lkz/a;", "Lyy/a;", "listener", "c", "e", "a", "I", "subjectID", "", "Ljava/lang/String;", "pageId", "attachInfo", "Z", "hasUnReadSection", "<init>", "(ILjava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int subjectID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String pageId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String attachInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needReadStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasReadSection;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasUnReadSection;

    public d(int i3, String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.subjectID = i3;
        this.pageId = pageId;
        this.attachInfo = "";
    }

    private final yy.c b(jz.a params, boolean hasRead) {
        if (params.a() || params.b()) {
            this.hasReadSection = false;
            this.hasUnReadSection = false;
        }
        if (hasRead && this.hasReadSection) {
            return null;
        }
        if (!hasRead && this.hasUnReadSection) {
            return null;
        }
        c.b bVar = new c.b(0, hasRead);
        if (hasRead) {
            this.hasReadSection = true;
        } else {
            this.hasUnReadSection = true;
        }
        return new yy.c(-1, 0, null, bVar, null, null);
    }

    private final ArrayList<yy.c> f(stGetSubjectMsgDetailRsp response) {
        ArrayList<yy.c> arrayList = new ArrayList<>();
        d(arrayList, response.unreadMsg, response.subjectID);
        d(arrayList, response.readMsg, response.subjectID);
        return arrayList;
    }

    private final ArrayList<yy.c> g(ArrayList<stNotifyMsg> messages, int subjectId, boolean hasReadSection) {
        ArrayList<yy.c> arrayList = new ArrayList<>();
        int size = messages.size();
        for (int i3 = 0; i3 < size; i3++) {
            c.a aVar = new c.a(true, true, true, true);
            if (hasReadSection && i3 == 0) {
                aVar.h(0);
            } else {
                aVar.h(13);
            }
            yy.c cVar = new yy.c(messages.get(i3).content.templateID, subjectId, null, null, messages.get(i3), aVar);
            cVar.h(this.pageId);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public final boolean c(jz.a params, boolean needReadStatus, kz.a<WSMsgDetailData> listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.needReadStatus = needReadStatus;
        if (params.a() || params.b()) {
            this.attachInfo = "";
        }
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSMsgDetailRequest(this.attachInfo, this.subjectID)).b(new b(params, needReadStatus, listener));
        return true;
    }

    public final WSMsgDetailData e(jz.a params, stGetSubjectMsgDetailRsp response, boolean needReadStatus) {
        Intrinsics.checkNotNullParameter(params, "params");
        WSMsgDetailData wSMsgDetailData = new WSMsgDetailData();
        if (response != null) {
            wSMsgDetailData.d(response.isFinished);
            wSMsgDetailData.e(response.totalCount);
            wSMsgDetailData.f(response.subjectID);
            if (!needReadStatus) {
                wSMsgDetailData.b().addAll(f(response));
                return wSMsgDetailData;
            }
            ArrayList<stNotifyMsg> arrayList = response.unreadMsg;
            if (arrayList != null && arrayList.size() != 0) {
                yy.c b16 = b(params, false);
                if (b16 != null) {
                    wSMsgDetailData.b().add(b16);
                }
                ArrayList<yy.c> b17 = wSMsgDetailData.b();
                ArrayList<stNotifyMsg> unreadMsg = response.unreadMsg;
                Intrinsics.checkNotNullExpressionValue(unreadMsg, "unreadMsg");
                b17.addAll(g(unreadMsg, response.subjectID, b16 != null));
            }
            ArrayList<stNotifyMsg> arrayList2 = response.readMsg;
            if (arrayList2 != null && arrayList2.size() != 0) {
                yy.c b18 = b(params, true);
                if (b18 != null) {
                    wSMsgDetailData.b().add(b18);
                }
                ArrayList<yy.c> b19 = wSMsgDetailData.b();
                ArrayList<stNotifyMsg> readMsg = response.readMsg;
                Intrinsics.checkNotNullExpressionValue(readMsg, "readMsg");
                b19.addAll(g(readMsg, response.subjectID, b18 != null));
            }
        }
        return wSMsgDetailData;
    }

    private final void d(ArrayList<yy.c> sectionList, ArrayList<stNotifyMsg> messages, int msgOfSubjectID) {
        c.a aVar;
        if (messages == null || messages.size() == 0) {
            return;
        }
        int size = messages.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == 0) {
                aVar = new c.a(20);
            } else {
                aVar = new c.a(32);
            }
            c.a aVar2 = aVar;
            stMsgContentPersonInfo stmsgcontentpersoninfo = messages.get(i3).oper;
            if (stmsgcontentpersoninfo != null) {
                if (r.r(stmsgcontentpersoninfo.beFollow)) {
                    aVar2.g(2);
                } else {
                    aVar2.g(3);
                }
            }
            yy.c cVar = new yy.c(0, msgOfSubjectID, null, null, messages.get(i3), aVar2);
            cVar.h(this.pageId);
            sectionList.add(cVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J,\u0010\t\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\u0011"}, d2 = {"zy/d$b", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stGetSubjectMsgDetailRsp;", "Lyy/a;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "t", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "data", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetSubjectMsgDetailRsp, WSMsgDetailData> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ jz.a f453687b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f453688c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kz.a<WSMsgDetailData> f453689d;

        b(jz.a aVar, boolean z16, kz.a<WSMsgDetailData> aVar2) {
            this.f453687b = aVar;
            this.f453688c = z16;
            this.f453689d = aVar2;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        protected void b(j errorInfo) {
            Intrinsics.checkNotNullParameter(errorInfo, "errorInfo");
            super.b(errorInfo);
            x.f("WSMsgDetailDataFetcher", "[WSMsgDetailDataFetcher.kt][fetchData] response errorCode:" + errorInfo.a() + ", errorMsg:" + errorInfo.b());
            kz.a<WSMsgDetailData> aVar = this.f453689d;
            if (aVar != null) {
                int a16 = errorInfo.a();
                String b16 = errorInfo.b();
                if (b16 == null) {
                    b16 = "";
                }
                aVar.onFailure(a16, b16);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public WSMsgDetailData c(com.tencent.biz.pubaccount.weishi.net.common.g<stGetSubjectMsgDetailRsp> request, stGetSubjectMsgDetailRsp t16, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            d dVar = d.this;
            String str = t16 != null ? t16.attachInfo : null;
            if (str == null) {
                str = "";
            }
            dVar.attachInfo = str;
            return d.this.e(this.f453687b, t16, this.f453688c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(WSMsgDetailData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            super.d(data);
            kz.a<WSMsgDetailData> aVar = this.f453689d;
            if (aVar != null) {
                aVar.onSuccess(data);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        protected void a(j errorInfo) {
        }
    }
}
