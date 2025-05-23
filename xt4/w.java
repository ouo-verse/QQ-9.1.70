package xt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class w extends ExtendableMessageNano<w> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile w[] f448658l;

    /* renamed from: a, reason: collision with root package name */
    public hs4.i f448659a;

    /* renamed from: b, reason: collision with root package name */
    public int f448660b;

    /* renamed from: c, reason: collision with root package name */
    public int f448661c;

    /* renamed from: d, reason: collision with root package name */
    public String f448662d;

    /* renamed from: e, reason: collision with root package name */
    public String f448663e;

    /* renamed from: f, reason: collision with root package name */
    public String f448664f;

    /* renamed from: g, reason: collision with root package name */
    public String f448665g;

    /* renamed from: h, reason: collision with root package name */
    public es4.b[] f448666h;

    /* renamed from: i, reason: collision with root package name */
    public String f448667i;

    /* renamed from: j, reason: collision with root package name */
    public String f448668j;

    /* renamed from: k, reason: collision with root package name */
    public hs4.b f448669k;

    public w() {
        a();
    }

    public static w[] b() {
        if (f448658l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448658l == null) {
                    f448658l = new w[0];
                }
            }
        }
        return f448658l;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public w mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f448659a == null) {
                        this.f448659a = new hs4.i();
                    }
                    codedInputByteBufferNano.readMessage(this.f448659a);
                    break;
                case 16:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f448660b = readInt32;
                        break;
                    }
                case 24:
                    this.f448661c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f448662d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f448663e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f448664f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f448665g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    es4.b[] bVarArr = this.f448666h;
                    int length = bVarArr == null ? 0 : bVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    es4.b[] bVarArr2 = new es4.b[i3];
                    if (length != 0) {
                        System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        es4.b bVar = new es4.b();
                        bVarArr2[length] = bVar;
                        codedInputByteBufferNano.readMessage(bVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    es4.b bVar2 = new es4.b();
                    bVarArr2[length] = bVar2;
                    codedInputByteBufferNano.readMessage(bVar2);
                    this.f448666h = bVarArr2;
                    break;
                case 74:
                    this.f448667i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f448668j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.f448669k == null) {
                        this.f448669k = new hs4.b();
                    }
                    codedInputByteBufferNano.readMessage(this.f448669k);
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        hs4.i iVar = this.f448659a;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
        }
        int i3 = this.f448660b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f448661c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!this.f448662d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f448662d);
        }
        if (!this.f448663e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f448663e);
        }
        if (!this.f448664f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f448664f);
        }
        if (!this.f448665g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f448665g);
        }
        es4.b[] bVarArr = this.f448666h;
        if (bVarArr != null && bVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                es4.b[] bVarArr2 = this.f448666h;
                if (i17 >= bVarArr2.length) {
                    break;
                }
                es4.b bVar = bVarArr2[i17];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, bVar);
                }
                i17++;
            }
        }
        if (!this.f448667i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f448667i);
        }
        if (!this.f448668j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f448668j);
        }
        hs4.b bVar2 = this.f448669k;
        return bVar2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, bVar2) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        hs4.i iVar = this.f448659a;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(1, iVar);
        }
        int i3 = this.f448660b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f448661c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.f448662d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f448662d);
        }
        if (!this.f448663e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f448663e);
        }
        if (!this.f448664f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f448664f);
        }
        if (!this.f448665g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f448665g);
        }
        es4.b[] bVarArr = this.f448666h;
        if (bVarArr != null && bVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                es4.b[] bVarArr2 = this.f448666h;
                if (i17 >= bVarArr2.length) {
                    break;
                }
                es4.b bVar = bVarArr2[i17];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(8, bVar);
                }
                i17++;
            }
        }
        if (!this.f448667i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f448667i);
        }
        if (!this.f448668j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f448668j);
        }
        hs4.b bVar2 = this.f448669k;
        if (bVar2 != null) {
            codedOutputByteBufferNano.writeMessage(11, bVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public w a() {
        this.f448659a = null;
        this.f448660b = 0;
        this.f448661c = 0;
        this.f448662d = "";
        this.f448663e = "";
        this.f448664f = "";
        this.f448665g = "";
        this.f448666h = es4.b.b();
        this.f448667i = "";
        this.f448668j = "";
        this.f448669k = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
