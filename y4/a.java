package y4;

import android.os.Build;
import androidx.fragment.app.Fragment;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final b f449319a;

    /* compiled from: P */
    /* renamed from: y4.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    static class C11587a implements b {
        C11587a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    interface b {
        void a(Fragment fragment, boolean z16);

        void b(Fragment fragment, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    static class c extends C11587a {
        c() {
        }

        @Override // y4.a.b
        public void a(Fragment fragment, boolean z16) {
            y4.c.a(fragment, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    static class d extends c {
        d() {
        }

        @Override // y4.a.b
        public void b(Fragment fragment, boolean z16) {
            y4.d.a(fragment, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    static class e extends d {
        e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    static class f extends e {
        f() {
        }

        @Override // y4.a.d, y4.a.b
        public void b(Fragment fragment, boolean z16) {
            y4.b.a(fragment, z16);
        }
    }

    static {
        if (a()) {
            f449319a = new f();
        } else {
            f449319a = new e();
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static void b(Fragment fragment, boolean z16) {
        f449319a.a(fragment, z16);
    }

    public static void c(Fragment fragment, boolean z16) {
        f449319a.b(fragment, z16);
    }
}
