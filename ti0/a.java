package ti0;

import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.util.k;
import com.tencent.ecommerce.biz.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\b\u001a\u00020\u0004J8\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b\u00a8\u0006\u0015"}, d2 = {"Lti0/a;", "", "Lorg/json/JSONArray;", "", "Lorg/json/JSONObject;", "e", "product", "a", "data", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "d", "", "shopId", "spuIds", "Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "scene", "text", "cookie", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f436377a = new a();

    a() {
    }

    private final JSONArray a(JSONObject product) {
        String optString = product.optString("title", "");
        String str = optString != null ? optString : "";
        JSONArray optJSONArray = product.optJSONArray("labels");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        l h16 = new k(null, 1, null).h(optJSONArray);
        h16.e(str, 14, "qecommerce_skin_color_text_primary", 2);
        return h16.g();
    }

    private final List<JSONObject> e(JSONArray jSONArray) {
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(jSONArray.optJSONObject(i3));
        }
        return arrayList;
    }

    public final JSONObject b(String shopId, List<String> spuIds, ECShopRecommendScene scene, String text, String cookie) {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = spuIds.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put((String) it.next());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("shop_id", shopId);
        jSONObject.put("spu_ids", jSONArray);
        jSONObject.put("scene", scene.value);
        jSONObject.put("full_txt", text);
        jSONObject.put("cookie", cookie);
        return jSONObject;
    }

    public final List<ECProductRecommendItemData> d(JSONObject data) {
        List<ECProductRecommendItemData> emptyList;
        List<JSONObject> e16;
        int collectionSizeOrDefault;
        JSONArray optJSONArray = data.optJSONArray("recom_card");
        if (optJSONArray == null || (e16 = e(optJSONArray)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<JSONObject> list = e16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (JSONObject jSONObject : list) {
            jSONObject.put("nodes", f436377a.a(jSONObject));
            arrayList.add(new ECProductRecommendItemData(jSONObject.optString("spu_id"), jSONObject.toString()));
        }
        return arrayList;
    }
}
