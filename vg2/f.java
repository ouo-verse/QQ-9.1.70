package vg2;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public int f441618a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f441619b = "";

    /* renamed from: c, reason: collision with root package name */
    public int f441620c = 0;

    public static String a(ArrayList<f> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                f fVar = arrayList.get(i3);
                if (fVar != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tagId", fVar.f441618a);
                        jSONObject.put("tagName", fVar.f441619b);
                        jSONObject.put("isHotTag", fVar.f441620c);
                        jSONArray.mo162put(jSONObject);
                    } catch (Exception e16) {
                        QLog.e("TagInfo CLASS", 2, "convertToJson error" + e16.toString());
                    }
                }
            }
            return jSONArray.toString();
        }
        return "";
    }

    public String toString() {
        return "{tagId: " + this.f441618a + "}{tagName: " + this.f441619b + "}{isHotTag: " + this.f441620c + "}";
    }
}
