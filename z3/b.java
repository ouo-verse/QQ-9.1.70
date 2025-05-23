package z3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.util.m;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends AbsWebView implements m {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f451836a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f451837b;

    public b(Context context, Activity activity, AppRuntime appRuntime) {
        super(context, activity, appRuntime);
        this.f451837b = false;
        this.f451836a = activity;
    }

    public void a(boolean z16) {
        this.f451837b = z16;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        super.bindJavaScript(arrayList);
        if (arrayList == null) {
            return;
        }
        arrayList.addAll(((IQwTemp) QRoute.api(IQwTemp.class)).getQWalletJsPlugins());
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildWebView(AppRuntime appRuntime) {
        super.buildBaseWebView(appRuntime);
    }

    public void onDestroy() {
        super.doOnDestroy();
    }

    public void onPause() {
        super.doOnPause();
    }

    public void onResume() {
        super.doOnResume();
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildData() {
    }

    public void buildLayout() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildTitleBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(Bundle bundle) {
    }
}
