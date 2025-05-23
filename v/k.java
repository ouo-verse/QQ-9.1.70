package v;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;

/* compiled from: P */
/* loaded from: classes.dex */
public class k<T> implements q<T> {

    /* renamed from: d, reason: collision with root package name */
    protected final T f440713d;

    public k(@NonNull T t16) {
        this.f440713d = (T) h0.j.d(t16);
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public final T get() {
        return this.f440713d;
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<T> getResourceClass() {
        return (Class<T>) this.f440713d.getClass();
    }

    @Override // com.bumptech.glide.load.engine.q
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.q
    public void recycle() {
    }
}
