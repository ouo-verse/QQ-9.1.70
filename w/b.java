package w;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;
import h0.j;

/* compiled from: P */
/* loaded from: classes.dex */
public class b implements q<byte[]> {

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f443807d;

    public b(byte[] bArr) {
        this.f443807d = (byte[]) j.d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f443807d;
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.q
    public int getSize() {
        return this.f443807d.length;
    }

    @Override // com.bumptech.glide.load.engine.q
    public void recycle() {
    }
}
