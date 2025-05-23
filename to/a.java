package to;

import java.io.IOException;
import java.io.Writer;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f436988a;

    public a(b... bVarArr) {
        this.f436988a = (b[]) d(bVarArr);
    }

    @Override // to.b
    public int a(CharSequence charSequence, int i3, Writer writer) throws IOException {
        for (b bVar : this.f436988a) {
            int a16 = bVar.a(charSequence, i3, writer);
            if (a16 != 0) {
                return a16;
            }
        }
        return 0;
    }

    public static <T> T[] d(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }
}
