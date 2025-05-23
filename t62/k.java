package t62;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J]\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0014\"\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lt62/k;", "Lt62/c;", "", QzoneIPCModule.RESULT_CODE, "", "msg", "Lorg/json/JSONObject;", "data", "", "c", "Lcom/tencent/biz/troop/b;", "client", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "a", "(Lcom/tencent/biz/troop/b;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Ljava/lang/String;", "jsCallback", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "b", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String jsCallback = "";

    private final void e(com.tencent.biz.troop.b client) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", client.d(new ITroopMemberApiClientApi.a() { // from class: t62.j
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public final void callback(Bundle bundle2) {
                k.f(k.this, bundle2);
            }
        }));
        client.y0(156, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(k this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = bundle.getInt(QzoneIPCModule.RESULT_CODE);
        String string = bundle.getString("resultMsg");
        if (string == null) {
            string = "";
        }
        d(this$0, i3, string, null, 4, null);
    }

    @Override // t62.c
    public boolean a(com.tencent.biz.troop.b client, Activity activity, JsBridgeListener listener, String url, String pkgName, String method, String... args) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(args.length == 0)) {
            try {
                String optString = new JSONObject(args[0]).optString("callback");
                Intrinsics.checkNotNullExpressionValue(optString, "jobj.optString(\"callback\")");
                this.jsCallback = optString;
                if (!TextUtils.isEmpty(optString)) {
                    e(client);
                }
            } catch (JSONException e16) {
                QLog.e("TweetTopicEntranceShouldShowAction", 1, e16.getMessage());
            }
        }
        return true;
    }

    @Override // t62.c
    public String getName() {
        return "publisherEntranceShouldShow";
    }

    private final void c(int resultCode, String msg2, JSONObject data) {
        if (data == null) {
            data = new JSONObject();
        }
        data.put("entranceShouldShow", resultCode);
        e.f435478a.b(this.jsCallback, new JsMethodModel(resultCode == 1 ? 0 : 1, msg2, data).a());
    }

    static /* synthetic */ void d(k kVar, int i3, String str, JSONObject jSONObject, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            jSONObject = null;
        }
        kVar.c(i3, str, jSONObject);
    }
}
