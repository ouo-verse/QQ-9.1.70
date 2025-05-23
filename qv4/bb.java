package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bb extends ExtendableMessageNano<bb> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile bb[] f430043g;

    /* renamed from: a, reason: collision with root package name */
    public pu4.g f430044a;

    /* renamed from: b, reason: collision with root package name */
    public bp[] f430045b;

    /* renamed from: c, reason: collision with root package name */
    public String f430046c;

    /* renamed from: d, reason: collision with root package name */
    public int f430047d;

    /* renamed from: e, reason: collision with root package name */
    public int f430048e;

    /* renamed from: f, reason: collision with root package name */
    public int f430049f;

    public bb() {
        a();
    }

    public static bb[] b() {
        if (f430043g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430043g == null) {
                    f430043g = new bb[0];
                }
            }
        }
        return f430043g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bb mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430044a == null) {
                    this.f430044a = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430044a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                bp[] bpVarArr = this.f430045b;
                int length = bpVarArr == null ? 0 : bpVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                bp[] bpVarArr2 = new bp[i3];
                if (length != 0) {
                    System.arraycopy(bpVarArr, 0, bpVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    bp bpVar = new bp();
                    bpVarArr2[length] = bpVar;
                    codedInputByteBufferNano.readMessage(bpVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bp bpVar2 = new bp();
                bpVarArr2[length] = bpVar2;
                codedInputByteBufferNano.readMessage(bpVar2);
                this.f430045b = bpVarArr2;
            } else if (readTag == 26) {
                this.f430046c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f430047d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 40) {
                this.f430048e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430049f = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pu4.g gVar = this.f430044a;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
        }
        bp[] bpVarArr = this.f430045b;
        if (bpVarArr != null && bpVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bp[] bpVarArr2 = this.f430045b;
                if (i3 >= bpVarArr2.length) {
                    break;
                }
                bp bpVar = bpVarArr2[i3];
                if (bpVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bpVar);
                }
                i3++;
            }
        }
        if (!this.f430046c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f430046c);
        }
        int i16 = this.f430047d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        int i17 = this.f430048e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.f430049f;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pu4.g gVar = this.f430044a;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(1, gVar);
        }
        bp[] bpVarArr = this.f430045b;
        if (bpVarArr != null && bpVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bp[] bpVarArr2 = this.f430045b;
                if (i3 >= bpVarArr2.length) {
                    break;
                }
                bp bpVar = bpVarArr2[i3];
                if (bpVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bpVar);
                }
                i3++;
            }
        }
        if (!this.f430046c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f430046c);
        }
        int i16 = this.f430047d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        int i17 = this.f430048e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.f430049f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bb a() {
        this.f430044a = null;
        this.f430045b = bp.b();
        this.f430046c = "";
        this.f430047d = 0;
        this.f430048e = 0;
        this.f430049f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
