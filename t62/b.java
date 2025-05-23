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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J]\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0013\"\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lt62/b;", "Lt62/c;", "", QzoneIPCModule.RESULT_CODE, "", "msg", "uin", "", "c", "Lcom/tencent/biz/troop/b;", "client", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "a", "(Lcom/tencent/biz/troop/b;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Ljava/lang/String;", "jsCallback", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "b", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String jsCallback = "";

    private final void c(int resultCode, String msg2, String uin) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("encrytedUin", uin);
        e.f435478a.b(this.jsCallback, new JsMethodModel(resultCode, msg2, jSONObject).a());
    }

    private final void d(com.tencent.biz.troop.b client) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", client.d(new ITroopMemberApiClientApi.a() { // from class: t62.a
            @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
            public final void callback(Bundle bundle2) {
                b.e(b.this, bundle2);
            }
        }));
        client.y0(159, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(b this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = bundle.getInt(QzoneIPCModule.RESULT_CODE);
        String string = bundle.getString("resultMsg");
        String uin = bundle.getString("iid", "");
        if (string == null) {
            string = "";
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        this$0.c(i3, string, uin);
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
                    d(client);
                }
            } catch (JSONException e16) {
                QLog.e("TweetTopicEntranceShouldShowAction", 1, e16.getMessage());
            }
        }
        return true;
    }

    @Override // t62.c
    public String getName() {
        return "getCurrentUserEncryptedUin";
    }
}
