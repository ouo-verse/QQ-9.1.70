package sa0;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.qqcircle.utils.l;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes4.dex */
public class b {
    public static void a(HashMap<String, String> hashMap) {
        boolean z16;
        String b16 = b();
        if (!b16.equals("exp_xsj_camera_B") && !b16.equals("exp_xsj_camera_C") && !b16.equals("exp_xsj_camera_D")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (Boolean.valueOf(z16).booleanValue() && !hashMap.containsKey("target")) {
            hashMap.put("target", "0");
            Map<String, String> tabParams = ABTestController.getInstance().getExpEntity("exp_xsj_camera").getTabParams();
            QLog.d("[QcirclePublish]WinkPublishJumpUtil", 1, "camera entrance exp cameraId:" + tabParams.get("cameraId"));
            QLog.d("[QcirclePublish]WinkPublishJumpUtil", 1, "camera entrance exp cameraMode:" + tabParams.get("cameraMode"));
            QLog.d("[QcirclePublish]WinkPublishJumpUtil", 1, "camera entrance exp materialId:" + tabParams.get(DKConfiguration.PreloadKeys.KEY_MATERIAL_ID));
            QLog.d("[QcirclePublish]WinkPublishJumpUtil", 1, "camera entrance exp needCacheCameraMode:" + tabParams.get("needCacheCameraMode"));
            hashMap.put("cameraId", tabParams.get("cameraId"));
            hashMap.put("cameraMode", tabParams.get("cameraMode"));
            hashMap.put("meterial", tabParams.get(DKConfiguration.PreloadKeys.KEY_MATERIAL_ID));
            hashMap.put("needCacheCameraMode", tabParams.get("needCacheCameraMode"));
        }
    }

    public static String b() {
        l.i("exp_xsj_camera");
        return l.b("exp_xsj_camera");
    }

    public static boolean c() {
        return false;
    }

    public static boolean d() {
        return false;
    }

    public static boolean e() {
        return false;
    }

    public static boolean f() {
        l.i("exp_xsj_ziliaoka_qianming");
        return l.d("exp_xsj_ziliaoka_qianming");
    }
}
