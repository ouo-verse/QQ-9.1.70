package ta1;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private boolean f435727a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f435728b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f435729c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f435730d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f435731e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f435732f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f435733g = 0;

    /* renamed from: h, reason: collision with root package name */
    private double f435734h = 0.0d;

    /* renamed from: i, reason: collision with root package name */
    private String f435735i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f435736j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f435737k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f435738l = "";

    /* renamed from: m, reason: collision with root package name */
    private String f435739m = "";

    /* renamed from: n, reason: collision with root package name */
    private String f435740n = "";

    /* renamed from: o, reason: collision with root package name */
    private Map<String, String> f435741o = new HashMap();

    /* renamed from: p, reason: collision with root package name */
    private Map<String, a> f435742p = new HashMap();

    /* renamed from: q, reason: collision with root package name */
    private Map<String, String> f435743q = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private SparseArray<a> f435744r = new SparseArray<>();

    /* renamed from: s, reason: collision with root package name */
    private List<b> f435745s = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String[] f435746a;

        /* renamed from: b, reason: collision with root package name */
        public String f435747b;

        /* renamed from: c, reason: collision with root package name */
        public String f435748c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f435749d;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f435750a;

        /* renamed from: b, reason: collision with root package name */
        public int f435751b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f435752c;
    }

    public static q m(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            boolean z16 = false;
            String str = aiVarArr[0].f202268b;
            q qVar = new q();
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TencentDocTipsConfigBean", 2, "updateConfig json parse faild");
                }
                return qVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("File");
                qVar.f435728b = optJSONObject.optInt("maxCount");
                qVar.f435729c = optJSONObject.optInt("insertDur");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(TagName.FILE_TYPE);
                StringBuilder sb5 = new StringBuilder();
                Iterator keys = optJSONObject2.keys();
                StringBuilder sb6 = new StringBuilder();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    sb5.append(str2);
                    sb5.append("|");
                    String string = optJSONObject2.getString(str2);
                    qVar.f435741o.put("fileType_" + str2, string);
                    sb6.append(string);
                    sb6.append("|");
                    a aVar = new a();
                    aVar.f435749d = q(string);
                    qVar.f435742p.put(str2, aVar);
                }
                if (sb6.length() > 0) {
                    sb6.deleteCharAt(sb6.length() - 1);
                }
                if (sb5.length() > 0) {
                    sb5.deleteCharAt(sb5.length() - 1);
                }
                qVar.f435737k = sb5.toString();
                qVar.f435738l = sb6.toString();
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("Similarity");
                qVar.f435730d = optJSONObject3.optInt("durTime");
                qVar.f435731e = optJSONObject3.optInt("maxQuery");
                qVar.f435734h = optJSONObject3.getDouble("Percentage");
                qVar.f435735i = optJSONObject3.optString("Tips");
                qVar.f435736j = optJSONObject3.optString("Link");
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("KeyWords");
                for (String str3 : qVar.f435742p.keySet()) {
                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject(str3);
                    a aVar2 = qVar.f435742p.get(str3);
                    String optString = optJSONObject5.optString("key");
                    aVar2.f435746a = q(optString);
                    if (qVar.f435732f == 1) {
                        aVar2.f435747b = optJSONObject5.optString("Tips1");
                        aVar2.f435748c = optJSONObject5.optString("Link1");
                    } else {
                        aVar2.f435747b = optJSONObject5.optString("Tips0");
                        aVar2.f435748c = optJSONObject5.optString("Link0");
                    }
                    qVar.f435742p.put(str3, aVar2);
                    qVar.f435743q.put("key_str_key_words" + str3, optString);
                    qVar.f435743q.put("key_str_key_tips" + str3, aVar2.f435747b);
                    qVar.f435743q.put("key_str_key_link" + str3, aVar2.f435748c);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("Text");
                if (optJSONObject6 != null) {
                    qVar.f435739m = optJSONObject6.toString();
                    if (optJSONObject6.optInt("textSwitch", 0) == 1) {
                        z16 = true;
                    }
                    qVar.f435727a = z16;
                    o(optJSONObject6, qVar);
                }
            } catch (Exception e16) {
                QLog.e("TencentDocTipsConfigBean", 2, e16.toString());
                e16.printStackTrace();
            }
            return qVar;
        }
        return null;
    }

    private static void o(JSONObject jSONObject, q qVar) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("template_list");
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            int optInt = optJSONArray.getJSONObject(i3).optInt("template_type", -1);
            a aVar = new a();
            int optInt2 = jSONObject.optInt("containKeyword");
            qVar.f435733g = optInt2;
            if (optInt2 == 1) {
                aVar.f435747b = jSONObject.optString("Tips1");
                aVar.f435748c = jSONObject.optString("Link1");
            } else {
                aVar.f435747b = jSONObject.optString("Tips0");
                aVar.f435748c = jSONObject.optString("Link0");
            }
            if (optInt == -1) {
                optInt = i3;
            }
            qVar.f435744r.put(optInt, aVar);
        }
    }

    private static String[] q(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        int i3 = 0;
        if (!stringTokenizer.hasMoreTokens()) {
            if (QLog.isColorLevel()) {
                QLog.i("TencentDocTipsConfigBean", 1, "split String faild :" + str);
            }
            return new String[0];
        }
        String[] strArr = new String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i3] = stringTokenizer.nextToken();
            i3++;
        }
        return strArr;
    }

    public int a() {
        return this.f435730d;
    }

    public Map<String, a> b() {
        return this.f435742p;
    }

    public int c() {
        return this.f435729c;
    }

    public int d() {
        return this.f435728b;
    }

    public double e() {
        return this.f435734h;
    }

    public String f() {
        return this.f435735i;
    }

    public String g() {
        return this.f435736j;
    }

    public String h() {
        return this.f435738l;
    }

    public List<b> i() {
        return this.f435745s;
    }

    public SparseArray<a> j() {
        return this.f435744r;
    }

    public String k() {
        return this.f435739m;
    }

    public boolean l() {
        return this.f435727a;
    }

    public void n(JSONObject jSONObject) {
        String jSONObject2;
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        this.f435740n = jSONObject2;
        if (jSONObject == null) {
            this.f435727a = false;
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("template_list");
            if (jSONObject.optInt("retcode", -1) != 0) {
                this.f435727a = false;
                return;
            }
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i3);
                    int optInt = jSONObject3.optInt("template_type", -1);
                    if (jSONObject3.optJSONArray("infos") != null) {
                        JSONArray optJSONArray2 = jSONObject3.optJSONArray("infos");
                        for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            JSONObject jSONObject4 = optJSONArray2.getJSONObject(i16);
                            b bVar = new b();
                            bVar.f435750a = jSONObject4.optString("template_name");
                            int optInt2 = jSONObject4.optInt("template_id", -1);
                            bVar.f435751b = optInt2;
                            if (optInt2 == -1) {
                                QLog.d("TencentDocTipsConfigBean", 2, "template has no id");
                            }
                            bVar.f435752c = optInt;
                            this.f435745s.add(bVar);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("TencentDocTipsConfigBean", 2, e16.toString());
        }
    }

    public void p(boolean z16) {
        this.f435727a = z16;
    }
}
