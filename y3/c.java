package y3;

import Wallet.GetPasswordReq;
import Wallet.GetSignV2Req;
import android.app.Activity;
import com.qwallet.activity.QWalletAppInterface;
import com.qwallet.activity.sso.d;
import com.qwallet.protocol.Wallet.PatternLock.SetPasswordReq;
import com.tencent.mobileqq.utils.ah;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public com.qwallet.activity.sso.c f449300a;

    /* renamed from: b, reason: collision with root package name */
    public com.qwallet.activity.sso.b f449301b;

    /* renamed from: c, reason: collision with root package name */
    public d f449302c;

    public c() {
        QWalletAppInterface qWalletAppInterface = QWalletAppInterface.getInstance();
        this.f449300a = (com.qwallet.activity.sso.c) qWalletAppInterface.getQWalletProtocolById(3);
        this.f449301b = (com.qwallet.activity.sso.b) qWalletAppInterface.getQWalletProtocolById(5);
        this.f449302c = (d) qWalletAppInterface.getQWalletProtocolById(2);
    }

    public void a(String str, String str2) {
        SetPasswordReq setPasswordReq = new SetPasswordReq();
        setPasswordReq.MQOS = "android";
        setPasswordReq.password = str;
        setPasswordReq.qpwd_token = str2;
        setPasswordReq.deviceId = QWalletHelperDelegate.getQWDevId();
        setPasswordReq.passwordType = 3;
        this.f449302c.w(2, true, null, setPasswordReq);
    }

    public void b(Activity activity) {
        GetPasswordReq getPasswordReq = new GetPasswordReq();
        getPasswordReq.MQOS = "android";
        getPasswordReq.MQVersion = ah.Q(activity);
        this.f449300a.w(2, true, null, getPasswordReq);
    }

    public void c(int i3) {
        GetSignV2Req getSignV2Req = new GetSignV2Req();
        getSignV2Req.MQOS = "android";
        this.f449301b.w(i3, true, null, getSignV2Req);
    }
}
