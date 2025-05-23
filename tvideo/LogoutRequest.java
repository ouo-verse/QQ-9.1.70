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
public final class LogoutRequest extends Message<LogoutRequest, a> {
    public static final ProtoAdapter<LogoutRequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.CurLoginToken#ADAPTER", jsonName = "loginToken", label = WireField.Label.REPEATED, tag = 1)
    public final List<CurLoginToken> login_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "useVideoServerToken", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final boolean use_video_server_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "userQuickLogin", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final boolean user_quick_login;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<LogoutRequest, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<CurLoginToken> f437684a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public boolean f437685b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f437686c = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogoutRequest build() {
            return new LogoutRequest(this.f437684a, this.f437685b, this.f437686c, super.buildUnknownFields());
        }

        public a b(List<CurLoginToken> list) {
            Internal.checkElementsNotNull(list);
            this.f437684a = list;
            return this;
        }

        public a c(boolean z16) {
            this.f437685b = z16;
            return this;
        }

        public a d(boolean z16) {
            this.f437686c = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<LogoutRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LogoutRequest.class, "type.googleapis.com/tvideo.LogoutRequest", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LogoutRequest decode(ProtoReader protoReader) throws IOException {
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
                                aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            }
                        } else {
                            aVar.c(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                        }
                    } else {
                        aVar.f437684a.add(CurLoginToken.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, LogoutRequest logoutRequest) throws IOException {
            CurLoginToken.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, logoutRequest.login_token);
            Boolean valueOf = Boolean.valueOf(logoutRequest.use_video_server_token);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, Boolean.valueOf(logoutRequest.use_video_server_token));
            }
            if (!Objects.equals(Boolean.valueOf(logoutRequest.user_quick_login), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, Boolean.valueOf(logoutRequest.user_quick_login));
            }
            protoWriter.writeBytes(logoutRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(LogoutRequest logoutRequest) {
            int encodedSizeWithTag = CurLoginToken.ADAPTER.asRepeated().encodedSizeWithTag(1, logoutRequest.login_token) + 0;
            Boolean valueOf = Boolean.valueOf(logoutRequest.use_video_server_token);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(2, Boolean.valueOf(logoutRequest.use_video_server_token));
            }
            if (!Objects.equals(Boolean.valueOf(logoutRequest.user_quick_login), bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(logoutRequest.user_quick_login));
            }
            return encodedSizeWithTag + logoutRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public LogoutRequest redact(LogoutRequest logoutRequest) {
            a newBuilder = logoutRequest.newBuilder();
            Internal.redactElements(newBuilder.f437684a, CurLoginToken.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LogoutRequest(List<CurLoginToken> list, boolean z16, boolean z17) {
        this(list, z16, z17, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogoutRequest)) {
            return false;
        }
        LogoutRequest logoutRequest = (LogoutRequest) obj;
        if (unknownFields().equals(logoutRequest.unknownFields()) && this.login_token.equals(logoutRequest.login_token) && Internal.equals(Boolean.valueOf(this.use_video_server_token), Boolean.valueOf(logoutRequest.use_video_server_token)) && Internal.equals(Boolean.valueOf(this.user_quick_login), Boolean.valueOf(logoutRequest.user_quick_login))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.login_token.hashCode()) * 37) + com.tencent.aio.widget.textView.param.a.a(this.use_video_server_token)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.user_quick_login);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.login_token.isEmpty()) {
            sb5.append(", login_token=");
            sb5.append(this.login_token);
        }
        sb5.append(", use_video_server_token=");
        sb5.append(this.use_video_server_token);
        sb5.append(", user_quick_login=");
        sb5.append(this.user_quick_login);
        StringBuilder replace = sb5.replace(0, 2, "LogoutRequest{");
        replace.append('}');
        return replace.toString();
    }

    public LogoutRequest(List<CurLoginToken> list, boolean z16, boolean z17, ByteString byteString) {
        super(ADAPTER, byteString);
        this.login_token = Internal.immutableCopyOf("login_token", list);
        this.use_video_server_token = z16;
        this.user_quick_login = z17;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437684a = Internal.copyOf(this.login_token);
        aVar.f437685b = this.use_video_server_token;
        aVar.f437686c = this.user_quick_login;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
