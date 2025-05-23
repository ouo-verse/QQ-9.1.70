package zh0;

import android.net.Uri;
import ck0.Category;
import ck0.Product;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.g;
import com.tencent.ecommerce.biz.common.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0082\u0001\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019\u00a8\u0006\u001e"}, d2 = {"Lzh0/a;", "", "", "", "userData", "", "c", "busId", "", "uin", "sellerId", "buyerId", "goodsType", "sassId", "productId", "productName", "priSortId", GetAdInfoRequest.SOURCE_FROM, "contendId", "roomId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "sealTransfer", "a", "url", "mediaId", "Lck0/c;", "product", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f452541a = new a();

    a() {
    }

    public final Map<Object, Object> a(String busId, long uin, String sellerId, String buyerId, String goodsType, String sassId, String productId, String productName, String priSortId, String sourceFrom, String contendId, String roomId, String requestId, String sealTransfer) {
        Map<Object, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bus_id", busId), TuplesKt.to("uin", String.valueOf(uin)), TuplesKt.to("seller_id", sellerId), TuplesKt.to("buyer_id", buyerId), TuplesKt.to("goods_type", goodsType), TuplesKt.to("saas_id", sassId), TuplesKt.to(ReportDataBuilder.KEY_PRODUCT_ID, productId), TuplesKt.to("product_name", productName), TuplesKt.to("pri_sort_id", priSortId), TuplesKt.to("source_from", sourceFrom), TuplesKt.to("content_id", contendId), TuplesKt.to(AudienceReportConst.ROOM_ID, roomId), TuplesKt.to("request_id", requestId), TuplesKt.to(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, sealTransfer));
        return mapOf;
    }

    public final Map<Object, Object> b(String url, String mediaId, Product product) {
        String valueOf;
        Map<String, String> l3 = yi0.a.f450402c.l(Uri.parse(url));
        String str = l3.get("ext");
        ug0.b bVar = ug0.b.f438933d;
        String valueOf2 = String.valueOf(bVar.e());
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        long currentAccount = qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount();
        String valueOf3 = String.valueOf(qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
        String valueOf4 = String.valueOf(product.getGoodsType());
        String saasTypeStr = product.getSaasTypeStr();
        String saasProductId = product.getSaasProductId();
        String title = product.getTitle();
        Category category = product.getCategory();
        String str2 = (category == null || (valueOf = String.valueOf(category.id)) == null) ? "" : valueOf;
        String str3 = l3.get("source_from");
        String str4 = str3 != null ? str3 : "";
        String optString = bVar.c(str).optString("content_id", "");
        String optString2 = bVar.c(str).optString("qqlive_room_id", "");
        String str5 = l3.get("request_id");
        String str6 = str5 != null ? str5 : "";
        String str7 = l3.get(QCircleLpReportDc05507.KEY_SEAL_TRANSFER);
        return a(valueOf2, currentAccount, mediaId, valueOf3, valueOf4, saasTypeStr, saasProductId, title, str2, str4, optString, optString2, str6, str7 != null ? str7 : "");
    }

    public final void c(Map<String, String> userData) {
        e eVar = new e();
        String str = userData.get("bus_id");
        if (str == null) {
            str = "";
        }
        eVar.a(str);
        String str2 = userData.get("uin");
        if (str2 == null) {
            str2 = "";
        }
        eVar.b("uin", str2);
        String str3 = userData.get("seller_id");
        if (str3 == null) {
            str3 = "";
        }
        eVar.d(str3);
        String str4 = userData.get("buyer_id");
        if (str4 == null) {
            str4 = "";
        }
        eVar.b("buyer_id", str4);
        String str5 = userData.get("goods_type");
        if (str5 == null) {
            str5 = "";
        }
        eVar.b("goods_type", str5);
        String str6 = userData.get("saas_id");
        if (str6 == null) {
            str6 = "";
        }
        eVar.b("saas_id", str6);
        String str7 = userData.get(ReportDataBuilder.KEY_PRODUCT_ID);
        if (str7 == null) {
            str7 = "";
        }
        eVar.b(ReportDataBuilder.KEY_PRODUCT_ID, str7);
        String str8 = userData.get("product_name");
        if (str8 == null) {
            str8 = "";
        }
        eVar.b("product_name", str8);
        String str9 = userData.get("pri_sort_id");
        if (str9 == null) {
            str9 = "";
        }
        eVar.b("pri_sort_id", str9);
        String str10 = userData.get("duration");
        if (str10 == null) {
            str10 = "";
        }
        eVar.b("duration", str10);
        String str11 = userData.get("source_from");
        if (str11 == null) {
            str11 = "";
        }
        eVar.b("source_from", str11);
        String str12 = userData.get("content_id");
        if (str12 == null) {
            str12 = "";
        }
        eVar.b("feed_id", str12);
        String str13 = userData.get(AudienceReportConst.ROOM_ID);
        if (str13 == null) {
            str13 = "";
        }
        eVar.b(AudienceReportConst.ROOM_ID, str13);
        String str14 = userData.get("request_id");
        if (str14 == null) {
            str14 = "";
        }
        eVar.b("request_id", str14);
        String str15 = userData.get(QCircleLpReportDc05507.KEY_SEAL_TRANSFER);
        eVar.b(QCircleLpReportDc05507.KEY_SEAL_TRANSFER, str15 != null ? str15 : "");
        Map<Object, Object> f16 = eVar.f();
        cg0.a.b("ECSaasProductH5PageReport", "[reportSaasProductPageDuration] " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_saas_duration", f16, false, 4, null);
        g.d("product_saas_page_duration", f16);
    }
}
