package z30;

import android.view.MotionEvent;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f451838b = new b();

    /* renamed from: a, reason: collision with root package name */
    private HashSet<a> f451839a = new HashSet<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    b() {
    }

    public void a(a aVar) {
        this.f451839a.add(aVar);
    }

    public boolean b(MotionEvent motionEvent) {
        Iterator<a> it = this.f451839a.iterator();
        while (it.hasNext()) {
            if (it.next().a(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void c(a aVar) {
        this.f451839a.remove(aVar);
    }
}
