package uh0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.pts.core.PTSComposer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Luh0/b;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class b implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        String str = parserParams.pageName;
        if (data == null) {
            cg0.a.a("ECProductDetailPtsShopChooseBuyCountParser", "parse", "data is invalid");
            return new ArrayList();
        }
        JSONObject optJSONObject = data.optJSONObject("sku_pts_data");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("sku_buy_count_info") : null;
        ArrayList arrayList = new ArrayList();
        if (optJSONObject2 != null) {
            String jSONObject = optJSONObject2.toString();
            PTSComposer b16 = gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject, null);
            cg0.a.b("ECProductDetailPtsShopChooseBuyCountParser", "[parse] proteusData = " + jSONObject);
            arrayList.add(new ECBasePtsViewData(null, str, jSONObject, b16, 1, null));
        }
        return arrayList;
    }
}
