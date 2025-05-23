package t01;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e extends FilterInputStream implements d {

    /* renamed from: d, reason: collision with root package name */
    private int f435225d;

    public e(InputStream inputStream) {
        super(inputStream);
        try {
            inputStream.reset();
        } catch (IOException unused) {
        }
    }

    @Override // t01.d
    public byte peek() throws IOException {
        byte read = (byte) read();
        this.f435225d++;
        return read;
    }

    @Override // t01.d
    public int position() {
        return this.f435225d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, t01.d
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int read = super.read(bArr, i3, i16);
        this.f435225d += Math.max(0, read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, t01.d
    public synchronized void reset() throws IOException {
        super.reset();
        this.f435225d = 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, t01.d
    public long skip(long j3) throws IOException {
        long skip = super.skip(j3);
        this.f435225d = (int) (this.f435225d + skip);
        return skip;
    }

    @Override // t01.d
    public InputStream toInputStream() throws IOException {
        return this;
    }
}
