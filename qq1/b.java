package qq1;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.guild.config.z;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.m;
import com.tencent.mobileqq.guild.performance.report.GuildLiveGuestEnterRoomReportTask;
import com.tencent.mobileqq.guild.performance.report.l;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.h;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.guild.window.o;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.qqlive.api.room.EnterRoomReqConfig;
import com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b implements qq1.a {

    /* renamed from: a, reason: collision with root package name */
    private final GLiveChannelCore f429247a;

    /* renamed from: b, reason: collision with root package name */
    private ILiveAudienceTPPlayerRoom f429248b;

    /* renamed from: c, reason: collision with root package name */
    private long f429249c;

    /* renamed from: d, reason: collision with root package name */
    private long f429250d;

    /* renamed from: e, reason: collision with root package name */
    private long f429251e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f429252f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f429253g;

    /* renamed from: h, reason: collision with root package name */
    private IQQLiveSDK f429254h;

    /* renamed from: i, reason: collision with root package name */
    private String f429255i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.guild.live.livemanager.c f429256j;

    /* renamed from: l, reason: collision with root package name */
    private AudienceRoomConfig f429258l;

    /* renamed from: k, reason: collision with root package name */
    private int f429257k = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f429259m = false;

    /* renamed from: n, reason: collision with root package name */
    private WeakReference<QQCustomDialog> f429260n = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements EnterAudienceRoomCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f429261a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f429262b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f429263c;

        a(String str, long j3, long j16) {
            this.f429261a = str;
            this.f429262b = j3;
            this.f429263c = j16;
        }

        private boolean a(IQQLiveSDK iQQLiveSDK) {
            if (!b.this.f429259m && iQQLiveSDK.getLoginModule() != null && iQQLiveSDK.getLoginModule().getLoginRequest() != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
        public void onFailed(int i3, String str) {
            if (b.this.C(this.f429261a)) {
                b.this.f429253g = false;
                QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom fail code " + i3 + " msg " + str);
                if (i3 == 100003 && a(b.this.f429254h)) {
                    b.this.f429259m = true;
                    b.this.J(this.f429262b, this.f429261a, str);
                    return;
                } else {
                    b.this.M(this.f429262b, i3, vq1.c.a(this.f429263c, str));
                    b.this.F(this.f429262b, i3);
                    return;
                }
            }
            QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom onFailed, checkUseUuidIsValid == false, ignore callback.");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.EnterAudienceRoomCallback
        public void onSuccess(LiveInfo liveInfo) {
            LiveAnchorInfo liveAnchorInfo;
            if (b.this.C(this.f429261a)) {
                b.this.f429253g = false;
                GuildLiveTimeEvent guildLiveTimeEvent = GuildLiveTimeEvent.LIVE_SDK_AUDIENCE_ENTER_ROOM;
                GuildTimeRecHelper.d(guildLiveTimeEvent);
                GuildTimeRecHelper.d(GuildLiveTimeEvent.LAUNCH_BETWEEN_AUDIENCE_ENTER_LIVE_ROOM_END);
                l.c("audience_enter_room_success");
                QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom suc.");
                if (b.this.f429248b == null) {
                    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom mLiveAudienceRoom == null, ignore callback.");
                    return;
                }
                if (liveInfo != null && (liveAnchorInfo = liveInfo.anchorInfo) != null) {
                    b.this.f429249c = liveAnchorInfo.uid;
                    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom mLiveAnchorUid:" + b.this.f429249c);
                }
                b.this.f429251e = this.f429262b;
                if (!b.this.f429252f && !b.this.f429247a.x()) {
                    QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom suc, startPlay." + b.this.f429248b);
                    b bVar = b.this;
                    bVar.R(bVar.f429248b);
                    GuildTimeRecHelper.g(GuildLiveTimeEvent.START_PLAY_BETWEEN_SHOW_FIRST_FRAME);
                    l.c("live_room_player_start_play");
                    b.this.Q(null);
                    b.this.f429248b.startPlay(null);
                    b.this.f429252f = true;
                }
                b.this.f429247a.t().c0(Boolean.TRUE);
                GuildLiveGuestEnterRoomReportTask.j(GuildTimeRecHelper.f(guildLiveTimeEvent));
                return;
            }
            QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom onSuccess, checkUseUuidIsValid == false, ignore callback.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: qq1.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C11094b implements IQQLiveLoginCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f429265a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f429266b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f429267c;

        C11094b(String str, long j3, String str2) {
            this.f429265a = str;
            this.f429266b = j3;
            this.f429267c = str2;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
        public void onFailed(int i3, String str) {
            if (!b.this.C(this.f429265a)) {
                QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom onFailed, checkUseUuidIsValid == false, ignore callback.");
                return;
            }
            QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "reLoginLiveSdk fail code:" + i3 + " ,msg" + str);
            b.this.M(this.f429266b, i3, this.f429267c + " & " + str);
            b.this.F(this.f429266b, i3);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback
        public void onSuccess(LoginInfo loginInfo) {
            if (!b.this.C(this.f429265a)) {
                QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "enterRoom onFailed, checkUseUuidIsValid == false, ignore callback.");
            } else {
                QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "reLoginLiveSdk success");
                b.this.e(this.f429266b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILiveAudienceTPPlayerRoom f429269a;

        c(ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom) {
            this.f429269a = iLiveAudienceTPPlayerRoom;
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean disableViewCallback() {
            return this.f429269a.disableViewCallback();
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
        public boolean enableViewCallback() {
            return this.f429269a.enableViewCallback();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f429271d;

        d(long j3) {
            this.f429271d = j3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "handleEnterRoomFailed retry.");
            b.this.e(this.f429271d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        private boolean a(Activity activity) {
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                return true;
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "handleEnterRoomFailed exit.");
            Activity b16 = o.a().b("qqGuildLiveRoom");
            if (a(b16)) {
                b16.finish();
            }
            b.this.f429260n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class f extends AudienceRoomPlayerListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ uq1.b f429274a;

        f(uq1.b bVar) {
            this.f429274a = bVar;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onError(int i3, int i16, int i17, String str) {
            super.onError(i3, i16, i17, str);
            b.this.f429248b.unRegisterRoomPlayerListener(this);
            b.this.O(this.f429274a);
            b.this.N(this.f429274a, i3, i16, i17, str);
            QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "httpdns \u64ad\u653e\u5931\u8d25 module:" + i3 + " errorType:" + i16 + " errorCode:" + i17 + " extraInfo:" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onFirstFrameCome(long j3, long j16) {
            super.onFirstFrameCome(j3, j16);
            b.this.f429248b.unRegisterRoomPlayerListener(this);
            b.this.f429248b.setRetryParams(-1L, -1);
            com.tencent.mobileqq.guild.live.livemanager.player.a.a(true, this.f429274a.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class g extends AudienceRoomPlayerListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ uq1.b f429276a;

        g(uq1.b bVar) {
            this.f429276a = bVar;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onFirstFrameCome(long j3, long j16) {
            super.onFirstFrameCome(j3, j16);
            b.this.f429248b.unRegisterRoomPlayerListener(this);
            com.tencent.mobileqq.guild.live.livemanager.player.a.b(this.f429276a);
            b.this.f429247a.t().j0(Boolean.FALSE);
        }
    }

    public b(GLiveChannelCore gLiveChannelCore) {
        this.f429247a = gLiveChannelCore;
    }

    private boolean B() {
        if (this.f429253g || this.f429247a.t().n().getValue() == Boolean.TRUE) {
            return false;
        }
        if (!h.m(E(), Constants.Business.QQ_GUILD_LIVE_VIEWER, this.f429247a.g())) {
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "requestAVFocus failure.");
            d();
            return false;
        }
        if (this.f429247a.p().h()) {
            return true;
        }
        QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "audienceEnterRoom, live sdk not init suc.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(String str) {
        return TextUtils.equals(this.f429255i, str);
    }

    private void D() {
        com.tencent.mobileqq.guild.live.livemanager.c cVar = this.f429256j;
        if (cVar != null) {
            cVar.o();
            this.f429256j = null;
        }
    }

    private AppRuntime E() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(long j3, int i3) {
        d dVar;
        d();
        if (i3 != -12201) {
            dVar = new d(j3);
        } else {
            dVar = null;
        }
        WeakReference<QQCustomDialog> weakReference = this.f429260n;
        if (weakReference != null && weakReference.get() != null && this.f429260n.get().isShowing()) {
            return;
        }
        this.f429260n = new WeakReference<>(aa.c(dVar, new e()));
    }

    private void G(ILiveRoom iLiveRoom) {
        if (iLiveRoom == null) {
            QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "initLiveRoomListeners, liveRoom == null, please check it!!!");
            return;
        }
        com.tencent.mobileqq.guild.live.livemanager.c cVar = new com.tencent.mobileqq.guild.live.livemanager.c(iLiveRoom);
        this.f429256j = cVar;
        cVar.r();
    }

    private boolean H(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("http") && str.contains(".flv")) {
            return true;
        }
        return false;
    }

    private boolean I() {
        return z.f216289a.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(long j3, String str, String str2) {
        IQQLiveModuleLogin loginModule = this.f429254h.getLoginModule();
        K(loginModule.getLoginInfo());
        LoginRequest loginRequest = this.f429254h.getLoginModule().getLoginRequest();
        QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, "start reLoginLiveSdk");
        loginModule.reLogin(loginRequest, new C11094b(str, j3, str2));
    }

    private void K(LoginInfo loginInfo) {
        if (loginInfo != null) {
            QLog.e("QGL.QQGuildLiveAudienceRoomMgr", 1, ", lastLoginTime: " + loginInfo.lastLoginTime + ", current access token time gap: " + (NetConnInfoCenter.getServerTime() - loginInfo.lastLoginTime) + ", current server time period:" + ((NetConnInfoCenter.getServerTime() - loginInfo.lastLoginTime) + 259200) + ", a2 expire time:" + loginInfo.a2ExpireTime + ", localTime:" + System.currentTimeMillis());
        }
    }

    private void L(uq1.b bVar) {
        this.f429248b.registerRoomPlayerListener(new g(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(long j3, int i3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(j3));
        l.g("audience_enter_room_fail", hashMap, i3, str);
        GuildLiveGuestEnterRoomReportTask.k(GuildTimeRecHelper.f(GuildLiveTimeEvent.LIVE_SDK_AUDIENCE_ENTER_ROOM), i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(uq1.b bVar, int i3, int i16, int i17, String str) {
        boolean d16 = bVar.d();
        com.tencent.mobileqq.guild.live.livemanager.player.a.a(false, d16);
        com.tencent.mobileqq.guild.live.livemanager.player.a.c(d16, bVar, i3, i16, i17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(uq1.b bVar) {
        this.f429248b.setRetryParams(-1L, -1);
        this.f429248b.startPlay(bVar.c());
        L(bVar);
    }

    private void P(uq1.b bVar) {
        this.f429248b.setRetryParams(-1L, 0);
        QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 4, "httpdns startPlay:" + bVar.a());
        this.f429248b.startPlay(bVar.a());
        this.f429248b.registerRoomPlayerListener(new f(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(String str) {
        if (this.f429258l == null) {
            return;
        }
        boolean I = I();
        PlayerConfig playerConfig = this.f429258l.playerConfig;
        playerConfig.isSupportQuicFLv = I;
        playerConfig.enableQuicPlaintext = true;
        if (!TextUtils.isEmpty(str)) {
            boolean H = H(str);
            if (H) {
                PlayerConfig playerConfig2 = this.f429258l.playerConfig;
                playerConfig2.format = AudienceRoomConfig.VideoFormat.FLV;
                playerConfig2.isEnableDownloadProxy = com.tencent.mobileqq.guild.live.config.a.a();
            } else {
                PlayerConfig playerConfig3 = this.f429258l.playerConfig;
                playerConfig3.format = AudienceRoomConfig.VideoFormat.RTMP;
                playerConfig3.isEnableDownloadProxy = false;
            }
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "isFlvUrl:" + H);
        }
        QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "isSupportQuicFlv:" + I + ", format:" + this.f429258l.playerConfig.format + ", isEnableDownloadProxy:" + this.f429258l.playerConfig.isEnableDownloadProxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(@NonNull ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom) {
        this.f429247a.t().l0(iLiveAudienceTPPlayerRoom.getDisplayView().getCurrentDisplayView(), new c(iLiveAudienceTPPlayerRoom));
    }

    @Override // qq1.a
    public boolean a() {
        QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "createAudienceRoom...");
        if (this.f429248b == null) {
            l.c("audience_create_room");
            IQQLiveSDK f16 = this.f429247a.p().f();
            this.f429254h = f16;
            if (f16 == null) {
                IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(com.tencent.mobileqq.qqlive.business.a.f271158a);
                this.f429254h = sDKImpl;
                if (sDKImpl == null) {
                    QLog.w("QGL.QQGuildLiveAudienceRoomMgr", 1, "get QQLiveSDK failed");
                    return false;
                }
            }
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "mQQLiveSDK:" + this.f429254h.hashCode());
            AudienceRoomConfig audienceRoomConfig = new AudienceRoomConfig();
            this.f429258l = audienceRoomConfig;
            audienceRoomConfig.playerConfig = com.tencent.mobileqq.guild.live.livemanager.b.a(I());
            ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = (ILiveAudienceTPPlayerRoom) this.f429254h.createAudienceRoom(this.f429258l);
            this.f429248b = iLiveAudienceTPPlayerRoom;
            iLiveAudienceTPPlayerRoom.getDisplayView().setXYAxis(this.f429257k);
            G(this.f429248b);
            QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "sdk has init createAudienceRoom finish");
        } else {
            QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "mLiveAudienceRoom had exist.");
        }
        return true;
    }

    @Override // qq1.a
    public void b(int i3) {
        this.f429257k = i3;
    }

    @Override // qq1.a
    public String c() {
        ILiveAudienceTPPlayerRoom iLiveAudienceTPPlayerRoom = this.f429248b;
        if (iLiveAudienceTPPlayerRoom != null && iLiveAudienceTPPlayerRoom.getRoomInfo() != null) {
            return this.f429248b.getRoomInfo().getProgramId();
        }
        return null;
    }

    @Override // qq1.a
    public void d() {
        QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "audienceExitRoom.");
        if (this.f429248b != null) {
            l.c("audience_exit_room");
            D();
            this.f429248b.exitRoom(null);
            this.f429248b.destroy();
            this.f429248b = null;
            this.f429249c = 0L;
            this.f429250d = 0L;
            this.f429251e = 0L;
            this.f429252f = false;
            this.f429253g = false;
            this.f429255i = null;
            this.f429247a.t().c();
        }
        h.b(Constants.Business.QQ_GUILD_LIVE_VIEWER);
    }

    @Override // qq1.a
    public void e(long j3) {
        if (!B()) {
            return;
        }
        if (this.f429254h == null) {
            this.f429254h = this.f429247a.p().f();
        }
        if (this.f429248b == null && !a()) {
            QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "[audienceEnterRoom] createAudienceRoom failed return");
            return;
        }
        GuildLiveGuestEnterRoomReportTask.INSTANCE.e();
        LiveUserInfo userInfo = this.f429254h.getLoginModule().getUserInfo();
        if (userInfo == null) {
            QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "[audienceEnterRoom] userInfo = null");
            GuildLiveGuestEnterRoomReportTask.k(0L, 7001, "[audienceEnterRoom] userInfo = null");
            return;
        }
        this.f429250d = userInfo.uid;
        QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "createAudienceRoom mLiveSelfUid:" + this.f429250d);
        EnterRoomInfo enterRoomInfo = new EnterRoomInfo();
        enterRoomInfo.setTargetDefinition(EnterRoomInfo.VideoDefinition.FHD);
        enterRoomInfo.setRoomId(j3);
        QLog.d("QGL.QQGuildLiveAudienceRoomMgr", 1, "audienceEnterRoom start, roomId:" + j3);
        GuildTimeRecHelper.g(GuildLiveTimeEvent.LIVE_SDK_AUDIENCE_ENTER_ROOM);
        l.c("audience_enter_room_start");
        this.f429253g = true;
        long currentTimeMillis = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        this.f429255i = uuid;
        this.f429248b.enterRoom(enterRoomInfo, new EnterRoomReqConfig(true), false, new a(uuid, j3, currentTimeMillis));
    }

    @Override // qq1.a
    public void f(String str) {
        if (this.f429248b != null && !TextUtils.isEmpty(str) && !this.f429252f && !this.f429247a.x()) {
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "startPrePlay." + this.f429248b);
            R(this.f429248b);
            GuildTimeRecHelper.g(GuildLiveTimeEvent.START_PLAY_BETWEEN_SHOW_FIRST_FRAME);
            l.c("live_room_player_start_play");
            Q(str);
            uq1.b b16 = com.tencent.mobileqq.guild.live.helper.a.d().b(str);
            if (b16 != null) {
                P(b16);
            } else {
                this.f429248b.startPlay(str);
            }
            this.f429252f = true;
        }
    }

    @Override // qq1.a
    public long g() {
        return this.f429249c;
    }

    @Override // qq1.a
    public long getCurrentRoomId() {
        return this.f429251e;
    }

    @Override // qq1.a
    public void pausePlay() {
        if (this.f429248b != null) {
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "pause." + this.f429248b);
            this.f429248b.pause();
        }
    }

    @Override // qq1.a
    public void resumePlay() {
        if (this.f429248b != null) {
            QLog.i("QGL.QQGuildLiveAudienceRoomMgr", 1, "replay." + this.f429248b);
            this.f429248b.replay();
        }
    }
}
