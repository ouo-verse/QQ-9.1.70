package rj3;

import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.zplan.utils.v;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J(\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lrj3/b;", "", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "redDotAppInfo", "", "hasRedDot", "hasRedNum", "hasBubbleAd", "", "b", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f431586a = new b();

    b() {
    }

    public final void a(BusinessInfoCheckUpdate.AppInfo redDotAppInfo, boolean hasRedDot, boolean hasRedNum, boolean hasBubbleAd) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_main");
        hashMap.put("zplan_action_type", "click");
        hashMap.put(EmotionReportDtImpl.IS_RED_TIPS_BEFORE, Integer.valueOf(hasRedDot ? 1 : 0));
        hashMap.put("reddot_num", Integer.valueOf(hasRedNum ? 1 : 0));
        hashMap.put(SquareReportConst.Key.KEY_MSG_BOX_HAS_BUBBLE, Integer.valueOf(hasBubbleAd ? 1 : 0));
        v vVar = v.f335848a;
        hashMap.put("zplan_tianshu_ad_id", vVar.e(redDotAppInfo));
        hashMap.put("zplan_tianshu_ad_type", Integer.valueOf(vVar.f(redDotAppInfo)));
        hashMap.put("zplan_tianshu_reddot_with_tips", Integer.valueOf(vVar.n(redDotAppInfo) ? 1 : 0));
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    public final void b(BusinessInfoCheckUpdate.AppInfo redDotAppInfo, boolean hasRedDot, boolean hasRedNum, boolean hasBubbleAd) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "em_zplan_entrance_qq_main");
        hashMap.put("zplan_action_type", "imp");
        hashMap.put(EmotionReportDtImpl.IS_RED_TIPS_BEFORE, Integer.valueOf(hasRedDot ? 1 : 0));
        hashMap.put("reddot_num", Integer.valueOf(hasRedNum ? 1 : 0));
        hashMap.put(SquareReportConst.Key.KEY_MSG_BOX_HAS_BUBBLE, Integer.valueOf(hasBubbleAd ? 1 : 0));
        v vVar = v.f335848a;
        hashMap.put("zplan_tianshu_ad_id", vVar.e(redDotAppInfo));
        hashMap.put("zplan_tianshu_ad_type", Integer.valueOf(vVar.f(redDotAppInfo)));
        hashMap.put("zplan_tianshu_reddot_with_tips", Integer.valueOf(vVar.n(redDotAppInfo) ? 1 : 0));
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }
}
