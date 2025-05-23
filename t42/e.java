package t42;

import android.content.Context;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    public static boolean a(Context context, int i3, int i16) {
        if (context == null || i3 == 0 || i16 == 0) {
            return false;
        }
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        if (PadUtil.a(BaseApplication.getContext()) != DeviceType.FOLD) {
            return false;
        }
        double d16 = i3 / i16;
        iAegisLogApi.i("ICGameFolderScreenUtil", 1, "isFolderScreenOpenModeByWH:" + d16 + "|configRatio:0.7099999785423279|maxRatio1.408450746791654__disPlayWidth| disPlayHeight:" + i3 + "|" + i16);
        if (d16 <= 0.7099999785423279d || d16 >= 1.408450746791654d) {
            return false;
        }
        return true;
    }
}
