package uh0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.pts.core.PTSComposer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Luh0/k;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class k implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        String jSONObject;
        List<ECBasePtsViewData> listOf;
        String str = parserParams.pageName;
        if (data == null || (jSONObject = data.toString()) == null) {
            jSONObject = new JSONObject().toString();
        }
        JSONObject jSONObject2 = new JSONObject(jSONObject);
        JSONObject jSONObject3 = parserParams.ext;
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        if (Intrinsics.areEqual(jSONObject3.optString("is_from_window", "0"), "1")) {
            jSONObject2.put("title_txt", "\u901b\u901b\u8fbe\u4eba\u6a71\u7a97");
        } else {
            jSONObject2.put("title_txt", "\u770b\u770b\u5176\u4ed6\u5546\u54c1");
        }
        PTSComposer b16 = gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject2.toString(), null);
        cg0.a.b("ECProductDetailPtsShopOffSaleTitleParser", "pageName = " + str + ", proteusData = " + jSONObject2);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str, jSONObject2.toString(), b16, 1, null));
        return listOf;
    }
}
