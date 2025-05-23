package t62;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\u0003B#\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lt62/d;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "hashCode", "other", "", "equals", "I", "getRetCode", "()I", "setRetCode", "(I)V", "retCode", "b", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "msg", "c", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "data", "<init>", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "d", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: t62.d, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class JsMethodModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int retCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private JSONObject data;

    public JsMethodModel(int i3, String msg2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.retCode = i3;
        this.msg = msg2;
        this.data = jSONObject;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", this.retCode);
            jSONObject.put("msg", this.msg);
            JSONObject jSONObject2 = this.data;
            if (jSONObject2 != null) {
                jSONObject.put("data", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public int hashCode() {
        int hashCode = ((this.retCode * 31) + this.msg.hashCode()) * 31;
        JSONObject jSONObject = this.data;
        return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        return "JsMethodModel(retCode=" + this.retCode + ", msg=" + this.msg + ", data=" + this.data + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JsMethodModel)) {
            return false;
        }
        JsMethodModel jsMethodModel = (JsMethodModel) other;
        return this.retCode == jsMethodModel.retCode && Intrinsics.areEqual(this.msg, jsMethodModel.msg) && Intrinsics.areEqual(this.data, jsMethodModel.data);
    }
}
