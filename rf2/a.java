package rf2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.QQKuiklyWebView;
import com.tencent.mobileqq.webview.swift.WebViewModule;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.af;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends WebViewModule {

    /* renamed from: d, reason: collision with root package name */
    private Context f431384d;

    /* renamed from: e, reason: collision with root package name */
    private QQKuiklyWebView f431385e;

    /* renamed from: f, reason: collision with root package name */
    private C11137a f431386f;

    /* compiled from: P */
    /* renamed from: rf2.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11137a implements y, af {
        C11137a() {
        }

        @Override // com.tencent.mobileqq.webview.swift.af
        public int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16) {
            Activity activity = a.this.getActivity();
            if (activity == null) {
                return 0;
            }
            activity.startActivityForResult(intent, b16);
            return 0;
        }

        @Override // com.tencent.mobileqq.webview.swift.af
        public int switchRequestCode(WebViewPlugin webViewPlugin, byte b16) {
            return 0;
        }
    }

    public a(Intent intent, Context context, QQKuiklyWebView qQKuiklyWebView) {
        super(intent, context);
        this.f431386f = new C11137a();
        this.f431384d = context;
        this.f431385e = qQKuiklyWebView;
    }

    public y a() {
        return this.f431386f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewModule
    public Activity getActivity() {
        Context context = this.f431384d;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return super.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewModule
    public void initWebView() {
        super.initWebView();
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            this.f431385e.l(touchWebView);
            this.mPluginEngine.b(this.f431386f);
        } else {
            QLog.e("HippyWebViewModule", 1, "initWebView webview is null");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public void onPageFinished(WebView webView, String str) {
        if (this.f431385e != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("url", str);
            this.f431385e.g(hashMap);
            this.f431385e.j(hashMap);
        }
        super.onPageFinished(webView, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.f431385e != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("url", str);
            this.f431385e.i(hashMap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        if (this.f431385e != null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("url", str2);
            hashMap.put("errCode", Integer.valueOf(i3));
            hashMap.put("errMsg", str);
            this.f431385e.m(hashMap);
        }
        super.onReceivedError(webView, i3, str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewModule, com.tencent.mobileqq.webview.swift.z
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
