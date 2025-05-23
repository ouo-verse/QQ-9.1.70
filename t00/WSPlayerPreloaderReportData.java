package t00;

import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0004\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0015\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lt00/b;", "", "", "toString", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", AppConstants.Key.KEY_QZONE_VIDEO_URL, "", "b", "J", "()J", "e", "(J)V", "videoDurationMs", "c", "f", "videoFileSize", "g", "videoPreloaderInfo", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: t00.b, reason: from toString */
/* loaded from: classes36.dex */
public final class WSPlayerPreloaderReportData {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long videoDurationMs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private long videoFileSize;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String videoUrl = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String videoPreloaderInfo = "";

    /* renamed from: a, reason: from getter */
    public final long getVideoDurationMs() {
        return this.videoDurationMs;
    }

    /* renamed from: b, reason: from getter */
    public final long getVideoFileSize() {
        return this.videoFileSize;
    }

    /* renamed from: c, reason: from getter */
    public final String getVideoPreloaderInfo() {
        return this.videoPreloaderInfo;
    }

    /* renamed from: d, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final void e(long j3) {
        this.videoDurationMs = j3;
    }

    public final void f(long j3) {
        this.videoFileSize = j3;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoPreloaderInfo = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoUrl = str;
    }

    public String toString() {
        return "WSPlayerPreloaderReportData(videoUrl='" + this.videoUrl + "', videoDurationMs=" + this.videoDurationMs + ", videoFileSize=" + this.videoFileSize + ", videoPreloaderInfo='" + this.videoPreloaderInfo + "')";
    }
}
