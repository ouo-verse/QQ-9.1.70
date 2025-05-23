package rt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.qqmini.minigame.GameConst;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f432287a;

    /* renamed from: b, reason: collision with root package name */
    public int f432288b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f432289c;

    /* renamed from: d, reason: collision with root package name */
    public ac f432290d;

    /* renamed from: e, reason: collision with root package name */
    public ah f432291e;

    /* renamed from: f, reason: collision with root package name */
    public int f432292f;

    /* renamed from: g, reason: collision with root package name */
    public a f432293g;

    /* renamed from: h, reason: collision with root package name */
    public w f432294h;

    /* renamed from: i, reason: collision with root package name */
    public w f432295i;

    /* renamed from: j, reason: collision with root package name */
    public d f432296j;

    /* renamed from: k, reason: collision with root package name */
    public z f432297k;

    /* renamed from: l, reason: collision with root package name */
    public ag f432298l;

    /* renamed from: m, reason: collision with root package name */
    public af f432299m;

    /* renamed from: n, reason: collision with root package name */
    public int f432300n;

    /* renamed from: o, reason: collision with root package name */
    public ab f432301o;

    /* renamed from: p, reason: collision with root package name */
    public aa f432302p;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    public h a() {
        this.f432287a = false;
        this.f432288b = 0;
        this.f432289c = WireFormatNano.EMPTY_BYTES;
        this.f432290d = null;
        this.f432291e = null;
        this.f432292f = 0;
        this.f432293g = null;
        this.f432294h = null;
        this.f432295i = null;
        this.f432296j = null;
        this.f432297k = null;
        this.f432298l = null;
        this.f432299m = null;
        this.f432300n = 0;
        this.f432301o = null;
        this.f432302p = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 24:
                    this.f432287a = codedInputByteBufferNano.readBool();
                    break;
                case 32:
                    this.f432288b = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f432289c = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    if (this.f432290d == null) {
                        this.f432290d = new ac();
                    }
                    codedInputByteBufferNano.readMessage(this.f432290d);
                    break;
                case 58:
                    if (this.f432291e == null) {
                        this.f432291e = new ah();
                    }
                    codedInputByteBufferNano.readMessage(this.f432291e);
                    break;
                case 64:
                    this.f432292f = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    if (this.f432293g == null) {
                        this.f432293g = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f432293g);
                    break;
                case 82:
                    if (this.f432294h == null) {
                        this.f432294h = new w();
                    }
                    codedInputByteBufferNano.readMessage(this.f432294h);
                    break;
                case 90:
                    if (this.f432295i == null) {
                        this.f432295i = new w();
                    }
                    codedInputByteBufferNano.readMessage(this.f432295i);
                    break;
                case 16386:
                    if (this.f432296j == null) {
                        this.f432296j = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f432296j);
                    break;
                case 16402:
                    if (this.f432297k == null) {
                        this.f432297k = new z();
                    }
                    codedInputByteBufferNano.readMessage(this.f432297k);
                    break;
                case 16410:
                    if (this.f432298l == null) {
                        this.f432298l = new ag();
                    }
                    codedInputByteBufferNano.readMessage(this.f432298l);
                    break;
                case 16418:
                    if (this.f432299m == null) {
                        this.f432299m = new af();
                    }
                    codedInputByteBufferNano.readMessage(this.f432299m);
                    break;
                case 16424:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f432300n = readInt32;
                        break;
                    }
                case 16434:
                    if (this.f432301o == null) {
                        this.f432301o = new ab();
                    }
                    codedInputByteBufferNano.readMessage(this.f432301o);
                    break;
                case 16442:
                    if (this.f432302p == null) {
                        this.f432302p = new aa();
                    }
                    codedInputByteBufferNano.readMessage(this.f432302p);
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
        boolean z16 = this.f432287a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        int i3 = this.f432288b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!Arrays.equals(this.f432289c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f432289c);
        }
        ac acVar = this.f432290d;
        if (acVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, acVar);
        }
        ah ahVar = this.f432291e;
        if (ahVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, ahVar);
        }
        int i16 = this.f432292f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        a aVar = this.f432293g;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, aVar);
        }
        w wVar = this.f432294h;
        if (wVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, wVar);
        }
        w wVar2 = this.f432295i;
        if (wVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, wVar2);
        }
        d dVar = this.f432296j;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2048, dVar);
        }
        z zVar = this.f432297k;
        if (zVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2050, zVar);
        }
        ag agVar = this.f432298l;
        if (agVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(GameConst.GAME_RUNTIME_MSG_GAME_ON_SHOW, agVar);
        }
        af afVar = this.f432299m;
        if (afVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2052, afVar);
        }
        int i17 = this.f432300n;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2053, i17);
        }
        ab abVar = this.f432301o;
        if (abVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2054, abVar);
        }
        aa aaVar = this.f432302p;
        if (aaVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(GameConst.GAME_RUNTIME_MSG_UPDATE_DOWNLOAD_RESULT, aaVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f432287a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        int i3 = this.f432288b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!Arrays.equals(this.f432289c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f432289c);
        }
        ac acVar = this.f432290d;
        if (acVar != null) {
            codedOutputByteBufferNano.writeMessage(6, acVar);
        }
        ah ahVar = this.f432291e;
        if (ahVar != null) {
            codedOutputByteBufferNano.writeMessage(7, ahVar);
        }
        int i16 = this.f432292f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        a aVar = this.f432293g;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(9, aVar);
        }
        w wVar = this.f432294h;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(10, wVar);
        }
        w wVar2 = this.f432295i;
        if (wVar2 != null) {
            codedOutputByteBufferNano.writeMessage(11, wVar2);
        }
        d dVar = this.f432296j;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2048, dVar);
        }
        z zVar = this.f432297k;
        if (zVar != null) {
            codedOutputByteBufferNano.writeMessage(2050, zVar);
        }
        ag agVar = this.f432298l;
        if (agVar != null) {
            codedOutputByteBufferNano.writeMessage(GameConst.GAME_RUNTIME_MSG_GAME_ON_SHOW, agVar);
        }
        af afVar = this.f432299m;
        if (afVar != null) {
            codedOutputByteBufferNano.writeMessage(2052, afVar);
        }
        int i17 = this.f432300n;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2053, i17);
        }
        ab abVar = this.f432301o;
        if (abVar != null) {
            codedOutputByteBufferNano.writeMessage(2054, abVar);
        }
        aa aaVar = this.f432302p;
        if (aaVar != null) {
            codedOutputByteBufferNano.writeMessage(GameConst.GAME_RUNTIME_MSG_UPDATE_DOWNLOAD_RESULT, aaVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
