package z15;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f451777a = Logger.getLogger(a.class.getName());

    a() {
    }

    private static boolean a(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    if (jSONArray.isNull(i3)) {
                        obj2 = null;
                    } else {
                        obj2 = jSONArray.get(i3);
                    }
                    if (a(obj2)) {
                        return true;
                    }
                } catch (JSONException e16) {
                    f451777a.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e16);
                    return false;
                }
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    if (a(jSONObject.get((String) keys.next()))) {
                        return true;
                    }
                } catch (JSONException e17) {
                    f451777a.log(Level.WARNING, "An error occured while retrieving data from JSONObject", (Throwable) e17);
                }
            }
        }
        return false;
    }

    public static boolean b(Object obj) {
        return a(obj);
    }
}
