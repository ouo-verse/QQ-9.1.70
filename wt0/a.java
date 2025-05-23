package wt0;

import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import nh2.c;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* compiled from: P */
    /* renamed from: wt0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    class C11506a implements MainTicketCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IQQLiveSDK f446472a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f446473b;

        C11506a(IQQLiveSDK iQQLiveSDK, AppRuntime appRuntime) {
            this.f446472a = iQQLiveSDK;
            this.f446473b = appRuntime;
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int i3, String str) {
            QLog.i("QQLiveJumpUtil", 1, "initSdk async get login ticket fail");
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(MainTicketInfo mainTicketInfo) {
            QLog.i("QQLiveJumpUtil", 1, "initSdk async get login ticket success");
            a.e(this.f446472a, this.f446473b, mainTicketInfo.getA2());
        }
    }

    public static boolean b() {
        QQLiveCurRoomInfo curRoomInfo;
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl == null || (curRoomInfo = sDKImpl.getCurRoomInfo()) == null || curRoomInfo.roomType != 1) {
            return false;
        }
        return true;
    }

    public static String c() {
        return "571ab62646abd99881be652d3e250a39";
    }

    public static void d(boolean z16) {
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (sDKImpl != null && !sDKImpl.isInited()) {
            sDKImpl.init(peekAppRuntime, QQLiveSDKConfigHelper.getDefIQQLiveSDK());
            if (z16) {
                TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
                if (ticketManager.useAsyncTicketInterface()) {
                    ticketManager.getA2(bv.b(peekAppRuntime.getCurrentUin(), 0L), 16, new C11506a(sDKImpl, peekAppRuntime));
                } else {
                    String a26 = ticketManager.getA2(peekAppRuntime.getCurrentUin());
                    QLog.i("QQLiveJumpUtil", 1, "initSdk sync get login ticket");
                    e(sDKImpl, peekAppRuntime, a26);
                }
            }
        }
        c sDKImpl2 = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        com.tencent.mobileqq.qqgift.sdk.config.a b16 = com.tencent.mobileqq.qqgift.sdk.config.a.a().d(QQLiveSDKConfigHelper.getSceneId()).a(c()).b();
        if (sDKImpl2 != null && !sDKImpl2.isInited()) {
            sDKImpl2.c(peekAppRuntime, b16);
        }
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).initLiveModule(BaseApplication.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(IQQLiveSDK iQQLiveSDK, AppRuntime appRuntime, String str) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.uin = appRuntime.getCurrentUin();
        loginRequest.qqA2 = str;
        loginRequest.authAppId = QQLiveSDKConfigHelper.getLoginAuthAppId();
        loginRequest.extData = QQLiveSDKConfigHelper.getLoginExtData();
        iQQLiveSDK.getLoginModule().login(loginRequest, null);
    }
}
