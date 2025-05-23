package th0;

import bh0.ECPageParserParams;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.pts.core.PTSComposer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lth0/b;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class b implements IECPTSComposerParser {
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r4 != null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0142  */
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        String str;
        long j3;
        String str2;
        String str3;
        long j16;
        long j17;
        String str4;
        String str5;
        long j18;
        List<ECBasePtsViewData> listOf;
        int i3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9;
        JSONObject optJSONObject10;
        JSONArray optJSONArray;
        JSONObject optJSONObject11;
        JSONObject optJSONObject12;
        String str6 = parserParams.pageName;
        long optLong = data != null ? data.optLong("price") : 0L;
        long optLong2 = (data == null || (optJSONObject12 = data.optJSONObject("product")) == null) ? 0L : optJSONObject12.optLong("sales");
        long optLong3 = data != null ? data.optLong("origin_price") : 0L;
        long optLong4 = data != null ? data.optLong("commission") : 0L;
        if (data == null || (str = data.optString("commission_rate")) == null) {
            str = "";
        }
        if (data != null) {
            JSONObject optJSONObject13 = data.optJSONObject("product");
            j3 = optLong;
            if (optJSONObject13 != null) {
                str2 = optJSONObject13.optString("title");
            }
        } else {
            j3 = optLong;
        }
        str2 = "";
        if (data == null || (optJSONObject11 = data.optJSONObject("product")) == null || (str3 = optJSONObject11.optString("source")) == null) {
            str3 = "";
        }
        int optInt = data != null ? data.optInt("goods_type") : 0;
        if (data != null) {
            j17 = data.optLong("coupon_price");
            j16 = optLong3;
        } else {
            j16 = optLong3;
            j17 = 0;
        }
        if (optInt == 2) {
            if (data == null || (optJSONObject10 = data.optJSONObject("commission_detail")) == null || (optJSONArray = optJSONObject10.optJSONArray("commission_details")) == null) {
                str4 = str6;
                i3 = 0;
            } else {
                i3 = optJSONArray.length();
                str4 = str6;
            }
            if (i3 >= 1) {
                JSONArray optJSONArray2 = (data == null || (optJSONObject9 = data.optJSONObject("commission_detail")) == null) ? null : optJSONObject9.optJSONArray("commission_details");
                long optLong5 = (optJSONArray2 == null || (optJSONObject7 = optJSONArray2.optJSONObject(0)) == null || (optJSONObject8 = optJSONObject7.optJSONObject("price")) == null) ? 0L : optJSONObject8.optLong("price");
                long optLong6 = (optJSONArray2 == null || (optJSONObject5 = optJSONArray2.optJSONObject(0)) == null || (optJSONObject6 = optJSONObject5.optJSONObject("price")) == null) ? 0L : optJSONObject6.optLong("origin_price");
                if (optJSONArray2 == null || (optJSONObject3 = optJSONArray2.optJSONObject(0)) == null || (optJSONObject4 = optJSONObject3.optJSONObject("commission")) == null || (str5 = optJSONObject4.optString("commission_rate")) == null) {
                    str5 = "";
                }
                j17 = (optJSONArray2 == null || (optJSONObject = optJSONArray2.optJSONObject(0)) == null || (optJSONObject2 = optJSONObject.optJSONObject("price")) == null) ? 0L : optJSONObject2.optLong("coupon_price");
                long j19 = optLong5;
                j18 = optLong6;
                j3 = j19;
                JSONObject jSONObject = new JSONObject();
                com.tencent.ecommerce.biz.util.i iVar = com.tencent.ecommerce.biz.util.i.f104869a;
                jSONObject.put("ec_ProductInfo_BasicInfo_price", iVar.b(j17 == 0 ? j17 : j3));
                jSONObject.put("ec_ProductInfo_BasicInfo_sales", optLong2);
                if (j18 != j3) {
                    jSONObject.put("ec_ProductInfo_BasicInfo_origin_price", iVar.b(j18));
                }
                jSONObject.put("ec_ProductInfo_BasicInfo_source", str3);
                jSONObject.put("ec_ProductInfo_BasicInfo_title", str2);
                jSONObject.put("ec_ProductInfo_SellerProductRsp_commission", iVar.b(optLong4));
                jSONObject.put("ec_ProductInfo_SellerProductRsp_commission_rate", str5);
                jSONObject.put("ec_ProductInfo_SellerProductRsp_price", iVar.b(j17 == 0 ? j17 : j3));
                if (j18 != j3) {
                    jSONObject.put("origin_price_display", iVar.b(j18));
                }
                String jSONObject2 = jSONObject.toString();
                String str7 = str4;
                PTSComposer b16 = gh0.d.f402041a.b(str7, ECPTSStyleManager.e(str7, wg0.a.a()), jSONObject2, null);
                cg0.a.b("ECProductDetailPtsParserCommission", "[parse] proteusData = " + jSONObject2);
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str7, jSONObject2, b16, 1, null));
                return listOf;
            }
        } else {
            str4 = str6;
        }
        str5 = str;
        j18 = j16;
        JSONObject jSONObject3 = new JSONObject();
        com.tencent.ecommerce.biz.util.i iVar2 = com.tencent.ecommerce.biz.util.i.f104869a;
        jSONObject3.put("ec_ProductInfo_BasicInfo_price", iVar2.b(j17 == 0 ? j17 : j3));
        jSONObject3.put("ec_ProductInfo_BasicInfo_sales", optLong2);
        if (j18 != j3) {
        }
        jSONObject3.put("ec_ProductInfo_BasicInfo_source", str3);
        jSONObject3.put("ec_ProductInfo_BasicInfo_title", str2);
        jSONObject3.put("ec_ProductInfo_SellerProductRsp_commission", iVar2.b(optLong4));
        jSONObject3.put("ec_ProductInfo_SellerProductRsp_commission_rate", str5);
        jSONObject3.put("ec_ProductInfo_SellerProductRsp_price", iVar2.b(j17 == 0 ? j17 : j3));
        if (j18 != j3) {
        }
        String jSONObject22 = jSONObject3.toString();
        String str72 = str4;
        PTSComposer b162 = gh0.d.f402041a.b(str72, ECPTSStyleManager.e(str72, wg0.a.a()), jSONObject22, null);
        cg0.a.b("ECProductDetailPtsParserCommission", "[parse] proteusData = " + jSONObject22);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ECBasePtsViewData(null, str72, jSONObject22, b162, 1, null));
        return listOf;
    }
}
