package zj0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\f\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0014\u0010 \u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0014\u0010\"\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0011R\u0014\u0010$\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\r\u00a8\u0006%"}, d2 = {"Lzj0/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "type", "b", "Ljava/lang/String;", "name", "", "c", "J", "()J", "setLower", "(J)V", "lower", "d", "lowerText", "e", "setUpper", "upper", "f", "upperText", "g", "unit", h.F, "minLimit", "i", "maxLimit", "j", "errorToast", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: zj0.d, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class RangeCond {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long lower;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String lowerText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long upper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String upperText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String unit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final long minLimit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final long maxLimit;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final String errorToast;

    /* renamed from: a, reason: from getter */
    public final long getLower() {
        return this.lower;
    }

    /* renamed from: b, reason: from getter */
    public final long getUpper() {
        return this.upper;
    }

    public int hashCode() {
        int i3 = this.type * 31;
        String str = this.name;
        int hashCode = (((i3 + (str != null ? str.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.lower)) * 31;
        String str2 = this.lowerText;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.upper)) * 31;
        String str3 = this.upperText;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.unit;
        int hashCode4 = (((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.minLimit)) * 31) + com.tencent.ecommerce.biz.commission.forecast.b.a(this.maxLimit)) * 31;
        String str5 = this.errorToast;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "RangeCond(type=" + this.type + ", name=" + this.name + ", lower=" + this.lower + ", lowerText=" + this.lowerText + ", upper=" + this.upper + ", upperText=" + this.upperText + ", unit=" + this.unit + ", minLimit=" + this.minLimit + ", maxLimit=" + this.maxLimit + ", errorToast=" + this.errorToast + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RangeCond)) {
            return false;
        }
        RangeCond rangeCond = (RangeCond) other;
        return this.type == rangeCond.type && Intrinsics.areEqual(this.name, rangeCond.name) && this.lower == rangeCond.lower && Intrinsics.areEqual(this.lowerText, rangeCond.lowerText) && this.upper == rangeCond.upper && Intrinsics.areEqual(this.upperText, rangeCond.upperText) && Intrinsics.areEqual(this.unit, rangeCond.unit) && this.minLimit == rangeCond.minLimit && this.maxLimit == rangeCond.maxLimit && Intrinsics.areEqual(this.errorToast, rangeCond.errorToast);
    }
}
