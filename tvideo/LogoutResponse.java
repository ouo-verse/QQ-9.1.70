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
public final class LogoutResponse extends Message<LogoutResponse, a> {
    public static final ProtoAdapter<LogoutResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "errCode", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int err_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "errMsg", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String err_msg;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<LogoutResponse, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437687a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437688b = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogoutResponse build() {
            return new LogoutResponse(this.f437687a, this.f437688b, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437687a = i3;
            return this;
        }

        public a c(String str) {
            this.f437688b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<LogoutResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LogoutResponse.class, "type.googleapis.com/tvideo.LogoutResponse", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogoutResponse decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.UINT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, LogoutResponse logoutResponse) throws IOException {
            if (!Objects.equals(Integer.valueOf(logoutResponse.err_code), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, Integer.valueOf(logoutResponse.err_code));
            }
            if (!Objects.equals(logoutResponse.err_msg, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, logoutResponse.err_msg);
            }
            protoWriter.writeBytes(logoutResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(LogoutResponse logoutResponse) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(logoutResponse.err_code), 0)) {
                i3 = 0 + ProtoAdapter.UINT32.encodedSizeWithTag(1, Integer.valueOf(logoutResponse.err_code));
            }
            if (!Objects.equals(logoutResponse.err_msg, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, logoutResponse.err_msg);
            }
            return i3 + logoutResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public LogoutResponse redact(LogoutResponse logoutResponse) {
            a newBuilder = logoutResponse.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LogoutResponse(int i3, String str) {
        this(i3, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogoutResponse)) {
            return false;
        }
        LogoutResponse logoutResponse = (LogoutResponse) obj;
        if (unknownFields().equals(logoutResponse.unknownFields()) && Internal.equals(Integer.valueOf(this.err_code), Integer.valueOf(logoutResponse.err_code)) && Internal.equals(this.err_msg, logoutResponse.err_msg)) {
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
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
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
        StringBuilder replace = sb5.replace(0, 2, "LogoutResponse{");
        replace.append('}');
        return replace.toString();
    }

    public LogoutResponse(int i3, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.err_code = i3;
        if (str != null) {
            this.err_msg = str;
            return;
        }
        throw new IllegalArgumentException("err_msg == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437687a = this.err_code;
        aVar.f437688b = this.err_msg;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
