package yg1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lyg1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "platformType", "b", "platformIcon", "Ljava/lang/String;", "()Ljava/lang/String;", "platformName", "<init>", "(IILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yg1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class ItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int platformType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int platformIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String platformName;

    public ItemData(int i3, int i16, @NotNull String platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        this.platformType = i3;
        this.platformIcon = i16;
        this.platformName = platformName;
    }

    /* renamed from: a, reason: from getter */
    public final int getPlatformIcon() {
        return this.platformIcon;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPlatformName() {
        return this.platformName;
    }

    /* renamed from: c, reason: from getter */
    public final int getPlatformType() {
        return this.platformType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemData)) {
            return false;
        }
        ItemData itemData = (ItemData) other;
        if (this.platformType == itemData.platformType && this.platformIcon == itemData.platformIcon && Intrinsics.areEqual(this.platformName, itemData.platformName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.platformType * 31) + this.platformIcon) * 31) + this.platformName.hashCode();
    }

    @NotNull
    public String toString() {
        return "ItemData(platformType=" + this.platformType + ", platformIcon=" + this.platformIcon + ", platformName=" + this.platformName + ")";
    }
}
