package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bp extends ExtendableMessageNano<bp> {

    /* renamed from: i, reason: collision with root package name */
    private static volatile bp[] f430093i;

    /* renamed from: a, reason: collision with root package name */
    public pu4.g f430094a;

    /* renamed from: b, reason: collision with root package name */
    public pu4.g f430095b;

    /* renamed from: c, reason: collision with root package name */
    public String f430096c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f430097d;

    /* renamed from: e, reason: collision with root package name */
    public int f430098e;

    /* renamed from: f, reason: collision with root package name */
    public pu4.g f430099f;

    /* renamed from: g, reason: collision with root package name */
    public pu4.g f430100g;

    /* renamed from: h, reason: collision with root package name */
    public pu4.g f430101h;

    public bp() {
        a();
    }

    public static bp[] b() {
        if (f430093i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430093i == null) {
                    f430093i = new bp[0];
                }
            }
        }
        return f430093i;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430094a == null) {
                    this.f430094a = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430094a);
            } else if (readTag == 18) {
                if (this.f430095b == null) {
                    this.f430095b = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430095b);
            } else if (readTag == 34) {
                this.f430096c = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                String[] strArr = this.f430097d;
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
                this.f430097d = strArr2;
            } else if (readTag == 48) {
                this.f430098e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 58) {
                if (this.f430099f == null) {
                    this.f430099f = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430099f);
            } else if (readTag == 66) {
                if (this.f430100g == null) {
                    this.f430100g = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430100g);
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f430101h == null) {
                    this.f430101h = new pu4.g();
                }
                codedInputByteBufferNano.readMessage(this.f430101h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pu4.g gVar = this.f430094a;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
        }
        pu4.g gVar2 = this.f430095b;
        if (gVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar2);
        }
        if (!this.f430096c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430096c);
        }
        String[] strArr = this.f430097d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f430097d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i17++;
                    i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (i17 * 1);
        }
        int i18 = this.f430098e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i18);
        }
        pu4.g gVar3 = this.f430099f;
        if (gVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, gVar3);
        }
        pu4.g gVar4 = this.f430100g;
        if (gVar4 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, gVar4);
        }
        pu4.g gVar5 = this.f430101h;
        return gVar5 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, gVar5) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pu4.g gVar = this.f430094a;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(1, gVar);
        }
        pu4.g gVar2 = this.f430095b;
        if (gVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar2);
        }
        if (!this.f430096c.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430096c);
        }
        String[] strArr = this.f430097d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f430097d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(5, str);
                }
                i3++;
            }
        }
        int i16 = this.f430098e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        pu4.g gVar3 = this.f430099f;
        if (gVar3 != null) {
            codedOutputByteBufferNano.writeMessage(7, gVar3);
        }
        pu4.g gVar4 = this.f430100g;
        if (gVar4 != null) {
            codedOutputByteBufferNano.writeMessage(8, gVar4);
        }
        pu4.g gVar5 = this.f430101h;
        if (gVar5 != null) {
            codedOutputByteBufferNano.writeMessage(9, gVar5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public bp a() {
        this.f430094a = null;
        this.f430095b = null;
        this.f430096c = "";
        this.f430097d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f430098e = 0;
        this.f430099f = null;
        this.f430100g = null;
        this.f430101h = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
