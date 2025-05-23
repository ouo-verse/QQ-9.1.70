package ww;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016JO\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\t\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lww/a;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "qav";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        boolean equals$default;
        int i3;
        Intrinsics.checkNotNullParameter(args, "args");
        if (TextUtils.isEmpty(url)) {
            QLog.e("QavApiPlugin", 1, "Call qav jsapi error, url is empty");
            return false;
        }
        try {
            String optString = new JSONObject(args[0]).optString("callback");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(KEY_CALLBACK)");
            if (QLog.isColorLevel()) {
                QLog.i("QavApiPlugin", 2, "callback: " + optString);
            }
            equals$default = StringsKt__StringsJVMKt.equals$default(pkgName, "qav", false, 2, null);
            if (equals$default) {
                if (Intrinsics.areEqual("isSupportAvatarCall", method)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QavApiPlugin", 2, "Call method isSupportAvatarCall");
                    }
                    boolean c16 = ax.a.c(this.mRuntime.c());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (c16) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        jSONObject.put("isSupportAvatarCall", i3);
                        if (QLog.isColorLevel()) {
                            QLog.i("QavApiPlugin", 2, "method isSupportAvatarCall return: " + jSONObject);
                        }
                        callJs(optString, jSONObject.toString());
                        return true;
                    } catch (JSONException unused) {
                        QLog.e("QavApiPlugin", 1, "handle method isSupportAvatarCall json exception");
                        return false;
                    }
                }
                QLog.e("QavApiPlugin", 1, "Call qav jsapi error, method not match");
                return false;
            }
            QLog.e("QavApiPlugin", 1, "Call qav jsapi error, package not match");
            return false;
        } catch (JSONException e16) {
            QLog.e("QavApiPlugin", 1, "handleJsRequest " + method + " exception[" + e16.getMessage() + "]");
            return false;
        }
    }
}
