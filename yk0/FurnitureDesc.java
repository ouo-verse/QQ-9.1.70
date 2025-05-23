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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017Bo\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011R\u001a\u0010 \u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001a\u0010\"\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R\u001a\u0010$\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011\u00a8\u0006("}, d2 = {"Lyk0/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "id", "J", "d", "()J", "subState", "I", "f", "()I", "slot", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "condition", "a", "error", "c", "deleted", "Z", "b", "()Z", HippyTKDListViewAdapter.X, "g", "y", h.F, "ctrlX", "getCtrlX", "ctrlY", "getCtrlY", "<init>", "(JILjava/lang/String;Ljava/lang/String;IZIIII)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: yk0.c, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class FurnitureDesc {

    @SerializedName("condition")
    @Nullable
    private final String condition;

    @SerializedName("ctrl_x")
    private final int ctrlX;

    @SerializedName("ctrl_y")
    private final int ctrlY;

    @SerializedName("deleted")
    private final boolean deleted;

    @SerializedName("error")
    private final int error;

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

    public FurnitureDesc() {
        this(0L, 0, null, null, 0, false, 0, 0, 0, 0, 1023, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCondition() {
        return this.condition;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getDeleted() {
        return this.deleted;
    }

    /* renamed from: c, reason: from getter */
    public final int getError() {
        return this.error;
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
            if (other instanceof FurnitureDesc) {
                FurnitureDesc furnitureDesc = (FurnitureDesc) other;
                if (this.id != furnitureDesc.id || this.subState != furnitureDesc.subState || !Intrinsics.areEqual(this.slot, furnitureDesc.slot) || !Intrinsics.areEqual(this.condition, furnitureDesc.condition) || this.error != furnitureDesc.error || this.deleted != furnitureDesc.deleted || this.x != furnitureDesc.x || this.y != furnitureDesc.y || this.ctrlX != furnitureDesc.ctrlX || this.ctrlY != furnitureDesc.ctrlY) {
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
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        String str2 = this.condition;
        if (str2 != null) {
            i17 = str2.hashCode();
        }
        int i19 = (((i18 + i17) * 31) + this.error) * 31;
        boolean z16 = this.deleted;
        int i26 = z16;
        if (z16 != 0) {
            i26 = 1;
        }
        return ((((((((i19 + i26) * 31) + this.x) * 31) + this.y) * 31) + this.ctrlX) * 31) + this.ctrlY;
    }

    @NotNull
    public String toString() {
        return "FurnitureDesc(id=" + this.id + ", subState=" + this.subState + ", slot=" + this.slot + ", condition=" + this.condition + ", error=" + this.error + ", deleted=" + this.deleted + ", x=" + this.x + ", y=" + this.y + ", ctrlX=" + this.ctrlX + ", ctrlY=" + this.ctrlY + ")";
    }

    public FurnitureDesc(long j3, int i3, @Nullable String str, @Nullable String str2, int i16, boolean z16, int i17, int i18, int i19, int i26) {
        this.id = j3;
        this.subState = i3;
        this.slot = str;
        this.condition = str2;
        this.error = i16;
        this.deleted = z16;
        this.x = i17;
        this.y = i18;
        this.ctrlX = i19;
        this.ctrlY = i26;
    }

    public /* synthetic */ FurnitureDesc(long j3, int i3, String str, String str2, int i16, boolean z16, int i17, int i18, int i19, int i26, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? 0L : j3, (i27 & 2) != 0 ? 0 : i3, (i27 & 4) != 0 ? null : str, (i27 & 8) == 0 ? str2 : null, (i27 & 16) != 0 ? 0 : i16, (i27 & 32) != 0 ? false : z16, (i27 & 64) != 0 ? 0 : i17, (i27 & 128) != 0 ? 0 : i18, (i27 & 256) != 0 ? 0 : i19, (i27 & 512) == 0 ? i26 : 0);
    }
}
