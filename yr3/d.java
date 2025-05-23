package yr3;

import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f451069a;

    /* renamed from: b, reason: collision with root package name */
    private HashSet<String> f451070b = new HashSet<>();

    public d(String str) {
        this.f451069a = str;
    }

    @NotNull
    public HashSet<String> a() {
        return this.f451070b;
    }

    public boolean b() {
        String d16 = com.tencent.qmethod.pandoraex.core.a.d();
        if (q.m()) {
            o.a("SplitModules", "splitModule " + this.f451069a + "isBindingUIAlive top " + d16 + "bindUI " + this.f451070b);
        }
        return this.f451070b.contains(d16);
    }

    public boolean c() {
        return !this.f451070b.isEmpty();
    }
}
