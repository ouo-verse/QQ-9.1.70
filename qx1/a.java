package qx1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a<Rsp> {
    public void a(int i3, String str, Rsp rsp) {
        b(true, i3, str, rsp);
    }

    public void b(boolean z16, int i3, String str, Rsp rsp) {
        if (i3 == 0 && rsp != null && z16) {
            d(rsp);
        } else {
            c(i3, str, rsp);
        }
    }

    protected abstract void c(int i3, String str, @Nullable Rsp rsp);

    protected abstract void d(@NonNull Rsp rsp);
}
