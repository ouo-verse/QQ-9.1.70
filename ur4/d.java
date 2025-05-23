package ur4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile d[] f439905j;

    /* renamed from: a, reason: collision with root package name */
    public int f439906a;

    /* renamed from: b, reason: collision with root package name */
    public String f439907b;

    /* renamed from: c, reason: collision with root package name */
    public int f439908c;

    /* renamed from: d, reason: collision with root package name */
    public int f439909d;

    /* renamed from: e, reason: collision with root package name */
    public j[] f439910e;

    /* renamed from: f, reason: collision with root package name */
    public long f439911f;

    /* renamed from: g, reason: collision with root package name */
    public long f439912g;

    /* renamed from: h, reason: collision with root package name */
    public b f439913h;

    /* renamed from: i, reason: collision with root package name */
    public r f439914i;

    public d() {
        a();
    }

    public static d[] b() {
        if (f439905j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f439905j == null) {
                    f439905j = new d[0];
                }
            }
        }
        return f439905j;
    }

    public d a() {
        this.f439906a = 0;
        this.f439907b = "";
        this.f439908c = 0;
        this.f439909d = 0;
        this.f439910e = j.b();
        this.f439911f = 0L;
        this.f439912g = 0L;
        this.f439913h = null;
        this.f439914i = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (readTag != 56) {
                                        if (readTag != 64) {
                                            if (readTag != 74) {
                                                if (readTag != 82) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    if (this.f439914i == null) {
                                                        this.f439914i = new r();
                                                    }
                                                    codedInputByteBufferNano.readMessage(this.f439914i);
                                                }
                                            } else {
                                                if (this.f439913h == null) {
                                                    this.f439913h = new b();
                                                }
                                                codedInputByteBufferNano.readMessage(this.f439913h);
                                            }
                                        } else {
                                            this.f439912g = codedInputByteBufferNano.readUInt64();
                                        }
                                    } else {
                                        this.f439911f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                    j[] jVarArr = this.f439910e;
                                    if (jVarArr == null) {
                                        length = 0;
                                    } else {
                                        length = jVarArr.length;
                                    }
                                    int i3 = repeatedFieldArrayLength + length;
                                    j[] jVarArr2 = new j[i3];
                                    if (length != 0) {
                                        System.arraycopy(jVarArr, 0, jVarArr2, 0, length);
                                    }
                                    while (length < i3 - 1) {
                                        j jVar = new j();
                                        jVarArr2[length] = jVar;
                                        codedInputByteBufferNano.readMessage(jVar);
                                        codedInputByteBufferNano.readTag();
                                        length++;
                                    }
                                    j jVar2 = new j();
                                    jVarArr2[length] = jVar2;
                                    codedInputByteBufferNano.readMessage(jVar2);
                                    this.f439910e = jVarArr2;
                                }
                            } else {
                                this.f439909d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f439908c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f439907b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f439906a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f439906a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f439907b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f439907b);
        }
        int i16 = this.f439908c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f439909d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        j[] jVarArr = this.f439910e;
        if (jVarArr != null && jVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                j[] jVarArr2 = this.f439910e;
                if (i18 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i18];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, jVar);
                }
                i18++;
            }
        }
        long j3 = this.f439911f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        long j16 = this.f439912g;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        b bVar = this.f439913h;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, bVar);
        }
        r rVar = this.f439914i;
        if (rVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, rVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f439906a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f439907b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f439907b);
        }
        int i16 = this.f439908c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f439909d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        j[] jVarArr = this.f439910e;
        if (jVarArr != null && jVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                j[] jVarArr2 = this.f439910e;
                if (i18 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i18];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, jVar);
                }
                i18++;
            }
        }
        long j3 = this.f439911f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        long j16 = this.f439912g;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        b bVar = this.f439913h;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(9, bVar);
        }
        r rVar = this.f439914i;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(10, rVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
