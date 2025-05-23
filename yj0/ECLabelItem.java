package yj0;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\n\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lyj0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "labelName", "b", "getLabelMsg", "()Ljava/lang/String;", "labelMsg", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: yj0.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECLabelItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String labelName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String labelMsg;

    public ECLabelItem() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public int hashCode() {
        String str = this.labelName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.labelMsg;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECLabelItem(labelName=" + this.labelName + ", labelMsg=" + this.labelMsg + ")";
    }

    public ECLabelItem(String str, String str2) {
        this.labelName = str;
        this.labelMsg = str2;
    }

    public /* synthetic */ ECLabelItem(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECLabelItem)) {
            return false;
        }
        ECLabelItem eCLabelItem = (ECLabelItem) other;
        return Intrinsics.areEqual(this.labelName, eCLabelItem.labelName) && Intrinsics.areEqual(this.labelMsg, eCLabelItem.labelMsg);
    }
}
