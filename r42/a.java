package r42;

import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import fu0.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0017"}, d2 = {"Lr42/a;", "", "", "roomId", "", "query", "Lcom/tencent/mobileqq/icgame/api/room/IAudienceRoom;", "k", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "o", "f", "d", "", "i", "g", "b", "a", "c", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    public static /* synthetic */ long e(a aVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return aVar.d(j3, i3);
    }

    public static /* synthetic */ long h(a aVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return aVar.g(j3, i3);
    }

    public static /* synthetic */ String j(a aVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return aVar.i(j3, i3);
    }

    private final IAudienceRoom k(long roomId, int query) {
        if (query != 0) {
            if (query != 1) {
                if (query != 2) {
                    return null;
                }
                return m(roomId);
            }
            return n(roomId);
        }
        return l(roomId);
    }

    private final IAudienceRoom l(long roomId) {
        return ((c) qx0.a.b(c.class)).N(roomId);
    }

    private final IAudienceRoom m(long j3) {
        return ((c) qx0.a.b(c.class)).K3(j3);
    }

    private final IAudienceRoom n(long j3) {
        return ((c) qx0.a.b(c.class)).y(j3);
    }

    @NotNull
    public final String a(long roomId, int query) {
        String str;
        LiveInfo roomLiveInfo;
        LiveAnchorInfo liveAnchorInfo;
        IAudienceRoom k3 = k(roomId, query);
        if (k3 != null && (roomLiveInfo = k3.getRoomLiveInfo()) != null && (liveAnchorInfo = roomLiveInfo.anchorInfo) != null) {
            str = liveAnchorInfo.headUrl;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String b(long roomId, int query) {
        String str;
        LiveInfo roomLiveInfo;
        LiveAnchorInfo liveAnchorInfo;
        IAudienceRoom k3 = k(roomId, query);
        if (k3 != null && (roomLiveInfo = k3.getRoomLiveInfo()) != null && (liveAnchorInfo = roomLiveInfo.anchorInfo) != null) {
            str = liveAnchorInfo.nickName;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final int c(long roomId, int query) {
        LiveInfo roomLiveInfo;
        LiveAnchorInfo liveAnchorInfo;
        IAudienceRoom k3 = k(roomId, query);
        if (k3 != null && (roomLiveInfo = k3.getRoomLiveInfo()) != null && (liveAnchorInfo = roomLiveInfo.anchorInfo) != null) {
            return liveAnchorInfo.sex;
        }
        return 0;
    }

    public final long d(long roomId, int query) {
        BaseAnchorInfo anchorInfo;
        IAudienceRoom k3 = k(roomId, query);
        if (k3 != null && (anchorInfo = k3.getAnchorInfo()) != null) {
            return anchorInfo.getAnchorUid();
        }
        return 0L;
    }

    public final long f() {
        BaseRoomInfo roomInfo;
        IAudienceRoom k3 = k(0L, 0);
        if (k3 == null || (roomInfo = k3.getRoomInfo()) == null) {
            return 0L;
        }
        return roomInfo.getRoomId();
    }

    public final long g(long roomId, int query) {
        IAudienceRoom k3 = k(roomId, query);
        if (k3 != null) {
            return k3.getEnterRoomTime();
        }
        return 0L;
    }

    @NotNull
    public final String i(long roomId, int query) {
        String str;
        BaseRoomInfo roomInfo;
        IAudienceRoom k3 = k(roomId, query);
        if (k3 != null && (roomInfo = k3.getRoomInfo()) != null) {
            str = roomInfo.getProgramId();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final boolean o(long roomId, int query) {
        IAudienceRoom k3 = k(roomId, query);
        if (k3 != null && !k3.isDestroyed()) {
            return true;
        }
        return false;
    }
}
