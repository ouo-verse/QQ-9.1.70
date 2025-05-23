package r63;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lr63/c;", "Lr63/b;", "a", "other", "", "b", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {
    @NotNull
    public static final MergeCheckerParams a(@NotNull MetaVideo metaVideo) {
        Intrinsics.checkNotNullParameter(metaVideo, "<this>");
        return new MergeCheckerParams(metaVideo.getWidth(), metaVideo.getHeight(), metaVideo.getIsHEVC(), metaVideo.getIsHDR(), metaVideo.getHasBFrame(), metaVideo.getVideoTrackCount(), metaVideo.getAudioTrackCount(), metaVideo.getIsHardwareEncode());
    }

    public static final boolean b(@NotNull MetaVideo metaVideo, @NotNull MetaVideo other) {
        Intrinsics.checkNotNullParameter(metaVideo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(a(metaVideo), a(other));
    }
}
