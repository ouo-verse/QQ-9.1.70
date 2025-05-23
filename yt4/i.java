package yt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: k, reason: collision with root package name */
    private static volatile i[] f451209k;

    /* renamed from: a, reason: collision with root package name */
    public int f451210a;

    /* renamed from: b, reason: collision with root package name */
    public int f451211b;

    /* renamed from: c, reason: collision with root package name */
    public int f451212c;

    /* renamed from: d, reason: collision with root package name */
    public String f451213d;

    /* renamed from: e, reason: collision with root package name */
    public String f451214e;

    /* renamed from: f, reason: collision with root package name */
    public int f451215f;

    /* renamed from: g, reason: collision with root package name */
    public String f451216g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f451217h;

    /* renamed from: i, reason: collision with root package name */
    public String f451218i;

    /* renamed from: j, reason: collision with root package name */
    public String f451219j;

    public i() {
        a();
    }

    public static i[] b() {
        if (f451209k == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f451209k == null) {
                    f451209k = new i[0];
                }
            }
        }
        return f451209k;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f451210a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f451211b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f451212c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f451213d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f451214e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f451215f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.f451216g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f451217h = codedInputByteBufferNano.readBool();
                    break;
                case 74:
                    this.f451218i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f451219j = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f451210a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f451211b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f451212c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        if (!this.f451213d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f451213d);
        }
        if (!this.f451214e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f451214e);
        }
        int i18 = this.f451215f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        if (!this.f451216g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f451216g);
        }
        boolean z16 = this.f451217h;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z16);
        }
        if (!this.f451218i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f451218i);
        }
        return !this.f451219j.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f451219j) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f451210a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f451211b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f451212c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!this.f451213d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f451213d);
        }
        if (!this.f451214e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f451214e);
        }
        int i18 = this.f451215f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!this.f451216g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f451216g);
        }
        boolean z16 = this.f451217h;
        if (z16) {
            codedOutputByteBufferNano.writeBool(8, z16);
        }
        if (!this.f451218i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f451218i);
        }
        if (!this.f451219j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f451219j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f451210a = 0;
        this.f451211b = 0;
        this.f451212c = 0;
        this.f451213d = "";
        this.f451214e = "";
        this.f451215f = 0;
        this.f451216g = "";
        this.f451217h = false;
        this.f451218i = "";
        this.f451219j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
