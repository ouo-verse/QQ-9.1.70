package qj2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0014\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lqj2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lqj2/c;", "a", "Lqj2/c;", "b", "()Lqj2/c;", "scrollConfig", "Lqj2/b;", "Lqj2/b;", "()Lqj2/b;", "layoutConfig", "Lqj2/e;", "c", "Lqj2/e;", "d", "()Lqj2/e;", "videoTrackConfig", "Lqj2/d;", "Lqj2/d;", "()Lqj2/d;", "timeBarConfig", "<init>", "(Lqj2/c;Lqj2/b;Lqj2/e;Lqj2/d;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: qj2.a, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class CommonConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ScrollConfig scrollConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LayoutConfig layoutConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final VideoTrackConfig videoTrackConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TimeBarConfig timeBarConfig;

    public CommonConfig() {
        this(null, null, null, null, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final LayoutConfig getLayoutConfig() {
        return this.layoutConfig;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final ScrollConfig getScrollConfig() {
        return this.scrollConfig;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final TimeBarConfig getTimeBarConfig() {
        return this.timeBarConfig;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final VideoTrackConfig getVideoTrackConfig() {
        return this.videoTrackConfig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonConfig)) {
            return false;
        }
        CommonConfig commonConfig = (CommonConfig) other;
        if (Intrinsics.areEqual(this.scrollConfig, commonConfig.scrollConfig) && Intrinsics.areEqual(this.layoutConfig, commonConfig.layoutConfig) && Intrinsics.areEqual(this.videoTrackConfig, commonConfig.videoTrackConfig) && Intrinsics.areEqual(this.timeBarConfig, commonConfig.timeBarConfig)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.scrollConfig.hashCode() * 31) + this.layoutConfig.hashCode()) * 31) + this.videoTrackConfig.hashCode()) * 31) + this.timeBarConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "CommonConfig(scrollConfig=" + this.scrollConfig + ", layoutConfig=" + this.layoutConfig + ", videoTrackConfig=" + this.videoTrackConfig + ", timeBarConfig=" + this.timeBarConfig + ")";
    }

    public CommonConfig(@NotNull ScrollConfig scrollConfig, @NotNull LayoutConfig layoutConfig, @NotNull VideoTrackConfig videoTrackConfig, @NotNull TimeBarConfig timeBarConfig) {
        Intrinsics.checkNotNullParameter(scrollConfig, "scrollConfig");
        Intrinsics.checkNotNullParameter(layoutConfig, "layoutConfig");
        Intrinsics.checkNotNullParameter(videoTrackConfig, "videoTrackConfig");
        Intrinsics.checkNotNullParameter(timeBarConfig, "timeBarConfig");
        this.scrollConfig = scrollConfig;
        this.layoutConfig = layoutConfig;
        this.videoTrackConfig = videoTrackConfig;
        this.timeBarConfig = timeBarConfig;
    }

    public /* synthetic */ CommonConfig(ScrollConfig scrollConfig, LayoutConfig layoutConfig, VideoTrackConfig videoTrackConfig, TimeBarConfig timeBarConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ScrollConfig(0.0f, 1, null) : scrollConfig, (i3 & 2) != 0 ? new LayoutConfig(0, 0.0f, 0.0f, 0.0f, 0, 31, null) : layoutConfig, (i3 & 4) != 0 ? new VideoTrackConfig(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 127, null) : videoTrackConfig, (i3 & 8) != 0 ? new TimeBarConfig(0.0f, 0.0f, 3, null) : timeBarConfig);
    }
}
