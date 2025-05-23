package t0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j extends e {
    public j(i iVar, d dVar, long j3) throws IOException {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (dVar.f435167a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = dVar.f435169c + (j3 * dVar.f435171e);
        this.f435176a = iVar.k(allocate, j16);
        this.f435177b = iVar.k(allocate, 4 + j16);
        this.f435178c = iVar.k(allocate, 8 + j16);
        this.f435179d = iVar.k(allocate, j16 + 20);
    }
}
