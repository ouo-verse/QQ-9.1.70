package vi0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \u00172\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lvi0/a;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "nickName", "e", "Lorg/json/JSONObject;", "b", "()Lorg/json/JSONObject;", "setToast", "(Lorg/json/JSONObject;)V", "toast", "<init>", "()V", "f", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String nickName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private JSONObject toast = new JSONObject();

    /* renamed from: a, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: b, reason: from getter */
    public final JSONObject getToast() {
        return this.toast;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        if (data == null) {
            return false;
        }
        this.nickName = data.optString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "");
        JSONObject optJSONObject = data.optJSONObject("toast");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.toast = optJSONObject;
        cg0.a.b("ECWxAuthRsp", "[ECWxAuthRsp] nickName = " + this.nickName);
        return true;
    }
}
