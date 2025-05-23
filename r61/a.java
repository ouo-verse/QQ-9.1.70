package r61;

import android.os.Bundle;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import cooperation.peak.PeakConstants;
import dov.com.qq.im.ae.current.SessionWrap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f430820a;

    public static Boolean a() {
        return f430820a;
    }

    public static boolean b() {
        if (a() != null) {
            return a().booleanValue();
        }
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("aio_camera_simple_mode_switch", true);
    }

    public static void c(p pVar, boolean z16, QBaseActivity qBaseActivity, QQAppInterface qQAppInterface, Bundle bundle) {
        js.a aVar;
        int i3 = 0;
        if (((ICaptureUtil) QRoute.api(ICaptureUtil.class)).supportCapture()) {
            Bundle c16 = StoryPublishLauncher.c(new SessionWrap(pVar.f179557e, pVar.f179563i, pVar.f179555d, pVar.f179559f), qBaseActivity.getClass().getName(), 10000, 100);
            boolean b16 = b();
            if (b16) {
                aVar = js.a.Q;
            } else {
                aVar = js.a.f410908h;
            }
            int i16 = 200;
            if (!b16 && !z16) {
                i16 = 201;
            }
            c16.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
            c16.putInt(AECameraConstants.AECAMERA_MODE, i16);
            if (b16) {
                c16.putInt(PeakConstants.ARG_FORCE_CAMERA, 2);
            }
            c16.putInt("qq_sub_business_id", 106);
            c16.putBoolean(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, z16);
            if (bundle != null) {
                c16.putAll(bundle);
            }
            StoryPublishLauncher.d().k(qBaseActivity, c16, 11);
            ((IAELaunchRecorder) QRoute.api(IAELaunchRecorder.class)).print(false);
            ((IAELaunchRecorder) QRoute.api(IAELaunchRecorder.class)).endSession();
            return;
        }
        if ((bundle == null || bundle.getInt("ability_flag", 0) != 2) && !SimpleUIUtil.getSimpleUISwitch()) {
            i3 = 1;
        }
        PlusPanelUtils.d(qQAppInterface, qBaseActivity, qBaseActivity, i3, -1);
    }
}
