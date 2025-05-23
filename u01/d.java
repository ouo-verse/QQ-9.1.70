package u01;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class d implements c {
    public abstract InputStream a() throws IOException;

    @Override // u01.c
    public final synchronized t01.d obtain() throws IOException {
        return new t01.e(a());
    }
}
