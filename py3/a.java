package py3;

import android.os.Environment;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements IConfigData {

    /* renamed from: i, reason: collision with root package name */
    public static String f428067i = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f428068d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f428069e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f428070f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f428071h;

    public static a a(String str) {
        a aVar;
        QLog.d("ExternFileMonitorConfigBean", 1, "ExternalDirOperationConfig fromJson content: " + str);
        try {
            aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            aVar.f428069e = jSONObject.optBoolean(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, false);
            aVar.f428070f = jSONObject.optBoolean("open_file_switch", false);
            JSONArray optJSONArray = jSONObject.optJSONArray("exclude_path");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    aVar.f428068d.add(f428067i + ((String) optJSONArray.get(i3)));
                }
            }
            aVar.f428071h = jSONObject.optBoolean("new_report", false);
        } catch (Exception e16) {
            QLog.e("ExternFileMonitorConfigBean", 1, e16, new Object[0]);
            aVar = null;
        }
        if (aVar == null) {
            aVar = new a();
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExternFileMonitorConfigBean", 1, aVar);
        }
        return aVar;
    }

    public String toString() {
        return "ExternFileMonitorConfigBean{hookSwitch=" + this.f428069e + ", openFileHookSwitch=" + this.f428070f + ", newReport=" + this.f428071h + '}';
    }
}
