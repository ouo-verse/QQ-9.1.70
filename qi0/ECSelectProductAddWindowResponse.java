package qi0;

import cj0.a;
import com.tencent.ecommerce.biz.commission.forecast.b;
import com.tencent.ecommerce.biz.showwindow.repo.window.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001f\u001a\u0004\b\u0017\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lqi0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "productId", "", "J", "()J", "setMediaProductId", "(J)V", "mediaProductId", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "c", "Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "d", "()Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;", "setResult", "(Lcom/tencent/ecommerce/biz/showwindow/repo/window/k;)V", "result", "Lcj0/a$b;", "Lcj0/a$b;", "()Lcj0/a$b;", "setRespMsgInfo", "(Lcj0/a$b;)V", "respMsgInfo", "<init>", "(Ljava/lang/String;JLcom/tencent/ecommerce/biz/showwindow/repo/window/k;Lcj0/a$b;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: qi0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECSelectProductAddWindowResponse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String productId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long mediaProductId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private k result;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private a.b respMsgInfo;

    public ECSelectProductAddWindowResponse() {
        this(null, 0L, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getMediaProductId() {
        return this.mediaProductId;
    }

    /* renamed from: b, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: c, reason: from getter */
    public final a.b getRespMsgInfo() {
        return this.respMsgInfo;
    }

    /* renamed from: d, reason: from getter */
    public final k getResult() {
        return this.result;
    }

    public int hashCode() {
        String str = this.productId;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + b.a(this.mediaProductId)) * 31;
        k kVar = this.result;
        int hashCode2 = (hashCode + (kVar != null ? kVar.hashCode() : 0)) * 31;
        a.b bVar = this.respMsgInfo;
        return hashCode2 + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "ECSelectProductAddWindowResponse(productId=" + this.productId + ", mediaProductId=" + this.mediaProductId + ", result=" + this.result + ", respMsgInfo=" + this.respMsgInfo + ")";
    }

    public ECSelectProductAddWindowResponse(String str, long j3, k kVar, a.b bVar) {
        this.productId = str;
        this.mediaProductId = j3;
        this.result = kVar;
        this.respMsgInfo = bVar;
    }

    public /* synthetic */ ECSelectProductAddWindowResponse(String str, long j3, k kVar, a.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? null : kVar, (i3 & 8) != 0 ? null : bVar);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECSelectProductAddWindowResponse)) {
            return false;
        }
        ECSelectProductAddWindowResponse eCSelectProductAddWindowResponse = (ECSelectProductAddWindowResponse) other;
        return Intrinsics.areEqual(this.productId, eCSelectProductAddWindowResponse.productId) && this.mediaProductId == eCSelectProductAddWindowResponse.mediaProductId && Intrinsics.areEqual(this.result, eCSelectProductAddWindowResponse.result) && Intrinsics.areEqual(this.respMsgInfo, eCSelectProductAddWindowResponse.respMsgInfo);
    }
}
