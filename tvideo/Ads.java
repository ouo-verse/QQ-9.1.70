package tvideo;

import com.squareup.wire.AnyMessage;
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
public final class Ads extends Message<Ads, a> {
    public static final ProtoAdapter<Ads> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "adFeedInfo", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final AnyMessage ad_feed_info;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<Ads, a> {

        /* renamed from: a, reason: collision with root package name */
        public AnyMessage f437583a;

        public a a(AnyMessage anyMessage) {
            this.f437583a = anyMessage;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Ads build() {
            return new Ads(this.f437583a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<Ads> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Ads.class, "type.googleapis.com/tvideo.Ads", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Ads decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.a(AnyMessage.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, Ads ads) throws IOException {
            if (!Objects.equals(ads.ad_feed_info, null)) {
                AnyMessage.ADAPTER.encodeWithTag(protoWriter, 1, ads.ad_feed_info);
            }
            protoWriter.writeBytes(ads.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Ads ads) {
            int i3 = 0;
            if (!Objects.equals(ads.ad_feed_info, null)) {
                i3 = 0 + AnyMessage.ADAPTER.encodedSizeWithTag(1, ads.ad_feed_info);
            }
            return i3 + ads.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Ads redact(Ads ads) {
            a newBuilder = ads.newBuilder();
            AnyMessage anyMessage = newBuilder.f437583a;
            if (anyMessage != null) {
                newBuilder.f437583a = AnyMessage.ADAPTER.redact(anyMessage);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Ads(AnyMessage anyMessage) {
        this(anyMessage, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ads)) {
            return false;
        }
        Ads ads = (Ads) obj;
        if (unknownFields().equals(ads.unknownFields()) && Internal.equals(this.ad_feed_info, ads.ad_feed_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            AnyMessage anyMessage = this.ad_feed_info;
            if (anyMessage != null) {
                i3 = anyMessage.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.ad_feed_info != null) {
            sb5.append(", ad_feed_info=");
            sb5.append(this.ad_feed_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "Ads{");
        replace.append('}');
        return replace.toString();
    }

    public Ads(AnyMessage anyMessage, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ad_feed_info = anyMessage;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437583a = this.ad_feed_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
