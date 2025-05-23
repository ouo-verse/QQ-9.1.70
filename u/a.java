package u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.j;
import java.io.InputStream;
import t.m;
import t.n;
import t.o;
import t.r;

/* compiled from: P */
/* loaded from: classes.dex */
public class a implements n<t.g, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Integer> f437969b = com.bumptech.glide.load.d.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final m<t.g, t.g> f437970a;

    /* compiled from: P */
    /* renamed from: u.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C11315a implements o<t.g, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final m<t.g, t.g> f437971a = new m<>(500);

        @Override // t.o
        @NonNull
        public n<t.g, InputStream> b(r rVar) {
            return new a(this.f437971a);
        }
    }

    public a(@Nullable m<t.g, t.g> mVar) {
        this.f437970a = mVar;
    }

    @Override // t.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> a(@NonNull t.g gVar, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        m<t.g, t.g> mVar = this.f437970a;
        if (mVar != null) {
            t.g a16 = mVar.a(gVar, 0, 0);
            if (a16 == null) {
                this.f437970a.b(gVar, 0, 0, gVar);
            } else {
                gVar = a16;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) eVar.c(f437969b)).intValue()));
    }

    @Override // t.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean handles(@NonNull t.g gVar) {
        return true;
    }
}
