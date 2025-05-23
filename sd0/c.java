package sd0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.fragment.QRDisplayMyCardFragment;
import com.tencent.biz.qrcode.mgr.MyQRCodeManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J'\u0010\f\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\f\u0010\u0007J\b\u0010\r\u001a\u00020\u0003H\u0016JO\u0010\u0013\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lsd0/c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "", "args", "", "r", "([Ljava/lang/String;)Z", ReportConstant.COSTREPORT_PREFIX, "isFromMyQRCode", "", "w", "u", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "<init>", "()V", "d", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class c extends WebViewPlugin {
    private final boolean r(String... args) {
        String str;
        boolean z16;
        String optString;
        String str2;
        if (args.length == 1 && !TextUtils.isEmpty(args[0])) {
            try {
                String str3 = args[0];
                Intrinsics.checkNotNull(str3);
                JSONObject jSONObject = new JSONObject(str3);
                optString = jSONObject.optString("base64");
                str = jSONObject.optString("callback");
                Intrinsics.checkNotNullExpressionValue(str, "json.optString(\"callback\")");
            } catch (Exception e16) {
                e = e16;
                str = "";
            }
            try {
                ScannerResult decodeQRCodeFromBase64 = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQRCodeFromBase64(optString);
                if (decodeQRCodeFromBase64 == null) {
                    str2 = "";
                } else {
                    str2 = ((StringBuilder) decodeQRCodeFromBase64.f().first).toString();
                    Intrinsics.checkNotNullExpressionValue(str2, "scannerResult.oneQrResult.first.toString()");
                    QLog.i("QRCodeJSPlugin", 1, "handleDecodeQRCode, qrcode = " + decodeQRCodeFromBase64.f());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ret", 0);
                jSONObject2.put("qrcodeStr", str2);
                QLog.i("QRCodeJSPlugin", 1, "[handleDecodeQRCode] resultJson = " + jSONObject2);
                callJs(str, jSONObject2.toString());
            } catch (Exception e17) {
                e = e17;
                QLog.e("QRCodeJSPlugin", 1, "handleDecodeQRCode error, ", e);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("ret", 1);
                    jSONObject3.put("qrcodeStr", "");
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        QLog.i("QRCodeJSPlugin", 1, "[handleDecodeQRCode] resultJson = " + jSONObject3);
                        callJs(str, jSONObject3.toString());
                    }
                } catch (Exception e18) {
                    QLog.e("QRCodeJSPlugin", 1, "handleDecodeQRCode callback error, ", e18);
                }
                return true;
            }
            return true;
        }
        QLog.e("QRCodeJSPlugin", 1, "decodeQRCode args error.");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [T, java.lang.Object, java.lang.String] */
    private final boolean s(String... args) {
        boolean z16;
        if (args.length == 1 && !TextUtils.isEmpty(args[0])) {
            MyQRCodeManager.f94961a.n();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            try {
                String str = args[0];
                Intrinsics.checkNotNull(str);
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("url");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"url\")");
                int optInt = jSONObject.optInt(IProfileCardConst.KEY_FROM_TYPE, 0);
                final boolean booleanExtra = this.mRuntime.f().getIntent().getBooleanExtra("key_start_by_my_qrcode", false);
                QLog.i("QRCodeJSPlugin", 1, "fromType=" + optInt + ", downloadUrl=" + optString);
                ?? optString2 = jSONObject.optString("callback");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"callback\")");
                objectRef.element = optString2;
                QIPCClientHelper.getInstance().callServer("QRCodeIPCModule", "action_set_my_aigc_qrcode", new Bundle(), new EIPCResultCallback() { // from class: sd0.b
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        c.t(c.this, booleanExtra, objectRef, eIPCResult);
                    }
                });
            } catch (Exception e16) {
                QLog.e("QRCodeJSPlugin", 1, "handleOpenMyQRCode error, ", e16);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ret", 1);
                    if (((CharSequence) objectRef.element).length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        callJs((String) objectRef.element, jSONObject2.toString());
                    }
                } catch (Exception e17) {
                    QLog.e("QRCodeJSPlugin", 1, "handleOpenMyQRCode callback error, ", e17);
                }
            }
            return true;
        }
        QLog.e("QRCodeJSPlugin", 1, "handleOpenMyQRCode args error.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(c this$0, boolean z16, Ref.ObjectRef callback, EIPCResult eIPCResult) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (eIPCResult != null && eIPCResult.isSuccess()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            this$0.w(z16);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", 0);
            this$0.callJs((String) callback.element, jSONObject.toString());
            return;
        }
        QLog.i("QRCodeJSPlugin", 1, "set aigc qrcode error.");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ret", 1);
        this$0.callJs((String) callback.element, jSONObject2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, java.lang.Object, java.lang.String] */
    private final boolean u(String... args) {
        boolean z16;
        QLog.i("QRCodeJSPlugin", 1, "[handleOpenTroopQRCode] args = " + args);
        if (args.length == 1 && !TextUtils.isEmpty(args[0])) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            try {
                String str = args[0];
                Intrinsics.checkNotNull(str);
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("groupId");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"groupId\")");
                String optString2 = jSONObject.optString(WadlProxyConsts.CHANNEL);
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"channel\")");
                ?? optString3 = jSONObject.optString("callback");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"callback\")");
                objectRef.element = optString3;
                String optString4 = jSONObject.optString("url");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"url\")");
                Bundle bundle = new Bundle();
                bundle.putString("groupId", optString);
                bundle.putString(WadlProxyConsts.CHANNEL, optString2);
                bundle.putString("downloadUrl", optString4);
                QIPCClientHelper.getInstance().callServer("QRCodeIPCModule", "action_set_troop_aigc_qrcode", bundle, new EIPCResultCallback() { // from class: sd0.a
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        c.v(c.this, objectRef, eIPCResult);
                    }
                });
            } catch (Exception e16) {
                QLog.e("QRCodeJSPlugin", 1, "handleOpenTroopQRCode error, ", e16);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ret", 1);
                    if (((CharSequence) objectRef.element).length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        callJs((String) objectRef.element, jSONObject2.toString());
                    }
                } catch (Exception e17) {
                    QLog.e("QRCodeJSPlugin", 1, "handleOpenTroopQRCode callback error, ", e17);
                }
            }
            return true;
        }
        QLog.e("QRCodeJSPlugin", 1, "handleOpenTroopQRCode args error.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v(c this$0, Ref.ObjectRef callback, EIPCResult eIPCResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (eIPCResult != null && eIPCResult.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this$0.mRuntime.a().finish();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", 0);
            this$0.callJs((String) callback.element, jSONObject.toString());
            return;
        }
        QLog.i("QRCodeJSPlugin", 1, "set aigc qrcode error.");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ret", 1);
        this$0.callJs((String) callback.element, jSONObject2.toString());
    }

    private final void w(boolean isFromMyQRCode) {
        Activity a16;
        if (isFromMyQRCode) {
            this.mRuntime.a().finish();
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (a16 = bVar.a()) != null) {
            String string = a16.getString(R.string.g2w);
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(R.string.qrcode_user_card)");
            String currentAccountUin = this.mRuntime.c().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "mRuntime.appRuntime.currentAccountUin");
            String f16 = ac.f(this.mRuntime.b(), currentAccountUin);
            Intent intent = new Intent(a16, (Class<?>) QRDisplayActivity.class);
            intent.putExtra("title", string);
            intent.putExtra("nick", f16);
            intent.putExtra("uin", currentAccountUin);
            intent.putExtra("key_start_by_js", true);
            intent.putExtra("type", 1);
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            QPublicFragmentActivity.start(a16, intent2, QRDisplayMyCardFragment.class);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "qrcode";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        boolean z16;
        Intrinsics.checkNotNullParameter(args, "args");
        if (method == null) {
            return false;
        }
        if (method.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        int hashCode = method.hashCode();
        if (hashCode != -2091312356) {
            if (hashCode != -1166041533) {
                if (hashCode == 1591668932 && method.equals("openMyQRCode")) {
                    return s((String[]) Arrays.copyOf(args, args.length));
                }
            } else if (method.equals("openGroupQRCode")) {
                return u((String[]) Arrays.copyOf(args, args.length));
            }
        } else if (method.equals("decodeQRCode")) {
            return r((String[]) Arrays.copyOf(args, args.length));
        }
        return true;
    }
}
