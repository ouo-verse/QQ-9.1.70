package qh0;

import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lqh0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "iconToken", "b", "Ljava/lang/String;", "text", "c", ZPlanPublishSource.FROM_SCHEME, "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: qh0.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ECMyShoppingActionSheetItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int iconToken;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String scheme;

    public ECMyShoppingActionSheetItemData(int i3, String str, String str2) {
        this.iconToken = i3;
        this.text = str;
        this.scheme = str2;
    }

    public int hashCode() {
        int i3 = this.iconToken * 31;
        String str = this.text;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.scheme;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECMyShoppingActionSheetItemData(iconToken=" + this.iconToken + ", text=" + this.text + ", scheme=" + this.scheme + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECMyShoppingActionSheetItemData)) {
            return false;
        }
        ECMyShoppingActionSheetItemData eCMyShoppingActionSheetItemData = (ECMyShoppingActionSheetItemData) other;
        return this.iconToken == eCMyShoppingActionSheetItemData.iconToken && Intrinsics.areEqual(this.text, eCMyShoppingActionSheetItemData.text) && Intrinsics.areEqual(this.scheme, eCMyShoppingActionSheetItemData.scheme);
    }
}
