package qo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.util.ToastUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QzoneWinkOutputRouter;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import yo.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {
    public static boolean c() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        boolean isFlashCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady();
        boolean z17 = true;
        QLog.d("QZoneHostLauncher", 2, "checkBlockByResNotReady,videoSoUsable:", Boolean.valueOf(isFlashCameraResReady), ",cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "ms");
        if (isFlashCameraResReady) {
            z16 = false;
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: qo.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.f();
                }
            });
            z16 = true;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean isAEResExist = ((IAEResUtil) QRoute.api(IAEResUtil.class)).isAEResExist(AEResInfo.AE_RES_BASE_PACKAGE.agentType, QQWinkConstants.ENTRY_QQ_QZONE);
        QLog.d("QZoneHostLauncher", 2, "checkBlockByResNotReady,AEBasePkgSoUsable:", Boolean.valueOf(isAEResExist), ",cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), "ms");
        if (isAEResExist) {
            z17 = z16;
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: qo.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.g();
                }
            });
        }
        if (z17) {
            ToastUtil.s(BaseApplication.getContext().getString(R.string.ylw), 4);
        }
        return z17;
    }

    public static void d(Context context, String str, ArrayList<String> arrayList, String str2) {
        String str3 = str + String.format("&%s=%s", "mediapath", TextUtils.join(",", arrayList));
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str3);
        Object[] objArr = new Object[2];
        objArr[0] = "content";
        if (str2 == null) {
            str2 = "";
        }
        objArr[1] = str2;
        sb5.append(String.format("&%s=%s", objArr));
        d.d(((sb5.toString() + String.format("&%s=%s", QCircleScheme.AttrQQPublish.SHOW_PUBLISH_EXIT_DIALOG, "1")) + String.format("&%s=%s", "publish_trans_tag", 311)) + String.format("&%s= ", QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME), context, null);
    }

    public static void e(Context context, ArrayList<LocalMediaInfo> arrayList) {
        String str;
        if (c()) {
            QLog.e("QZoneHostLauncher", 1, "jumpToWinkEditorAutoTemplate blocked by res not ready!");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        bundle.putString("app_key", "0AND0MWZXR4U3RVU");
        bundle.putBoolean(QQWinkConstants.IS_AUTO_TEMPLATE, true);
        bundle.putBoolean("key_need_save_draft", false);
        bundle.putBoolean(QQWinkConstants.IS_IMAGE_MODEL, true);
        bundle.putBoolean(QQWinkConstants.IS_EDIT_TEXT, false);
        bundle.putBoolean(QQWinkConstants.IS_FROM_CAPTURE, false);
        bundle.putSerializable(QQWinkConstants.INPUT_MEDIA, arrayList);
        bundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", lc.b.b().getName());
        bundle.putString("wink_output_route", QzoneWinkOutputRouter.ROUTE_PATH);
        bundle.putLong("wink_output_point", 2L);
        if (QzoneFrame.isNewConciseFragment()) {
            str = WinkDaTongReportConstant.ElementParamValue.XSJ_QZONE_MODE_EXPERIENCE;
        } else {
            str = "normal";
        }
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_MODE, str);
        bundle.putString("xsj_ref_pgid", "qzone_myshuoshuo_list_photo");
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditor(context, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchAllEssentialBundles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g() {
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(AEResInfo.AE_RES_BASE_PACKAGE.agentType);
    }
}
