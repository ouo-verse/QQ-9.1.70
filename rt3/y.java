package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class y extends ExtendableMessageNano<y> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile y[] f432382d;

    /* renamed from: a, reason: collision with root package name */
    public int f432383a;

    /* renamed from: b, reason: collision with root package name */
    public String f432384b;

    /* renamed from: c, reason: collision with root package name */
    public String f432385c;

    public y() {
        a();
    }

    public static y[] b() {
        if (f432382d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432382d == null) {
                    f432382d = new y[0];
                }
            }
        }
        return f432382d;
    }

    public y a() {
        this.f432383a = 0;
        this.f432384b = "";
        this.f432385c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f432385c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f432384b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432383a = codedInputByteBufferNano.readUInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f432383a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f432384b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432384b);
        }
        if (!this.f432385c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f432385c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f432383a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f432384b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432384b);
        }
        if (!this.f432385c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432385c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
