package th0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.pts.core.PTSComposer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lth0/k;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class k implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        String str;
        String str2;
        List<ECBasePtsViewData> listOf;
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        String str3 = parserParams.pageName;
        long optLong = data != null ? data.optLong("price") : 0L;
        long optLong2 = data != null ? data.optLong("coupon_price") : 0L;
        if (optLong2 != 0) {
            optLong = optLong2;
        }
        long optLong3 = data != null ? data.optLong("origin_price") : 0L;
        long optLong4 = data != null ? data.optLong("commission") : 0L;
        String str4 = "";
        if (data == null || (str = data.optString("commission_rate")) == null) {
            str = "";
        }
        if (data == null || (optJSONObject2 = data.optJSONObject("product")) == null || (str2 = optJSONObject2.optString("title")) == null) {
            str2 = "";
        }
        if (data != null && (optJSONObject = data.optJSONObject("product")) != null && (optString = optJSONObject.optString("source")) != null) {
            str4 = optString;
        }
        if (data != null) {
            com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
            data.put("ec_ProductInfo_BasicInfo_price", iVar.b(optLong));
            if (optLong3 > optLong) {
                data.put("ec_ProductInfo_BasicInfo_origin_price", iVar.b(optLong3));
            }
            data.put("ec_ProductInfo_BasicInfo_source", str4);
            data.put("ec_ProductInfo_BasicInfo_title", str2);
            data.put("ec_ProductInfo_SellerProductRsp_commission", iVar.b(optLong4));
            data.put("ec_ProductInfo_SellerProductRsp_commission_rate", str);
        } else {
            data = null;
        }
        String valueOf = String.valueOf(data);
        PTSComposer b16 = gh0.d.f402041a.b(str3, ECPTSStyleManager.e(str3, wg0.a.a()), valueOf, null);
        cg0.a.b("ECProductDetailPtsParserPrice", "[parse] proteusData = " + valueOf);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str3, valueOf, b16, 1, null));
        return listOf;
    }
}
