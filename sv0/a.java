package sv0;

import com.tencent.icgame.game.liveroom.impl.room.audience.record.TGLiveRecordEntity;
import com.tencent.icgame.game.liveroom.impl.room.util.f;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002R$\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lsv0/a;", "", "", "roomId", "enterRoomTime", "", "roomType", "", "a", "heartBeatExitRoomTime", "c", "exitRoomTime", "b", "Lcom/tencent/icgame/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;", "Lcom/tencent/icgame/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;", "getCurTGLiveRecordEntity", "()Lcom/tencent/icgame/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;", "setCurTGLiveRecordEntity", "(Lcom/tencent/icgame/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;)V", "curTGLiveRecordEntity", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f434825a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TGLiveRecordEntity curTGLiveRecordEntity;

    a() {
    }

    public final void a(long roomId, long enterRoomTime, int roomType) {
        TGLiveRecordEntity tGLiveRecordEntity = new TGLiveRecordEntity();
        tGLiveRecordEntity.roomId = roomId;
        tGLiveRecordEntity.enterRoomTime = enterRoomTime;
        tGLiveRecordEntity.roomType = roomType;
        curTGLiveRecordEntity = tGLiveRecordEntity;
    }

    public final void b(long roomId, long exitRoomTime) {
        boolean z16;
        List mutableListOf;
        TGLiveRecordEntity tGLiveRecordEntity = curTGLiveRecordEntity;
        if (tGLiveRecordEntity != null && tGLiveRecordEntity.roomId == roomId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (tGLiveRecordEntity != null) {
                tGLiveRecordEntity.leaveRoomTime = exitRoomTime;
            }
            f fVar = f.f115694a;
            TGLiveRecordEntity tGLiveRecordEntity2 = curTGLiveRecordEntity;
            Intrinsics.checkNotNull(tGLiveRecordEntity2);
            fVar.e(tGLiveRecordEntity2);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(String.valueOf((NetConnInfoCenter.getServerTime() * 1000) - 1296000000));
            TGLiveRecordEntity tGLiveRecordEntity3 = new TGLiveRecordEntity();
            tGLiveRecordEntity3.setStatus(1001);
            Object[] array = mutableListOf.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            fVar.c(tGLiveRecordEntity3, "enterRoomTime<? ", (String[]) array);
            curTGLiveRecordEntity = null;
        }
    }

    public final void c(long roomId, long heartBeatExitRoomTime) {
        TGLiveRecordEntity tGLiveRecordEntity = curTGLiveRecordEntity;
        boolean z16 = false;
        if (tGLiveRecordEntity != null && tGLiveRecordEntity.roomId == roomId) {
            z16 = true;
        }
        if (z16) {
            if (tGLiveRecordEntity != null) {
                tGLiveRecordEntity.leaveRoomTime = heartBeatExitRoomTime;
            }
            f fVar = f.f115694a;
            TGLiveRecordEntity tGLiveRecordEntity2 = curTGLiveRecordEntity;
            Intrinsics.checkNotNull(tGLiveRecordEntity2);
            fVar.e(tGLiveRecordEntity2);
        }
    }
}
