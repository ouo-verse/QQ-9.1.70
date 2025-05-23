package tvideo;

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
import okio.ByteString;

/* loaded from: classes30.dex */
public final class QueryVideoPlotListRequest extends Message<QueryVideoPlotListRequest, a> {
    public static final ProtoAdapter<QueryVideoPlotListRequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "pageContext", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> page_context;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> page_params;

    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<QueryVideoPlotListRequest, a> {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, String> f437710a = Internal.newMutableMap();

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f437711b = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueryVideoPlotListRequest build() {
            return new QueryVideoPlotListRequest(this.f437710a, this.f437711b, super.buildUnknownFields());
        }

        public a b(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f437711b = map;
            return this;
        }

        public a c(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f437710a = map;
            return this;
        }
    }

    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<QueryVideoPlotListRequest> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437712a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437713b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) QueryVideoPlotListRequest.class, "type.googleapis.com/tvideo.QueryVideoPlotListRequest", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437713b;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437713b = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437712a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437712a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueryVideoPlotListRequest decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f437711b.putAll(d().decode(protoReader));
                        }
                    } else {
                        aVar.f437710a.putAll(e().decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, QueryVideoPlotListRequest queryVideoPlotListRequest) throws IOException {
            e().encodeWithTag(protoWriter, 1, queryVideoPlotListRequest.page_params);
            d().encodeWithTag(protoWriter, 2, queryVideoPlotListRequest.page_context);
            protoWriter.writeBytes(queryVideoPlotListRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(QueryVideoPlotListRequest queryVideoPlotListRequest) {
            return e().encodedSizeWithTag(1, queryVideoPlotListRequest.page_params) + 0 + d().encodedSizeWithTag(2, queryVideoPlotListRequest.page_context) + queryVideoPlotListRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public QueryVideoPlotListRequest redact(QueryVideoPlotListRequest queryVideoPlotListRequest) {
            a newBuilder = queryVideoPlotListRequest.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public QueryVideoPlotListRequest(Map<String, String> map, Map<String, String> map2) {
        this(map, map2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryVideoPlotListRequest)) {
            return false;
        }
        QueryVideoPlotListRequest queryVideoPlotListRequest = (QueryVideoPlotListRequest) obj;
        if (unknownFields().equals(queryVideoPlotListRequest.unknownFields()) && this.page_params.equals(queryVideoPlotListRequest.page_params) && this.page_context.equals(queryVideoPlotListRequest.page_context)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.page_params.hashCode()) * 37) + this.page_context.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.page_params.isEmpty()) {
            sb5.append(", page_params=");
            sb5.append(this.page_params);
        }
        if (!this.page_context.isEmpty()) {
            sb5.append(", page_context=");
            sb5.append(this.page_context);
        }
        StringBuilder replace = sb5.replace(0, 2, "QueryVideoPlotListRequest{");
        replace.append('}');
        return replace.toString();
    }

    public QueryVideoPlotListRequest(Map<String, String> map, Map<String, String> map2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.page_params = Internal.immutableCopyOf("page_params", map);
        this.page_context = Internal.immutableCopyOf("page_context", map2);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437710a = Internal.copyOf(this.page_params);
        aVar.f437711b = Internal.copyOf(this.page_context);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
