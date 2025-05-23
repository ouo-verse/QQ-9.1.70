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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* loaded from: classes30.dex */
public final class VideoPlotDetails extends Message<VideoPlotDetails, a> {
    public static final ProtoAdapter<VideoPlotDetails> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.CoverBaseInfo#ADAPTER", jsonName = "coverBaseInfo", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final CoverBaseInfo cover_base_info;

    @WireField(adapter = "tvideo.EpisodeListStyle#ADAPTER", jsonName = "episodeListStyle", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final EpisodeListStyle episode_list_style;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "episodeUpdated", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String episode_updated;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "hasNext", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean has_next;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "hasPrev", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final boolean has_prev;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "nextEpisodeBtnShown", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    public final boolean next_episode_btn_shown;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "nowPageNum", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final int now_page_num;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "pageContext", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> page_context;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "prevPageContext", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> prev_page_context;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 100)
    public final long timestamp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "totalPage", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final int total_page;

    @WireField(adapter = "tvideo.VideoPlot#ADAPTER", jsonName = "videoPlotList", label = WireField.Label.REPEATED, tag = 10)
    public final List<VideoPlot> video_plot_list;

    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<VideoPlotDetails, a> {

        /* renamed from: i, reason: collision with root package name */
        public CoverBaseInfo f437841i;

        /* renamed from: a, reason: collision with root package name */
        public boolean f437833a = false;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f437834b = Internal.newMutableMap();

        /* renamed from: c, reason: collision with root package name */
        public boolean f437835c = false;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String> f437836d = Internal.newMutableMap();

        /* renamed from: e, reason: collision with root package name */
        public int f437837e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f437838f = 0;

        /* renamed from: g, reason: collision with root package name */
        public String f437839g = "";

        /* renamed from: h, reason: collision with root package name */
        public EpisodeListStyle f437840h = EpisodeListStyle.EpisodeListStyleSquare;

        /* renamed from: j, reason: collision with root package name */
        public List<VideoPlot> f437842j = Internal.newMutableList();

        /* renamed from: k, reason: collision with root package name */
        public boolean f437843k = false;

        /* renamed from: l, reason: collision with root package name */
        public long f437844l = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoPlotDetails build() {
            return new VideoPlotDetails(this.f437833a, this.f437834b, this.f437835c, this.f437836d, this.f437837e, this.f437838f, this.f437839g, this.f437840h, this.f437841i, this.f437842j, this.f437843k, this.f437844l, super.buildUnknownFields());
        }

        public a b(CoverBaseInfo coverBaseInfo) {
            this.f437841i = coverBaseInfo;
            return this;
        }

        public a c(EpisodeListStyle episodeListStyle) {
            this.f437840h = episodeListStyle;
            return this;
        }

        public a d(String str) {
            this.f437839g = str;
            return this;
        }

        public a e(boolean z16) {
            this.f437833a = z16;
            return this;
        }

        public a f(boolean z16) {
            this.f437835c = z16;
            return this;
        }

        public a g(boolean z16) {
            this.f437843k = z16;
            return this;
        }

        public a h(int i3) {
            this.f437837e = i3;
            return this;
        }

        public a i(long j3) {
            this.f437844l = j3;
            return this;
        }

        public a j(int i3) {
            this.f437838f = i3;
            return this;
        }

        public a k(List<VideoPlot> list) {
            Internal.checkElementsNotNull(list);
            this.f437842j = list;
            return this;
        }
    }

    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<VideoPlotDetails> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437845a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437846b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoPlotDetails.class, "type.googleapis.com/tvideo.VideoPlotDetails", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437845a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437845a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437846b;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437846b = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoPlotDetails decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 100) {
                        switch (nextTag) {
                            case 1:
                                aVar.e(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                break;
                            case 2:
                                aVar.f437834b.putAll(d().decode(protoReader));
                                break;
                            case 3:
                                aVar.f(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                break;
                            case 4:
                                aVar.f437836d.putAll(e().decode(protoReader));
                                break;
                            case 5:
                                aVar.h(ProtoAdapter.INT32.decode(protoReader).intValue());
                                break;
                            case 6:
                                aVar.j(ProtoAdapter.INT32.decode(protoReader).intValue());
                                break;
                            case 7:
                                aVar.d(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 8:
                                try {
                                    aVar.c(EpisodeListStyle.ADAPTER.decode(protoReader));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    break;
                                }
                            case 9:
                                aVar.b(CoverBaseInfo.ADAPTER.decode(protoReader));
                                break;
                            case 10:
                                aVar.f437842j.add(VideoPlot.ADAPTER.decode(protoReader));
                                break;
                            case 11:
                                aVar.g(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                break;
                            default:
                                protoReader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        aVar.i(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VideoPlotDetails videoPlotDetails) throws IOException {
            Boolean valueOf = Boolean.valueOf(videoPlotDetails.has_next);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(videoPlotDetails.has_next));
            }
            d().encodeWithTag(protoWriter, 2, videoPlotDetails.page_context);
            if (!Objects.equals(Boolean.valueOf(videoPlotDetails.has_prev), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, Boolean.valueOf(videoPlotDetails.has_prev));
            }
            e().encodeWithTag(protoWriter, 4, videoPlotDetails.prev_page_context);
            if (!Objects.equals(Integer.valueOf(videoPlotDetails.now_page_num), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, Integer.valueOf(videoPlotDetails.now_page_num));
            }
            if (!Objects.equals(Integer.valueOf(videoPlotDetails.total_page), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, Integer.valueOf(videoPlotDetails.total_page));
            }
            if (!Objects.equals(videoPlotDetails.episode_updated, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, videoPlotDetails.episode_updated);
            }
            if (!Objects.equals(videoPlotDetails.episode_list_style, EpisodeListStyle.EpisodeListStyleSquare)) {
                EpisodeListStyle.ADAPTER.encodeWithTag(protoWriter, 8, videoPlotDetails.episode_list_style);
            }
            if (!Objects.equals(videoPlotDetails.cover_base_info, null)) {
                CoverBaseInfo.ADAPTER.encodeWithTag(protoWriter, 9, videoPlotDetails.cover_base_info);
            }
            VideoPlot.ADAPTER.asRepeated().encodeWithTag(protoWriter, 10, videoPlotDetails.video_plot_list);
            if (!Objects.equals(Boolean.valueOf(videoPlotDetails.next_episode_btn_shown), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 11, Boolean.valueOf(videoPlotDetails.next_episode_btn_shown));
            }
            if (!Objects.equals(Long.valueOf(videoPlotDetails.timestamp), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 100, Long.valueOf(videoPlotDetails.timestamp));
            }
            protoWriter.writeBytes(videoPlotDetails.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoPlotDetails videoPlotDetails) {
            Boolean valueOf = Boolean.valueOf(videoPlotDetails.has_next);
            Boolean bool = Boolean.FALSE;
            int i3 = 0;
            if (!Objects.equals(valueOf, bool)) {
                i3 = 0 + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(videoPlotDetails.has_next));
            }
            int encodedSizeWithTag = i3 + d().encodedSizeWithTag(2, videoPlotDetails.page_context);
            if (!Objects.equals(Boolean.valueOf(videoPlotDetails.has_prev), bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(videoPlotDetails.has_prev));
            }
            int encodedSizeWithTag2 = encodedSizeWithTag + e().encodedSizeWithTag(4, videoPlotDetails.prev_page_context);
            if (!Objects.equals(Integer.valueOf(videoPlotDetails.now_page_num), 0)) {
                encodedSizeWithTag2 += ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(videoPlotDetails.now_page_num));
            }
            if (!Objects.equals(Integer.valueOf(videoPlotDetails.total_page), 0)) {
                encodedSizeWithTag2 += ProtoAdapter.INT32.encodedSizeWithTag(6, Integer.valueOf(videoPlotDetails.total_page));
            }
            if (!Objects.equals(videoPlotDetails.episode_updated, "")) {
                encodedSizeWithTag2 += ProtoAdapter.STRING.encodedSizeWithTag(7, videoPlotDetails.episode_updated);
            }
            if (!Objects.equals(videoPlotDetails.episode_list_style, EpisodeListStyle.EpisodeListStyleSquare)) {
                encodedSizeWithTag2 += EpisodeListStyle.ADAPTER.encodedSizeWithTag(8, videoPlotDetails.episode_list_style);
            }
            if (!Objects.equals(videoPlotDetails.cover_base_info, null)) {
                encodedSizeWithTag2 += CoverBaseInfo.ADAPTER.encodedSizeWithTag(9, videoPlotDetails.cover_base_info);
            }
            int encodedSizeWithTag3 = encodedSizeWithTag2 + VideoPlot.ADAPTER.asRepeated().encodedSizeWithTag(10, videoPlotDetails.video_plot_list);
            if (!Objects.equals(Boolean.valueOf(videoPlotDetails.next_episode_btn_shown), bool)) {
                encodedSizeWithTag3 += ProtoAdapter.BOOL.encodedSizeWithTag(11, Boolean.valueOf(videoPlotDetails.next_episode_btn_shown));
            }
            if (!Objects.equals(Long.valueOf(videoPlotDetails.timestamp), 0L)) {
                encodedSizeWithTag3 += ProtoAdapter.INT64.encodedSizeWithTag(100, Long.valueOf(videoPlotDetails.timestamp));
            }
            return encodedSizeWithTag3 + videoPlotDetails.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public VideoPlotDetails redact(VideoPlotDetails videoPlotDetails) {
            a newBuilder = videoPlotDetails.newBuilder();
            CoverBaseInfo coverBaseInfo = newBuilder.f437841i;
            if (coverBaseInfo != null) {
                newBuilder.f437841i = CoverBaseInfo.ADAPTER.redact(coverBaseInfo);
            }
            Internal.redactElements(newBuilder.f437842j, VideoPlot.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoPlotDetails(boolean z16, Map<String, String> map, boolean z17, Map<String, String> map2, int i3, int i16, String str, EpisodeListStyle episodeListStyle, CoverBaseInfo coverBaseInfo, List<VideoPlot> list, boolean z18, long j3) {
        this(z16, map, z17, map2, i3, i16, str, episodeListStyle, coverBaseInfo, list, z18, j3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoPlotDetails)) {
            return false;
        }
        VideoPlotDetails videoPlotDetails = (VideoPlotDetails) obj;
        if (unknownFields().equals(videoPlotDetails.unknownFields()) && Internal.equals(Boolean.valueOf(this.has_next), Boolean.valueOf(videoPlotDetails.has_next)) && this.page_context.equals(videoPlotDetails.page_context) && Internal.equals(Boolean.valueOf(this.has_prev), Boolean.valueOf(videoPlotDetails.has_prev)) && this.prev_page_context.equals(videoPlotDetails.prev_page_context) && Internal.equals(Integer.valueOf(this.now_page_num), Integer.valueOf(videoPlotDetails.now_page_num)) && Internal.equals(Integer.valueOf(this.total_page), Integer.valueOf(videoPlotDetails.total_page)) && Internal.equals(this.episode_updated, videoPlotDetails.episode_updated) && Internal.equals(this.episode_list_style, videoPlotDetails.episode_list_style) && Internal.equals(this.cover_base_info, videoPlotDetails.cover_base_info) && this.video_plot_list.equals(videoPlotDetails.video_plot_list) && Internal.equals(Boolean.valueOf(this.next_episode_btn_shown), Boolean.valueOf(videoPlotDetails.next_episode_btn_shown)) && Internal.equals(Long.valueOf(this.timestamp), Long.valueOf(videoPlotDetails.timestamp))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = ((((((((((((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.has_next)) * 37) + this.page_context.hashCode()) * 37) + com.tencent.aio.widget.textView.param.a.a(this.has_prev)) * 37) + this.prev_page_context.hashCode()) * 37) + this.now_page_num) * 37) + this.total_page) * 37;
            String str = this.episode_updated;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            EpisodeListStyle episodeListStyle = this.episode_list_style;
            if (episodeListStyle != null) {
                i16 = episodeListStyle.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            CoverBaseInfo coverBaseInfo = this.cover_base_info;
            if (coverBaseInfo != null) {
                i18 = coverBaseInfo.hashCode();
            }
            int hashCode2 = ((((((i26 + i18) * 37) + this.video_plot_list.hashCode()) * 37) + com.tencent.aio.widget.textView.param.a.a(this.next_episode_btn_shown)) * 37) + androidx.fragment.app.a.a(this.timestamp);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", has_next=");
        sb5.append(this.has_next);
        if (!this.page_context.isEmpty()) {
            sb5.append(", page_context=");
            sb5.append(this.page_context);
        }
        sb5.append(", has_prev=");
        sb5.append(this.has_prev);
        if (!this.prev_page_context.isEmpty()) {
            sb5.append(", prev_page_context=");
            sb5.append(this.prev_page_context);
        }
        sb5.append(", now_page_num=");
        sb5.append(this.now_page_num);
        sb5.append(", total_page=");
        sb5.append(this.total_page);
        if (this.episode_updated != null) {
            sb5.append(", episode_updated=");
            sb5.append(Internal.sanitize(this.episode_updated));
        }
        if (this.episode_list_style != null) {
            sb5.append(", episode_list_style=");
            sb5.append(this.episode_list_style);
        }
        if (this.cover_base_info != null) {
            sb5.append(", cover_base_info=");
            sb5.append(this.cover_base_info);
        }
        if (!this.video_plot_list.isEmpty()) {
            sb5.append(", video_plot_list=");
            sb5.append(this.video_plot_list);
        }
        sb5.append(", next_episode_btn_shown=");
        sb5.append(this.next_episode_btn_shown);
        sb5.append(", timestamp=");
        sb5.append(this.timestamp);
        StringBuilder replace = sb5.replace(0, 2, "VideoPlotDetails{");
        replace.append('}');
        return replace.toString();
    }

    public VideoPlotDetails(boolean z16, Map<String, String> map, boolean z17, Map<String, String> map2, int i3, int i16, String str, EpisodeListStyle episodeListStyle, CoverBaseInfo coverBaseInfo, List<VideoPlot> list, boolean z18, long j3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.has_next = z16;
        this.page_context = Internal.immutableCopyOf("page_context", map);
        this.has_prev = z17;
        this.prev_page_context = Internal.immutableCopyOf("prev_page_context", map2);
        this.now_page_num = i3;
        this.total_page = i16;
        if (str != null) {
            this.episode_updated = str;
            if (episodeListStyle != null) {
                this.episode_list_style = episodeListStyle;
                this.cover_base_info = coverBaseInfo;
                this.video_plot_list = Internal.immutableCopyOf("video_plot_list", list);
                this.next_episode_btn_shown = z18;
                this.timestamp = j3;
                return;
            }
            throw new IllegalArgumentException("episode_list_style == null");
        }
        throw new IllegalArgumentException("episode_updated == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437833a = this.has_next;
        aVar.f437834b = Internal.copyOf(this.page_context);
        aVar.f437835c = this.has_prev;
        aVar.f437836d = Internal.copyOf(this.prev_page_context);
        aVar.f437837e = this.now_page_num;
        aVar.f437838f = this.total_page;
        aVar.f437839g = this.episode_updated;
        aVar.f437840h = this.episode_list_style;
        aVar.f437841i = this.cover_base_info;
        aVar.f437842j = Internal.copyOf(this.video_plot_list);
        aVar.f437843k = this.next_episode_btn_shown;
        aVar.f437844l = this.timestamp;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
