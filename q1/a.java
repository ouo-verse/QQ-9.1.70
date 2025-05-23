package q1;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.j;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: q1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C11051a extends c {

        /* renamed from: a, reason: collision with root package name */
        final Charset f428167a;

        C11051a(Charset charset) {
            this.f428167a = (Charset) j.m(charset);
        }

        @Override // q1.c
        public String a() throws IOException {
            return new String(a.this.b(), this.f428167a);
        }

        public String toString() {
            return a.this.toString() + ".asCharSource(" + this.f428167a + ")";
        }
    }

    public c a(Charset charset) {
        return new C11051a(charset);
    }

    public abstract byte[] b() throws IOException;
}
