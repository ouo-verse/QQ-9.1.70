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
public final class VersionInfo extends Message<VersionInfo, a> {
    public static final ProtoAdapter<VersionInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "appId", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String app_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "channelId", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String channel_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int platform;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "platformVersion", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String platform_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "versionCode", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String version_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "versionName", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String version_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "vnviewPkgVersion", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final int vnview_pkg_version;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<VersionInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437793a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437794b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f437795c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f437796d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437797e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f437798f = "";

        /* renamed from: g, reason: collision with root package name */
        public int f437799g = 0;

        public a a(String str) {
            this.f437798f = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VersionInfo build() {
            return new VersionInfo(this.f437793a, this.f437794b, this.f437795c, this.f437796d, this.f437797e, this.f437798f, this.f437799g, super.buildUnknownFields());
        }

        public a c(String str) {
            this.f437797e = str;
            return this;
        }

        public a d(int i3) {
            this.f437795c = i3;
            return this;
        }

        public a e(String str) {
            this.f437796d = str;
            return this;
        }

        public a f(String str) {
            this.f437794b = str;
            return this;
        }

        public a g(String str) {
            this.f437793a = str;
            return this;
        }

        public a h(int i3) {
            this.f437799g = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<VersionInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VersionInfo.class, "type.googleapis.com/tvideo.VersionInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VersionInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 4:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                        case 6:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            aVar.h(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VersionInfo versionInfo) throws IOException {
            if (!Objects.equals(versionInfo.version_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, versionInfo.version_name);
            }
            if (!Objects.equals(versionInfo.version_code, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, versionInfo.version_code);
            }
            if (!Objects.equals(Integer.valueOf(versionInfo.platform), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(versionInfo.platform));
            }
            if (!Objects.equals(versionInfo.platform_version, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, versionInfo.platform_version);
            }
            if (!Objects.equals(versionInfo.channel_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, versionInfo.channel_id);
            }
            if (!Objects.equals(versionInfo.app_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, versionInfo.app_id);
            }
            if (!Objects.equals(Integer.valueOf(versionInfo.vnview_pkg_version), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 8, Integer.valueOf(versionInfo.vnview_pkg_version));
            }
            protoWriter.writeBytes(versionInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VersionInfo versionInfo) {
            int i3 = 0;
            if (!Objects.equals(versionInfo.version_name, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, versionInfo.version_name);
            }
            if (!Objects.equals(versionInfo.version_code, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, versionInfo.version_code);
            }
            if (!Objects.equals(Integer.valueOf(versionInfo.platform), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(versionInfo.platform));
            }
            if (!Objects.equals(versionInfo.platform_version, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, versionInfo.platform_version);
            }
            if (!Objects.equals(versionInfo.channel_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, versionInfo.channel_id);
            }
            if (!Objects.equals(versionInfo.app_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, versionInfo.app_id);
            }
            if (!Objects.equals(Integer.valueOf(versionInfo.vnview_pkg_version), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(8, Integer.valueOf(versionInfo.vnview_pkg_version));
            }
            return i3 + versionInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VersionInfo redact(VersionInfo versionInfo) {
            a newBuilder = versionInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VersionInfo(String str, String str2, int i3, String str3, String str4, String str5, int i16) {
        this(str, str2, i3, str3, str4, str5, i16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VersionInfo)) {
            return false;
        }
        VersionInfo versionInfo = (VersionInfo) obj;
        if (unknownFields().equals(versionInfo.unknownFields()) && Internal.equals(this.version_name, versionInfo.version_name) && Internal.equals(this.version_code, versionInfo.version_code) && Internal.equals(Integer.valueOf(this.platform), Integer.valueOf(versionInfo.platform)) && Internal.equals(this.platform_version, versionInfo.platform_version) && Internal.equals(this.channel_id, versionInfo.channel_id) && Internal.equals(this.app_id, versionInfo.app_id) && Internal.equals(Integer.valueOf(this.vnview_pkg_version), Integer.valueOf(versionInfo.vnview_pkg_version))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.version_name;
            int i26 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            String str2 = this.version_code;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (((i27 + i16) * 37) + this.platform) * 37;
            String str3 = this.platform_version;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            String str4 = this.channel_id;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str5 = this.app_id;
            if (str5 != null) {
                i26 = str5.hashCode();
            }
            int i37 = ((i36 + i26) * 37) + this.vnview_pkg_version;
            this.hashCode = i37;
            return i37;
        }
        return i19;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.version_name != null) {
            sb5.append(", version_name=");
            sb5.append(Internal.sanitize(this.version_name));
        }
        if (this.version_code != null) {
            sb5.append(", version_code=");
            sb5.append(Internal.sanitize(this.version_code));
        }
        sb5.append(", platform=");
        sb5.append(this.platform);
        if (this.platform_version != null) {
            sb5.append(", platform_version=");
            sb5.append(Internal.sanitize(this.platform_version));
        }
        if (this.channel_id != null) {
            sb5.append(", channel_id=");
            sb5.append(Internal.sanitize(this.channel_id));
        }
        if (this.app_id != null) {
            sb5.append(", app_id=");
            sb5.append(Internal.sanitize(this.app_id));
        }
        sb5.append(", vnview_pkg_version=");
        sb5.append(this.vnview_pkg_version);
        StringBuilder replace = sb5.replace(0, 2, "VersionInfo{");
        replace.append('}');
        return replace.toString();
    }

    public VersionInfo(String str, String str2, int i3, String str3, String str4, String str5, int i16, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.version_name = str;
            if (str2 != null) {
                this.version_code = str2;
                this.platform = i3;
                if (str3 != null) {
                    this.platform_version = str3;
                    if (str4 != null) {
                        this.channel_id = str4;
                        if (str5 != null) {
                            this.app_id = str5;
                            this.vnview_pkg_version = i16;
                            return;
                        }
                        throw new IllegalArgumentException("app_id == null");
                    }
                    throw new IllegalArgumentException("channel_id == null");
                }
                throw new IllegalArgumentException("platform_version == null");
            }
            throw new IllegalArgumentException("version_code == null");
        }
        throw new IllegalArgumentException("version_name == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437793a = this.version_name;
        aVar.f437794b = this.version_code;
        aVar.f437795c = this.platform;
        aVar.f437796d = this.platform_version;
        aVar.f437797e = this.channel_id;
        aVar.f437798f = this.app_id;
        aVar.f437799g = this.vnview_pkg_version;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
