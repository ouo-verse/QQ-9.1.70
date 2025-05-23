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
public final class Navbar extends Message<Navbar, a> {
    public static final ProtoAdapter<Navbar> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String clientReportInfo;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.JumpInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final JumpInfo jumpInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String picture;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<Navbar, a> {

        /* renamed from: b, reason: collision with root package name */
        public JumpInfo f437313b;

        /* renamed from: a, reason: collision with root package name */
        public String f437312a = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437314c = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Navbar build() {
            return new Navbar(this.f437312a, this.f437313b, this.f437314c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437314c = str;
            return this;
        }

        public a c(JumpInfo jumpInfo) {
            this.f437313b = jumpInfo;
            return this;
        }

        public a d(String str) {
            this.f437312a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<Navbar> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Navbar.class, "type.googleapis.com/trpc.feedcloud.sidebar.Navbar", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Navbar decode(ProtoReader protoReader) throws IOException {
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
                                aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.c(JumpInfo.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.d(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, Navbar navbar) throws IOException {
            if (!Objects.equals(navbar.picture, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, navbar.picture);
            }
            if (!Objects.equals(navbar.jumpInfo, null)) {
                JumpInfo.ADAPTER.encodeWithTag(protoWriter, 2, navbar.jumpInfo);
            }
            if (!Objects.equals(navbar.clientReportInfo, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, navbar.clientReportInfo);
            }
            protoWriter.writeBytes(navbar.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Navbar navbar) {
            int i3 = 0;
            if (!Objects.equals(navbar.picture, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, navbar.picture);
            }
            if (!Objects.equals(navbar.jumpInfo, null)) {
                i3 += JumpInfo.ADAPTER.encodedSizeWithTag(2, navbar.jumpInfo);
            }
            if (!Objects.equals(navbar.clientReportInfo, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, navbar.clientReportInfo);
            }
            return i3 + navbar.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Navbar redact(Navbar navbar) {
            a newBuilder = navbar.newBuilder();
            JumpInfo jumpInfo = newBuilder.f437313b;
            if (jumpInfo != null) {
                newBuilder.f437313b = JumpInfo.ADAPTER.redact(jumpInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Navbar(String str, JumpInfo jumpInfo, String str2) {
        this(str, jumpInfo, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Navbar)) {
            return false;
        }
        Navbar navbar = (Navbar) obj;
        if (unknownFields().equals(navbar.unknownFields()) && Internal.equals(this.picture, navbar.picture) && Internal.equals(this.jumpInfo, navbar.jumpInfo) && Internal.equals(this.clientReportInfo, navbar.clientReportInfo)) {
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
            String str = this.picture;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            JumpInfo jumpInfo = this.jumpInfo;
            if (jumpInfo != null) {
                i16 = jumpInfo.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str2 = this.clientReportInfo;
            if (str2 != null) {
                i18 = str2.hashCode();
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
        if (this.picture != null) {
            sb5.append(", picture=");
            sb5.append(Internal.sanitize(this.picture));
        }
        if (this.jumpInfo != null) {
            sb5.append(", jumpInfo=");
            sb5.append(this.jumpInfo);
        }
        if (this.clientReportInfo != null) {
            sb5.append(", clientReportInfo=");
            sb5.append(Internal.sanitize(this.clientReportInfo));
        }
        StringBuilder replace = sb5.replace(0, 2, "Navbar{");
        replace.append('}');
        return replace.toString();
    }

    public Navbar(String str, JumpInfo jumpInfo, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.picture = str;
            this.jumpInfo = jumpInfo;
            if (str2 != null) {
                this.clientReportInfo = str2;
                return;
            }
            throw new IllegalArgumentException("clientReportInfo == null");
        }
        throw new IllegalArgumentException("picture == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437312a = this.picture;
        aVar.f437313b = this.jumpInfo;
        aVar.f437314c = this.clientReportInfo;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
