package va1;

import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f441270a = 0;

    public static a a(ai aiVar) {
        a aVar = new a();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SuspiciousTroopConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            try {
                String str = aiVar.f202268b;
                if (str == null) {
                    str = "";
                }
                aVar.f441270a = new JSONObject(str).optInt("suspiciousSwitch", 0);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SuspiciousTroopConfBean", 2, "parse error->" + e16.toString());
                }
            }
        }
        return aVar;
    }
}
