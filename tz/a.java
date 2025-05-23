package tz;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.e;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mz.d;
import nz.f;
import oz.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f437919a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private static String f437920b = "";

    private static WSStatisticsReporter.Builder a() {
        return new WSStatisticsReporter.Builder().setSopName("drama_preview").setTestId(bb.x(10012)).setPushId(v.b().c()).setFlush(true);
    }

    private static void b(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    private static WSStatisticsReporter.Builder c(String str, String str2, String str3, int i3) {
        return a().addParams("position", str).addParams("feed_id", str2).addParams("owner_id", str3).addParams("action_id", String.valueOf(i3));
    }

    private static WSStatisticsReporter.Builder d(String str, String str2, String str3) {
        return a().addParams("position", str).addParams("feed_id", str2).addParams("owner_id", str3);
    }

    private static String e(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1282366045:
                if (str.equals("aio_red_dot")) {
                    c16 = 0;
                    break;
                }
                break;
            case -763476863:
                if (str.equals("grid_drama_card")) {
                    c16 = 1;
                    break;
                }
                break;
            case 836791522:
                if (str.equals("grid_drama_follow")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "direct";
            case 1:
                return "feeds";
            case 2:
                return "feeds_history";
            default:
                return "";
        }
    }

    public static void f(String str, String str2, String str3, int i3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str3);
        hashMap.put("micro_drama_num", String.valueOf(i3));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str4));
        b(c("drama_close", str, str2, 1000001).addExtParams(hashMap), "gzh_click");
    }

    public static void g(String str, String str2, String str3, int i3, String str4) {
        q(str, str2, str3, i3, "drama_fullscreen", str4);
    }

    public static void h(String str, String str2, String str3, int i3, c cVar, String str4, int i16) {
        Object obj;
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str3);
        hashMap.put("micro_drama_num", String.valueOf(i3));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str4));
        hashMap.put("cover_drama_id", cVar.a());
        hashMap.put("cover_drama_num", String.valueOf(cVar.c()));
        String str5 = "1";
        if (cVar.e()) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("is_play", obj);
        if (cVar.f()) {
            str5 = "0";
        }
        hashMap.put("is_update", str5);
        hashMap.put("update_num", String.valueOf(cVar.c()));
        hashMap.put("play_num", String.valueOf(cVar.d()));
        b(c("drama_more_drama" + (i16 + 1), str, str2, 1000001).addExtParams(hashMap), "gzh_click");
    }

    public static void i(String str, String str2, String str3, int i3, c cVar, String str4, int i16) {
        Object obj;
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str3);
        hashMap.put("micro_drama_num", String.valueOf(i3));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str4));
        hashMap.put("cover_drama_id", cVar.a());
        hashMap.put("cover_drama_num", String.valueOf(cVar.c()));
        String str5 = "1";
        if (cVar.e()) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("is_play", obj);
        if (cVar.f()) {
            str5 = "0";
        }
        hashMap.put("is_update", str5);
        hashMap.put("update_num", String.valueOf(cVar.c()));
        hashMap.put("play_num", String.valueOf(cVar.d()));
        b(d("drama_more_drama" + (i16 + 1), str, str2).addExtParams(hashMap), "gzh_exposure");
    }

    public static void j(String str, String str2, String str3, int i3, String str4, int i16, int i17) {
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str3);
        hashMap.put("micro_drama_num", String.valueOf(i3));
        hashMap.put("status", String.valueOf(i16));
        hashMap.put("data_status", String.valueOf(i17));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str4));
        b(c("drama_more", str, str2, 1000001).addExtParams(hashMap), "gzh_click");
    }

    public static void o(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str));
        WSPublicAccReport.getInstance().reportPageVisitEnter("drama_preview", hashMap);
    }

    public static void p(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str));
        WSPublicAccReport.getInstance().reportPageVisitExit("drama_preview", hashMap);
    }

    public static void q(String str, String str2, String str3, int i3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str3);
        hashMap.put("micro_drama_num", String.valueOf(i3));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str5));
        b(c(str4, str, str2, 1000001).addExtParams(hashMap), "gzh_click");
    }

    public static void r(String str, String str2, String str3, int i3, String str4, int i16) {
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str3);
        hashMap.put("micro_drama_num", String.valueOf(i3));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str4));
        hashMap.put("poolType", String.valueOf(i16));
        b(d("drama_videoplay_video", str, str2).addExtParams(hashMap), "gzh_exposure");
    }

    public static void s(int i3, b bVar) {
        l lVar;
        String str;
        e d16 = bVar.d();
        if (d16 == null || (lVar = d16.f81127c) == null || com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.b(f437919a, i3, lVar)) {
            return;
        }
        if (i3 == 1) {
            f437920b = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.i(lVar.f81166a);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, String.valueOf(i3));
        hashMap.put("feed_id", lVar.f81166a);
        hashMap.put("owner_id", lVar.f81181p);
        hashMap.put("video_length", String.valueOf(lVar.f81169d));
        hashMap.put("recommend_id", "");
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_ID, f437920b);
        if (i3 == 2) {
            WSPlayerWrapper wSPlayerWrapper = d16.f81129e;
            long z16 = wSPlayerWrapper != null ? wSPlayerWrapper.z() : 0L;
            hashMap.put("duration", String.valueOf(wSPlayerWrapper != null ? wSPlayerWrapper.Q(bVar.f()) : 0L));
            hashMap.put("last_location", String.valueOf(z16));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("micro_drama_id", bVar.a());
        hashMap2.put("micro_drama_num", String.valueOf(bVar.b()));
        hashMap2.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(bVar.c()));
        hashMap2.put("poolType", String.valueOf(lVar.f81176k));
        if (i3 == 1) {
            if (bVar.e()) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap2.put(PlayParamConst.ParamKey.PLAY_TYPE, str);
        }
        b(a().addParams(hashMap).addExtParams(hashMap2), "gzh_video_play");
    }

    public static void t(String str, String str2, String str3, int i3, String str4) {
        q(str, str2, str3, i3, "drama_videoplay_video", str4);
    }

    public static void u(b bVar) {
        s(1, bVar);
    }

    public static void v(b bVar) {
        s(2, bVar);
    }

    public static void k(d dVar, int i3, int i16, boolean z16, String str) {
        String str2;
        int i17;
        String str3;
        if (dVar == null) {
            return;
        }
        d e16 = kz.c.d().e();
        if (e16 != null) {
            str2 = e16.d();
            i17 = e16.c();
        } else {
            str2 = "";
            i17 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str2);
        hashMap.put("micro_drama_num", String.valueOf(i17));
        hashMap.put("cover_drama_id", dVar.d());
        hashMap.put("cover_drama_num", String.valueOf(dVar.b()));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str));
        hashMap.put(PlayParamConst.ParamKey.PLAY_TYPE, String.valueOf(i16));
        if (z16) {
            str3 = "2";
        } else {
            str3 = "1";
        }
        hashMap.put("click_num", str3);
        b(c("drama_list_video" + (i3 + 1), dVar.f(), dVar.j(), 1000001).addExtParams(hashMap), "gzh_click");
    }

    public static void l(d dVar, int i3, String str) {
        String str2;
        int i16;
        if (dVar == null) {
            return;
        }
        d e16 = kz.c.d().e();
        if (e16 != null) {
            str2 = e16.d();
            i16 = e16.c();
        } else {
            str2 = "";
            i16 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str2);
        hashMap.put("micro_drama_num", String.valueOf(i16));
        hashMap.put("cover_drama_id", dVar.d());
        hashMap.put("cover_drama_num", String.valueOf(dVar.b()));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str));
        b(d("drama_list_video" + (i3 + 1), dVar.f(), dVar.j()).addExtParams(hashMap), "gzh_exposure");
    }

    public static void m(f fVar, int i3, long j3, String str) {
        String str2;
        int i16;
        String str3;
        if (fVar == null) {
            return;
        }
        d e16 = kz.c.d().e();
        if (e16 != null) {
            str2 = e16.d();
            str3 = e16.j();
            i16 = e16.c();
        } else {
            str2 = "";
            i16 = 0;
            str3 = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str2);
        hashMap.put("micro_drama_num", String.valueOf(i16));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str));
        hashMap.put("max_drama_num", String.valueOf(i3));
        hashMap.put("max_drama_times", String.valueOf(j3));
        b(d("drama_list_btn", fVar.a(), str3).addExtParams(hashMap), "gzh_exposure");
    }

    public static void n(f fVar, int i3, String str) {
        String str2;
        int i16;
        if (fVar == null) {
            return;
        }
        d e16 = kz.c.d().e();
        if (e16 != null) {
            str2 = e16.d();
            i16 = e16.a();
        } else {
            str2 = "";
            i16 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", str2);
        hashMap.put("micro_drama_num", String.valueOf(i16));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, e(str));
        hashMap.put(PlayParamConst.ParamKey.PLAY_TYPE, String.valueOf(i3));
        hashMap.put(WidgetCacheConstellationData.NUM, String.valueOf(fVar.b()));
        b(c("drama_list_btn", fVar.a(), fVar.c(), 1000001).addExtParams(hashMap), "gzh_click");
    }
}
