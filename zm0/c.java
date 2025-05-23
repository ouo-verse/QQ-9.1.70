package zm0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends AbsWebView implements m {

    /* renamed from: a, reason: collision with root package name */
    protected Intent f452776a;

    public c(Context context, Activity activity, Intent intent, AppInterface appInterface) {
        super(context, activity, appInterface);
        this.f452776a = intent;
    }

    public boolean a(@NonNull WebView webView, @NonNull String str) {
        QLog.i(AbsWebView.TAG, 1, "qZoneShouldOverrideUrlLoading:" + str);
        if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge://")) {
            return true;
        }
        WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
        if (!str.startsWith("file://") && !str.startsWith("data:") && !str.startsWith("http://") && !str.startsWith("https://")) {
            Uri parse = Uri.parse(str);
            if (AuthorizeConfig.y().G(webView.getUrl(), parse.getScheme()).booleanValue()) {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
                intent.addFlags(268435456);
                try {
                    this.mContext.startActivity(intent);
                } catch (Exception e16) {
                    QLog.e(AbsWebView.TAG, 1, "startActivity", e16);
                }
            }
            return true;
        }
        if (pluginEngine != null && pluginEngine.s(str, 16L, null)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        super.bindJavaScript(arrayList);
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public final void buildWebView(AppRuntime appRuntime) {
        super.buildBaseWebView(appRuntime);
    }

    public void onCreate(Bundle bundle) {
        super.doOnCreate(this.f452776a);
    }

    public void onDestroy() {
        try {
            super.doOnDestroy();
        } catch (Exception e16) {
            GdtLog.e("GdtWebViewBuilder", "getVideoComponent error", e16);
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

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
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

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(Bundle bundle) {
    }
}
