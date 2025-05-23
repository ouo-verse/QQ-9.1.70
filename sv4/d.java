package sv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f434860a;

    /* renamed from: b, reason: collision with root package name */
    public String f434861b;

    /* renamed from: c, reason: collision with root package name */
    public String f434862c;

    /* renamed from: d, reason: collision with root package name */
    public String f434863d;

    /* renamed from: e, reason: collision with root package name */
    public String f434864e;

    /* renamed from: f, reason: collision with root package name */
    public String f434865f;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f434860a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f434861b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f434862c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f434863d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f434864e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f434865f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f434860a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f434861b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f434861b);
        }
        if (!this.f434862c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434862c);
        }
        if (!this.f434863d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434863d);
        }
        if (!this.f434864e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f434864e);
        }
        return !this.f434865f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f434865f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f434860a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f434861b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f434861b);
        }
        if (!this.f434862c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434862c);
        }
        if (!this.f434863d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f434863d);
        }
        if (!this.f434864e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f434864e);
        }
        if (!this.f434865f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f434865f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f434860a = 0;
        this.f434861b = "";
        this.f434862c = "";
        this.f434863d = "";
        this.f434864e = "";
        this.f434865f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
