package t;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public interface n<Model, Data> {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.c f435123a;

        /* renamed from: b, reason: collision with root package name */
        public final List<com.bumptech.glide.load.c> f435124b;

        /* renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f435125c;

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull List<com.bumptech.glide.load.c> list, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this.f435123a = (com.bumptech.glide.load.c) h0.j.d(cVar);
            this.f435124b = (List) h0.j.d(list);
            this.f435125c = (com.bumptech.glide.load.data.d) h0.j.d(dVar);
        }
    }

    @Nullable
    a<Data> a(@NonNull Model model, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar);

    boolean handles(@NonNull Model model);
}
