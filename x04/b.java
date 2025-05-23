package x04;

import android.os.HandlerThread;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f446841a;

    /* renamed from: b, reason: collision with root package name */
    private final String f446842b;

    /* renamed from: c, reason: collision with root package name */
    private final long f446843c;

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f446844d;

    public b(Thread thread, List<String> list) {
        this.f446841a = thread instanceof HandlerThread ? HandlerThread.class.getName() : thread.getClass().getName();
        this.f446842b = thread.getName();
        this.f446843c = thread.getId();
        this.f446844d = list;
    }

    public String a() {
        return this.f446842b;
    }

    public String b() {
        return this.f446841a;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.f446844d != null) {
            for (int i3 = 0; i3 < this.f446844d.size(); i3++) {
                sb5.append(this.f446844d.get(i3));
                if (i3 < this.f446844d.size() - 1) {
                    sb5.append("\n");
                }
            }
        }
        return String.format("%s,%s,%d\n%s", this.f446841a, this.f446842b, Long.valueOf(this.f446843c), sb5.toString());
    }
}
