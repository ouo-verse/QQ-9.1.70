package uq3;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f439802a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Pair<List<String>, List<String>>> f439803b = new ConcurrentHashMap();

    public static Map<String, Pair<List<String>, List<String>>> a() {
        try {
            String E2 = c.E2("rfw_ip_config", "");
            if (!TextUtils.isEmpty(E2) && E2.hashCode() != f439802a.get()) {
                QLog.d("QCircleDirectIPUtils", 1, "[getNewConfigIpList] ipStrategyVal: " + E2);
                Map<String, Pair<List<String>, List<String>>> map = f439803b;
                map.clear();
                JSONArray jSONArray = new JSONArray(E2);
                if (jSONArray.length() <= 0) {
                    QLog.d("QCircleDirectIPUtils", 1, "[getNewConfigIpList] ip list length <= 0.");
                    return map;
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = new JSONObject(jSONArray.get(i3).toString());
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("ipList");
                    String obj = jSONObject.get("host").toString();
                    for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                        arrayList.add(jSONArray2.get(i16).toString());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray jSONArray3 = jSONObject.getJSONArray("portList");
                    for (int i17 = 0; i17 < jSONArray3.length(); i17++) {
                        arrayList2.add(jSONArray3.get(i17).toString());
                    }
                    f439803b.put(obj, new Pair<>(arrayList, arrayList2));
                }
                f439802a.set(E2.hashCode());
                return f439803b;
            }
            return f439803b;
        } catch (Throwable th5) {
            QLog.e("QCircleDirectIPUtils", 1, "[getNewConfigIpList] e: " + th5);
            return f439803b;
        }
    }
}
