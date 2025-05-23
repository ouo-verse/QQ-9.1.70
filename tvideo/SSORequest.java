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
public final class SSORequest extends Message<SSORequest, a> {
    public static final ProtoAdapter<SSORequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final ByteString body;

    @WireField(adapter = "tvideo.RequestHead#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final RequestHead header;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<SSORequest, a> {

        /* renamed from: a, reason: collision with root package name */
        public RequestHead f437763a;

        /* renamed from: b, reason: collision with root package name */
        public ByteString f437764b = ByteString.EMPTY;

        public a a(ByteString byteString) {
            this.f437764b = byteString;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SSORequest build() {
            return new SSORequest(this.f437763a, this.f437764b, super.buildUnknownFields());
        }

        public a c(RequestHead requestHead) {
            this.f437763a = requestHead;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<SSORequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SSORequest.class, "type.googleapis.com/tvideo.SSORequest", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SSORequest decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.a(ProtoAdapter.BYTES.decode(protoReader));
                        }
                    } else {
                        aVar.c(RequestHead.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SSORequest sSORequest) throws IOException {
            if (!Objects.equals(sSORequest.header, null)) {
                RequestHead.ADAPTER.encodeWithTag(protoWriter, 1, sSORequest.header);
            }
            if (!Objects.equals(sSORequest.body, ByteString.EMPTY)) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, sSORequest.body);
            }
            protoWriter.writeBytes(sSORequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SSORequest sSORequest) {
            int i3 = 0;
            if (!Objects.equals(sSORequest.header, null)) {
                i3 = 0 + RequestHead.ADAPTER.encodedSizeWithTag(1, sSORequest.header);
            }
            if (!Objects.equals(sSORequest.body, ByteString.EMPTY)) {
                i3 += ProtoAdapter.BYTES.encodedSizeWithTag(2, sSORequest.body);
            }
            return i3 + sSORequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SSORequest redact(SSORequest sSORequest) {
            a newBuilder = sSORequest.newBuilder();
            RequestHead requestHead = newBuilder.f437763a;
            if (requestHead != null) {
                newBuilder.f437763a = RequestHead.ADAPTER.redact(requestHead);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SSORequest(RequestHead requestHead, ByteString byteString) {
        this(requestHead, byteString, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SSORequest)) {
            return false;
        }
        SSORequest sSORequest = (SSORequest) obj;
        if (unknownFields().equals(sSORequest.unknownFields()) && Internal.equals(this.header, sSORequest.header) && Internal.equals(this.body, sSORequest.body)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            RequestHead requestHead = this.header;
            int i17 = 0;
            if (requestHead != null) {
                i3 = requestHead.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            ByteString byteString = this.body;
            if (byteString != null) {
                i17 = byteString.hashCode();
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
        if (this.header != null) {
            sb5.append(", header=");
            sb5.append(this.header);
        }
        if (this.body != null) {
            sb5.append(", body=");
            sb5.append(this.body);
        }
        StringBuilder replace = sb5.replace(0, 2, "SSORequest{");
        replace.append('}');
        return replace.toString();
    }

    public SSORequest(RequestHead requestHead, ByteString byteString, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.header = requestHead;
        if (byteString != null) {
            this.body = byteString;
            return;
        }
        throw new IllegalArgumentException("body == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437763a = this.header;
        aVar.f437764b = this.body;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
