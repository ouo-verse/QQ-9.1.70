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
public final class SSOResponse extends Message<SSOResponse, a> {
    public static final ProtoAdapter<SSOResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final ByteString body;

    @WireField(adapter = "tvideo.ResponseHead#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final ResponseHead header;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<SSOResponse, a> {

        /* renamed from: a, reason: collision with root package name */
        public ResponseHead f437765a;

        /* renamed from: b, reason: collision with root package name */
        public ByteString f437766b = ByteString.EMPTY;

        public a a(ByteString byteString) {
            this.f437766b = byteString;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SSOResponse build() {
            return new SSOResponse(this.f437765a, this.f437766b, super.buildUnknownFields());
        }

        public a c(ResponseHead responseHead) {
            this.f437765a = responseHead;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<SSOResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SSOResponse.class, "type.googleapis.com/tvideo.SSOResponse", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SSOResponse decode(ProtoReader protoReader) throws IOException {
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
                        aVar.c(ResponseHead.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SSOResponse sSOResponse) throws IOException {
            if (!Objects.equals(sSOResponse.header, null)) {
                ResponseHead.ADAPTER.encodeWithTag(protoWriter, 1, sSOResponse.header);
            }
            if (!Objects.equals(sSOResponse.body, ByteString.EMPTY)) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, sSOResponse.body);
            }
            protoWriter.writeBytes(sSOResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SSOResponse sSOResponse) {
            int i3 = 0;
            if (!Objects.equals(sSOResponse.header, null)) {
                i3 = 0 + ResponseHead.ADAPTER.encodedSizeWithTag(1, sSOResponse.header);
            }
            if (!Objects.equals(sSOResponse.body, ByteString.EMPTY)) {
                i3 += ProtoAdapter.BYTES.encodedSizeWithTag(2, sSOResponse.body);
            }
            return i3 + sSOResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SSOResponse redact(SSOResponse sSOResponse) {
            a newBuilder = sSOResponse.newBuilder();
            ResponseHead responseHead = newBuilder.f437765a;
            if (responseHead != null) {
                newBuilder.f437765a = ResponseHead.ADAPTER.redact(responseHead);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SSOResponse(ResponseHead responseHead, ByteString byteString) {
        this(responseHead, byteString, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SSOResponse)) {
            return false;
        }
        SSOResponse sSOResponse = (SSOResponse) obj;
        if (unknownFields().equals(sSOResponse.unknownFields()) && Internal.equals(this.header, sSOResponse.header) && Internal.equals(this.body, sSOResponse.body)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            ResponseHead responseHead = this.header;
            int i17 = 0;
            if (responseHead != null) {
                i3 = responseHead.hashCode();
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
        StringBuilder replace = sb5.replace(0, 2, "SSOResponse{");
        replace.append('}');
        return replace.toString();
    }

    public SSOResponse(ResponseHead responseHead, ByteString byteString, ByteString byteString2) {
        super(ADAPTER, byteString2);
        this.header = responseHead;
        if (byteString != null) {
            this.body = byteString;
            return;
        }
        throw new IllegalArgumentException("body == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437765a = this.header;
        aVar.f437766b = this.body;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
