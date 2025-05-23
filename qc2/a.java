package qc2;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.ai;
import com.tencent.mobileqq.config.business.ak;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.d;
import com.tencent.widget.OnlineBatteryProducer;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    ai f428843a = ak.f202506a.a();

    /* renamed from: b, reason: collision with root package name */
    OnlineBatteryProducer f428844b = new OnlineBatteryProducer();

    /* renamed from: c, reason: collision with root package name */
    long f428845c;

    /* renamed from: d, reason: collision with root package name */
    int f428846d;

    public boolean a(AppRuntime appRuntime, c cVar, OnlineStatusView onlineStatusView) {
        this.f428845c = cVar.e0();
        this.f428846d = d.a(cVar);
        au J = af.C().J(AppRuntime.Status.online, this.f428845c, !appRuntime.getCurrentUin().equals(cVar.f0()));
        if (J.f255493f == 2 || (this.f428845c == 1000 && this.f428846d <= 0)) {
            return false;
        }
        String o16 = af.C().o(appRuntime, J, J.f255494g, cVar, onlineStatusView.c(), 2);
        if (J.f255489b == 1030 && TextUtils.isEmpty(o16)) {
            return false;
        }
        if (J.f255489b == 1040 && TextUtils.isEmpty(o16)) {
            return false;
        }
        if (J.f255489b == 2000 && TextUtils.isEmpty(o16)) {
            return false;
        }
        if (au.d(this.f428845c)) {
            onlineStatusView.setIconDrawable(this.f428844b.createBatteryDrawable(this.f428846d, 0));
        } else {
            onlineStatusView.setIconDrawable(af.C().T(J, cVar));
        }
        onlineStatusView.setDescText(o16);
        return true;
    }
}
