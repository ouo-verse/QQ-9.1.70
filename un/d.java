package un;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private final int f439250b;

    public d(String str, int i3) {
        super(str);
        this.f439250b = i3;
    }

    @Override // un.a
    public int b() {
        return this.f439250b;
    }

    @Override // un.a
    public void c(Context context) {
        int b16 = b();
        if (b16 == 4) {
            f.e(context);
        } else {
            if (b16 != 311) {
                return;
            }
            e.e(context);
        }
    }
}
