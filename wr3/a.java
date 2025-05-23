package wr3;

import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a<T> extends WeakReference<T> {
    public a(T t16) {
        super(t16);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            if (get() != null && get() == ((a) obj).get()) {
                return true;
            }
            return false;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        if (get() != null) {
            return get().hashCode();
        }
        return super.hashCode();
    }
}
