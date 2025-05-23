package yv2;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdMarketDownloadVRReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdAndroidMarketInfo;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import java.util.ArrayList;
import java.util.Iterator;
import pw2.k;
import pw2.n;
import pw2.o;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends yv2.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ xv2.a f451318a;

        a(xv2.a aVar) {
            this.f451318a = aVar;
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g
        public void a(int i3, String str, int i16) {
            g gVar = c.this.f451315e;
            if (gVar != null) {
                gVar.a(i3, str, i16);
            }
            n.a("MarketDownloadHandler", "reportWhenNeedParse --> onReportFinish : resultStr = " + str + " , errCode = " + i16 + " , reporterType = " + i3);
            if (i3 == 0 && i16 == 0) {
                c.this.i(this.f451318a, ew2.c.a(str, new ew2.c()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, wv2.a aVar, AdDownloadItem adDownloadItem, d dVar, g gVar, b.a aVar2) {
        this.f451311a = aVar2;
        this.f451312b = aVar;
        this.f451313c = dVar;
        this.f451314d = adDownloadItem;
        this.f451315e = gVar;
        this.f451316f = context;
    }

    private void d(xv2.a aVar) {
        this.f451313c.t(new a(aVar));
    }

    private boolean e(@Nullable AdAndroidMarketInfo adAndroidMarketInfo) {
        if (adAndroidMarketInfo != null && adAndroidMarketInfo.enableMarketDownload) {
            ArrayList<Intent> a16 = uv2.c.a(adAndroidMarketInfo.marketDeepLink, adAndroidMarketInfo.marketPackageName, false);
            n.e("MarketDownloadHandler", "\u751f\u6210\u7684\u8df3\u8f6cIntent\u4e3a\uff1a" + a16);
            Iterator<Intent> it = a16.iterator();
            while (it.hasNext()) {
                Intent next = it.next();
                if (next != null) {
                    if (uv2.c.b(this.f451316f, next)) {
                        n.e("MarketDownloadHandler", "\u5355\u6b21\u5382\u5546\u8df3\u8f6c\u6210\u529f\uff0c\u5f53\u524d\u8df3\u8f6cIntent\u662f:" + next);
                        QAdMarketDownloadVRReport.c(g(), true);
                        return true;
                    }
                    n.e("MarketDownloadHandler", "\u5355\u6b21\u5382\u5546\u8df3\u8f6c\u5931\u8d25\uff0c\u5f53\u524d\u8df3\u8f6cIntent\u662f" + next);
                    QAdMarketDownloadVRReport.c(g(), false);
                }
            }
        }
        return false;
    }

    private int f() {
        wv2.a aVar = this.f451312b;
        if (aVar != null && aVar.f446570f == 6) {
            return 28;
        }
        return 19;
    }

    @Nullable
    private VideoReportInfo g() {
        wv2.a aVar = this.f451312b;
        if (aVar == null) {
            return null;
        }
        return aVar.E;
    }

    private void h(@Nullable String str) {
        if (!TextUtils.isEmpty(str) && this.f451312b.E != null) {
            o.d().c(str, this.f451312b.E.getAllReportInfoJsonStr(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(xv2.a aVar, ew2.c cVar) {
        cVar.f397282d = this.f451317g;
        if (cVar.f397279a == 0 && aVar != null) {
            aVar.h(f(), cVar);
        }
        if (!TextUtils.isEmpty(cVar.f397280b) && cVar.f397282d != -1) {
            k.a().b(cVar.f397280b, cVar.f397282d);
        }
    }

    @Override // yv2.a
    public void a(xv2.a aVar) {
        VideoReportInfo videoReportInfo;
        n.e("MarketDownloadHandler", "handleAction");
        if (aVar == null) {
            return;
        }
        QAdMarketDownloadVRReport.d(this.f451312b.E);
        String str = this.f451314d.packageName;
        if (pw2.b.b(this.f451316f, str)) {
            n.e("MarketDownloadHandler", "\u5f53\u524dAPP\u5df2\u5b89\u88c5");
            Context context = this.f451316f;
            wv2.a aVar2 = this.f451312b;
            if (aVar2 != null) {
                videoReportInfo = aVar2.E;
            } else {
                videoReportInfo = null;
            }
            pw2.b.f(context, str, videoReportInfo, 0);
            d(aVar);
            return;
        }
        h(str);
        if (!e(this.f451314d.androidMarketInfo)) {
            QAdMarketDownloadVRReport.a(g(), false);
            aVar.l(this.f451313c, this.f451315e, true);
        } else {
            this.f451313c.t(this.f451315e);
            QAdMarketDownloadVRReport.a(g(), true);
        }
    }
}
