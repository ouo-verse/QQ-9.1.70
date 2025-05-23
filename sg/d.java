package sg;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.CellUniverse;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.proxy.feedcomponent.model.j;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\u000f"}, d2 = {"Lsg/d;", "", "Lorg/json/JSONArray;", "dataList", "", "Lcom/qzone/proxy/feedcomponent/model/j$a;", "b", "Lcom/qzone/proxy/feedcomponent/model/CellUniverse;", "cellUniverse", "", "a", "Lcom/qzone/proxy/feedcomponent/model/j;", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f433774a = new d();

    d() {
    }

    public final j c(CellUniverse cellUniverse) {
        String str;
        String str2;
        if (!a(cellUniverse)) {
            return null;
        }
        Intrinsics.checkNotNull(cellUniverse);
        String str3 = cellUniverse.jsonTemplate;
        j jVar = new j();
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (jSONObject.optInt("style") == 3) {
                JSONObject optJSONObject = jSONObject.optJSONObject("card_list");
                jVar.e(b(optJSONObject != null ? optJSONObject.optJSONArray("item_list") : null));
                String str4 = "";
                if (optJSONObject == null) {
                    str = "";
                } else {
                    str = optJSONObject.optString("title");
                }
                jVar.g(str);
                if (optJSONObject == null) {
                    str2 = "";
                } else {
                    str2 = optJSONObject.optString("title_right");
                }
                jVar.h(str2);
                if (optJSONObject != null) {
                    str4 = optJSONObject.optString("right_jump_url");
                }
                jVar.f(str4);
            }
        } catch (Exception e16) {
            QLog.e("QZoneFriendPostingFeedUtil", 1, "[parseFriendPostingFeedData] failed:", e16);
        }
        return jVar;
    }

    public final boolean a(CellUniverse cellUniverse) {
        if (cellUniverse == null || cellUniverse.universeType != 89) {
            return false;
        }
        if (!TextUtils.isEmpty(cellUniverse.jsonTemplate)) {
            return true;
        }
        QLog.e("QZoneFriendPostingFeedUtil", 1, "json template is empty");
        return false;
    }

    private final List<j.a> b(JSONArray dataList) {
        if (dataList == null) {
            return null;
        }
        QLog.i("QZoneFriendPostingFeedUtil", 1, "[parseCardListFeedData] dataList:" + dataList);
        ArrayList arrayList = new ArrayList();
        try {
            int length = dataList.length();
            for (int i3 = 0; i3 < length; i3++) {
                j.a aVar = new j.a();
                JSONObject jSONObject = dataList.getJSONObject(i3);
                aVar.i(jSONObject.optString("ad_id"));
                aVar.p(jSONObject.optString("trace_info"));
                aVar.o(jSONObject.optString("title"));
                aVar.n(jSONObject.optString("summary"));
                aVar.l(jSONObject.optString("jump_url"));
                aVar.k(jSONObject.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT));
                aVar.j(jSONObject.optString("button_jump"));
                PictureItem pictureItem = new PictureItem();
                pictureItem.currentUrl = new PictureUrl(jSONObject.optString("icon"), 0, 0);
                aVar.m(pictureItem);
                arrayList.add(aVar);
            }
        } catch (JSONException e16) {
            QLog.e("QZoneFriendPostingFeedUtil", 1, "[parseCardListFeedData] failed:", e16);
        }
        return arrayList;
    }
}
