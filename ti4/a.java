package ti4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.IResultListener;
import mm4.b;
import mqq.app.NewIntent;
import pl4.a;
import pl4.c;
import pl4.d;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoReq;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends pl4.a {

    /* compiled from: P */
    /* renamed from: ti4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11292a implements d<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f436378a;

        C11292a(IResultListener iResultListener) {
            this.f436378a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp, @Nullable FromServiceMsg fromServiceMsg) {
            if (z16) {
                i3 = i16;
            }
            if (!z16) {
                str2 = "\u7f51\u7edc\u4e0d\u7ed9\u529b";
            }
            IResultListener iResultListener = this.f436378a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp, FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f436378a;
            if (iResultListener != null) {
                iResultListener.onSuccess(premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
            }
        }
    }

    private static NewIntent d(long j3, int i3, kf4.a aVar) {
        PremadesTeamServerOuterClass$GetChannelLiveRoomInfoReq premadesTeamServerOuterClass$GetChannelLiveRoomInfoReq = new PremadesTeamServerOuterClass$GetChannelLiveRoomInfoReq();
        premadesTeamServerOuterClass$GetChannelLiveRoomInfoReq.game_id.set(i3);
        premadesTeamServerOuterClass$GetChannelLiveRoomInfoReq.uid.set(j3);
        if (aVar != null) {
            premadesTeamServerOuterClass$GetChannelLiveRoomInfoReq.guild_id.set(aVar.f412310a);
            premadesTeamServerOuterClass$GetChannelLiveRoomInfoReq.channel_id.set(aVar.f412311b);
        }
        return a.C11028a.a(premadesTeamServerOuterClass$GetChannelLiveRoomInfoReq, a.class);
    }

    public static void e(long j3, int i3, kf4.a aVar, IResultListener<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> iResultListener) {
        ((c) b.b(c.class)).F1(d(j3, i3, aVar), PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp.class, new C11292a(iResultListener));
    }

    @Override // pl4.a
    protected int b() {
        return 335;
    }
}
