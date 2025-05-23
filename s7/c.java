package s7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.mobileqq.webview.swift.a f433411e = new a();

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
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebSoPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getReportPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getPtloginPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebViewJumpPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getVasWebReportPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getEventApiPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getOpenCenterPlugin());
            arrayList.add((WebViewPlugin) ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppWebViewPlugin());
            arrayList.add((WebViewPlugin) ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewOfflinePlugin());
            return arrayList;
        }
    }

    public c(Context context, Activity activity, Intent intent, AppInterface appInterface, boolean z16) {
        super(context, activity, intent, appInterface, z16);
    }

    @Override // s7.b, com.tencent.mobileqq.webview.AbsWebView
    protected com.tencent.mobileqq.webview.swift.a myCommonJsPlugins() {
        if (this.f433409b) {
            return f433411e;
        }
        return new com.tencent.mobileqq.webview.swift.a();
    }
}
