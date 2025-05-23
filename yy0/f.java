package yy0;

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
/* loaded from: classes7.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f451442a;

    /* renamed from: b, reason: collision with root package name */
    public int f451443b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f451444c;

    /* renamed from: d, reason: collision with root package name */
    public p f451445d;

    /* renamed from: e, reason: collision with root package name */
    public u f451446e;

    /* renamed from: f, reason: collision with root package name */
    public int f451447f;

    /* renamed from: g, reason: collision with root package name */
    public a f451448g;

    /* renamed from: h, reason: collision with root package name */
    public l f451449h;

    /* renamed from: i, reason: collision with root package name */
    public l f451450i;

    /* renamed from: j, reason: collision with root package name */
    public d f451451j;

    /* renamed from: k, reason: collision with root package name */
    public n f451452k;

    /* renamed from: l, reason: collision with root package name */
    public t f451453l;

    /* renamed from: m, reason: collision with root package name */
    public s f451454m;

    /* renamed from: n, reason: collision with root package name */
    public int f451455n;

    /* renamed from: o, reason: collision with root package name */
    public o f451456o;

    /* renamed from: p, reason: collision with root package name */
    public int f451457p;

    /* renamed from: q, reason: collision with root package name */
    public long f451458q;

    /* renamed from: r, reason: collision with root package name */
    public u f451459r;

    /* renamed from: s, reason: collision with root package name */
    public long f451460s;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f451442a = false;
        this.f451443b = 0;
        this.f451444c = WireFormatNano.EMPTY_BYTES;
        this.f451445d = null;
        this.f451446e = null;
        this.f451447f = 0;
        this.f451448g = null;
        this.f451449h = null;
        this.f451450i = null;
        this.f451451j = null;
        this.f451452k = null;
        this.f451453l = null;
        this.f451454m = null;
        this.f451455n = 0;
        this.f451456o = null;
        this.f451457p = 0;
        this.f451458q = 0L;
        this.f451459r = null;
        this.f451460s = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 24:
                    this.f451442a = codedInputByteBufferNano.readBool();
                    break;
                case 32:
                    this.f451443b = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.f451444c = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    if (this.f451445d == null) {
                        this.f451445d = new p();
                    }
                    codedInputByteBufferNano.readMessage(this.f451445d);
                    break;
                case 58:
                    if (this.f451446e == null) {
                        this.f451446e = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f451446e);
                    break;
                case 64:
                    this.f451447f = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    if (this.f451448g == null) {
                        this.f451448g = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f451448g);
                    break;
                case 82:
                    if (this.f451449h == null) {
                        this.f451449h = new l();
                    }
                    codedInputByteBufferNano.readMessage(this.f451449h);
                    break;
                case 90:
                    if (this.f451450i == null) {
                        this.f451450i = new l();
                    }
                    codedInputByteBufferNano.readMessage(this.f451450i);
                    break;
                case 16386:
                    if (this.f451451j == null) {
                        this.f451451j = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f451451j);
                    break;
                case 16402:
                    if (this.f451452k == null) {
                        this.f451452k = new n();
                    }
                    codedInputByteBufferNano.readMessage(this.f451452k);
                    break;
                case 16410:
                    if (this.f451453l == null) {
                        this.f451453l = new t();
                    }
                    codedInputByteBufferNano.readMessage(this.f451453l);
                    break;
                case 16418:
                    if (this.f451454m == null) {
                        this.f451454m = new s();
                    }
                    codedInputByteBufferNano.readMessage(this.f451454m);
                    break;
                case 16424:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f451455n = readInt32;
                        break;
                    }
                case 16434:
                    if (this.f451456o == null) {
                        this.f451456o = new o();
                    }
                    codedInputByteBufferNano.readMessage(this.f451456o);
                    break;
                case 16440:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f451457p = readInt322;
                        break;
                    }
                case 16448:
                    this.f451458q = codedInputByteBufferNano.readUInt64();
                    break;
                case 16458:
                    if (this.f451459r == null) {
                        this.f451459r = new u();
                    }
                    codedInputByteBufferNano.readMessage(this.f451459r);
                    break;
                case 16464:
                    this.f451460s = codedInputByteBufferNano.readUInt64();
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
        boolean z16 = this.f451442a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        int i3 = this.f451443b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!Arrays.equals(this.f451444c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f451444c);
        }
        p pVar = this.f451445d;
        if (pVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, pVar);
        }
        u uVar = this.f451446e;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, uVar);
        }
        int i16 = this.f451447f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        a aVar = this.f451448g;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, aVar);
        }
        l lVar = this.f451449h;
        if (lVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, lVar);
        }
        l lVar2 = this.f451450i;
        if (lVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, lVar2);
        }
        d dVar = this.f451451j;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2048, dVar);
        }
        n nVar = this.f451452k;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2050, nVar);
        }
        t tVar = this.f451453l;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(GameConst.GAME_RUNTIME_MSG_GAME_ON_SHOW, tVar);
        }
        s sVar = this.f451454m;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2052, sVar);
        }
        int i17 = this.f451455n;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2053, i17);
        }
        o oVar = this.f451456o;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2054, oVar);
        }
        int i18 = this.f451457p;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(GameConst.GAME_RUNTIME_MSG_UPDATE_DOWNLOAD_RESULT, i18);
        }
        long j3 = this.f451458q;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(GameConst.GAME_RUNTIME_MSG_PROFILE_START, j3);
        }
        u uVar2 = this.f451459r;
        if (uVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(GameConst.GAME_RUNTIME_MSG_PROFILE_END, uVar2);
        }
        long j16 = this.f451460s;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2058, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f451442a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        int i3 = this.f451443b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!Arrays.equals(this.f451444c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f451444c);
        }
        p pVar = this.f451445d;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(6, pVar);
        }
        u uVar = this.f451446e;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(7, uVar);
        }
        int i16 = this.f451447f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        a aVar = this.f451448g;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(9, aVar);
        }
        l lVar = this.f451449h;
        if (lVar != null) {
            codedOutputByteBufferNano.writeMessage(10, lVar);
        }
        l lVar2 = this.f451450i;
        if (lVar2 != null) {
            codedOutputByteBufferNano.writeMessage(11, lVar2);
        }
        d dVar = this.f451451j;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2048, dVar);
        }
        n nVar = this.f451452k;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(2050, nVar);
        }
        t tVar = this.f451453l;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(GameConst.GAME_RUNTIME_MSG_GAME_ON_SHOW, tVar);
        }
        s sVar = this.f451454m;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(2052, sVar);
        }
        int i17 = this.f451455n;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2053, i17);
        }
        o oVar = this.f451456o;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(2054, oVar);
        }
        int i18 = this.f451457p;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(GameConst.GAME_RUNTIME_MSG_UPDATE_DOWNLOAD_RESULT, i18);
        }
        long j3 = this.f451458q;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(GameConst.GAME_RUNTIME_MSG_PROFILE_START, j3);
        }
        u uVar2 = this.f451459r;
        if (uVar2 != null) {
            codedOutputByteBufferNano.writeMessage(GameConst.GAME_RUNTIME_MSG_PROFILE_END, uVar2);
        }
        long j16 = this.f451460s;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2058, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
