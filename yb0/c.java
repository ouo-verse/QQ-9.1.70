package yb0;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    private static DialogInterface.OnClickListener b(final Activity activity, final String str, final String str2) {
        if (activity == null) {
            return null;
        }
        return new DialogInterface.OnClickListener() { // from class: yb0.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.c(activity, str2, str, dialogInterface, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Activity activity, String str, String str2, DialogInterface dialogInterface, int i3) {
        if (i3 == 0) {
            com.tencent.biz.qqcircle.launcher.c.o0(activity, uq3.c.q3(), null, -1);
            e(str);
        } else if (i3 == 1) {
            e(str2);
        }
    }

    public static boolean d(QCircleShareInfo qCircleShareInfo) {
        if (qCircleShareInfo.albumStatus == 1) {
            return true;
        }
        return false;
    }

    private static void e(String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_CANCEL_BUTTON);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    private static void f(String str) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_eid", str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", buildElementParams);
    }

    public static void g(Activity activity) {
        DialogInterface.OnClickListener b16 = b(activity, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_EDIT_FEEDBACK_BUTTON, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_EDIT_KNOW_BUTTON);
        if (b16 != null && !activity.isFinishing()) {
            QCircleCustomDialog.S(activity, null, com.tencent.biz.qqcircle.utils.h.a(R.string.f181473dv), R.string.f181403do, R.string.f1910643s, b16, b16).show();
            f(QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_ASTRICT_EDIT_WINDOWS);
        }
    }

    public static void h(Activity activity) {
        DialogUtil.createCustomDialog(activity, 230, (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f19189461), (String) null, com.tencent.biz.qqcircle.utils.h.a(R.string.f1910643s), new a(), (DialogInterface.OnClickListener) null).show();
    }

    public static void i(Activity activity) {
        DialogInterface.OnClickListener b16 = b(activity, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_SHARE_FEEDBACK_BUTTON, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_DETAIL_SHARE_KNOW_BUTTON);
        if (b16 != null && !activity.isFinishing()) {
            QCircleCustomDialog.S(activity, null, com.tencent.biz.qqcircle.utils.h.a(R.string.f181503dy), R.string.f181403do, R.string.f1910643s, b16, b16).show();
            f(QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_ASTRICT_SHARE_WINDOWS);
        }
    }
}
