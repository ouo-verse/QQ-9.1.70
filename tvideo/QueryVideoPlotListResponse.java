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

/* loaded from: classes30.dex */
public final class QueryVideoPlotListResponse extends Message<QueryVideoPlotListResponse, a> {
    public static final ProtoAdapter<QueryVideoPlotListResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.VideoPlotDetails#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final VideoPlotDetails data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "errCode", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int err_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "errMsg", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String err_msg;

    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<QueryVideoPlotListResponse, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437714a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437715b = "";

        /* renamed from: c, reason: collision with root package name */
        public VideoPlotDetails f437716c;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueryVideoPlotListResponse build() {
            return new QueryVideoPlotListResponse(this.f437714a, this.f437715b, this.f437716c, super.buildUnknownFields());
        }

        public a b(VideoPlotDetails videoPlotDetails) {
            this.f437716c = videoPlotDetails;
            return this;
        }

        public a c(int i3) {
            this.f437714a = i3;
            return this;
        }

        public a d(String str) {
            this.f437715b = str;
            return this;
        }
    }

    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<QueryVideoPlotListResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) QueryVideoPlotListResponse.class, "type.googleapis.com/tvideo.QueryVideoPlotListResponse", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QueryVideoPlotListResponse decode(ProtoReader protoReader) throws IOException {
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
                                aVar.b(VideoPlotDetails.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, QueryVideoPlotListResponse queryVideoPlotListResponse) throws IOException {
            if (!Objects.equals(Integer.valueOf(queryVideoPlotListResponse.err_code), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(queryVideoPlotListResponse.err_code));
            }
            if (!Objects.equals(queryVideoPlotListResponse.err_msg, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, queryVideoPlotListResponse.err_msg);
            }
            if (!Objects.equals(queryVideoPlotListResponse.data, null)) {
                VideoPlotDetails.ADAPTER.encodeWithTag(protoWriter, 3, queryVideoPlotListResponse.data);
            }
            protoWriter.writeBytes(queryVideoPlotListResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(QueryVideoPlotListResponse queryVideoPlotListResponse) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(queryVideoPlotListResponse.err_code), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(queryVideoPlotListResponse.err_code));
            }
            if (!Objects.equals(queryVideoPlotListResponse.err_msg, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, queryVideoPlotListResponse.err_msg);
            }
            if (!Objects.equals(queryVideoPlotListResponse.data, null)) {
                i3 += VideoPlotDetails.ADAPTER.encodedSizeWithTag(3, queryVideoPlotListResponse.data);
            }
            return i3 + queryVideoPlotListResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public QueryVideoPlotListResponse redact(QueryVideoPlotListResponse queryVideoPlotListResponse) {
            a newBuilder = queryVideoPlotListResponse.newBuilder();
            VideoPlotDetails videoPlotDetails = newBuilder.f437716c;
            if (videoPlotDetails != null) {
                newBuilder.f437716c = VideoPlotDetails.ADAPTER.redact(videoPlotDetails);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public QueryVideoPlotListResponse(int i3, String str, VideoPlotDetails videoPlotDetails) {
        this(i3, str, videoPlotDetails, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryVideoPlotListResponse)) {
            return false;
        }
        QueryVideoPlotListResponse queryVideoPlotListResponse = (QueryVideoPlotListResponse) obj;
        if (unknownFields().equals(queryVideoPlotListResponse.unknownFields()) && Internal.equals(Integer.valueOf(this.err_code), Integer.valueOf(queryVideoPlotListResponse.err_code)) && Internal.equals(this.err_msg, queryVideoPlotListResponse.err_msg) && Internal.equals(this.data, queryVideoPlotListResponse.data)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.err_code) * 37;
            String str = this.err_msg;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            VideoPlotDetails videoPlotDetails = this.data;
            if (videoPlotDetails != null) {
                i17 = videoPlotDetails.hashCode();
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
        sb5.append(", err_code=");
        sb5.append(this.err_code);
        if (this.err_msg != null) {
            sb5.append(", err_msg=");
            sb5.append(Internal.sanitize(this.err_msg));
        }
        if (this.data != null) {
            sb5.append(", data=");
            sb5.append(this.data);
        }
        StringBuilder replace = sb5.replace(0, 2, "QueryVideoPlotListResponse{");
        replace.append('}');
        return replace.toString();
    }

    public QueryVideoPlotListResponse(int i3, String str, VideoPlotDetails videoPlotDetails, ByteString byteString) {
        super(ADAPTER, byteString);
        this.err_code = i3;
        if (str != null) {
            this.err_msg = str;
            this.data = videoPlotDetails;
            return;
        }
        throw new IllegalArgumentException("err_msg == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437714a = this.err_code;
        aVar.f437715b = this.err_msg;
        aVar.f437716c = this.data;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
