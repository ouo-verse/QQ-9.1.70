package vb1;

import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    public static int a(com.tencent.wstt.SSCM.a aVar, long j3, long j16, long j17) {
        int i3;
        if (j17 == 0) {
            if (j3 >= aVar.d(BaseApplication.getContext(), j3, j17, 1024)) {
                j3 = 1024;
            }
            i3 = (int) j3;
        } else {
            long d16 = aVar.d(BaseApplication.getContext(), j3, j16, 131072);
            if (j3 < j16 + d16) {
                d16 = j3 - j16;
            }
            i3 = (int) d16;
        }
        int netWorkType = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getNetWorkType(BaseApplication.getContext());
        if ((netWorkType == 1 || netWorkType == 2) && i3 > 16384) {
            i3 = 16384;
        }
        int min = Math.min(i3, 1048576);
        if (QLog.isColorLevel()) {
            QLog.d("FileHttpUtils<FileAssistant>", 2, "sendFilePakage transferedSize[" + j16 + "], size[" + min + "]");
        }
        return min;
    }

    public static String b(byte[] bArr) {
        return ah.Q0(bArr);
    }

    public static boolean c(int i3) {
        if (i3 != 9052 && i3 != 9050 && i3 != 9055 && i3 != 9053 && i3 != 9054) {
            return false;
        }
        return true;
    }
}
