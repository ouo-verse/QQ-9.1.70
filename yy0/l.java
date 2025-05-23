package yy0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public String f451492a;

    /* renamed from: b, reason: collision with root package name */
    public int f451493b;

    /* renamed from: c, reason: collision with root package name */
    public int f451494c;

    /* renamed from: d, reason: collision with root package name */
    public long f451495d;

    /* renamed from: e, reason: collision with root package name */
    public long f451496e;

    /* renamed from: f, reason: collision with root package name */
    public int f451497f;

    /* renamed from: g, reason: collision with root package name */
    public int f451498g;

    /* renamed from: h, reason: collision with root package name */
    public c f451499h;

    /* renamed from: i, reason: collision with root package name */
    public int f451500i;

    /* renamed from: j, reason: collision with root package name */
    public int f451501j;

    /* renamed from: k, reason: collision with root package name */
    public j[] f451502k;

    /* renamed from: l, reason: collision with root package name */
    public int f451503l;

    public l() {
        a();
    }

    public l a() {
        this.f451492a = "";
        this.f451493b = 0;
        this.f451494c = 0;
        this.f451495d = 0L;
        this.f451496e = 0L;
        this.f451497f = 0;
        this.f451498g = 0;
        this.f451499h = null;
        this.f451500i = 0;
        this.f451501j = 0;
        this.f451502k = j.b();
        this.f451503l = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f451492a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f451493b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f451494c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f451495d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f451496e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f451497f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f451498g = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    if (this.f451499h == null) {
                        this.f451499h = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f451499h);
                    break;
                case 72:
                    this.f451500i = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f451501j = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    j[] jVarArr = this.f451502k;
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
                    this.f451502k = jVarArr2;
                    break;
                case 96:
                    this.f451503l = codedInputByteBufferNano.readUInt32();
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
        if (!this.f451492a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f451492a);
        }
        int i3 = this.f451493b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f451494c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long j3 = this.f451495d;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j16 = this.f451496e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        int i17 = this.f451497f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.f451498g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        c cVar = this.f451499h;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, cVar);
        }
        int i19 = this.f451500i;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        int i26 = this.f451501j;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        j[] jVarArr = this.f451502k;
        if (jVarArr != null && jVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                j[] jVarArr2 = this.f451502k;
                if (i27 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i27];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, jVar);
                }
                i27++;
            }
        }
        int i28 = this.f451503l;
        if (i28 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(12, i28);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f451492a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f451492a);
        }
        int i3 = this.f451493b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f451494c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long j3 = this.f451495d;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j16 = this.f451496e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        int i17 = this.f451497f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.f451498g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        c cVar = this.f451499h;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(8, cVar);
        }
        int i19 = this.f451500i;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        int i26 = this.f451501j;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i26);
        }
        j[] jVarArr = this.f451502k;
        if (jVarArr != null && jVarArr.length > 0) {
            int i27 = 0;
            while (true) {
                j[] jVarArr2 = this.f451502k;
                if (i27 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i27];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, jVar);
                }
                i27++;
            }
        }
        int i28 = this.f451503l;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i28);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
