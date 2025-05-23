package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class at extends ExtendableMessageNano<at> {

    /* renamed from: a, reason: collision with root package name */
    public String f440223a;

    /* renamed from: b, reason: collision with root package name */
    public String f440224b;

    /* renamed from: c, reason: collision with root package name */
    public String f440225c;

    /* renamed from: d, reason: collision with root package name */
    public int f440226d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f440227e;

    /* renamed from: f, reason: collision with root package name */
    public int f440228f;

    /* renamed from: g, reason: collision with root package name */
    public String f440229g;

    /* renamed from: h, reason: collision with root package name */
    public int f440230h;

    /* renamed from: i, reason: collision with root package name */
    public String f440231i;

    public at() {
        a();
    }

    public at a() {
        this.f440223a = "";
        this.f440224b = "";
        this.f440225c = "";
        this.f440226d = 0;
        this.f440227e = false;
        this.f440228f = 0;
        this.f440229g = "";
        this.f440230h = 0;
        this.f440231i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public at mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440223a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440224b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f440225c = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.f440226d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.f440227e = codedInputByteBufferNano.readBool();
            } else if (readTag == 48) {
                this.f440228f = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 58) {
                this.f440229g = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.f440230h = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 74) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f440231i = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440223a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440223a);
        }
        if (!this.f440224b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440224b);
        }
        if (!this.f440225c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440225c);
        }
        int i3 = this.f440226d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        boolean z16 = this.f440227e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        int i16 = this.f440228f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        if (!this.f440229g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f440229g);
        }
        int i17 = this.f440230h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        return !this.f440231i.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f440231i) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440223a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440223a);
        }
        if (!this.f440224b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440224b);
        }
        if (!this.f440225c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440225c);
        }
        int i3 = this.f440226d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        boolean z16 = this.f440227e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        int i16 = this.f440228f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        if (!this.f440229g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f440229g);
        }
        int i17 = this.f440230h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.f440231i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f440231i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
