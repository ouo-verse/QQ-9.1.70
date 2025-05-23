package uh0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Luh0/i;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class i implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        JSONObject jSONObject;
        List<ECBasePtsViewData> listOf;
        String str = parserParams.pageName;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONObject a16 = data != null ? com.tencent.ecommerce.base.ktx.e.a(data, parserParams.dataParams) : null;
        if (a16 == null || (jSONObject = a16.optJSONObject("product")) == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(IndividuationUrlHelper.UrlId.PENDANT_HOME);
        JSONArray optJSONArray = jSONObject.optJSONArray("carousel_pictures");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    String optString = optJSONObject2.optString("thumbnail_url", "");
                    if (optString.length() == 0) {
                        optString = optJSONObject2.optString("url");
                    }
                    jSONObject2.put("mainPics", optString);
                    Unit unit = Unit.INSTANCE;
                    jSONArray.mo162put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("mainPics", optJSONObject2.optString("url"));
                    jSONArray2.mo162put(jSONObject3);
                }
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("swiperData", jSONArray);
        jSONObject4.put("originalPics", jSONArray2);
        jSONObject4.put(IndividuationUrlHelper.UrlId.PENDANT_HOME, optJSONObject);
        String jSONObject5 = jSONObject4.toString();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject5, gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject5, null), 1, null));
        return listOf;
    }
}
