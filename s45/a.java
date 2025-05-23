package s45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import qu4.h;
import qu4.n;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f433314a;

    /* renamed from: b, reason: collision with root package name */
    public int f433315b;

    /* renamed from: c, reason: collision with root package name */
    public n f433316c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f433317d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f433318e;

    /* renamed from: f, reason: collision with root package name */
    public h f433319f;

    /* renamed from: g, reason: collision with root package name */
    public h f433320g;

    /* renamed from: h, reason: collision with root package name */
    public h f433321h;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f433314a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f433315b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                if (this.f433316c == null) {
                    this.f433316c = new n();
                }
                codedInputByteBufferNano.readMessage(this.f433316c);
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                String[] strArr = this.f433317d;
                int length = strArr == null ? 0 : strArr.length;
                int i3 = repeatedFieldArrayLength + length;
                String[] strArr2 = new String[i3];
                if (length != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length);
                }
                while (length < i3 - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.f433317d = strArr2;
            } else if (readTag == 40) {
                this.f433318e = codedInputByteBufferNano.readBool();
            } else if (readTag == 50) {
                if (this.f433319f == null) {
                    this.f433319f = new h();
                }
                codedInputByteBufferNano.readMessage(this.f433319f);
            } else if (readTag == 58) {
                if (this.f433320g == null) {
                    this.f433320g = new h();
                }
                codedInputByteBufferNano.readMessage(this.f433320g);
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f433321h == null) {
                    this.f433321h = new h();
                }
                codedInputByteBufferNano.readMessage(this.f433321h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f433314a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f433315b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        n nVar = this.f433316c;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, nVar);
        }
        String[] strArr = this.f433317d;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.f433317d;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    i19++;
                    i18 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (i19 * 1);
        }
        boolean z16 = this.f433318e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        h hVar = this.f433319f;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, hVar);
        }
        h hVar2 = this.f433320g;
        if (hVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, hVar2);
        }
        h hVar3 = this.f433321h;
        return hVar3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, hVar3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f433314a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f433315b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        n nVar = this.f433316c;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(3, nVar);
        }
        String[] strArr = this.f433317d;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f433317d;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i17++;
            }
        }
        boolean z16 = this.f433318e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        h hVar = this.f433319f;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(6, hVar);
        }
        h hVar2 = this.f433320g;
        if (hVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, hVar2);
        }
        h hVar3 = this.f433321h;
        if (hVar3 != null) {
            codedOutputByteBufferNano.writeMessage(8, hVar3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f433314a = 0;
        this.f433315b = 0;
        this.f433316c = null;
        this.f433317d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f433318e = false;
        this.f433319f = null;
        this.f433320g = null;
        this.f433321h = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
