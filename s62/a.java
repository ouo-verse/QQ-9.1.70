package s62;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webviewplugin.f;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;
import t62.c;
import t62.e;
import t62.g;
import t62.i;
import t62.k;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends WebViewPlugin implements z52.a {

    /* renamed from: e, reason: collision with root package name */
    public Bundle f433390e;

    /* renamed from: h, reason: collision with root package name */
    g f433392h;

    /* renamed from: d, reason: collision with root package name */
    private String f433389d = null;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.biz.troop.b f433391f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: s62.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public class C11209a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f433393d;

        C11209a(String str) {
            this.f433393d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            boolean z16 = bundle.getBoolean("success", false);
            JSONObject jSONObject = new JSONObject();
            try {
                try {
                    if (z16) {
                        int i3 = bundle.getInt("code", -2);
                        String string = bundle.getString("msg", "");
                        String string2 = bundle.getString(QCircleWeakNetReporter.KEY_TRACE_ID, "");
                        jSONObject.put("retCode", i3);
                        jSONObject.put("retMsg", string);
                        jSONObject.put(QCircleWeakNetReporter.KEY_TRACE_ID, string2);
                        byte[] byteArray = bundle.getByteArray("body");
                        if (byteArray != null) {
                            jSONObject.put("body", new String(byteArray));
                        }
                        QLog.i("ReadInJoyWebviewPlugin", 1, "#ssoForward: isSuccess=true, code=" + i3 + ", msg" + string);
                    } else {
                        jSONObject.put("retCode", -2);
                        QLog.i("ReadInJoyWebviewPlugin", 1, "#ssoForward: isSuccess=false");
                    }
                    a.this.callJs(this.f433393d, jSONObject.toString());
                } catch (JSONException e16) {
                    QLog.e("ReadInJoyWebviewPlugin", 1, e16, new Object[0]);
                    a.this.callJs(this.f433393d, jSONObject.toString());
                }
            } catch (Throwable th5) {
                a.this.callJs(this.f433393d, jSONObject.toString());
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class b implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f433395d;

        b(String str) {
            this.f433395d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            String string = bundle.getString("ALD_CONFIG_RESULT", "");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", string);
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("ReadInJoyWebviewPlugin", 2, "Error in value:" + string);
                }
            }
            a.this.callJs(this.f433395d, jSONObject.toString());
        }
    }

    public a() {
        e.f435478a.e(this);
        s();
    }

    private void p(JSONObject jSONObject) {
        String optString = jSONObject.optString("callback");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isArm64", true);
        } catch (JSONException e16) {
            QLog.e("ReadInJoyWebviewPlugin", 1, "checkIsArm64 exception", e16);
        }
        QLog.i("ReadInJoyWebviewPlugin", 1, "checkIsArm64, result=" + jSONObject2);
        callJs(optString, jSONObject2.toString());
    }

    private void q(JSONObject jSONObject) {
        this.f433391f.u(jSONObject, new b(jSONObject.optString("callback")));
    }

    private HashMap<String, String> r(JSONObject jSONObject) {
        String optString = jSONObject.optString("exts");
        HashMap<String, String> hashMap = null;
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(optString);
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String optString2 = jSONObject2.optString(str);
                if (!TextUtils.isEmpty(optString2)) {
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    hashMap.put(str, optString2);
                }
            }
            return hashMap;
        } catch (JSONException e16) {
            QLog.e("ReadInJoyWebviewPlugin", 1, e16, new Object[0]);
            return null;
        }
    }

    private void s() {
        k kVar = new k();
        e eVar = e.f435478a;
        eVar.f(kVar);
        eVar.f(new t62.b());
        eVar.f(new i());
    }

    private void t(JSONObject jSONObject) {
        String optString = jSONObject.optString("callback");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("qimei36", o.c());
        } catch (JSONException e16) {
            QLog.e("ReadInJoyWebviewPlugin", 1, "error to put qimei36:" + e16);
        }
        callJs(optString, jSONObject2.toString());
    }

    private void v(JSONObject jSONObject) {
        String optString = jSONObject.optString("service");
        String optString2 = jSONObject.optString("method");
        String optString3 = jSONObject.optString("body");
        String optString4 = jSONObject.optString("refer");
        String optString5 = jSONObject.optString("callback");
        HashMap<String, String> r16 = r(jSONObject);
        QLog.i("ReadInJoyWebviewPlugin", 1, "#ssoForward: service=" + optString + ", mthod=" + optString2 + ", refer=" + optString4 + ", extMap=" + r16);
        this.f433391f.I0(optString, optString2, optString3.getBytes(StandardCharsets.UTF_8), optString4, r16, new C11209a(optString5));
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void callJs(String str, String... strArr) {
        super.callJs(str, strArr);
    }

    @Override // z52.a
    public String f1() {
        SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) ((WebViewFragment) this.mRuntime.f()).getComponentProvider().a(4);
        if (swiftBrowserShareMenuHandler != null) {
            return swiftBrowserShareMenuHandler.J;
        }
        return "";
    }

    @Override // z52.a
    public String getCurrentUrl() {
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        r rVar = d16 instanceof r ? (r) d16 : null;
        if (rVar != null) {
            return rVar.getCurrentUrl();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return ProcessConstant.READINJOY;
    }

    @Override // z52.a
    public String getUin() {
        WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        if (webViewFragment != null) {
            return webViewFragment.getUin();
        }
        return "";
    }

    @Override // z52.a
    public Object getWebView() {
        return this.mRuntime.e();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 16777216L;
    }

    @Override // z52.a
    public int j(byte b16, boolean z16) {
        WebViewPlugin.b bVar = this.mRuntime;
        y d16 = bVar.d(bVar.a());
        f fVar = d16 instanceof f ? (f) d16 : null;
        if (fVar != null) {
            return fVar.switchRequestCode(this, (byte) 2, true);
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        g gVar;
        Log.d("ReadInJoyWebviewPlugin", "onActivityResult()");
        if ((b16 == 1 || b16 == 2) && (gVar = this.f433392h) != null) {
            gVar.d(intent, b16, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f433390e = new Bundle();
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f433391f = A;
        A.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        this.f433391f.q();
        g gVar = this.f433392h;
        if (gVar != null) {
            gVar.e();
        }
    }

    private boolean u(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        if (this.f433392h == null) {
            this.f433392h = new g(this, this.f433391f);
        }
        this.f433392h.g(strArr[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyWebviewPlugin", 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !ProcessConstant.READINJOY.equals(str2) || str3 == null) {
            return false;
        }
        if ("showShareReadInJoyMenu".equals(str3)) {
            if (u(strArr)) {
                return false;
            }
        } else {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyWebviewPlugin", 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
            }
            c d16 = e.f435478a.d(str3);
            if (d16 != null) {
                return d16.a(this.f433391f, this.mRuntime.a(), jsBridgeListener, str, str2, str3, strArr);
            }
            if ("getALDConfig".equals(str3)) {
                q(jsonFromJSBridge);
            } else if ("requireQimei36_A153".equalsIgnoreCase(str3)) {
                t(jsonFromJSBridge);
            } else if ("checkIsArm64".equalsIgnoreCase(str3)) {
                p(jsonFromJSBridge);
            } else if ("ssoForward".equalsIgnoreCase(str3)) {
                v(jsonFromJSBridge);
            }
        }
        return true;
    }
}
