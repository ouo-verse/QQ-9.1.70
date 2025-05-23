package yj0;

import com.tencent.ecommerce.base.network.api.IECResponse;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lyj0/d;", "Lcom/tencent/ecommerce/base/network/api/IECResponse;", "Lorg/json/JSONObject;", "data", "", "decodeData", "Lyj0/b;", "d", "Lyj0/b;", "getLabelItem", "()Lyj0/b;", "setLabelItem", "(Lyj0/b;)V", "labelItem", "e", "Ljava/lang/Boolean;", "getHasPromotionItem", "()Ljava/lang/Boolean;", "setHasPromotionItem", "(Ljava/lang/Boolean;)V", "hasPromotionItem", "Ljava/util/ArrayList;", "Lyj0/c;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setPromotionItemList", "(Ljava/util/ArrayList;)V", "promotionItemList", "Lyj0/a;", h.F, "Lyj0/a;", "getAdvertiseItem", "()Lyj0/a;", "setAdvertiseItem", "(Lyj0/a;)V", "advertiseItem", "<init>", "()V", "i", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class d implements IECResponse {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECLabelItem labelItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Boolean hasPromotionItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ECPromoteItem> promotionItemList = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ECAdvertiseItem advertiseItem;

    public final ArrayList<ECPromoteItem> a() {
        return this.promotionItemList;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECResponse
    public boolean decodeData(JSONObject data) {
        cg0.a.b("ECPromotionResp", "[decodeData] data = " + data);
        if (data == null) {
            return false;
        }
        JSONObject optJSONObject = data.optJSONObject("label_item");
        if (optJSONObject != null) {
            this.labelItem = new ECLabelItem(optJSONObject.optString("label_name", ""), optJSONObject.optString("label_msg", ""));
        }
        this.hasPromotionItem = Boolean.valueOf(data.optBoolean("has_promote_item", false));
        JSONObject optJSONObject2 = data.optJSONObject("advertise_item");
        if (optJSONObject2 != null) {
            this.advertiseItem = new ECAdvertiseItem(optJSONObject2.optString("name", ""), optJSONObject2.optInt(WadlProxyConsts.CHANNEL, 0), optJSONObject2.optString("ad_id", ""));
        }
        JSONArray optJSONArray = data.optJSONArray("promote_item");
        if (optJSONArray == null) {
            return true;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i3);
            this.promotionItemList.add(new ECPromoteItem(optJSONObject3.optString("msg", ""), optJSONObject3.optString("url", ""), optJSONObject3.optString("img", ""), optJSONObject3.optString("night_img", ""), optJSONObject3.optString("js_bundle_key", "")));
        }
        return true;
    }
}
