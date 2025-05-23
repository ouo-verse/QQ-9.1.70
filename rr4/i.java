package rr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public long f432126a;

    /* renamed from: b, reason: collision with root package name */
    public String f432127b;

    /* renamed from: c, reason: collision with root package name */
    public int f432128c;

    /* renamed from: d, reason: collision with root package name */
    public String f432129d;

    /* renamed from: e, reason: collision with root package name */
    public String f432130e;

    /* renamed from: f, reason: collision with root package name */
    public long f432131f;

    /* renamed from: g, reason: collision with root package name */
    public String f432132g;

    /* renamed from: h, reason: collision with root package name */
    public long f432133h;

    /* renamed from: i, reason: collision with root package name */
    public String f432134i;

    public i() {
        a();
    }

    public i a() {
        this.f432126a = 0L;
        this.f432127b = "";
        this.f432128c = 0;
        this.f432129d = "";
        this.f432130e = "";
        this.f432131f = 0L;
        this.f432132g = "";
        this.f432133h = 0L;
        this.f432134i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (readTag != 64) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f432134i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f432133h = codedInputByteBufferNano.readUInt64();
                                            }
                                        } else {
                                            this.f432132g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f432131f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f432130e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f432129d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f432128c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f432127b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f432126a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f432126a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f432127b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f432127b);
        }
        int i3 = this.f432128c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f432129d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f432129d);
        }
        if (!this.f432130e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f432130e);
        }
        long j16 = this.f432131f;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        if (!this.f432132g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f432132g);
        }
        long j17 = this.f432133h;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        if (!this.f432134i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f432134i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f432126a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f432127b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f432127b);
        }
        int i3 = this.f432128c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f432129d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f432129d);
        }
        if (!this.f432130e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f432130e);
        }
        long j16 = this.f432131f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        if (!this.f432132g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f432132g);
        }
        long j17 = this.f432133h;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        if (!this.f432134i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f432134i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
