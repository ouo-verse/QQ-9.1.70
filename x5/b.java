package x5;

import NS_MOBILE_FEEDS.s_join_list;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.qzone.common.event.ui.model.JoinList;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static Object[] a(s_join_list s_join_listVar) {
        return b(JoinList.create(s_join_listVar));
    }

    public static String c(Paint paint, String str, int i3, int i16) {
        if (paint != null && !TextUtils.isEmpty(str) && d(paint, str) > i16 && str.length() > i3 + 1) {
            String str2 = MiniBoxNoticeInfo.APPNAME_SUFFIX + str.substring(str.length() - i3, str.length());
            String substring = str.substring(0, str.length() - i3);
            for (int i17 = 1; i17 < substring.length(); i17++) {
                String str3 = str.substring(0, substring.length() - i17) + str2;
                if (d(paint, str3) <= i16) {
                    return str3;
                }
            }
        }
        return str;
    }

    private static int d(Paint paint, String str) {
        if (paint == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        rect.height();
        return rect.width();
    }

    public static Object[] b(JoinList joinList) {
        String str;
        String str2;
        String str3 = null;
        if (joinList == null || (str = joinList.desc) == null) {
            return null;
        }
        ArrayList<User> arrayList = joinList.users;
        String valueOf = String.valueOf(joinList.num);
        if (joinList.num >= 10000) {
            valueOf = String.format("%.1f", Float.valueOf(joinList.num / 10000.0f)) + l.a(R.string.maf);
        }
        if (joinList.isjoined == 1) {
            int i3 = joinList.num;
            if (i3 == 1) {
                str3 = l.a(R.string.mah);
            } else if (i3 == 2) {
                str3 = l.a(R.string.ma_);
                if (arrayList.size() > 0) {
                    str3 = str3 + "\u3001" + arrayList.get(0).nickName;
                }
            } else if (i3 > 2) {
                String a16 = l.a(R.string.mab);
                if (arrayList.size() > 0) {
                    a16 = a16 + "\u3001" + arrayList.get(0).nickName;
                }
                str3 = a16;
                str = l.a(R.string.maa) + valueOf + l.a(R.string.mad) + str;
            }
        } else {
            int i16 = joinList.num;
            if (i16 == 1) {
                if (arrayList.size() > 0) {
                    str3 = arrayList.get(0).nickName;
                } else {
                    str = valueOf + l.a(R.string.mac) + str;
                }
            } else if (i16 == 2) {
                if (arrayList.size() == 1) {
                    str3 = arrayList.get(0).nickName;
                } else if (arrayList.size() > 1) {
                    str3 = arrayList.get(0).nickName + "\u3001" + arrayList.get(1).nickName;
                } else {
                    str = valueOf + l.a(R.string.ma7) + str;
                }
            } else if (i16 > 2) {
                if (arrayList.size() == 1) {
                    str3 = arrayList.get(0).nickName;
                    str = l.a(R.string.mag) + valueOf + l.a(R.string.ma8) + str;
                } else if (arrayList.size() > 1) {
                    str3 = arrayList.get(0).nickName + "\u3001" + arrayList.get(1).nickName;
                    str = l.a(R.string.ma9) + valueOf + l.a(R.string.mai) + str;
                } else {
                    str = valueOf + l.a(R.string.mae) + str;
                }
            }
        }
        if (str3 != null) {
            str2 = str3 + str;
        } else {
            str2 = str;
        }
        return new Object[]{str2, Integer.valueOf(str.length())};
    }
}
