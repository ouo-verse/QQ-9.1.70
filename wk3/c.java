package wk3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lwk3/c;", "", "", "toString", "", "enableZPlanBirthdayCareRecord", "Z", "d", "()Z", "", "actionId", "I", "a", "()I", "width", tl.h.F, "height", "e", "useFilament", "g", "actionStyle", "b", "disableGlassesMetallic", "c", "needUpload", "f", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    @SerializedName("enableZPlanBirthdayCareRecord")
    private final boolean enableZPlanBirthdayCareRecord;

    @SerializedName("actionId")
    private final int actionId = 6204;

    @SerializedName("width")
    private final int width = 750;

    @SerializedName("height")
    private final int height = 1400;

    @SerializedName("useFilament")
    private final boolean useFilament = true;

    @SerializedName("actionStyle")
    private final int actionStyle = 1;

    @SerializedName("disableGlassesMetallic")
    private final boolean disableGlassesMetallic = true;

    @SerializedName("needUpload")
    private final boolean needUpload = true;

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    /* renamed from: b, reason: from getter */
    public final int getActionStyle() {
        return this.actionStyle;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getDisableGlassesMetallic() {
        return this.disableGlassesMetallic;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnableZPlanBirthdayCareRecord() {
        return this.enableZPlanBirthdayCareRecord;
    }

    /* renamed from: e, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getNeedUpload() {
        return this.needUpload;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getUseFilament() {
        return this.useFilament;
    }

    /* renamed from: h, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public String toString() {
        return "ZPlanBirthdayCareRecordConfig, enableZPlanBirthdayCareRecord: " + this.enableZPlanBirthdayCareRecord + "actionId: " + this.actionId + ", width: " + this.width + ", height: " + this.height + ", useFila: " + this.useFilament + ", actionStyle: " + this.actionStyle + ", disableGlassesMetallic: " + this.disableGlassesMetallic + "\uff0c needUpload: " + this.needUpload;
    }
}
