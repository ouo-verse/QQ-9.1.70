package t0;

import com.tencent.ttpic.openapi.initializer.so.MinElf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i implements Closeable {

    /* renamed from: d, reason: collision with root package name */
    private final int f435183d = MinElf.ELF_MAGIC;

    /* renamed from: e, reason: collision with root package name */
    private final FileChannel f435184e;

    public i(File file) throws FileNotFoundException {
        if (file != null && file.exists()) {
            this.f435184e = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    private long a(d dVar, long j3, long j16) throws IOException {
        for (long j17 = 0; j17 < j3; j17++) {
            e b16 = dVar.b(j17);
            if (b16.f435176a == 1) {
                long j18 = b16.f435178c;
                if (j18 <= j16 && j16 <= b16.f435179d + j18) {
                    return (j16 - j18) + b16.f435177b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f435184e.close();
    }

    public d d() throws IOException {
        boolean z16;
        this.f435184e.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (k(allocate, 0L) == 1179403647) {
            short g16 = g(allocate, 4L);
            if (g(allocate, 5L) == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (g16 == 1) {
                return new g(z16, this);
            }
            if (g16 == 2) {
                return new h(z16, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> e() throws IOException {
        ByteOrder byteOrder;
        long j3;
        c a16;
        this.f435184e.position(0L);
        ArrayList arrayList = new ArrayList();
        d d16 = d();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        if (d16.f435167a) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        allocate.order(byteOrder);
        long j16 = d16.f435172f;
        int i3 = 0;
        if (j16 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j16 = d16.c(0).f435180a;
        }
        long j17 = 0;
        while (true) {
            if (j17 < j16) {
                e b16 = d16.b(j17);
                if (b16.f435176a == 2) {
                    j3 = b16.f435177b;
                    break;
                }
                j17++;
            } else {
                j3 = 0;
                break;
            }
        }
        if (j3 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j18 = 0;
        do {
            a16 = d16.a(j3, i3);
            long j19 = a16.f435165a;
            if (j19 == 1) {
                arrayList2.add(Long.valueOf(a16.f435166b));
            } else if (j19 == 5) {
                j18 = a16.f435166b;
            }
            i3++;
        } while (a16.f435165a != 0);
        if (j18 != 0) {
            long a17 = a(d16, j16, j18);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(j(allocate, ((Long) it.next()).longValue() + a17));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    protected void f(ByteBuffer byteBuffer, long j3, int i3) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i3);
        long j16 = 0;
        while (j16 < i3) {
            int read = this.f435184e.read(byteBuffer, j3 + j16);
            if (read != -1) {
                j16 += read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }

    protected short g(ByteBuffer byteBuffer, long j3) throws IOException {
        f(byteBuffer, j3, 1);
        return (short) (byteBuffer.get() & 255);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h(ByteBuffer byteBuffer, long j3) throws IOException {
        f(byteBuffer, j3, 2);
        return byteBuffer.getShort() & 65535;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long i(ByteBuffer byteBuffer, long j3) throws IOException {
        f(byteBuffer, j3, 8);
        return byteBuffer.getLong();
    }

    protected String j(ByteBuffer byteBuffer, long j3) throws IOException {
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            long j16 = 1 + j3;
            short g16 = g(byteBuffer, j3);
            if (g16 != 0) {
                sb5.append((char) g16);
                j3 = j16;
            } else {
                return sb5.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long k(ByteBuffer byteBuffer, long j3) throws IOException {
        f(byteBuffer, j3, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
