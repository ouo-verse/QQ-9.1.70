package qt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f429532a;

    /* renamed from: b, reason: collision with root package name */
    public h[] f429533b;

    /* renamed from: c, reason: collision with root package name */
    public int f429534c;

    /* renamed from: d, reason: collision with root package name */
    public int f429535d;

    /* renamed from: e, reason: collision with root package name */
    public int f429536e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f429537f;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f429532a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                h[] hVarArr = this.f429533b;
                int length = hVarArr == null ? 0 : hVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                h[] hVarArr2 = new h[i3];
                if (length != 0) {
                    System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    h hVar = new h();
                    hVarArr2[length] = hVar;
                    codedInputByteBufferNano.readMessage(hVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                h hVar2 = new h();
                hVarArr2[length] = hVar2;
                codedInputByteBufferNano.readMessage(hVar2);
                this.f429533b = hVarArr2;
            } else if (readTag == 24) {
                this.f429534c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f429535d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 80) {
                this.f429536e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 90) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f429537f = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f429532a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        h[] hVarArr = this.f429533b;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f429533b;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, hVar);
                }
                i16++;
            }
        }
        int i17 = this.f429534c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.f429535d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.f429536e;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i19);
        }
        return !Arrays.equals(this.f429537f, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(11, this.f429537f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f429532a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        h[] hVarArr = this.f429533b;
        if (hVarArr != null && hVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                h[] hVarArr2 = this.f429533b;
                if (i16 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i16];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, hVar);
                }
                i16++;
            }
        }
        int i17 = this.f429534c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.f429535d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.f429536e;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        if (!Arrays.equals(this.f429537f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(11, this.f429537f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f429532a = 0;
        this.f429533b = h.b();
        this.f429534c = 0;
        this.f429535d = 0;
        this.f429536e = 0;
        this.f429537f = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
