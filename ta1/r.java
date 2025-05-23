package ta1;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class r implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private String f435753d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f435754e = "";

    public static r a(String str) {
        r rVar = new r();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("AndroidDrawerJumpURL")) {
                rVar.f435753d = jSONObject.getString("AndroidDrawerJumpURL");
                if (QLog.isColorLevel()) {
                    QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidDrawerJumpURL = " + rVar.f435753d);
                }
            }
            if (jSONObject.has("AndroidAioJumpURL")) {
                rVar.f435754e = jSONObject.getString("AndroidAioJumpURL");
                if (QLog.isColorLevel()) {
                    QLog.d("TencentDocUserConfigBean", 2, "handleTencentDocUserConfigCmd AndroidAioJumpURL = " + rVar.f435754e);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return rVar;
    }
}
