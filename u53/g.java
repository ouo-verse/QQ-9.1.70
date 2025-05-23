package u53;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class g extends h {

    /* renamed from: f, reason: collision with root package name */
    private static final String f438414f;

    /* renamed from: g, reason: collision with root package name */
    private static final String f438415g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f438416h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f438417i;

    /* renamed from: j, reason: collision with root package name */
    private static final String f438418j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f438419k;

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_ROOT;
        sb5.append(str);
        sb5.append("/DCIM/Video/");
        f438414f = sb5.toString();
        f438415g = str + HardCodeUtil.qqStr(R.string.jno);
        f438416h = str + HardCodeUtil.qqStr(R.string.jnp);
        f438417i = str + "/Camera/Video/";
        f438418j = str + "/DCIM/Camera/";
        f438419k = str + "/DCIM/";
    }

    public static String a() {
        String str;
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (upperCase.contains("GN9000L")) {
            str = f438415g;
        } else if (!upperCase.contains("MX4") && !upperCase.contains("MX6") && !upperCase.contains("MX5") && !upperCase.contains("M355") && !upperCase.contains("M571C")) {
            if (upperCase.contains("M040")) {
                str = f438417i;
            } else if (!upperCase.contains("VIVO X7") && !upperCase.contains("VIVO X6A") && !upperCase.contains("VIVO XPLAY6") && !upperCase.contains("VIVO X5PRO") && !upperCase.contains("VIVO X9 PLUS") && !upperCase.contains("VIVO Y51A") && !upperCase.contains("VIVO X9I") && !upperCase.contains("VIVO X9") && !upperCase.contains("VIVO X6D")) {
                if (upperCase.contains("M1852")) {
                    str = f438419k;
                } else {
                    str = f438418j;
                }
            } else {
                str = f438416h;
            }
        } else {
            str = f438414f;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AEPath", 1, "getCameraPath, cameraPath: " + str + ", model: " + upperCase);
        }
        return str;
    }
}
