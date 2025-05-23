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
public final class OttInfo extends Message<OttInfo, a> {
    public static final ProtoAdapter<OttInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String licence;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String qas;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String qua;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<OttInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437705a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437706b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437707c = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OttInfo build() {
            return new OttInfo(this.f437705a, this.f437706b, this.f437707c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437705a = str;
            return this;
        }

        public a c(String str) {
            this.f437707c = str;
            return this;
        }

        public a d(String str) {
            this.f437706b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<OttInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) OttInfo.class, "type.googleapis.com/tvideo.OttInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OttInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, OttInfo ottInfo) throws IOException {
            if (!Objects.equals(ottInfo.licence, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, ottInfo.licence);
            }
            if (!Objects.equals(ottInfo.qua, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, ottInfo.qua);
            }
            if (!Objects.equals(ottInfo.qas, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, ottInfo.qas);
            }
            protoWriter.writeBytes(ottInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(OttInfo ottInfo) {
            int i3 = 0;
            if (!Objects.equals(ottInfo.licence, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, ottInfo.licence);
            }
            if (!Objects.equals(ottInfo.qua, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, ottInfo.qua);
            }
            if (!Objects.equals(ottInfo.qas, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, ottInfo.qas);
            }
            return i3 + ottInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public OttInfo redact(OttInfo ottInfo) {
            a newBuilder = ottInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public OttInfo(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OttInfo)) {
            return false;
        }
        OttInfo ottInfo = (OttInfo) obj;
        if (unknownFields().equals(ottInfo.unknownFields()) && Internal.equals(this.licence, ottInfo.licence) && Internal.equals(this.qua, ottInfo.qua) && Internal.equals(this.qas, ottInfo.qas)) {
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
            String str = this.licence;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.qua;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str3 = this.qas;
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
        if (this.licence != null) {
            sb5.append(", licence=");
            sb5.append(Internal.sanitize(this.licence));
        }
        if (this.qua != null) {
            sb5.append(", qua=");
            sb5.append(Internal.sanitize(this.qua));
        }
        if (this.qas != null) {
            sb5.append(", qas=");
            sb5.append(Internal.sanitize(this.qas));
        }
        StringBuilder replace = sb5.replace(0, 2, "OttInfo{");
        replace.append('}');
        return replace.toString();
    }

    public OttInfo(String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.licence = str;
            if (str2 != null) {
                this.qua = str2;
                if (str3 != null) {
                    this.qas = str3;
                    return;
                }
                throw new IllegalArgumentException("qas == null");
            }
            throw new IllegalArgumentException("qua == null");
        }
        throw new IllegalArgumentException("licence == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437705a = this.licence;
        aVar.f437706b = this.qua;
        aVar.f437707c = this.qas;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
