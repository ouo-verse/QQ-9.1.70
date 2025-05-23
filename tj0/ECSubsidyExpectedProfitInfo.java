package tj0;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Ltj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "cookie", "b", "Z", "isEnd", "", "Lorg/json/JSONObject;", "c", "Ljava/util/List;", "()Ljava/util/List;", "profitList", "<init>", "(Ljava/lang/String;ZLjava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: tj0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECSubsidyExpectedProfitInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cookie;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isEnd;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<JSONObject> profitList;

    /* JADX WARN: Multi-variable type inference failed */
    public ECSubsidyExpectedProfitInfo(String str, boolean z16, List<? extends JSONObject> list) {
        this.cookie = str;
        this.isEnd = z16;
        this.profitList = list;
    }

    public final List<JSONObject> a() {
        return this.profitList;
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
        List<JSONObject> list = this.profitList;
        return i16 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ECSubsidyExpectedProfitInfo(cookie=" + this.cookie + ", isEnd=" + this.isEnd + ", profitList=" + this.profitList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECSubsidyExpectedProfitInfo)) {
            return false;
        }
        ECSubsidyExpectedProfitInfo eCSubsidyExpectedProfitInfo = (ECSubsidyExpectedProfitInfo) other;
        return Intrinsics.areEqual(this.cookie, eCSubsidyExpectedProfitInfo.cookie) && this.isEnd == eCSubsidyExpectedProfitInfo.isEnd && Intrinsics.areEqual(this.profitList, eCSubsidyExpectedProfitInfo.profitList);
    }
}
