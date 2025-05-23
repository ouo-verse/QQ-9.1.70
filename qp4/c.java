package qp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile c[] f429206d;

    /* renamed from: a, reason: collision with root package name */
    public String f429207a;

    /* renamed from: b, reason: collision with root package name */
    public int f429208b;

    /* renamed from: c, reason: collision with root package name */
    public int f429209c;

    public c() {
        a();
    }

    public static c[] b() {
        if (f429206d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f429206d == null) {
                    f429206d = new c[0];
                }
            }
        }
        return f429206d;
    }

    public c a() {
        this.f429207a = "";
        this.f429208b = 0;
        this.f429209c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f429209c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f429208b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f429207a = codedInputByteBufferNano.readString();
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
        if (!this.f429207a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f429207a);
        }
        int i3 = this.f429208b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f429209c;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f429207a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f429207a);
        }
        int i3 = this.f429208b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f429209c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
