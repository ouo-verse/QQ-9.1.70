package zd3;

import android.view.View;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTPublicParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import qu4.p;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\bC\u0010DJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\tJ&\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002J\u001e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006J\u001e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0002J&\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0002J\u0010\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\"\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J$\u0010)\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'J\u000e\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0006J\u0016\u0010.\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0002J:\u00101\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00022\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002J.\u00102\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00022\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ.\u00103\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00022\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ:\u00104\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00022\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002J\u0016\u00108\u001a\u00020\t2\u0006\u00105\u001a\u00020\u00012\u0006\u00107\u001a\u000206J4\u0010;\u001a\u00020\t2\u0006\u00105\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00022\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ6\u0010<\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ\u000e\u0010=\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010B\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b8\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lzd3/a;", "", "", "eventId", "Landroid/view/View;", "view", "", "backPosition", IECDtReport.ACTION_IDENTIFIER, "", "r", "", "d", "w", "abnormalType", "e", "f", "entranceSource", "gender", "exceptionType", "traceId", h.F, "reCreateType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "value", "g", Element.ELEMENT_NAME_TIMES, "i", "uin", "p", "feedId", "j", "", "isLike", "o", "", "Lqu4/p;", "customColors", "itemId", "", "ugcId", DomainData.DOMAIN_NAME, "from", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "clkType", "k", "elementID", "businessParams", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", "u", "target", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "params", "a", "pageId", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "c", "b", "B", "Lid3/d;", "Lid3/d;", "getReportHelper", "()Lid3/d;", "reportHelper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    private static final List<Integer> f452366c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final id3.d reportHelper = new id3.d(null, 1, null);

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{0, 4});
        f452366c = listOf;
    }

    public final void B(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.traversePage(view);
    }

    public final synchronized void a(Object target, IDynamicParams params) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.setEventDynamicParams(target, params);
    }

    public final void b(Object view, String elementID, String identifier, Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        VideoReport.setElementId(view, elementID);
        VideoReport.setElementReuseIdentifier(view, identifier);
        VideoReport.setElementParams(view, params);
    }

    public final void c(Object target, Object view, String pageId, Map<String, Object> pageParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.reportHelper.j(target, view, pageId, pageParams);
    }

    public final void e(int abnormalType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_load_abnormal_type", Integer.valueOf(abnormalType));
        linkedHashMap.put("dt_pgid", "pg_zplan_preview_new");
        this.reportHelper.d("ev_zplan_load_abnormal", linkedHashMap);
    }

    public final void f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_zplan_preview_new");
        this.reportHelper.d("ev_zplan_long_press_copy", linkedHashMap);
    }

    public final void g(String entranceSource, int gender, String value) {
        Intrinsics.checkNotNullParameter(entranceSource, "entranceSource");
        Intrinsics.checkNotNullParameter(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, entranceSource);
        linkedHashMap.put("zplan_gender", Integer.valueOf(gender));
        linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
        linkedHashMap.put("zplan_eid", value);
        linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_PG_ID, "pg_zplan_create_new");
        this.reportHelper.d("ev_zplan_toast_total", linkedHashMap);
    }

    public final void h(String entranceSource, int gender, int exceptionType, String traceId) {
        Intrinsics.checkNotNullParameter(entranceSource, "entranceSource");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, entranceSource);
        linkedHashMap.put("zplan_gender", Integer.valueOf(gender));
        linkedHashMap.put("zplan_exception_reason", Integer.valueOf(exceptionType));
        linkedHashMap.put("zplan_trace_id", traceId);
        linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
        this.reportHelper.d("ev_zplan_create_exception", linkedHashMap);
    }

    public final void i(String entranceSource, int gender, int times, String traceId) {
        Intrinsics.checkNotNullParameter(entranceSource, "entranceSource");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, entranceSource);
        linkedHashMap.put("zplan_gender", Integer.valueOf(gender));
        linkedHashMap.put("zplan_loading_times", Integer.valueOf(times));
        linkedHashMap.put("zplan_trace_id", traceId);
        linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
        this.reportHelper.d("ev_zplan_create_loading", linkedHashMap);
    }

    public final void j(String feedId) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (feedId != null) {
            linkedHashMap.put("zplan_feed_id", feedId);
        }
        this.reportHelper.d("ev_zplan_del_feed", linkedHashMap);
    }

    public final void k(int from, String clkType) {
        Intrinsics.checkNotNullParameter(clkType, "clkType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_SOURCE, String.valueOf(from));
        linkedHashMap.put("zplan_clck_type", clkType);
        this.reportHelper.d("ev_zplan_colthing_dyeing_remind_pop_clck", linkedHashMap);
    }

    public final void l(int from) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_SOURCE, String.valueOf(from));
        this.reportHelper.d("ev_zplan_colthing_dyeing_remind_pop_imp", linkedHashMap);
    }

    public final void m(int from) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_SOURCE, String.valueOf(from));
        this.reportHelper.d("ev_zplan_gold_insufficient_reminder_pop_imp", linkedHashMap);
    }

    public final void n(List<p> customColors, int itemId, long ugcId) {
        Intrinsics.checkNotNullParameter(customColors, "customColors");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<p> it = customColors.iterator();
        String str = "";
        while (it.hasNext()) {
            str = (str + it.next().f429637b) + ",";
        }
        linkedHashMap.put("zplan_color_code", str);
        linkedHashMap.put("zplan_item_id", itemId + "," + ugcId);
        this.reportHelper.d("ev_zplan_dyeing_success", linkedHashMap);
    }

    public final void o(String uin, boolean isLike) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_CUSTOMER_LIKE_TYPE, Integer.valueOf(isLike ? 1 : 2));
        linkedHashMap.put(DTPublicParamKey.DT_QQ, uin);
        linkedHashMap.put("dt_pgid", "pg_zplan_feed_detail");
        this.reportHelper.d("ev_zplan_like_feeds", linkedHashMap);
    }

    public final void p(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(DTPublicParamKey.DT_QQ, uin);
        linkedHashMap.put("dt_pgid", "pg_zplan_contribute");
        this.reportHelper.d("ev_zplan_contribute", linkedHashMap);
    }

    public final void q(String entranceSource, int gender, int reCreateType) {
        Intrinsics.checkNotNullParameter(entranceSource, "entranceSource");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, entranceSource);
        linkedHashMap.put("zplan_gender", Integer.valueOf(gender));
        linkedHashMap.put("zplan_click_type", Integer.valueOf(reCreateType));
        linkedHashMap.put("dt_pgid", "pg_zplan_create_new");
        this.reportHelper.d("ev_zplan_again_create_pop", linkedHashMap);
    }

    public final void r(String eventId, View view, int backPosition, String identifier) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(view, "view");
        if (backPosition >= 0) {
            Map<String, Object> d16 = d(backPosition);
            int hashCode = eventId.hashCode();
            if (hashCode == -1693995719) {
                if (eventId.equals("dt_imp_end")) {
                    z(view, "em_zplan_back_btn", d16);
                }
            } else {
                if (hashCode != -1321989219) {
                    if (hashCode == 1967827168 && eventId.equals("dt_clck")) {
                        t(view, "em_zplan_back_btn", d16);
                        return;
                    }
                    return;
                }
                if (eventId.equals("dt_imp")) {
                    x(view, "em_zplan_back_btn", d16, identifier);
                }
            }
        }
    }

    public final void t(View view, String elementID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        id3.d.i(this.reportHelper, view, elementID, businessParams == null ? new LinkedHashMap() : businessParams, false, false, null, false, false, 224, null);
        id3.d dVar = this.reportHelper;
        if (businessParams == null) {
            businessParams = new LinkedHashMap<>();
        }
        dVar.c("dt_clck", view, businessParams);
    }

    public final void w(String eventId, View view) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual(eventId, "dt_imp")) {
            y(this, view, "em_zplan_home_btn", null, null, 8, null);
        } else if (Intrinsics.areEqual(eventId, "dt_clck")) {
            t(view, "em_zplan_home_btn", null);
        }
    }

    public final void z(View view, String elementID, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        if (businessParams == null) {
            businessParams = new LinkedHashMap<>();
        }
        if (!businessParams.isEmpty()) {
            id3.d.i(this.reportHelper, view, elementID, businessParams, false, false, null, false, false, 224, null);
        }
        this.reportHelper.c("dt_imp_end", view, businessParams);
    }

    public final Map<String, Object> d(int backPosition) {
        String str;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("zplan_back_pos", Integer.valueOf(backPosition));
        if (f452366c.contains(Integer.valueOf(backPosition))) {
            str = "close";
        } else {
            str = "back";
        }
        pairArr[1] = TuplesKt.to("zplan_back_btn_type", str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    public final void u(View view, String elementID, Map<String, Object> businessParams, String identifier) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        id3.d.i(this.reportHelper, view, elementID, businessParams == null ? new LinkedHashMap() : businessParams, false, false, identifier, false, false, 192, null);
        this.reportHelper.c("dt_clck", view, businessParams == null ? new LinkedHashMap<>() : businessParams);
    }

    public final void x(View view, String elementID, Map<String, Object> businessParams, String identifier) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        id3.d.i(this.reportHelper, view, elementID, businessParams == null ? new LinkedHashMap() : businessParams, false, false, identifier, false, false, 192, null);
        this.reportHelper.c("dt_imp", view, businessParams == null ? new LinkedHashMap<>() : businessParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void A(a aVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.z(view, str, map);
    }

    public static /* synthetic */ void s(a aVar, String str, View view, int i3, String str2, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            str2 = null;
        }
        aVar.r(str, view, i3, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v(a aVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        aVar.t(view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void y(a aVar, View view, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        aVar.x(view, str, map, str2);
    }
}
