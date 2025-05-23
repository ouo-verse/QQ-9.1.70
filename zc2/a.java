package zc2;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    public static boolean a(String str) {
        boolean decodeBool = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations").decodeBool(str, true);
        QLog.d("QQRMonitorDebug", 1, str + ProgressTracer.SEPARATOR + decodeBool);
        return decodeBool;
    }
}
