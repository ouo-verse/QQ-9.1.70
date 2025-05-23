package rn;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.qzmoment.bean.QZMFolderInitBean;
import com.qzone.util.l;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.service.qzone.QZoneClearRedCountInfoEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static QZMFolderInitBean a(boolean z16) {
        QZMFolderInitBean qZMFolderInitBean = new QZMFolderInitBean();
        qZMFolderInitBean.setIsNeedToJumpMessagePage(z16);
        return qZMFolderInitBean;
    }

    public static boolean b(View view) {
        if (view == null) {
            return true;
        }
        return false;
    }

    public static void d() {
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(67);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneClearRedCountInfoEvent(67));
    }

    public static void e(int i3) {
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(i3);
        SimpleEventBus.getInstance().dispatchEvent(new QZoneClearRedCountInfoEvent(i3));
        com.tencent.mobileqq.service.qzone.b.v("");
    }

    public static QZoneCountInfo f() {
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(66);
        if (j(singleUnReadItem)) {
            singleUnReadItem.countId = 66;
        } else {
            singleUnReadItem = null;
        }
        if (singleUnReadItem == null) {
            singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(68);
            c(singleUnReadItem);
            if (singleUnReadItem != null) {
                singleUnReadItem.countId = 68;
            }
        }
        return singleUnReadItem;
    }

    public static String g(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            return "";
        }
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                QZoneCountUserInfo qZoneCountUserInfo = arrayList.get(i3);
                if (qZoneCountUserInfo != null && i3 < 3) {
                    arrayList2.add(Long.valueOf(qZoneCountUserInfo.uin));
                }
            }
            return TextUtils.join(",", arrayList2).hashCode() + "";
        }
        QLog.e("QZMEntranceViewHelper", 1, "invalidate list");
        return "";
    }

    public static boolean h(int i3) {
        if (i3 == 66) {
            return true;
        }
        return false;
    }

    public static boolean i(QZoneCountInfo qZoneCountInfo) {
        int e16 = com.tencent.mobileqq.service.qzone.b.e();
        int i3 = com.tencent.mobileqq.service.qzone.b.i();
        if (e16 != 0 && i3 != e16) {
            com.tencent.mobileqq.service.qzone.b.w(e16);
            return false;
        }
        if (qZoneCountInfo == null) {
            return true;
        }
        String g16 = g(qZoneCountInfo);
        String g17 = com.tencent.mobileqq.service.qzone.b.g();
        if (!TextUtils.isEmpty(g16) && g16.equals(g17)) {
            return true;
        }
        com.tencent.mobileqq.service.qzone.b.v(g16);
        return false;
    }

    public static void q(TextView textView, QZoneCountInfo qZoneCountInfo) {
        m(textView, FontSettingManager.isFontSizeLarge());
        if (qZoneCountInfo != null && qZoneCountInfo.uCount > 0 && h(qZoneCountInfo.countId)) {
            n(textView, false);
            return;
        }
        n(textView, true);
        if (qZoneCountInfo != null && !TextUtils.isEmpty(qZoneCountInfo.strShowMsg)) {
            l(textView, qZoneCountInfo.strShowMsg);
        } else {
            String h16 = com.tencent.mobileqq.service.qzone.b.h();
            if (!TextUtils.isEmpty(h16)) {
                l(textView, h16);
            } else {
                l(textView, "\u8bb0\u5f55\u6b64\u523b\uff0c\u5206\u4eab\u5feb\u4e50");
            }
        }
        r(textView);
    }

    public static void s(TextView textView, QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo != null && !TextUtils.isEmpty(qZoneCountInfo.strShowMsg)) {
            l(textView, qZoneCountInfo.strShowMsg);
            return;
        }
        String h16 = com.tencent.mobileqq.service.qzone.b.h();
        if (!TextUtils.isEmpty(h16)) {
            l(textView, h16);
        } else {
            l(textView, "\u8bb0\u5f55\u6b64\u523b\uff0c\u5206\u4eab\u5feb\u4e50");
        }
    }

    public static void c(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis > qZoneCountInfo.expireTime) {
            QLog.d("QZMEntranceViewHelper", 1, "clear expire red count info, current time is " + currentTimeMillis + " expire time is " + qZoneCountInfo.expireTime);
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(67);
            QZoneFeedAlertService.getInstance().clearSingleUnreadCount(68);
            SimpleEventBus.getInstance().dispatchEvent(new QZoneClearRedCountInfoEvent(67));
            SimpleEventBus.getInstance().dispatchEvent(new QZoneClearRedCountInfoEvent(68));
            com.tencent.mobileqq.service.qzone.b.v("");
        }
    }

    public static void k(QZoneUserAvatarView qZoneUserAvatarView, long j3) {
        if (qZoneUserAvatarView == null) {
            return;
        }
        qZoneUserAvatarView.setUser(j3);
        qZoneUserAvatarView.setIsShieldJumpToMainPage(true);
        n(qZoneUserAvatarView, true);
    }

    public static void l(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return;
        }
        textView.setText(str);
    }

    public static void o(TextView textView, QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo != null) {
            n(textView, true);
            long j3 = qZoneCountInfo.uCount;
            if (j3 < 99) {
                l(textView, String.valueOf(j3));
                return;
            } else {
                l(textView, l.a(R.string.w_k));
                return;
            }
        }
        n(textView, false);
    }

    public static void p(ImageView imageView, TextView textView, QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo != null) {
            if (h(qZoneCountInfo.countId)) {
                o(textView, qZoneCountInfo);
                n(imageView, false);
                return;
            } else {
                n(textView, false);
                n(imageView, true);
                return;
            }
        }
        n(imageView, false);
        n(textView, false);
    }

    private static void r(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_secondary));
    }

    public static boolean j(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            return false;
        }
        if (!TextUtils.isEmpty(qZoneCountInfo.strShowMsg) && qZoneCountInfo.uCount > 0) {
            return true;
        }
        QLog.e("QZMEntranceViewHelper", 1, "str show msg is " + qZoneCountInfo.strShowMsg + " uCount is " + qZoneCountInfo.uCount);
        return false;
    }

    public static void m(TextView textView, boolean z16) {
        if (textView == null) {
            return;
        }
        textView.setMaxEms(z16 ? 4 : 8);
    }

    public static void n(View view, boolean z16) {
        if (view == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 8);
    }
}
