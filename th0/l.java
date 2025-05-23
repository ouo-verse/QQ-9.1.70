package th0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.ecommerce.biz.detail.ECDetailConstantsKt;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lth0/l;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lorg/json/JSONObject;", "productData", "a", "recommendData", "b", "c", "data", "", "d", "Lbh0/e;", "parserParams", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class l implements IECPTSComposerParser {
    private final JSONObject c(JSONObject productData) {
        JSONObject jSONObject = new JSONObject(productData.toString());
        long optLong = jSONObject.optLong("price", 0L);
        JSONArray optJSONArray = jSONObject.optJSONArray("prices");
        long optLong2 = jSONObject.optLong("commission", 0L);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("commissions");
        com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
        jSONObject.put("price_yuan", iVar.b(optLong));
        if (optJSONArray != null) {
            if (optJSONArray.length() == 1) {
                jSONObject.put("price_yuan", iVar.b(optJSONArray.optLong(0, 0L)));
            } else if (optJSONArray.length() >= 2) {
                long optLong3 = optJSONArray.optLong(0, 0L);
                long optLong4 = optJSONArray.optLong(optJSONArray.length() - 1, 0L);
                jSONObject.put("price_yuan", iVar.b(optLong3));
                jSONObject.put("price_yuan_min", iVar.b(optLong3));
                jSONObject.put("price_yuan_max", iVar.b(optLong4));
            }
        }
        jSONObject.put("commission_yuan", iVar.b(optLong2));
        if (optJSONArray2 != null) {
            if (optJSONArray2.length() == 1) {
                jSONObject.put("commission_yuan", iVar.b(optJSONArray2.optLong(0, 0L)));
            } else if (optJSONArray2.length() >= 2) {
                long optLong5 = optJSONArray2.optLong(0, 0L);
                long optLong6 = optJSONArray2.optLong(optJSONArray2.length() - 1, 0L);
                jSONObject.put("commission_yuan", iVar.b(optLong5));
                jSONObject.put("commission_yuan_min", iVar.b(optLong5));
                jSONObject.put("commission_yuan_max", iVar.b(optLong6));
            }
        }
        jSONObject.put("card_width", ECDetailConstantsKt.a().invoke().intValue());
        jSONObject.put("is_host", 1);
        return jSONObject;
    }

    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        ArrayList arrayList = new ArrayList();
        String str = parserParams.pageName;
        JSONObject jSONObject = parserParams.ext;
        if (jSONObject != null ? jSONObject.optBoolean("EC_IS_CUSTOM") : false) {
            if (data == null || (jSONArray3 = data.optJSONArray("products")) == null) {
                jSONArray3 = new JSONArray();
            }
            int length = jSONArray3.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray3.optJSONObject(i3);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                JSONObject a16 = a(optJSONObject);
                arrayList.add(new ECBasePtsViewData(null, str, a16.toString(), gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), a16.toString(), null), 1, null));
            }
        } else if (d(data)) {
            if (data == null || (jSONArray2 = data.optJSONArray("related_recomms")) == null) {
                jSONArray2 = new JSONArray();
            }
            int length2 = jSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                JSONObject b16 = b(new JSONObject(jSONArray2.optJSONObject(i16).toString()));
                arrayList.add(new ECBasePtsViewData(null, str, b16.toString(), gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), b16.toString(), null), 1, null));
            }
        } else {
            if (data == null || (jSONArray = data.optJSONArray("product_list")) == null) {
                jSONArray = new JSONArray();
            }
            int length3 = jSONArray.length();
            for (int i17 = 0; i17 < length3; i17++) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i17);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                JSONObject c16 = c(optJSONObject2);
                arrayList.add(new ECBasePtsViewData(null, str, c16.toString(), gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), c16.toString(), null), 1, null));
            }
        }
        return arrayList;
    }

    private final JSONObject a(JSONObject productData) {
        String str;
        String str2;
        String str3;
        String str4;
        long j3;
        String str5;
        String str6;
        JSONObject jSONObject;
        String optString;
        String str7 = "";
        if (productData == null || (str = productData.optString("title")) == null) {
            str = "";
        }
        long optLong = productData != null ? productData.optLong("sales") : 0L;
        if (productData == null || (str2 = productData.optString("sales_txt")) == null) {
            str2 = "";
        }
        if (str2.length() == 0) {
            str2 = String.valueOf(optLong);
        }
        long optLong2 = productData != null ? productData.optLong("price") : 0L;
        com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
        String d16 = iVar.d(optLong2);
        JSONObject optJSONObject = productData != null ? productData.optJSONObject("price_range") : null;
        if (optJSONObject != null) {
            str3 = "price";
            str4 = d16;
            j3 = optLong2;
            str6 = iVar.b(optJSONObject.optLong("lower", 0L));
            str5 = iVar.b(optJSONObject.optLong("upper", 0L));
        } else {
            str3 = "price";
            str4 = d16;
            j3 = optLong2;
            str5 = "";
            str6 = str5;
        }
        JSONArray optJSONArray = productData != null ? productData.optJSONArray("cdn_main_pics") : null;
        if (productData != null && (optString = productData.optString("detail_url")) != null) {
            str7 = optString;
        }
        if (productData == null || (jSONObject = productData.optJSONObject(IndividuationUrlHelper.UrlId.PENDANT_HOME)) == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("title", str);
        jSONObject2.put("sales", optLong);
        jSONObject2.put("sales_txt", str2);
        jSONObject2.put(str3, j3);
        jSONObject2.put("price_yuan", str4);
        jSONObject2.put("price_yuan_min", str6);
        jSONObject2.put("price_yuan_max", str5);
        jSONObject2.put("cdn_main_pics", optJSONArray);
        jSONObject2.put("detail_url", str7);
        jSONObject2.put("card_width", ECDetailConstantsKt.a().invoke().intValue());
        jSONObject2.put("is_host", 0);
        jSONObject2.put(IndividuationUrlHelper.UrlId.PENDANT_HOME, jSONObject);
        return jSONObject2;
    }

    private final boolean d(JSONObject data) {
        return com.tencent.ecommerce.biz.detail.utils.e.f102467a.e(String.valueOf(data != null ? data.optInt("goods_type", 0) : 0));
    }

    private final JSONObject b(JSONObject recommendData) {
        String str;
        String str2;
        String str3;
        long j3;
        long j16;
        String str4;
        long j17;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = recommendData != null ? recommendData.optJSONObject("product") : null;
        if (optJSONObject2 == null || (str = optJSONObject2.optString("title")) == null) {
            str = "";
        }
        long optLong = optJSONObject2 != null ? optJSONObject2.optLong("sales") : 0L;
        String valueOf = String.valueOf(optLong);
        long optLong2 = (recommendData == null || (optJSONObject = recommendData.optJSONObject("commission")) == null) ? 0L : optJSONObject.optLong("commission");
        com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
        String d16 = iVar.d(optLong2);
        JSONObject optJSONObject3 = recommendData != null ? recommendData.optJSONObject("price") : null;
        if (optJSONObject3 != null) {
            str2 = "";
            str3 = "price";
            j3 = optJSONObject3.optLong("price");
        } else {
            str2 = "";
            str3 = "price";
            j3 = 0;
        }
        String d17 = iVar.d(j3);
        JSONObject optJSONObject4 = recommendData != null ? recommendData.optJSONObject("commission_range") : null;
        long j18 = j3;
        if (optJSONObject4 != null) {
            j16 = optLong2;
            str4 = "commission";
            j17 = 0;
            String b16 = iVar.b(optJSONObject4.optLong("min_commission", 0L));
            str5 = iVar.b(optJSONObject4.optLong("max_commission", 0L));
            str6 = b16;
        } else {
            j16 = optLong2;
            str4 = "commission";
            j17 = 0;
            str5 = str2;
            str6 = str5;
        }
        JSONObject optJSONObject5 = recommendData != null ? recommendData.optJSONObject("price_range") : null;
        if (optJSONObject5 != null) {
            str9 = str4;
            str7 = "sales";
            str8 = str6;
            str10 = iVar.b(optJSONObject5.optLong("min_price", j17));
            str11 = iVar.b(optJSONObject5.optLong("max_price", j17));
        } else {
            str7 = "sales";
            str8 = str6;
            str9 = str4;
            str10 = str2;
            str11 = str10;
        }
        JSONArray optJSONArray = optJSONObject2 != null ? optJSONObject2.optJSONArray("main_pics") : null;
        if (recommendData == null || (str12 = recommendData.optString("url")) == null) {
            str12 = str2;
        }
        if (recommendData == null || (jSONObject = recommendData.optJSONObject(IndividuationUrlHelper.UrlId.PENDANT_HOME)) == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.length() <= 0 && (optJSONObject2 == null || (jSONObject = optJSONObject2.optJSONObject(IndividuationUrlHelper.UrlId.PENDANT_HOME)) == null)) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("title", str);
        jSONObject2.put(str7, optLong);
        jSONObject2.put("sales_txt", valueOf);
        jSONObject2.put(str9, j16);
        jSONObject2.put("commission_yuan", d16);
        jSONObject2.put("commission_yuan_min", str8);
        jSONObject2.put("commission_yuan_max", str5);
        jSONObject2.put(str3, j18);
        jSONObject2.put("price_yuan", d17);
        jSONObject2.put("price_yuan_min", str10);
        jSONObject2.put("price_yuan_max", str11);
        jSONObject2.put("cdn_main_pics", optJSONArray);
        jSONObject2.put("detail_url", str12);
        jSONObject2.put("card_width", ECDetailConstantsKt.a().invoke().intValue());
        jSONObject2.put("is_host", 1);
        jSONObject2.put(IndividuationUrlHelper.UrlId.PENDANT_HOME, jSONObject);
        return jSONObject2;
    }
}
