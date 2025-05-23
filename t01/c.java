package t01;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements d {

    /* renamed from: d, reason: collision with root package name */
    protected d f435224d;

    public c(d dVar) {
        this.f435224d = dVar;
    }

    @Override // t01.d
    public int available() throws IOException {
        return this.f435224d.available();
    }

    @Override // t01.d
    public void close() throws IOException {
        this.f435224d.close();
    }

    @Override // t01.d
    public byte peek() throws IOException {
        return this.f435224d.peek();
    }

    @Override // t01.d
    public int position() {
        return this.f435224d.position();
    }

    @Override // t01.d
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        return this.f435224d.read(bArr, i3, i16);
    }

    @Override // t01.d
    public void reset() throws IOException {
        this.f435224d.reset();
    }

    @Override // t01.d
    public long skip(long j3) throws IOException {
        return this.f435224d.skip(j3);
    }

    @Override // t01.d
    public InputStream toInputStream() throws IOException {
        reset();
        return this.f435224d.toInputStream();
    }
}
