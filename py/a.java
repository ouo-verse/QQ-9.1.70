package py;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qphone.base.util.QLog;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f428042a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f428043b = false;

    public static boolean a() {
        boolean z16;
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        if (c.v4() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (f428042a != studyModeSwitch || f428043b != z16) {
            f428042a = studyModeSwitch;
            f428043b = z16;
            QLog.d("SCF-ServiceAccountQCircleUtils", 1, "[isCircleRecommend] sIsStudyModeSwitch: " + f428042a + " | sIsQCircleSwitch: " + f428043b);
        }
        if (studyModeSwitch || !z16) {
            return false;
        }
        return true;
    }
}
