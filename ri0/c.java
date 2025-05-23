package ri0;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\bR$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0016j\b\u0012\u0004\u0012\u00020\n`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0018R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0016j\b\u0012\u0004\u0012\u00020\n`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lri0/c;", "", "Lcom/tencent/ecommerce/biz/common/e;", "paramsBuilder", "Lorg/json/JSONObject;", "goodsInfoJSON", "Lcom/tencent/ecommerce/biz/productcenter/repo/ECSalesRankRepo$SalesRankType;", "rankType", "", "a", "", "goodId", "rankListType", "", "b", "", "busId", "f", "e", "d", "c", "g", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "dailyItemExpReportList", "monthlyItemExpReportList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f431472c = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<Long> dailyItemExpReportList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ArrayList<Long> monthlyItemExpReportList = new ArrayList<>();

    c() {
    }

    private final void a(com.tencent.ecommerce.biz.common.e paramsBuilder, JSONObject goodsInfoJSON, ECSalesRankRepo.SalesRankType rankType) {
        int i3 = b.f431468a[rankType.ordinal()];
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                i16 = 0;
            }
        }
        paramsBuilder.b("saas_id", goodsInfoJSON.optString("saas_type")).b("product_index", goodsInfoJSON.optString("sale_index")).b(ReportDataBuilder.KEY_PRODUCT_ID, goodsInfoJSON.optString("saas_product_id")).b("commission", String.valueOf(goodsInfoJSON.optLong("commission"))).b("product_price", String.valueOf(goodsInfoJSON.optLong("price"))).b("product_sales", String.valueOf(goodsInfoJSON.optLong("sale_index_num"))).b("product_name", goodsInfoJSON.optString("name")).b("rank_type", String.valueOf(i16));
    }

    private final boolean b(long goodId, ECSalesRankRepo.SalesRankType rankListType) {
        int i3 = b.f431469b[rankListType.ordinal()];
        if (i3 == 1) {
            ArrayList<Long> arrayList = dailyItemExpReportList;
            if (arrayList.contains(Long.valueOf(goodId))) {
                return true;
            }
            arrayList.add(Long.valueOf(goodId));
            return false;
        }
        if (i3 != 2) {
            return false;
        }
        if (monthlyItemExpReportList.contains(Long.valueOf(goodId))) {
            return true;
        }
        monthlyItemExpReportList.add(Long.valueOf(goodId));
        return false;
    }

    public final void f(String busId) {
        Map<Object, Object> f16 = new com.tencent.ecommerce.biz.common.e().a(busId).f();
        cg0.a.b("ECSalesRankDataReportUtil", "[reportSearchRankEXP] eventCode = xuanpin_search_rank_exp, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "xuanpin_search_rank_exp", f16, false, 4, null);
    }

    public final void g() {
        dailyItemExpReportList.clear();
        monthlyItemExpReportList.clear();
    }

    public final void c(String busId, JSONObject goodsInfoJSON, ECSalesRankRepo.SalesRankType rankType) {
        if (goodsInfoJSON == null) {
            return;
        }
        com.tencent.ecommerce.biz.common.e a16 = new com.tencent.ecommerce.biz.common.e().a(busId);
        a(a16, goodsInfoJSON, rankType);
        Map<Object, Object> f16 = a16.f();
        cg0.a.b("ECSalesRankDataReportUtil", "[reportRankGoodsCardCLK] eventCode = xuanpin_search_rank_goods_card_add, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "xuanpin_search_rank_goods_card_add", f16, false, 4, null);
    }

    public final void d(String busId, JSONObject goodsInfoJSON, ECSalesRankRepo.SalesRankType rankType) {
        if (goodsInfoJSON == null) {
            return;
        }
        com.tencent.ecommerce.biz.common.e a16 = new com.tencent.ecommerce.biz.common.e().a(busId);
        a(a16, goodsInfoJSON, rankType);
        Map<Object, Object> f16 = a16.f();
        cg0.a.b("ECSalesRankDataReportUtil", "[reportRankGoodsCardCLK] eventCode = xuanpin_search_rank_goods_card_clk, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "xuanpin_search_rank_goods_card_clk", f16, false, 4, null);
    }

    public final void e(String busId, JSONObject goodsInfoJSON, ECSalesRankRepo.SalesRankType rankType) {
        if (goodsInfoJSON == null || b(goodsInfoJSON.optLong("saas_product_id", 0L), rankType)) {
            return;
        }
        com.tencent.ecommerce.biz.common.e a16 = new com.tencent.ecommerce.biz.common.e().a(busId);
        a(a16, goodsInfoJSON, rankType);
        Map<Object, Object> f16 = a16.f();
        cg0.a.b("ECSalesRankDataReportUtil", "[reportSearchRankEXP] eventCode = xuanpin_search_rank_goods_card_exp, params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "xuanpin_search_rank_goods_card_exp", f16, false, 4, null);
    }
}
