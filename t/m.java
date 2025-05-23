package t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes.dex */
public class m<A, B> {

    /* renamed from: a, reason: collision with root package name */
    private final h0.g<b<A>, B> f435117a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a extends h0.g<b<A>, B> {
        a(long j3) {
            super(j3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // h0.g
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void i(@NonNull b<A> bVar, @Nullable B b16) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b<A> {

        /* renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f435119d = h0.k.e(0);

        /* renamed from: a, reason: collision with root package name */
        private int f435120a;

        /* renamed from: b, reason: collision with root package name */
        private int f435121b;

        /* renamed from: c, reason: collision with root package name */
        private A f435122c;

        b() {
        }

        static <A> b<A> a(A a16, int i3, int i16) {
            b<A> bVar;
            Queue<b<?>> queue = f435119d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a16, i3, i16);
            return bVar;
        }

        private void b(A a16, int i3, int i16) {
            this.f435122c = a16;
            this.f435121b = i3;
            this.f435120a = i16;
        }

        public void c() {
            Queue<b<?>> queue = f435119d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f435121b != bVar.f435121b || this.f435120a != bVar.f435120a || !this.f435122c.equals(bVar.f435122c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f435120a * 31) + this.f435121b) * 31) + this.f435122c.hashCode();
        }
    }

    public m(long j3) {
        this.f435117a = new a(j3);
    }

    @Nullable
    public B a(A a16, int i3, int i16) {
        b<A> a17 = b.a(a16, i3, i16);
        B f16 = this.f435117a.f(a17);
        a17.c();
        return f16;
    }

    public void b(A a16, int i3, int i16, B b16) {
        this.f435117a.j(b.a(a16, i3, i16), b16);
    }
}
