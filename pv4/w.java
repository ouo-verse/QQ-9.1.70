package pv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile w[] f427708i;

    /* renamed from: a, reason: collision with root package name */
    public pu4.b[] f427709a;

    /* renamed from: b, reason: collision with root package name */
    public String f427710b;

    /* renamed from: c, reason: collision with root package name */
    public String f427711c;

    /* renamed from: d, reason: collision with root package name */
    public int f427712d;

    /* renamed from: e, reason: collision with root package name */
    public int f427713e;

    /* renamed from: f, reason: collision with root package name */
    public long f427714f;

    /* renamed from: g, reason: collision with root package name */
    public u f427715g;

    /* renamed from: h, reason: collision with root package name */
    public u f427716h;

    public w() {
        a();
    }

    public static w[] b() {
        if (f427708i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427708i == null) {
                    f427708i = new w[0];
                }
            }
        }
        return f427708i;
    }

    public w a() {
        this.f427709a = pu4.b.b();
        this.f427710b = "";
        this.f427711c = "";
        this.f427712d = 0;
        this.f427713e = 0;
        this.f427714f = 0L;
        this.f427715g = null;
        this.f427716h = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                pu4.b[] bVarArr = this.f427709a;
                int length = bVarArr == null ? 0 : bVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pu4.b[] bVarArr2 = new pu4.b[i3];
                if (length != 0) {
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pu4.b bVar = new pu4.b();
                    bVarArr2[length] = bVar;
                    codedInputByteBufferNano.readMessage(bVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pu4.b bVar2 = new pu4.b();
                bVarArr2[length] = bVar2;
                codedInputByteBufferNano.readMessage(bVar2);
                this.f427709a = bVarArr2;
            } else if (readTag == 18) {
                this.f427710b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f427711c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f427712d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f427713e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 48) {
                this.f427714f = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 58) {
                if (this.f427715g == null) {
                    this.f427715g = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427715g);
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427716h == null) {
                    this.f427716h = new u();
                }
                codedInputByteBufferNano.readMessage(this.f427716h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pu4.b[] bVarArr = this.f427709a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pu4.b[] bVarArr2 = this.f427709a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                pu4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i3++;
            }
        }
        if (!this.f427710b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427710b);
        }
        if (!this.f427711c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427711c);
        }
        int i16 = this.f427712d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.f427713e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i17);
        }
        long j3 = this.f427714f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        u uVar = this.f427715g;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, uVar);
        }
        u uVar2 = this.f427716h;
        return uVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, uVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pu4.b[] bVarArr = this.f427709a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                pu4.b[] bVarArr2 = this.f427709a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                pu4.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i3++;
            }
        }
        if (!this.f427710b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427710b);
        }
        if (!this.f427711c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427711c);
        }
        int i16 = this.f427712d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.f427713e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        long j3 = this.f427714f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        u uVar = this.f427715g;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(7, uVar);
        }
        u uVar2 = this.f427716h;
        if (uVar2 != null) {
            codedOutputByteBufferNano.writeMessage(8, uVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
