package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class br extends ExtendableMessageNano<br> {

    /* renamed from: a, reason: collision with root package name */
    public pv4.u f430105a;

    /* renamed from: b, reason: collision with root package name */
    public int f430106b;

    /* renamed from: c, reason: collision with root package name */
    public int f430107c;

    /* renamed from: d, reason: collision with root package name */
    public int f430108d;

    /* renamed from: e, reason: collision with root package name */
    public int f430109e;

    /* renamed from: f, reason: collision with root package name */
    public int f430110f;

    /* renamed from: g, reason: collision with root package name */
    public int f430111g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f430112h;

    /* renamed from: i, reason: collision with root package name */
    public int f430113i;

    public br() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public br mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f430105a == null) {
                    this.f430105a = new pv4.u();
                }
                codedInputByteBufferNano.readMessage(this.f430105a);
            } else if (readTag == 24) {
                this.f430106b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f430107c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f430108d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.f430109e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 64) {
                this.f430110f = codedInputByteBufferNano.readInt32();
            } else if (readTag == 72) {
                this.f430111g = codedInputByteBufferNano.readInt32();
            } else if (readTag == 80) {
                this.f430112h = codedInputByteBufferNano.readBool();
            } else if (readTag != 88) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430113i = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pv4.u uVar = this.f430105a;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, uVar);
        }
        int i3 = this.f430106b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.f430107c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f430108d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.f430109e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        int i19 = this.f430110f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i19);
        }
        int i26 = this.f430111g;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i26);
        }
        boolean z16 = this.f430112h;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z16);
        }
        int i27 = this.f430113i;
        return i27 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i27) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pv4.u uVar = this.f430105a;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(1, uVar);
        }
        int i3 = this.f430106b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.f430107c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f430108d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.f430109e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        int i19 = this.f430110f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i19);
        }
        int i26 = this.f430111g;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i26);
        }
        boolean z16 = this.f430112h;
        if (z16) {
            codedOutputByteBufferNano.writeBool(10, z16);
        }
        int i27 = this.f430113i;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public br a() {
        this.f430105a = null;
        this.f430106b = 0;
        this.f430107c = 0;
        this.f430108d = 0;
        this.f430109e = 0;
        this.f430110f = 0;
        this.f430111g = 0;
        this.f430112h = false;
        this.f430113i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
