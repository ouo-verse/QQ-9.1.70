package tvideo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class VideoBaseInfo extends Message<VideoBaseInfo, a> {
    public static final ProtoAdapter<VideoBaseInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.AttitudeInfo#ADAPTER", jsonName = "attitudeInfo", label = WireField.Label.OMIT_IDENTITY, tag = 25)
    public final AttitudeInfo attitude_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "audioFileSize", label = WireField.Label.OMIT_IDENTITY, tag = 14)
    public final long audio_file_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String cid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "episodeTitle", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String episode_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isShortVideo", label = WireField.Label.OMIT_IDENTITY, tag = 36)
    public final boolean is_short_video;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isTraitor", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final boolean is_traitor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "materialAspectVid", label = WireField.Label.OMIT_IDENTITY, tag = 18)
    public final String material_aspect_vid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "materialEndTime", label = WireField.Label.OMIT_IDENTITY, tag = 17)
    public final int material_end_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "materialStartingTime", label = WireField.Label.OMIT_IDENTITY, tag = 16)
    public final int material_starting_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "materialTitle", label = WireField.Label.OMIT_IDENTITY, tag = 21)
    public final String material_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, label = WireField.Label.OMIT_IDENTITY, tag = 15)
    public final int play_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "plotTitle", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String plot_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "seriesNum", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String series_num;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "skipEnd", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final int skip_end;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "skipStart", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final int skip_start;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "streamRatio", label = WireField.Label.OMIT_IDENTITY, tag = 12)
    public final String stream_ratio;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String vid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "videoFileSize", label = WireField.Label.OMIT_IDENTITY, tag = 13)
    public final long video_file_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "videoHotval", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String video_hotval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "videoScore", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String video_score;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "videoType", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    public final int video_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "videoTypeName", label = WireField.Label.OMIT_IDENTITY, tag = 20)
    public final String video_type_name;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<VideoBaseInfo, a> {

        /* renamed from: u, reason: collision with root package name */
        public AttitudeInfo f437824u;

        /* renamed from: a, reason: collision with root package name */
        public String f437804a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437805b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437806c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f437807d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437808e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f437809f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f437810g = "";

        /* renamed from: h, reason: collision with root package name */
        public int f437811h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f437812i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f437813j = false;

        /* renamed from: k, reason: collision with root package name */
        public int f437814k = 0;

        /* renamed from: l, reason: collision with root package name */
        public String f437815l = "";

        /* renamed from: m, reason: collision with root package name */
        public long f437816m = 0;

        /* renamed from: n, reason: collision with root package name */
        public long f437817n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f437818o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f437819p = 0;

        /* renamed from: q, reason: collision with root package name */
        public int f437820q = 0;

        /* renamed from: r, reason: collision with root package name */
        public String f437821r = "";

        /* renamed from: s, reason: collision with root package name */
        public String f437822s = "";

        /* renamed from: t, reason: collision with root package name */
        public String f437823t = "";

        /* renamed from: v, reason: collision with root package name */
        public boolean f437825v = false;

        public a a(AttitudeInfo attitudeInfo) {
            this.f437824u = attitudeInfo;
            return this;
        }

        public a b(long j3) {
            this.f437817n = j3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public VideoBaseInfo build() {
            return new VideoBaseInfo(this, super.buildUnknownFields());
        }

        public a d(String str) {
            this.f437804a = str;
            return this;
        }

        public a e(String str) {
            this.f437807d = str;
            return this;
        }

        public a f(boolean z16) {
            this.f437825v = z16;
            return this;
        }

        public a g(boolean z16) {
            this.f437813j = z16;
            return this;
        }

        public a h(String str) {
            this.f437821r = str;
            return this;
        }

        public a i(int i3) {
            this.f437820q = i3;
            return this;
        }

        public a j(int i3) {
            this.f437819p = i3;
            return this;
        }

        public a k(String str) {
            this.f437823t = str;
            return this;
        }

        public a l(int i3) {
            this.f437818o = i3;
            return this;
        }

        public a m(String str) {
            this.f437806c = str;
            return this;
        }

        public a n(String str) {
            this.f437810g = str;
            return this;
        }

        public a o(int i3) {
            this.f437812i = i3;
            return this;
        }

        public a p(int i3) {
            this.f437811h = i3;
            return this;
        }

        public a q(String str) {
            this.f437815l = str;
            return this;
        }

        public a r(String str) {
            this.f437805b = str;
            return this;
        }

        public a s(long j3) {
            this.f437816m = j3;
            return this;
        }

        public a t(String str) {
            this.f437809f = str;
            return this;
        }

        public a u(String str) {
            this.f437808e = str;
            return this;
        }

        public a v(int i3) {
            this.f437814k = i3;
            return this;
        }

        public a w(String str) {
            this.f437822s = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<VideoBaseInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoBaseInfo.class, "type.googleapis.com/tvideo.VideoBaseInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoBaseInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 20) {
                        if (nextTag != 21) {
                            if (nextTag != 25) {
                                if (nextTag != 36) {
                                    switch (nextTag) {
                                        case 1:
                                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 2:
                                            aVar.r(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 3:
                                            aVar.m(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 4:
                                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 5:
                                            aVar.u(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 6:
                                            aVar.t(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 7:
                                            aVar.n(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 8:
                                            aVar.p(ProtoAdapter.INT32.decode(protoReader).intValue());
                                            break;
                                        case 9:
                                            aVar.o(ProtoAdapter.INT32.decode(protoReader).intValue());
                                            break;
                                        case 10:
                                            aVar.g(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                            break;
                                        case 11:
                                            aVar.v(ProtoAdapter.INT32.decode(protoReader).intValue());
                                            break;
                                        case 12:
                                            aVar.q(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        case 13:
                                            aVar.s(ProtoAdapter.INT64.decode(protoReader).longValue());
                                            break;
                                        case 14:
                                            aVar.b(ProtoAdapter.INT64.decode(protoReader).longValue());
                                            break;
                                        case 15:
                                            aVar.l(ProtoAdapter.INT32.decode(protoReader).intValue());
                                            break;
                                        case 16:
                                            aVar.j(ProtoAdapter.INT32.decode(protoReader).intValue());
                                            break;
                                        case 17:
                                            aVar.i(ProtoAdapter.INT32.decode(protoReader).intValue());
                                            break;
                                        case 18:
                                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                                            break;
                                        default:
                                            protoReader.readUnknownField(nextTag);
                                            break;
                                    }
                                } else {
                                    aVar.f(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                }
                            } else {
                                aVar.a(AttitudeInfo.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.k(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.w(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, VideoBaseInfo videoBaseInfo) throws IOException {
            if (!Objects.equals(videoBaseInfo.cid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, videoBaseInfo.cid);
            }
            if (!Objects.equals(videoBaseInfo.vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, videoBaseInfo.vid);
            }
            if (!Objects.equals(videoBaseInfo.plot_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, videoBaseInfo.plot_title);
            }
            if (!Objects.equals(videoBaseInfo.episode_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, videoBaseInfo.episode_title);
            }
            if (!Objects.equals(videoBaseInfo.video_score, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, videoBaseInfo.video_score);
            }
            if (!Objects.equals(videoBaseInfo.video_hotval, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, videoBaseInfo.video_hotval);
            }
            if (!Objects.equals(videoBaseInfo.series_num, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, videoBaseInfo.series_num);
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.skip_start), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 8, Integer.valueOf(videoBaseInfo.skip_start));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.skip_end), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 9, Integer.valueOf(videoBaseInfo.skip_end));
            }
            Boolean valueOf = Boolean.valueOf(videoBaseInfo.is_traitor);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 10, Boolean.valueOf(videoBaseInfo.is_traitor));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.video_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 11, Integer.valueOf(videoBaseInfo.video_type));
            }
            if (!Objects.equals(videoBaseInfo.stream_ratio, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, videoBaseInfo.stream_ratio);
            }
            if (!Objects.equals(Long.valueOf(videoBaseInfo.video_file_size), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 13, Long.valueOf(videoBaseInfo.video_file_size));
            }
            if (!Objects.equals(Long.valueOf(videoBaseInfo.audio_file_size), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 14, Long.valueOf(videoBaseInfo.audio_file_size));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.play_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 15, Integer.valueOf(videoBaseInfo.play_type));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.material_starting_time), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 16, Integer.valueOf(videoBaseInfo.material_starting_time));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.material_end_time), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 17, Integer.valueOf(videoBaseInfo.material_end_time));
            }
            if (!Objects.equals(videoBaseInfo.material_aspect_vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, videoBaseInfo.material_aspect_vid);
            }
            if (!Objects.equals(videoBaseInfo.video_type_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 20, videoBaseInfo.video_type_name);
            }
            if (!Objects.equals(videoBaseInfo.material_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 21, videoBaseInfo.material_title);
            }
            if (!Objects.equals(videoBaseInfo.attitude_info, null)) {
                AttitudeInfo.ADAPTER.encodeWithTag(protoWriter, 25, videoBaseInfo.attitude_info);
            }
            if (!Objects.equals(Boolean.valueOf(videoBaseInfo.is_short_video), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 36, Boolean.valueOf(videoBaseInfo.is_short_video));
            }
            protoWriter.writeBytes(videoBaseInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoBaseInfo videoBaseInfo) {
            int encodedSizeWithTag = Objects.equals(videoBaseInfo.cid, "") ? 0 : 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, videoBaseInfo.cid);
            if (!Objects.equals(videoBaseInfo.vid, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(2, videoBaseInfo.vid);
            }
            if (!Objects.equals(videoBaseInfo.plot_title, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(3, videoBaseInfo.plot_title);
            }
            if (!Objects.equals(videoBaseInfo.episode_title, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(4, videoBaseInfo.episode_title);
            }
            if (!Objects.equals(videoBaseInfo.video_score, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(5, videoBaseInfo.video_score);
            }
            if (!Objects.equals(videoBaseInfo.video_hotval, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(6, videoBaseInfo.video_hotval);
            }
            if (!Objects.equals(videoBaseInfo.series_num, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(7, videoBaseInfo.series_num);
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.skip_start), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(8, Integer.valueOf(videoBaseInfo.skip_start));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.skip_end), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(9, Integer.valueOf(videoBaseInfo.skip_end));
            }
            Boolean valueOf = Boolean.valueOf(videoBaseInfo.is_traitor);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(10, Boolean.valueOf(videoBaseInfo.is_traitor));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.video_type), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(11, Integer.valueOf(videoBaseInfo.video_type));
            }
            if (!Objects.equals(videoBaseInfo.stream_ratio, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(12, videoBaseInfo.stream_ratio);
            }
            if (!Objects.equals(Long.valueOf(videoBaseInfo.video_file_size), 0L)) {
                encodedSizeWithTag += ProtoAdapter.INT64.encodedSizeWithTag(13, Long.valueOf(videoBaseInfo.video_file_size));
            }
            if (!Objects.equals(Long.valueOf(videoBaseInfo.audio_file_size), 0L)) {
                encodedSizeWithTag += ProtoAdapter.INT64.encodedSizeWithTag(14, Long.valueOf(videoBaseInfo.audio_file_size));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.play_type), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(15, Integer.valueOf(videoBaseInfo.play_type));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.material_starting_time), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(16, Integer.valueOf(videoBaseInfo.material_starting_time));
            }
            if (!Objects.equals(Integer.valueOf(videoBaseInfo.material_end_time), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(17, Integer.valueOf(videoBaseInfo.material_end_time));
            }
            if (!Objects.equals(videoBaseInfo.material_aspect_vid, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(18, videoBaseInfo.material_aspect_vid);
            }
            if (!Objects.equals(videoBaseInfo.video_type_name, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(20, videoBaseInfo.video_type_name);
            }
            if (!Objects.equals(videoBaseInfo.material_title, "")) {
                encodedSizeWithTag += ProtoAdapter.STRING.encodedSizeWithTag(21, videoBaseInfo.material_title);
            }
            if (!Objects.equals(videoBaseInfo.attitude_info, null)) {
                encodedSizeWithTag += AttitudeInfo.ADAPTER.encodedSizeWithTag(25, videoBaseInfo.attitude_info);
            }
            if (!Objects.equals(Boolean.valueOf(videoBaseInfo.is_short_video), bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(36, Boolean.valueOf(videoBaseInfo.is_short_video));
            }
            return encodedSizeWithTag + videoBaseInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VideoBaseInfo redact(VideoBaseInfo videoBaseInfo) {
            a newBuilder = videoBaseInfo.newBuilder();
            AttitudeInfo attitudeInfo = newBuilder.f437824u;
            if (attitudeInfo != null) {
                newBuilder.f437824u = AttitudeInfo.ADAPTER.redact(attitudeInfo);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoBaseInfo(a aVar, ByteString byteString) {
        super(ADAPTER, byteString);
        String str = aVar.f437804a;
        if (str != null) {
            this.cid = str;
            String str2 = aVar.f437805b;
            if (str2 != null) {
                this.vid = str2;
                String str3 = aVar.f437806c;
                if (str3 != null) {
                    this.plot_title = str3;
                    String str4 = aVar.f437807d;
                    if (str4 != null) {
                        this.episode_title = str4;
                        String str5 = aVar.f437808e;
                        if (str5 != null) {
                            this.video_score = str5;
                            String str6 = aVar.f437809f;
                            if (str6 != null) {
                                this.video_hotval = str6;
                                String str7 = aVar.f437810g;
                                if (str7 != null) {
                                    this.series_num = str7;
                                    this.skip_start = aVar.f437811h;
                                    this.skip_end = aVar.f437812i;
                                    this.is_traitor = aVar.f437813j;
                                    this.video_type = aVar.f437814k;
                                    String str8 = aVar.f437815l;
                                    if (str8 != null) {
                                        this.stream_ratio = str8;
                                        this.video_file_size = aVar.f437816m;
                                        this.audio_file_size = aVar.f437817n;
                                        this.play_type = aVar.f437818o;
                                        this.material_starting_time = aVar.f437819p;
                                        this.material_end_time = aVar.f437820q;
                                        String str9 = aVar.f437821r;
                                        if (str9 != null) {
                                            this.material_aspect_vid = str9;
                                            String str10 = aVar.f437822s;
                                            if (str10 != null) {
                                                this.video_type_name = str10;
                                                String str11 = aVar.f437823t;
                                                if (str11 != null) {
                                                    this.material_title = str11;
                                                    this.attitude_info = aVar.f437824u;
                                                    this.is_short_video = aVar.f437825v;
                                                    return;
                                                }
                                                throw new IllegalArgumentException("builder.material_title == null");
                                            }
                                            throw new IllegalArgumentException("builder.video_type_name == null");
                                        }
                                        throw new IllegalArgumentException("builder.material_aspect_vid == null");
                                    }
                                    throw new IllegalArgumentException("builder.stream_ratio == null");
                                }
                                throw new IllegalArgumentException("builder.series_num == null");
                            }
                            throw new IllegalArgumentException("builder.video_hotval == null");
                        }
                        throw new IllegalArgumentException("builder.video_score == null");
                    }
                    throw new IllegalArgumentException("builder.episode_title == null");
                }
                throw new IllegalArgumentException("builder.plot_title == null");
            }
            throw new IllegalArgumentException("builder.vid == null");
        }
        throw new IllegalArgumentException("builder.cid == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoBaseInfo)) {
            return false;
        }
        VideoBaseInfo videoBaseInfo = (VideoBaseInfo) obj;
        if (unknownFields().equals(videoBaseInfo.unknownFields()) && Internal.equals(this.cid, videoBaseInfo.cid) && Internal.equals(this.vid, videoBaseInfo.vid) && Internal.equals(this.plot_title, videoBaseInfo.plot_title) && Internal.equals(this.episode_title, videoBaseInfo.episode_title) && Internal.equals(this.video_score, videoBaseInfo.video_score) && Internal.equals(this.video_hotval, videoBaseInfo.video_hotval) && Internal.equals(this.series_num, videoBaseInfo.series_num) && Internal.equals(Integer.valueOf(this.skip_start), Integer.valueOf(videoBaseInfo.skip_start)) && Internal.equals(Integer.valueOf(this.skip_end), Integer.valueOf(videoBaseInfo.skip_end)) && Internal.equals(Boolean.valueOf(this.is_traitor), Boolean.valueOf(videoBaseInfo.is_traitor)) && Internal.equals(Integer.valueOf(this.video_type), Integer.valueOf(videoBaseInfo.video_type)) && Internal.equals(this.stream_ratio, videoBaseInfo.stream_ratio) && Internal.equals(Long.valueOf(this.video_file_size), Long.valueOf(videoBaseInfo.video_file_size)) && Internal.equals(Long.valueOf(this.audio_file_size), Long.valueOf(videoBaseInfo.audio_file_size)) && Internal.equals(Integer.valueOf(this.play_type), Integer.valueOf(videoBaseInfo.play_type)) && Internal.equals(Integer.valueOf(this.material_starting_time), Integer.valueOf(videoBaseInfo.material_starting_time)) && Internal.equals(Integer.valueOf(this.material_end_time), Integer.valueOf(videoBaseInfo.material_end_time)) && Internal.equals(this.material_aspect_vid, videoBaseInfo.material_aspect_vid) && Internal.equals(this.video_type_name, videoBaseInfo.video_type_name) && Internal.equals(this.material_title, videoBaseInfo.material_title) && Internal.equals(this.attitude_info, videoBaseInfo.attitude_info) && Internal.equals(Boolean.valueOf(this.is_short_video), Boolean.valueOf(videoBaseInfo.is_short_video))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38 = this.hashCode;
        if (i38 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.cid;
            int i39 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i46 = (hashCode + i3) * 37;
            String str2 = this.vid;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i47 = (i46 + i16) * 37;
            String str3 = this.plot_title;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i48 = (i47 + i17) * 37;
            String str4 = this.episode_title;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i49 = (i48 + i18) * 37;
            String str5 = this.video_score;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i56 = (i49 + i19) * 37;
            String str6 = this.video_hotval;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i57 = (i56 + i26) * 37;
            String str7 = this.series_num;
            if (str7 != null) {
                i27 = str7.hashCode();
            } else {
                i27 = 0;
            }
            int a16 = (((((((((i57 + i27) * 37) + this.skip_start) * 37) + this.skip_end) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_traitor)) * 37) + this.video_type) * 37;
            String str8 = this.stream_ratio;
            if (str8 != null) {
                i28 = str8.hashCode();
            } else {
                i28 = 0;
            }
            int a17 = (((((((((((a16 + i28) * 37) + androidx.fragment.app.a.a(this.video_file_size)) * 37) + androidx.fragment.app.a.a(this.audio_file_size)) * 37) + this.play_type) * 37) + this.material_starting_time) * 37) + this.material_end_time) * 37;
            String str9 = this.material_aspect_vid;
            if (str9 != null) {
                i29 = str9.hashCode();
            } else {
                i29 = 0;
            }
            int i58 = (a17 + i29) * 37;
            String str10 = this.video_type_name;
            if (str10 != null) {
                i36 = str10.hashCode();
            } else {
                i36 = 0;
            }
            int i59 = (i58 + i36) * 37;
            String str11 = this.material_title;
            if (str11 != null) {
                i37 = str11.hashCode();
            } else {
                i37 = 0;
            }
            int i65 = (i59 + i37) * 37;
            AttitudeInfo attitudeInfo = this.attitude_info;
            if (attitudeInfo != null) {
                i39 = attitudeInfo.hashCode();
            }
            int a18 = ((i65 + i39) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_short_video);
            this.hashCode = a18;
            return a18;
        }
        return i38;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.cid != null) {
            sb5.append(", cid=");
            sb5.append(Internal.sanitize(this.cid));
        }
        if (this.vid != null) {
            sb5.append(", vid=");
            sb5.append(Internal.sanitize(this.vid));
        }
        if (this.plot_title != null) {
            sb5.append(", plot_title=");
            sb5.append(Internal.sanitize(this.plot_title));
        }
        if (this.episode_title != null) {
            sb5.append(", episode_title=");
            sb5.append(Internal.sanitize(this.episode_title));
        }
        if (this.video_score != null) {
            sb5.append(", video_score=");
            sb5.append(Internal.sanitize(this.video_score));
        }
        if (this.video_hotval != null) {
            sb5.append(", video_hotval=");
            sb5.append(Internal.sanitize(this.video_hotval));
        }
        if (this.series_num != null) {
            sb5.append(", series_num=");
            sb5.append(Internal.sanitize(this.series_num));
        }
        sb5.append(", skip_start=");
        sb5.append(this.skip_start);
        sb5.append(", skip_end=");
        sb5.append(this.skip_end);
        sb5.append(", is_traitor=");
        sb5.append(this.is_traitor);
        sb5.append(", video_type=");
        sb5.append(this.video_type);
        if (this.stream_ratio != null) {
            sb5.append(", stream_ratio=");
            sb5.append(Internal.sanitize(this.stream_ratio));
        }
        sb5.append(", video_file_size=");
        sb5.append(this.video_file_size);
        sb5.append(", audio_file_size=");
        sb5.append(this.audio_file_size);
        sb5.append(", play_type=");
        sb5.append(this.play_type);
        sb5.append(", material_starting_time=");
        sb5.append(this.material_starting_time);
        sb5.append(", material_end_time=");
        sb5.append(this.material_end_time);
        if (this.material_aspect_vid != null) {
            sb5.append(", material_aspect_vid=");
            sb5.append(Internal.sanitize(this.material_aspect_vid));
        }
        if (this.video_type_name != null) {
            sb5.append(", video_type_name=");
            sb5.append(Internal.sanitize(this.video_type_name));
        }
        if (this.material_title != null) {
            sb5.append(", material_title=");
            sb5.append(Internal.sanitize(this.material_title));
        }
        if (this.attitude_info != null) {
            sb5.append(", attitude_info=");
            sb5.append(this.attitude_info);
        }
        sb5.append(", is_short_video=");
        sb5.append(this.is_short_video);
        StringBuilder replace = sb5.replace(0, 2, "VideoBaseInfo{");
        replace.append('}');
        return replace.toString();
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437804a = this.cid;
        aVar.f437805b = this.vid;
        aVar.f437806c = this.plot_title;
        aVar.f437807d = this.episode_title;
        aVar.f437808e = this.video_score;
        aVar.f437809f = this.video_hotval;
        aVar.f437810g = this.series_num;
        aVar.f437811h = this.skip_start;
        aVar.f437812i = this.skip_end;
        aVar.f437813j = this.is_traitor;
        aVar.f437814k = this.video_type;
        aVar.f437815l = this.stream_ratio;
        aVar.f437816m = this.video_file_size;
        aVar.f437817n = this.audio_file_size;
        aVar.f437818o = this.play_type;
        aVar.f437819p = this.material_starting_time;
        aVar.f437820q = this.material_end_time;
        aVar.f437821r = this.material_aspect_vid;
        aVar.f437822s = this.video_type_name;
        aVar.f437823t = this.material_title;
        aVar.f437824u = this.attitude_info;
        aVar.f437825v = this.is_short_video;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
