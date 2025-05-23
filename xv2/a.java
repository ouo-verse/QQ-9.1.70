package xv2;

import android.content.Context;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import pw2.i;
import pw2.m;
import pw2.n;
import pw2.u;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends b {

    /* renamed from: g, reason: collision with root package name */
    private int f448746g;

    public a(Context context, wv2.a aVar) {
        super(context, aVar);
        this.f448746g = m.a();
    }

    private void m(d dVar, g gVar) {
        yv2.a a16 = yv2.b.a(i.k(this.f303964b), this.f303963a, this.f303965c, dVar, gVar);
        if (a16 == null) {
            e(dVar, gVar);
        } else {
            a16.b(this.f448746g);
            a16.a(this);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b
    public void c(d dVar, g gVar) {
        n.e("QADDownloadActionHandler", "doClick");
        g(10001);
        u.i(this.f303963a, dVar, true);
        l(dVar, gVar, false);
    }

    public void l(d dVar, g gVar, boolean z16) {
        if (mw2.a.c(z16, this.f303963a) && mw2.a.m(dVar, this.f303963a)) {
            mw2.a.e(this.f303963a);
            m(dVar, gVar);
        } else {
            e(dVar, gVar);
        }
    }
}
