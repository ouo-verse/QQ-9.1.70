package s;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;
import s.h;

/* compiled from: P */
/* loaded from: classes.dex */
public class g extends h0.g<com.bumptech.glide.load.c, q<?>> implements h {

    /* renamed from: e, reason: collision with root package name */
    private h.a f433029e;

    public g(long j3) {
        super(j3);
    }

    @Override // s.h
    @Nullable
    public /* bridge */ /* synthetic */ q b(@NonNull com.bumptech.glide.load.c cVar) {
        return (q) super.k(cVar);
    }

    @Override // s.h
    @Nullable
    public /* bridge */ /* synthetic */ q c(@NonNull com.bumptech.glide.load.c cVar, @Nullable q qVar) {
        return (q) super.j(cVar, qVar);
    }

    @Override // s.h
    public void d(@NonNull h.a aVar) {
        this.f433029e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h0.g
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public int h(@Nullable q<?> qVar) {
        if (qVar == null) {
            return super.h(null);
        }
        return qVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h0.g
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void i(@NonNull com.bumptech.glide.load.c cVar, @Nullable q<?> qVar) {
        h.a aVar = this.f433029e;
        if (aVar != null && qVar != null) {
            aVar.c(qVar);
        }
    }

    @Override // s.h
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i3) {
        if (i3 >= 40) {
            a();
        } else if (i3 >= 20 || i3 == 15) {
            l(g() / 2);
        }
    }
}
