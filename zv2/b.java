package zv2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdH5UrlItem;
import pw2.i;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f453549a;

        a(c cVar) {
            this.f453549a = cVar;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g
        public void a(int i3, String str, int i16) {
            b.this.t(this.f453549a, i3, str, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: zv2.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class C11720b implements iw2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f453551a;

        C11720b(c cVar) {
            this.f453551a = cVar;
        }

        @Override // iw2.a
        public void a(int i3, String str) {
            b.this.s(i3, str, this.f453551a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c extends g {
        void b();

        void c(String str);
    }

    public b(Context context, wv2.a aVar) {
        super(context, aVar);
    }

    private void n(d dVar, c cVar) {
        b(dVar, new a(cVar));
    }

    private void o(d dVar, String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            n.e("QAdJumpDirectHandler", "doCgiClickReportWithUrl fail, url is null");
        } else {
            i.p(str, dVar.k(), new C11720b(cVar));
            a(dVar);
        }
    }

    private void q(d dVar, c cVar) {
        if (dVar == null) {
            n.e("QAdJumpDirectHandler", "openLandingPage fail, reportBaseInfo is null");
            return;
        }
        if (cVar == null) {
            n.e("QAdJumpDirectHandler", "openLandingPage fail, listener is null");
            return;
        }
        String g16 = mw2.a.g(this.f303963a);
        if (TextUtils.isEmpty(g16)) {
            n.e("QAdJumpDirectHandler", "openLandingPage fail, h5Url is invalid");
        } else {
            cVar.c(g16);
        }
    }

    public static int r(wv2.a aVar) {
        AdActionItem adActionItem;
        AdH5UrlItem adH5UrlItem;
        if (aVar != null && (adActionItem = aVar.f446565a) != null && (adH5UrlItem = adActionItem.adH5UrlItem) != null) {
            return adH5UrlItem.actionJumpType;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3, String str, c cVar) {
        if (i3 == 0) {
            n.e("QAdJumpDirectHandler", "200Ok");
            t(cVar, 0, str, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(c cVar, int i3, String str, int i16) {
        if (cVar != null) {
            cVar.a(i3, str, i16);
        }
    }

    public void p(d dVar, String str, boolean z16, c cVar) {
        if (dVar == null) {
            n.e("QAdJumpDirectHandler", "openLandingPage fail, reportBaseInfo is null");
            return;
        }
        if (r(this.f303963a) != 1 && cVar != null) {
            n.e("QAdJumpDirectHandler", "openLandingPage, is Normal jump");
            cVar.b();
            return;
        }
        n.e("QAdJumpDirectHandler", "openLandingPage, is parallel jump");
        q(dVar, cVar);
        if (z16) {
            o(dVar, str, cVar);
        } else {
            n(dVar, cVar);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void c(d dVar, g gVar) {
    }
}
