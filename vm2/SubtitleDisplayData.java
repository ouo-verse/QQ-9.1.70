package vm2;

import android.content.Context;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.view.video.VideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b\t\u0010!R\u0017\u0010&\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b\u0014\u0010%R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b\u001a\u0010(\u00a8\u0006,"}, d2 = {"Lvm2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "playUrl", "Lcom/tencent/mobileqq/richmediabrowser/model/AIOVideoData;", "Lcom/tencent/mobileqq/richmediabrowser/model/AIOVideoData;", "e", "()Lcom/tencent/mobileqq/richmediabrowser/model/AIOVideoData;", "videoData", "Lcom/tencent/mobileqq/richmediabrowser/presenter/f;", "c", "Lcom/tencent/mobileqq/richmediabrowser/presenter/f;", "f", "()Lcom/tencent/mobileqq/richmediabrowser/presenter/f;", "videoPresenter", "Lcom/tencent/richmediabrowser/view/video/VideoView;", "d", "Lcom/tencent/richmediabrowser/view/video/VideoView;", "g", "()Lcom/tencent/richmediabrowser/view/video/VideoView;", "videoView", "Landroid/content/Context;", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "()Ljava/lang/Runnable;", "showSubtitleTimeoutRunnable", "I", "()I", "timeout", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/richmediabrowser/model/AIOVideoData;Lcom/tencent/mobileqq/richmediabrowser/presenter/f;Lcom/tencent/richmediabrowser/view/video/VideoView;Landroid/content/Context;Ljava/lang/Runnable;I)V", "qq-richmediabrowser-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vm2.a, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class SubtitleDisplayData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String playUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AIOVideoData videoData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.mobileqq.richmediabrowser.presenter.f videoPresenter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final VideoView videoView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Runnable showSubtitleTimeoutRunnable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int timeout;

    public SubtitleDisplayData(@NotNull String playUrl, @NotNull AIOVideoData videoData, @NotNull com.tencent.mobileqq.richmediabrowser.presenter.f videoPresenter, @NotNull VideoView videoView, @NotNull Context context, @NotNull Runnable showSubtitleTimeoutRunnable, int i3) {
        Intrinsics.checkNotNullParameter(playUrl, "playUrl");
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        Intrinsics.checkNotNullParameter(videoPresenter, "videoPresenter");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(showSubtitleTimeoutRunnable, "showSubtitleTimeoutRunnable");
        this.playUrl = playUrl;
        this.videoData = videoData;
        this.videoPresenter = videoPresenter;
        this.videoView = videoView;
        this.context = context;
        this.showSubtitleTimeoutRunnable = showSubtitleTimeoutRunnable;
        this.timeout = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPlayUrl() {
        return this.playUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Runnable getShowSubtitleTimeoutRunnable() {
        return this.showSubtitleTimeoutRunnable;
    }

    /* renamed from: d, reason: from getter */
    public final int getTimeout() {
        return this.timeout;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final AIOVideoData getVideoData() {
        return this.videoData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtitleDisplayData)) {
            return false;
        }
        SubtitleDisplayData subtitleDisplayData = (SubtitleDisplayData) other;
        if (Intrinsics.areEqual(this.playUrl, subtitleDisplayData.playUrl) && Intrinsics.areEqual(this.videoData, subtitleDisplayData.videoData) && Intrinsics.areEqual(this.videoPresenter, subtitleDisplayData.videoPresenter) && Intrinsics.areEqual(this.videoView, subtitleDisplayData.videoView) && Intrinsics.areEqual(this.context, subtitleDisplayData.context) && Intrinsics.areEqual(this.showSubtitleTimeoutRunnable, subtitleDisplayData.showSubtitleTimeoutRunnable) && this.timeout == subtitleDisplayData.timeout) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final com.tencent.mobileqq.richmediabrowser.presenter.f getVideoPresenter() {
        return this.videoPresenter;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final VideoView getVideoView() {
        return this.videoView;
    }

    public int hashCode() {
        return (((((((((((this.playUrl.hashCode() * 31) + this.videoData.hashCode()) * 31) + this.videoPresenter.hashCode()) * 31) + this.videoView.hashCode()) * 31) + this.context.hashCode()) * 31) + this.showSubtitleTimeoutRunnable.hashCode()) * 31) + this.timeout;
    }

    @NotNull
    public String toString() {
        return "SubtitleDisplayData(playUrl=" + this.playUrl + ", videoData=" + this.videoData + ", videoPresenter=" + this.videoPresenter + ", videoView=" + this.videoView + ", context=" + this.context + ", showSubtitleTimeoutRunnable=" + this.showSubtitleTimeoutRunnable + ", timeout=" + this.timeout + ')';
    }
}
