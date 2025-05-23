package th0;

import android.text.TextUtils;
import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lth0/d;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lorg/json/JSONObject;", "data", "Lbh0/e;", "parserParams", "Lcom/tencent/ecommerce/base/ui/b;", "a", "", "b", "reqParam", "", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class d implements IECPTSComposerParser {
    private final ECBasePtsViewData a(JSONObject data, ECPageParserParams parserParams) {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = parserParams.ext;
        if (jSONObject2 == null || (str = jSONObject2.optString("EC_OTHER_CATEGORY")) == null) {
            str = "";
        }
        JSONObject jSONObject3 = parserParams.ext;
        boolean optBoolean = jSONObject3 != null ? jSONObject3.optBoolean("EC_IS_CUSTOM") : false;
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("recommen_title", "\u5176\u4ed6" + str + "\u7c7b\u5546\u54c1");
        } else {
            jSONObject.put("recommen_title", "\u5176\u4ed6\u5546\u54c1");
        }
        if (b(data)) {
            jSONObject.put("recommen_title", "\u76f8\u5173\u63a8\u8350");
        }
        JSONObject jSONObject4 = parserParams.ext;
        if (jSONObject4 != null && jSONObject4.optBoolean("EC_IS_CUSTOM")) {
            StringBuilder sb5 = new StringBuilder();
            if (data == null || (str2 = data.optString("title")) == null) {
                str2 = "TA";
            }
            sb5.append(str2);
            sb5.append("\u7684\u5176\u4ed6\u6a71\u7a97\u5546\u54c1");
            jSONObject.put("recommen_title", sb5.toString());
        }
        if (optBoolean) {
            jSONObject.put("is_host", 0);
        } else {
            jSONObject.put("is_host", 1);
        }
        String str3 = parserParams.pageName;
        return new ECBasePtsViewData(null, str3, jSONObject.toString(), gh0.d.f402041a.b(str3, ECPTSStyleManager.e(str3, wg0.a.a()), jSONObject.toString(), null), 1, null);
    }

    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        List<ECBasePtsViewData> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(a(data, parserParams));
        return listOf;
    }

    private final boolean b(JSONObject data) {
        return com.tencent.ecommerce.biz.detail.utils.e.f102467a.e(String.valueOf(data != null ? data.optInt("goods_type", 0) : 0));
    }
}
