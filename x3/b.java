package x3;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static boolean a() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_shopad_0308_9030");
        QLog.d("QWalletABTestUtils", 2, "isQQShopAdReportTestB: expEntityInfo, " + expEntity.toStr());
        expEntity.reportExpExposure();
        return expEntity.isExperiment("exp_shopad_0308_9030_B");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "exp_qqshop_jindoutab_for_long_tail";
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        QLog.d("QWalletABTestUtils", 2, "isQQShopCoinsTabTest: expEntityInfo, " + expEntity.toStr());
        if (expEntity.isExperiment(str + "_B")) {
            expEntity.reportExpExposure();
            return true;
        }
        return false;
    }
}
