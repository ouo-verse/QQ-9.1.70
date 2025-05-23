package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bk extends ExtendableMessageNano<bk> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile bk[] f440364e;

    /* renamed from: a, reason: collision with root package name */
    public int f440365a;

    /* renamed from: b, reason: collision with root package name */
    public az f440366b;

    /* renamed from: c, reason: collision with root package name */
    public ag f440367c;

    /* renamed from: d, reason: collision with root package name */
    public a f440368d;

    public bk() {
        a();
    }

    public static bk[] b() {
        if (f440364e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440364e == null) {
                    f440364e = new bk[0];
                }
            }
        }
        return f440364e;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f440365a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.f440366b == null) {
                    this.f440366b = new az();
                }
                codedInputByteBufferNano.readMessage(this.f440366b);
            } else if (readTag == 26) {
                if (this.f440367c == null) {
                    this.f440367c = new ag();
                }
                codedInputByteBufferNano.readMessage(this.f440367c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f440368d == null) {
                    this.f440368d = new a();
                }
                codedInputByteBufferNano.readMessage(this.f440368d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f440365a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        az azVar = this.f440366b;
        if (azVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, azVar);
        }
        ag agVar = this.f440367c;
        if (agVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, agVar);
        }
        a aVar = this.f440368d;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f440365a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        az azVar = this.f440366b;
        if (azVar != null) {
            codedOutputByteBufferNano.writeMessage(2, azVar);
        }
        ag agVar = this.f440367c;
        if (agVar != null) {
            codedOutputByteBufferNano.writeMessage(3, agVar);
        }
        a aVar = this.f440368d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bk a() {
        this.f440365a = 0;
        this.f440366b = null;
        this.f440367c = null;
        this.f440368d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
