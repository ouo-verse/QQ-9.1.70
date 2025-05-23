package qj2;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0015\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001b\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lqj2/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "getThumbWidth", "()F", "thumbWidth", "b", "getThumbHeight", "thumbHeight", "c", "singleShowThumbWidth", "d", "videoTrackMargin", "e", "getTransitionViewWidth", "transitionViewWidth", "f", "getTransitionViewHeight", "transitionViewHeight", "g", "Z", "getShowTopDurationTag", "()Z", "showTopDurationTag", "<init>", "(FFFFFFZ)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qj2.e, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class VideoTrackConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final float thumbWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float thumbHeight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final float singleShowThumbWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float videoTrackMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float transitionViewWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float transitionViewHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean showTopDurationTag;

    public VideoTrackConfig() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final float getSingleShowThumbWidth() {
        return this.singleShowThumbWidth;
    }

    /* renamed from: b, reason: from getter */
    public final float getVideoTrackMargin() {
        return this.videoTrackMargin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoTrackConfig)) {
            return false;
        }
        VideoTrackConfig videoTrackConfig = (VideoTrackConfig) other;
        if (Float.compare(this.thumbWidth, videoTrackConfig.thumbWidth) == 0 && Float.compare(this.thumbHeight, videoTrackConfig.thumbHeight) == 0 && Float.compare(this.singleShowThumbWidth, videoTrackConfig.singleShowThumbWidth) == 0 && Float.compare(this.videoTrackMargin, videoTrackConfig.videoTrackMargin) == 0 && Float.compare(this.transitionViewWidth, videoTrackConfig.transitionViewWidth) == 0 && Float.compare(this.transitionViewHeight, videoTrackConfig.transitionViewHeight) == 0 && this.showTopDurationTag == videoTrackConfig.showTopDurationTag) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((((((((((Float.floatToIntBits(this.thumbWidth) * 31) + Float.floatToIntBits(this.thumbHeight)) * 31) + Float.floatToIntBits(this.singleShowThumbWidth)) * 31) + Float.floatToIntBits(this.videoTrackMargin)) * 31) + Float.floatToIntBits(this.transitionViewWidth)) * 31) + Float.floatToIntBits(this.transitionViewHeight)) * 31;
        boolean z16 = this.showTopDurationTag;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return floatToIntBits + i3;
    }

    @NotNull
    public String toString() {
        return "VideoTrackConfig(thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", singleShowThumbWidth=" + this.singleShowThumbWidth + ", videoTrackMargin=" + this.videoTrackMargin + ", transitionViewWidth=" + this.transitionViewWidth + ", transitionViewHeight=" + this.transitionViewHeight + ", showTopDurationTag=" + this.showTopDurationTag + ")";
    }

    public VideoTrackConfig(float f16, float f17, float f18, float f19, float f26, float f27, boolean z16) {
        this.thumbWidth = f16;
        this.thumbHeight = f17;
        this.singleShowThumbWidth = f18;
        this.videoTrackMargin = f19;
        this.transitionViewWidth = f26;
        this.transitionViewHeight = f27;
        this.showTopDurationTag = z16;
    }

    public /* synthetic */ VideoTrackConfig(float f16, float f17, float f18, float f19, float f26, float f27, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 26.0f : f16, (i3 & 2) != 0 ? 43.0f : f17, (i3 & 4) == 0 ? f18 : 26.0f, (i3 & 8) != 0 ? 2.0f : f19, (i3 & 16) != 0 ? 22.0f : f26, (i3 & 32) != 0 ? 22.0f : f27, (i3 & 64) != 0 ? false : z16);
    }
}
