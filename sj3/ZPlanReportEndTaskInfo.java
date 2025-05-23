package sj3;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R%\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lsj3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "taskName", "b", "featureName", "c", "I", "()I", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "Ljava/util/Map;", "()Ljava/util/Map;", "endAttributes", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sj3.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanReportEndTaskInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String featureName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int statusCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Map<String, String> endAttributes;

    public ZPlanReportEndTaskInfo(@NotNull String taskName, @Nullable String str, int i3, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        this.taskName = taskName;
        this.featureName = str;
        this.statusCode = i3;
        this.endAttributes = map;
    }

    @Nullable
    public final Map<String, String> a() {
        return this.endAttributes;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getFeatureName() {
        return this.featureName;
    }

    /* renamed from: c, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanReportEndTaskInfo)) {
            return false;
        }
        ZPlanReportEndTaskInfo zPlanReportEndTaskInfo = (ZPlanReportEndTaskInfo) other;
        if (Intrinsics.areEqual(this.taskName, zPlanReportEndTaskInfo.taskName) && Intrinsics.areEqual(this.featureName, zPlanReportEndTaskInfo.featureName) && this.statusCode == zPlanReportEndTaskInfo.statusCode && Intrinsics.areEqual(this.endAttributes, zPlanReportEndTaskInfo.endAttributes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.taskName.hashCode() * 31;
        String str = this.featureName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (((hashCode2 + hashCode) * 31) + this.statusCode) * 31;
        Map<String, String> map = this.endAttributes;
        if (map != null) {
            i3 = map.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "ZPlanReportEndTaskInfo(taskName=" + this.taskName + ", featureName=" + this.featureName + ", statusCode=" + this.statusCode + ", endAttributes=" + this.endAttributes + ')';
    }
}
