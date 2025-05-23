package zj4;

import ag4.h;
import ag4.i;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import nf4.e;
import nf4.f;
import nf4.j;
import nf4.k;
import trpc.yes.common.OneLiveServerOuterClass$GetRoomSettingCliRsp;
import trpc.yes.common.OneLiveServerOuterClass$OffLiveCliRsp;
import trpc.yes.common.OneLiveServerOuterClass$SetRoomCliRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final f f452675a = zj4.a.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements nf4.e {

        /* compiled from: P */
        /* renamed from: zj4.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C11688a implements IResultListener<OneLiveServerOuterClass$SetRoomCliRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ nf4.a f452676a;

            C11688a(nf4.a aVar) {
                this.f452676a = aVar;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(OneLiveServerOuterClass$SetRoomCliRsp oneLiveServerOuterClass$SetRoomCliRsp) {
                b.h("initLiveRoomStatus SetRoomCliServlet - onSuccess");
                if (this.f452676a != null) {
                    j jVar = new j();
                    if (oneLiveServerOuterClass$SetRoomCliRsp != null) {
                        jVar.f420107b = oneLiveServerOuterClass$SetRoomCliRsp.SchemeUrl.get();
                        jVar.f420108c = oneLiveServerOuterClass$SetRoomCliRsp.LiveID.get();
                    }
                    this.f452676a.onSuccess(jVar);
                }
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                b.g("initLiveRoomStatus SetRoomCliServlet - onError: " + i3 + " - " + str);
                nf4.a aVar = this.f452676a;
                if (aVar != null) {
                    aVar.onError(i3, str);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: zj4.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class C11689b implements IResultListener<IUserInfo> {
            C11689b() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(IUserInfo iUserInfo) {
                b.h("initLiveRoomStatus getUserInfoFromDBOrNet - " + b.f(iUserInfo));
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                b.h("initLiveRoomStatus getUserInfoFromDBOrNet - onError: " + i3 + " - " + str);
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class c implements IResultListener<OneLiveServerOuterClass$GetRoomSettingCliRsp> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ nf4.a f452679a;

            c(nf4.a aVar) {
                this.f452679a = aVar;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(OneLiveServerOuterClass$GetRoomSettingCliRsp oneLiveServerOuterClass$GetRoomSettingCliRsp) {
                b.h("requestLiveRoomStatus onSuccess");
                if (this.f452679a != null) {
                    k kVar = new k();
                    if (oneLiveServerOuterClass$GetRoomSettingCliRsp != null) {
                        kVar.f420109a = oneLiveServerOuterClass$GetRoomSettingCliRsp.Status.get();
                        kVar.f420110b = oneLiveServerOuterClass$GetRoomSettingCliRsp.VersionSwitch.get();
                        kVar.f420111c = oneLiveServerOuterClass$GetRoomSettingCliRsp.RoomID.get();
                        kVar.f420112d = oneLiveServerOuterClass$GetRoomSettingCliRsp.SchemeUrl.get();
                        if (!TextUtils.isEmpty(oneLiveServerOuterClass$GetRoomSettingCliRsp.GuildID.get()) || !TextUtils.isEmpty(oneLiveServerOuterClass$GetRoomSettingCliRsp.ChannelID.get())) {
                            kVar.f420113e = new kf4.a(oneLiveServerOuterClass$GetRoomSettingCliRsp.GuildID.get(), oneLiveServerOuterClass$GetRoomSettingCliRsp.ChannelID.get());
                        }
                    }
                    this.f452679a.onSuccess(kVar);
                }
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                b.g("requestLiveRoomStatus onError - " + i3 + " - " + str);
                nf4.a aVar = this.f452679a;
                if (aVar != null) {
                    aVar.onError(i3, str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes26.dex */
        public class d implements IResultListener<IUserInfo> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ nf4.a f452681a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: zj4.b$a$d$a, reason: collision with other inner class name */
            /* loaded from: classes26.dex */
            public class C11690a implements IResultListener<OneLiveServerOuterClass$OffLiveCliRsp> {
                C11690a() {
                }

                @Override // com.tencent.timi.game.utils.IResultListener
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(OneLiveServerOuterClass$OffLiveCliRsp oneLiveServerOuterClass$OffLiveCliRsp) {
                    b.h("stopOneKeyLive - onSuccess");
                    nf4.a aVar = d.this.f452681a;
                    if (aVar != null) {
                        aVar.onSuccess(0);
                    }
                }

                @Override // com.tencent.timi.game.utils.IResultListener
                public void onError(int i3, String str) {
                    b.g("stopOneKeyLive - onError: " + i3 + " - " + str);
                    nf4.a aVar = d.this.f452681a;
                    if (aVar != null) {
                        aVar.onError(i3, str);
                    }
                }
            }

            d(nf4.a aVar) {
                this.f452681a = aVar;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(IUserInfo iUserInfo) {
                String f16 = b.f(iUserInfo);
                b.h("stopOneKeyLive getUserInfoFromDBOrNet - " + f16);
                if (TextUtils.isEmpty(f16)) {
                    nf4.a aVar = this.f452681a;
                    if (aVar != null) {
                        aVar.onError(-100, "\u6e38\u620f\u8d44\u6599\u83b7\u53d6\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                        return;
                    }
                    return;
                }
                ak4.b.e(f16, new C11690a());
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                b.g("stopOneKeyLive - onError: " + i3 + " - " + str);
                nf4.a aVar = this.f452681a;
                if (aVar != null) {
                    aVar.onError(i3, str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes26.dex */
        public class e implements ag4.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f452684a;

            e(int i3) {
                this.f452684a = i3;
            }

            @Override // ag4.f
            public void a() {
                b.h("isGameInstalled_" + this.f452684a + "-- onDownloadClick");
            }

            @Override // ag4.f
            public void b() {
                b.h("isGameInstalled_" + this.f452684a + "-- onNeedInstallDialogShown");
            }

            @Override // ag4.f
            public void onCancelClick() {
                b.h("isGameInstalled_" + this.f452684a + "-- onCancelClick");
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class f implements ag4.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ nf4.b f452686a;

            f(nf4.b bVar) {
                this.f452686a = bVar;
            }

            @Override // ag4.d
            public void a(String str) {
                nf4.b bVar = this.f452686a;
                if (bVar != null) {
                    bVar.onFailed(-789003, str);
                }
            }

            @Override // ag4.d
            public void onSuccess() {
                nf4.b bVar = this.f452686a;
                if (bVar != null) {
                    bVar.onSuccess();
                }
            }
        }

        a() {
        }

        @Override // nf4.e
        public void a(nf4.a<Integer> aVar) {
            ((bo4.d) mm4.b.b(bo4.d.class)).I3(((ll4.a) mm4.b.b(ll4.a.class)).E(), new d(aVar));
        }

        @Override // nf4.e
        public void b(int i3, String str, long j3, nf4.a<k> aVar) {
            ak4.a.e(i3, str, j3, new c(aVar));
        }

        @Override // nf4.e
        public long c() {
            return rm4.a.d("anchor_live_roomid", 0L);
        }

        @Override // nf4.e
        public void d(long j3) {
            rm4.a.j("anchor_live_roomid", j3);
        }

        @Override // nf4.e
        public void e(Activity activity, int i3, nf4.b bVar) {
            if (!j(activity, i3)) {
                if (bVar != null) {
                    bVar.onFailed(-789002, "\u6e38\u620f\u672a\u5b89\u88c5");
                    return;
                }
                return;
            }
            ((i) mm4.b.b(i.class)).L1(i3, activity, ag4.e.a(3), false, new f(bVar));
        }

        @Override // nf4.e
        public void f(int i3, String str, long j3, nf4.i iVar, nf4.a<j> aVar) {
            ak4.d.e(i3, str, j3, iVar, new C11688a(aVar));
            ((bo4.d) mm4.b.b(bo4.d.class)).I3(((ll4.a) mm4.b.b(ll4.a.class)).E(), new C11689b());
        }

        @Override // nf4.e
        public void g(String str) {
            rm4.a.k("anchor_live_launchid", str);
        }

        @Override // nf4.e
        public nf4.f h() {
            return b.f452675a;
        }

        @Override // nf4.e
        public String i() {
            return rm4.a.f("anchor_live_launchid", "");
        }

        public boolean j(Activity activity, int i3) {
            return ((h) mm4.b.b(h.class)).v2(activity, i3, true, true, "", "", "", new e(i3));
        }
    }

    public static e e() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(IUserInfo iUserInfo) {
        if (iUserInfo != null && iUserInfo.getUserGameOpenid() != null) {
            return iUserInfo.getUserGameOpenid().smoba_openid.get();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(String str) {
        l.c("QQLivePrepareFragment_AnchorRoomService", 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str) {
        l.h("QQLivePrepareFragment_AnchorRoomService", 1, str);
    }
}
