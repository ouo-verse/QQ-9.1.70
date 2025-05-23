package t62;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J]\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u000f\"\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lt62/i;", "Lt62/c;", "Lcom/tencent/biz/troop/b;", "client", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "data", "", "c", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "a", "(Lcom/tencent/biz/troop/b;Landroid/app/Activity;Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "Ljava/lang/String;", "callback", "", "b", "I", "seq", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String callback = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int seq = -1;

    private final void c(final com.tencent.biz.troop.b client, Activity activity, String data) {
        try {
            JSONObject jSONObject = new JSONObject(data);
            String optString = jSONObject.optString("callback");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"callback\")");
            this.callback = optString;
            if (optString.length() == 0) {
                return;
            }
            this.seq = client.d(new ITroopMemberApiClientApi.a() { // from class: t62.h
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
                public final void callback(Bundle bundle) {
                    i.d(com.tencent.biz.troop.b.this, this, bundle);
                }
            });
            JSONArray optJSONArray = jSONObject.optJSONArray("imageIDs");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.getString(i3));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
                bundle.putString("src_id", jSONObject.optString("srcID"));
                bundle.putInt("index", jSONObject.optInt("index"));
                bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
                bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_SHOW_TITLE_BAR, jSONObject.optBoolean("showTitleBar", true));
                bundle.putString(TroopAvatarWallPreviewActivity.KEY_ACTICLE_INFO_ROWKEY, jSONObject.optString("rowkey"));
                boolean optBoolean = jSONObject.optBoolean("showSocialBottomBar", true);
                bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_SHOW_SOCIAL_BOTTOM_BAR, optBoolean);
                if (optBoolean) {
                    bundle.putString(TroopAvatarWallPreviewActivity.KEY_SHOW_SOCIAL_BOTTOM_BAR_DATA, jSONObject.optJSONObject("socialBottomBar").toString());
                    bundle.putString(TroopAvatarWallPreviewActivity.KEY_CALLBACK_SEQ, String.valueOf(this.seq));
                }
                bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_FROM_TOOL_PROCESS, true);
                Intent intent = new Intent(activity, (Class<?>) TroopAvatarWallPreviewActivity.class);
                intent.putExtras(bundle);
                if (activity != null) {
                    activity.startActivity(intent);
                }
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(com.tencent.biz.troop.b client, i this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(client, "$client");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = bundle.getInt("click_view_type");
        if (i3 == 4) {
            client.l0(this$0.seq);
            return;
        }
        e eVar = e.f435478a;
        String str = this$0.callback;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, i3);
        jSONObject.put("liked", bundle.getBoolean("like_state"));
        Unit unit = Unit.INSTANCE;
        eVar.a(str, 0, "", jSONObject);
    }

    @Override // t62.c
    public boolean a(com.tencent.biz.troop.b client, Activity activity, JsBridgeListener listener, String url, String pkgName, String method, String... args) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        if (activity != null) {
            if (!(args.length == 0)) {
                String str = args[0];
                if (str != null) {
                    c(client, activity, str);
                }
                return true;
            }
        }
        return false;
    }

    @Override // t62.c
    public String getName() {
        return "showPicture";
    }
}
