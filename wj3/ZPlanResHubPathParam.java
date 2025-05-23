package wj3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lwj3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getResId", "()Ljava/lang/String;", "resId", "b", "resSavaPath", "c", "diffPatchPath", "d", "unzipPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wj3.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZPlanResHubPathParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String resId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String resSavaPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String diffPatchPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String unzipPath;

    public ZPlanResHubPathParam(String resId, String resSavaPath, String diffPatchPath, String unzipPath) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(resSavaPath, "resSavaPath");
        Intrinsics.checkNotNullParameter(diffPatchPath, "diffPatchPath");
        Intrinsics.checkNotNullParameter(unzipPath, "unzipPath");
        this.resId = resId;
        this.resSavaPath = resSavaPath;
        this.diffPatchPath = diffPatchPath;
        this.unzipPath = unzipPath;
    }

    /* renamed from: a, reason: from getter */
    public final String getDiffPatchPath() {
        return this.diffPatchPath;
    }

    /* renamed from: b, reason: from getter */
    public final String getResSavaPath() {
        return this.resSavaPath;
    }

    /* renamed from: c, reason: from getter */
    public final String getUnzipPath() {
        return this.unzipPath;
    }

    public int hashCode() {
        return (((((this.resId.hashCode() * 31) + this.resSavaPath.hashCode()) * 31) + this.diffPatchPath.hashCode()) * 31) + this.unzipPath.hashCode();
    }

    public String toString() {
        return "ZPlanResHubPathParam(resId=" + this.resId + ", resSavaPath=" + this.resSavaPath + ", diffPatchPath=" + this.diffPatchPath + ", unzipPath=" + this.unzipPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanResHubPathParam)) {
            return false;
        }
        ZPlanResHubPathParam zPlanResHubPathParam = (ZPlanResHubPathParam) other;
        return Intrinsics.areEqual(this.resId, zPlanResHubPathParam.resId) && Intrinsics.areEqual(this.resSavaPath, zPlanResHubPathParam.resSavaPath) && Intrinsics.areEqual(this.diffPatchPath, zPlanResHubPathParam.diffPatchPath) && Intrinsics.areEqual(this.unzipPath, zPlanResHubPathParam.unzipPath);
    }
}
