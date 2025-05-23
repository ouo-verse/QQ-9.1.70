package uv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class bn extends ExtendableMessageNano<bn> {

    /* renamed from: h, reason: collision with root package name */
    private static volatile bn[] f440375h;

    /* renamed from: a, reason: collision with root package name */
    public String f440376a;

    /* renamed from: b, reason: collision with root package name */
    public String f440377b;

    /* renamed from: c, reason: collision with root package name */
    public String f440378c;

    /* renamed from: d, reason: collision with root package name */
    public String f440379d;

    /* renamed from: e, reason: collision with root package name */
    public int f440380e;

    /* renamed from: f, reason: collision with root package name */
    public String f440381f;

    /* renamed from: g, reason: collision with root package name */
    public az f440382g;

    public bn() {
        a();
    }

    public static bn[] b() {
        if (f440375h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f440375h == null) {
                    f440375h = new bn[0];
                }
            }
        }
        return f440375h;
    }

    public bn a() {
        this.f440376a = "";
        this.f440377b = "";
        this.f440378c = "";
        this.f440379d = "";
        this.f440380e = 0;
        this.f440381f = "";
        this.f440382g = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public bn mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f440376a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f440377b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f440378c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f440379d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f440380e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 50) {
                this.f440381f = codedInputByteBufferNano.readString();
            } else if (readTag != 58) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f440382g == null) {
                    this.f440382g = new az();
                }
                codedInputByteBufferNano.readMessage(this.f440382g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f440376a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f440376a);
        }
        if (!this.f440377b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f440377b);
        }
        if (!this.f440378c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f440378c);
        }
        if (!this.f440379d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f440379d);
        }
        int i3 = this.f440380e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        if (!this.f440381f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f440381f);
        }
        az azVar = this.f440382g;
        return azVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, azVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f440376a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f440376a);
        }
        if (!this.f440377b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f440377b);
        }
        if (!this.f440378c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f440378c);
        }
        if (!this.f440379d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f440379d);
        }
        int i3 = this.f440380e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        if (!this.f440381f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f440381f);
        }
        az azVar = this.f440382g;
        if (azVar != null) {
            codedOutputByteBufferNano.writeMessage(7, azVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
