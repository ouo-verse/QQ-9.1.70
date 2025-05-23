package yr3;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import yr3.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {

    /* renamed from: p, reason: collision with root package name */
    private static e f451071p = new e();

    /* renamed from: h, reason: collision with root package name */
    private Context f451079h;

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, ConcurrentHashMap<String, ArrayList<String>>> f451072a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f451073b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, List<Pair<String, String>>> f451074c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f451075d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, c> f451076e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private LinkedHashSet<c> f451077f = new LinkedHashSet<>();

    /* renamed from: g, reason: collision with root package name */
    private LinkedHashSet<String> f451078g = new LinkedHashSet<>();

    /* renamed from: i, reason: collision with root package name */
    private Map<String, List<String>> f451080i = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Long> f451081j = new ConcurrentHashMap();

    /* renamed from: k, reason: collision with root package name */
    private List<a> f451082k = new CopyOnWriteArrayList();

    /* renamed from: l, reason: collision with root package name */
    public int f451083l = 2;

    /* renamed from: m, reason: collision with root package name */
    private String f451084m = "";

    /* renamed from: n, reason: collision with root package name */
    private String f451085n = "";

    /* renamed from: o, reason: collision with root package name */
    private String f451086o = "";

    public static e c() {
        return f451071p;
    }

    private void t(String str, b bVar) {
        if (!q.m()) {
            return;
        }
        TextUtils.isEmpty(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> a(String str, String str2) {
        List<String> n3 = n(str, 0L);
        if (!n3.contains(str2)) {
            n3.add(str2);
            r(str, n3);
        }
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(c cVar) {
        LinkedHashSet<c> linkedHashSet = new LinkedHashSet<>(this.f451077f);
        linkedHashSet.remove(cVar);
        linkedHashSet.add(cVar);
        this.f451077f = linkedHashSet;
    }

    public c d(String str) {
        return this.f451076e.get(e(str));
    }

    public int f(String str) {
        Integer num = this.f451075d.get(str);
        if (num == null) {
            return Math.min(this.f451083l, 0);
        }
        return num.intValue();
    }

    public List<String> g(String str, String str2) {
        ArrayList<String> arrayList;
        ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap = this.f451072a.get(str);
        if (concurrentHashMap != null && (arrayList = concurrentHashMap.get(str2)) != null) {
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    public LinkedHashSet<c> h() {
        return this.f451077f;
    }

    public String i() {
        return this.f451086o;
    }

    public void j(Context context) {
        this.f451079h = context;
        t(this.f451084m, null);
        if (q.m() && !TextUtils.isEmpty(this.f451085n)) {
            Toast.makeText(q.b(), this.f451085n, 1).show();
        }
    }

    public synchronized c k(String str, String str2, boolean z16, c.a aVar, ArrayList<String> arrayList, int i3, ArrayList<Integer> arrayList2) {
        c cVar;
        String e16 = e(str);
        if (this.f451076e.get(e16) == null) {
            cVar = new c(str, str2, z16, aVar, arrayList, i3, arrayList2);
            this.f451076e.put(e16, cVar);
        } else {
            throw new IllegalStateException("ReDefine module " + str);
        }
        return cVar;
    }

    public boolean l() {
        return !this.f451076e.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> m(String str) {
        return n(str, 500L);
    }

    List<String> n(String str, long j3) {
        if (this.f451080i.containsKey(str) && this.f451081j.containsKey(str)) {
            if (System.currentTimeMillis() - this.f451081j.get(str).longValue() <= j3) {
                return this.f451080i.get(str);
            }
            this.f451080i.remove(str);
            this.f451081j.remove(str);
        }
        List<String> f16 = r.f(this.f451079h, str, String.class);
        this.f451080i.put(str, f16);
        this.f451081j.put(str, Long.valueOf(System.currentTimeMillis()));
        return f16;
    }

    public void o(int i3, String str, String str2, List<String> list, LinkedHashSet<c> linkedHashSet) {
        Iterator<a> it = this.f451082k.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(i3, str, str2, list, linkedHashSet);
            } catch (Exception e16) {
                o.d("SplitModules", "onApiCallBanByPermission", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> p(String str, String str2) {
        List<String> n3 = n(str, 0L);
        if (n3.contains(str2)) {
            n3.remove(str2);
            r(str, n3);
        }
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void q(c cVar) {
        LinkedHashSet<c> linkedHashSet = new LinkedHashSet<>(this.f451077f);
        linkedHashSet.remove(cVar);
        this.f451077f = linkedHashSet;
    }

    void r(String str, List<String> list) {
        r.r(this.f451079h, str, list, List.class);
    }

    public void s(String str, int i3) {
        this.f451075d.put(str, Integer.valueOf(i3));
    }

    public static String e(String str) {
        return str;
    }
}
