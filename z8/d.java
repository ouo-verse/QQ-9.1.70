package z8;

import com.qzone.publish.ui.model.MediaWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/qzone/publish/ui/model/MediaWrapper;", "", "a", "(Lcom/qzone/publish/ui/model/MediaWrapper;)Ljava/lang/String;", "originalPath", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {
    public static final String a(MediaWrapper mediaWrapper) {
        String videoOriginalPath;
        String str;
        Intrinsics.checkNotNullParameter(mediaWrapper, "<this>");
        if (mediaWrapper.isImage()) {
            videoOriginalPath = mediaWrapper.getImageInfo().mPath;
            str = "imageInfo.mPath";
        } else {
            videoOriginalPath = mediaWrapper.getVideoInfo().getVideoOriginalPath();
            str = "videoInfo.videoOriginalPath";
        }
        Intrinsics.checkNotNullExpressionValue(videoOriginalPath, str);
        return videoOriginalPath;
    }
}
