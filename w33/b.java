package w33;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lw33/b;", "", "", "toString", "", "a", "I", "()I", "result", "b", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String msg;

    public b(int i3, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.result = i3;
        this.msg = msg2;
    }

    /* renamed from: a, reason: from getter */
    public final int getResult() {
        return this.result;
    }

    @NotNull
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", this.result);
            jSONObject.put("message", this.msg);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "resultJson.toString()");
        return jSONObject2;
    }
}
