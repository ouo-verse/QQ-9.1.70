package u;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;
import t.n;
import t.o;
import t.r;

/* compiled from: P */
/* loaded from: classes.dex */
public class b implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f437972a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f437973a;

        public a(Context context) {
            this.f437973a = context;
        }

        @Override // t.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new b(this.f437973a);
        }
    }

    public b(Context context) {
        this.f437972a = context.getApplicationContext();
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        if (q.b.d(i3, i16)) {
            return new n.a<>(new g0.b(uri), q.c.d(this.f437972a, uri));
        }
        return null;
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Uri uri) {
        return q.b.a(uri);
    }
}
