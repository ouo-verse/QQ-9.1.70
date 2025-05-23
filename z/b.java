package z;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b implements GifDecoder.a {

    /* renamed from: a, reason: collision with root package name */
    private final r.d f451661a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final r.b f451662b;

    public b(r.d dVar, @Nullable r.b bVar) {
        this.f451661a = dVar;
        this.f451662b = bVar;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void a(@NonNull byte[] bArr) {
        r.b bVar = this.f451662b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void b(@NonNull int[] iArr) {
        r.b bVar = this.f451662b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public byte[] c(int i3) {
        r.b bVar = this.f451662b;
        if (bVar == null) {
            return new byte[i3];
        }
        return (byte[]) bVar.b(i3, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public int[] d(int i3) {
        r.b bVar = this.f451662b;
        if (bVar == null) {
            return new int[i3];
        }
        return (int[]) bVar.b(i3, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public Bitmap e(int i3, int i16, @NonNull Bitmap.Config config) {
        return this.f451661a.b(i3, i16, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void f(@NonNull Bitmap bitmap) {
        this.f451661a.put(bitmap);
    }
}
