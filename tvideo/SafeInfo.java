package tvideo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class SafeInfo extends Message<SafeInfo, a> {
    public static final ProtoAdapter<SafeInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "safeKey", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String safe_key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", jsonName = "safeResult", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final ByteString safe_result;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int type;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<SafeInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437767a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437768b = "";

        /* renamed from: c, reason: collision with root package name */
        public ByteString f437769c = ByteString.EMPTY;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SafeInfo build() {
            return new SafeInfo(this.f437767a, this.f437768b, this.f437769c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437768b = str;
            return this;
        }

        public a c(ByteString byteString) {
            this.f437769c = byteString;
            return this;
        }

        public a d(int i3) {
            this.f437767a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<SafeInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SafeInfo.class, "type.googleapis.com/tvideo.SafeInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SafeInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                protoReader.readUnknownField(nextTag);
                            } else {
                                aVar.c(ProtoAdapter.BYTES.decode(protoReader));
                            }
                        } else {
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SafeInfo safeInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(safeInfo.type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(safeInfo.type));
            }
            if (!Objects.equals(safeInfo.safe_key, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, safeInfo.safe_key);
            }
            if (!Objects.equals(safeInfo.safe_result, ByteString.EMPTY)) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 3, safeInfo.safe_result);
            }
            protoWriter.writeBytes(safeInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SafeInfo safeInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(safeInfo.type), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(safeInfo.type));
            }
            if (!Objects.equals(safeInfo.safe_key, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, safeInfo.safe_key);
            }
            if (!Objects.equals(safeInfo.safe_result, ByteString.EMPTY)) {
                i3 += ProtoAdapter.BYTES.encodedSizeWithTag(3, safeInfo.safe_result);
            }
            return i3 + safeInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SafeInfo redact(SafeInfo safeInfo) {
            a newBuilder = safeInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SafeInfo(int i3, String str, ByteString byteString) {
        this(i3, str, byteString, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeInfo)) {
            return false;
        }
        SafeInfo safeInfo = (SafeInfo) obj;
        if (unknownFields().equals(safeInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.type), Integer.valueOf(safeInfo.type)) && Internal.equals(this.safe_key, safeInfo.safe_key) && Internal.equals(this.safe_result, safeInfo.safe_result)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.type) * 37;
            String str = this.safe_key;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            ByteString byteString = this.safe_result;
            if (byteString != null) {
                i17 = byteString.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", type=");
        sb5.append(this.type);
        if (this.safe_key != null) {
            sb5.append(", safe_key=");
            sb5.append(Internal.sanitize(this.safe_key));
        }
        if (this.safe_result != null) {
            sb5.append(", safe_result=");
            sb5.append(this.safe_result);
        }
        StringBuilder replace = sb5.replace(0, 2, "SafeInfo{");
        replace.append('}');
        return replace.toString();
    }

    public SafeInfo(int i3, String str, ByteString byteString, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.type = i3;
        if (str != null) {
            this.safe_key = str;
            if (byteString != null) {
                this.safe_result = byteString;
                return;
            }
            throw new IllegalArgumentException("safe_result == null");
        }
        throw new IllegalArgumentException("safe_key == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437767a = this.type;
        aVar.f437768b = this.safe_key;
        aVar.f437769c = this.safe_result;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
