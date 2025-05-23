package vh0;

import bh0.ECPageParserParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lvh0/c;", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lorg/json/JSONObject;", "data", "ext", "", "Lbh0/e;", "processRemoteParserParamsArray", "localPageParserParamsArray", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class c extends com.tencent.ecommerce.biz.detail.dataprocessor.processor.a {
    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        String str;
        List<ECPageParserParams> listOf;
        boolean optBoolean = ext != null ? ext.optBoolean("is_in_presale", false) : false;
        ECPageParserParams[] eCPageParserParamsArr = new ECPageParserParams[13];
        eCPageParserParamsArr[0] = new ECPageParserParams(21, "product_detail_mainpic", null, ext, 4, null);
        int i3 = optBoolean ? 39 : 32;
        if (optBoolean) {
            str = "qshop_detail_presale_price";
        } else {
            str = "qshop_detail_price";
        }
        eCPageParserParamsArr[1] = new ECPageParserParams(i3, str, null, ext, 4, null);
        eCPageParserParamsArr[2] = new ECPageParserParams(35, "qshop_detail_labels", null, ext, 4, null);
        eCPageParserParamsArr[3] = new ECPageParserParams(0, "qshop_detail_title", null, ext, 5, null);
        eCPageParserParamsArr[4] = new ECPageParserParams(33, "qshop_detail_services", null, ext, 4, null);
        eCPageParserParamsArr[5] = new ECPageParserParams(0, "qshop_detail_shipping", null, ext, 5, null);
        eCPageParserParamsArr[6] = new ECPageParserParams(0, "qshop_detail_bulletin", null, ext, 5, null);
        eCPageParserParamsArr[7] = new ECPageParserParams(0, "qshop_detail_comment", null, ext, 5, null);
        eCPageParserParamsArr[8] = new ECPageParserParams(23, "qshop_head_card", null, ext, 4, null);
        eCPageParserParamsArr[9] = new ECPageParserParams(24, "qshop_product_detail_table_title", null, ext, 4, null);
        eCPageParserParamsArr[10] = new ECPageParserParams(0, "qshop_product_detail_table", null, ext, 5, null);
        eCPageParserParamsArr[11] = new ECPageParserParams(0, "qshop_detail_pictures", null, ext, 5, null);
        eCPageParserParamsArr[12] = new ECPageParserParams(0, "qshop_detail_price_desc", null, ext, 5, null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) eCPageParserParamsArr);
        return listOf;
    }

    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> processRemoteParserParamsArray(JSONObject data, JSONObject ext) {
        JSONObject optJSONObject;
        ArrayList arrayList = null;
        JSONArray optJSONArray = (data == null || (optJSONObject = data.optJSONObject("product")) == null) ? null : optJSONObject.optJSONArray("page_names");
        if (optJSONArray != null) {
            arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                arrayList.add(new ECPageParserParams(Integer.parseInt(optJSONObject2.optString("parser_id")), optJSONObject2.optString("page_name"), "", ext));
            }
        }
        return arrayList;
    }
}
