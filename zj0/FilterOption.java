package zj0;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lzj0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "optionId", "b", "Ljava/lang/String;", "optionName", "c", "shortName", "d", "Z", "mutex", "e", "default", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: zj0.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class FilterOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int optionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String optionName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String shortName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean mutex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean default;

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.optionId * 31;
        String str = this.optionName;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.shortName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.mutex;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        boolean z17 = this.default;
        return i17 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "FilterOption(optionId=" + this.optionId + ", optionName=" + this.optionName + ", shortName=" + this.shortName + ", mutex=" + this.mutex + ", default=" + this.default + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterOption)) {
            return false;
        }
        FilterOption filterOption = (FilterOption) other;
        return this.optionId == filterOption.optionId && Intrinsics.areEqual(this.optionName, filterOption.optionName) && Intrinsics.areEqual(this.shortName, filterOption.shortName) && this.mutex == filterOption.mutex && this.default == filterOption.default;
    }
}
