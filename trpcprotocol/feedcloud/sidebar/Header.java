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
public final class Header extends Message<Header, a> {
    public static final ProtoAdapter<Header> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.MedalWallInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final MedalWallInfo medalWall;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.RocketInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final RocketInfo rocketInfo;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<Header, a> {

        /* renamed from: a, reason: collision with root package name */
        public MedalWallInfo f437298a;

        /* renamed from: b, reason: collision with root package name */
        public RocketInfo f437299b;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Header build() {
            return new Header(this.f437298a, this.f437299b, super.buildUnknownFields());
        }

        public a b(MedalWallInfo medalWallInfo) {
            this.f437298a = medalWallInfo;
            return this;
        }

        public a c(RocketInfo rocketInfo) {
            this.f437299b = rocketInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<Header> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Header.class, "type.googleapis.com/trpc.feedcloud.sidebar.Header", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Header decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.c(RocketInfo.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.b(MedalWallInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, Header header) throws IOException {
            if (!Objects.equals(header.medalWall, null)) {
                MedalWallInfo.ADAPTER.encodeWithTag(protoWriter, 1, header.medalWall);
            }
            if (!Objects.equals(header.rocketInfo, null)) {
                RocketInfo.ADAPTER.encodeWithTag(protoWriter, 2, header.rocketInfo);
            }
            protoWriter.writeBytes(header.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Header header) {
            int i3 = 0;
            if (!Objects.equals(header.medalWall, null)) {
                i3 = 0 + MedalWallInfo.ADAPTER.encodedSizeWithTag(1, header.medalWall);
            }
            if (!Objects.equals(header.rocketInfo, null)) {
                i3 += RocketInfo.ADAPTER.encodedSizeWithTag(2, header.rocketInfo);
            }
            return i3 + header.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Header redact(Header header) {
            a newBuilder = header.newBuilder();
            MedalWallInfo medalWallInfo = newBuilder.f437298a;
            if (medalWallInfo != null) {
                newBuilder.f437298a = MedalWallInfo.ADAPTER.redact(medalWallInfo);
            }
            RocketInfo rocketInfo = newBuilder.f437299b;
            if (rocketInfo != null) {
                newBuilder.f437299b = RocketInfo.ADAPTER.redact(rocketInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Header(MedalWallInfo medalWallInfo, RocketInfo rocketInfo) {
        this(medalWallInfo, rocketInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (unknownFields().equals(header.unknownFields()) && Internal.equals(this.medalWall, header.medalWall) && Internal.equals(this.rocketInfo, header.rocketInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            MedalWallInfo medalWallInfo = this.medalWall;
            int i17 = 0;
            if (medalWallInfo != null) {
                i3 = medalWallInfo.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            RocketInfo rocketInfo = this.rocketInfo;
            if (rocketInfo != null) {
                i17 = rocketInfo.hashCode();
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
        if (this.medalWall != null) {
            sb5.append(", medalWall=");
            sb5.append(this.medalWall);
        }
        if (this.rocketInfo != null) {
            sb5.append(", rocketInfo=");
            sb5.append(this.rocketInfo);
        }
        StringBuilder replace = sb5.replace(0, 2, "Header{");
        replace.append('}');
        return replace.toString();
    }

    public Header(MedalWallInfo medalWallInfo, RocketInfo rocketInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.medalWall = medalWallInfo;
        this.rocketInfo = rocketInfo;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437298a = this.medalWall;
        aVar.f437299b = this.rocketInfo;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
