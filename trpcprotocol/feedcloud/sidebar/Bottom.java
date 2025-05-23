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
public final class Bottom extends Message<Bottom, a> {
    public static final ProtoAdapter<Bottom> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String schema;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String text;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<Bottom, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437279a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437280b = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bottom build() {
            return new Bottom(this.f437279a, this.f437280b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437280b = str;
            return this;
        }

        public a c(String str) {
            this.f437279a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<Bottom> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Bottom.class, "type.googleapis.com/trpc.feedcloud.sidebar.Bottom", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bottom decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, Bottom bottom) throws IOException {
            if (!Objects.equals(bottom.text, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, bottom.text);
            }
            if (!Objects.equals(bottom.schema, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, bottom.schema);
            }
            protoWriter.writeBytes(bottom.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Bottom bottom) {
            int i3 = 0;
            if (!Objects.equals(bottom.text, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, bottom.text);
            }
            if (!Objects.equals(bottom.schema, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, bottom.schema);
            }
            return i3 + bottom.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Bottom redact(Bottom bottom) {
            a newBuilder = bottom.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Bottom(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bottom)) {
            return false;
        }
        Bottom bottom = (Bottom) obj;
        if (unknownFields().equals(bottom.unknownFields()) && Internal.equals(this.text, bottom.text) && Internal.equals(this.schema, bottom.schema)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.text;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.schema;
            if (str2 != null) {
                i17 = str2.hashCode();
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
        if (this.text != null) {
            sb5.append(", text=");
            sb5.append(Internal.sanitize(this.text));
        }
        if (this.schema != null) {
            sb5.append(", schema=");
            sb5.append(Internal.sanitize(this.schema));
        }
        StringBuilder replace = sb5.replace(0, 2, "Bottom{");
        replace.append('}');
        return replace.toString();
    }

    public Bottom(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.text = str;
            if (str2 != null) {
                this.schema = str2;
                return;
            }
            throw new IllegalArgumentException("schema == null");
        }
        throw new IllegalArgumentException("text == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437279a = this.text;
        aVar.f437280b = this.schema;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
