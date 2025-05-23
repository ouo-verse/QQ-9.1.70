package t;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import t.n;

/* compiled from: P */
/* loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f435163b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    private final n<g, Data> f435164a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // t.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f435164a = nVar;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return this.f435164a.a(new g(uri.toString()), i3, i16, eVar);
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Uri uri) {
        return f435163b.contains(uri.getScheme());
    }
}
