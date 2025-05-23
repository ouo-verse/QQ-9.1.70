package u20;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lu20/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "pipelineId", "", "b", UserInfo.SEX_FEMALE, "()F", "threshold", "<init>", "(IF)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.h, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSPipelineConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pipelineId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final float threshold;

    public QFSPipelineConfig() {
        this(0, 0.0f, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getPipelineId() {
        return this.pipelineId;
    }

    /* renamed from: b, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSPipelineConfig)) {
            return false;
        }
        QFSPipelineConfig qFSPipelineConfig = (QFSPipelineConfig) other;
        if (this.pipelineId == qFSPipelineConfig.pipelineId && Float.compare(this.threshold, qFSPipelineConfig.threshold) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.pipelineId * 31) + Float.floatToIntBits(this.threshold);
    }

    @NotNull
    public String toString() {
        return "QFSPipelineConfig(pipelineId=" + this.pipelineId + ", threshold=" + this.threshold + ")";
    }

    public QFSPipelineConfig(int i3, float f16) {
        this.pipelineId = i3;
        this.threshold = f16;
    }

    public /* synthetic */ QFSPipelineConfig(int i3, float f16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? 68.0f : f16);
    }
}
