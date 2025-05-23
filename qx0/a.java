package qx0;

import android.content.Context;
import com.tencent.icgame.game.initer.impl.IniterServiceImpl;
import ev0.b;
import ey0.d;
import fv0.c;
import gy0.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<? extends mm4.a>, mm4.a> f430268a = new HashMap();

    static {
        d(b.class, new IniterServiceImpl());
        d(ox0.b.class, new ky4.b());
        d(mx0.a.class, new nx0.a());
        d(d.class, new e());
        d(sx0.b.class, new ux0.b());
        d(vu0.b.class, new wu0.a());
        d(c.class, new gv0.a());
        d(fu0.c.class, new gu0.a());
        d(ru0.b.class, new su0.b());
        d(bv0.a.class, new cv0.a());
        d(ru0.a.class, new su0.c("0AND05GC39G3MA0B"));
        d(fu0.b.class, new ju0.a());
    }

    public static void a() {
        Iterator<mm4.a> it = f430268a.values().iterator();
        while (it.hasNext()) {
            it.next().o2();
        }
    }

    public static <T extends mm4.a> T b(Class<T> cls) {
        return (T) f430268a.get(cls);
    }

    public static void c(Context context) {
        Iterator<mm4.a> it = f430268a.values().iterator();
        while (it.hasNext()) {
            it.next().init(context);
        }
    }

    private static void d(Class<? extends mm4.a> cls, mm4.a aVar) {
        f430268a.put(cls, aVar);
    }
}
