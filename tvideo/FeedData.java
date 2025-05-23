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
public final class FeedData extends Message<FeedData, a> {
    public static final ProtoAdapter<FeedData> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.Ads#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final Ads ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "feedPosition", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int feed_position;

    @WireField(adapter = "tvideo.Video#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final Video video;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<FeedData, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437628a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Video f437629b;

        /* renamed from: c, reason: collision with root package name */
        public Ads f437630c;

        public a a(Ads ads) {
            this.f437630c = ads;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FeedData build() {
            return new FeedData(this.f437628a, this.f437629b, this.f437630c, super.buildUnknownFields());
        }

        public a c(int i3) {
            this.f437628a = i3;
            return this;
        }

        public a d(Video video) {
            this.f437629b = video;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<FeedData> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) FeedData.class, "type.googleapis.com/tvideo.FeedData", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedData decode(ProtoReader protoReader) throws IOException {
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
                                aVar.a(Ads.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.d(Video.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, FeedData feedData) throws IOException {
            if (!Objects.equals(Integer.valueOf(feedData.feed_position), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(feedData.feed_position));
            }
            if (!Objects.equals(feedData.video, null)) {
                Video.ADAPTER.encodeWithTag(protoWriter, 2, feedData.video);
            }
            if (!Objects.equals(feedData.ads, null)) {
                Ads.ADAPTER.encodeWithTag(protoWriter, 3, feedData.ads);
            }
            protoWriter.writeBytes(feedData.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(FeedData feedData) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(feedData.feed_position), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(feedData.feed_position));
            }
            if (!Objects.equals(feedData.video, null)) {
                i3 += Video.ADAPTER.encodedSizeWithTag(2, feedData.video);
            }
            if (!Objects.equals(feedData.ads, null)) {
                i3 += Ads.ADAPTER.encodedSizeWithTag(3, feedData.ads);
            }
            return i3 + feedData.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FeedData redact(FeedData feedData) {
            a newBuilder = feedData.newBuilder();
            Video video = newBuilder.f437629b;
            if (video != null) {
                newBuilder.f437629b = Video.ADAPTER.redact(video);
            }
            Ads ads = newBuilder.f437630c;
            if (ads != null) {
                newBuilder.f437630c = Ads.ADAPTER.redact(ads);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public FeedData(int i3, Video video, Ads ads) {
        this(i3, video, ads, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeedData)) {
            return false;
        }
        FeedData feedData = (FeedData) obj;
        if (unknownFields().equals(feedData.unknownFields()) && Internal.equals(Integer.valueOf(this.feed_position), Integer.valueOf(feedData.feed_position)) && Internal.equals(this.video, feedData.video) && Internal.equals(this.ads, feedData.ads)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.feed_position) * 37;
            Video video = this.video;
            int i17 = 0;
            if (video != null) {
                i3 = video.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            Ads ads = this.ads;
            if (ads != null) {
                i17 = ads.hashCode();
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
        sb5.append(", feed_position=");
        sb5.append(this.feed_position);
        if (this.video != null) {
            sb5.append(", video=");
            sb5.append(this.video);
        }
        if (this.ads != null) {
            sb5.append(", ads=");
            sb5.append(this.ads);
        }
        StringBuilder replace = sb5.replace(0, 2, "FeedData{");
        replace.append('}');
        return replace.toString();
    }

    public FeedData(int i3, Video video, Ads ads, ByteString byteString) {
        super(ADAPTER, byteString);
        this.feed_position = i3;
        this.video = video;
        this.ads = ads;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437628a = this.feed_position;
        aVar.f437629b = this.video;
        aVar.f437630c = this.ads;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
