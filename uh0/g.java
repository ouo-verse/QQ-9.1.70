package uh0;

import bh0.ECPageParserParams;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.pts.core.PTSComposer;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Luh0/g;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class g implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        JSONObject jSONObject;
        List<ECBasePtsViewData> listOf;
        String str = parserParams.pageName;
        if (data == null || (jSONObject = data.optJSONObject("shop")) == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("button");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(TabPreloadItem.TAB_NAME_DYNAMIC);
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject(String.valueOf(data));
        jSONObject2.put("shop_id", jSONObject.optString("id", ""));
        jSONObject2.put("shop_pic", jSONObject.optString("icon", ""));
        jSONObject2.put("shop_name", jSONObject.optString("name", ""));
        jSONObject2.put("sales_txt", optJSONObject2.optString("sales", ""));
        jSONObject2.put(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, optJSONObject.optString(FileReaderHelper.TXT_EXT, ""));
        jSONObject2.put("button_jump_url", optJSONObject.optString("jump_url", ""));
        jSONObject2.put("show_button", true);
        String jSONObject3 = jSONObject2.toString();
        PTSComposer b16 = gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject3, null);
        cg0.a.b("ECProductDetailPtsShopHeadParser", "[parse] proteusData = " + jSONObject3);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject3, b16, 1, null));
        return listOf;
    }
}
