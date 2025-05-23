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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lth0/e;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class e implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        JSONArray jSONArray;
        String str;
        List<ECBasePtsViewData> listOf;
        JSONObject optJSONObject;
        String optString;
        String str2 = parserParams.pageName;
        if (data == null || (jSONArray = data.optJSONArray("labels")) == null) {
            jSONArray = new JSONArray();
        }
        com.tencent.ecommerce.biz.util.l lVar = new com.tencent.ecommerce.biz.util.l(null, 1, null);
        int length = jSONArray.length();
        int i3 = 0;
        while (true) {
            str = "";
            if (i3 >= length) {
                break;
            }
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i3);
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            String f16 = oi0.a.f(optJSONObject2);
            int g16 = oi0.a.g(optJSONObject2);
            int b16 = oi0.a.b(optJSONObject2);
            if (f16.length() > 0) {
                lVar.b(f16, g16, b16);
            } else {
                lVar.c(optJSONObject2.optString("background_color", ""), optJSONObject2.optString("text_color", ""), optJSONObject2.optString("text", ""));
            }
            i3++;
        }
        if (data != null && (optJSONObject = data.optJSONObject("product")) != null && (optString = optJSONObject.optString("title")) != null) {
            str = optString;
        }
        lVar.e(str, 15, "qecommerce_skin_color_text_primary", 2);
        String f17 = lVar.f();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str2, f17, gh0.d.f402041a.b(str2, ECPTSStyleManager.e(str2, wg0.a.a()), f17, null), 1, null));
        return listOf;
    }
}
