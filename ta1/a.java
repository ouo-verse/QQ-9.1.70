package ta1;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f435626d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private String f435627e = HardCodeUtil.qqStr(R.string.u2g);

    /* renamed from: f, reason: collision with root package name */
    private String f435628f = "";

    public static a b(String str) {
        QLog.d("TenDocDirectShareConfigBean", 2, str);
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("suffix");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                aVar.f435626d.add(jSONArray.getString(i3));
            }
            aVar.f435627e = jSONObject.getString("title");
            aVar.f435628f = jSONObject.getString("desc");
        } catch (JSONException e16) {
            QLog.e("TenDocDirectShareConfigBean", 1, e16.getLocalizedMessage(), e16);
        }
        return aVar;
    }

    public List<String> a() {
        return this.f435626d;
    }
}
