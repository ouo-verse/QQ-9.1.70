package tb4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Ltb4/d;", "", "other", "", "c", "", "toString", "hashCode", "", "", "equals", "d", "I", "j", "()I", "stage", "e", "k", "startProgress", "f", h.F, "finalProgress", "", "J", "i", "()J", "predictDuration", "<init>", "(IIIJ)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: tb4.d, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class StageProgressConfig implements Comparable<StageProgressConfig> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int stage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int startProgress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int finalProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final long predictDuration;

    public StageProgressConfig(int i3, int i16, int i17, long j3) {
        this.stage = i3;
        this.startProgress = i16;
        this.finalProgress = i17;
        this.predictDuration = j3;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(StageProgressConfig other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = this.stage;
        int i16 = other.stage;
        if (i3 > i16) {
            return 1;
        }
        return i3 == i16 ? 0 : -1;
    }

    /* renamed from: h, reason: from getter */
    public final int getFinalProgress() {
        return this.finalProgress;
    }

    public int hashCode() {
        return (((((this.stage * 31) + this.startProgress) * 31) + this.finalProgress) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.predictDuration);
    }

    /* renamed from: i, reason: from getter */
    public final long getPredictDuration() {
        return this.predictDuration;
    }

    /* renamed from: j, reason: from getter */
    public final int getStage() {
        return this.stage;
    }

    /* renamed from: k, reason: from getter */
    public final int getStartProgress() {
        return this.startProgress;
    }

    public String toString() {
        return "StageProgressConfig(stage=" + this.stage + ", startProgress=" + this.startProgress + ", finalProgress=" + this.finalProgress + ", predictDuration=" + this.predictDuration + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageProgressConfig)) {
            return false;
        }
        StageProgressConfig stageProgressConfig = (StageProgressConfig) other;
        return this.stage == stageProgressConfig.stage && this.startProgress == stageProgressConfig.startProgress && this.finalProgress == stageProgressConfig.finalProgress && this.predictDuration == stageProgressConfig.predictDuration;
    }
}
