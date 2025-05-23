package sj0;

import com.tenpay.sdk.util.UinConfigManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\f\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lsj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "cookie", "b", "Z", "isEnd", "", "Lorg/json/JSONObject;", "c", "Ljava/util/List;", "()Ljava/util/List;", "settlementBills", "d", "()Ljava/lang/String;", UinConfigManager.KEY_ADS, "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: sj0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECBillModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cookie;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<JSONObject> settlementBills;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String notice;

    /* JADX WARN: Multi-variable type inference failed */
    public ECBillModel(String str, boolean z16, List<? extends JSONObject> list, String str2) {
        this.cookie = str;
        this.isEnd = z16;
        this.settlementBills = list;
        this.notice = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getNotice() {
        return this.notice;
    }

    public final List<JSONObject> b() {
        return this.settlementBills;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.cookie;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z16 = this.isEnd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        List<JSONObject> list = this.settlementBills;
        int hashCode2 = (i16 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.notice;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECBillModel(cookie=" + this.cookie + ", isEnd=" + this.isEnd + ", settlementBills=" + this.settlementBills + ", notice=" + this.notice + ")";
    }

    public /* synthetic */ ECBillModel(String str, boolean z16, List list, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, list, (i3 & 8) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECBillModel)) {
            return false;
        }
        ECBillModel eCBillModel = (ECBillModel) other;
        return Intrinsics.areEqual(this.cookie, eCBillModel.cookie) && this.isEnd == eCBillModel.isEnd && Intrinsics.areEqual(this.settlementBills, eCBillModel.settlementBills) && Intrinsics.areEqual(this.notice, eCBillModel.notice);
    }
}
