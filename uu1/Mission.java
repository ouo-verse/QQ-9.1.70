package uu1;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTaskInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\tB7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Luu1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "missionId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "d", "missionName", "missionDes", "e", "Z", "()Z", "isFinish", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: uu1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class Mission {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int missionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String missionName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String missionDes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFinish;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Luu1/a$a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTaskInfo;", "task", "", "guildId", "Luu1/a;", "b", "", "taskList", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: uu1.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<Mission> a(@NotNull List<IGProTaskInfo> taskList, @NotNull String guildId) {
            int collectionSizeOrDefault;
            List<Mission> mutableList;
            Intrinsics.checkNotNullParameter(taskList, "taskList");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            List<IGProTaskInfo> list = taskList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Mission.INSTANCE.b((IGProTaskInfo) it.next(), guildId));
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
            return mutableList;
        }

        @NotNull
        public final Mission b(@NotNull IGProTaskInfo task, @NotNull String guildId) {
            boolean z16;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            String id5 = task.getId();
            Intrinsics.checkNotNullExpressionValue(id5, "task.id");
            int parseInt = Integer.parseInt(id5);
            String name = task.getName();
            Intrinsics.checkNotNullExpressionValue(name, "task.name");
            String progressText = task.getProgressText();
            Intrinsics.checkNotNullExpressionValue(progressText, "task.progressText");
            if (task.getStatus() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new Mission(parseInt, guildId, name, progressText, z16);
        }

        Companion() {
        }
    }

    public Mission(int i3, @NotNull String guildId, @NotNull String missionName, @NotNull String missionDes, boolean z16) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(missionName, "missionName");
        Intrinsics.checkNotNullParameter(missionDes, "missionDes");
        this.missionId = i3;
        this.guildId = guildId;
        this.missionName = missionName;
        this.missionDes = missionDes;
        this.isFinish = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMissionDes() {
        return this.missionDes;
    }

    /* renamed from: c, reason: from getter */
    public final int getMissionId() {
        return this.missionId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMissionName() {
        return this.missionName;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mission)) {
            return false;
        }
        Mission mission = (Mission) other;
        if (this.missionId == mission.missionId && Intrinsics.areEqual(this.guildId, mission.guildId) && Intrinsics.areEqual(this.missionName, mission.missionName) && Intrinsics.areEqual(this.missionDes, mission.missionDes) && this.isFinish == mission.isFinish) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.missionId * 31) + this.guildId.hashCode()) * 31) + this.missionName.hashCode()) * 31) + this.missionDes.hashCode()) * 31;
        boolean z16 = this.isFinish;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        return "Mission(missionId=" + this.missionId + ", guildId=" + this.guildId + ", missionName=" + this.missionName + ", missionDes=" + this.missionDes + ", isFinish=" + this.isFinish + ")";
    }
}
