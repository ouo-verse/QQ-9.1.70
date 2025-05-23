package x92;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.z;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends WebViewWrapper {

    /* renamed from: j, reason: collision with root package name */
    private Activity f447489j;

    public a(Activity activity, z zVar, Intent intent, boolean z16) {
        super(zVar, intent, activity, z16);
        this.f447489j = activity;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    public TouchWebView p(TouchWebView touchWebView, Intent intent) {
        super.p(touchWebView, intent);
        b.a().g(touchWebView, BaseApplication.getContext());
        touchWebView.setWebChromeClient(new C11535a());
        return touchWebView;
    }

    /* compiled from: P */
    /* renamed from: x92.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11535a extends WebChromeClient {
        C11535a() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public View getVideoLoadingProgressView() {
            if (((WebViewWrapper) a.this).f314154a != null) {
                return ((WebViewWrapper) a.this).f314154a.getVideoLoadingProgressView();
            }
            return null;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            if (((WebViewWrapper) a.this).f314154a != null) {
                ((WebViewWrapper) a.this).f314154a.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            if (((WebViewWrapper) a.this).f314154a != null) {
                ((WebViewWrapper) a.this).f314154a.onHideCustomView();
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (((WebViewWrapper) a.this).f314154a != null) {
                ((WebViewWrapper) a.this).f314154a.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewWrapper", 2, "onProgressChanged:" + i3);
            }
            if (((WebViewWrapper) a.this).f314154a != null) {
                ((WebViewWrapper) a.this).f314154a.onProgressChanged(webView, i3);
            }
            if (i3 <= 30 || webView.getSettings().getLoadsImagesAutomatically()) {
                return;
            }
            webView.getSettings().setLoadsImagesAutomatically(true);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (((WebViewWrapper) a.this).f314154a != null) {
                ((WebViewWrapper) a.this).f314154a.onReceivedTitle(webView, str);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            if (((WebViewWrapper) a.this).f314154a != null) {
                ((WebViewWrapper) a.this).f314154a.showCustomView(view, 10, customViewCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (b.a().e(webView, valueCallback, a.this.f447489j, fileChooserParams)) {
                return true;
            }
            if (valueCallback != null && ((WebViewWrapper) a.this).f314154a != null) {
                return ((WebViewWrapper) a.this).f314154a.onShowFileChooser(valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (b.a().f(valueCallback, str, a.this.f447489j) || ((WebViewWrapper) a.this).f314154a == null) {
                return;
            }
            ((WebViewWrapper) a.this).f314154a.openFileChooser(valueCallback, str, str2);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            if (((WebViewWrapper) a.this).f314154a != null) {
                ((WebViewWrapper) a.this).f314154a.showCustomView(view, i3, customViewCallback);
            }
        }
    }
}
