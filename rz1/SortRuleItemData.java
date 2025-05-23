package rz1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lrz1/f;", "Lrz1/b;", "newItem", "", "b", "", "c", "", "toString", "", "hashCode", "other", "equals", "I", "d", "()I", "order", "Lrz1/d;", "Lrz1/d;", "e", "()Lrz1/d;", "ruleData", "<init>", "(ILrz1/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rz1.f, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SortRuleItemData extends b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int order;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RuleData ruleData;

    public SortRuleItemData(int i3, @NotNull RuleData ruleData) {
        Intrinsics.checkNotNullParameter(ruleData, "ruleData");
        this.order = i3;
        this.ruleData = ruleData;
    }

    @Override // rz1.b
    public boolean b(@NotNull b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if ((newItem instanceof SortRuleItemData) && this.ruleData.getOriginOrder() == ((SortRuleItemData) newItem).ruleData.getOriginOrder()) {
            return true;
        }
        return false;
    }

    @Override // rz1.b
    @Nullable
    public Object c(@NotNull b newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof SortRuleItemData)) {
            return null;
        }
        SortRuleItemData sortRuleItemData = (SortRuleItemData) newItem;
        if (!Intrinsics.areEqual(this.ruleData, sortRuleItemData.ruleData) || this.order == sortRuleItemData.order) {
            return null;
        }
        return 1;
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
        if (!(other instanceof SortRuleItemData)) {
            return false;
        }
        SortRuleItemData sortRuleItemData = (SortRuleItemData) other;
        if (this.order == sortRuleItemData.order && Intrinsics.areEqual(this.ruleData, sortRuleItemData.ruleData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.order * 31) + this.ruleData.hashCode();
    }

    @NotNull
    public String toString() {
        return "SortRuleItemData(order=" + this.order + ", ruleData=" + this.ruleData + ")";
    }
}
