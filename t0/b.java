package t0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends c {
    public b(i iVar, d dVar, long j3, int i3) throws IOException {
        ByteOrder byteOrder;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (dVar.f435167a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = j3 + (i3 * 16);
        this.f435165a = iVar.i(allocate, j16);
        this.f435166b = iVar.i(allocate, j16 + 8);
    }
}
