package v;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.q;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public final class l<T> implements com.bumptech.glide.load.h<T> {

    /* renamed from: b, reason: collision with root package name */
    private static final com.bumptech.glide.load.h<?> f440714b = new l();

    l() {
    }

    @NonNull
    public static <T> l<T> c() {
        return (l) f440714b;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
    }

    @Override // com.bumptech.glide.load.h
    @NonNull
    public q<T> a(@NonNull Context context, @NonNull q<T> qVar, int i3, int i16) {
        return qVar;
    }
}
