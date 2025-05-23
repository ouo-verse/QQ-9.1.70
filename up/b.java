package up;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f439405a = new HashMap(3);

    /* renamed from: b, reason: collision with root package name */
    private a f439406b = null;

    public void a() {
        this.f439405a.clear();
        this.f439406b = null;
    }

    public a b(int i3, String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = this.f439405a.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(i3, str);
        this.f439405a.put(str, aVar2);
        if (this.f439405a.size() != 1 && !z16) {
            return aVar2;
        }
        f(str);
        return aVar2;
    }

    public a c() {
        return this.f439406b;
    }

    public a d(String str) {
        if (this.f439405a.isEmpty()) {
            return null;
        }
        return this.f439405a.get(str);
    }

    public a e(String str) {
        a aVar;
        if (this.f439405a.isEmpty()) {
            return null;
        }
        a remove = this.f439405a.remove(str);
        if (remove != null && remove == (aVar = this.f439406b)) {
            aVar.f439385d = false;
            this.f439406b = null;
        }
        return remove;
    }

    public void f(String str) {
        a d16 = d(str);
        if (d16 == null || d16.f439385d) {
            return;
        }
        a aVar = this.f439406b;
        if (aVar != null) {
            aVar.f439385d = false;
        }
        d16.f439385d = true;
        this.f439406b = d16;
    }
}
