package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bk extends ExtendableMessageNano<bk> {

    /* renamed from: a, reason: collision with root package name */
    public bi f430075a;

    /* renamed from: b, reason: collision with root package name */
    public pu4.d[] f430076b;

    /* renamed from: c, reason: collision with root package name */
    public e[] f430077c;

    /* renamed from: d, reason: collision with root package name */
    public br f430078d;

    /* renamed from: e, reason: collision with root package name */
    public bi f430079e;

    /* renamed from: f, reason: collision with root package name */
    public bi f430080f;

    /* renamed from: g, reason: collision with root package name */
    public ak f430081g;

    /* renamed from: h, reason: collision with root package name */
    public bi f430082h;

    /* renamed from: i, reason: collision with root package name */
    public String f430083i;

    /* renamed from: j, reason: collision with root package name */
    public bi f430084j;

    /* renamed from: k, reason: collision with root package name */
    public bh[] f430085k;

    public bk() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public bk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f430075a == null) {
                        this.f430075a = new bi();
                    }
                    codedInputByteBufferNano.readMessage(this.f430075a);
                    break;
                case 18:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    pu4.d[] dVarArr = this.f430076b;
                    int length = dVarArr == null ? 0 : dVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    pu4.d[] dVarArr2 = new pu4.d[i3];
                    if (length != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        pu4.d dVar = new pu4.d();
                        dVarArr2[length] = dVar;
                        codedInputByteBufferNano.readMessage(dVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    pu4.d dVar2 = new pu4.d();
                    dVarArr2[length] = dVar2;
                    codedInputByteBufferNano.readMessage(dVar2);
                    this.f430076b = dVarArr2;
                    break;
                case 26:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    e[] eVarArr = this.f430077c;
                    int length2 = eVarArr == null ? 0 : eVarArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    e[] eVarArr2 = new e[i16];
                    if (length2 != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        e eVar = new e();
                        eVarArr2[length2] = eVar;
                        codedInputByteBufferNano.readMessage(eVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    e eVar2 = new e();
                    eVarArr2[length2] = eVar2;
                    codedInputByteBufferNano.readMessage(eVar2);
                    this.f430077c = eVarArr2;
                    break;
                case 34:
                    if (this.f430078d == null) {
                        this.f430078d = new br();
                    }
                    codedInputByteBufferNano.readMessage(this.f430078d);
                    break;
                case 42:
                    if (this.f430079e == null) {
                        this.f430079e = new bi();
                    }
                    codedInputByteBufferNano.readMessage(this.f430079e);
                    break;
                case 50:
                    if (this.f430080f == null) {
                        this.f430080f = new bi();
                    }
                    codedInputByteBufferNano.readMessage(this.f430080f);
                    break;
                case 58:
                    if (this.f430081g == null) {
                        this.f430081g = new ak();
                    }
                    codedInputByteBufferNano.readMessage(this.f430081g);
                    break;
                case 66:
                    if (this.f430082h == null) {
                        this.f430082h = new bi();
                    }
                    codedInputByteBufferNano.readMessage(this.f430082h);
                    break;
                case 74:
                    this.f430083i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.f430084j == null) {
                        this.f430084j = new bi();
                    }
                    codedInputByteBufferNano.readMessage(this.f430084j);
                    break;
                case 90:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    bh[] bhVarArr = this.f430085k;
                    int length3 = bhVarArr == null ? 0 : bhVarArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    bh[] bhVarArr2 = new bh[i17];
                    if (length3 != 0) {
                        System.arraycopy(bhVarArr, 0, bhVarArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        bh bhVar = new bh();
                        bhVarArr2[length3] = bhVar;
                        codedInputByteBufferNano.readMessage(bhVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    bh bhVar2 = new bh();
                    bhVarArr2[length3] = bhVar2;
                    codedInputByteBufferNano.readMessage(bhVar2);
                    this.f430085k = bhVarArr2;
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
        bi biVar = this.f430075a;
        if (biVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, biVar);
        }
        pu4.d[] dVarArr = this.f430076b;
        int i3 = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                pu4.d[] dVarArr2 = this.f430076b;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                pu4.d dVar = dVarArr2[i16];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
                }
                i16++;
            }
        }
        e[] eVarArr = this.f430077c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                e[] eVarArr2 = this.f430077c;
                if (i17 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i17];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
                }
                i17++;
            }
        }
        br brVar = this.f430078d;
        if (brVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, brVar);
        }
        bi biVar2 = this.f430079e;
        if (biVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, biVar2);
        }
        bi biVar3 = this.f430080f;
        if (biVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, biVar3);
        }
        ak akVar = this.f430081g;
        if (akVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, akVar);
        }
        bi biVar4 = this.f430082h;
        if (biVar4 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, biVar4);
        }
        if (!this.f430083i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f430083i);
        }
        bi biVar5 = this.f430084j;
        if (biVar5 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, biVar5);
        }
        bh[] bhVarArr = this.f430085k;
        if (bhVarArr != null && bhVarArr.length > 0) {
            while (true) {
                bh[] bhVarArr2 = this.f430085k;
                if (i3 >= bhVarArr2.length) {
                    break;
                }
                bh bhVar = bhVarArr2[i3];
                if (bhVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, bhVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        bi biVar = this.f430075a;
        if (biVar != null) {
            codedOutputByteBufferNano.writeMessage(1, biVar);
        }
        pu4.d[] dVarArr = this.f430076b;
        int i3 = 0;
        if (dVarArr != null && dVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                pu4.d[] dVarArr2 = this.f430076b;
                if (i16 >= dVarArr2.length) {
                    break;
                }
                pu4.d dVar = dVarArr2[i16];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, dVar);
                }
                i16++;
            }
        }
        e[] eVarArr = this.f430077c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                e[] eVarArr2 = this.f430077c;
                if (i17 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i17];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, eVar);
                }
                i17++;
            }
        }
        br brVar = this.f430078d;
        if (brVar != null) {
            codedOutputByteBufferNano.writeMessage(4, brVar);
        }
        bi biVar2 = this.f430079e;
        if (biVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, biVar2);
        }
        bi biVar3 = this.f430080f;
        if (biVar3 != null) {
            codedOutputByteBufferNano.writeMessage(6, biVar3);
        }
        ak akVar = this.f430081g;
        if (akVar != null) {
            codedOutputByteBufferNano.writeMessage(7, akVar);
        }
        bi biVar4 = this.f430082h;
        if (biVar4 != null) {
            codedOutputByteBufferNano.writeMessage(8, biVar4);
        }
        if (!this.f430083i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f430083i);
        }
        bi biVar5 = this.f430084j;
        if (biVar5 != null) {
            codedOutputByteBufferNano.writeMessage(10, biVar5);
        }
        bh[] bhVarArr = this.f430085k;
        if (bhVarArr != null && bhVarArr.length > 0) {
            while (true) {
                bh[] bhVarArr2 = this.f430085k;
                if (i3 >= bhVarArr2.length) {
                    break;
                }
                bh bhVar = bhVarArr2[i3];
                if (bhVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, bhVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bk a() {
        this.f430075a = null;
        this.f430076b = pu4.d.b();
        this.f430077c = e.b();
        this.f430078d = null;
        this.f430079e = null;
        this.f430080f = null;
        this.f430081g = null;
        this.f430082h = null;
        this.f430083i = "";
        this.f430084j = null;
        this.f430085k = bh.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
