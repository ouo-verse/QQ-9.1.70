package wk3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lwk3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "portraitId", "I", "e", "()I", "width", "g", "height", "c", "mode", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "backgroundColor", "a", "theme", "f", "frameType", "b", "<init>", "(IIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wk3.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PortalStoreDressUpRecordParamConfig {

    @SerializedName("backgroundColor")
    private final int backgroundColor;

    @SerializedName("frameType")
    @NotNull
    private final String frameType;

    @SerializedName("height")
    private final int height;

    @SerializedName("mode")
    @NotNull
    private final String mode;

    @SerializedName("portraitId")
    private final int portraitId;

    @SerializedName("theme")
    @NotNull
    private final String theme;

    @SerializedName("width")
    private final int width;

    public PortalStoreDressUpRecordParamConfig() {
        this(0, 0, 0, null, 0, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getFrameType() {
        return this.frameType;
    }

    /* renamed from: c, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: e, reason: from getter */
    public final int getPortraitId() {
        return this.portraitId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PortalStoreDressUpRecordParamConfig)) {
            return false;
        }
        PortalStoreDressUpRecordParamConfig portalStoreDressUpRecordParamConfig = (PortalStoreDressUpRecordParamConfig) other;
        if (this.portraitId == portalStoreDressUpRecordParamConfig.portraitId && this.width == portalStoreDressUpRecordParamConfig.width && this.height == portalStoreDressUpRecordParamConfig.height && Intrinsics.areEqual(this.mode, portalStoreDressUpRecordParamConfig.mode) && this.backgroundColor == portalStoreDressUpRecordParamConfig.backgroundColor && Intrinsics.areEqual(this.theme, portalStoreDressUpRecordParamConfig.theme) && Intrinsics.areEqual(this.frameType, portalStoreDressUpRecordParamConfig.frameType)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    /* renamed from: g, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((((this.portraitId * 31) + this.width) * 31) + this.height) * 31) + this.mode.hashCode()) * 31) + this.backgroundColor) * 31) + this.theme.hashCode()) * 31) + this.frameType.hashCode();
    }

    @NotNull
    public String toString() {
        return "PortalStoreDressUpRecordParamConfig(portraitId=" + this.portraitId + ", width=" + this.width + ", height=" + this.height + ", mode=" + this.mode + ", backgroundColor=" + this.backgroundColor + ", theme=" + this.theme + ", frameType=" + this.frameType + ')';
    }

    public PortalStoreDressUpRecordParamConfig(int i3, int i16, int i17, @NotNull String mode, int i18, @NotNull String theme, @NotNull String frameType) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        this.portraitId = i3;
        this.width = i16;
        this.height = i17;
        this.mode = mode;
        this.backgroundColor = i18;
        this.theme = theme;
        this.frameType = frameType;
    }

    public /* synthetic */ PortalStoreDressUpRecordParamConfig(int i3, int i16, int i17, String str, int i18, String str2, String str3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? 6389 : i3, (i19 & 2) != 0 ? 270 : i16, (i19 & 4) != 0 ? 450 : i17, (i19 & 8) != 0 ? "FRAME" : str, (i19 & 16) != 0 ? 0 : i18, (i19 & 32) != 0 ? "DAY" : str2, (i19 & 64) != 0 ? "PNG" : str3);
    }
}
