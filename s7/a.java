package s7;

import android.text.TextUtils;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.util.QZLog;
import java.util.Map;
import org.json.JSONObject;
import yo.d;
import yo.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    public long f433401d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f433402e = -1;

    /* renamed from: f, reason: collision with root package name */
    public long f433403f = -1;

    /* renamed from: h, reason: collision with root package name */
    public long f433404h = -1;

    /* renamed from: i, reason: collision with root package name */
    public String f433405i = null;

    /* renamed from: m, reason: collision with root package name */
    public boolean f433406m = false;
    private String C = QzoneCoverConst.WEBVIEW_DEFAULT_ERROR_MSG;

    private void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("webviewStartTime", this.f433401d);
            jSONObject.put("webviewFinishTime", this.f433402e);
            jSONObject.put("pageStartTime", this.f433403f);
            jSONObject.put("pageFinishTime", this.f433404h);
            jSONObject.put("url", this.f433405i);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        callJs(str, jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "QzoneShow";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.e() == null) {
            return false;
        }
        if (j3 == 8589934595L) {
            if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge://")) {
                return false;
            }
            if (map != null) {
                Object obj = map.get("errorCode");
                if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    if (QZLog.isColorLevel() && this.mRuntime.e() != null) {
                        QZLog.d("WebViewPlugin", 2, "load web failed(" + intValue + "), url: " + this.mRuntime.e().getUrl());
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("<html><head> <style>html,body{width:100%;height:100%;}html,body,div,p{margin:0;padding:0;}</style></head><body>\n <div style=\"\n    position: relative;\n    left: 50%;\n    top: 50%;\n    width: 360px;\n    height: 32px;\n\"><p style=\"\n    position: relative;\n    left: -50%;\n    top: -50%;\n    font-size: 32px;\n\">");
                    String str2 = this.C;
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb5.append(str2);
                    sb5.append("</p></div>\n\n</body></html>");
                    String sb6 = sb5.toString();
                    try {
                        CustomWebView e16 = this.mRuntime.e();
                        e16.stopLoading();
                        e16.loadDataWithBaseURL(null, sb6, "text/html", "utf-8", null);
                        return true;
                    } catch (Exception unused) {
                        return true;
                    }
                }
            }
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        this.f433401d = -1L;
        this.f433402e = -1L;
        this.f433403f = -1L;
        this.f433404h = -1L;
        this.f433405i = null;
    }

    public void q(String str) {
        this.C = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin.b bVar;
        String str4;
        if (str2 != null && str2.equals("QzoneShow") && str3 != null && (bVar = this.mRuntime) != null && bVar.a() != null) {
            if (str3.equals("openUrl") && strArr.length >= 1) {
                d.b(this.mRuntime.a(), new g(strArr[0]));
                return true;
            }
            if (str3.equals("getWebLoadTime") && strArr.length >= 1) {
                try {
                    str4 = new JSONObject(strArr[0]).optString("callback");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    str4 = null;
                }
                p(str4);
                return true;
            }
        }
        return false;
    }
}
