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
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GetVideoListReq extends Message<GetVideoListReq, a> {
    public static final ProtoAdapter<GetVideoListReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "adReqInfo", label = WireField.Label.OMIT_IDENTITY, tag = 103)
    public final AnyMessage ad_req_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "channelId", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int channel_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "loadType", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int load_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "pageContext", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 102)
    public final Map<String, String> page_context;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "pageNum", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int page_num;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 101)
    public final Map<String, String> page_params;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "pageSize", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int page_size;

    /* renamed from: qq, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final long f437635qq;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reserveVid", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final String reserve_vid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String scene;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "videoDirection", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final int video_direction;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<GetVideoListReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437636a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f437637b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f437638c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f437639d = 0;

        /* renamed from: e, reason: collision with root package name */
        public long f437640e = 0;

        /* renamed from: f, reason: collision with root package name */
        public String f437641f = "";

        /* renamed from: g, reason: collision with root package name */
        public int f437642g = 0;

        /* renamed from: h, reason: collision with root package name */
        public String f437643h = "";

        /* renamed from: i, reason: collision with root package name */
        public Map<String, String> f437644i = Internal.newMutableMap();

        /* renamed from: j, reason: collision with root package name */
        public Map<String, String> f437645j = Internal.newMutableMap();

        /* renamed from: k, reason: collision with root package name */
        public AnyMessage f437646k;

        public a a(AnyMessage anyMessage) {
            this.f437646k = anyMessage;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GetVideoListReq build() {
            return new GetVideoListReq(this.f437636a, this.f437637b, this.f437638c, this.f437639d, this.f437640e, this.f437641f, this.f437642g, this.f437643h, this.f437644i, this.f437645j, this.f437646k, super.buildUnknownFields());
        }

        public a c(int i3) {
            this.f437638c = i3;
            return this;
        }

        public a d(int i3) {
            this.f437639d = i3;
            return this;
        }

        public a e(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f437645j = map;
            return this;
        }

        public a f(int i3) {
            this.f437636a = i3;
            return this;
        }

        public a g(int i3) {
            this.f437637b = i3;
            return this;
        }

        public a h(long j3) {
            this.f437640e = j3;
            return this;
        }

        public a i(String str) {
            this.f437643h = str;
            return this;
        }

        public a j(String str) {
            this.f437641f = str;
            return this;
        }

        public a k(int i3) {
            this.f437642g = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<GetVideoListReq> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437647a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437648b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetVideoListReq.class, "type.googleapis.com/tvideo.GetVideoListReq", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437648b;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437648b = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437647a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437647a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetVideoListReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.f(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.g(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 4:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 5:
                            aVar.h(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 6:
                            aVar.j(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.k(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 8:
                            aVar.i(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            switch (nextTag) {
                                case 101:
                                    aVar.f437644i.putAll(e().decode(protoReader));
                                    break;
                                case 102:
                                    aVar.f437645j.putAll(d().decode(protoReader));
                                    break;
                                case 103:
                                    aVar.a(AnyMessage.ADAPTER.decode(protoReader));
                                    break;
                                default:
                                    protoReader.readUnknownField(nextTag);
                                    break;
                            }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetVideoListReq getVideoListReq) throws IOException {
            if (!Objects.equals(Integer.valueOf(getVideoListReq.page_num), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(getVideoListReq.page_num));
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.page_size), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(getVideoListReq.page_size));
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.channel_id), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(getVideoListReq.channel_id));
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.load_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, Integer.valueOf(getVideoListReq.load_type));
            }
            if (!Objects.equals(Long.valueOf(getVideoListReq.f437635qq), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, Long.valueOf(getVideoListReq.f437635qq));
            }
            if (!Objects.equals(getVideoListReq.scene, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, getVideoListReq.scene);
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.video_direction), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, Integer.valueOf(getVideoListReq.video_direction));
            }
            if (!Objects.equals(getVideoListReq.reserve_vid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, getVideoListReq.reserve_vid);
            }
            e().encodeWithTag(protoWriter, 101, getVideoListReq.page_params);
            d().encodeWithTag(protoWriter, 102, getVideoListReq.page_context);
            if (!Objects.equals(getVideoListReq.ad_req_info, null)) {
                AnyMessage.ADAPTER.encodeWithTag(protoWriter, 103, getVideoListReq.ad_req_info);
            }
            protoWriter.writeBytes(getVideoListReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetVideoListReq getVideoListReq) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(getVideoListReq.page_num), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(getVideoListReq.page_num));
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.page_size), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(getVideoListReq.page_size));
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.channel_id), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(getVideoListReq.channel_id));
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.load_type), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(getVideoListReq.load_type));
            }
            if (!Objects.equals(Long.valueOf(getVideoListReq.f437635qq), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(5, Long.valueOf(getVideoListReq.f437635qq));
            }
            if (!Objects.equals(getVideoListReq.scene, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, getVideoListReq.scene);
            }
            if (!Objects.equals(Integer.valueOf(getVideoListReq.video_direction), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(7, Integer.valueOf(getVideoListReq.video_direction));
            }
            if (!Objects.equals(getVideoListReq.reserve_vid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(8, getVideoListReq.reserve_vid);
            }
            int encodedSizeWithTag = i3 + e().encodedSizeWithTag(101, getVideoListReq.page_params) + d().encodedSizeWithTag(102, getVideoListReq.page_context);
            if (!Objects.equals(getVideoListReq.ad_req_info, null)) {
                encodedSizeWithTag += AnyMessage.ADAPTER.encodedSizeWithTag(103, getVideoListReq.ad_req_info);
            }
            return encodedSizeWithTag + getVideoListReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public GetVideoListReq redact(GetVideoListReq getVideoListReq) {
            a newBuilder = getVideoListReq.newBuilder();
            AnyMessage anyMessage = newBuilder.f437646k;
            if (anyMessage != null) {
                newBuilder.f437646k = AnyMessage.ADAPTER.redact(anyMessage);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetVideoListReq(int i3, int i16, int i17, int i18, long j3, String str, int i19, String str2, Map<String, String> map, Map<String, String> map2, AnyMessage anyMessage) {
        this(i3, i16, i17, i18, j3, str, i19, str2, map, map2, anyMessage, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetVideoListReq)) {
            return false;
        }
        GetVideoListReq getVideoListReq = (GetVideoListReq) obj;
        if (unknownFields().equals(getVideoListReq.unknownFields()) && Internal.equals(Integer.valueOf(this.page_num), Integer.valueOf(getVideoListReq.page_num)) && Internal.equals(Integer.valueOf(this.page_size), Integer.valueOf(getVideoListReq.page_size)) && Internal.equals(Integer.valueOf(this.channel_id), Integer.valueOf(getVideoListReq.channel_id)) && Internal.equals(Integer.valueOf(this.load_type), Integer.valueOf(getVideoListReq.load_type)) && Internal.equals(Long.valueOf(this.f437635qq), Long.valueOf(getVideoListReq.f437635qq)) && Internal.equals(this.scene, getVideoListReq.scene) && Internal.equals(Integer.valueOf(this.video_direction), Integer.valueOf(getVideoListReq.video_direction)) && Internal.equals(this.reserve_vid, getVideoListReq.reserve_vid) && this.page_params.equals(getVideoListReq.page_params) && this.page_context.equals(getVideoListReq.page_context) && Internal.equals(this.ad_req_info, getVideoListReq.ad_req_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = ((((((((((unknownFields().hashCode() * 37) + this.page_num) * 37) + this.page_size) * 37) + this.channel_id) * 37) + this.load_type) * 37) + androidx.fragment.app.a.a(this.f437635qq)) * 37;
            String str = this.scene;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (((hashCode + i3) * 37) + this.video_direction) * 37;
            String str2 = this.reserve_vid;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int hashCode2 = (((((i19 + i16) * 37) + this.page_params.hashCode()) * 37) + this.page_context.hashCode()) * 37;
            AnyMessage anyMessage = this.ad_req_info;
            if (anyMessage != null) {
                i18 = anyMessage.hashCode();
            }
            int i26 = hashCode2 + i18;
            this.hashCode = i26;
            return i26;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", page_num=");
        sb5.append(this.page_num);
        sb5.append(", page_size=");
        sb5.append(this.page_size);
        sb5.append(", channel_id=");
        sb5.append(this.channel_id);
        sb5.append(", load_type=");
        sb5.append(this.load_type);
        sb5.append(", qq=");
        sb5.append(this.f437635qq);
        if (this.scene != null) {
            sb5.append(", scene=");
            sb5.append(Internal.sanitize(this.scene));
        }
        sb5.append(", video_direction=");
        sb5.append(this.video_direction);
        if (this.reserve_vid != null) {
            sb5.append(", reserve_vid=");
            sb5.append(Internal.sanitize(this.reserve_vid));
        }
        if (!this.page_params.isEmpty()) {
            sb5.append(", page_params=");
            sb5.append(this.page_params);
        }
        if (!this.page_context.isEmpty()) {
            sb5.append(", page_context=");
            sb5.append(this.page_context);
        }
        if (this.ad_req_info != null) {
            sb5.append(", ad_req_info=");
            sb5.append(this.ad_req_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "GetVideoListReq{");
        replace.append('}');
        return replace.toString();
    }

    public GetVideoListReq(int i3, int i16, int i17, int i18, long j3, String str, int i19, String str2, Map<String, String> map, Map<String, String> map2, AnyMessage anyMessage, ByteString byteString) {
        super(ADAPTER, byteString);
        this.page_num = i3;
        this.page_size = i16;
        this.channel_id = i17;
        this.load_type = i18;
        this.f437635qq = j3;
        if (str != null) {
            this.scene = str;
            this.video_direction = i19;
            if (str2 != null) {
                this.reserve_vid = str2;
                this.page_params = Internal.immutableCopyOf("page_params", map);
                this.page_context = Internal.immutableCopyOf("page_context", map2);
                this.ad_req_info = anyMessage;
                return;
            }
            throw new IllegalArgumentException("reserve_vid == null");
        }
        throw new IllegalArgumentException("scene == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437636a = this.page_num;
        aVar.f437637b = this.page_size;
        aVar.f437638c = this.channel_id;
        aVar.f437639d = this.load_type;
        aVar.f437640e = this.f437635qq;
        aVar.f437641f = this.scene;
        aVar.f437642g = this.video_direction;
        aVar.f437643h = this.reserve_vid;
        aVar.f437644i = Internal.copyOf(this.page_params);
        aVar.f437645j = Internal.copyOf(this.page_context);
        aVar.f437646k = this.ad_req_info;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
