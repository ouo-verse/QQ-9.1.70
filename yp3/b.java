package yp3;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import zp3.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends ax {
    public b(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    private boolean F() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_common_channel_network_check_switch", true);
        QLog.i("OpenSdkCommonChannelJumpAction", 1, "checkNetworkSwitch: " + isSwitchOn);
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        String str = this.f307441f.get("src_id");
        String E = ax.E(this.f307441f.get("opensdk_ext_data"));
        zp3.b bVar = new zp3.b(this);
        QLog.i("OpenSdkCommonChannelJumpAction", 1, "doAction srcId: " + str + ", data: " + E);
        if (F() && !NetworkUtil.isNetworkAvailable()) {
            if (this.f307437b instanceof Activity) {
                xp3.b.e((Activity) this.f307437b, this.f307444i, true, Long.parseLong(this.f307441f.get("app_id")), this.f307437b.getString(R.string.zmz));
            }
            return true;
        }
        c a16 = a.a(str, this.f307436a, this.f307437b);
        if (a16 != null) {
            a16.a(E, bVar);
            this.f307458w = false;
        } else if (this.f307437b instanceof Activity) {
            xp3.b.e((Activity) this.f307437b, this.f307444i, true, Long.parseLong(this.f307441f.get("app_id")), this.f307437b.getString(R.string.zpi));
        }
        return false;
    }
}
