package yk0;

import com.google.gson.annotations.SerializedName;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBY\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lyk0/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "id", "J", "d", "()J", "subState", "I", "f", "()I", "slot", "Ljava/lang/String;", "e", "()Ljava/lang/String;", HippyTKDListViewAdapter.X, "g", "y", h.F, "ctrlX", "a", "ctrlY", "b", "deleted", "Z", "c", "()Z", "<init>", "(JILjava/lang/String;IIIIZ)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: yk0.b, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class DecorateScreenPosition {

    @SerializedName("ctrl_x")
    private final int ctrlX;

    @SerializedName("ctrl_y")
    private final int ctrlY;

    @SerializedName("deleted")
    private final boolean deleted;

    @SerializedName("id")
    private final long id;

    @SerializedName("slot")
    @Nullable
    private final String slot;

    @SerializedName("subState")
    private final int subState;

    @SerializedName(HippyTKDListViewAdapter.X)
    private final int x;

    @SerializedName("y")
    private final int y;

    public DecorateScreenPosition() {
        this(0L, 0, null, 0, 0, 0, 0, false, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCtrlX() {
        return this.ctrlX;
    }

    /* renamed from: b, reason: from getter */
    public final int getCtrlY() {
        return this.ctrlY;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getDeleted() {
        return this.deleted;
    }

    /* renamed from: d, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getSlot() {
        return this.slot;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof DecorateScreenPosition) {
                DecorateScreenPosition decorateScreenPosition = (DecorateScreenPosition) other;
                if (this.id != decorateScreenPosition.id || this.subState != decorateScreenPosition.subState || !Intrinsics.areEqual(this.slot, decorateScreenPosition.slot) || this.x != decorateScreenPosition.x || this.y != decorateScreenPosition.y || this.ctrlX != decorateScreenPosition.ctrlX || this.ctrlY != decorateScreenPosition.ctrlY || this.deleted != decorateScreenPosition.deleted) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final int getSubState() {
        return this.subState;
    }

    /* renamed from: g, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: h, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        long j3 = this.id;
        int i16 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + this.subState) * 31;
        String str = this.slot;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (((((((((i16 + i3) * 31) + this.x) * 31) + this.y) * 31) + this.ctrlX) * 31) + this.ctrlY) * 31;
        boolean z16 = this.deleted;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        return i17 + i18;
    }

    @NotNull
    public String toString() {
        return "DecorateScreenPosition(id=" + this.id + ", subState=" + this.subState + ", slot=" + this.slot + ", x=" + this.x + ", y=" + this.y + ", ctrlX=" + this.ctrlX + ", ctrlY=" + this.ctrlY + ", deleted=" + this.deleted + ")";
    }

    public DecorateScreenPosition(long j3, int i3, @Nullable String str, int i16, int i17, int i18, int i19, boolean z16) {
        this.id = j3;
        this.subState = i3;
        this.slot = str;
        this.x = i16;
        this.y = i17;
        this.ctrlX = i18;
        this.ctrlY = i19;
        this.deleted = z16;
    }

    public /* synthetic */ DecorateScreenPosition(long j3, int i3, String str, int i16, int i17, int i18, int i19, boolean z16, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 0L : j3, (i26 & 2) != 0 ? 0 : i3, (i26 & 4) != 0 ? null : str, (i26 & 8) != 0 ? 0 : i16, (i26 & 16) != 0 ? 0 : i17, (i26 & 32) != 0 ? 0 : i18, (i26 & 64) != 0 ? 0 : i19, (i26 & 128) == 0 ? z16 : false);
    }
}
