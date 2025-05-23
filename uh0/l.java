package uh0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Luh0/l;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class l implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        JSONObject jSONObject;
        List<ECBasePtsViewData> listOf;
        if (data == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = new JSONObject(data.toString());
        }
        String str = parserParams.pageName;
        JSONObject optJSONObject = jSONObject.optJSONObject("delivery_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        boolean optBoolean = optJSONObject.optBoolean("has_end_time", false);
        long optLong = optJSONObject.optLong("presale_end_time");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("product");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("price");
        if (optJSONObject3 == null) {
            optJSONObject3 = new JSONObject();
        }
        String optString = optJSONObject3.optString("price_txt", "");
        JSONObject optJSONObject4 = optJSONObject2.optJSONObject(TabPreloadItem.TAB_NAME_DYNAMIC);
        if (optJSONObject4 == null) {
            optJSONObject4 = new JSONObject();
        }
        String optString2 = optJSONObject4.optString("sales", "");
        jSONObject.put("price_txt", optString);
        jSONObject.put("sale_txt", optString2);
        jSONObject.put("has_end_time", optBoolean);
        jSONObject.put("end_time", optLong);
        String jSONObject2 = jSONObject.toString();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject2, gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject2, null), 1, null));
        return listOf;
    }
}
