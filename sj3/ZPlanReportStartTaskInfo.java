package sj3;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\fR%\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lsj3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "taskName", "b", "featureName", "c", "parentTaskName", "d", "parentFeatureName", "", "Ljava/util/Map;", "()Ljava/util/Map;", "startAttributes", "", "f", "Ljava/lang/Long;", "()Ljava/lang/Long;", "timeout", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sj3.b, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class ZPlanReportStartTaskInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String taskName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String featureName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String parentTaskName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String parentFeatureName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Map<String, String> startAttributes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long timeout;

    public ZPlanReportStartTaskInfo(@NotNull String taskName, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, String> map, @Nullable Long l3) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        this.taskName = taskName;
        this.featureName = str;
        this.parentTaskName = str2;
        this.parentFeatureName = str3;
        this.startAttributes = map;
        this.timeout = l3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getFeatureName() {
        return this.featureName;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getParentFeatureName() {
        return this.parentFeatureName;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getParentTaskName() {
        return this.parentTaskName;
    }

    @Nullable
    public final Map<String, String> d() {
        return this.startAttributes;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanReportStartTaskInfo)) {
            return false;
        }
        ZPlanReportStartTaskInfo zPlanReportStartTaskInfo = (ZPlanReportStartTaskInfo) other;
        if (Intrinsics.areEqual(this.taskName, zPlanReportStartTaskInfo.taskName) && Intrinsics.areEqual(this.featureName, zPlanReportStartTaskInfo.featureName) && Intrinsics.areEqual(this.parentTaskName, zPlanReportStartTaskInfo.parentTaskName) && Intrinsics.areEqual(this.parentFeatureName, zPlanReportStartTaskInfo.parentFeatureName) && Intrinsics.areEqual(this.startAttributes, zPlanReportStartTaskInfo.startAttributes) && Intrinsics.areEqual(this.timeout, zPlanReportStartTaskInfo.timeout)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Long getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = this.taskName.hashCode() * 31;
        String str = this.featureName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode5 + hashCode) * 31;
        String str2 = this.parentTaskName;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.parentFeatureName;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Map<String, String> map = this.startAttributes;
        if (map == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = map.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Long l3 = this.timeout;
        if (l3 != null) {
            i3 = l3.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "ZPlanReportStartTaskInfo(taskName=" + this.taskName + ", featureName=" + this.featureName + ", parentTaskName=" + this.parentTaskName + ", parentFeatureName=" + this.parentFeatureName + ", startAttributes=" + this.startAttributes + ", timeout=" + this.timeout + ')';
    }
}
