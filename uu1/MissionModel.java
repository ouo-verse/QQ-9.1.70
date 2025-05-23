package uu1;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0012\u0010\u001e\u00a8\u0006\""}, d2 = {"Luu1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "I", "getSkipStatus", "()I", "skipStatus", "c", "Z", "isAllFinished", "()Z", "d", "finishNum", "e", "totalNum", "", "Luu1/a;", "f", "Ljava/util/List;", "()Ljava/util/List;", "missionList", "<init>", "(Ljava/lang/String;IZIILjava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: uu1.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MissionModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int skipStatus;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAllFinished;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int finishNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Mission> missionList;

    public MissionModel(@NotNull String guildId, int i3, boolean z16, int i16, int i17, @NotNull List<Mission> missionList) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(missionList, "missionList");
        this.guildId = guildId;
        this.skipStatus = i3;
        this.isAllFinished = z16;
        this.finishNum = i16;
        this.totalNum = i17;
        this.missionList = missionList;
    }

    /* renamed from: a, reason: from getter */
    public final int getFinishNum() {
        return this.finishNum;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final List<Mission> c() {
        return this.missionList;
    }

    /* renamed from: d, reason: from getter */
    public final int getTotalNum() {
        return this.totalNum;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MissionModel)) {
            return false;
        }
        MissionModel missionModel = (MissionModel) other;
        if (Intrinsics.areEqual(this.guildId, missionModel.guildId) && this.skipStatus == missionModel.skipStatus && this.isAllFinished == missionModel.isAllFinished && this.finishNum == missionModel.finishNum && this.totalNum == missionModel.totalNum && Intrinsics.areEqual(this.missionList, missionModel.missionList)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.guildId.hashCode() * 31) + this.skipStatus) * 31;
        boolean z16 = this.isAllFinished;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((hashCode + i3) * 31) + this.finishNum) * 31) + this.totalNum) * 31) + this.missionList.hashCode();
    }

    @NotNull
    public String toString() {
        return "MissionModel(guildId=" + this.guildId + ", skipStatus=" + this.skipStatus + ", isAllFinished=" + this.isAllFinished + ", finishNum=" + this.finishNum + ", totalNum=" + this.totalNum + ", missionList=" + this.missionList + ")";
    }
}
