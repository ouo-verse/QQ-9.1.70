package s7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends AbsWebView implements m {

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.mobileqq.webview.swift.a f433407d = new a();

    /* renamed from: a, reason: collision with root package name */
    protected Intent f433408a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f433409b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC11212b f433410c;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a extends com.tencent.mobileqq.webview.swift.a {
        a() {
        }

        @Override // com.tencent.mobileqq.webview.swift.a
        public List<WebViewPlugin> getCommonJsPlugin() {
            ArrayList arrayList = new ArrayList();
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getAntiphingHandlerPlugin());
            arrayList.add(new OfflinePlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getReportPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getPtloginPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebViewJumpPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getVasWebReportPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getEventApiPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getOpenCenterPlugin());
            arrayList.add((WebViewPlugin) ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewOfflinePlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getDocxApiPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getUIApiPlugin());
            arrayList.add((WebViewPlugin) ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppWebViewPlugin());
            arrayList.add(((IGdtAPI) QRoute.api(IGdtAPI.class)).getGdtWebReportPlugin());
            return arrayList;
        }
    }

    /* compiled from: P */
    /* renamed from: s7.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11212b {
        void onPageFinished();
    }

    public b(Context context, Activity activity, Intent intent, AppInterface appInterface, boolean z16) {
        super(context, activity, appInterface);
        this.f433408a = intent;
        this.f433409b = z16;
    }

    public void a(InterfaceC11212b interfaceC11212b) {
        this.f433410c = interfaceC11212b;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        if (this.mPluginList == null) {
            this.mPluginList = new ArrayList<>();
        }
        this.mPluginList.add((WebViewPlugin) ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewOfflinePlugin());
        this.mPluginList.add(new s7.a());
        this.mPluginList.add((WebViewPlugin) ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewPlugin());
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public final void buildWebView(AppRuntime appRuntime) {
        super.buildBaseWebView(appRuntime);
        onWebViewReady();
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    protected com.tencent.mobileqq.webview.swift.a myCommonJsPlugins() {
        if (this.f433409b) {
            return f433407d;
        }
        return new com.tencent.mobileqq.webview.swift.a();
    }

    public void onDestroy() {
        try {
            super.doOnDestroy();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(WebView webView, String str) {
        InterfaceC11212b interfaceC11212b = this.f433410c;
        if (interfaceC11212b != null) {
            try {
                interfaceC11212b.onPageFinished();
            } catch (Exception unused) {
            }
        }
    }

    public void onPause() {
        super.doOnPause();
    }

    public void onResume() {
        super.doOnResume();
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
        super.preInitPluginEngine();
    }

    public void setWebView(TouchWebView touchWebView) {
        this.mWebview = touchWebView;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneWebViewBaseBuilder", 2, "loadUrl in shouldOverrideUrlLoading url=" + str);
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge://")) {
            return true;
        }
        webView.loadUrl(str);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(Bundle bundle) {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildData() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildTitleBar() {
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onWebViewReady() {
    }
}
