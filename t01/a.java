package t01;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name */
    protected ByteBuffer f435222a;

    public a() {
        d(10240);
    }

    public int a() {
        return this.f435222a.position();
    }

    public void b(byte b16) {
        this.f435222a.put(b16);
    }

    public void c(byte[] bArr) {
        this.f435222a.put(bArr);
    }

    public void d(int i3) {
        ByteBuffer byteBuffer = this.f435222a;
        if (byteBuffer == null || i3 > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i3);
            this.f435222a = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f435222a.clear();
    }

    public void e(int i3) {
        this.f435222a.position(i3 + a());
    }

    public byte[] f() {
        return this.f435222a.array();
    }

    @Override // t01.f
    public void close() {
    }
}
