package vh0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lvh0/f;", "Lcom/tencent/ecommerce/biz/detail/dataprocessor/processor/a;", "Lorg/json/JSONObject;", "ext", "", "Lbh0/e;", "localPageParserParamsArray", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class f extends com.tencent.ecommerce.biz.detail.dataprocessor.processor.a {
    @Override // com.tencent.ecommerce.biz.detail.dataprocessor.processor.a, com.tencent.ecommerce.base.ui.component.IECPTSProcessor
    public List<ECPageParserParams> localPageParserParamsArray(JSONObject ext) {
        int optInt = ext != null ? ext.optInt("recommend_data_request_scene") : 0;
        ArrayList arrayList = new ArrayList();
        if ((ext != null ? ext.optBoolean("is_first_screen_recommend", true) : true) && optInt != ECShopRecommendScene.QQ_OFF_SALE_SCENE.value) {
            arrayList.add(new ECPageParserParams(0, "qshop_detail_recommen_title_new", "", ext));
            if (ext != null && ext.optInt("show_recomment_none") == 1) {
                arrayList.add(new ECPageParserParams(0, "qshop_detail_recommen_none", "", ext));
            }
        }
        if (optInt == ECShopRecommendScene.QQ_SHOP_WEB_PRODUCT_DETAIL.value) {
            arrayList.add(new ECPageParserParams(29, "apply_sample_recommend_card", "", ext));
        } else {
            arrayList.add(new ECPageParserParams(29, "shop_home_product_card", "", ext));
        }
        return arrayList;
    }
}
