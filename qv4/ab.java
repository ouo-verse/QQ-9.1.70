package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ab extends ExtendableMessageNano<ab> {

    /* renamed from: a, reason: collision with root package name */
    public bb[] f429886a;

    /* renamed from: b, reason: collision with root package name */
    public pv4.y f429887b;

    /* renamed from: c, reason: collision with root package name */
    public String f429888c;

    /* renamed from: d, reason: collision with root package name */
    public String f429889d;

    /* renamed from: e, reason: collision with root package name */
    public int f429890e;

    /* renamed from: f, reason: collision with root package name */
    public int f429891f;

    /* renamed from: g, reason: collision with root package name */
    public String f429892g;

    /* renamed from: h, reason: collision with root package name */
    public pv4.u f429893h;

    /* renamed from: i, reason: collision with root package name */
    public pv4.u f429894i;

    /* renamed from: j, reason: collision with root package name */
    public pv4.u f429895j;

    /* renamed from: k, reason: collision with root package name */
    public String f429896k;

    /* renamed from: l, reason: collision with root package name */
    public pv4.u f429897l;

    /* renamed from: m, reason: collision with root package name */
    public int f429898m;

    /* renamed from: n, reason: collision with root package name */
    public l[] f429899n;

    public ab() {
        a();
    }

    public static ab c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ab) MessageNano.mergeFrom(new ab(), bArr);
    }

    public ab a() {
        this.f429886a = bb.b();
        this.f429887b = null;
        this.f429888c = "";
        this.f429889d = "";
        this.f429890e = 0;
        this.f429891f = 0;
        this.f429892g = "";
        this.f429893h = null;
        this.f429894i = null;
        this.f429895j = null;
        this.f429896k = "";
        this.f429897l = null;
        this.f429898m = 0;
        this.f429899n = l.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ab mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    bb[] bbVarArr = this.f429886a;
                    int length = bbVarArr == null ? 0 : bbVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    bb[] bbVarArr2 = new bb[i3];
                    if (length != 0) {
                        System.arraycopy(bbVarArr, 0, bbVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        bb bbVar = new bb();
                        bbVarArr2[length] = bbVar;
                        codedInputByteBufferNano.readMessage(bbVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    bb bbVar2 = new bb();
                    bbVarArr2[length] = bbVar2;
                    codedInputByteBufferNano.readMessage(bbVar2);
                    this.f429886a = bbVarArr2;
                    break;
                case 18:
                    if (this.f429887b == null) {
                        this.f429887b = new pv4.y();
                    }
                    codedInputByteBufferNano.readMessage(this.f429887b);
                    break;
                case 26:
                    this.f429888c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f429889d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f429890e = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.f429891f = codedInputByteBufferNano.readInt32();
                    break;
                case 58:
                    this.f429892g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.f429893h == null) {
                        this.f429893h = new pv4.u();
                    }
                    codedInputByteBufferNano.readMessage(this.f429893h);
                    break;
                case 74:
                    if (this.f429894i == null) {
                        this.f429894i = new pv4.u();
                    }
                    codedInputByteBufferNano.readMessage(this.f429894i);
                    break;
                case 82:
                    if (this.f429895j == null) {
                        this.f429895j = new pv4.u();
                    }
                    codedInputByteBufferNano.readMessage(this.f429895j);
                    break;
                case 90:
                    this.f429896k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    if (this.f429897l == null) {
                        this.f429897l = new pv4.u();
                    }
                    codedInputByteBufferNano.readMessage(this.f429897l);
                    break;
                case 104:
                    this.f429898m = codedInputByteBufferNano.readUInt32();
                    break;
                case 114:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    l[] lVarArr = this.f429899n;
                    int length2 = lVarArr == null ? 0 : lVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    l[] lVarArr2 = new l[i16];
                    if (length2 != 0) {
                        System.arraycopy(lVarArr, 0, lVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        l lVar = new l();
                        lVarArr2[length2] = lVar;
                        codedInputByteBufferNano.readMessage(lVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    l lVar2 = new l();
                    lVarArr2[length2] = lVar2;
                    codedInputByteBufferNano.readMessage(lVar2);
                    this.f429899n = lVarArr2;
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
        bb[] bbVarArr = this.f429886a;
        int i3 = 0;
        if (bbVarArr != null && bbVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bb[] bbVarArr2 = this.f429886a;
                if (i16 >= bbVarArr2.length) {
                    break;
                }
                bb bbVar = bbVarArr2[i16];
                if (bbVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bbVar);
                }
                i16++;
            }
        }
        pv4.y yVar = this.f429887b;
        if (yVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, yVar);
        }
        if (!this.f429888c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f429888c);
        }
        if (!this.f429889d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f429889d);
        }
        int i17 = this.f429890e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i17);
        }
        int i18 = this.f429891f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i18);
        }
        if (!this.f429892g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f429892g);
        }
        pv4.u uVar = this.f429893h;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, uVar);
        }
        pv4.u uVar2 = this.f429894i;
        if (uVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, uVar2);
        }
        pv4.u uVar3 = this.f429895j;
        if (uVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, uVar3);
        }
        if (!this.f429896k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f429896k);
        }
        pv4.u uVar4 = this.f429897l;
        if (uVar4 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, uVar4);
        }
        int i19 = this.f429898m;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i19);
        }
        l[] lVarArr = this.f429899n;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.f429899n;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, lVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bb[] bbVarArr = this.f429886a;
        int i3 = 0;
        if (bbVarArr != null && bbVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                bb[] bbVarArr2 = this.f429886a;
                if (i16 >= bbVarArr2.length) {
                    break;
                }
                bb bbVar = bbVarArr2[i16];
                if (bbVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bbVar);
                }
                i16++;
            }
        }
        pv4.y yVar = this.f429887b;
        if (yVar != null) {
            codedOutputByteBufferNano.writeMessage(2, yVar);
        }
        if (!this.f429888c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f429888c);
        }
        if (!this.f429889d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f429889d);
        }
        int i17 = this.f429890e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        int i18 = this.f429891f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i18);
        }
        if (!this.f429892g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f429892g);
        }
        pv4.u uVar = this.f429893h;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(8, uVar);
        }
        pv4.u uVar2 = this.f429894i;
        if (uVar2 != null) {
            codedOutputByteBufferNano.writeMessage(9, uVar2);
        }
        pv4.u uVar3 = this.f429895j;
        if (uVar3 != null) {
            codedOutputByteBufferNano.writeMessage(10, uVar3);
        }
        if (!this.f429896k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f429896k);
        }
        pv4.u uVar4 = this.f429897l;
        if (uVar4 != null) {
            codedOutputByteBufferNano.writeMessage(12, uVar4);
        }
        int i19 = this.f429898m;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i19);
        }
        l[] lVarArr = this.f429899n;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.f429899n;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(14, lVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
