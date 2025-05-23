package w32;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static d f444509d;

    /* renamed from: a, reason: collision with root package name */
    private String f444510a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f444511b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f444512c = "";

    public d() {
        f();
        e();
        g();
    }

    public static d b() {
        if (f444509d == null) {
            synchronized (d.class) {
                if (f444509d == null) {
                    f444509d = new d();
                }
            }
        }
        return f444509d;
    }

    private void e() {
        this.f444511b = Build.BRAND;
    }

    private void f() {
        this.f444510a = DeviceInfoMonitor.getModel();
    }

    private void g() {
        this.f444512c = Build.VERSION.RELEASE;
    }

    public String a() {
        return this.f444511b;
    }

    public String c() {
        return this.f444510a;
    }

    public String d() {
        return this.f444512c;
    }
}
