package yv;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.r;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f451278a = String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_AVCALL);

    public static boolean a(VideoAppInterface videoAppInterface, int i3, int i16) {
        boolean z16 = false;
        if (videoAppInterface == null) {
            return false;
        }
        boolean z17 = true;
        switch (i3) {
            case 1:
                z16 = e(videoAppInterface, 1);
                if (z16) {
                    z16 = a(videoAppInterface, 2, i16);
                    if (!z16) {
                        z16 = a(videoAppInterface, 6, i16);
                    }
                    if (!z16) {
                        z16 = a(videoAppInterface, 7, i16);
                    }
                    if (!z16) {
                        z16 = a(videoAppInterface, 9, i16);
                        break;
                    }
                }
                break;
            case 2:
                if (i16 == 2 || i16 == 4) {
                    z16 = true;
                }
                if (z16) {
                    z16 = e(videoAppInterface, 2);
                }
                if (z16) {
                    z16 = a(videoAppInterface, 3, i16);
                    break;
                }
                break;
            case 3:
                if (i16 == 2 || i16 == 4) {
                    z16 = true;
                }
                if (z16) {
                    z16 = e(videoAppInterface, 3);
                }
                if (z16 && !(z16 = a(videoAppInterface, 4, i16))) {
                    z16 = a(videoAppInterface, 5, i16);
                    break;
                }
                break;
            case 5:
                if (i16 != 2) {
                    z17 = false;
                }
                if (z17) {
                    z17 = e(videoAppInterface, 5);
                }
                if (!z17) {
                    z16 = z17;
                    break;
                }
                break;
            case 6:
                z16 = e(videoAppInterface, 6);
                break;
            case 7:
                if (i16 == 2 || i16 == 4) {
                    z16 = j.D();
                }
                if (z16) {
                    z16 = e(videoAppInterface, 7);
                }
                if (z16) {
                    z16 = a(videoAppInterface, 8, i16);
                    break;
                }
                break;
            case 8:
                if (i16 == 2 || i16 == 4) {
                    z16 = true;
                }
                if (z16) {
                    z16 = j.D();
                    break;
                }
                break;
            case 9:
                z16 = e(videoAppInterface, 9);
                break;
            case 11:
                if (i16 == 2 || i16 == 1) {
                    z16 = true;
                }
                if (z16) {
                    z16 = e(videoAppInterface, 11);
                    break;
                }
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AVRedTouchUtil", 2, "canShowRedTouch, id[" + i3 + "], show[" + z16 + "]");
        }
        return z16;
    }

    public static void b(VideoAppInterface videoAppInterface, RedTouch redTouch, int i3) {
        if (videoAppInterface != null && redTouch != null) {
            String c16 = c(i3);
            if (TextUtils.isEmpty(c16)) {
                QLog.d("AVRedTouchUtil", 1, "clearRedDot falied. appId[" + c16 + "], redTouch[" + redTouch + "]");
                return;
            }
            BusinessInfoCheckUpdate.AppInfo d16 = d(videoAppInterface, c16);
            if (f(d16)) {
                if ("105000.105100".equals(c16) || "105000.105200".equals(c16)) {
                    videoAppInterface.n0(f451278a);
                }
                videoAppInterface.n0(c16);
                redTouch.clearRedTouch();
                QLog.d("AVRedTouchUtil", 1, "clearRedDot successfully. appId[" + c16 + "], redTouch[" + redTouch + "]");
                return;
            }
            QLog.d("AVRedTouchUtil", 1, "clearRedDot falied. appId[" + c16 + "], redTouch[" + redTouch + "], appInfo[" + d16 + "], hasRedDot[" + f(d16) + "]");
        }
    }

    public static String c(int i3) {
        switch (i3) {
            case 0:
                return f451278a;
            case 1:
                return "105000.105100";
            case 2:
                return "105000.105100.105110";
            case 3:
                return "105000.105100.105110.105111";
            case 4:
                return "105000.105100.105110.105111.105116";
            case 5:
                return "105000.105100.105110.105111.105117";
            case 6:
                return "105000.105100.105120";
            case 7:
                return "105000.105100.105130";
            case 8:
                return "105000.105100.105130.105131";
            case 9:
                return "105000.105100.105140";
            case 10:
            default:
                return null;
            case 11:
                return "105000.105200";
        }
    }

    public static BusinessInfoCheckUpdate.AppInfo d(VideoAppInterface videoAppInterface, String str) {
        if (videoAppInterface != null) {
            return videoAppInterface.W(str);
        }
        return null;
    }

    private static boolean e(VideoAppInterface videoAppInterface, int i3) {
        String c16 = c(i3);
        if (TextUtils.isEmpty(c16)) {
            QLog.d("AVRedTouchUtil", 1, "hasRedDot falied. appId = " + c16);
            return false;
        }
        BusinessInfoCheckUpdate.AppInfo d16 = d(videoAppInterface, c16);
        if (f(d16)) {
            return true;
        }
        QLog.d("AVRedTouchUtil", 1, "hasRedDot falied. appId = " + c16 + ", appInfo = " + d16 + ", hasRedDot = false");
        return false;
    }

    public static boolean f(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null || appInfo.iNewFlag.get() == 0 || appInfo.exposure_max.get() < 0 || appInfo.red_display_info.get() == null || appInfo.red_display_info.red_type_info.get() == null || appInfo.red_display_info.red_type_info.get().size() == 0) {
            return false;
        }
        return true;
    }

    public static BusinessInfoCheckUpdate.AppInfo g(VideoAppInterface videoAppInterface, int i3) {
        int i16;
        if (videoAppInterface == null) {
            return null;
        }
        if (r.h0() != null && n.e().f() != null) {
            i16 = n.e().f().f73035i;
        } else {
            i16 = 0;
        }
        String c16 = c(i3);
        if (TextUtils.isEmpty(c16)) {
            QLog.d("AVRedTouchUtil", 1, "tryGetRedTouch failed. appId[" + c16 + "]");
            return null;
        }
        if (!a(videoAppInterface, i3, i16)) {
            QLog.d("AVRedTouchUtil", 1, "tryGetRedTouch failed. can not show red touch. appId = " + c16);
            return null;
        }
        BusinessInfoCheckUpdate.AppInfo d16 = d(videoAppInterface, c16);
        if (!f(d16)) {
            return null;
        }
        return d16;
    }

    public static RedTouch h(VideoAppInterface videoAppInterface, View view, int i3) {
        RedTouch applyTo;
        if (videoAppInterface != null && view != null) {
            String c16 = c(i3);
            BusinessInfoCheckUpdate.AppInfo g16 = g(videoAppInterface, i3);
            if (f(g16)) {
                ViewParent parent = view.getParent();
                if (parent instanceof RedTouch) {
                    applyTo = (RedTouch) parent;
                } else {
                    applyTo = new RedTouch(videoAppInterface.getApplication(), view).setGravity(53).applyTo();
                }
                applyTo.parseRedTouch(g16);
                if ("105000.105100".equals(c16)) {
                    videoAppInterface.o0(f451278a);
                }
                videoAppInterface.o0(c16);
                QLog.d("AVRedTouchUtil", 1, "tryGetRedTouchAndShowRedDot suc. appId[" + c16 + "], view[" + view + "], redTouch[" + applyTo + "]");
                return applyTo;
            }
            QLog.d("AVRedTouchUtil", 1, "tryGetRedTouchAndShowRedDot fail. appId[" + c16 + "], view[" + view + "], appInfo[" + g16 + "], hasRedDot[false]");
        }
        return null;
    }
}
