package tp2;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public String f437064d;

    /* renamed from: e, reason: collision with root package name */
    boolean f437065e;

    public static a b(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            QLog.i("search_manager_configSearchFunctionModuleBean", 1, "#parse: content is empty");
            return aVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f437065e = true;
            aVar.f437064d = jSONObject.optString("kFTSFunctionListUrlKey");
            QLog.i("search_manager_configSearchFunctionModuleBean", 1, "#parse: config=" + str + JefsClass.INDEX_URL + aVar.f437064d);
            return aVar;
        } catch (JSONException e16) {
            QLog.i("search_manager_configSearchFunctionModuleBean", 1, "#parse: ", e16);
            return aVar;
        }
    }

    @Deprecated
    public static a c(ai[] aiVarArr) {
        String str;
        a aVar = new a();
        if (aiVarArr != null && aiVarArr.length > 0) {
            str = aiVarArr[0].f202268b;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("search_manager_configSearchFunctionModuleBean", 1, "content is empty");
            return aVar;
        }
        try {
            aVar.f437064d = new JSONObject(str).optString("kFTSFunctionListUrlKey");
            aVar.f437065e = true;
            QLog.i("search_manager_configSearchFunctionModuleBean", 1, "parse config=" + str + JefsClass.INDEX_URL + aVar.f437064d);
        } catch (Exception e16) {
            QLog.i("search_manager_configSearchFunctionModuleBean", 1, "parse", e16);
        }
        return aVar;
    }

    public boolean a() {
        return this.f437065e;
    }
}
