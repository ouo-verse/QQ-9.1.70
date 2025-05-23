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
public final class ClientReportInfo extends Message<ClientReportInfo, a> {
    public static final ProtoAdapter<ClientReportInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "clientSendTimestamp", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final long client_send_timestamp;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<ClientReportInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public long f437589a = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ClientReportInfo build() {
            return new ClientReportInfo(this.f437589a, super.buildUnknownFields());
        }

        public a b(long j3) {
            this.f437589a = j3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<ClientReportInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ClientReportInfo.class, "type.googleapis.com/tvideo.ClientReportInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ClientReportInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.b(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, ClientReportInfo clientReportInfo) throws IOException {
            if (!Objects.equals(Long.valueOf(clientReportInfo.client_send_timestamp), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(clientReportInfo.client_send_timestamp));
            }
            protoWriter.writeBytes(clientReportInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ClientReportInfo clientReportInfo) {
            int i3 = 0;
            if (!Objects.equals(Long.valueOf(clientReportInfo.client_send_timestamp), 0L)) {
                i3 = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(clientReportInfo.client_send_timestamp));
            }
            return i3 + clientReportInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ClientReportInfo redact(ClientReportInfo clientReportInfo) {
            a newBuilder = clientReportInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ClientReportInfo(long j3) {
        this(j3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientReportInfo)) {
            return false;
        }
        ClientReportInfo clientReportInfo = (ClientReportInfo) obj;
        if (unknownFields().equals(clientReportInfo.unknownFields()) && Internal.equals(Long.valueOf(this.client_send_timestamp), Long.valueOf(clientReportInfo.client_send_timestamp))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + androidx.fragment.app.a.a(this.client_send_timestamp);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", client_send_timestamp=");
        sb5.append(this.client_send_timestamp);
        StringBuilder replace = sb5.replace(0, 2, "ClientReportInfo{");
        replace.append('}');
        return replace.toString();
    }

    public ClientReportInfo(long j3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.client_send_timestamp = j3;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437589a = this.client_send_timestamp;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
