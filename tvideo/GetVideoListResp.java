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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GetVideoListResp extends Message<GetVideoListResp, a> {
    public static final ProtoAdapter<GetVideoListResp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int code;

    @WireField(adapter = "tvideo.GetVideoListResp$Data#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final Data data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String detail;

    /* renamed from: msg, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String f437649msg;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class Data extends Message<Data, a> {
        public static final ProtoAdapter<Data> ADAPTER = new b();
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "adRspInfo", label = WireField.Label.OMIT_IDENTITY, tag = 101)
        public final AnyMessage ad_rsp_info;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "pageContext", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 102)
        public final Map<String, String> page_context;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "reportMap", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 103)
        public final Map<String, String> report_map;

        @WireField(adapter = "com.squareup.wire.AnyMessage#ADAPTER", jsonName = "stGetFeedListRsp", label = WireField.Label.OMIT_IDENTITY, tag = 4)
        public final AnyMessage st_get_feed_list_rsp;

        /* compiled from: P */
        /* loaded from: classes30.dex */
        public static final class a extends Message.Builder<Data, a> {

            /* renamed from: a, reason: collision with root package name */
            public AnyMessage f437650a;

            /* renamed from: b, reason: collision with root package name */
            public AnyMessage f437651b;

            /* renamed from: c, reason: collision with root package name */
            public Map<String, String> f437652c = Internal.newMutableMap();

            /* renamed from: d, reason: collision with root package name */
            public Map<String, String> f437653d = Internal.newMutableMap();

            public a a(AnyMessage anyMessage) {
                this.f437651b = anyMessage;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Data build() {
                return new Data(this.f437650a, this.f437651b, this.f437652c, this.f437653d, super.buildUnknownFields());
            }

            public a c(AnyMessage anyMessage) {
                this.f437650a = anyMessage;
                return this;
            }
        }

        /* compiled from: P */
        /* loaded from: classes30.dex */
        private static final class b extends ProtoAdapter<Data> {

            /* renamed from: a, reason: collision with root package name */
            private ProtoAdapter<Map<String, String>> f437654a;

            /* renamed from: b, reason: collision with root package name */
            private ProtoAdapter<Map<String, String>> f437655b;

            public b() {
                super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Data.class, "type.googleapis.com/tvideo.GetVideoListResp.Data", Syntax.PROTO_3, (Object) null);
            }

            private ProtoAdapter<Map<String, String>> d() {
                ProtoAdapter<Map<String, String>> protoAdapter = this.f437654a;
                if (protoAdapter == null) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                    this.f437654a = newMapAdapter;
                    return newMapAdapter;
                }
                return protoAdapter;
            }

            private ProtoAdapter<Map<String, String>> f() {
                ProtoAdapter<Map<String, String>> protoAdapter = this.f437655b;
                if (protoAdapter == null) {
                    ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                    ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                    this.f437655b = newMapAdapter;
                    return newMapAdapter;
                }
                return protoAdapter;
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Data decode(ProtoReader protoReader) throws IOException {
                a aVar = new a();
                long beginMessage = protoReader.beginMessage();
                while (true) {
                    int nextTag = protoReader.nextTag();
                    if (nextTag != -1) {
                        if (nextTag != 4) {
                            switch (nextTag) {
                                case 101:
                                    aVar.a(AnyMessage.ADAPTER.decode(protoReader));
                                    break;
                                case 102:
                                    aVar.f437652c.putAll(d().decode(protoReader));
                                    break;
                                case 103:
                                    aVar.f437653d.putAll(f().decode(protoReader));
                                    break;
                                default:
                                    protoReader.readUnknownField(nextTag);
                                    break;
                            }
                        } else {
                            aVar.c(AnyMessage.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                        return aVar.build();
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void encode(ProtoWriter protoWriter, Data data) throws IOException {
                if (!Objects.equals(data.st_get_feed_list_rsp, null)) {
                    AnyMessage.ADAPTER.encodeWithTag(protoWriter, 4, data.st_get_feed_list_rsp);
                }
                if (!Objects.equals(data.ad_rsp_info, null)) {
                    AnyMessage.ADAPTER.encodeWithTag(protoWriter, 101, data.ad_rsp_info);
                }
                d().encodeWithTag(protoWriter, 102, data.page_context);
                f().encodeWithTag(protoWriter, 103, data.report_map);
                protoWriter.writeBytes(data.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public int encodedSize(Data data) {
                int i3 = 0;
                if (!Objects.equals(data.st_get_feed_list_rsp, null)) {
                    i3 = 0 + AnyMessage.ADAPTER.encodedSizeWithTag(4, data.st_get_feed_list_rsp);
                }
                if (!Objects.equals(data.ad_rsp_info, null)) {
                    i3 += AnyMessage.ADAPTER.encodedSizeWithTag(101, data.ad_rsp_info);
                }
                return i3 + d().encodedSizeWithTag(102, data.page_context) + f().encodedSizeWithTag(103, data.report_map) + data.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Data redact(Data data) {
                a newBuilder = data.newBuilder();
                AnyMessage anyMessage = newBuilder.f437650a;
                if (anyMessage != null) {
                    newBuilder.f437650a = AnyMessage.ADAPTER.redact(anyMessage);
                }
                AnyMessage anyMessage2 = newBuilder.f437651b;
                if (anyMessage2 != null) {
                    newBuilder.f437651b = AnyMessage.ADAPTER.redact(anyMessage2);
                }
                newBuilder.clearUnknownFields();
                return newBuilder.build();
            }
        }

        public Data(AnyMessage anyMessage, AnyMessage anyMessage2, Map<String, String> map, Map<String, String> map2) {
            this(anyMessage, anyMessage2, map, map2, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Data)) {
                return false;
            }
            Data data = (Data) obj;
            if (unknownFields().equals(data.unknownFields()) && Internal.equals(this.st_get_feed_list_rsp, data.st_get_feed_list_rsp) && Internal.equals(this.ad_rsp_info, data.ad_rsp_info) && this.page_context.equals(data.page_context) && this.report_map.equals(data.report_map)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i3;
            int i16 = this.hashCode;
            if (i16 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                AnyMessage anyMessage = this.st_get_feed_list_rsp;
                int i17 = 0;
                if (anyMessage != null) {
                    i3 = anyMessage.hashCode();
                } else {
                    i3 = 0;
                }
                int i18 = (hashCode + i3) * 37;
                AnyMessage anyMessage2 = this.ad_rsp_info;
                if (anyMessage2 != null) {
                    i17 = anyMessage2.hashCode();
                }
                int hashCode2 = ((((i18 + i17) * 37) + this.page_context.hashCode()) * 37) + this.report_map.hashCode();
                this.hashCode = hashCode2;
                return hashCode2;
            }
            return i16;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            StringBuilder sb5 = new StringBuilder();
            if (this.st_get_feed_list_rsp != null) {
                sb5.append(", st_get_feed_list_rsp=");
                sb5.append(this.st_get_feed_list_rsp);
            }
            if (this.ad_rsp_info != null) {
                sb5.append(", ad_rsp_info=");
                sb5.append(this.ad_rsp_info);
            }
            if (!this.page_context.isEmpty()) {
                sb5.append(", page_context=");
                sb5.append(this.page_context);
            }
            if (!this.report_map.isEmpty()) {
                sb5.append(", report_map=");
                sb5.append(this.report_map);
            }
            StringBuilder replace = sb5.replace(0, 2, "Data{");
            replace.append('}');
            return replace.toString();
        }

        public Data(AnyMessage anyMessage, AnyMessage anyMessage2, Map<String, String> map, Map<String, String> map2, ByteString byteString) {
            super(ADAPTER, byteString);
            this.st_get_feed_list_rsp = anyMessage;
            this.ad_rsp_info = anyMessage2;
            this.page_context = Internal.immutableCopyOf("page_context", map);
            this.report_map = Internal.immutableCopyOf("report_map", map2);
        }

        @Override // com.squareup.wire.Message
        public a newBuilder() {
            a aVar = new a();
            aVar.f437650a = this.st_get_feed_list_rsp;
            aVar.f437651b = this.ad_rsp_info;
            aVar.f437652c = Internal.copyOf(this.page_context);
            aVar.f437653d = Internal.copyOf(this.report_map);
            aVar.addUnknownFields(unknownFields());
            return aVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<GetVideoListResp, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437656a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437657b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437658c = "";

        /* renamed from: d, reason: collision with root package name */
        public Data f437659d;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetVideoListResp build() {
            return new GetVideoListResp(this.f437656a, this.f437657b, this.f437658c, this.f437659d, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437656a = i3;
            return this;
        }

        public a c(Data data) {
            this.f437659d = data;
            return this;
        }

        public a d(String str) {
            this.f437658c = str;
            return this;
        }

        public a e(String str) {
            this.f437657b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<GetVideoListResp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetVideoListResp.class, "type.googleapis.com/tvideo.GetVideoListResp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetVideoListResp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    protoReader.readUnknownField(nextTag);
                                } else {
                                    aVar.c(Data.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetVideoListResp getVideoListResp) throws IOException {
            if (!Objects.equals(Integer.valueOf(getVideoListResp.code), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(getVideoListResp.code));
            }
            if (!Objects.equals(getVideoListResp.f437649msg, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, getVideoListResp.f437649msg);
            }
            if (!Objects.equals(getVideoListResp.detail, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, getVideoListResp.detail);
            }
            if (!Objects.equals(getVideoListResp.data, null)) {
                Data.ADAPTER.encodeWithTag(protoWriter, 4, getVideoListResp.data);
            }
            protoWriter.writeBytes(getVideoListResp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetVideoListResp getVideoListResp) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(getVideoListResp.code), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(getVideoListResp.code));
            }
            if (!Objects.equals(getVideoListResp.f437649msg, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, getVideoListResp.f437649msg);
            }
            if (!Objects.equals(getVideoListResp.detail, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, getVideoListResp.detail);
            }
            if (!Objects.equals(getVideoListResp.data, null)) {
                i3 += Data.ADAPTER.encodedSizeWithTag(4, getVideoListResp.data);
            }
            return i3 + getVideoListResp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public GetVideoListResp redact(GetVideoListResp getVideoListResp) {
            a newBuilder = getVideoListResp.newBuilder();
            Data data = newBuilder.f437659d;
            if (data != null) {
                newBuilder.f437659d = Data.ADAPTER.redact(data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetVideoListResp(int i3, String str, String str2, Data data) {
        this(i3, str, str2, data, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetVideoListResp)) {
            return false;
        }
        GetVideoListResp getVideoListResp = (GetVideoListResp) obj;
        if (unknownFields().equals(getVideoListResp.unknownFields()) && Internal.equals(Integer.valueOf(this.code), Integer.valueOf(getVideoListResp.code)) && Internal.equals(this.f437649msg, getVideoListResp.f437649msg) && Internal.equals(this.detail, getVideoListResp.detail) && Internal.equals(this.data, getVideoListResp.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.code) * 37;
            String str = this.f437649msg;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.detail;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            Data data = this.data;
            if (data != null) {
                i18 = data.hashCode();
            }
            int i27 = i26 + i18;
            this.hashCode = i27;
            return i27;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", code=");
        sb5.append(this.code);
        if (this.f437649msg != null) {
            sb5.append(", msg=");
            sb5.append(Internal.sanitize(this.f437649msg));
        }
        if (this.detail != null) {
            sb5.append(", detail=");
            sb5.append(Internal.sanitize(this.detail));
        }
        if (this.data != null) {
            sb5.append(", data=");
            sb5.append(this.data);
        }
        StringBuilder replace = sb5.replace(0, 2, "GetVideoListResp{");
        replace.append('}');
        return replace.toString();
    }

    public GetVideoListResp(int i3, String str, String str2, Data data, ByteString byteString) {
        super(ADAPTER, byteString);
        this.code = i3;
        if (str != null) {
            this.f437649msg = str;
            if (str2 != null) {
                this.detail = str2;
                this.data = data;
                return;
            }
            throw new IllegalArgumentException("detail == null");
        }
        throw new IllegalArgumentException("msg == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437656a = this.code;
        aVar.f437657b = this.f437649msg;
        aVar.f437658c = this.detail;
        aVar.f437659d = this.data;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
