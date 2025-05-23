package sp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile c[] f434139g;

    /* renamed from: a, reason: collision with root package name */
    public long f434140a;

    /* renamed from: b, reason: collision with root package name */
    public long f434141b;

    /* renamed from: c, reason: collision with root package name */
    public a[] f434142c;

    /* renamed from: d, reason: collision with root package name */
    public String f434143d;

    /* renamed from: e, reason: collision with root package name */
    public int f434144e;

    /* renamed from: f, reason: collision with root package name */
    public String f434145f;

    public c() {
        a();
    }

    public static c[] b() {
        if (f434139g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f434139g == null) {
                    f434139g = new c[0];
                }
            }
        }
        return f434139g;
    }

    public c a() {
        this.f434140a = 0L;
        this.f434141b = 0L;
        this.f434142c = a.b();
        this.f434143d = "";
        this.f434144e = 0;
        this.f434145f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 8010) {
                            if (readTag != 80010) {
                                if (readTag != 80016) {
                                    if (readTag != 80026) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f434145f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f434144e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f434143d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8010);
                            a[] aVarArr = this.f434142c;
                            if (aVarArr == null) {
                                length = 0;
                            } else {
                                length = aVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            a[] aVarArr2 = new a[i3];
                            if (length != 0) {
                                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                a aVar = new a();
                                aVarArr2[length] = aVar;
                                codedInputByteBufferNano.readMessage(aVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            a aVar2 = new a();
                            aVarArr2[length] = aVar2;
                            codedInputByteBufferNano.readMessage(aVar2);
                            this.f434142c = aVarArr2;
                        }
                    } else {
                        this.f434141b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f434140a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f434140a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f434141b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        a[] aVarArr = this.f434142c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f434142c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1001, aVar);
                }
                i3++;
            }
        }
        if (!this.f434143d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10001, this.f434143d);
        }
        int i16 = this.f434144e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10002, i16);
        }
        if (!this.f434145f.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10003, this.f434145f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f434140a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f434141b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        a[] aVarArr = this.f434142c;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f434142c;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1001, aVar);
                }
                i3++;
            }
        }
        if (!this.f434143d.equals("")) {
            codedOutputByteBufferNano.writeString(10001, this.f434143d);
        }
        int i16 = this.f434144e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10002, i16);
        }
        if (!this.f434145f.equals("")) {
            codedOutputByteBufferNano.writeString(10003, this.f434145f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
