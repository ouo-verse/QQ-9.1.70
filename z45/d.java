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
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public o[] f451898a;

    /* renamed from: b, reason: collision with root package name */
    public int f451899b;

    /* renamed from: c, reason: collision with root package name */
    public int f451900c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f451901d;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f451898a = o.b();
        this.f451899b = 0;
        this.f451900c = 0;
        this.f451901d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f451901d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f451901d, mapFactory, 9, 9, null, 10, 18);
                            }
                        } else {
                            this.f451900c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f451899b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    o[] oVarArr = this.f451898a;
                    if (oVarArr == null) {
                        length = 0;
                    } else {
                        length = oVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    o[] oVarArr2 = new o[i3];
                    if (length != 0) {
                        System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        o oVar = new o();
                        oVarArr2[length] = oVar;
                        codedInputByteBufferNano.readMessage(oVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    o oVar2 = new o();
                    oVarArr2[length] = oVar2;
                    codedInputByteBufferNano.readMessage(oVar2);
                    this.f451898a = oVarArr2;
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
        o[] oVarArr = this.f451898a;
        if (oVarArr != null && oVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                o[] oVarArr2 = this.f451898a;
                if (i3 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i3];
                if (oVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, oVar);
                }
                i3++;
            }
        }
        int i16 = this.f451899b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f451900c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        Map<String, String> map = this.f451901d;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 4, 9, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        o[] oVarArr = this.f451898a;
        if (oVarArr != null && oVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                o[] oVarArr2 = this.f451898a;
                if (i3 >= oVarArr2.length) {
                    break;
                }
                o oVar = oVarArr2[i3];
                if (oVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, oVar);
                }
                i3++;
            }
        }
        int i16 = this.f451899b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f451900c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        Map<String, String> map = this.f451901d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
