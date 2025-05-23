package r64;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lr64/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "groupId", "b", "c", "robotUin", "Ljava/lang/String;", "()Ljava/lang/String;", "robotName", "", "d", "Ljava/util/List;", "()Ljava/util/List;", "templateIds", "<init>", "(JJLjava/lang/String;Ljava/util/List;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: r64.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class SubscribeMessageDialogParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long groupId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long robotUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String robotName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Object> templateIds;

    public SubscribeMessageDialogParam(long j3, long j16, @Nullable String str, @NotNull List<? extends Object> templateIds) {
        Intrinsics.checkNotNullParameter(templateIds, "templateIds");
        this.groupId = j3;
        this.robotUin = j16;
        this.robotName = str;
        this.templateIds = templateIds;
    }

    /* renamed from: a, reason: from getter */
    public final long getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getRobotName() {
        return this.robotName;
    }

    /* renamed from: c, reason: from getter */
    public final long getRobotUin() {
        return this.robotUin;
    }

    @NotNull
    public final List<Object> d() {
        return this.templateIds;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscribeMessageDialogParam)) {
            return false;
        }
        SubscribeMessageDialogParam subscribeMessageDialogParam = (SubscribeMessageDialogParam) other;
        if (this.groupId == subscribeMessageDialogParam.groupId && this.robotUin == subscribeMessageDialogParam.robotUin && Intrinsics.areEqual(this.robotName, subscribeMessageDialogParam.robotName) && Intrinsics.areEqual(this.templateIds, subscribeMessageDialogParam.templateIds)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((androidx.fragment.app.a.a(this.groupId) * 31) + androidx.fragment.app.a.a(this.robotUin)) * 31;
        String str = this.robotName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((a16 + hashCode) * 31) + this.templateIds.hashCode();
    }

    @NotNull
    public String toString() {
        return "SubscribeMessageDialogParam(groupId=" + this.groupId + ", robotUin=" + this.robotUin + ", robotName=" + this.robotName + ", templateIds=" + this.templateIds + ")";
    }
}
