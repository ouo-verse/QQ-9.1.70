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
public class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f435656a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f435657b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f435658c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f435659d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f435660e = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f435661f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f435662g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f435663h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f435664i = "";

    /* renamed from: j, reason: collision with root package name */
    private Map<String, String> f435665j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private Map<String, a> f435666k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private Map<String, String> f435667l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private SparseArray<a> f435668m = new SparseArray<>();

    /* renamed from: n, reason: collision with root package name */
    private List<b> f435669n = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String[] f435670a;

        /* renamed from: b, reason: collision with root package name */
        public String f435671b;

        /* renamed from: c, reason: collision with root package name */
        public String f435672c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f435673d;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f435674a;

        /* renamed from: b, reason: collision with root package name */
        public int f435675b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f435676c;
    }

    public static g g(ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            boolean z16 = false;
            String str = aiVarArr[0].f202268b;
            g gVar = new g();
            if (TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TencentDocDataLineTipsConfigBean", 2, "updateConfig json parse faild");
                }
                return gVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("File");
                gVar.f435657b = optJSONObject.optInt("maxCount");
                gVar.f435658c = optJSONObject.optInt("insertDur");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(TagName.FILE_TYPE);
                StringBuilder sb5 = new StringBuilder();
                Iterator keys = optJSONObject2.keys();
                StringBuilder sb6 = new StringBuilder();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    sb5.append(str2);
                    sb5.append("|");
                    String string = optJSONObject2.getString(str2);
                    gVar.f435665j.put("fileType_" + str2, string);
                    sb6.append(string);
                    sb6.append("|");
                    a aVar = new a();
                    aVar.f435673d = k(string);
                    gVar.f435666k.put(str2, aVar);
                }
                if (sb6.length() > 0) {
                    sb6.deleteCharAt(sb6.length() - 1);
                }
                if (sb5.length() > 0) {
                    sb5.deleteCharAt(sb5.length() - 1);
                }
                gVar.f435661f = sb5.toString();
                gVar.f435662g = sb6.toString();
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("KeyWords");
                for (String str3 : gVar.f435666k.keySet()) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject(str3);
                    a aVar2 = gVar.f435666k.get(str3);
                    String optString = optJSONObject4.optString("key");
                    aVar2.f435670a = k(optString);
                    if (gVar.f435659d == 1) {
                        aVar2.f435671b = optJSONObject4.optString("Tips1");
                        aVar2.f435672c = optJSONObject4.optString("Link1");
                    } else {
                        aVar2.f435671b = optJSONObject4.optString("Tips0");
                        aVar2.f435672c = optJSONObject4.optString("Link0");
                    }
                    gVar.f435666k.put(str3, aVar2);
                    gVar.f435667l.put("key_str_key_words" + str3, optString);
                    gVar.f435667l.put("key_str_key_tips" + str3, aVar2.f435671b);
                    gVar.f435667l.put("key_str_key_link" + str3, aVar2.f435672c);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("Text");
                if (optJSONObject5 != null) {
                    gVar.f435663h = optJSONObject5.toString();
                    if (optJSONObject5.optInt("textSwitch", 0) == 1) {
                        z16 = true;
                    }
                    gVar.f435656a = z16;
                    i(optJSONObject5, gVar);
                }
            } catch (Exception e16) {
                QLog.e("TencentDocDataLineTipsConfigBean", 2, e16.toString());
                e16.printStackTrace();
            }
            return gVar;
        }
        return null;
    }

    private static void i(JSONObject jSONObject, g gVar) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("template_list");
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            int optInt = optJSONArray.getJSONObject(i3).optInt("template_type", -1);
            a aVar = new a();
            int optInt2 = jSONObject.optInt("containKeyword");
            gVar.f435660e = optInt2;
            if (optInt2 == 1) {
                aVar.f435671b = jSONObject.optString("Tips1");
                aVar.f435672c = jSONObject.optString("Link1");
            } else {
                aVar.f435671b = jSONObject.optString("Tips0");
                aVar.f435672c = jSONObject.optString("Link0");
            }
            if (optInt == -1) {
                optInt = i3;
            }
            gVar.f435668m.put(optInt, aVar);
        }
    }

    private static String[] k(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        int i3 = 0;
        if (!stringTokenizer.hasMoreTokens()) {
            if (QLog.isColorLevel()) {
                QLog.i("TencentDocDataLineTipsConfigBean", 1, "split String faild :" + str);
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

    public Map<String, a> a() {
        return this.f435666k;
    }

    public int b() {
        return this.f435658c;
    }

    public int c() {
        return this.f435657b;
    }

    public String d() {
        return this.f435662g;
    }

    public List<b> e() {
        return this.f435669n;
    }

    public String f() {
        return this.f435663h;
    }

    public void h(JSONObject jSONObject) {
        String jSONObject2;
        if (jSONObject == null) {
            jSONObject2 = "";
        } else {
            jSONObject2 = jSONObject.toString();
        }
        this.f435664i = jSONObject2;
        if (jSONObject == null) {
            this.f435656a = false;
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("template_list");
            if (jSONObject.optInt("retcode", -1) != 0) {
                this.f435656a = false;
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
                            bVar.f435674a = jSONObject4.optString("template_name");
                            int optInt2 = jSONObject4.optInt("template_id", -1);
                            bVar.f435675b = optInt2;
                            if (optInt2 == -1) {
                                QLog.d("TencentDocDataLineTipsConfigBean", 2, "template has no id");
                            }
                            bVar.f435676c = optInt;
                            this.f435669n.add(bVar);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("TencentDocDataLineTipsConfigBean", 2, e16.toString());
        }
    }

    public void j(boolean z16) {
        this.f435656a = z16;
    }
}
