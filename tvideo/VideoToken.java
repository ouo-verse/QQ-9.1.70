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
public final class VideoToken extends Message<VideoToken, a> {
    public static final ProtoAdapter<VideoToken> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "expireTime", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int expire_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "videoSessionkey", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String video_sessionkey;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "videoUserid", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final long video_userid;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<VideoToken, a> {

        /* renamed from: a, reason: collision with root package name */
        public long f437851a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437852b = "";

        /* renamed from: c, reason: collision with root package name */
        public int f437853c = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoToken build() {
            return new VideoToken(this.f437851a, this.f437852b, this.f437853c, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437853c = i3;
            return this;
        }

        public a c(String str) {
            this.f437852b = str;
            return this;
        }

        public a d(long j3) {
            this.f437851a = j3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<VideoToken> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoToken.class, "type.googleapis.com/tvideo.VideoToken", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoToken decode(ProtoReader protoReader) throws IOException {
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
                                aVar.b(ProtoAdapter.UINT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.d(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VideoToken videoToken) throws IOException {
            if (!Objects.equals(Long.valueOf(videoToken.video_userid), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(videoToken.video_userid));
            }
            if (!Objects.equals(videoToken.video_sessionkey, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, videoToken.video_sessionkey);
            }
            if (!Objects.equals(Integer.valueOf(videoToken.expire_time), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 3, Integer.valueOf(videoToken.expire_time));
            }
            protoWriter.writeBytes(videoToken.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoToken videoToken) {
            int i3;
            if (!Objects.equals(Long.valueOf(videoToken.video_userid), 0L)) {
                i3 = ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(videoToken.video_userid)) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(videoToken.video_sessionkey, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, videoToken.video_sessionkey);
            }
            if (!Objects.equals(Integer.valueOf(videoToken.expire_time), 0)) {
                i3 += ProtoAdapter.UINT32.encodedSizeWithTag(3, Integer.valueOf(videoToken.expire_time));
            }
            return i3 + videoToken.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VideoToken redact(VideoToken videoToken) {
            a newBuilder = videoToken.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoToken(long j3, String str, int i3) {
        this(j3, str, i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoToken)) {
            return false;
        }
        VideoToken videoToken = (VideoToken) obj;
        if (unknownFields().equals(videoToken.unknownFields()) && Internal.equals(Long.valueOf(this.video_userid), Long.valueOf(videoToken.video_userid)) && Internal.equals(this.video_sessionkey, videoToken.video_sessionkey) && Internal.equals(Integer.valueOf(this.expire_time), Integer.valueOf(videoToken.expire_time))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.video_userid)) * 37;
            String str = this.video_sessionkey;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = ((hashCode + i3) * 37) + this.expire_time;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", video_userid=");
        sb5.append(this.video_userid);
        if (this.video_sessionkey != null) {
            sb5.append(", video_sessionkey=");
            sb5.append(Internal.sanitize(this.video_sessionkey));
        }
        sb5.append(", expire_time=");
        sb5.append(this.expire_time);
        StringBuilder replace = sb5.replace(0, 2, "VideoToken{");
        replace.append('}');
        return replace.toString();
    }

    public VideoToken(long j3, String str, int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_userid = j3;
        if (str != null) {
            this.video_sessionkey = str;
            this.expire_time = i3;
            return;
        }
        throw new IllegalArgumentException("video_sessionkey == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437851a = this.video_userid;
        aVar.f437852b = this.video_sessionkey;
        aVar.f437853c = this.expire_time;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
