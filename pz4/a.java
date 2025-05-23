package pz4;

import com.xingin.xhssharesdk.a.g;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class a<T> implements Closeable {

    /* renamed from: d, reason: collision with root package name */
    public final g f428096d;

    public a(g.d dVar) {
        this.f428096d = dVar;
    }

    public final void a(e05.c cVar) {
        try {
            byte[] a16 = cVar.a();
            int i3 = b.f428097a;
            byte[] bArr = {(byte) ((i3 >> 24) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 8) & 255), (byte) (i3 & 255)};
            if (a16.length <= 5242880) {
                this.f428096d.y(a16.length + 4);
                g gVar = this.f428096d;
                gVar.getClass();
                gVar.u(bArr, 0, 4);
                g gVar2 = this.f428096d;
                gVar2.getClass();
                gVar2.u(a16, 0, a16.length);
                this.f428096d.h();
                return;
            }
            throw new IOException("Byte array length exceed! Required: <5242880, but got:" + a16.length);
        } catch (FileNotFoundException e16) {
            throw new RuntimeException(e16);
        } catch (IOException e17) {
            throw new RuntimeException(e17);
        }
    }
}
