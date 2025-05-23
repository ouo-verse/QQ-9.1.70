package th0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.pts.core.PTSComposer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lth0/j;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class j implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        List<ECBasePtsViewData> listOf;
        JSONArray jSONArray;
        String str = parserParams.pageName;
        JSONObject jSONObject = new JSONObject();
        if (data != null) {
            jSONObject = new JSONObject(data.toString());
            JSONObject optJSONObject = jSONObject.optJSONObject("commission_detail");
            JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("commission_details") : null;
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                    JSONObject optJSONObject3 = optJSONObject2 != null ? optJSONObject2.optJSONObject("price") : null;
                    if (optJSONObject3 != null) {
                        long optLong = optJSONObject3.optLong("price");
                        com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
                        String b16 = iVar.b(optLong);
                        long optLong2 = optJSONObject3.optLong("origin_price");
                        String b17 = iVar.b(optLong2);
                        jSONArray = optJSONArray;
                        optJSONObject3.put("price_display", b16);
                        if (optLong != optLong2) {
                            optJSONObject3.put("origin_price_display", b17);
                        }
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("commission");
                        if (optJSONObject4 == null) {
                            optJSONObject4 = new JSONObject();
                        }
                        optJSONObject4.put("commission_display", iVar.b(optJSONObject4.optLong("commission")));
                    } else {
                        jSONArray = optJSONArray;
                    }
                    i3++;
                    optJSONArray = jSONArray;
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("commission_detail");
                JSONObject optJSONObject6 = optJSONObject5 != null ? optJSONObject5.optJSONObject("commission_range") : null;
                cg0.a.b("ECProductDetailPtsParserPreSalePrice", "commissionDetailJson = " + optJSONObject5 + ", commissionRangJson = " + optJSONObject6);
                if (optJSONObject6 != null) {
                    long optLong3 = optJSONObject6.optLong("min_commission");
                    com.tencent.ecommerce.biz.util.i iVar2 = com.tencent.ecommerce.biz.util.i.f104869a;
                    String b18 = iVar2.b(optLong3);
                    String b19 = iVar2.b(optJSONObject6.optLong("max_commission"));
                    optJSONObject6.put("min_commission_display", b18);
                    optJSONObject6.put("max_commission_display", b19);
                }
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (optJSONObject7 != null) {
                long j3 = 1000;
                long optLong4 = optJSONObject7.optLong("activity_start_time") * j3;
                long optLong5 = optJSONObject7.optLong("activity_end_time") * j3;
                String optString = optJSONObject7.optString("activity_text_before");
                String optString2 = optJSONObject7.optString("activity_text_ing");
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis >= optLong4 && currentTimeMillis <= optLong5) {
                    optString = optString2;
                }
                optJSONObject7.put("activity_text_showing", optString);
            }
        }
        String jSONObject2 = jSONObject.toString();
        PTSComposer b26 = gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject2, null);
        cg0.a.b("ECProductDetailPtsParserPreSalePrice", "[parse] proteusData = " + jSONObject2);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject2, b26, 1, null));
        return listOf;
    }
}
