package xv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ab extends ExtendableMessageNano<ab> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile ab[] f448767d;

    /* renamed from: a, reason: collision with root package name */
    public int f448768a;

    /* renamed from: b, reason: collision with root package name */
    public String f448769b;

    /* renamed from: c, reason: collision with root package name */
    public int f448770c;

    public ab() {
        a();
    }

    public static ab[] b() {
        if (f448767d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448767d == null) {
                    f448767d = new ab[0];
                }
            }
        }
        return f448767d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ab mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f448768a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f448769b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f448770c = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f448768a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f448769b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448769b);
        }
        int i16 = this.f448770c;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448768a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f448769b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448769b);
        }
        int i16 = this.f448770c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public ab a() {
        this.f448768a = 0;
        this.f448769b = "";
        this.f448770c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
