package sa1;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, a> f433573d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    boolean f433574e;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f433575a;

        /* renamed from: b, reason: collision with root package name */
        public String f433576b;

        /* renamed from: c, reason: collision with root package name */
        public String f433577c;

        /* renamed from: d, reason: collision with root package name */
        public String f433578d;
    }

    private static void a(c cVar, String str) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.f433574e = true;
            if (jSONObject.has("emoji") && (optJSONObject2 = jSONObject.optJSONObject("emoji")) != null) {
                a aVar = new a();
                aVar.f433575a = optJSONObject2.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, 0);
                aVar.f433576b = optJSONObject2.optString("iconUrl", "");
                aVar.f433577c = optJSONObject2.optString("url", "");
                cVar.f433573d.put("emoji", aVar);
            }
            if (jSONObject.has("heihua") && (optJSONObject = jSONObject.optJSONObject("heihua")) != null) {
                a aVar2 = new a();
                aVar2.f433575a = optJSONObject.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, 0);
                aVar2.f433576b = optJSONObject.optString("iconUrl", "");
                aVar2.f433577c = optJSONObject.optString("url", "");
                aVar2.f433578d = optJSONObject.optString("name", "");
                cVar.f433573d.put("heihua", aVar2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("VerticalNavigationConfBean", 2, "parse error->" + e16);
            }
        }
    }

    public static c g(ai aiVar) {
        c cVar = new c();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            a(cVar, aiVar.f202268b);
        }
        return cVar;
    }

    public static c h(String str) {
        c cVar = new c();
        a(cVar, str);
        return cVar;
    }

    public String b(String str) {
        a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f433573d.get(str)) == null) {
            return "";
        }
        return aVar.f433576b;
    }

    public String c(String str) {
        a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f433573d.get(str)) == null) {
            return "";
        }
        return aVar.f433578d;
    }

    public String d(String str) {
        a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f433573d.get(str)) == null) {
            return "";
        }
        return aVar.f433577c;
    }

    public boolean e(String str) {
        a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f433573d.get(str)) == null || aVar.f433575a != 1) {
            return false;
        }
        return true;
    }

    public boolean f() {
        return this.f433574e;
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[1];
        HashMap<String, a> hashMap = this.f433573d;
        if (hashMap != null) {
            str = hashMap.toString();
        } else {
            str = "null";
        }
        objArr[0] = str;
        return String.format("mConfigData:%s ", objArr);
    }
}
