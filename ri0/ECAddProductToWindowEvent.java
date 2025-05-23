package ri0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lri0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isAdded", "b", "Ljava/lang/String;", "saasProductId", "c", "mediaProductId", "Lorg/json/JSONObject;", "d", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "productInfo", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ri0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECAddProductToWindowEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isAdded;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String saasProductId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String mediaProductId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final JSONObject productInfo;

    public ECAddProductToWindowEvent(boolean z16, String str, String str2, JSONObject jSONObject) {
        this.isAdded = z16;
        this.saasProductId = str;
        this.mediaProductId = str2;
        this.productInfo = jSONObject;
    }

    /* renamed from: a, reason: from getter */
    public final JSONObject getProductInfo() {
        return this.productInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z16 = this.isAdded;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.saasProductId;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mediaProductId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.productInfo;
        return hashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ECAddProductToWindowEvent(isAdded=" + this.isAdded + ", saasProductId=" + this.saasProductId + ", mediaProductId=" + this.mediaProductId + ", productInfo=" + this.productInfo + ")";
    }

    public /* synthetic */ ECAddProductToWindowEvent(boolean z16, String str, String str2, JSONObject jSONObject, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? new JSONObject() : jSONObject);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECAddProductToWindowEvent)) {
            return false;
        }
        ECAddProductToWindowEvent eCAddProductToWindowEvent = (ECAddProductToWindowEvent) other;
        return this.isAdded == eCAddProductToWindowEvent.isAdded && Intrinsics.areEqual(this.saasProductId, eCAddProductToWindowEvent.saasProductId) && Intrinsics.areEqual(this.mediaProductId, eCAddProductToWindowEvent.mediaProductId) && Intrinsics.areEqual(this.productInfo, eCAddProductToWindowEvent.productInfo);
    }
}
