package q1;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.j;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final OutputStream f428169a = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a extends OutputStream {
        a() {
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i3) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            j.m(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i16) {
            j.m(bArr);
        }
    }

    private static byte[] a(Deque<byte[]> deque, int i3) {
        byte[] bArr = new byte[i3];
        int i16 = i3;
        while (i16 > 0) {
            byte[] removeFirst = deque.removeFirst();
            int min = Math.min(i16, removeFirst.length);
            System.arraycopy(removeFirst, 0, bArr, i3 - i16, min);
            i16 -= min;
        }
        return bArr;
    }

    @CanIgnoreReturnValue
    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        j.m(inputStream);
        j.m(outputStream);
        byte[] c16 = c();
        long j3 = 0;
        while (true) {
            int read = inputStream.read(c16);
            if (read == -1) {
                return j3;
            }
            outputStream.write(c16, 0, read);
            j3 += read;
        }
    }

    static byte[] c() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    @Beta
    public static int d(InputStream inputStream, byte[] bArr, int i3, int i16) throws IOException {
        j.m(inputStream);
        j.m(bArr);
        if (i16 >= 0) {
            int i17 = 0;
            while (i17 < i16) {
                int read = inputStream.read(bArr, i3 + i17, i16 - i17);
                if (read == -1) {
                    break;
                }
                i17 += read;
            }
            return i17;
        }
        throw new IndexOutOfBoundsException("len is negative");
    }

    @Beta
    public static void e(InputStream inputStream, byte[] bArr) throws IOException {
        f(inputStream, bArr, 0, bArr.length);
    }

    @Beta
    public static void f(InputStream inputStream, byte[] bArr, int i3, int i16) throws IOException {
        int d16 = d(inputStream, bArr, i3, i16);
        if (d16 == i16) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + d16 + " bytes; " + i16 + " bytes expected");
    }

    @Beta
    public static void g(InputStream inputStream, long j3) throws IOException {
        long i3 = i(inputStream, j3);
        if (i3 >= j3) {
            return;
        }
        throw new EOFException("reached end of stream after skipping " + i3 + " bytes; " + j3 + " bytes expected");
    }

    private static long h(InputStream inputStream, long j3) throws IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(available, j3));
    }

    static long i(InputStream inputStream, long j3) throws IOException {
        byte[] c16 = c();
        long j16 = 0;
        while (j16 < j3) {
            long j17 = j3 - j16;
            long h16 = h(inputStream, j17);
            if (h16 == 0) {
                h16 = inputStream.read(c16, 0, (int) Math.min(j17, c16.length));
                if (h16 == -1) {
                    break;
                }
            }
            j16 += h16;
        }
        return j16;
    }

    public static byte[] j(InputStream inputStream) throws IOException {
        j.m(inputStream);
        return l(inputStream, new ArrayDeque(20), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] k(InputStream inputStream, long j3) throws IOException {
        boolean z16;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.g(z16, "expectedSize (%s) must be non-negative", j3);
        if (j3 <= 2147483639) {
            int i3 = (int) j3;
            byte[] bArr = new byte[i3];
            int i16 = i3;
            while (i16 > 0) {
                int i17 = i3 - i16;
                int read = inputStream.read(bArr, i17, i16);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i17);
                }
                i16 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return l(inputStream, arrayDeque, i3 + 1);
        }
        throw new OutOfMemoryError(j3 + " bytes is too large to fit in a byte array");
    }

    private static byte[] l(InputStream inputStream, Deque<byte[]> deque, int i3) throws IOException {
        int i16 = 8192;
        while (i3 < 2147483639) {
            int min = Math.min(i16, 2147483639 - i3);
            byte[] bArr = new byte[min];
            deque.add(bArr);
            int i17 = 0;
            while (i17 < min) {
                int read = inputStream.read(bArr, i17, min - i17);
                if (read == -1) {
                    return a(deque, i3);
                }
                i17 += read;
                i3 += read;
            }
            i16 = r1.a.e(i16, 2);
        }
        if (inputStream.read() == -1) {
            return a(deque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
