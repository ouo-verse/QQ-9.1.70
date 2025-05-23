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
public final class RocketInfo extends Message<RocketInfo, a> {
    public static final ProtoAdapter<RocketInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final long count;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.RedInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final RedInfo redInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String url;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<RocketInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public long f437318a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437319b = "";

        /* renamed from: c, reason: collision with root package name */
        public RedInfo f437320c;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RocketInfo build() {
            return new RocketInfo(this.f437318a, this.f437319b, this.f437320c, super.buildUnknownFields());
        }

        public a b(long j3) {
            this.f437318a = j3;
            return this;
        }

        public a c(RedInfo redInfo) {
            this.f437320c = redInfo;
            return this;
        }

        public a d(String str) {
            this.f437319b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<RocketInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RocketInfo.class, "type.googleapis.com/trpc.feedcloud.sidebar.RocketInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RocketInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.c(RedInfo.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RocketInfo rocketInfo) throws IOException {
            if (!Objects.equals(Long.valueOf(rocketInfo.count), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(rocketInfo.count));
            }
            if (!Objects.equals(rocketInfo.url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, rocketInfo.url);
            }
            if (!Objects.equals(rocketInfo.redInfo, null)) {
                RedInfo.ADAPTER.encodeWithTag(protoWriter, 3, rocketInfo.redInfo);
            }
            protoWriter.writeBytes(rocketInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RocketInfo rocketInfo) {
            int i3 = 0;
            if (!Objects.equals(Long.valueOf(rocketInfo.count), 0L)) {
                i3 = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(rocketInfo.count));
            }
            if (!Objects.equals(rocketInfo.url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, rocketInfo.url);
            }
            if (!Objects.equals(rocketInfo.redInfo, null)) {
                i3 += RedInfo.ADAPTER.encodedSizeWithTag(3, rocketInfo.redInfo);
            }
            return i3 + rocketInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RocketInfo redact(RocketInfo rocketInfo) {
            a newBuilder = rocketInfo.newBuilder();
            RedInfo redInfo = newBuilder.f437320c;
            if (redInfo != null) {
                newBuilder.f437320c = RedInfo.ADAPTER.redact(redInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RocketInfo(long j3, String str, RedInfo redInfo) {
        this(j3, str, redInfo, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RocketInfo)) {
            return false;
        }
        RocketInfo rocketInfo = (RocketInfo) obj;
        if (unknownFields().equals(rocketInfo.unknownFields()) && Internal.equals(Long.valueOf(this.count), Long.valueOf(rocketInfo.count)) && Internal.equals(this.url, rocketInfo.url) && Internal.equals(this.redInfo, rocketInfo.redInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.count)) * 37;
            String str = this.url;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            RedInfo redInfo = this.redInfo;
            if (redInfo != null) {
                i17 = redInfo.hashCode();
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
        sb5.append(", count=");
        sb5.append(this.count);
        if (this.url != null) {
            sb5.append(", url=");
            sb5.append(Internal.sanitize(this.url));
        }
        if (this.redInfo != null) {
            sb5.append(", redInfo=");
            sb5.append(this.redInfo);
        }
        StringBuilder replace = sb5.replace(0, 2, "RocketInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RocketInfo(long j3, String str, RedInfo redInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.count = j3;
        if (str != null) {
            this.url = str;
            this.redInfo = redInfo;
            return;
        }
        throw new IllegalArgumentException("url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437318a = this.count;
        aVar.f437319b = this.url;
        aVar.f437320c = this.redInfo;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
