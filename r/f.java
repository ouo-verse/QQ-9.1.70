package r;

/* compiled from: P */
/* loaded from: classes.dex */
public final class f implements a<byte[]> {
    @Override // r.a
    public int b() {
        return 1;
    }

    @Override // r.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // r.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i3) {
        return new byte[i3];
    }

    @Override // r.a
    public String getTag() {
        return "ByteArrayPool";
    }
}
