package vp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public e[] f443154a;

    /* renamed from: b, reason: collision with root package name */
    public b f443155b;

    /* renamed from: c, reason: collision with root package name */
    public c f443156c;

    /* renamed from: d, reason: collision with root package name */
    public float f443157d;

    /* renamed from: e, reason: collision with root package name */
    public int f443158e;

    /* renamed from: f, reason: collision with root package name */
    public int f443159f;

    /* renamed from: g, reason: collision with root package name */
    public int f443160g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f443161h;

    /* renamed from: i, reason: collision with root package name */
    public float f443162i;

    /* renamed from: j, reason: collision with root package name */
    public b f443163j;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f443154a = e.b();
        this.f443155b = null;
        this.f443156c = null;
        this.f443157d = 0.0f;
        this.f443158e = 0;
        this.f443159f = 0;
        this.f443160g = 0;
        this.f443161h = false;
        this.f443162i = 0.0f;
        this.f443163j = null;
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
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    e[] eVarArr = this.f443154a;
                    if (eVarArr == null) {
                        length = 0;
                    } else {
                        length = eVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    e[] eVarArr2 = new e[i3];
                    if (length != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        e eVar = new e();
                        eVarArr2[length] = eVar;
                        codedInputByteBufferNano.readMessage(eVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    e eVar2 = new e();
                    eVarArr2[length] = eVar2;
                    codedInputByteBufferNano.readMessage(eVar2);
                    this.f443154a = eVarArr2;
                    break;
                case 18:
                    if (this.f443155b == null) {
                        this.f443155b = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f443155b);
                    break;
                case 26:
                    if (this.f443156c == null) {
                        this.f443156c = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f443156c);
                    break;
                case 37:
                    this.f443157d = codedInputByteBufferNano.readFloat();
                    break;
                case 40:
                    this.f443158e = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.f443159f = codedInputByteBufferNano.readInt32();
                    break;
                case 56:
                    this.f443160g = codedInputByteBufferNano.readInt32();
                    break;
                case 64:
                    this.f443161h = codedInputByteBufferNano.readBool();
                    break;
                case 77:
                    this.f443162i = codedInputByteBufferNano.readFloat();
                    break;
                case 82:
                    if (this.f443163j == null) {
                        this.f443163j = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f443163j);
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
        e[] eVarArr = this.f443154a;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f443154a;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
                }
                i3++;
            }
        }
        b bVar = this.f443155b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        c cVar = this.f443156c;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
        }
        if (Float.floatToIntBits(this.f443157d) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.f443157d);
        }
        int i16 = this.f443158e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        int i17 = this.f443159f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i17);
        }
        int i18 = this.f443160g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i18);
        }
        boolean z16 = this.f443161h;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z16);
        }
        if (Float.floatToIntBits(this.f443162i) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(9, this.f443162i);
        }
        b bVar2 = this.f443163j;
        if (bVar2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, bVar2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e[] eVarArr = this.f443154a;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f443154a;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, eVar);
                }
                i3++;
            }
        }
        b bVar = this.f443155b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        c cVar = this.f443156c;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(3, cVar);
        }
        if (Float.floatToIntBits(this.f443157d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f443157d);
        }
        int i16 = this.f443158e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        int i17 = this.f443159f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        int i18 = this.f443160g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i18);
        }
        boolean z16 = this.f443161h;
        if (z16) {
            codedOutputByteBufferNano.writeBool(8, z16);
        }
        if (Float.floatToIntBits(this.f443162i) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(9, this.f443162i);
        }
        b bVar2 = this.f443163j;
        if (bVar2 != null) {
            codedOutputByteBufferNano.writeMessage(10, bVar2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
