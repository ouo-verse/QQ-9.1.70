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

/* loaded from: classes30.dex */
public final class VideoPlot extends Message<VideoPlot, a> {
    public static final ProtoAdapter<VideoPlot> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.MarkLabelList#ADAPTER", jsonName = "markLabelListMap", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Map<Integer, MarkLabelList> mark_label_list_map;

    @WireField(adapter = "tvideo.VideoBaseInfo#ADAPTER", jsonName = "videoBaseInfo", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final VideoBaseInfo video_base_info;

    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<VideoPlot, a> {

        /* renamed from: a, reason: collision with root package name */
        public VideoBaseInfo f437830a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Integer, MarkLabelList> f437831b = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoPlot build() {
            return new VideoPlot(this.f437830a, this.f437831b, super.buildUnknownFields());
        }

        public a b(VideoBaseInfo videoBaseInfo) {
            this.f437830a = videoBaseInfo;
            return this;
        }
    }

    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<VideoPlot> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<Integer, MarkLabelList>> f437832a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoPlot.class, "type.googleapis.com/tvideo.VideoPlot", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<Integer, MarkLabelList>> d() {
            ProtoAdapter<Map<Integer, MarkLabelList>> protoAdapter = this.f437832a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<Integer, MarkLabelList>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MarkLabelList.ADAPTER);
                this.f437832a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoPlot decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f437831b.putAll(d().decode(protoReader));
                        }
                    } else {
                        aVar.b(VideoBaseInfo.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VideoPlot videoPlot) throws IOException {
            if (!Objects.equals(videoPlot.video_base_info, null)) {
                VideoBaseInfo.ADAPTER.encodeWithTag(protoWriter, 1, videoPlot.video_base_info);
            }
            d().encodeWithTag(protoWriter, 2, videoPlot.mark_label_list_map);
            protoWriter.writeBytes(videoPlot.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoPlot videoPlot) {
            int i3 = 0;
            if (!Objects.equals(videoPlot.video_base_info, null)) {
                i3 = 0 + VideoBaseInfo.ADAPTER.encodedSizeWithTag(1, videoPlot.video_base_info);
            }
            return i3 + d().encodedSizeWithTag(2, videoPlot.mark_label_list_map) + videoPlot.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public VideoPlot redact(VideoPlot videoPlot) {
            a newBuilder = videoPlot.newBuilder();
            VideoBaseInfo videoBaseInfo = newBuilder.f437830a;
            if (videoBaseInfo != null) {
                newBuilder.f437830a = VideoBaseInfo.ADAPTER.redact(videoBaseInfo);
            }
            Internal.redactElements(newBuilder.f437831b, MarkLabelList.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoPlot(VideoBaseInfo videoBaseInfo, Map<Integer, MarkLabelList> map) {
        this(videoBaseInfo, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoPlot)) {
            return false;
        }
        VideoPlot videoPlot = (VideoPlot) obj;
        if (unknownFields().equals(videoPlot.unknownFields()) && Internal.equals(this.video_base_info, videoPlot.video_base_info) && this.mark_label_list_map.equals(videoPlot.mark_label_list_map)) {
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
            if (videoBaseInfo != null) {
                i3 = videoBaseInfo.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((hashCode + i3) * 37) + this.mark_label_list_map.hashCode();
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
        if (!this.mark_label_list_map.isEmpty()) {
            sb5.append(", mark_label_list_map=");
            sb5.append(this.mark_label_list_map);
        }
        StringBuilder replace = sb5.replace(0, 2, "VideoPlot{");
        replace.append('}');
        return replace.toString();
    }

    public VideoPlot(VideoBaseInfo videoBaseInfo, Map<Integer, MarkLabelList> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.video_base_info = videoBaseInfo;
        this.mark_label_list_map = Internal.immutableCopyOf("mark_label_list_map", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437830a = this.video_base_info;
        aVar.f437831b = Internal.copyOf(this.mark_label_list_map);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
