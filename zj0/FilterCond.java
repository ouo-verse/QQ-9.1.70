package zj0;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lzj0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "type", "b", "Ljava/lang/String;", "name", "", "Lzj0/b;", "c", "Ljava/util/List;", "()Ljava/util/List;", "filterOptions", "d", "Z", ProcessConstant.MULTI, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: zj0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class FilterCond {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<FilterOption> filterOptions;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean multi;

    public final List<FilterOption> a() {
        return this.filterOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.type * 31;
        String str = this.name;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        List<FilterOption> list = this.filterOptions;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z16 = this.multi;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return hashCode2 + i16;
    }

    public String toString() {
        return "FilterCond(type=" + this.type + ", name=" + this.name + ", filterOptions=" + this.filterOptions + ", multi=" + this.multi + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterCond)) {
            return false;
        }
        FilterCond filterCond = (FilterCond) other;
        return this.type == filterCond.type && Intrinsics.areEqual(this.name, filterCond.name) && Intrinsics.areEqual(this.filterOptions, filterCond.filterOptions) && this.multi == filterCond.multi;
    }
}
