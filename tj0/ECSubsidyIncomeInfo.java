package tj0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ltj0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "total", "b", "paidFen", "c", "unPaidFen", "d", "Ljava/lang/String;", "hint", "<init>", "(JJJLjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: tj0.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECSubsidyIncomeInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long total;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final long paidFen;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final long unPaidFen;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String hint;

    public ECSubsidyIncomeInfo(long j3, long j16, long j17, String str) {
        this.total = j3;
        this.paidFen = j16;
        this.unPaidFen = j17;
        this.hint = str;
    }

    public int hashCode() {
        int a16 = ((((com.tencent.ecommerce.biz.commission.forecast.b.a(this.total) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.paidFen)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.unPaidFen)) * 31;
        String str = this.hint;
        return a16 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ECSubsidyIncomeInfo(total=" + this.total + ", paidFen=" + this.paidFen + ", unPaidFen=" + this.unPaidFen + ", hint=" + this.hint + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECSubsidyIncomeInfo)) {
            return false;
        }
        ECSubsidyIncomeInfo eCSubsidyIncomeInfo = (ECSubsidyIncomeInfo) other;
        return this.total == eCSubsidyIncomeInfo.total && this.paidFen == eCSubsidyIncomeInfo.paidFen && this.unPaidFen == eCSubsidyIncomeInfo.unPaidFen && Intrinsics.areEqual(this.hint, eCSubsidyIncomeInfo.hint);
    }
}
