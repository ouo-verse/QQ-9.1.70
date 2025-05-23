package uh0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.pts.core.PTSComposer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Luh0/n;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class n implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        JSONObject jSONObject;
        List<ECBasePtsViewData> listOf;
        String str = parserParams.pageName;
        if (data == null || (jSONObject = data.optJSONObject("shop_service")) == null) {
            jSONObject = new JSONObject();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("services");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        int length = optJSONArray.length();
        String str2 = "";
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                str2 = str2 + " \u00b7 ";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            String optString = optJSONArray.optJSONObject(i3).optString("title");
            if (optString == null) {
                optString = "";
            }
            sb5.append(optString);
            str2 = sb5.toString();
        }
        if (data != null) {
            data.put("shop_service_tips", str2);
        }
        String jSONObject2 = data != null ? data.toString() : null;
        PTSComposer b16 = gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject2, null);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("product active info:");
        sb6.append(data != null ? com.tencent.ecommerce.biz.detail.utils.f.h(data) : null);
        cg0.a.b("ECProductDetailPtsShopService", sb6.toString());
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject2, b16, 1, null));
        return listOf;
    }
}
