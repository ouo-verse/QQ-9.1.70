package z;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class e extends x.b<c> {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<c> getResourceClass() {
        return c.class;
    }

    @Override // com.bumptech.glide.load.engine.q
    public int getSize() {
        return ((c) this.f446808d).j();
    }

    @Override // x.b, com.bumptech.glide.load.engine.m
    public void initialize() {
        ((c) this.f446808d).f().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.q
    public void recycle() {
        ((c) this.f446808d).stop();
        ((c) this.f446808d).recycle();
    }
}
