package trpcprotocol.feedcloud.sidebar;

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
public final class RedInfo extends Message<RedInfo, a> {
    public static final ProtoAdapter<RedInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int num;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.RedType#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RedType redType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String text;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<RedInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public RedType f437315a = RedType.RED_TYPE_NONE;

        /* renamed from: b, reason: collision with root package name */
        public int f437316b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f437317c = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedInfo build() {
            return new RedInfo(this.f437315a, this.f437316b, this.f437317c, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437316b = i3;
            return this;
        }

        public a c(RedType redType) {
            this.f437315a = redType;
            return this;
        }

        public a d(String str) {
            this.f437317c = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<RedInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RedInfo.class, "type.googleapis.com/trpc.feedcloud.sidebar.RedInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        try {
                            aVar.c(RedType.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                        }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RedInfo redInfo) throws IOException {
            if (!Objects.equals(redInfo.redType, RedType.RED_TYPE_NONE)) {
                RedType.ADAPTER.encodeWithTag(protoWriter, 1, redInfo.redType);
            }
            if (!Objects.equals(Integer.valueOf(redInfo.num), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(redInfo.num));
            }
            if (!Objects.equals(redInfo.text, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, redInfo.text);
            }
            protoWriter.writeBytes(redInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RedInfo redInfo) {
            int i3;
            if (!Objects.equals(redInfo.redType, RedType.RED_TYPE_NONE)) {
                i3 = RedType.ADAPTER.encodedSizeWithTag(1, redInfo.redType) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(redInfo.num), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(redInfo.num));
            }
            if (!Objects.equals(redInfo.text, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, redInfo.text);
            }
            return i3 + redInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RedInfo redact(RedInfo redInfo) {
            a newBuilder = redInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RedInfo(RedType redType, int i3, String str) {
        this(redType, i3, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RedInfo)) {
            return false;
        }
        RedInfo redInfo = (RedInfo) obj;
        if (unknownFields().equals(redInfo.unknownFields()) && Internal.equals(this.redType, redInfo.redType) && Internal.equals(Integer.valueOf(this.num), Integer.valueOf(redInfo.num)) && Internal.equals(this.text, redInfo.text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RedType redType = this.redType;
            int i17 = 0;
            if (redType != null) {
                i3 = redType.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (((hashCode + i3) * 37) + this.num) * 37;
            String str = this.text;
            if (str != null) {
                i17 = str.hashCode();
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
        if (this.redType != null) {
            sb5.append(", redType=");
            sb5.append(this.redType);
        }
        sb5.append(", num=");
        sb5.append(this.num);
        if (this.text != null) {
            sb5.append(", text=");
            sb5.append(Internal.sanitize(this.text));
        }
        StringBuilder replace = sb5.replace(0, 2, "RedInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RedInfo(RedType redType, int i3, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        if (redType != null) {
            this.redType = redType;
            this.num = i3;
            if (str != null) {
                this.text = str;
                return;
            }
            throw new IllegalArgumentException("text == null");
        }
        throw new IllegalArgumentException("redType == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437315a = this.redType;
        aVar.f437316b = this.num;
        aVar.f437317c = this.text;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
