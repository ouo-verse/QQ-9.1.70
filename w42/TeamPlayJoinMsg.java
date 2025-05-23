package w42;

import com.tencent.icgame.trpc.yes.common.MessageOuterClass$LiveRoomEnterGameTeamMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lw42/l;", "Lw42/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$LiveRoomEnterGameTeamMsg;", "d", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$LiveRoomEnterGameTeamMsg;", "b", "()Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$LiveRoomEnterGameTeamMsg;", "teamPlayJoin", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: w42.l, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class TeamPlayJoinMsg implements f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MessageOuterClass$LiveRoomEnterGameTeamMsg teamPlayJoin;

    @NotNull
    /* renamed from: b, reason: from getter */
    public final MessageOuterClass$LiveRoomEnterGameTeamMsg getTeamPlayJoin() {
        return this.teamPlayJoin;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof TeamPlayJoinMsg) && Intrinsics.areEqual(this.teamPlayJoin, ((TeamPlayJoinMsg) other).teamPlayJoin)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.teamPlayJoin.hashCode();
    }

    @NotNull
    public String toString() {
        return "TeamPlayJoinMsg(teamPlayJoin=" + this.teamPlayJoin + ')';
    }
}
