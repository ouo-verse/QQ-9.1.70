package qe0;

import android.text.TextUtils;
import com.tencent.biz.richframework.video.rfw.player.datacollect.action.RFWPlayerCollectBaseAction;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final /* synthetic */ class a {
    public static String a(RFWPlayerCollectBaseAction rFWPlayerCollectBaseAction, long j3, long j16) {
        return String.valueOf(((float) (j16 - j3)) / 1000.0f);
    }

    public static String b(RFWPlayerCollectBaseAction rFWPlayerCollectBaseAction, String str) {
        return "QFSPlayDataCollectManger_" + str;
    }

    public static String c(RFWPlayerCollectBaseAction rFWPlayerCollectBaseAction, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Map<String, String> arguments = URLUtil.getArguments(str);
        if (!arguments.containsKey(QCircleLpReportDc05507.KEY_PLAY_SCENE)) {
            return "";
        }
        return arguments.get(QCircleLpReportDc05507.KEY_PLAY_SCENE);
    }

    public static void d(RFWPlayerCollectBaseAction rFWPlayerCollectBaseAction, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Iterator<String> it = e(str2, str3).iterator();
            while (it.hasNext()) {
                QLog.d(str, 1, it.next());
            }
        }
    }

    public static List<String> e(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String str3 = str + ":" + str2;
        int ceil = (int) Math.ceil(str3.length() / 1000.0d);
        if (ceil == 1) {
            arrayList.add(str3);
            return arrayList;
        }
        int ceil2 = (int) Math.ceil(str2.length() / ceil);
        int i3 = 0;
        while (i3 < ceil) {
            int i16 = i3 * ceil2;
            i3++;
            arrayList.add(str + "-" + i3 + ":" + str2.substring(i16, Math.min(i3 * ceil2, str2.length())));
        }
        return arrayList;
    }
}
