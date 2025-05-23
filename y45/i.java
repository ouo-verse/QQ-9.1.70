package y45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile i[] f449402h;

    /* renamed from: a, reason: collision with root package name */
    public int f449403a;

    /* renamed from: b, reason: collision with root package name */
    public int f449404b;

    /* renamed from: c, reason: collision with root package name */
    public String f449405c;

    /* renamed from: d, reason: collision with root package name */
    public j[] f449406d;

    /* renamed from: e, reason: collision with root package name */
    public String f449407e;

    /* renamed from: f, reason: collision with root package name */
    public String f449408f;

    /* renamed from: g, reason: collision with root package name */
    public String f449409g;

    public i() {
        a();
    }

    public static i[] b() {
        if (f449402h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f449402h == null) {
                    f449402h = new i[0];
                }
            }
        }
        return f449402h;
    }

    public i a() {
        this.f449403a = 0;
        this.f449404b = 0;
        this.f449405c = "";
        this.f449406d = j.b();
        this.f449407e = "";
        this.f449408f = "";
        this.f449409g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f449409g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f449408f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f449407e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                j[] jVarArr = this.f449406d;
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
                                this.f449406d = jVarArr2;
                            }
                        } else {
                            this.f449405c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f449404b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f449403a = codedInputByteBufferNano.readUInt32();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f449403a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f449404b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f449405c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f449405c);
        }
        j[] jVarArr = this.f449406d;
        if (jVarArr != null && jVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                j[] jVarArr2 = this.f449406d;
                if (i17 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i17];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, jVar);
                }
                i17++;
            }
        }
        if (!this.f449407e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f449407e);
        }
        if (!this.f449408f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f449408f);
        }
        if (!this.f449409g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f449409g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f449403a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f449404b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f449405c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f449405c);
        }
        j[] jVarArr = this.f449406d;
        if (jVarArr != null && jVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                j[] jVarArr2 = this.f449406d;
                if (i17 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i17];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, jVar);
                }
                i17++;
            }
        }
        if (!this.f449407e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f449407e);
        }
        if (!this.f449408f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f449408f);
        }
        if (!this.f449409g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f449409g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
