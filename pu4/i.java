package pu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public String f427453a;

    /* renamed from: b, reason: collision with root package name */
    public String f427454b;

    /* renamed from: c, reason: collision with root package name */
    public String f427455c;

    /* renamed from: d, reason: collision with root package name */
    public String f427456d;

    /* renamed from: e, reason: collision with root package name */
    public String f427457e;

    /* renamed from: f, reason: collision with root package name */
    public String f427458f;

    /* renamed from: g, reason: collision with root package name */
    public String f427459g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f427460h;

    /* renamed from: i, reason: collision with root package name */
    public a f427461i;

    public i() {
        a();
    }

    public i a() {
        this.f427453a = "";
        this.f427454b = "";
        this.f427455c = "";
        this.f427456d = "";
        this.f427457e = "";
        this.f427458f = "";
        this.f427459g = "";
        this.f427460h = false;
        this.f427461i = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f427453a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f427454b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f427455c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f427456d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f427457e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f427458f = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.f427459g = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.f427460h = codedInputByteBufferNano.readBool();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f427461i == null) {
                    this.f427461i = new a();
                }
                codedInputByteBufferNano.readMessage(this.f427461i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427453a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427453a);
        }
        if (!this.f427454b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427454b);
        }
        if (!this.f427455c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427455c);
        }
        if (!this.f427456d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427456d);
        }
        if (!this.f427457e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427457e);
        }
        if (!this.f427458f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427458f);
        }
        if (!this.f427459g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427459g);
        }
        boolean z16 = this.f427460h;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z16);
        }
        a aVar = this.f427461i;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427453a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427453a);
        }
        if (!this.f427454b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427454b);
        }
        if (!this.f427455c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427455c);
        }
        if (!this.f427456d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427456d);
        }
        if (!this.f427457e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427457e);
        }
        if (!this.f427458f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427458f);
        }
        if (!this.f427459g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427459g);
        }
        boolean z16 = this.f427460h;
        if (z16) {
            codedOutputByteBufferNano.writeBool(8, z16);
        }
        a aVar = this.f427461i;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(9, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
