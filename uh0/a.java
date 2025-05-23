package uh0;

import bh0.ECPageParserParams;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.component.IECPTSComposerParser;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Luh0/a;", "Lcom/tencent/ecommerce/base/ui/component/IECPTSComposerParser;", "Lbh0/e;", "parserParams", "Lorg/json/JSONObject;", "data", "reqParam", "", "Lcom/tencent/ecommerce/base/ui/b;", "parse", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a implements IECPTSComposerParser {
    @Override // com.tencent.ecommerce.base.ui.component.IECPTSComposerParser
    public List<ECBasePtsViewData> parse(ECPageParserParams parserParams, JSONObject data, JSONObject reqParam) {
        ArrayList arrayListOf;
        ArrayList arrayListOf2;
        String str = parserParams.pageName;
        if (data == null) {
            cg0.a.a("ECProductCommentPtsTableParser", "parse", "data is invalid");
            return new ArrayList();
        }
        JSONArray optJSONArray = data.optJSONArray("review_detail");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(0, 1, 2, 3, 4);
                jSONObject.put("star_loop", new JSONArray((Collection) arrayListOf));
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(0, 1, 2);
                jSONObject.put("pic_loop", new JSONArray((Collection) arrayListOf2));
                jSONObject.put("create_time_display", new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(Long.valueOf(jSONObject.optLong(AlbumCacheData.CREATE_TIME, 0L))));
                String jSONObject2 = jSONObject.toString();
                arrayList.add(new ECBasePtsViewData(null, str, jSONObject2, gh0.d.f402041a.b(str, ECPTSStyleManager.e(str, wg0.a.a()), jSONObject2, null), 1, null));
            }
        }
        return arrayList;
    }
}
