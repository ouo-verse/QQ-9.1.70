package th0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lth0/i;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lorg/json/JSONObject;", "data", "", "b", "Lorg/json/JSONArray;", "commissionDetails", "a", "Lbh0/e;", "parserParams", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class i implements IECPTSComposerParser {
    private final void a(JSONObject data, JSONArray commissionDetails) {
        JSONObject optJSONObject;
        int length = commissionDetails.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            JSONObject optJSONObject2 = commissionDetails.optJSONObject(i3);
            optJSONObject = optJSONObject2 != null ? optJSONObject2.optJSONObject("price") : null;
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong("price");
                com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
                String b16 = iVar.b(optLong);
                long optLong2 = optJSONObject.optLong("origin_price");
                String b17 = iVar.b(optLong2);
                optJSONObject.put("price_display", b16);
                if (optLong != optLong2) {
                    optJSONObject.put("origin_price_display", b17);
                }
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("commission");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                }
                optJSONObject3.put("commission_display", iVar.b(optJSONObject3.optLong("commission")));
            }
            i3++;
        }
        JSONObject optJSONObject4 = data.optJSONObject("commission_detail");
        optJSONObject = optJSONObject4 != null ? optJSONObject4.optJSONObject("commission_range") : null;
        cg0.a.b("ECProductDetailPtsMultiCommissionAndPriceParser", "commissionDetailJson = " + optJSONObject4 + ", commissionRangJson = " + optJSONObject);
        if (optJSONObject != null) {
            long optLong3 = optJSONObject.optLong("min_commission");
            com.tencent.ecommerce.biz.util.i iVar2 = com.tencent.ecommerce.biz.util.i.f104869a;
            String b18 = iVar2.b(optLong3);
            String b19 = iVar2.b(optJSONObject.optLong("max_commission"));
            optJSONObject.put("min_commission_display", b18);
            optJSONObject.put("max_commission_display", b19);
        }
    }

    private final void b(JSONObject data) {
        long optLong = data.optLong("price");
        long optLong2 = data.optLong("origin_price");
        long optLong3 = data.optLong("commission");
        String optString = data.optString("commission_rate");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("price", optLong);
        jSONObject.put("origin_price", optLong2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("commission", optLong3);
        jSONObject2.put("commission_rate", optString);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("price", jSONObject);
        jSONObject3.put("commission", jSONObject2);
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("commission_details", jSONArray);
        a(data, jSONArray);
        data.put("commission_detail", jSONObject4);
    }

    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        List<ECBasePtsViewData> listOf;
        if (data != null) {
            JSONObject optJSONObject = data.optJSONObject("commission_detail");
            JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("commission_details") : null;
            if (optJSONObject == null) {
                b(data);
            } else if (optJSONArray != null) {
                a(data, optJSONArray);
            }
        }
        String str = parserParams.pageName;
        String valueOf = String.valueOf(data);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, valueOf, gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), valueOf, null), 1, null));
        return listOf;
    }
}
