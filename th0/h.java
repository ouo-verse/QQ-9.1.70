package th0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lth0/h;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class h implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        List<ECBasePtsViewData> listOf;
        boolean isBlank;
        JSONObject optJSONObject;
        String str = parserParams.pageName;
        JSONArray jSONArray = new JSONArray();
        JSONArray optJSONArray = (data == null || (optJSONObject = data.optJSONObject("product")) == null) ? null : optJSONObject.optJSONArray("main_pics");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String obj = optJSONArray.get(i3).toString();
                isBlank = StringsKt__StringsJVMKt.isBlank(obj);
                if (!isBlank) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("mainPics", obj);
                    Unit unit = Unit.INSTANCE;
                    jSONArray.mo162put(jSONObject);
                }
            }
        }
        String jSONObject2 = new JSONObject().put("swiperData", jSONArray).toString();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject2, gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject2, null), 1, null));
        return listOf;
    }
}
