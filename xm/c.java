package xm;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import java.util.Map;
import zm.d;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {
    public static boolean b(boolean z16) {
        String g16 = g();
        RFWLog.d("QZoneQQVideoConfig", RFWLog.USR, "[canTogetherRefreshRedPointWithQQVideo] wns val:" + g16);
        if (TextUtils.equals(g16, "1")) {
            RFWLog.e("QZoneQQVideoConfig", RFWLog.USR, "[canTogetherRefreshRedPointWithQQVideo] refresh disable");
            return false;
        }
        if (TextUtils.equals(g16, "3")) {
            return z16;
        }
        if (TextUtils.equals(g16, "2")) {
            return c();
        }
        if (TextUtils.equals(g16, "0")) {
            return c() && z16;
        }
        return true;
    }

    public static boolean c() {
        return d.f452771a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f() {
        com.tencent.mobileqq.activity.qcircle.utils.c.f().refreshRedPointData();
    }

    private static String g() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QQ_VIDEO_CLEAR_REDPOINT_STRATEGY, "3");
    }

    private static void d() {
        QLog.d("QZoneQQVideoConfig", 1, "[qqVideoRedPoint] doRealRefreshRedPoint for qfs");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: xm.b
            @Override // java.lang.Runnable
            public final void run() {
                c.f();
            }
        }, 2000L);
    }

    public static boolean e(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        if (!businessFeedData.isQQVideoFeeds()) {
            RFWLog.e("QZoneQQVideoConfig", RFWLog.USR, "[feedCanUseQQVideoLayer] isQQVideoFeeds return false");
            return false;
        }
        if (!c()) {
            RFWLog.e("QZoneQQVideoConfig", RFWLog.USR, "[feedCanUseQQVideoLayer] canUseQQVideoLayer return false");
            return false;
        }
        if (businessFeedData.getVideoInfo() == null) {
            RFWLog.e("QZoneQQVideoConfig", RFWLog.USR, "[feedCanUseQQVideoLayer] getVideoInfo is null");
            return false;
        }
        if (businessFeedData.qqVideoFeedStatus == 2) {
            RFWLog.e("QZoneQQVideoConfig", RFWLog.USR, "[feedCanUseQQVideoLayer] qqVideoFeedStatus is error");
            return false;
        }
        if (businessFeedData.getOperationInfo() == null) {
            RFWLog.e("QZoneQQVideoConfig", RFWLog.USR, "[feedCanUseQQVideoLayer] operationInfo is null");
            return false;
        }
        return !TextUtils.isEmpty(r5.qzoneFeedid);
    }

    public static void h(int i3, QZoneCountInfo qZoneCountInfo) {
        boolean z16;
        if (qZoneCountInfo != null && i3 == 1) {
            if (qZoneCountInfo.uCount <= 0) {
                QLog.d("QZoneQQVideoConfig", 1, "[qqVideoRedPoint] tryRefreshQFSRedPoint uCount :" + qZoneCountInfo.uCount);
                return;
            }
            Map<String, String> map = qZoneCountInfo.ext;
            QLog.d("QZoneQQVideoConfig", 1, "[qqVideoRedPoint] tryRefreshQFSRedPoint");
            if (map != null) {
                z16 = TextUtils.equals(map.get("has_ntgr_video_count"), "1");
            } else {
                QLog.d("QZoneQQVideoConfig", 1, "[qqVideoRedPoint] tryRefreshQFSRedPoint extMap is null");
                z16 = false;
            }
            QLog.d("QZoneQQVideoConfig", 1, "[qqVideoRedPoint] refresh from server flag,flag:" + z16);
            if (b(z16)) {
                QLog.d("QZoneQQVideoConfig", 1, "[qqVideoRedPoint] doRealRefreshRedPoint");
                d();
            }
        }
    }
}
