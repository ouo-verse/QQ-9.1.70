package xp2;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public String f448278d;

    /* renamed from: e, reason: collision with root package name */
    public JSONObject f448279e;

    /* renamed from: f, reason: collision with root package name */
    boolean f448280f;

    private static void a(a aVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f448280f = true;
            aVar.f448278d = jSONObject.optString("experimentId2");
            aVar.f448279e = jSONObject.optJSONObject("defaultConfig");
        } catch (JSONException e16) {
            QLog.e("SearchTnnConfigBean", 1, "parse json error", e16);
        }
    }

    public static a b(String str) {
        a aVar = new a();
        a(aVar, str);
        return aVar;
    }

    public static a c(ai[] aiVarArr) {
        String str;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0) {
            str = aiVarArr[0].f202268b;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        QLog.d("SearchTnnConfigBean", 1, "parse conf=" + str);
        a(aVar, str);
        return aVar;
    }
}
