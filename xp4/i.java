package xp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: f, reason: collision with root package name */
    private static volatile i[] f448333f;

    /* renamed from: a, reason: collision with root package name */
    public int f448334a;

    /* renamed from: b, reason: collision with root package name */
    public String f448335b;

    /* renamed from: c, reason: collision with root package name */
    public String f448336c;

    /* renamed from: d, reason: collision with root package name */
    public np4.e f448337d;

    /* renamed from: e, reason: collision with root package name */
    public String f448338e;

    public i() {
        a();
    }

    public static i[] b() {
        if (f448333f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f448333f == null) {
                    f448333f = new i[0];
                }
            }
        }
        return f448333f;
    }

    public i a() {
        this.f448334a = 0;
        this.f448335b = "";
        this.f448336c = "";
        this.f448337d = null;
        this.f448338e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f448338e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                if (this.f448337d == null) {
                                    this.f448337d = new np4.e();
                                }
                                codedInputByteBufferNano.readMessage(this.f448337d);
                            }
                        } else {
                            this.f448336c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f448335b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f448334a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f448334a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f448335b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f448335b);
        }
        if (!this.f448336c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f448336c);
        }
        np4.e eVar = this.f448337d;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, eVar);
        }
        if (!this.f448338e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f448338e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f448334a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f448335b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f448335b);
        }
        if (!this.f448336c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f448336c);
        }
        np4.e eVar = this.f448337d;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(4, eVar);
        }
        if (!this.f448338e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f448338e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
