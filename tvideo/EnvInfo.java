package tvideo;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class EnvInfo extends Message<EnvInfo, a> {
    public static final ProtoAdapter<EnvInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String detail;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> metadata;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String user;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<EnvInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437623a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437624b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437625c = "";

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String> f437626d = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnvInfo build() {
            return new EnvInfo(this.f437623a, this.f437624b, this.f437625c, this.f437626d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437625c = str;
            return this;
        }

        public a c(String str) {
            this.f437623a = str;
            return this;
        }

        public a d(String str) {
            this.f437624b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<EnvInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437627a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) EnvInfo.class, "type.googleapis.com/tvideo.EnvInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437627a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437627a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnvInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    protoReader.readUnknownField(nextTag);
                                } else {
                                    aVar.f437626d.putAll(d().decode(protoReader));
                                }
                            } else {
                                aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, EnvInfo envInfo) throws IOException {
            if (!Objects.equals(envInfo.name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, envInfo.name);
            }
            if (!Objects.equals(envInfo.user, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, envInfo.user);
            }
            if (!Objects.equals(envInfo.detail, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, envInfo.detail);
            }
            d().encodeWithTag(protoWriter, 4, envInfo.metadata);
            protoWriter.writeBytes(envInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(EnvInfo envInfo) {
            int i3 = 0;
            if (!Objects.equals(envInfo.name, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, envInfo.name);
            }
            if (!Objects.equals(envInfo.user, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, envInfo.user);
            }
            if (!Objects.equals(envInfo.detail, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, envInfo.detail);
            }
            return i3 + d().encodedSizeWithTag(4, envInfo.metadata) + envInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public EnvInfo redact(EnvInfo envInfo) {
            a newBuilder = envInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public EnvInfo(String str, String str2, String str3, Map<String, String> map) {
        this(str, str2, str3, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EnvInfo)) {
            return false;
        }
        EnvInfo envInfo = (EnvInfo) obj;
        if (unknownFields().equals(envInfo.unknownFields()) && Internal.equals(this.name, envInfo.name) && Internal.equals(this.user, envInfo.user) && Internal.equals(this.detail, envInfo.detail) && this.metadata.equals(envInfo.metadata)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.name;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.user;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str3 = this.detail;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int hashCode2 = ((i26 + i18) * 37) + this.metadata.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.name != null) {
            sb5.append(", name=");
            sb5.append(Internal.sanitize(this.name));
        }
        if (this.user != null) {
            sb5.append(", user=");
            sb5.append(Internal.sanitize(this.user));
        }
        if (this.detail != null) {
            sb5.append(", detail=");
            sb5.append(Internal.sanitize(this.detail));
        }
        if (!this.metadata.isEmpty()) {
            sb5.append(", metadata=");
            sb5.append(this.metadata);
        }
        StringBuilder replace = sb5.replace(0, 2, "EnvInfo{");
        replace.append('}');
        return replace.toString();
    }

    public EnvInfo(String str, String str2, String str3, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.name = str;
            if (str2 != null) {
                this.user = str2;
                if (str3 != null) {
                    this.detail = str3;
                    this.metadata = Internal.immutableCopyOf(TtmlNode.TAG_METADATA, map);
                    return;
                }
                throw new IllegalArgumentException("detail == null");
            }
            throw new IllegalArgumentException("user == null");
        }
        throw new IllegalArgumentException("name == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437623a = this.name;
        aVar.f437624b = this.user;
        aVar.f437625c = this.detail;
        aVar.f437626d = Internal.copyOf(this.metadata);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
