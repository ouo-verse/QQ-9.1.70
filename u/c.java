package u;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import java.io.InputStream;
import t.n;
import t.o;
import t.r;

/* compiled from: P */
/* loaded from: classes.dex */
public class c implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f437974a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f437975a;

        public a(Context context) {
            this.f437975a = context;
        }

        @Override // t.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new c(this.f437975a);
        }
    }

    public c(Context context) {
        this.f437974a = context.getApplicationContext();
    }

    private boolean d(com.bumptech.glide.load.e eVar) {
        Long l3 = (Long) eVar.c(VideoDecoder.f31799d);
        if (l3 != null && l3.longValue() == -1) {
            return true;
        }
        return false;
    }

    @Override // t.n
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull Uri uri, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        if (q.b.d(i3, i16) && d(eVar)) {
            return new n.a<>(new g0.b(uri), q.c.e(this.f437974a, uri));
        }
        return null;
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull Uri uri) {
        return q.b.c(uri);
    }
}
