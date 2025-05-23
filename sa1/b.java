package sa1;

import android.support.v4.util.ArrayMap;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements IConfigData {
    boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f433561d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f433562e = 1;

    /* renamed from: f, reason: collision with root package name */
    private int f433563f = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f433564h = 1;

    /* renamed from: i, reason: collision with root package name */
    private int f433565i = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f433566m = 1;
    private ArrayMap<String, ArrayList<a>> D = new ArrayMap<>(5);

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f433567a;

        /* renamed from: b, reason: collision with root package name */
        public String f433568b;

        /* renamed from: c, reason: collision with root package name */
        public String f433569c;

        /* renamed from: d, reason: collision with root package name */
        public String f433570d;

        /* renamed from: e, reason: collision with root package name */
        public String f433571e;

        /* renamed from: f, reason: collision with root package name */
        public String f433572f;
    }

    private static void a(b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.C = true;
            int optInt = jSONObject.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, 0);
            int optInt2 = jSONObject.optInt("ftsEnableMsgSwitch", 1);
            int optInt3 = jSONObject.optInt("showMessageResult", 1);
            int optInt4 = jSONObject.optInt("ftsEnableSwitch", 1);
            int optInt5 = jSONObject.optInt("ftsEnableTroopSwitch", 1);
            int optInt6 = jSONObject.optInt("ftsEnableFtsFilter", 1);
            bVar.i(optInt);
            bVar.h(optInt2);
            bVar.j(optInt3);
            bVar.f433563f = optInt4;
            bVar.f433565i = optInt5;
            bVar.f433566m = optInt6;
            JSONArray optJSONArray = jSONObject.optJSONArray("templateinfo");
            if (optJSONArray != null) {
                ArrayList<a> arrayList = new ArrayList<>(10);
                ArrayList<a> arrayList2 = new ArrayList<>(10);
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.f433567a = optJSONObject.optInt("templateid");
                        aVar.f433568b = optJSONObject.optString("templatetype");
                        aVar.f433570d = optJSONObject.optString("templatever");
                        aVar.f433569c = optJSONObject.optString("templatename");
                        aVar.f433571e = optJSONObject.optString("templateview");
                        aVar.f433572f = optJSONObject.optString("templatebizsrc");
                        if ("ark".equals(aVar.f433568b)) {
                            arrayList.add(aVar);
                        } else if ("native".equals(aVar.f433568b)) {
                            arrayList2.add(aVar);
                        }
                    }
                }
                bVar.k("ark", arrayList);
                bVar.k("native", arrayList2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchRichConfBean", 2, "parse error->" + e16);
            }
        }
    }

    @Deprecated
    public static b f(ai aiVar) {
        b bVar = new b();
        if (aiVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SearchRichConfBean", 2, "parse taskid->" + aiVar.f202267a + " content->" + aiVar.f202268b);
            }
            a(bVar, aiVar.f202268b);
        }
        return bVar;
    }

    public static b g(String str) {
        b bVar = new b();
        a(bVar, str);
        return bVar;
    }

    public ArrayList<a> b(String str) {
        ArrayMap<String, ArrayList<a>> arrayMap = this.D;
        if (arrayMap != null) {
            return arrayMap.get(str);
        }
        return null;
    }

    public boolean c() {
        if (this.f433565i == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f433561d == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        return this.C;
    }

    void h(int i3) {
        this.f433564h = i3;
    }

    void i(int i3) {
        this.f433561d = i3;
    }

    void j(int i3) {
        this.f433562e = i3;
    }

    void k(String str, ArrayList<a> arrayList) {
        ArrayMap<String, ArrayList<a>> arrayMap = this.D;
        if (arrayMap != null && str != null) {
            arrayMap.put(str, arrayList);
        }
    }

    public String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.f433561d);
        ArrayMap<String, ArrayList<a>> arrayMap = this.D;
        if (arrayMap != null) {
            str = arrayMap.toString();
        } else {
            str = "null";
        }
        objArr[1] = str;
        return String.format("mRichSwitch:%d  templateData:%s", objArr);
    }
}
