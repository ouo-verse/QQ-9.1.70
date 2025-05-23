package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f427418a;

    /* renamed from: b, reason: collision with root package name */
    public int f427419b;

    /* renamed from: c, reason: collision with root package name */
    public int f427420c;

    /* renamed from: d, reason: collision with root package name */
    public String f427421d;

    /* renamed from: e, reason: collision with root package name */
    public int f427422e;

    /* renamed from: f, reason: collision with root package name */
    public int f427423f;

    /* renamed from: g, reason: collision with root package name */
    public String f427424g;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f427418a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f427419b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f427420c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.f427421d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f427422e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f427423f = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427424g = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f427418a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f427419b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f427420c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        if (!this.f427421d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427421d);
        }
        int i18 = this.f427422e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.f427423f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        return !this.f427424g.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f427424g) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427418a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f427419b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f427420c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!this.f427421d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427421d);
        }
        int i18 = this.f427422e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.f427423f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        if (!this.f427424g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427424g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f427418a = 0;
        this.f427419b = 0;
        this.f427420c = 0;
        this.f427421d = "";
        this.f427422e = 0;
        this.f427423f = 0;
        this.f427424g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
