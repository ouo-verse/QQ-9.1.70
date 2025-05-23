package r32;

import android.text.TextUtils;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.data.login.LoginInfo;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.data.login.LoginRequest;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements IQQLiveModuleLogin {
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private volatile LoginRequest f430667d;

    /* renamed from: e, reason: collision with root package name */
    private volatile LoginInfo f430668e;

    /* renamed from: h, reason: collision with root package name */
    private IQQLiveSDK f430670h;

    /* renamed from: f, reason: collision with root package name */
    private final List<w22.a> f430669f = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final List<w22.a> f430671i = new CopyOnWriteArrayList();

    /* renamed from: m, reason: collision with root package name */
    private volatile int f430672m = 0;

    private void l(int i3, int i16) {
        int i17 = this.f430672m;
        if (QLog.isColorLevel()) {
            rt0.a.f("ICGameLogin|ICGameLoginLogic", "changeState", "hash:" + this.C + ", old:" + i17 + ", new:" + i3 + ", check:" + i16);
        }
        if (i17 == i3) {
            return;
        }
        if (i16 > -1 && i17 != i16) {
            return;
        }
        this.f430672m = i3;
    }

    private boolean m(String str, LoginRequest loginRequest, LoginInfo loginInfo, String str2) {
        if (loginRequest == null) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "checkLoginInfo", "hash:" + this.C + ", " + str2 + ", requestInfo is null");
            return false;
        }
        if (loginInfo == null) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "checkLoginInfo", "hash:" + this.C + ", " + str2 + ", loginInfo is null");
            return false;
        }
        if (!TextUtils.equals(loginInfo.originUin, loginRequest.uin)) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "checkLoginInfo", "hash:" + this.C + ", " + str2 + ", uin not equal");
            return false;
        }
        if (!str.equals(loginInfo.appId)) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "checkLoginInfo", "hash:" + this.C + ", " + str2 + ", clientType not equal");
            return false;
        }
        if (!loginInfo.isValid()) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "checkLoginInfo", "hash:" + this.C + ", " + str2 + ", loginInfo not valid");
            return false;
        }
        return true;
    }

    private LoginInfo n(String str, LoginRequest loginRequest) {
        LoginInfo loginInfo = this.f430668e;
        if (isLogined() && m(str, loginRequest, loginInfo, "memCache")) {
            return loginInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o(QQLiveResponse qQLiveResponse) {
        if (!qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
            IQQLiveSDK iQQLiveSDK = this.f430670h;
            if (iQQLiveSDK == null) {
                p(5105, "invalid live sdk");
                return Unit.INSTANCE;
            }
            q(iQQLiveSDK.getAppId(), (LiveLoginInfo) qQLiveResponse.getRsp());
            return Unit.INSTANCE;
        }
        p(5105, "retCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        return Unit.INSTANCE;
    }

    private void p(int i3, String str) {
        rt0.a.f("ICGameLogin|ICGameLoginLogic", "onLoginCallFail", "hash:" + this.C + ", code:" + i3 + ", msg:" + str);
        l(3, 2);
        try {
            Iterator<w22.a> it = this.f430669f.iterator();
            while (it.hasNext()) {
                it.next().onFailed(i3, str);
            }
        } catch (Throwable th5) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "onLoginCallFail", th5.getMessage());
        }
        try {
            if (this.f430671i.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f430671i);
            this.f430671i.clear();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ((w22.a) it5.next()).onFailed(i3, str);
            }
        } catch (Throwable th6) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "onLoginCallFail", th6.getMessage());
        }
    }

    private void q(String str, LiveLoginInfo liveLoginInfo) {
        rt0.a.f("ICGameLogin|ICGameLoginLogic", "onLoginCallback", "hash:" + this.C);
        LoginInfo loginInfo = new LoginInfo(liveLoginInfo);
        if (!m(str, this.f430667d, loginInfo, "net")) {
            p(9999, "hash:" + this.C + "checkLoginInfo invalid");
            return;
        }
        if (this.f430672m != 2) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "onLoginCallback", "hash:" + this.C + ", state=" + this.f430672m + ", ignore");
            return;
        }
        setLoginInfo(loginInfo);
        r(loginInfo, "net");
    }

    private void r(LoginInfo loginInfo, String str) {
        if (loginInfo.userInfo == null) {
            rt0.a.c("ICGameLogin|ICGameLoginLogic", "onSuccessCallback", "liveUserInfo is null from:" + str);
        }
        rt0.a.f("ICGameLogin|ICGameLoginLogic", "onSuccessCallback", "hash:" + this.C + ", from:" + str);
        l(1, 2);
        Iterator<w22.a> it = this.f430669f.iterator();
        while (it.hasNext()) {
            try {
                it.next().onSuccess(loginInfo);
            } catch (Throwable th5) {
                rt0.a.d("ICGameLogin|ICGameLoginLogic", "onSuccessCallback", "", th5);
            }
        }
        if (this.f430671i.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f430671i);
        this.f430671i.clear();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            try {
                ((w22.a) it5.next()).onSuccess(loginInfo);
            } catch (Throwable th6) {
                rt0.a.d("ICGameLogin|ICGameLoginLogic", "onSuccessCallback", "", th6);
            }
        }
    }

    private void setLoginInfo(LoginInfo loginInfo) {
        this.f430668e = loginInfo;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        rt0.a.f("ICGameLogin|ICGameLoginLogic", "destroy", "hash:" + this.C);
        l(0, -1);
        this.f430669f.clear();
        this.f430671i.clear();
        rt0.a.b("ICGameLogin|ICGameLoginLogic", "destroy", "clear all login callback size: " + this.f430669f.size());
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public LoginInfo getLoginInfo() {
        return this.f430668e;
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public LoginRequest getLoginRequest() {
        return this.f430667d;
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public int getLoginStatus() {
        return this.f430672m;
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public LiveUserInfo getUserInfo() {
        if (this.f430668e == null) {
            return null;
        }
        return this.f430668e.userInfo;
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        this.f430670h = iQQLiveSDK;
        this.C = hashCode();
        rt0.a.f("ICGameLogin|ICGameLoginLogic", "init", "hash:" + this.C + ", appId:" + iQQLiveSDK.getAppId());
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public boolean isLogined() {
        if (this.f430672m == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public synchronized void login(LoginRequest loginRequest, w22.a aVar) {
        String str;
        rt0.a.f("ICGameLogin|ICGameLoginLogic", "login", "hash:" + this.C + ", state:" + this.f430672m);
        if (this.f430670h == null) {
            rt0.a.f("ICGameLogin|ICGameLoginLogic", "login", "hash:" + this.C + "not inited, return");
            return;
        }
        if (aVar != null && !this.f430671i.contains(aVar)) {
            this.f430671i.add(aVar);
        }
        if (this.f430672m == 2) {
            return;
        }
        if (this.f430667d == null) {
            this.f430667d = loginRequest;
        }
        if (this.f430667d == null) {
            p(10000, this.C + ", login, requestInfo is null");
            return;
        }
        LoginInfo n3 = n(this.f430670h.getAppId(), this.f430667d);
        if (n3 != null) {
            rt0.a.f("ICGameLogin|ICGameLoginLogic", "login", "hash:" + this.C + ", hit mem cache");
            r(n3, "memCache");
            return;
        }
        l(2, -1);
        if (this.f430667d.uin == null) {
            str = "";
        } else {
            str = this.f430667d.uin;
        }
        ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(this.f430670h.getAppId(), str, new Function1() { // from class: r32.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o16;
                o16 = b.this.o((QQLiveResponse) obj);
                return o16;
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public void registerLoginStateCallback(w22.a aVar) {
        if (!this.f430669f.contains(aVar)) {
            this.f430669f.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        rt0.a.f("ICGameLogin|ICGameLoginLogic", "reset", "hash:" + this.C);
        l(0, -1);
        this.f430669f.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public void unregisterLoginStateCallback(w22.a aVar) {
        this.f430669f.remove(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin
    public void updateUserInfo(LiveUserInfo liveUserInfo) {
        if (this.f430668e != null && this.f430668e.userInfo != null && liveUserInfo != null) {
            if (!TextUtils.isEmpty(liveUserInfo.headUrl)) {
                this.f430668e.userInfo.headUrl = liveUserInfo.headUrl;
            }
            if (!TextUtils.isEmpty(liveUserInfo.nick)) {
                this.f430668e.userInfo.nick = liveUserInfo.nick;
            }
            this.f430668e.userInfo.sex = liveUserInfo.sex;
            rt0.a.f("ICGameLogin|ICGameLoginLogic", "updateUserInfo", "updateUserInfo success! " + liveUserInfo);
            return;
        }
        rt0.a.c("ICGameLogin|ICGameLoginLogic", "updateUserInfo", "updateUserInfo fail! loginInfo:" + this.f430668e + " userInfo:" + liveUserInfo);
    }
}
