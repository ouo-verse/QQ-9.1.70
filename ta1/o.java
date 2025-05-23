package ta1;

import androidx.annotation.NonNull;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, Long> f435722d = new HashMap();

    @NonNull
    public static o b(String str) {
        o oVar = new o();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                oVar.f435722d.put(str2, Long.valueOf(jSONObject.getLong(str2)));
            }
        } catch (JSONException e16) {
            QLog.e("TencentDocPreviewConfigBean", 1, e16.getLocalizedMessage(), e16);
        }
        return oVar;
    }

    public Map<String, Long> a() {
        return this.f435722d;
    }
}
