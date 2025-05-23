package w00;

import UserGrowth.stGetPersonalFeedListRsp;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.request.ProfileFeedListRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements w00.a<c, j> {

    /* renamed from: a, reason: collision with root package name */
    public List<j> f444112a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public List<jz.c<j>> f444113b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private String f444114c;

    /* renamed from: d, reason: collision with root package name */
    private String f444115d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f444116e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f444117f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetPersonalFeedListRsp, C11449b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f444118a;

        a(c cVar) {
            this.f444118a = cVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        protected void a(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            x.j("WSProfileFeedsDataFetcher", "[WSProfileFeedsDataFetcher.java][failureOnSubThread] errorCode:" + jVar.a() + ", errorMsg:" + jVar.b());
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        protected void b(com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
            super.b(jVar);
            b.this.i(this.f444118a, jVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C11449b c(g<stGetPersonalFeedListRsp> gVar, stGetPersonalFeedListRsp stgetpersonalfeedlistrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            return b.this.h(stgetpersonalfeedlistrsp, this.f444118a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(C11449b c11449b) {
            super.d(c11449b);
            b.this.j(this.f444118a, c11449b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: w00.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11449b {

        /* renamed from: a, reason: collision with root package name */
        public List<j> f444120a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f444121b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f444122c;

        public C11449b(List<j> list, boolean z16, boolean z17) {
            this.f444120a = list;
            this.f444121b = z16;
            this.f444122c = z17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C11449b h(stGetPersonalFeedListRsp stgetpersonalfeedlistrsp, c cVar) {
        if (this.f444117f || !TextUtils.equals(this.f444114c, cVar.d())) {
            return null;
        }
        this.f444115d = stgetpersonalfeedlistrsp.attach_info;
        this.f444116e = stgetpersonalfeedlistrsp.is_finished;
        if (stgetpersonalfeedlistrsp.feeds == null) {
            x.j("WSProfileFeedsDataFetcher", "[WSProfileFeedsDataFetcher.java][handleRspOnSubThread] itemDataList is null, mIsFinished:" + stgetpersonalfeedlistrsp.is_finished);
        }
        List<j> e16 = i.e(stgetpersonalfeedlistrsp.feeds, false);
        this.f444112a.addAll(e16);
        x.j("WSProfileFeedsDataFetcher", "[WSProfileFeedsDataFetcher.java][handleRspOnSubThread] itemDataList size:" + e16.size() + ", mIsFinished:" + stgetpersonalfeedlistrsp.is_finished + ", reqType:" + cVar.e() + ", mAttachInfo:" + this.f444115d);
        return new C11449b(e16, cVar.a(), stgetpersonalfeedlistrsp.is_finished);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(c cVar, com.tencent.biz.pubaccount.weishi.net.common.j jVar) {
        for (jz.c<j> cVar2 : this.f444113b) {
            if (cVar2 != null) {
                cVar2.i(jVar.a(), jVar.b(), cVar.a(), cVar.b());
            }
        }
    }

    @Override // w00.a
    public void b(jz.c<j> cVar) {
        if (this.f444113b.contains(cVar)) {
            return;
        }
        this.f444113b.add(cVar);
    }

    @Override // w00.a
    public void c(jz.c<j> cVar) {
        this.f444113b.remove(cVar);
    }

    @Override // w00.a
    public List<j> getDataList() {
        return this.f444112a;
    }

    @Override // w00.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean a(c cVar) {
        this.f444117f = false;
        if (this.f444116e) {
            return false;
        }
        if (cVar.b()) {
            this.f444112a.clear();
            this.f444115d = "";
        }
        this.f444114c = cVar.d();
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new ProfileFeedListRequest(cVar.d(), this.f444115d, cVar.a(), cVar.c(), cVar.f(), cVar.e())).b(new a(cVar));
        return true;
    }

    @Override // w00.a
    public void reset() {
        this.f444117f = true;
        this.f444115d = "";
        this.f444116e = false;
        this.f444112a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(c cVar, C11449b c11449b) {
        if (c11449b == null) {
            return;
        }
        for (jz.c<j> cVar2 : this.f444113b) {
            if (cVar2 != null) {
                cVar2.d0(c11449b.f444120a, cVar.b(), c11449b.f444121b, Boolean.valueOf(!c11449b.f444122c));
            }
        }
    }
}
