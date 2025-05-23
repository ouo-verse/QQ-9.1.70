package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bi extends ExtendableMessageNano<bi> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile bi[] f440344d;

    /* renamed from: a, reason: collision with root package name */
    public String f440345a;

    /* renamed from: b, reason: collision with root package name */
    public String f440346b;

    /* renamed from: c, reason: collision with root package name */
    public String f440347c;

    public bi() {
        a();
    }

    public static bi[] b() {
        if (f440344d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440344d == null) {
                    f440344d = new bi[0];
                }
            }
        }
        return f440344d;
    }

    public bi a() {
        this.f440345a = "";
        this.f440346b = "";
        this.f440347c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bi mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440345a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440346b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440347c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440345a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440345a);
        }
        if (!this.f440346b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440346b);
        }
        return !this.f440347c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f440347c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440345a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440345a);
        }
        if (!this.f440346b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440346b);
        }
        if (!this.f440347c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440347c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
