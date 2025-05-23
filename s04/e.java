package s04;

import android.text.TextUtils;
import com.tencent.rmonitor.custom.IUserDataEditor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements IUserDataEditor {

    /* renamed from: b, reason: collision with root package name */
    private final int f433069b;

    /* renamed from: c, reason: collision with root package name */
    private final int f433070c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f433071d = new ConcurrentHashMap<>(10);

    public e(int i3, int i16) {
        this.f433069b = i3;
        this.f433070c = i16;
    }

    private boolean b(String str) {
        if (str != null && !str.isEmpty() && str.length() <= this.f433069b) {
            return false;
        }
        return true;
    }

    public boolean a() {
        return this.f433071d.isEmpty();
    }

    public void c(e eVar) {
        if (eVar != null && eVar != this) {
            this.f433071d.putAll(eVar.f433071d);
        }
    }

    public String d(String str) {
        if (!b(str) && this.f433071d.containsKey(str)) {
            return this.f433071d.remove(str);
        }
        return null;
    }

    public JSONObject e() throws JSONException {
        if (!this.f433071d.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : this.f433071d.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    jSONObject.put(key, value);
                }
            }
            return jSONObject;
        }
        return null;
    }

    @Override // com.tencent.rmonitor.custom.IUserDataEditor
    public String getUserData(String str) {
        if (!b(str) && this.f433071d.containsKey(str)) {
            return this.f433071d.get(str);
        }
        return null;
    }

    @Override // com.tencent.rmonitor.custom.IUserDataEditor
    public boolean putUserData(String str, String str2) {
        if (b(str)) {
            return false;
        }
        if (!this.f433071d.containsKey(str) && this.f433071d.size() >= this.f433070c) {
            return false;
        }
        this.f433071d.put(str, a.a(str2));
        return true;
    }
}
