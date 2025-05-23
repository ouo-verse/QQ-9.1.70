package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class as extends ExtendableMessageNano<as> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile as[] f430000f;

    /* renamed from: a, reason: collision with root package name */
    public int f430001a;

    /* renamed from: b, reason: collision with root package name */
    public String f430002b;

    /* renamed from: c, reason: collision with root package name */
    public int f430003c;

    /* renamed from: d, reason: collision with root package name */
    public String f430004d;

    /* renamed from: e, reason: collision with root package name */
    public pv4.f[] f430005e;

    public as() {
        a();
    }

    public static as[] b() {
        if (f430000f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f430000f == null) {
                    f430000f = new as[0];
                }
            }
        }
        return f430000f;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public as mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430001a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.f430002b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f430003c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f430004d = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                pv4.f[] fVarArr = this.f430005e;
                int length = fVarArr == null ? 0 : fVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pv4.f[] fVarArr2 = new pv4.f[i3];
                if (length != 0) {
                    System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pv4.f fVar = new pv4.f();
                    fVarArr2[length] = fVar;
                    codedInputByteBufferNano.readMessage(fVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pv4.f fVar2 = new pv4.f();
                fVarArr2[length] = fVar2;
                codedInputByteBufferNano.readMessage(fVar2);
                this.f430005e = fVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f430001a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f430002b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f430002b);
        }
        int i16 = this.f430003c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        if (!this.f430004d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f430004d);
        }
        pv4.f[] fVarArr = this.f430005e;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                pv4.f[] fVarArr2 = this.f430005e;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                pv4.f fVar = fVarArr2[i17];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, fVar);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f430001a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f430002b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f430002b);
        }
        int i16 = this.f430003c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        if (!this.f430004d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f430004d);
        }
        pv4.f[] fVarArr = this.f430005e;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                pv4.f[] fVarArr2 = this.f430005e;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                pv4.f fVar = fVarArr2[i17];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, fVar);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public as a() {
        this.f430001a = 0;
        this.f430002b = "";
        this.f430003c = 0;
        this.f430004d = "";
        this.f430005e = pv4.f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
