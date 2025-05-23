package v23;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lv23/b;", "", "Lorg/json/JSONObject;", "a", "", "toString", "", "I", "getErrorCode", "()I", "errorCode", "b", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "errorMsg", "c", "getRetryCount", "retryCount", "<init>", "(ILjava/lang/String;I)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: v23.b, reason: from toString */
/* loaded from: classes20.dex */
public final class Status {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorCode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String errorMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int retryCount;

    public Status(int i3, @NotNull String errorMsg, int i16) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.errorCode = i3;
        this.errorMsg = errorMsg;
        this.retryCount = i16;
    }

    @NotNull
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ec", this.errorCode);
        jSONObject.put("em", this.errorMsg);
        jSONObject.put("rc", this.retryCount);
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "Status(errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', retryCount=" + this.retryCount + ")";
    }

    public /* synthetic */ Status(int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i17 & 4) != 0 ? 0 : i16);
    }
}
