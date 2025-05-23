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
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ServerReportInfo extends Message<ServerReportInfo, a> {
    public static final ProtoAdapter<ServerReportInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "discontentReason", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> discontent_reason;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "serverReceiveTimestamp", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long server_receive_timestamp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "serverRspTime", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final long server_rsp_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "serverSendTimestamp", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final long server_send_timestamp;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<ServerReportInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public long f437770a = 0;

        /* renamed from: b, reason: collision with root package name */
        public List<String> f437771b = Internal.newMutableList();

        /* renamed from: c, reason: collision with root package name */
        public long f437772c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f437773d = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ServerReportInfo build() {
            return new ServerReportInfo(this.f437770a, this.f437771b, this.f437772c, this.f437773d, super.buildUnknownFields());
        }

        public a b(long j3) {
            this.f437772c = j3;
            return this;
        }

        public a c(long j3) {
            this.f437770a = j3;
            return this;
        }

        public a d(long j3) {
            this.f437773d = j3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<ServerReportInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ServerReportInfo.class, "type.googleapis.com/tvideo.ServerReportInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ServerReportInfo decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.d(ProtoAdapter.INT64.decode(protoReader).longValue());
                                }
                            } else {
                                aVar.b(ProtoAdapter.INT64.decode(protoReader).longValue());
                            }
                        } else {
                            aVar.f437771b.add(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, ServerReportInfo serverReportInfo) throws IOException {
            if (!Objects.equals(Long.valueOf(serverReportInfo.server_rsp_time), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(serverReportInfo.server_rsp_time));
            }
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, serverReportInfo.discontent_reason);
            if (!Objects.equals(Long.valueOf(serverReportInfo.server_receive_timestamp), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, Long.valueOf(serverReportInfo.server_receive_timestamp));
            }
            if (!Objects.equals(Long.valueOf(serverReportInfo.server_send_timestamp), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, Long.valueOf(serverReportInfo.server_send_timestamp));
            }
            protoWriter.writeBytes(serverReportInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ServerReportInfo serverReportInfo) {
            int i3 = 0;
            if (!Objects.equals(Long.valueOf(serverReportInfo.server_rsp_time), 0L)) {
                i3 = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(serverReportInfo.server_rsp_time));
            }
            int encodedSizeWithTag = i3 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, serverReportInfo.discontent_reason);
            if (!Objects.equals(Long.valueOf(serverReportInfo.server_receive_timestamp), 0L)) {
                encodedSizeWithTag += ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(serverReportInfo.server_receive_timestamp));
            }
            if (!Objects.equals(Long.valueOf(serverReportInfo.server_send_timestamp), 0L)) {
                encodedSizeWithTag += ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(serverReportInfo.server_send_timestamp));
            }
            return encodedSizeWithTag + serverReportInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ServerReportInfo redact(ServerReportInfo serverReportInfo) {
            a newBuilder = serverReportInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ServerReportInfo(long j3, List<String> list, long j16, long j17) {
        this(j3, list, j16, j17, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServerReportInfo)) {
            return false;
        }
        ServerReportInfo serverReportInfo = (ServerReportInfo) obj;
        if (unknownFields().equals(serverReportInfo.unknownFields()) && Internal.equals(Long.valueOf(this.server_rsp_time), Long.valueOf(serverReportInfo.server_rsp_time)) && this.discontent_reason.equals(serverReportInfo.discontent_reason) && Internal.equals(Long.valueOf(this.server_receive_timestamp), Long.valueOf(serverReportInfo.server_receive_timestamp)) && Internal.equals(Long.valueOf(this.server_send_timestamp), Long.valueOf(serverReportInfo.server_send_timestamp))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.server_rsp_time)) * 37) + this.discontent_reason.hashCode()) * 37) + androidx.fragment.app.a.a(this.server_receive_timestamp)) * 37) + androidx.fragment.app.a.a(this.server_send_timestamp);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", server_rsp_time=");
        sb5.append(this.server_rsp_time);
        if (!this.discontent_reason.isEmpty()) {
            sb5.append(", discontent_reason=");
            sb5.append(Internal.sanitize(this.discontent_reason));
        }
        sb5.append(", server_receive_timestamp=");
        sb5.append(this.server_receive_timestamp);
        sb5.append(", server_send_timestamp=");
        sb5.append(this.server_send_timestamp);
        StringBuilder replace = sb5.replace(0, 2, "ServerReportInfo{");
        replace.append('}');
        return replace.toString();
    }

    public ServerReportInfo(long j3, List<String> list, long j16, long j17, ByteString byteString) {
        super(ADAPTER, byteString);
        this.server_rsp_time = j3;
        this.discontent_reason = Internal.immutableCopyOf("discontent_reason", list);
        this.server_receive_timestamp = j16;
        this.server_send_timestamp = j17;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437770a = this.server_rsp_time;
        aVar.f437771b = Internal.copyOf(this.discontent_reason);
        aVar.f437772c = this.server_receive_timestamp;
        aVar.f437773d = this.server_send_timestamp;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
