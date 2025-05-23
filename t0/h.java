package t0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class h extends d {

    /* renamed from: j, reason: collision with root package name */
    private final i f435182j;

    public h(boolean z16, i iVar) throws IOException {
        ByteOrder byteOrder;
        this.f435167a = z16;
        this.f435182j = iVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (z16) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        this.f435168b = iVar.h(allocate, 16L);
        this.f435169c = iVar.i(allocate, 32L);
        this.f435170d = iVar.i(allocate, 40L);
        this.f435171e = iVar.h(allocate, 54L);
        this.f435172f = iVar.h(allocate, 56L);
        this.f435173g = iVar.h(allocate, 58L);
        this.f435174h = iVar.h(allocate, 60L);
        this.f435175i = iVar.h(allocate, 62L);
    }

    @Override // t0.d
    public c a(long j3, int i3) throws IOException {
        return new b(this.f435182j, this, j3, i3);
    }

    @Override // t0.d
    public e b(long j3) throws IOException {
        return new k(this.f435182j, this, j3);
    }

    @Override // t0.d
    public f c(int i3) throws IOException {
        return new m(this.f435182j, this, i3);
    }
}
