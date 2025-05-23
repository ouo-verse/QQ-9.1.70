package vi0;

import com.tencent.ecommerce.base.network.api.IECRequest;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lvi0/b;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", "authCode", "<init>", "(Ljava/lang/String;)V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class b implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String authCode;

    public b(String str) {
        this.authCode = str;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", this.authCode);
            cg0.a.b("ECWxAuthoReq", "[sendAuthCode]  = " + this.authCode);
            return jSONObject;
        } catch (JSONException e16) {
            cg0.a.a("ECWxAuthoReq", "encodeParams", "[encodeParams] error = " + e16);
            return null;
        }
    }
}
