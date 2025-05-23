package wc3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB+\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lwc3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getModelColor", "()Ljava/lang/String;", "modelColor", "b", "getModelId", "modelId", "c", "getHavePaste", "havePaste", "", "d", "J", "()J", "firstFrameStartMillis", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wc3.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ExtraReportParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String modelColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String modelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String havePaste;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long firstFrameStartMillis;

    public ExtraReportParams(String modelColor, String modelId, String havePaste, long j3) {
        Intrinsics.checkNotNullParameter(modelColor, "modelColor");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(havePaste, "havePaste");
        this.modelColor = modelColor;
        this.modelId = modelId;
        this.havePaste = havePaste;
        this.firstFrameStartMillis = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getFirstFrameStartMillis() {
        return this.firstFrameStartMillis;
    }

    public int hashCode() {
        return (((((this.modelColor.hashCode() * 31) + this.modelId.hashCode()) * 31) + this.havePaste.hashCode()) * 31) + com.tencent.mobileqq.vas.banner.c.a(this.firstFrameStartMillis);
    }

    public String toString() {
        return "ExtraReportParams(modelColor=" + this.modelColor + ", modelId=" + this.modelId + ", havePaste=" + this.havePaste + ", firstFrameStartMillis=" + this.firstFrameStartMillis + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtraReportParams)) {
            return false;
        }
        ExtraReportParams extraReportParams = (ExtraReportParams) other;
        return Intrinsics.areEqual(this.modelColor, extraReportParams.modelColor) && Intrinsics.areEqual(this.modelId, extraReportParams.modelId) && Intrinsics.areEqual(this.havePaste, extraReportParams.havePaste) && this.firstFrameStartMillis == extraReportParams.firstFrameStartMillis;
    }

    public /* synthetic */ ExtraReportParams(String str, String str2, String str3, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "1" : str3, (i3 & 8) != 0 ? System.currentTimeMillis() : j3);
    }
}
