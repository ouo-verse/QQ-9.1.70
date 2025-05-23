package vr3;

import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f443242a;

    /* renamed from: b, reason: collision with root package name */
    public String f443243b;

    /* renamed from: c, reason: collision with root package name */
    public String f443244c;

    /* renamed from: d, reason: collision with root package name */
    public String f443245d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f443246e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f443247f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f443248g;

    /* renamed from: i, reason: collision with root package name */
    public int f443250i;

    /* renamed from: j, reason: collision with root package name */
    public long f443251j;

    /* renamed from: k, reason: collision with root package name */
    public long f443252k;

    /* renamed from: l, reason: collision with root package name */
    public long f443253l;

    /* renamed from: m, reason: collision with root package name */
    public long f443254m;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.qmethod.pandoraex.api.c f443255n;

    /* renamed from: o, reason: collision with root package name */
    public String[] f443256o;

    /* renamed from: p, reason: collision with root package name */
    public List<t> f443257p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f443259r;

    /* renamed from: s, reason: collision with root package name */
    public List<String> f443260s;

    /* renamed from: u, reason: collision with root package name */
    public LinkedHashSet<yr3.c> f443262u;

    /* renamed from: v, reason: collision with root package name */
    public JSONObject f443263v;

    /* renamed from: w, reason: collision with root package name */
    public JSONObject f443264w;

    /* renamed from: h, reason: collision with root package name */
    public boolean f443249h = false;

    /* renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f443258q = new ConcurrentHashMap<>(2);

    /* renamed from: t, reason: collision with root package name */
    public int f443261t = 100;

    /* renamed from: x, reason: collision with root package name */
    public int f443265x = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f443266y = 0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        private boolean f443269c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f443270d;

        /* renamed from: a, reason: collision with root package name */
        private String f443267a = null;

        /* renamed from: b, reason: collision with root package name */
        private String f443268b = null;

        /* renamed from: e, reason: collision with root package name */
        public final List<t> f443271e = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        private int f443272f = 0;

        /* renamed from: g, reason: collision with root package name */
        private boolean f443273g = false;

        /* renamed from: h, reason: collision with root package name */
        private final HashMap<String, String> f443274h = new HashMap<>(2);

        /* renamed from: i, reason: collision with root package name */
        private String[] f443275i = null;

        public b a() {
            b bVar = new b();
            bVar.f443242a = this.f443267a;
            bVar.f443243b = this.f443268b;
            bVar.f443247f = this.f443269c;
            bVar.f443248g = this.f443270d;
            bVar.f443257p = this.f443271e;
            bVar.f443250i = this.f443272f;
            bVar.f443246e = this.f443273g;
            bVar.f443258q.putAll(this.f443274h);
            bVar.f443256o = this.f443275i;
            return bVar;
        }

        public a b(int i3) {
            this.f443272f = i3;
            return this;
        }

        public a c(String[] strArr) {
            this.f443275i = strArr;
            return this;
        }

        public a d(HashMap<String, String> hashMap) {
            this.f443274h.clear();
            if (hashMap != null) {
                this.f443274h.putAll(hashMap);
            }
            return this;
        }

        public a e(boolean z16) {
            this.f443270d = z16;
            return this;
        }

        public a f(boolean z16) {
            this.f443269c = z16;
            return this;
        }

        public a g(String str) {
            this.f443267a = str;
            return this;
        }

        public a h(String str) {
            this.f443268b = str;
            return this;
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                jSONObject2.put(str, jSONObject.get(str));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return jSONObject2;
    }

    public static b b(b bVar) {
        b bVar2 = new b();
        bVar2.f443242a = bVar.f443242a;
        bVar2.f443243b = bVar.f443243b;
        bVar2.f443244c = bVar.f443244c;
        bVar2.f443245d = bVar.f443245d;
        bVar2.f443246e = bVar.f443246e;
        bVar2.f443247f = bVar.f443247f;
        bVar2.f443248g = bVar.f443248g;
        bVar2.f443249h = bVar.f443249h;
        bVar2.f443250i = bVar.f443250i;
        bVar2.f443251j = bVar.f443251j;
        bVar2.f443252k = bVar.f443252k;
        bVar2.f443253l = bVar.f443253l;
        bVar2.f443254m = bVar.f443254m;
        String[] strArr = bVar.f443256o;
        if (strArr != null) {
            bVar2.f443256o = new String[strArr.length];
            int i3 = 0;
            while (true) {
                String[] strArr2 = bVar.f443256o;
                if (i3 >= strArr2.length) {
                    break;
                }
                bVar2.f443256o[i3] = strArr2[i3];
                i3++;
            }
        }
        bVar2.f443258q.putAll(bVar.f443258q);
        com.tencent.qmethod.pandoraex.api.c cVar = bVar.f443255n;
        if (cVar != null) {
            bVar2.f443255n = new com.tencent.qmethod.pandoraex.api.c(cVar.f343898c, cVar.f343897b, cVar.f343899d);
        }
        bVar2.f443257p = bVar.f443257p;
        bVar2.f443262u = bVar.f443262u;
        bVar2.f443260s = bVar.f443260s;
        bVar2.f443266y = bVar.f443266y;
        bVar2.f443261t = bVar.f443261t;
        bVar2.f443265x = bVar.f443265x;
        return bVar2;
    }

    public JSONObject c() {
        boolean z16;
        JSONObject a16 = a(this.f443263v);
        try {
            JSONObject jSONObject = this.f443264w;
            if (jSONObject != null && jSONObject.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((this.f443263v.length() > 0 || z16) && z16) {
                a16.put("_ForApi", this.f443264w);
            }
        } catch (Throwable th5) {
            o.b("PandoraEx", "getExtInfo", th5);
        }
        return a16;
    }

    public boolean d() {
        return "back".equals(this.f443244c);
    }

    public boolean e() {
        if (this.f443261t < 100) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ReportItem{module[");
        sb5.append(this.f443242a);
        sb5.append("], systemApi[");
        sb5.append(this.f443243b);
        sb5.append("], scene[");
        sb5.append(this.f443244c);
        sb5.append("], strategy[");
        sb5.append(this.f443245d);
        sb5.append("], currentPages[");
        sb5.append(Arrays.toString(this.f443256o));
        sb5.append("], isSystemCall[");
        sb5.append(this.f443246e);
        sb5.append("], isAppForeground[");
        sb5.append(this.f443247f);
        sb5.append("], isAgreed[");
        sb5.append(this.f443248g);
        sb5.append("], isNeedReport[");
        sb5.append(this.f443249h);
        sb5.append("], count[");
        sb5.append(this.f443250i);
        sb5.append("], cacheTime[");
        sb5.append(this.f443251j);
        sb5.append("], silenceTime[");
        sb5.append(this.f443252k);
        sb5.append("], actualSilenceTime[");
        sb5.append(this.f443253l);
        sb5.append("], backgroundTime[");
        sb5.append(this.f443254m);
        sb5.append("], configHighFrequency[");
        sb5.append(this.f443255n);
        sb5.append("], extraParam[");
        sb5.append(this.f443258q);
        sb5.append("], reportStackItems[");
        sb5.append(this.f443257p);
        sb5.append("], moduleStack[");
        sb5.append(this.f443262u);
        sb5.append("]");
        if (this.f443259r) {
            str = " qnjni ";
        } else {
            str = " qnnoJni ";
        }
        sb5.append(str);
        sb5.append("}");
        return sb5.toString();
    }
}
