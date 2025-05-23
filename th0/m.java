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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lth0/m;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class m implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        JSONArray jSONArray;
        List<ECBasePtsViewData> listOf;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        String str = parserParams.pageName;
        String optString = (data == null || (optJSONObject2 = data.optJSONObject("product")) == null) ? null : optJSONObject2.optString("title", "");
        String optString2 = (data == null || (optJSONObject = data.optJSONObject("product")) == null) ? null : optJSONObject.optString("source", "");
        if (data == null || (jSONArray = data.optJSONArray("labels")) == null) {
            jSONArray = new JSONArray();
        }
        com.tencent.ecommerce.biz.util.l h16 = new com.tencent.ecommerce.biz.util.k(null, 1, null).h(jSONArray);
        if (optString != null) {
            h16.e(optString, 15, "qecommerce_skin_color_text_primary", 2);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ec_ProductInfo_BasicInfo_source", optString2);
        jSONObject.put("nodes", h16.g());
        String jSONObject2 = jSONObject.toString();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject2, gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject2, null), 1, null));
        return listOf;
    }
}
