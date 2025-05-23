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
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public y45.b[] f451905a;

    /* renamed from: b, reason: collision with root package name */
    public int f451906b;

    /* renamed from: c, reason: collision with root package name */
    public y45.o f451907c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f451908d;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f451905a = y45.b.b();
        this.f451906b = 0;
        this.f451907c = null;
        this.f451908d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f451908d = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f451908d, mapFactory, 9, 9, null, 10, 18);
                            }
                        } else {
                            if (this.f451907c == null) {
                                this.f451907c = new y45.o();
                            }
                            codedInputByteBufferNano.readMessage(this.f451907c);
                        }
                    } else {
                        this.f451906b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    y45.b[] bVarArr = this.f451905a;
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
                    this.f451905a = bVarArr2;
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
        y45.b[] bVarArr = this.f451905a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f451905a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i3++;
            }
        }
        int i16 = this.f451906b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        y45.o oVar = this.f451907c;
        if (oVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, oVar);
        }
        Map<String, String> map = this.f451908d;
        if (map != null) {
            return computeSerializedSize + InternalNano.computeMapFieldSize(map, 4, 9, 9);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        y45.b[] bVarArr = this.f451905a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                y45.b[] bVarArr2 = this.f451905a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                y45.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i3++;
            }
        }
        int i16 = this.f451906b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        y45.o oVar = this.f451907c;
        if (oVar != null) {
            codedOutputByteBufferNano.writeMessage(3, oVar);
        }
        Map<String, String> map = this.f451908d;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
