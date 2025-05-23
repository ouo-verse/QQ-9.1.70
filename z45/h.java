package z45;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public int f451912a;

    /* renamed from: b, reason: collision with root package name */
    public y45.b[] f451913b;

    /* renamed from: c, reason: collision with root package name */
    public int f451914c;

    /* renamed from: d, reason: collision with root package name */
    public y45.o f451915d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f451916e;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    public h a() {
        this.f451912a = 0;
        this.f451913b = y45.b.b();
        this.f451914c = 0;
        this.f451915d = null;
        this.f451916e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f451916e = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f451916e, mapFactory, 9, 9, null, 10, 18);
                                }
                            } else {
                                if (this.f451915d == null) {
                                    this.f451915d = new y45.o();
                                }
                                codedInputByteBufferNano.readMessage(this.f451915d);
                            }
                        } else {
                            this.f451914c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        y45.b[] bVarArr = this.f451913b;
                        if (bVarArr == null) {
                            length = 0;
                        } else {
                            length = bVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        y45.b[] bVarArr2 = new y45.b[i3];
                        if (length != 0) {
                            System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            y45.b bVar = new y45.b();
                            bVarArr2[length] = bVar;
                            codedInputByteBufferNano.readMessage(bVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        y45.b bVar2 = new y45.b();
                        bVarArr2[length] = bVar2;
                        codedInputByteBufferNano.readMessage(bVar2);
                        this.f451913b = bVarArr2;
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                        this.f451912a = readInt32;
                    }
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
        int i3 = this.f451912a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        y45.b[] bVarArr = this.f451913b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f451913b;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f451914c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        y45.o oVar = this.f451915d;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, oVar);
        }
        Map<String, String> map = this.f451916e;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 5, 9, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451912a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        y45.b[] bVarArr = this.f451913b;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f451913b;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f451914c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        y45.o oVar = this.f451915d;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(4, oVar);
        }
        Map<String, String> map = this.f451916e;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 5, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
