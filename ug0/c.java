package ug0;

import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u00a8\u0006\n"}, d2 = {"Lug0/c;", "", "", "", "parameters", "", "b", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f438934a = new c();

    c() {
    }

    public final Map<String, String> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String string = ECLocalConfig.f100650f.getString("scheme_parameter", "{}", Boolean.TRUE);
        try {
            JSONObject jSONObject = new JSONObject(string);
            JSONArray names = jSONObject.names();
            if (names != null) {
                int length = names.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = names.optString(i3);
                    linkedHashMap.put(optString, jSONObject.getString(optString));
                }
            }
        } catch (JSONException unused) {
            cg0.a.b("ECSchemeParameterConfig", "[getSchemeParameterFromLocal] convert json to map error, content = " + string);
        }
        return linkedHashMap;
    }

    public final void b(Map<String, String> parameters) {
        try {
            String jSONObject = new JSONObject(parameters).toString();
            cg0.a.b("ECSchemeParameterConfig", "[saveSchemeParameterToLocal] parameters = " + parameters + ", content = " + jSONObject);
            ECLocalConfig.f100650f.setString("scheme_parameter", jSONObject, Boolean.TRUE);
        } catch (JSONException unused) {
            cg0.a.a("ECSchemeParameterConfig", "saveSchemeParameterToLocal", "convert parameters to json error, parameters = " + parameters);
        }
    }
}
