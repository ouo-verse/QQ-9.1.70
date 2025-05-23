package rt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile u[] f432449g;

    /* renamed from: a, reason: collision with root package name */
    public hs4.t f432450a;

    /* renamed from: b, reason: collision with root package name */
    public l[] f432451b;

    /* renamed from: c, reason: collision with root package name */
    public String f432452c;

    /* renamed from: d, reason: collision with root package name */
    public c f432453d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f432454e;

    /* renamed from: f, reason: collision with root package name */
    public w f432455f;

    public u() {
        a();
    }

    public static u[] b() {
        if (f432449g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f432449g == null) {
                    f432449g = new u[0];
                }
            }
        }
        return f432449g;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f432450a == null) {
                    this.f432450a = new hs4.t();
                }
                codedInputByteBufferNano.readMessage(this.f432450a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                l[] lVarArr = this.f432451b;
                int length = lVarArr == null ? 0 : lVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                l[] lVarArr2 = new l[i3];
                if (length != 0) {
                    System.arraycopy(lVarArr, 0, lVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    l lVar = new l();
                    lVarArr2[length] = lVar;
                    codedInputByteBufferNano.readMessage(lVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                l lVar2 = new l();
                lVarArr2[length] = lVar2;
                codedInputByteBufferNano.readMessage(lVar2);
                this.f432451b = lVarArr2;
            } else if (readTag == 26) {
                this.f432452c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.f432453d == null) {
                    this.f432453d = new c();
                }
                codedInputByteBufferNano.readMessage(this.f432453d);
            } else if (readTag == 40) {
                this.f432454e = codedInputByteBufferNano.readBool();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f432455f == null) {
                    this.f432455f = new w();
                }
                codedInputByteBufferNano.readMessage(this.f432455f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        hs4.t tVar = this.f432450a;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, tVar);
        }
        l[] lVarArr = this.f432451b;
        if (lVarArr != null && lVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                l[] lVarArr2 = this.f432451b;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, lVar);
                }
                i3++;
            }
        }
        if (!this.f432452c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f432452c);
        }
        c cVar = this.f432453d;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
        }
        boolean z16 = this.f432454e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        w wVar = this.f432455f;
        return wVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, wVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        hs4.t tVar = this.f432450a;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(1, tVar);
        }
        l[] lVarArr = this.f432451b;
        if (lVarArr != null && lVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                l[] lVarArr2 = this.f432451b;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, lVar);
                }
                i3++;
            }
        }
        if (!this.f432452c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f432452c);
        }
        c cVar = this.f432453d;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(4, cVar);
        }
        boolean z16 = this.f432454e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        w wVar = this.f432455f;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(6, wVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public u a() {
        this.f432450a = null;
        this.f432451b = l.b();
        this.f432452c = "";
        this.f432453d = null;
        this.f432454e = false;
        this.f432455f = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
