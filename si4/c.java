package si4;

import androidx.annotation.Nullable;
import com.tencent.timi.game.liveroom.impl.liveapi.manager.push.TgLivePushHandler;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.OneLiveServerOuterClass$QueryChanelAnchorCliRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c implements si4.a {

    /* renamed from: i, reason: collision with root package name */
    private static volatile c f433839i;

    /* renamed from: a, reason: collision with root package name */
    private boolean f433840a;

    /* renamed from: b, reason: collision with root package name */
    private int f433841b;

    /* renamed from: c, reason: collision with root package name */
    private kf4.a f433842c;

    /* renamed from: d, reason: collision with root package name */
    private long f433843d;

    /* renamed from: e, reason: collision with root package name */
    private kf4.b f433844e;

    /* renamed from: f, reason: collision with root package name */
    private TgLivePushHandler f433845f;

    /* renamed from: g, reason: collision with root package name */
    private PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp f433846g;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, List<si4.b>> f433847h = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements IResultListener<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kf4.a f433848a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IResultListener f433849b;

        a(kf4.a aVar, IResultListener iResultListener) {
            this.f433848a = aVar;
            this.f433849b = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp) {
            c.this.x(this.f433848a, premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
            IResultListener iResultListener = this.f433849b;
            if (iResultListener != null) {
                iResultListener.onSuccess(premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            IResultListener iResultListener = this.f433849b;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    public static void q() {
        synchronized (c.class) {
            if (f433839i != null) {
                f433839i.r();
                f433839i = null;
            }
        }
    }

    private void r() {
        v("destroyInternal cur= " + this.f433842c);
        if (this.f433847h.size() > 0) {
            Iterator<Map.Entry<String, List<si4.b>>> it = this.f433847h.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().clear();
            }
            this.f433847h.clear();
        }
        TgLivePushHandler tgLivePushHandler = this.f433845f;
        if (tgLivePushHandler != null) {
            tgLivePushHandler.e();
        }
        this.f433845f = null;
        this.f433841b = 0;
        this.f433842c = null;
        this.f433844e = null;
        this.f433846g = null;
        this.f433843d = 0L;
    }

    public static c s() {
        if (f433839i == null) {
            synchronized (c.class) {
                if (f433839i == null) {
                    f433839i = new c();
                }
            }
        }
        return f433839i;
    }

    private boolean t(kf4.a aVar) {
        kf4.a aVar2 = this.f433842c;
        if (aVar2 != null && aVar != null && aVar2.a().equals(aVar.a())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        l.c("TgLiveTag_Manager", 1, str);
    }

    private void v(String str) {
        l.h("TgLiveTag_Manager", 1, str);
    }

    private void w(kf4.a aVar, PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp) {
        List<si4.b> list = this.f433847h.get(aVar.a());
        if (list != null) {
            Iterator<si4.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
            }
        }
    }

    @Override // si4.a
    public void a(boolean z16, @NotNull kf4.a aVar, int i3) {
        v("enterLiveSuccess, " + aVar + ", liveGameId = " + i3 + ", isSelfAnchor = " + z16);
        this.f433840a = z16;
        this.f433842c = aVar;
        this.f433841b = i3;
        ((hi4.b) mm4.b.b(hi4.b.class)).d3(new b(aVar, i3));
    }

    @Override // si4.a
    public boolean b() {
        return this.f433840a;
    }

    @Override // si4.a
    public void c(@NotNull kf4.a aVar) {
        v("exitLive, " + aVar);
        if (t(aVar)) {
            q();
            return;
        }
        TgLivePushHandler tgLivePushHandler = this.f433845f;
        if (tgLivePushHandler != null && tgLivePushHandler.i(aVar)) {
            u("exitLive but mPushHandler equal! cur= " + this.f433842c + ", input=" + aVar);
            this.f433845f.e();
            this.f433845f = null;
            return;
        }
        u("exitLive but not equal! cur= " + this.f433842c + ", input=" + aVar);
    }

    @Override // si4.a
    public void d(kf4.b bVar) {
        this.f433844e = bVar;
    }

    @Override // si4.a
    @Nullable
    public kf4.b e() {
        return this.f433844e;
    }

    @Override // si4.a
    public void f(si4.b bVar) {
        if (bVar != null && this.f433847h.size() > 0) {
            Iterator<Map.Entry<String, List<si4.b>>> it = this.f433847h.entrySet().iterator();
            while (it.hasNext()) {
                List<si4.b> value = it.next().getValue();
                value.remove(bVar);
                if (value.size() == 0) {
                    it.remove();
                }
            }
        }
    }

    @Override // si4.a
    public long g() {
        return this.f433843d;
    }

    @Override // si4.a
    public PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp h(@NotNull kf4.a aVar) {
        if (t(aVar)) {
            return this.f433846g;
        }
        return null;
    }

    @Override // si4.a
    public void i(@NotNull kf4.a aVar, IResultListener<PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp> iResultListener) {
        if (!t(aVar)) {
            u("requestPushMsgFromNet but not equal! cur= " + this.f433842c + ", input=" + aVar);
        }
        if (!aVar.b()) {
            u("requestPushMsgFromNet, guildIdInfo invalid! = " + aVar);
            if (iResultListener != null) {
                iResultListener.onError(-222, "\u53c2\u6570\u5f02\u5e38");
                return;
            }
            return;
        }
        ti4.a.e(((ll4.a) mm4.b.b(ll4.a.class)).E().uid.get(), this.f433841b, aVar, new a(aVar, iResultListener));
    }

    @Override // si4.a
    public void j(@NotNull kf4.a aVar, si4.b bVar) {
        if (bVar != null) {
            List<si4.b> list = this.f433847h.get(aVar.a());
            if (list != null) {
                if (!list.contains(bVar)) {
                    list.add(bVar);
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar);
                this.f433847h.put(aVar.a(), arrayList);
            }
        }
    }

    @Override // si4.a
    @Nullable
    public kf4.a k() {
        return this.f433842c;
    }

    public void x(kf4.a aVar, PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp) {
        if (premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp != null) {
            if (t(aVar)) {
                this.f433846g = premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;
                w(aVar, premadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp);
                return;
            }
            u("updatePushMsg but not equal! cur= " + this.f433842c + ", input=" + aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements hi4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kf4.a f433851a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f433852b;

        b(kf4.a aVar, int i3) {
            this.f433851a = aVar;
            this.f433852b = i3;
        }

        @Override // hi4.a
        public void a(boolean z16) {
            if (c.this.f433845f != null && !c.this.f433845f.i(this.f433851a)) {
                c.this.u("enterLiveSuccess destroy old pushHandler - " + c.this.f433845f.g());
                c.this.f433845f.e();
                c.this.f433845f = null;
            }
            if (c.this.f433845f == null) {
                c.this.f433845f = new TgLivePushHandler(this.f433851a, this.f433852b);
            }
            c.this.f433845f.f();
            ak4.c.g(c.this.f433842c.f412310a, c.this.f433842c.f412311b, new a());
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a implements IResultListener<OneLiveServerOuterClass$QueryChanelAnchorCliRsp> {
            a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(OneLiveServerOuterClass$QueryChanelAnchorCliRsp oneLiveServerOuterClass$QueryChanelAnchorCliRsp) {
                if (oneLiveServerOuterClass$QueryChanelAnchorCliRsp != null) {
                    c.this.f433843d = oneLiveServerOuterClass$QueryChanelAnchorCliRsp.RoomID.get();
                }
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
            }
        }
    }
}
