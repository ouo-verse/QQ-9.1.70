package yr3;

import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c extends d {

    /* renamed from: c, reason: collision with root package name */
    public AtomicInteger f451061c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<String> f451062d;

    /* renamed from: e, reason: collision with root package name */
    final ConcurrentHashMap<String, f> f451063e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedHashSet<f> f451064f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f451065g;

    /* renamed from: h, reason: collision with root package name */
    String f451066h;

    /* renamed from: i, reason: collision with root package name */
    public int f451067i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<Integer> f451068j;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
    }

    public c(String str, String str2, boolean z16, a aVar, ArrayList<String> arrayList, int i3, ArrayList<Integer> arrayList2) {
        super(str);
        this.f451061c = new AtomicInteger(0);
        this.f451063e = new ConcurrentHashMap<>();
        this.f451064f = new LinkedHashSet<>();
        this.f451066h = str2;
        this.f451065g = z16;
        this.f451062d = arrayList;
        this.f451067i = i3;
        this.f451068j = arrayList2;
    }

    public c d() {
        o.a("SplitModules", "enter " + this.f451069a);
        e.c().b(this);
        this.f451061c.incrementAndGet();
        return this;
    }

    public c e() {
        o.a("SplitModules", "exit " + this.f451069a);
        if (this.f451061c.decrementAndGet() <= 0) {
            this.f451061c.set(0);
            e.c().q(this);
        }
        return this;
    }

    public c f() {
        o.a("SplitModules", "exitAll " + this.f451069a);
        this.f451061c.set(0);
        e.c().q(this);
        return this;
    }

    public List<String> g() {
        return e.c().m(i());
    }

    public String h() {
        return this.f451066h;
    }

    String i() {
        return "m-perm" + this.f451069a;
    }

    public void j(String str) {
        o.a("SplitModules", "granPerm module=" + this.f451069a + " perm=" + str);
        e.c().a(i(), str);
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.f451066h);
    }

    public boolean l(String str) {
        if (this.f451065g) {
            Iterator<f> it = this.f451064f.iterator();
            while (it.hasNext()) {
                if (it.next().e(str)) {
                    return true;
                }
            }
            return false;
        }
        return g().contains(str);
    }

    public void m(String str) {
        o.a("SplitModules", "unGranPerm module=" + this.f451069a + " perm=" + str);
        e.c().p(i(), str);
    }

    public String toString() {
        return "SplitModule{runningCount=" + this.f451061c + ", name='" + this.f451069a + "', relatePermission=" + this.f451062d + '}';
    }
}
