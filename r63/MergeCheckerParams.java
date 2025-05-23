package r63;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\t\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\fR\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014\u00a8\u0006#"}, d2 = {"Lr63/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getWidth", "()I", "width", "b", "getHeight", "height", "c", "Z", "isHEVC", "()Z", "d", "isHDR", "e", "hasBFrame", "f", "getVideoTrackCount", "videoTrackCount", "g", "getAudioTrackCount", "audioTrackCount", h.F, "isHardwareEncode", "<init>", "(IIZZZIIZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: r63.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MergeCheckerParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHEVC;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHDR;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasBFrame;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int videoTrackCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int audioTrackCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isHardwareEncode;

    public MergeCheckerParams(int i3, int i16, boolean z16, boolean z17, boolean z18, int i17, int i18, boolean z19) {
        this.width = i3;
        this.height = i16;
        this.isHEVC = z16;
        this.isHDR = z17;
        this.hasBFrame = z18;
        this.videoTrackCount = i17;
        this.audioTrackCount = i18;
        this.isHardwareEncode = z19;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getHasBFrame() {
        return this.hasBFrame;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MergeCheckerParams)) {
            return false;
        }
        MergeCheckerParams mergeCheckerParams = (MergeCheckerParams) other;
        if (this.width == mergeCheckerParams.width && this.height == mergeCheckerParams.height && this.isHEVC == mergeCheckerParams.isHEVC && this.isHDR == mergeCheckerParams.isHDR && this.hasBFrame == mergeCheckerParams.hasBFrame && this.videoTrackCount == mergeCheckerParams.videoTrackCount && this.audioTrackCount == mergeCheckerParams.audioTrackCount && this.isHardwareEncode == mergeCheckerParams.isHardwareEncode) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = ((this.width * 31) + this.height) * 31;
        boolean z16 = this.isHEVC;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i3 + i17) * 31;
        boolean z17 = this.isHDR;
        int i19 = z17;
        if (z17 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z18 = this.hasBFrame;
        int i27 = z18;
        if (z18 != 0) {
            i27 = 1;
        }
        int i28 = (((((i26 + i27) * 31) + this.videoTrackCount) * 31) + this.audioTrackCount) * 31;
        boolean z19 = this.isHardwareEncode;
        if (!z19) {
            i16 = z19 ? 1 : 0;
        }
        return i28 + i16;
    }

    @NotNull
    public String toString() {
        return "MergeCheckerParams(width=" + this.width + ", height=" + this.height + ", isHEVC=" + this.isHEVC + ", isHDR=" + this.isHDR + ", hasBFrame=" + this.hasBFrame + ", videoTrackCount=" + this.videoTrackCount + ", audioTrackCount=" + this.audioTrackCount + ", isHardwareEncode=" + this.isHardwareEncode + ")";
    }
}
