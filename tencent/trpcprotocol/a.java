package tencent.trpcprotocol;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f436071a;

    /* renamed from: b, reason: collision with root package name */
    public String f436072b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f436073c;

    /* renamed from: d, reason: collision with root package name */
    public int f436074d;

    /* renamed from: e, reason: collision with root package name */
    public String f436075e;

    /* renamed from: f, reason: collision with root package name */
    public r45.a[] f436076f;

    public a() {
        a();
    }

    public a a() {
        this.f436071a = "";
        this.f436072b = "";
        this.f436073c = WireFormatNano.EMPTY_BYTES;
        this.f436074d = 0;
        this.f436075e = "";
        this.f436076f = r45.a.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 802) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 802);
                                        r45.a[] aVarArr = this.f436076f;
                                        if (aVarArr == null) {
                                            length = 0;
                                        } else {
                                            length = aVarArr.length;
                                        }
                                        int i3 = repeatedFieldArrayLength + length;
                                        r45.a[] aVarArr2 = new r45.a[i3];
                                        if (length != 0) {
                                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                                        }
                                        while (length < i3 - 1) {
                                            r45.a aVar = new r45.a();
                                            aVarArr2[length] = aVar;
                                            codedInputByteBufferNano.readMessage(aVar);
                                            codedInputByteBufferNano.readTag();
                                            length++;
                                        }
                                        r45.a aVar2 = new r45.a();
                                        aVarArr2[length] = aVar2;
                                        codedInputByteBufferNano.readMessage(aVar2);
                                        this.f436076f = aVarArr2;
                                    }
                                } else {
                                    this.f436075e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f436074d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f436073c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f436072b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f436071a = codedInputByteBufferNano.readString();
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
        if (!this.f436071a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f436071a);
        }
        if (!this.f436072b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f436072b);
        }
        if (!Arrays.equals(this.f436073c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f436073c);
        }
        int i3 = this.f436074d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.f436075e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f436075e);
        }
        r45.a[] aVarArr = this.f436076f;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                r45.a[] aVarArr2 = this.f436076f;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                r45.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(100, aVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f436071a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f436071a);
        }
        if (!this.f436072b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f436072b);
        }
        if (!Arrays.equals(this.f436073c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f436073c);
        }
        int i3 = this.f436074d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.f436075e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f436075e);
        }
        r45.a[] aVarArr = this.f436076f;
        if (aVarArr != null && aVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                r45.a[] aVarArr2 = this.f436076f;
                if (i16 >= aVarArr2.length) {
                    break;
                }
                r45.a aVar = aVarArr2[i16];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(100, aVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
