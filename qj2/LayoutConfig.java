package qj2;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.videocut.utils.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lqj2/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "panelStartOffset", "", "b", UserInfo.SEX_FEMALE, "getCourseTopMargin", "()F", "courseTopMargin", "c", "getCourseWidth", "courseWidth", "d", "getCourseElevation", "courseElevation", "e", "getCourseColor", "courseColor", "<init>", "(IFFFI)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qj2.b, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class LayoutConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int panelStartOffset;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float courseTopMargin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float courseWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float courseElevation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int courseColor;

    public LayoutConfig() {
        this(0, 0.0f, 0.0f, 0.0f, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getPanelStartOffset() {
        return this.panelStartOffset;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LayoutConfig)) {
            return false;
        }
        LayoutConfig layoutConfig = (LayoutConfig) other;
        if (this.panelStartOffset == layoutConfig.panelStartOffset && Float.compare(this.courseTopMargin, layoutConfig.courseTopMargin) == 0 && Float.compare(this.courseWidth, layoutConfig.courseWidth) == 0 && Float.compare(this.courseElevation, layoutConfig.courseElevation) == 0 && this.courseColor == layoutConfig.courseColor) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.panelStartOffset * 31) + Float.floatToIntBits(this.courseTopMargin)) * 31) + Float.floatToIntBits(this.courseWidth)) * 31) + Float.floatToIntBits(this.courseElevation)) * 31) + this.courseColor;
    }

    @NotNull
    public String toString() {
        return "LayoutConfig(panelStartOffset=" + this.panelStartOffset + ", courseTopMargin=" + this.courseTopMargin + ", courseWidth=" + this.courseWidth + ", courseElevation=" + this.courseElevation + ", courseColor=" + this.courseColor + ")";
    }

    public LayoutConfig(int i3, float f16, float f17, float f18, int i16) {
        this.panelStartOffset = i3;
        this.courseTopMargin = f16;
        this.courseWidth = f17;
        this.courseElevation = f18;
        this.courseColor = i16;
    }

    public /* synthetic */ LayoutConfig(int i3, float f16, float f17, float f18, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? o.g() / 2 : i3, (i17 & 2) != 0 ? 1.0f : f16, (i17 & 4) != 0 ? 3.0f : f17, (i17 & 8) == 0 ? f18 : 3.0f, (i17 & 16) != 0 ? -1 : i16);
    }
}
