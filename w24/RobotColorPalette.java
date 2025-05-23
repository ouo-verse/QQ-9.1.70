package w24;

import com.huawei.hms.framework.common.EmuiUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\t\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lw24/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "profileId", "b", "I", EmuiUtil.GET_PRIMARY_COLOR, "()I", "primaryColor", "colorType", "d", "Z", "()Z", "isDark", "Lae0/a;", "e", "Lae0/a;", "()Lae0/a;", "colorPalette", "<init>", "(Ljava/lang/String;IIZLae0/a;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: w24.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotColorPalette {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String profileId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int primaryColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int colorType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDark;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ae0.a colorPalette;

    public RobotColorPalette(@NotNull String profileId, int i3, int i16, boolean z16, @NotNull ae0.a colorPalette) {
        Intrinsics.checkNotNullParameter(profileId, "profileId");
        Intrinsics.checkNotNullParameter(colorPalette, "colorPalette");
        this.profileId = profileId;
        this.primaryColor = i3;
        this.colorType = i16;
        this.isDark = z16;
        this.colorPalette = colorPalette;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ae0.a getColorPalette() {
        return this.colorPalette;
    }

    /* renamed from: b, reason: from getter */
    public final int getColorType() {
        return this.colorType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getProfileId() {
        return this.profileId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsDark() {
        return this.isDark;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotColorPalette)) {
            return false;
        }
        RobotColorPalette robotColorPalette = (RobotColorPalette) other;
        if (Intrinsics.areEqual(this.profileId, robotColorPalette.profileId) && this.primaryColor == robotColorPalette.primaryColor && this.colorType == robotColorPalette.colorType && this.isDark == robotColorPalette.isDark && Intrinsics.areEqual(this.colorPalette, robotColorPalette.colorPalette)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.profileId.hashCode() * 31) + this.primaryColor) * 31) + this.colorType) * 31;
        boolean z16 = this.isDark;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.colorPalette.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotColorPalette(profileId=" + this.profileId + ", primaryColor=" + this.primaryColor + ", colorType=" + this.colorType + ", isDark=" + this.isDark + ", colorPalette=" + this.colorPalette + ")";
    }
}
