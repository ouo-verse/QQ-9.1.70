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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class Video extends Message<Video, a> {
    public static final ProtoAdapter<Video> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.CoverBaseInfo#ADAPTER", jsonName = "coverBaseInfo", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final CoverBaseInfo cover_base_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reportMap", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> report_map;

    @WireField(adapter = "tvideo.VideoBaseInfo#ADAPTER", jsonName = "videoBaseInfo", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final VideoBaseInfo video_base_info;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<Video, a> {

        /* renamed from: a, reason: collision with root package name */
        public VideoBaseInfo f437800a;

        /* renamed from: b, reason: collision with root package name */
        public CoverBaseInfo f437801b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, String> f437802c = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Video build() {
            return new Video(this.f437800a, this.f437801b, this.f437802c, super.buildUnknownFields());
        }

        public a b(CoverBaseInfo coverBaseInfo) {
            this.f437801b = coverBaseInfo;
            return this;
        }

        public a c(VideoBaseInfo videoBaseInfo) {
            this.f437800a = videoBaseInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<Video> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437803a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Video.class, "type.googleapis.com/tvideo.Video", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437803a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437803a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Video decode(ProtoReader protoReader) throws IOException {
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
                                aVar.f437802c.putAll(e().decode(protoReader));
                            }
                        } else {
                            aVar.b(CoverBaseInfo.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.c(VideoBaseInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, Video video) throws IOException {
            if (!Objects.equals(video.video_base_info, null)) {
                VideoBaseInfo.ADAPTER.encodeWithTag(protoWriter, 1, video.video_base_info);
            }
            if (!Objects.equals(video.cover_base_info, null)) {
                CoverBaseInfo.ADAPTER.encodeWithTag(protoWriter, 2, video.cover_base_info);
            }
            e().encodeWithTag(protoWriter, 3, video.report_map);
            protoWriter.writeBytes(video.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Video video) {
            int i3 = 0;
            if (!Objects.equals(video.video_base_info, null)) {
                i3 = 0 + VideoBaseInfo.ADAPTER.encodedSizeWithTag(1, video.video_base_info);
            }
            if (!Objects.equals(video.cover_base_info, null)) {
                i3 += CoverBaseInfo.ADAPTER.encodedSizeWithTag(2, video.cover_base_info);
            }
            return i3 + e().encodedSizeWithTag(3, video.report_map) + video.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Video redact(Video video) {
            a newBuilder = video.newBuilder();
            VideoBaseInfo videoBaseInfo = newBuilder.f437800a;
            if (videoBaseInfo != null) {
                newBuilder.f437800a = VideoBaseInfo.ADAPTER.redact(videoBaseInfo);
            }
            CoverBaseInfo coverBaseInfo = newBuilder.f437801b;
            if (coverBaseInfo != null) {
                newBuilder.f437801b = CoverBaseInfo.ADAPTER.redact(coverBaseInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Video(VideoBaseInfo videoBaseInfo, CoverBaseInfo coverBaseInfo, Map<String, String> map) {
        this(videoBaseInfo, coverBaseInfo, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Video)) {
            return false;
        }
        Video video = (Video) obj;
        if (unknownFields().equals(video.unknownFields()) && Internal.equals(this.video_base_info, video.video_base_info) && Internal.equals(this.cover_base_info, video.cover_base_info) && this.report_map.equals(video.report_map)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            VideoBaseInfo videoBaseInfo = this.video_base_info;
            int i17 = 0;
            if (videoBaseInfo != null) {
                i3 = videoBaseInfo.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            CoverBaseInfo coverBaseInfo = this.cover_base_info;
            if (coverBaseInfo != null) {
                i17 = coverBaseInfo.hashCode();
            }
            int hashCode2 = ((i18 + i17) * 37) + this.report_map.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.video_base_info != null) {
            sb5.append(", video_base_info=");
            sb5.append(this.video_base_info);
        }
        if (this.cover_base_info != null) {
            sb5.append(", cover_base_info=");
            sb5.append(this.cover_base_info);
        }
        if (!this.report_map.isEmpty()) {
            sb5.append(", report_map=");
            sb5.append(this.report_map);
        }
        StringBuilder replace = sb5.replace(0, 2, "Video{");
        replace.append('}');
        return replace.toString();
    }

    public Video(VideoBaseInfo videoBaseInfo, CoverBaseInfo coverBaseInfo, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_base_info = videoBaseInfo;
        this.cover_base_info = coverBaseInfo;
        this.report_map = Internal.immutableCopyOf("report_map", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437800a = this.video_base_info;
        aVar.f437801b = this.cover_base_info;
        aVar.f437802c = Internal.copyOf(this.report_map);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
