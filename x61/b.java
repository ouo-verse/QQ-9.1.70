package x61;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f447284a;

    public static synchronized a a(Context context, String str) {
        synchronized (b.class) {
            JSONObject jSONObject = null;
            if (context == null || str == null) {
                return null;
            }
            if (f447284a == null) {
                String string = context.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).getString("RECOMMENDED_STICKER_AD_CFG" + str, null);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                try {
                    jSONObject = new JSONObject(string);
                } catch (Exception e16) {
                    QLog.e("AdEmoCfgProvider", 2, "getAdEmoCfg has exception\uff0ccfgStr = " + string, e16);
                }
                if (jSONObject != null) {
                    f447284a = b(jSONObject);
                }
            }
            return f447284a;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (r6.getInt(com.tencent.thumbplayer.report.reportv1.TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH) == 1) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a b(JSONObject jSONObject) {
        int i3;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        try {
            if (jSONObject.has(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)) {
                z16 = 1;
            }
            z16 = 0;
            try {
                if (jSONObject.has("sortType")) {
                    i3 = jSONObject.getInt("sortType");
                } else {
                    i3 = 0;
                }
            } catch (JSONException e16) {
                e = e16;
                i3 = 0;
            }
        } catch (JSONException e17) {
            e = e17;
            i3 = 0;
        }
        try {
            if (jSONObject.has("adList")) {
                JSONArray jSONArray = jSONObject.getJSONArray("adList");
                while (i16 < jSONArray.length()) {
                    f c16 = c(jSONArray.getJSONObject(i16));
                    if (c16 != null) {
                        arrayList.add(c16);
                    }
                    i16++;
                }
            }
        } catch (JSONException e18) {
            e = e18;
            i16 = z16 ? 1 : 0;
            QLog.e("AdEmoCfgProvider", 2, "parseJson has exception\uff0ccfgObj = " + jSONObject.toString(), e);
            z16 = i16;
            return new a(z16, i3, arrayList);
        }
        return new a(z16, i3, arrayList);
    }

    public static f c(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            if (jSONObject.has("keyWords")) {
                JSONArray jSONArray = jSONObject.getJSONArray("keyWords");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
            }
            if (jSONObject.has("emos")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("emos");
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                    String optString = jSONObject2.optString("imgUrl", "");
                    String optString2 = jSONObject2.optString("md5", "");
                    Long valueOf = Long.valueOf(jSONObject2.optLong("fileSize", 0L));
                    int optInt = jSONObject2.optInt("width", 0);
                    int optInt2 = jSONObject2.optInt("height", 0);
                    String optString3 = jSONObject2.optString(WadlProxyConsts.KEY_JUMP_URL, "");
                    String optString4 = jSONObject2.optString("desc", "");
                    d dVar = new d();
                    dVar.f447286a = optString;
                    dVar.f447287b = optString2;
                    dVar.f447288c = valueOf.longValue();
                    dVar.f447289d = optInt;
                    dVar.f447290e = optInt2;
                    dVar.f447291f = optString3;
                    dVar.f447292g = optString4;
                    arrayList2.add(dVar);
                }
            }
        } catch (JSONException e16) {
            QLog.e("AdEmoCfgProvider", 2, "parseAdItemJson has exception\uff0c adObject = " + jSONObject.toString(), e16);
        }
        return new f(arrayList, arrayList2);
    }

    public static synchronized void d(Context context, String str, JSONObject jSONObject) {
        String jSONObject2;
        synchronized (b.class) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateCfgStr, cfgJsonObject = ");
                if (jSONObject == null) {
                    jSONObject2 = "null";
                } else {
                    jSONObject2 = jSONObject.toString();
                }
                sb5.append(jSONObject2);
                QLog.d("AdEmoCfgProvider", 2, sb5.toString());
            }
            if (jSONObject != null) {
                f447284a = b(jSONObject);
                if (context != null) {
                    context.getSharedPreferences("MOBILEQQ_RECOMMENDED_STICKER_CONFIG", 4).edit().putString("RECOMMENDED_STICKER_AD_CFG" + str, jSONObject.toString()).apply();
                }
            }
        }
    }
}
