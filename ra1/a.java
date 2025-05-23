package ra1;

import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f431003a = 1;

    public static a b(ai aiVar) {
        a aVar = new a();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SysSuspiciousConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            try {
                aVar.f431003a = new JSONObject(aiVar.f202268b).optInt("suspiciousSwitch", 1);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SysSuspiciousConfBean", 2, "parse error->" + e16.toString());
                }
            }
        }
        return aVar;
    }

    public boolean a() {
        if (this.f431003a == 1) {
            return true;
        }
        return false;
    }
}
