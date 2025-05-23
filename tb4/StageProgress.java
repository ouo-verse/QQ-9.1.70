package tb4;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Ltb4/c;", "", "Ltb4/d;", DownloadInfo.spKey_Config, "", "c", "", "toString", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "stage", "progress", "<init>", "(II)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: tb4.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class StageProgress {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int stage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int progress;

    public StageProgress(int i3, int i16) {
        this.stage = i3;
        this.progress = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: b, reason: from getter */
    public final int getStage() {
        return this.stage;
    }

    public final int c(StageProgressConfig config) {
        int roundToInt;
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(config, "config");
        roundToInt = MathKt__MathJVMKt.roundToInt(config.getStartProgress() + ((config.getFinalProgress() - config.getStartProgress()) * (this.progress / 100.0f)));
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(roundToInt, config.getFinalProgress());
        return coerceAtMost;
    }

    public int hashCode() {
        return (this.stage * 31) + this.progress;
    }

    public String toString() {
        return "StageProgress(stage=" + this.stage + ", progress=" + this.progress + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageProgress)) {
            return false;
        }
        StageProgress stageProgress = (StageProgress) other;
        return this.stage == stageProgress.stage && this.progress == stageProgress.progress;
    }
}
