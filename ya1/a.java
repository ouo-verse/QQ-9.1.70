package ya1;

import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f449928a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f449929b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f449930c = null;

    public static a a(ai aiVar) {
        a aVar = new a();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("JoinGroupConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            try {
                JSONObject jSONObject = new JSONObject(aiVar.f202268b);
                aVar.f449928a = jSONObject.optInt("showEntrance", 0);
                aVar.f449929b = jSONObject.optString("entranceName", "");
                aVar.f449930c = jSONObject.optString("url", "");
                if (QLog.isColorLevel()) {
                    QLog.d("JoinGroupConfBean", 2, "JoinGroupConfBean " + aVar.toString());
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("JoinGroupConfBean", 2, "parse error->" + e16.toString());
                }
            }
        }
        return aVar;
    }
}
