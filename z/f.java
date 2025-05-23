package z;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.h<c> {

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.h<Bitmap> f451670b;

    public f(com.bumptech.glide.load.h<Bitmap> hVar) {
        this.f451670b = (com.bumptech.glide.load.h) h0.j.d(hVar);
    }

    @Override // com.bumptech.glide.load.h
    @NonNull
    public q<c> a(@NonNull Context context, @NonNull q<c> qVar, int i3, int i16) {
        c cVar = qVar.get();
        q<Bitmap> eVar = new com.bumptech.glide.load.resource.bitmap.e(cVar.f(), com.bumptech.glide.b.c(context).f());
        q<Bitmap> a16 = this.f451670b.a(context, eVar, i3, i16);
        if (!eVar.equals(a16)) {
            eVar.recycle();
        }
        cVar.n(this.f451670b, a16.get());
        return qVar;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f451670b.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f451670b.equals(((f) obj).f451670b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f451670b.hashCode();
    }
}
