package t62;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004J \u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010!\u00a8\u0006%"}, d2 = {"Lt62/g;", "", "Landroid/os/Bundle;", "bundle", "", "f", "", "data", "g", "b", "e", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "d", "Lz52/a;", "a", "Lz52/a;", "getPlugin", "()Lz52/a;", "plugin", "Lcom/tencent/biz/troop/b;", "Lcom/tencent/biz/troop/b;", "getClient", "()Lcom/tencent/biz/troop/b;", "client", "c", "Ljava/lang/String;", "callback", "Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$a;", "Lcom/tencent/mobileqq/troop/api/ITroopMemberApiClientApi$a;", "clientCallback", "<init>", "(Lz52/a;Lcom/tencent/biz/troop/b;)V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z52.a plugin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.biz.troop.b client;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ITroopMemberApiClientApi.a clientCallback;

    public g(z52.a plugin, com.tencent.biz.troop.b client) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(client, "client");
        this.plugin = plugin;
        this.client = client;
        this.callback = "";
        this.clientCallback = new ITroopMemberApiClientApi.a() { // from class: t62.f
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public final void callback(Bundle bundle) {
                g.c(g.this, bundle);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(g this$0, Bundle resp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = resp.getString("methodName");
        if (Intrinsics.areEqual(string, "callBackToJs")) {
            Intrinsics.checkNotNullExpressionValue(resp, "resp");
            this$0.b(resp);
        } else if (Intrinsics.areEqual(string, "onFontSizeChange")) {
            Intrinsics.checkNotNullExpressionValue(resp, "resp");
            this$0.f(resp);
        } else {
            QLog.e("", 2, "method name = " + string);
        }
    }

    private final void f(Bundle bundle) {
        int i3 = bundle.getInt("index");
        bundle.getFloat("textSizeRatio");
        Object webView = this.plugin.getWebView();
        Intrinsics.checkNotNull(webView, "null cannot be cast to non-null type com.tencent.biz.pubaccount.CustomWebView");
        WebSettings settings = ((CustomWebView) webView).getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webview.getSettings()");
        settings.setTextZoom(SwiftBrowserShareMenuHandler.f314289m0[i3]);
        this.client.B0(i3);
    }

    public final void b(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Object webView = this.plugin.getWebView();
        Intrinsics.checkNotNull(webView, "null cannot be cast to non-null type com.tencent.biz.pubaccount.CustomWebView");
        ((CustomWebView) webView).callJs(this.callback, bundle.getString("result"));
    }

    public final void g(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            String optString = new JSONObject(data).optString("callback");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"callback\")");
            this.callback = optString;
        } catch (JSONException unused) {
        }
        int d16 = this.client.d(this.clientCallback);
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d16);
        bundle.putString("data", data);
        bundle.putInt("code_share_qzone_key", this.plugin.j((byte) 2, true));
        bundle.putString("uin_key", this.plugin.getUin());
        bundle.putString("public_uin_key", this.plugin.f1());
        bundle.putString("current_url_key", this.plugin.getCurrentUrl());
        this.client.y0(161, bundle);
    }

    public final void e() {
    }

    public final void d(Intent intent, byte requestCode, int resultCode) {
    }
}
