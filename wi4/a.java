package wi4;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.liveroom.impl.room.audience.record.TGLiveRecordEntity;
import com.tencent.timi.game.liveroom.impl.room.util.e;
import java.util.List;
import jg4.b;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J&\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lwi4/a;", "", "", "roomId", "enterRoomTime", "", "roomType", "", "a", "heartBeatExitRoomTime", "c", "exitRoomTime", "b", "exitTime", "", "gameLiveOnly", "d", "Lcom/tencent/timi/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;", "Lcom/tencent/timi/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;", "getCurTGLiveRecordEntity", "()Lcom/tencent/timi/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;", "setCurTGLiveRecordEntity", "(Lcom/tencent/timi/game/liveroom/impl/room/audience/record/TGLiveRecordEntity;)V", "curTGLiveRecordEntity", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445705a = new a();

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
            e eVar = e.f378633a;
            TGLiveRecordEntity tGLiveRecordEntity2 = curTGLiveRecordEntity;
            Intrinsics.checkNotNull(tGLiveRecordEntity2);
            eVar.e(tGLiveRecordEntity2);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(String.valueOf((NetConnInfoCenter.getServerTime() * 1000) - 1296000000));
            TGLiveRecordEntity tGLiveRecordEntity3 = new TGLiveRecordEntity();
            tGLiveRecordEntity3.setStatus(1001);
            Object[] array = mutableListOf.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            eVar.c(tGLiveRecordEntity3, "enterRoomTime<? ", (String[]) array);
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
            e eVar = e.f378633a;
            TGLiveRecordEntity tGLiveRecordEntity2 = curTGLiveRecordEntity;
            Intrinsics.checkNotNull(tGLiveRecordEntity2);
            eVar.e(tGLiveRecordEntity2);
        }
    }

    public final long d(long roomId, long enterRoomTime, long exitTime, boolean gameLiveOnly) {
        long coerceAtMost;
        List<? extends Entity> list;
        long j3;
        Object obj;
        boolean z16;
        boolean z17;
        long j16;
        List mutableListOf;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(NetConnInfoCenter.getServerTime() * 1000, exitTime);
        YesDataBaseHelper f16 = YesDataBaseHelper.f();
        long j17 = 0;
        if (f16 != null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(String.valueOf(enterRoomTime), String.valueOf(coerceAtMost));
            String str = "enterRoomTime>? and enterRoomTime<?";
            if (roomId > 0) {
                str = "enterRoomTime>? and enterRoomTime<? and roomId=?";
                mutableListOf.add(String.valueOf(roomId));
            }
            if (gameLiveOnly) {
                mutableListOf.add("1");
                str = str + " and roomType=?";
            }
            Object[] array = mutableListOf.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            list = f16.k(TGLiveRecordEntity.class, false, str, (String[]) array, null, null, "leaveRoomTime desc", null);
        } else {
            list = null;
        }
        if (list != null) {
            j3 = 0;
            obj = null;
            for (Object obj2 : list) {
                if (obj2 instanceof TGLiveRecordEntity) {
                    TGLiveRecordEntity tGLiveRecordEntity = (TGLiveRecordEntity) obj2;
                    if (tGLiveRecordEntity.duration() > 0) {
                        TGLiveRecordEntity tGLiveRecordEntity2 = curTGLiveRecordEntity;
                        if (tGLiveRecordEntity2 != null && tGLiveRecordEntity.enterRoomTime == tGLiveRecordEntity2.enterRoomTime) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            obj = obj2;
                        }
                        if (tGLiveRecordEntity.leaveRoomTime < coerceAtMost) {
                            j16 = tGLiveRecordEntity.duration();
                        } else {
                            j16 = coerceAtMost - tGLiveRecordEntity.enterRoomTime;
                        }
                        j3 += j16;
                    }
                }
            }
        } else {
            j3 = 0;
            obj = null;
        }
        TGLiveRecordEntity tGLiveRecordEntity3 = curTGLiveRecordEntity;
        if (tGLiveRecordEntity3 != null) {
            if (((b) mm4.b.b(b.class)).H(tGLiveRecordEntity3.roomId)) {
                if (roomId <= 0 || roomId == tGLiveRecordEntity3.roomId) {
                    long j18 = enterRoomTime + 1;
                    long j19 = tGLiveRecordEntity3.enterRoomTime;
                    if (j18 <= j19 && j19 < coerceAtMost) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        long j26 = coerceAtMost - j19;
                        TGLiveRecordEntity tGLiveRecordEntity4 = (TGLiveRecordEntity) obj;
                        if (tGLiveRecordEntity4 != null) {
                            j17 = tGLiveRecordEntity4.duration();
                        }
                        return j3 + (j26 - j17);
                    }
                    return j3;
                }
                return j3;
            }
            curTGLiveRecordEntity = null;
            return j3;
        }
        return j3;
    }
}
