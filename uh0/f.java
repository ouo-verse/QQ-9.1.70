package uh0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.pts.core.PTSComposer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J,\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Luh0/f;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "a", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class f implements IECPTSComposerParser {
    private final String a(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        String str;
        String str2;
        String str3;
        String str4;
        String optString;
        String str5 = "";
        if (reqParam == null || (str = reqParam.optString(WadlProxyConsts.CHANNEL, "")) == null) {
            str = "";
        }
        if (reqParam == null || (str2 = reqParam.optString("shop_id", "")) == null) {
            str2 = "";
        }
        if (reqParam == null || (str3 = reqParam.optString("spu_id", "")) == null) {
            str3 = "";
        }
        JSONObject optJSONObject = data != null ? data.optJSONObject("product") : null;
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("price") : null;
        if (optJSONObject2 == null || (str4 = optJSONObject2.optString("discount_price_txt")) == null) {
            str4 = "";
        }
        if ((str4.length() == 0) && (optJSONObject2 == null || (str4 = optJSONObject2.optString("price_txt", "")) == null)) {
            str4 = "";
        }
        JSONObject jSONObject = parserParams.ext;
        if (jSONObject != null && (optString = jSONObject.optString("seller_media_id", "")) != null) {
            str5 = optString;
        }
        String str6 = "mqqapi://ecommerce/open?target=52&channel=" + str + "&page_name=obtain_coupon_page&from=1&shop_id=" + str2 + "&spu_id=" + str3 + "&minimum_price=" + str4 + "&modal_mode=1&media_id=" + str5;
        cg0.a.b("ECProductDetailPtsShopCouponParser", "[createCouponSchema] jumpSchema = " + str6);
        return str6;
    }

    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        List<ECBasePtsViewData> listOf;
        JSONArray jSONArray;
        String str = parserParams.pageName;
        JSONObject jSONObject = new JSONObject();
        if (data != null) {
            JSONObject optJSONObject = data.optJSONObject("product");
            if (optJSONObject == null || (jSONArray = optJSONObject.optJSONArray("prod_tags")) == null) {
                jSONArray = new JSONArray();
            }
            jSONObject.put("prod_tags", jSONArray);
            jSONObject.put("has_coupon_button", jSONArray.length() > 0);
            jSONObject.put("coupon_btn_text", "\u9886\u5238");
            jSONObject.put("coupon_btn_url", a(parserParams, data, reqParam));
        }
        PTSComposer b16 = gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject.toString(), null);
        cg0.a.b("ECProductDetailPtsShopCouponParser", "[parse] pagename = " + str + " proteusData = " + jSONObject);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject.toString(), b16, 1, null));
        return listOf;
    }
}
