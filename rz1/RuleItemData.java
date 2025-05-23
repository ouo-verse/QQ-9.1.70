package rz1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lrz1/e;", "Lrz1/b;", "newItem", "", "b", "", "toString", "", "hashCode", "", "other", "equals", "I", "d", "()I", "order", "Lrz1/d;", "c", "Lrz1/d;", "e", "()Lrz1/d;", "ruleData", "<init>", "(ILrz1/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rz1.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RuleItemData extends b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int order;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RuleData ruleData;

    public RuleItemData(int i3, @NotNull RuleData ruleData) {
        Intrinsics.checkNotNullParameter(ruleData, "ruleData");
        this.order = i3;
        this.ruleData = ruleData;
    }

    @Override // rz1.b
    public boolean b(@NotNull b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof RuleItemData) && this.ruleData.getOriginOrder() == ((RuleItemData) newItem).ruleData.getOriginOrder()) {
            return true;
        }
        return false;
    }

    /* renamed from: d, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final RuleData getRuleData() {
        return this.ruleData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleItemData)) {
            return false;
        }
        RuleItemData ruleItemData = (RuleItemData) other;
        if (this.order == ruleItemData.order && Intrinsics.areEqual(this.ruleData, ruleItemData.ruleData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.order * 31) + this.ruleData.hashCode();
    }

    @NotNull
    public String toString() {
        return "RuleItemData(order=" + this.order + ", ruleData=" + this.ruleData + ")";
    }
}
