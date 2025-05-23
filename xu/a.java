package xu;

import android.text.TextUtils;
import com.tencent.av.utils.af;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import wu.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final int f448684a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, Boolean> f448685b = new ConcurrentHashMap<>();

    public a(int i3) {
        this.f448684a = i3;
    }

    private void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("manufacture")) {
                int i3 = jSONObject.getInt("manufacture");
                this.f448685b.put(1, Boolean.valueOf((i3 & 1) != 0));
                this.f448685b.put(2, Boolean.valueOf((i3 & 2) != 0));
            }
        } catch (JSONException unused) {
            QLog.d("NetworkConfigurationApiImpl", 1, "updateConfigFromJson fail");
        }
    }

    @Override // wu.b
    public boolean a() {
        if (this.f448685b.containsKey(Integer.valueOf(this.f448684a))) {
            return this.f448685b.get(Integer.valueOf(this.f448684a)).booleanValue();
        }
        return false;
    }

    @Override // wu.b
    public void b() {
        String p16 = af.p();
        if (TextUtils.isEmpty(p16)) {
            return;
        }
        c(p16);
    }
}
