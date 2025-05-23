package t0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g extends d {

    /* renamed from: j, reason: collision with root package name */
    private final i f435181j;

    public g(boolean z16, i iVar) throws IOException {
        ByteOrder byteOrder;
        this.f435167a = z16;
        this.f435181j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f435168b = iVar.h(allocate, 16L);
        this.f435169c = iVar.k(allocate, 28L);
        this.f435170d = iVar.k(allocate, 32L);
        this.f435171e = iVar.h(allocate, 42L);
        this.f435172f = iVar.h(allocate, 44L);
        this.f435173g = iVar.h(allocate, 46L);
        this.f435174h = iVar.h(allocate, 48L);
        this.f435175i = iVar.h(allocate, 50L);
    }

    @Override // t0.d
    public c a(long j3, int i3) throws IOException {
        return new a(this.f435181j, this, j3, i3);
    }

    @Override // t0.d
    public e b(long j3) throws IOException {
        return new j(this.f435181j, this, j3);
    }

    @Override // t0.d
    public f c(int i3) throws IOException {
        return new l(this.f435181j, this, i3);
    }
}
