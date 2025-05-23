package sr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f434371a;

    /* renamed from: b, reason: collision with root package name */
    public long f434372b;

    /* renamed from: c, reason: collision with root package name */
    public String f434373c;

    /* renamed from: d, reason: collision with root package name */
    public String f434374d;

    /* renamed from: e, reason: collision with root package name */
    public long f434375e;

    /* renamed from: f, reason: collision with root package name */
    public a[] f434376f;

    /* renamed from: g, reason: collision with root package name */
    public String f434377g;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class a extends ExtendableMessageNano<a> {

        /* renamed from: g, reason: collision with root package name */
        private static volatile a[] f434378g;

        /* renamed from: a, reason: collision with root package name */
        public long f434379a;

        /* renamed from: b, reason: collision with root package name */
        public int f434380b;

        /* renamed from: c, reason: collision with root package name */
        public String f434381c;

        /* renamed from: d, reason: collision with root package name */
        public String f434382d;

        /* renamed from: e, reason: collision with root package name */
        public long f434383e;

        /* renamed from: f, reason: collision with root package name */
        public int f434384f;

        public a() {
            a();
        }

        public static a[] b() {
            if (f434378g == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (f434378g == null) {
                        f434378g = new a[0];
                    }
                }
            }
            return f434378g;
        }

        public a a() {
            this.f434379a = 0L;
            this.f434380b = 0;
            this.f434381c = "";
            this.f434382d = "";
            this.f434383e = 0L;
            this.f434384f = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag != 0) {
                    if (readTag != 8) {
                        if (readTag != 16) {
                            if (readTag != 26) {
                                if (readTag != 34) {
                                    if (readTag != 40) {
                                        if (readTag != 48) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            int readInt32 = codedInputByteBufferNano.readInt32();
                                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                                                this.f434384f = readInt32;
                                            }
                                        }
                                    } else {
                                        this.f434383e = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f434382d = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f434381c = codedInputByteBufferNano.readString();
                            }
                        } else {
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                                this.f434380b = readInt322;
                            }
                        }
                    } else {
                        this.f434379a = codedInputByteBufferNano.readUInt64();
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
            long j3 = this.f434379a;
            if (j3 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
            }
            int i3 = this.f434380b;
            if (i3 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
            }
            if (!this.f434381c.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434381c);
            }
            if (!this.f434382d.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434382d);
            }
            long j16 = this.f434383e;
            if (j16 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
            }
            int i16 = this.f434384f;
            if (i16 != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i16);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j3 = this.f434379a;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j3);
            }
            int i3 = this.f434380b;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i3);
            }
            if (!this.f434381c.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.f434381c);
            }
            if (!this.f434382d.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.f434382d);
            }
            long j16 = this.f434383e;
            if (j16 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j16);
            }
            int i16 = this.f434384f;
            if (i16 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i16);
            }
            super.writeTo(codedOutputByteBufferNano);
        }
    }

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f434371a = 0L;
        this.f434372b = 0L;
        this.f434373c = "";
        this.f434374d = "";
        this.f434375e = 0L;
        this.f434376f = a.b();
        this.f434377g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f434377g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                                        a[] aVarArr = this.f434376f;
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
                                        this.f434376f = aVarArr2;
                                    }
                                } else {
                                    this.f434375e = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f434374d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f434373c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f434372b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f434371a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f434371a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f434372b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f434373c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f434373c);
        }
        if (!this.f434374d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f434374d);
        }
        long j17 = this.f434375e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        a[] aVarArr = this.f434376f;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f434376f;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, aVar);
                }
                i3++;
            }
        }
        if (!this.f434377g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f434377g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f434371a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f434372b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f434373c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f434373c);
        }
        if (!this.f434374d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f434374d);
        }
        long j17 = this.f434375e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        a[] aVarArr = this.f434376f;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f434376f;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, aVar);
                }
                i3++;
            }
        }
        if (!this.f434377g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f434377g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
