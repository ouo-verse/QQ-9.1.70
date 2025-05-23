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
public final class v extends ExtendableMessageNano<v> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.y[] f430204a;

    /* renamed from: b, reason: collision with root package name */
    public g[] f430205b;

    /* renamed from: c, reason: collision with root package name */
    public gw4.f[] f430206c;

    public v() {
        a();
    }

    public static v c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (v) MessageNano.mergeFrom(new v(), bArr);
    }

    public v a() {
        this.f430204a = pv4.y.b();
        this.f430205b = g.b();
        this.f430206c = gw4.f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public v mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                pv4.y[] yVarArr = this.f430204a;
                int length = yVarArr == null ? 0 : yVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                pv4.y[] yVarArr2 = new pv4.y[i3];
                if (length != 0) {
                    System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    pv4.y yVar = new pv4.y();
                    yVarArr2[length] = yVar;
                    codedInputByteBufferNano.readMessage(yVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pv4.y yVar2 = new pv4.y();
                yVarArr2[length] = yVar2;
                codedInputByteBufferNano.readMessage(yVar2);
                this.f430204a = yVarArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                g[] gVarArr = this.f430205b;
                int length2 = gVarArr == null ? 0 : gVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                g[] gVarArr2 = new g[i16];
                if (length2 != 0) {
                    System.arraycopy(gVarArr, 0, gVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    g gVar = new g();
                    gVarArr2[length2] = gVar;
                    codedInputByteBufferNano.readMessage(gVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                g gVar2 = new g();
                gVarArr2[length2] = gVar2;
                codedInputByteBufferNano.readMessage(gVar2);
                this.f430205b = gVarArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                gw4.f[] fVarArr = this.f430206c;
                int length3 = fVarArr == null ? 0 : fVarArr.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                gw4.f[] fVarArr2 = new gw4.f[i17];
                if (length3 != 0) {
                    System.arraycopy(fVarArr, 0, fVarArr2, 0, length3);
                }
                while (length3 < i17 - 1) {
                    gw4.f fVar = new gw4.f();
                    fVarArr2[length3] = fVar;
                    codedInputByteBufferNano.readMessage(fVar);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                gw4.f fVar2 = new gw4.f();
                fVarArr2[length3] = fVar2;
                codedInputByteBufferNano.readMessage(fVar2);
                this.f430206c = fVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.y[] yVarArr = this.f430204a;
        int i3 = 0;
        if (yVarArr != null && yVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                pv4.y[] yVarArr2 = this.f430204a;
                if (i16 >= yVarArr2.length) {
                    break;
                }
                pv4.y yVar = yVarArr2[i16];
                if (yVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, yVar);
                }
                i16++;
            }
        }
        g[] gVarArr = this.f430205b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                g[] gVarArr2 = this.f430205b;
                if (i17 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i17];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
                }
                i17++;
            }
        }
        gw4.f[] fVarArr = this.f430206c;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                gw4.f[] fVarArr2 = this.f430206c;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                gw4.f fVar = fVarArr2[i3];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.y[] yVarArr = this.f430204a;
        int i3 = 0;
        if (yVarArr != null && yVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                pv4.y[] yVarArr2 = this.f430204a;
                if (i16 >= yVarArr2.length) {
                    break;
                }
                pv4.y yVar = yVarArr2[i16];
                if (yVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, yVar);
                }
                i16++;
            }
        }
        g[] gVarArr = this.f430205b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                g[] gVarArr2 = this.f430205b;
                if (i17 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i17];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, gVar);
                }
                i17++;
            }
        }
        gw4.f[] fVarArr = this.f430206c;
        if (fVarArr != null && fVarArr.length > 0) {
            while (true) {
                gw4.f[] fVarArr2 = this.f430206c;
                if (i3 >= fVarArr2.length) {
                    break;
                }
                gw4.f fVar = fVarArr2[i3];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, fVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
