package qo3;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB/\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lqo3/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getScaleStyle", "()I", "scaleStyle", "b", "d", "realScaleWidth", "c", "realScaleHeight", "cropLeft", "e", "cropTop", "<init>", "(IIIII)V", "f", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qo3.c, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class VideoScaleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int scaleStyle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int realScaleWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int realScaleHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cropLeft;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int cropTop;

    public VideoScaleData(int i3, int i16, int i17, int i18, int i19) {
        this.scaleStyle = i3;
        this.realScaleWidth = i16;
        this.realScaleHeight = i17;
        this.cropLeft = i18;
        this.cropTop = i19;
    }

    /* renamed from: a, reason: from getter */
    public final int getCropLeft() {
        return this.cropLeft;
    }

    /* renamed from: b, reason: from getter */
    public final int getCropTop() {
        return this.cropTop;
    }

    /* renamed from: c, reason: from getter */
    public final int getRealScaleHeight() {
        return this.realScaleHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getRealScaleWidth() {
        return this.realScaleWidth;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoScaleData)) {
            return false;
        }
        VideoScaleData videoScaleData = (VideoScaleData) other;
        if (this.scaleStyle == videoScaleData.scaleStyle && this.realScaleWidth == videoScaleData.realScaleWidth && this.realScaleHeight == videoScaleData.realScaleHeight && this.cropLeft == videoScaleData.cropLeft && this.cropTop == videoScaleData.cropTop) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.scaleStyle * 31) + this.realScaleWidth) * 31) + this.realScaleHeight) * 31) + this.cropLeft) * 31) + this.cropTop;
    }

    @NotNull
    public String toString() {
        return "VideoScaleData(scaleStyle=" + this.scaleStyle + ", realScaleWidth=" + this.realScaleWidth + ", realScaleHeight=" + this.realScaleHeight + ", cropLeft=" + this.cropLeft + ", cropTop=" + this.cropTop + ")";
    }
}
