package xd2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADLandingPageInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.QAdH5ReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.smtt.sdk.ValueCallback;
import gu2.h;
import jy2.d;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import pw2.w;
import xd2.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b f447820a;

    /* renamed from: b, reason: collision with root package name */
    private String f447821b;

    /* renamed from: c, reason: collision with root package name */
    private final Activity f447822c;

    /* renamed from: d, reason: collision with root package name */
    private CustomWebView f447823d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f447824e;

    /* renamed from: f, reason: collision with root package name */
    private String f447825f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: xd2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C11540a implements jy2.a {
        C11540a() {
        }

        @Override // jy2.a
        public void a(@NonNull DownloadListener downloadListener) {
            DownloadManagerV2.V().D0(downloadListener);
        }

        @Override // jy2.a
        public boolean b(@NonNull DownloadInfo downloadInfo) {
            return DownloadManagerV2.V().a0(downloadInfo);
        }

        @Override // jy2.a
        public void c(@NonNull DownloadInfo downloadInfo) {
            DownloadManagerV2.V().z0(downloadInfo);
        }

        @Override // jy2.a
        public boolean d(@NonNull String str) {
            return DownloadManagerV2.V().G(str, true);
        }

        @Override // jy2.a
        public void e(@NonNull DownloadListener downloadListener) {
            DownloadManagerV2.V().t0(downloadListener);
        }

        @Override // jy2.a
        public void f(@NonNull String str) {
            DownloadManagerV2.V().o0(str);
        }

        @Override // jy2.a
        @Nullable
        public DownloadInfo getDownloadInfoByUrl(@NonNull String str) {
            return DownloadManagerV2.V().S(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements jv2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QAdH5ReportInfo f447827a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QADLandingPageInfo f447828b;

        b(QAdH5ReportInfo qAdH5ReportInfo, QADLandingPageInfo qADLandingPageInfo) {
            this.f447827a = qAdH5ReportInfo;
            this.f447828b = qADLandingPageInfo;
        }

        @Override // jv2.a
        public String a() {
            return this.f447827a.adPos;
        }

        @Override // jv2.a
        public AdReport b() {
            return this.f447827a.adReport;
        }

        @Override // jv2.a
        public String c() {
            return a.this.d(this.f447828b.getUrl());
        }

        @Override // jv2.a
        public AdDownloadItem d() {
            return this.f447828b.getDownloadItem();
        }

        @Override // jv2.a
        public String e() {
            if (a.this.f447823d == null) {
                return null;
            }
            return mw2.b.a(w.g(a.this.f447823d));
        }

        @Override // jv2.a
        public String getAdId() {
            return this.f447827a.adId;
        }

        @Override // jv2.a
        public int getFrom() {
            return this.f447828b.getFrom();
        }

        @Override // jv2.a
        public String getReportKey() {
            return this.f447827a.adReportKey;
        }

        @Override // jv2.a
        public String getReportParams() {
            return this.f447827a.adReportParams;
        }
    }

    public a(Activity activity) {
        this.f447822c = activity;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if (!TextUtils.isEmpty(this.f447821b)) {
            return this.f447821b;
        }
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            try {
                if (parse.isHierarchical()) {
                    this.f447821b = parse.getQueryParameter("qz_gdt");
                }
            } catch (Exception e16) {
                n.h("TVideoAdWebPlugin", "getAdClickId error, msg=" + e16.getLocalizedMessage());
            }
        }
        return this.f447821b;
    }

    private void e() {
        d.f411161a.g(new C11540a());
        h.a();
    }

    private void f() {
        QADLandingPageInfo qADLandingPageInfo;
        QAdH5ReportInfo qAdH5ReportInfo;
        Intent intent = this.f447822c.getIntent();
        if (intent == null || (qADLandingPageInfo = (QADLandingPageInfo) intent.getSerializableExtra("ad_land_page_info")) == null || (qAdH5ReportInfo = qADLandingPageInfo.getQAdH5ReportInfo()) == null) {
            return;
        }
        this.f447820a.d(new b(qAdH5ReportInfo, qADLandingPageInfo));
    }

    public void c(CustomWebView customWebView) {
        if (this.f447822c == null) {
            n.e("TVideoAdWebPlugin", "attach fail, mActivity == null");
            return;
        }
        if (customWebView == null) {
            n.e("TVideoAdWebPlugin", "attach fail, webview == null");
            return;
        }
        if (this.f447820a != null) {
            n.e("TVideoAdWebPlugin", "attach fail, already attach");
            return;
        }
        this.f447823d = customWebView;
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b bVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b(new c());
        this.f447820a = bVar;
        this.f447823d.addJavascriptInterface(bVar.b(), "QQLiveJavaInterface");
        n.a("TVideoAdWebPlugin", "TVideoAdWebPlugin # onWebViewCreated");
        f();
    }

    public void g(int i3) {
        CustomWebView customWebView = this.f447823d;
        if (customWebView != null && this.f447820a != null) {
            if (i3 <= 25) {
                this.f447824e = false;
                return;
            }
            String str = this.f447825f;
            if (str == null || !str.equals(customWebView.getUrl())) {
                this.f447824e = false;
                this.f447825f = this.f447823d.getUrl();
            }
            if (!this.f447824e) {
                this.f447823d.evaluateJavascript(this.f447820a.c(), null);
                this.f447824e = true;
                Log.d("TVideoAdWebPlugin", " inject js interface completely on progress " + i3);
            }
            if (i3 == 100) {
                this.f447824e = false;
                return;
            }
            return;
        }
        n.e("TVideoAdWebPlugin", "onProgressChanged fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements b.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str) {
            a.this.f447823d.evaluateJavascript(str, new ValueCallback() { // from class: xd2.c
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    a.c.d((String) obj);
                }
            });
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b.a
        public void a(final String str) {
            if (a.this.f447823d != null) {
                QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: xd2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.this.e(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(String str) {
        }
    }
}
