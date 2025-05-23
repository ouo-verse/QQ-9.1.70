package uw0;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.icgame.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.icgame.game.liveroom.impl.room.util.QuickGiftBalanceEvent;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rh2.f;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f440493a = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: uw0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C11370a implements IQQGiftRechargeCallback {
        C11370a() {
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public Map<String, String> a() {
            return new HashMap();
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public void b(boolean z16, int i3, String str) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "openPayPanel", "success=" + z16 + ", errCode=" + i3 + ", errMsg=" + str);
            SimpleEventBus.getInstance().dispatchEvent(new QuickGiftBalanceEvent(z16, i3, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements rh2.a {
        final /* synthetic */ int C;
        final /* synthetic */ long D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqgift.data.service.d f440494d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f440495e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f440496f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f440497h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f440498i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f440499m;

        b(com.tencent.mobileqq.qqgift.data.service.d dVar, d dVar2, Activity activity, boolean z16, boolean z17, int i3, int i16, long j3) {
            this.f440494d = dVar;
            this.f440495e = dVar2;
            this.f440496f = activity;
            this.f440497h = z16;
            this.f440498i = z17;
            this.f440499m = i3;
            this.C = i16;
            this.D = j3;
        }

        @Override // rh2.a
        public void h(long j3, long j16, long j17, int i3) {
            if (a.n(this.f440494d.f264878f, j3, j16)) {
                if (this.f440495e != null) {
                    QQToast.makeText(BaseApplication.getContext(), "\u4f59\u989d\u4e0d\u8db3", 1).show();
                    this.f440495e.e(-6, "\u4f59\u989d\u4e0d\u8db3");
                    a.p(this.f440496f);
                    return;
                }
                return;
            }
            if (this.f440497h) {
                if (this.f440498i) {
                    a.q(this.f440496f, this.f440494d, this.f440499m, this.C, this.D, this.f440495e);
                    return;
                } else {
                    a.r(this.f440496f, this.f440494d, this.f440499m, this.f440495e);
                    return;
                }
            }
            d dVar = this.f440495e;
            if (dVar != null) {
                dVar.c(this.f440494d);
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            d dVar = this.f440495e;
            if (dVar != null) {
                dVar.e(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f440500d;

        c(d dVar) {
            this.f440500d = dVar;
        }

        @Override // rh2.f
        public void f(com.tencent.mobileqq.qqgift.data.service.d dVar) {
            d dVar2 = this.f440500d;
            if (dVar2 != null) {
                dVar2.c(dVar);
            }
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            d dVar = this.f440500d;
            if (dVar != null) {
                dVar.b(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface d {
        void a(int i3, String str);

        void b(int i3, String str);

        void c(com.tencent.mobileqq.qqgift.data.service.d dVar);

        void d(com.tencent.mobileqq.qqgift.data.service.d dVar);

        void e(int i3, String str);
    }

    private static f d(d dVar) {
        return new c(dVar);
    }

    private static void e(com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, d dVar2) {
        com.tencent.mobileqq.qqgift.data.service.c cVar = new com.tencent.mobileqq.qqgift.data.service.c();
        dVar.H = j3;
        xw0.b bVar = xw0.b.f448881a;
        cVar.f264860a = bVar.u();
        cVar.f264861b = bVar.d();
        cVar.f264870k.put(AudienceReportConst.ROOM_ID, String.valueOf(bVar.h()));
        Map<String, String> map = dVar.M;
        if (map != null && map.containsKey("batchSendCnt")) {
            cVar.f264870k.put("batchSendCnt", dVar.M.get("batchSendCnt"));
        }
        j(cVar.f264869j, "1");
        l().a().Q(cVar);
    }

    private static void f(Activity activity, boolean z16, boolean z17, long j3, long j16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j17, d dVar2) {
        f440493a = true;
        g(activity, z16, z17, j3, j16, dVar, i3, i16, j17, dVar2);
    }

    private static void g(Activity activity, boolean z16, boolean z17, long j3, long j16, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j17, d dVar2) {
        if (!o(j3, j16)) {
            if (n(dVar.f264878f, j3, j16)) {
                QQToast.makeText(BaseApplication.getContext(), "\u4f59\u989d\u4e0d\u8db3", 1).show();
                if (dVar2 != null) {
                    dVar2.e(-6, "\u4f59\u989d\u4e0d\u8db3");
                }
                p(activity);
                return;
            }
            if (!z16) {
                if (dVar2 != null) {
                    dVar2.d(dVar);
                    return;
                }
                return;
            } else if (z17) {
                q(activity, dVar, i3, i16, j17, dVar2);
                return;
            } else {
                r(activity, dVar, i3, dVar2);
                return;
            }
        }
        k(new b(dVar, dVar2, activity, z16, z17, i3, i16, j17));
    }

    private static boolean h(Activity activity, com.tencent.mobileqq.qqgift.data.service.d dVar, d dVar2) {
        if (activity == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "checkSendGiftCondition", "fail, activity is null");
            if (dVar2 != null) {
                dVar2.a(-1, "activity is null");
            }
            return false;
        }
        if (l() == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "checkSendGiftCondition", "fail, getGiftSdk is null");
            if (dVar2 != null) {
                dVar2.a(-2, "getGiftSdk is null");
            }
            return false;
        }
        if (l().e() == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "checkSendGiftCondition", "fail, getIdentifyModule is null");
            if (dVar2 != null) {
                dVar2.a(-3, "getIdentifyModule is null");
            }
            return false;
        }
        if (l().a() == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "checkSendGiftCondition", "fail, getServiceModule is null");
            if (dVar2 != null) {
                dVar2.a(-4, "getServiceModule is null");
            }
            return false;
        }
        if (dVar == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "checkSendGiftCondition", "fail, giftData is null");
            if (dVar2 != null) {
                dVar2.a(-5, "giftData is null");
                return true;
            }
            return true;
        }
        return true;
    }

    private static void i(com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, int i3, int i16, long j16) {
        LiveUserInfo selfUserInfo = m().getSelfUserInfo();
        if (selfUserInfo == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "dispatchGiftMessage", "fail, selfInfo is null");
            return;
        }
        IAudienceRoom N = m().N(j3);
        if (N == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "dispatchGiftMessage", "fail, audienceRoom is null");
            return;
        }
        if (N.getRoomLiveInfo() == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "dispatchGiftMessage", "fail, getRoomLiveInfo is null");
            return;
        }
        LiveAnchorInfo liveAnchorInfo = N.getRoomLiveInfo().anchorInfo;
        if (liveAnchorInfo == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "dispatchGiftMessage", "fail, anchorInfo is null");
            return;
        }
        GiftMessage giftMessage = new GiftMessage();
        giftMessage.effectLevel = dVar.f264883i;
        giftMessage.giftID = dVar.f264874d;
        giftMessage.giftName = dVar.f264876e;
        giftMessage.materialID = dVar.C;
        giftMessage.giftType = dVar.f264881h;
        giftMessage.giftNum = i3;
        giftMessage.sender = selfUserInfo.uid;
        giftMessage.senderHead = selfUserInfo.headUrl;
        giftMessage.senderNick = selfUserInfo.nick;
        giftMessage.receiverNick = liveAnchorInfo.nickName;
        giftMessage.receiverHead = liveAnchorInfo.headUrl;
        giftMessage.comboSeq = j16;
        giftMessage.allComboCnt = i16;
        giftMessage.giftPrice = dVar.f264878f;
        Map<String, String> map = dVar.M;
        if (map != null && map.containsKey("batchSendCnt")) {
            giftMessage.batchSendCnt = Long.parseLong(dVar.M.get("batchSendCnt"));
        }
        SimpleEventBus.getInstance().dispatchEvent(new TimiGiftEvent(giftMessage, j3, l().getSDKConfig().f264972a));
    }

    public static void j(ConcurrentHashMap<String, String> concurrentHashMap, String str) {
        if (concurrentHashMap == null) {
            return;
        }
        xw0.b bVar = xw0.b.f448881a;
        if (!TextUtils.isEmpty(bVar.q())) {
            concurrentHashMap.put("program_id", bVar.p());
            concurrentHashMap.put("anchor_uid", String.valueOf(bVar.d()));
            concurrentHashMap.put("roomid", String.valueOf(bVar.h()));
            concurrentHashMap.put("room_type", bVar.t());
            concurrentHashMap.put("room_enter_id", bVar.q());
            if (str == null) {
                str = "";
            }
            concurrentHashMap.put("source_from", str);
            concurrentHashMap.put("item_type", "\u793c\u7269");
            concurrentHashMap.put("ownerqq", String.valueOf(bVar.d()));
            concurrentHashMap.put("app_version", bVar.v());
            concurrentHashMap.put("qqlive_start_source", QQLiveSDKConfigHelper.getQQLiveAppId());
            concurrentHashMap.put("qqlive_coming_way", bVar.g());
            concurrentHashMap.put(QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, bVar.l());
        }
    }

    public static void k(rh2.a aVar) {
        if (aVar == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "getBalance", "fail, callback is null");
        } else if (l() != null && l().a() != null) {
            l().a().F(aVar);
        } else {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "getBalance", "getBalance fail, getGiftSdk or getServiceModule is null");
            aVar.onFailed(-1, "getBalance fail, getGiftSdk or getServiceModule is null");
        }
    }

    public static nh2.c l() {
        return ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
    }

    private static fu0.c m() {
        return (fu0.c) qx0.a.b(fu0.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(int i3, long j3, long j16) {
        long j17 = i3;
        if (j16 < j17 && j3 < j17) {
            return true;
        }
        return false;
    }

    private static boolean o(long j3, long j16) {
        if (j3 >= 0 && j16 >= 0) {
            return false;
        }
        return true;
    }

    public static void p(Activity activity) {
        if (activity == null) {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "openPayPanel", "activity is null");
        } else if (l() != null && l().f() != null) {
            l().f().I(activity, 1, false, new C11370a());
        } else {
            rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "openPayPanel", "getGiftSdk or getRechargeModule is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Activity activity, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, int i16, long j3, d dVar2) {
        e(dVar, j3, dVar2);
        i(dVar, xw0.b.f448881a.h(), i3, i16, j3);
        l().a().B(activity, dVar, i3, i16, d(dVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(Activity activity, com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, d dVar2) {
        e(dVar, 0L, dVar2);
        l().a().X(activity, dVar.f264874d, dVar.F, i3, d(dVar2));
    }

    public static void s(Activity activity, long j3, long j16, d dVar, int i3, int i16, long j17, com.tencent.mobileqq.qqgift.data.service.d dVar2) {
        if (!h(activity, dVar2, dVar)) {
            return;
        }
        if (f440493a) {
            g(activity, true, true, j3, j16, dVar2, i3, i16, j17, dVar);
        } else {
            f(activity, true, true, j3, j16, dVar2, i3, i16, j17, dVar);
        }
    }

    public static void t(com.tencent.mobileqq.qqgift.data.service.d dVar, long j3, int i3, int i16) {
        if (l() != null && l().a() != null) {
            if (dVar == null) {
                rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "sendComboGiftOver", "fail, giftData is null");
                return;
            } else {
                dVar.H = j3;
                l().a().w(dVar, 1, j3, i3, i16);
                return;
            }
        }
        rt0.a.c("ICGameGift|ICGameQuickGiftHelper", "sendComboGiftOver", "fail, giftSDK or ServiceModule is null");
    }
}
