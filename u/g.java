package u;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.net.URL;
import t.n;
import t.o;
import t.r;

/* compiled from: P */
/* loaded from: classes.dex */
public class g implements n<URL, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final n<t.g, InputStream> f437988a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a implements o<URL, InputStream> {
        @Override // t.o
        @NonNull
        public n<URL, InputStream> b(r rVar) {
            return new g(rVar.d(t.g.class, InputStream.class));
        }
    }

    public g(n<t.g, InputStream> nVar) {
        this.f437988a = nVar;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull URL url, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return this.f437988a.a(new t.g(url), i3, i16, eVar);
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull URL url) {
        return true;
    }
}
