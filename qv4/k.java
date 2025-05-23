package qv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public int f430178a;

    /* renamed from: b, reason: collision with root package name */
    public int f430179b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f430180c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f430181d;

    /* renamed from: e, reason: collision with root package name */
    public int f430182e;

    public k() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f430178a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.f430179b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f430180c = codedInputByteBufferNano.readBool();
            } else if (readTag == 32) {
                this.f430181d = codedInputByteBufferNano.readBool();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f430182e = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f430178a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f430179b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        boolean z16 = this.f430180c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        boolean z17 = this.f430181d;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z17);
        }
        int i17 = this.f430182e;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f430178a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f430179b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        boolean z16 = this.f430180c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        boolean z17 = this.f430181d;
        if (z17) {
            codedOutputByteBufferNano.writeBool(4, z17);
        }
        int i17 = this.f430182e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f430178a = 0;
        this.f430179b = 0;
        this.f430180c = false;
        this.f430181d = false;
        this.f430182e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
