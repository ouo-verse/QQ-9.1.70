package z;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.q;

/* compiled from: P */
/* loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.f<GifDecoder, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final r.d f451693a;

    public h(r.d dVar) {
        this.f451693a = dVar;
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q<Bitmap> b(@NonNull GifDecoder gifDecoder, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar) {
        return com.bumptech.glide.load.resource.bitmap.e.b(gifDecoder.getNextFrame(), this.f451693a);
    }

    @Override // com.bumptech.glide.load.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull GifDecoder gifDecoder, @NonNull com.bumptech.glide.load.e eVar) {
        return true;
    }
}
