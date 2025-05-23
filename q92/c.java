package q92;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected static long f428734a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected static long f428735b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected static long f428736c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected static long f428737d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected static long f428738e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected static long f428739f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected static int f428740g = 0;

    /* renamed from: h, reason: collision with root package name */
    protected static int f428741h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected static String f428742i = "";

    public static long a() {
        return f428739f - f428734a;
    }

    public static long b() {
        return f428739f - f428738e;
    }

    public static void c(int i3) {
        f428741h = i3;
        f428734a = 0L;
        f428735b = 0L;
        f428736c = 0L;
        f428738e = 0L;
        f428739f = 0L;
        f428740g = 0;
        f428742i = HttpUtil.getNetWorkType() + "";
        f428734a = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportEntryTime,time = " + f428734a);
        }
    }

    public static void d() {
        f428736c = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportFinisGetVideoInfoTime,time = " + f428736c);
        }
    }

    public static void e() {
        f428735b = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportStartGetVideoInfoTime,time = " + f428735b);
        }
    }

    public static void f() {
        f428738e = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportInitToPlayTime,time = " + f428738e);
        }
    }

    public static void g() {
        f428739f = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportStartPlayTime,time = " + f428739f);
        }
    }

    public static void h() {
        f428737d = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportUIInitFinishTime,time = " + f428737d);
        }
    }

    public static void i(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportVideoLoad,time =  feedid = " + str + " loadingTime =" + f428740g);
        }
        ReportController.o(null, INowVideoReporter.TAG, "grp_lbs", str, "video_quality", "play_load_again", i3, 0, String.valueOf(f428740g), "", "", "||" + str + "|||" + f428742i);
    }

    public static void j(String str, int i3, boolean z16) {
        if (f428741h != 0) {
            return;
        }
        long j3 = f428739f;
        long j16 = j3 - f428738e;
        long j17 = f428736c - f428735b;
        long j18 = f428737d;
        long j19 = f428734a;
        long j26 = j18 - j19;
        long j27 = j3 - j19;
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportVideoPlayLoadTime,videoLoadTime = " + j16 + " getVideoInfoTime = " + j17 + " initVideoListUITime =" + j26 + " allTimeConsume=" + j27 + " feedsid=" + str + " playType=" + i3 + " isUrlProvide=" + z16);
        }
        ReportController.o(null, INowVideoReporter.TAG, "grp_lbs", str, "video_quality", "play_loading_time", i3, z16 ? 1 : 0, String.valueOf(j16), String.valueOf(j17), String.valueOf(j26), String.valueOf(j27) + "||" + str + "|||" + f428742i);
    }

    public static void k(String str, int i3, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, "reportVideoPlayResult,time = feedid = " + str + " playType=" + i3 + " errCode=" + str2 + " subErrCode=" + str3);
        }
        ReportController.o(null, INowVideoReporter.TAG, "grp_lbs", str, "video_quality", "play_result", i3, 0, str2, str3, "", "||" + str + "|||" + f428742i);
    }

    public static void l(String str, int i3, String str2, String str3, String str4, String str5, boolean z16) {
        int i16 = 2;
        if (f428741h == 2) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QualityReporter", 2, " reportVideoSurportPlayOnline,time =  feedid = " + str + " reportType=" + i3 + " downloadProgress=" + str2 + " videoSize=" + str3 + "downloadedSize=" + str4 + "waitTime=" + (System.currentTimeMillis() - f428734a) + " isPlaying = " + z16 + " startPlayTime =  " + f428739f);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.currentTimeMillis() - f428734a);
        sb5.append("|");
        if (f428739f == 0) {
            i16 = 1;
        }
        sb5.append(i16);
        sb5.append("|");
        sb5.append(str);
        sb5.append("|||");
        sb5.append(f428742i);
        ReportController.o(null, INowVideoReporter.TAG, "grp_lbs", str, "video_quality", "play_support_online", i3, z16 ? 1 : 0, str2, str3, str4, sb5.toString());
    }
}
