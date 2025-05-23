package y02;

import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@Deprecated
/* loaded from: classes14.dex */
public class a {
    public static boolean a(String str, String str2) {
        return c(str).isExpHit(str2);
    }

    public static boolean b() {
        return ABTestController.getInstance().isTabSDKInited();
    }

    private static ExpEntityInfo c(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.ABT.GuildABTestUtils", 1, "[loadExperiment] expTagName: ", str, " | expInfo Exp: ", expEntity.getExpName(), " | assignment: " + expEntity.getAssignment(), " | isTABSDK inited: ", Boolean.valueOf(b()));
        }
        return expEntity;
    }

    public static void d(String str) {
        c(str).reportExpExposure();
    }
}
