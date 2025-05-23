package ur;

import tr.b;
import tr.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public c f439854a;

    /* renamed from: b, reason: collision with root package name */
    public int f439855b;

    /* renamed from: c, reason: collision with root package name */
    public int f439856c;

    a(C11364a c11364a) {
        this.f439854a = c11364a.f439857a;
        this.f439855b = c11364a.f439858b;
        this.f439856c = c11364a.f439859c;
    }

    public String toString() {
        return "DoodleConfig{doodleStrategy=" + this.f439854a + ", maxBitmapWidth=" + this.f439855b + ", maxBitmapHeight=" + this.f439856c + '}';
    }

    /* compiled from: P */
    /* renamed from: ur.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static class C11364a {

        /* renamed from: a, reason: collision with root package name */
        private c f439857a = new b();

        /* renamed from: b, reason: collision with root package name */
        private int f439858b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f439859c = 0;

        public a d() {
            return new a(this);
        }

        public C11364a e(c cVar) {
            if (cVar != null) {
                this.f439857a = cVar;
            }
            return this;
        }

        public C11364a f(int i3) {
            if (i3 > 0) {
                this.f439859c = i3;
            }
            return this;
        }

        public C11364a g(int i3) {
            if (i3 > 0) {
                this.f439858b = i3;
            }
            return this;
        }
    }
}
