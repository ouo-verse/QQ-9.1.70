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
public final class CoverBaseInfo extends Message<CoverBaseInfo, a> {
    public static final ProtoAdapter<CoverBaseInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String cid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "horizontalPicUrl", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String horizontal_pic_url;

    @WireField(adapter = "tvideo.VideoHotTag#ADAPTER", jsonName = "hotTag", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final VideoHotTag hot_tag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "leadingActor", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final String leading_actor;

    @WireField(adapter = "tvideo.VideoRecommendReason#ADAPTER", jsonName = "recommendReason", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final VideoRecommendReason recommend_reason;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "secondTitle", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String second_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "totalEpisode", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final int total_episode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "verticalPicUrl", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String vertical_pic_url;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<CoverBaseInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437590a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437591b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437592c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f437593d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437594e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f437595f = "";

        /* renamed from: g, reason: collision with root package name */
        public int f437596g = 0;

        /* renamed from: h, reason: collision with root package name */
        public String f437597h = "";

        /* renamed from: i, reason: collision with root package name */
        public VideoHotTag f437598i;

        /* renamed from: j, reason: collision with root package name */
        public VideoRecommendReason f437599j;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoverBaseInfo build() {
            return new CoverBaseInfo(this.f437590a, this.f437591b, this.f437592c, this.f437593d, this.f437594e, this.f437595f, this.f437596g, this.f437597h, this.f437598i, this.f437599j, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437590a = str;
            return this;
        }

        public a c(String str) {
            this.f437594e = str;
            return this;
        }

        public a d(VideoHotTag videoHotTag) {
            this.f437598i = videoHotTag;
            return this;
        }

        public a e(String str) {
            this.f437597h = str;
            return this;
        }

        public a f(VideoRecommendReason videoRecommendReason) {
            this.f437599j = videoRecommendReason;
            return this;
        }

        public a g(String str) {
            this.f437592c = str;
            return this;
        }

        public a h(String str) {
            this.f437591b = str;
            return this;
        }

        public a i(int i3) {
            this.f437596g = i3;
            return this;
        }

        public a j(String str) {
            this.f437595f = str;
            return this;
        }

        public a k(String str) {
            this.f437593d = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<CoverBaseInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) CoverBaseInfo.class, "type.googleapis.com/tvideo.CoverBaseInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoverBaseInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.k(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.j(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.i(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 8:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            aVar.d(VideoHotTag.ADAPTER.decode(protoReader));
                            break;
                        case 10:
                            aVar.f(VideoRecommendReason.ADAPTER.decode(protoReader));
                            break;
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, CoverBaseInfo coverBaseInfo) throws IOException {
            if (!Objects.equals(coverBaseInfo.cid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, coverBaseInfo.cid);
            }
            if (!Objects.equals(coverBaseInfo.title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, coverBaseInfo.title);
            }
            if (!Objects.equals(coverBaseInfo.second_title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, coverBaseInfo.second_title);
            }
            if (!Objects.equals(coverBaseInfo.vertical_pic_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, coverBaseInfo.vertical_pic_url);
            }
            if (!Objects.equals(coverBaseInfo.horizontal_pic_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, coverBaseInfo.horizontal_pic_url);
            }
            if (!Objects.equals(coverBaseInfo.type, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, coverBaseInfo.type);
            }
            if (!Objects.equals(Integer.valueOf(coverBaseInfo.total_episode), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, Integer.valueOf(coverBaseInfo.total_episode));
            }
            if (!Objects.equals(coverBaseInfo.leading_actor, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, coverBaseInfo.leading_actor);
            }
            if (!Objects.equals(coverBaseInfo.hot_tag, null)) {
                VideoHotTag.ADAPTER.encodeWithTag(protoWriter, 9, coverBaseInfo.hot_tag);
            }
            if (!Objects.equals(coverBaseInfo.recommend_reason, null)) {
                VideoRecommendReason.ADAPTER.encodeWithTag(protoWriter, 10, coverBaseInfo.recommend_reason);
            }
            protoWriter.writeBytes(coverBaseInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(CoverBaseInfo coverBaseInfo) {
            int i3;
            if (!Objects.equals(coverBaseInfo.cid, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, coverBaseInfo.cid) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(coverBaseInfo.title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, coverBaseInfo.title);
            }
            if (!Objects.equals(coverBaseInfo.second_title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, coverBaseInfo.second_title);
            }
            if (!Objects.equals(coverBaseInfo.vertical_pic_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, coverBaseInfo.vertical_pic_url);
            }
            if (!Objects.equals(coverBaseInfo.horizontal_pic_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, coverBaseInfo.horizontal_pic_url);
            }
            if (!Objects.equals(coverBaseInfo.type, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, coverBaseInfo.type);
            }
            if (!Objects.equals(Integer.valueOf(coverBaseInfo.total_episode), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(7, Integer.valueOf(coverBaseInfo.total_episode));
            }
            if (!Objects.equals(coverBaseInfo.leading_actor, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(8, coverBaseInfo.leading_actor);
            }
            if (!Objects.equals(coverBaseInfo.hot_tag, null)) {
                i3 += VideoHotTag.ADAPTER.encodedSizeWithTag(9, coverBaseInfo.hot_tag);
            }
            if (!Objects.equals(coverBaseInfo.recommend_reason, null)) {
                i3 += VideoRecommendReason.ADAPTER.encodedSizeWithTag(10, coverBaseInfo.recommend_reason);
            }
            return i3 + coverBaseInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public CoverBaseInfo redact(CoverBaseInfo coverBaseInfo) {
            a newBuilder = coverBaseInfo.newBuilder();
            VideoHotTag videoHotTag = newBuilder.f437598i;
            if (videoHotTag != null) {
                newBuilder.f437598i = VideoHotTag.ADAPTER.redact(videoHotTag);
            }
            VideoRecommendReason videoRecommendReason = newBuilder.f437599j;
            if (videoRecommendReason != null) {
                newBuilder.f437599j = VideoRecommendReason.ADAPTER.redact(videoRecommendReason);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public CoverBaseInfo(String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, VideoHotTag videoHotTag, VideoRecommendReason videoRecommendReason) {
        this(str, str2, str3, str4, str5, str6, i3, str7, videoHotTag, videoRecommendReason, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoverBaseInfo)) {
            return false;
        }
        CoverBaseInfo coverBaseInfo = (CoverBaseInfo) obj;
        if (unknownFields().equals(coverBaseInfo.unknownFields()) && Internal.equals(this.cid, coverBaseInfo.cid) && Internal.equals(this.title, coverBaseInfo.title) && Internal.equals(this.second_title, coverBaseInfo.second_title) && Internal.equals(this.vertical_pic_url, coverBaseInfo.vertical_pic_url) && Internal.equals(this.horizontal_pic_url, coverBaseInfo.horizontal_pic_url) && Internal.equals(this.type, coverBaseInfo.type) && Internal.equals(Integer.valueOf(this.total_episode), Integer.valueOf(coverBaseInfo.total_episode)) && Internal.equals(this.leading_actor, coverBaseInfo.leading_actor) && Internal.equals(this.hot_tag, coverBaseInfo.hot_tag) && Internal.equals(this.recommend_reason, coverBaseInfo.recommend_reason)) {
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
        int i29 = this.hashCode;
        if (i29 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.cid;
            int i36 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i37 = (hashCode + i3) * 37;
            String str2 = this.title;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i38 = (i37 + i16) * 37;
            String str3 = this.second_title;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i39 = (i38 + i17) * 37;
            String str4 = this.vertical_pic_url;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i46 = (i39 + i18) * 37;
            String str5 = this.horizontal_pic_url;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i47 = (i46 + i19) * 37;
            String str6 = this.type;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i48 = (((i47 + i26) * 37) + this.total_episode) * 37;
            String str7 = this.leading_actor;
            if (str7 != null) {
                i27 = str7.hashCode();
            } else {
                i27 = 0;
            }
            int i49 = (i48 + i27) * 37;
            VideoHotTag videoHotTag = this.hot_tag;
            if (videoHotTag != null) {
                i28 = videoHotTag.hashCode();
            } else {
                i28 = 0;
            }
            int i56 = (i49 + i28) * 37;
            VideoRecommendReason videoRecommendReason = this.recommend_reason;
            if (videoRecommendReason != null) {
                i36 = videoRecommendReason.hashCode();
            }
            int i57 = i56 + i36;
            this.hashCode = i57;
            return i57;
        }
        return i29;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.cid != null) {
            sb5.append(", cid=");
            sb5.append(Internal.sanitize(this.cid));
        }
        if (this.title != null) {
            sb5.append(", title=");
            sb5.append(Internal.sanitize(this.title));
        }
        if (this.second_title != null) {
            sb5.append(", second_title=");
            sb5.append(Internal.sanitize(this.second_title));
        }
        if (this.vertical_pic_url != null) {
            sb5.append(", vertical_pic_url=");
            sb5.append(Internal.sanitize(this.vertical_pic_url));
        }
        if (this.horizontal_pic_url != null) {
            sb5.append(", horizontal_pic_url=");
            sb5.append(Internal.sanitize(this.horizontal_pic_url));
        }
        if (this.type != null) {
            sb5.append(", type=");
            sb5.append(Internal.sanitize(this.type));
        }
        sb5.append(", total_episode=");
        sb5.append(this.total_episode);
        if (this.leading_actor != null) {
            sb5.append(", leading_actor=");
            sb5.append(Internal.sanitize(this.leading_actor));
        }
        if (this.hot_tag != null) {
            sb5.append(", hot_tag=");
            sb5.append(this.hot_tag);
        }
        if (this.recommend_reason != null) {
            sb5.append(", recommend_reason=");
            sb5.append(this.recommend_reason);
        }
        StringBuilder replace = sb5.replace(0, 2, "CoverBaseInfo{");
        replace.append('}');
        return replace.toString();
    }

    public CoverBaseInfo(String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, VideoHotTag videoHotTag, VideoRecommendReason videoRecommendReason, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.cid = str;
            if (str2 != null) {
                this.title = str2;
                if (str3 != null) {
                    this.second_title = str3;
                    if (str4 != null) {
                        this.vertical_pic_url = str4;
                        if (str5 != null) {
                            this.horizontal_pic_url = str5;
                            if (str6 != null) {
                                this.type = str6;
                                this.total_episode = i3;
                                if (str7 != null) {
                                    this.leading_actor = str7;
                                    this.hot_tag = videoHotTag;
                                    this.recommend_reason = videoRecommendReason;
                                    return;
                                }
                                throw new IllegalArgumentException("leading_actor == null");
                            }
                            throw new IllegalArgumentException("type == null");
                        }
                        throw new IllegalArgumentException("horizontal_pic_url == null");
                    }
                    throw new IllegalArgumentException("vertical_pic_url == null");
                }
                throw new IllegalArgumentException("second_title == null");
            }
            throw new IllegalArgumentException("title == null");
        }
        throw new IllegalArgumentException("cid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437590a = this.cid;
        aVar.f437591b = this.title;
        aVar.f437592c = this.second_title;
        aVar.f437593d = this.vertical_pic_url;
        aVar.f437594e = this.horizontal_pic_url;
        aVar.f437595f = this.type;
        aVar.f437596g = this.total_episode;
        aVar.f437597h = this.leading_actor;
        aVar.f437598i = this.hot_tag;
        aVar.f437599j = this.recommend_reason;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
