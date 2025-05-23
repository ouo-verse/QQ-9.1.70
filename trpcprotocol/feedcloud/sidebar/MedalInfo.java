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
public final class MedalInfo extends Message<MedalInfo, a> {
    public static final ProtoAdapter<MedalInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String iconURL;

    /* renamed from: id, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String f437302id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int type;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<MedalInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437303a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437304b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f437305c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f437306d = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MedalInfo build() {
            return new MedalInfo(this.f437303a, this.f437304b, this.f437305c, this.f437306d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437306d = str;
            return this;
        }

        public a c(String str) {
            this.f437303a = str;
            return this;
        }

        public a d(String str) {
            this.f437304b = str;
            return this;
        }

        public a e(int i3) {
            this.f437305c = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<MedalInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MedalInfo.class, "type.googleapis.com/trpc.feedcloud.sidebar.MedalInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MedalInfo decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.b(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.e(ProtoAdapter.INT32.decode(protoReader).intValue());
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
        public void encode(ProtoWriter protoWriter, MedalInfo medalInfo) throws IOException {
            if (!Objects.equals(medalInfo.f437302id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, medalInfo.f437302id);
            }
            if (!Objects.equals(medalInfo.name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, medalInfo.name);
            }
            if (!Objects.equals(Integer.valueOf(medalInfo.type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(medalInfo.type));
            }
            if (!Objects.equals(medalInfo.iconURL, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, medalInfo.iconURL);
            }
            protoWriter.writeBytes(medalInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(MedalInfo medalInfo) {
            int i3;
            if (!Objects.equals(medalInfo.f437302id, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, medalInfo.f437302id) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(medalInfo.name, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, medalInfo.name);
            }
            if (!Objects.equals(Integer.valueOf(medalInfo.type), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(medalInfo.type));
            }
            if (!Objects.equals(medalInfo.iconURL, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, medalInfo.iconURL);
            }
            return i3 + medalInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MedalInfo redact(MedalInfo medalInfo) {
            a newBuilder = medalInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MedalInfo(String str, String str2, int i3, String str3) {
        this(str, str2, i3, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MedalInfo)) {
            return false;
        }
        MedalInfo medalInfo = (MedalInfo) obj;
        if (unknownFields().equals(medalInfo.unknownFields()) && Internal.equals(this.f437302id, medalInfo.f437302id) && Internal.equals(this.name, medalInfo.name) && Internal.equals(Integer.valueOf(this.type), Integer.valueOf(medalInfo.type)) && Internal.equals(this.iconURL, medalInfo.iconURL)) {
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
            String str = this.f437302id;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.name;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (((i19 + i16) * 37) + this.type) * 37;
            String str3 = this.iconURL;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int i27 = i26 + i18;
            this.hashCode = i27;
            return i27;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.f437302id != null) {
            sb5.append(", id=");
            sb5.append(Internal.sanitize(this.f437302id));
        }
        if (this.name != null) {
            sb5.append(", name=");
            sb5.append(Internal.sanitize(this.name));
        }
        sb5.append(", type=");
        sb5.append(this.type);
        if (this.iconURL != null) {
            sb5.append(", iconURL=");
            sb5.append(Internal.sanitize(this.iconURL));
        }
        StringBuilder replace = sb5.replace(0, 2, "MedalInfo{");
        replace.append('}');
        return replace.toString();
    }

    public MedalInfo(String str, String str2, int i3, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.f437302id = str;
            if (str2 != null) {
                this.name = str2;
                this.type = i3;
                if (str3 != null) {
                    this.iconURL = str3;
                    return;
                }
                throw new IllegalArgumentException("iconURL == null");
            }
            throw new IllegalArgumentException("name == null");
        }
        throw new IllegalArgumentException("id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437303a = this.f437302id;
        aVar.f437304b = this.name;
        aVar.f437305c = this.type;
        aVar.f437306d = this.iconURL;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
