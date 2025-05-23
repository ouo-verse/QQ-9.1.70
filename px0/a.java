package px0;

import com.tencent.icgame.game.report.b;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0002J(\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u001b\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001d\u00a8\u0006!"}, d2 = {"Lpx0/a;", "", "", "roomId", "Lcom/tencent/icgame/game/report/b;", "c", "k", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/mobileqq/icgame/api/room/ILiveAudienceTPPlayerRoom;", "room", "", "roomType", "", "g", "i", "j", "a", "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", "liveInfo", "costTime", "d", "errCode", "", "errMsg", "e", "f", h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "delegateMap", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f427869a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, b> delegateMap = new ConcurrentHashMap<>();

    a() {
    }

    private final b b(long roomId) {
        b putIfAbsent;
        ConcurrentHashMap<Long, b> concurrentHashMap = delegateMap;
        Long valueOf = Long.valueOf(roomId);
        b bVar = concurrentHashMap.get(valueOf);
        if (bVar == null && (putIfAbsent = concurrentHashMap.putIfAbsent(valueOf, (bVar = new b(roomId)))) != null) {
            bVar = putIfAbsent;
        }
        return bVar;
    }

    private final b c(long roomId) {
        return delegateMap.get(Long.valueOf(roomId));
    }

    private final b k(long roomId) {
        return delegateMap.remove(Long.valueOf(roomId));
    }

    public final void a(long roomId) {
        if (roomId == 0) {
            QLog.w("ICGameVideoQualityHelper", 1, "[beforeEnterRoom] invalid params");
            return;
        }
        b c16 = c(roomId);
        if (c16 != null) {
            c16.b();
        }
    }

    public final void d(@Nullable LiveInfo liveInfo, long costTime) {
        LiveRoomInfo liveRoomInfo;
        LiveRoomInfo liveRoomInfo2;
        Long l3 = null;
        if (liveInfo != null) {
            liveRoomInfo = liveInfo.roomInfo;
        } else {
            liveRoomInfo = null;
        }
        if (liveRoomInfo != null) {
            long j3 = liveInfo.roomInfo.roomId;
            if (j3 != 0) {
                b c16 = c(j3);
                if (c16 != null) {
                    c16.i(liveInfo, costTime);
                    return;
                }
                return;
            }
        }
        if (liveInfo != null && (liveRoomInfo2 = liveInfo.roomInfo) != null) {
            l3 = Long.valueOf(liveRoomInfo2.roomId);
        }
        QLog.w("ICGameVideoQualityHelper", 1, "[onEnterRoom] invalid params, roomId=" + l3);
    }

    public final void e(long roomId, int errCode, @Nullable String errMsg, long costTime) {
        if (roomId == 0) {
            QLog.w("ICGameVideoQualityHelper", 1, "[onEnterRoomFail] invalid params");
        }
        b c16 = c(roomId);
        if (c16 != null) {
            c16.j(errCode, errMsg, costTime);
        }
    }

    public final void f(long roomId) {
        if (roomId == 0) {
            QLog.w("ICGameVideoQualityHelper", 1, "[onExitRoom] invalid params");
        }
        b c16 = c(roomId);
        if (c16 != null) {
            c16.k();
        }
    }

    public final void g(@Nullable ILiveAudienceTPPlayerRoom room, long roomId, int roomType) {
        if (room != null && roomId != 0) {
            if (c(roomId) != null) {
                QLog.i("ICGameVideoQualityHelper", 1, "[onRoomCreate] already create delegate, roomId=" + roomId);
                return;
            }
            b b16 = b(roomId);
            b16.h(roomType);
            room.registerRoomPlayerListener(b16);
            return;
        }
        QLog.w("ICGameVideoQualityHelper", 1, "[onRoomCreate] invalid params, roomId=" + roomId);
    }

    public final void h(@Nullable ILiveAudienceTPPlayerRoom room, long roomId) {
        if (room != null && roomId != 0) {
            b c16 = c(roomId);
            if (c16 != null) {
                c16.l();
                room.unRegisterRoomPlayerListener(c16);
            }
            k(roomId);
            return;
        }
        QLog.w("ICGameVideoQualityHelper", 1, "[onRoomDestroy] invalid params, roomId=" + roomId);
    }

    public final void i(@Nullable ILiveAudienceTPPlayerRoom room, long roomId) {
        if (room != null && roomId != 0) {
            b c16 = c(roomId);
            if (c16 != null) {
                room.registerRoomPlayerListener(c16);
                return;
            }
            return;
        }
        QLog.w("ICGameVideoQualityHelper", 1, "[onRoomPreload] invalid params, roomId=" + roomId);
    }

    public final void j(long roomId) {
        if (roomId == 0) {
            QLog.w("ICGameVideoQualityHelper", 1, "[prepareEnterRoom] invalid params");
            return;
        }
        b c16 = c(roomId);
        if (c16 != null) {
            c16.n();
        }
    }
}
