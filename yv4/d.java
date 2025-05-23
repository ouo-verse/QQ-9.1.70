package yv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public t55.b f451331a;

    /* renamed from: b, reason: collision with root package name */
    public long f451332b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f451333c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f451334d;

    /* renamed from: e, reason: collision with root package name */
    public String f451335e;

    /* renamed from: f, reason: collision with root package name */
    public String f451336f;

    /* renamed from: g, reason: collision with root package name */
    public int f451337g;

    /* renamed from: h, reason: collision with root package name */
    public String f451338h;

    /* renamed from: i, reason: collision with root package name */
    public String f451339i;

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
            if (readTag == 10) {
                if (this.f451331a == null) {
                    this.f451331a = new t55.b();
                }
                codedInputByteBufferNano.readMessage(this.f451331a);
            } else if (readTag == 16) {
                this.f451332b = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.f451333c = codedInputByteBufferNano.readBool();
            } else if (readTag == 32) {
                this.f451334d = codedInputByteBufferNano.readBool();
            } else if (readTag == 42) {
                this.f451335e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f451336f = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.f451337g = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 66) {
                this.f451338h = codedInputByteBufferNano.readString();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f451339i = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        t55.b bVar = this.f451331a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        long j3 = this.f451332b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        boolean z16 = this.f451333c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        boolean z17 = this.f451334d;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z17);
        }
        if (!this.f451335e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451335e);
        }
        if (!this.f451336f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f451336f);
        }
        int i3 = this.f451337g;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        if (!this.f451338h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f451338h);
        }
        return !this.f451339i.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f451339i) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        t55.b bVar = this.f451331a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        long j3 = this.f451332b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        boolean z16 = this.f451333c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        boolean z17 = this.f451334d;
        if (z17) {
            codedOutputByteBufferNano.writeBool(4, z17);
        }
        if (!this.f451335e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451335e);
        }
        if (!this.f451336f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f451336f);
        }
        int i3 = this.f451337g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        if (!this.f451338h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f451338h);
        }
        if (!this.f451339i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f451339i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f451331a = null;
        this.f451332b = 0L;
        this.f451333c = false;
        this.f451334d = false;
        this.f451335e = "";
        this.f451336f = "";
        this.f451337g = 0;
        this.f451338h = "";
        this.f451339i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
