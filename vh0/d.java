package vh0;

import bh0.ECPageParserParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lvh0/d;", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lorg/json/JSONObject;", "data", "ext", "", "Lbh0/e;", "processRemoteParserParamsArray", "localPageParserParamsArray", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class d extends com.tencent.ecommerce.biz.detail.dataprocessor.processor.a {
    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        List<ECPageParserParams> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECPageParserParams[]{new ECPageParserParams(21, "product_detail_mainpic", null, ext, 4, null), new ECPageParserParams(0, "qshop_detail_price_sales", null, ext, 5, null), new ECPageParserParams(0, "qshop_detail_labels", null, ext, 5, null), new ECPageParserParams(3, "product_detail_name_source_host", null, ext, 4, null), new ECPageParserParams(33, "qshop_detail_services", null, ext, 4, null), new ECPageParserParams(0, "qshop_detail_bulletin", null, ext, 5, null), new ECPageParserParams(34, "product_detail_commission", null, ext, 4, null), new ECPageParserParams(0, "qshop_chart_info_view_container", null, ext, 5, null), new ECPageParserParams(0, "qshop_detail_comment", null, ext, 5, null), new ECPageParserParams(23, "qshop_head_card", null, ext, 4, null), new ECPageParserParams(24, "qshop_product_detail_table_title", null, ext, 4, null), new ECPageParserParams(0, "qshop_product_detail_table", null, ext, 5, null), new ECPageParserParams(0, "qshop_detail_pictures", null, ext, 5, null), new ECPageParserParams(0, "product_distribution_rule", null, ext, 5, null)});
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
