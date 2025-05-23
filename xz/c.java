package xz;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J-\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\t\u0010\nJ-\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\u000b\u0010\nJ-\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0004\b\f\u0010\nJ\u001c\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007JT\u0010\u0013\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J$\u0010\u0017\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0003J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0006H\u0003R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010 R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\"\u00a8\u0006&"}, d2 = {"Lxz/c;", "", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "playerParam", "", "position", "", "testId", "", "g", "(Lcom/tencent/biz/pubaccount/weishi/player/e;Ljava/lang/Integer;Ljava/lang/String;)V", "e", "f", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extParams", "actionId", "positionId", "c", "i", "", "isCompleted", "j", "eventType", tl.h.F, "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "a", "builder", AdMetricTag.EVENT_NAME, "b", "", "Ljava/util/Set;", "PLAYED_VIDEO_SET", "Ljava/lang/String;", "sPlayId", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f449124a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> PLAYED_VIDEO_SET = new HashSet();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String sPlayId = "";

    c() {
    }

    @JvmStatic
    private static final WSStatisticsReporter.Builder a(String testId) {
        WSStatisticsReporter.Builder flush = new WSStatisticsReporter.Builder().setSopName("mini_videoplay").setTestId(testId).setPushId(v.b().c()).setFlush(true);
        Intrinsics.checkNotNullExpressionValue(flush, "Builder()\n              \u2026          .setFlush(true)");
        return flush;
    }

    @JvmStatic
    private static final void b(WSStatisticsReporter.Builder builder, String eventName) {
        builder.build(eventName).report();
    }

    @JvmStatic
    public static final void d(com.tencent.biz.pubaccount.weishi.player.e playerParam, String testId) {
        f449124a.c(playerParam, null, testId, 1000001, "mini_videoplay_close");
    }

    @JvmStatic
    public static final void e(com.tencent.biz.pubaccount.weishi.player.e playerParam, Integer position, String testId) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (WSPublicAccReport.getInstance().isInWSPublicAccount()) {
            str = "inner";
        } else {
            str = "out";
        }
        hashMap.put("minivideo_play_scene", str);
        int intValue = position != null ? position.intValue() : 0;
        f449124a.c(playerParam, hashMap, testId, 1000001, "mini_videoplay_video" + (intValue + 1));
    }

    @JvmStatic
    public static final void j(com.tencent.biz.pubaccount.weishi.player.e playerParam, boolean isCompleted, String testId) {
        h(2, playerParam, isCompleted, testId);
    }

    private final void c(com.tencent.biz.pubaccount.weishi.player.e playerParam, HashMap<String, String> extParams, String testId, int actionId, String positionId) {
        l lVar = playerParam != null ? playerParam.f81127c : null;
        if (lVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("position", positionId);
        hashMap.put("feed_id", lVar.f81166a);
        hashMap.put("owner_id", lVar.f81181p);
        hashMap.put("global_key", com.tencent.biz.pubaccount.weishi.report.c.b().c(lVar.f81182q));
        hashMap.put("action_id", String.valueOf(actionId));
        if (extParams == null) {
            extParams = new HashMap<>();
        }
        extParams.put("type", String.valueOf(lVar.f81177l));
        extParams.put("poolType", String.valueOf(lVar.f81176k));
        extParams.put("opvideo_type", String.valueOf(lVar.f81184s));
        WSStatisticsReporter.Builder builder = a(testId).addParams(hashMap).addExtParams(extParams).addObjectParams("feed_pass_key", lVar.f81183r);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_click");
    }

    @JvmStatic
    public static final void f(com.tencent.biz.pubaccount.weishi.player.e playerParam, Integer position, String testId) {
        int intValue = position != null ? position.intValue() : 0;
        f449124a.c(playerParam, null, testId, 1007001, "mini_videoplay_video" + (intValue + 1));
    }

    @JvmStatic
    public static final void g(com.tencent.biz.pubaccount.weishi.player.e playerParam, Integer position, String testId) {
        l lVar = playerParam != null ? playerParam.f81127c : null;
        if (lVar == null) {
            return;
        }
        int intValue = position != null ? position.intValue() : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("position", "mini_videoplay_video" + (intValue + 1));
        hashMap.put("feed_id", lVar.f81166a);
        hashMap.put("owner_id", lVar.f81181p);
        hashMap.put("global_key", com.tencent.biz.pubaccount.weishi.report.c.b().c(lVar.f81182q));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", String.valueOf(lVar.f81177l));
        hashMap2.put("poolType", String.valueOf(lVar.f81176k));
        hashMap2.put("opvideo_type", String.valueOf(lVar.f81184s));
        WSStatisticsReporter.Builder builder = a(testId).addParams(hashMap).addExtParams(hashMap2).addObjectParams("feed_pass_key", lVar.f81183r);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_exposure");
    }

    @JvmStatic
    private static final void h(int eventType, com.tencent.biz.pubaccount.weishi.player.e playerParam, boolean isCompleted, String testId) {
        l lVar = playerParam != null ? playerParam.f81127c : null;
        if (lVar == null || com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.b(PLAYED_VIDEO_SET, eventType, lVar)) {
            return;
        }
        if (eventType == 1) {
            String i3 = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.i(lVar.f81166a);
            Intrinsics.checkNotNullExpressionValue(i3, "getPlayId(videoInfo.id)");
            sPlayId = i3;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CGNonAgeReport.EVENT_TYPE, String.valueOf(eventType));
        hashMap.put("feed_id", lVar.f81166a);
        hashMap.put("owner_id", lVar.f81181p);
        hashMap.put("video_length", String.valueOf(lVar.f81169d));
        hashMap.put("recommend_id", "");
        hashMap.put("poolType", String.valueOf(lVar.f81176k));
        hashMap.put("global_key", com.tencent.biz.pubaccount.weishi.report.c.b().c(lVar.f81182q));
        hashMap.put(QCircleLpReportDc05507.KEY_PLAY_ID, sPlayId);
        if (eventType == 2) {
            WSPlayerWrapper wSPlayerWrapper = playerParam.f81129e;
            hashMap.put("duration", String.valueOf(wSPlayerWrapper != null ? wSPlayerWrapper.Q(isCompleted) : 0L));
            WSPlayerWrapper wSPlayerWrapper2 = playerParam.f81129e;
            hashMap.put("last_location", String.valueOf(wSPlayerWrapper2 != null ? wSPlayerWrapper2.A(isCompleted) : 0L));
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", String.valueOf(lVar.f81177l));
        hashMap2.put("opvideo_type", String.valueOf(lVar.f81184s));
        WSStatisticsReporter.Builder builder = a(testId).addParams(hashMap).addExtParams(hashMap2).addObjectParams("feed_pass_key", lVar.f81183r);
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_video_play");
    }

    @JvmStatic
    public static final void i(com.tencent.biz.pubaccount.weishi.player.e playerParam, String testId) {
        h(1, playerParam, false, testId);
    }
}
