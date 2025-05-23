package ta1;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private String f435629d = "";

    /* renamed from: e, reason: collision with root package name */
    private boolean f435630e = false;

    public static b c(String str) {
        QLog.d("TenDocGroupListEntryConfigBean", 2, str);
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("AndroidGroupListJumpURL")) {
                bVar.f435629d = jSONObject.getString("AndroidGroupListJumpURL");
                if (QLog.isColorLevel()) {
                    QLog.d("TenDocGroupListEntryConfigBean", 2, "handleTenDocGroupListEntryConfig mAndroidGroupListJumpURL = " + bVar.f435629d);
                }
            }
            if (jSONObject.has("AndroidGroupListWebEnable")) {
                bVar.f435630e = jSONObject.getBoolean("AndroidGroupListWebEnable");
                if (QLog.isColorLevel()) {
                    QLog.d("TenDocGroupListEntryConfigBean", 2, "handleTenDocGroupListEntryConfig AndroidGroupListWebEnable = " + bVar.f435630e);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return bVar;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f435629d)) {
            return null;
        }
        return this.f435629d;
    }

    public boolean b() {
        return this.f435630e;
    }
}
