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
public final class LoginRequest extends Message<LoginRequest, a> {
    public static final ProtoAdapter<LoginRequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isUserInitiative", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean is_user_initiative;

    @WireField(adapter = "tvideo.CurLoginToken#ADAPTER", jsonName = "loginToken", label = WireField.Label.REPEATED, tag = 2)
    public final List<CurLoginToken> login_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "useVideoServerToken", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final boolean use_video_server_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "userQuickLogin", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final boolean user_quick_login;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<LoginRequest, a> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f437667a = false;

        /* renamed from: b, reason: collision with root package name */
        public List<CurLoginToken> f437668b = Internal.newMutableList();

        /* renamed from: c, reason: collision with root package name */
        public boolean f437669c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f437670d = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginRequest build() {
            return new LoginRequest(this.f437667a, this.f437668b, this.f437669c, this.f437670d, super.buildUnknownFields());
        }

        public a b(boolean z16) {
            this.f437667a = z16;
            return this;
        }

        public a c(List<CurLoginToken> list) {
            Internal.checkElementsNotNull(list);
            this.f437668b = list;
            return this;
        }

        public a d(boolean z16) {
            this.f437669c = z16;
            return this;
        }

        public a e(boolean z16) {
            this.f437670d = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<LoginRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LoginRequest.class, "type.googleapis.com/tvideo.LoginRequest", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginRequest decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.e(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                }
                            } else {
                                aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            }
                        } else {
                            aVar.f437668b.add(CurLoginToken.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.b(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, LoginRequest loginRequest) throws IOException {
            Boolean valueOf = Boolean.valueOf(loginRequest.is_user_initiative);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(loginRequest.is_user_initiative));
            }
            CurLoginToken.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, loginRequest.login_token);
            if (!Objects.equals(Boolean.valueOf(loginRequest.use_video_server_token), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, Boolean.valueOf(loginRequest.use_video_server_token));
            }
            if (!Objects.equals(Boolean.valueOf(loginRequest.user_quick_login), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, Boolean.valueOf(loginRequest.user_quick_login));
            }
            protoWriter.writeBytes(loginRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(LoginRequest loginRequest) {
            Boolean valueOf = Boolean.valueOf(loginRequest.is_user_initiative);
            Boolean bool = Boolean.FALSE;
            int i3 = 0;
            if (!Objects.equals(valueOf, bool)) {
                i3 = 0 + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(loginRequest.is_user_initiative));
            }
            int encodedSizeWithTag = i3 + CurLoginToken.ADAPTER.asRepeated().encodedSizeWithTag(2, loginRequest.login_token);
            if (!Objects.equals(Boolean.valueOf(loginRequest.use_video_server_token), bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(loginRequest.use_video_server_token));
            }
            if (!Objects.equals(Boolean.valueOf(loginRequest.user_quick_login), bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(4, Boolean.valueOf(loginRequest.user_quick_login));
            }
            return encodedSizeWithTag + loginRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public LoginRequest redact(LoginRequest loginRequest) {
            a newBuilder = loginRequest.newBuilder();
            Internal.redactElements(newBuilder.f437668b, CurLoginToken.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LoginRequest(boolean z16, List<CurLoginToken> list, boolean z17, boolean z18) {
        this(z16, list, z17, z18, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginRequest)) {
            return false;
        }
        LoginRequest loginRequest = (LoginRequest) obj;
        if (unknownFields().equals(loginRequest.unknownFields()) && Internal.equals(Boolean.valueOf(this.is_user_initiative), Boolean.valueOf(loginRequest.is_user_initiative)) && this.login_token.equals(loginRequest.login_token) && Internal.equals(Boolean.valueOf(this.use_video_server_token), Boolean.valueOf(loginRequest.use_video_server_token)) && Internal.equals(Boolean.valueOf(this.user_quick_login), Boolean.valueOf(loginRequest.user_quick_login))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_user_initiative)) * 37) + this.login_token.hashCode()) * 37) + com.tencent.aio.widget.textView.param.a.a(this.use_video_server_token)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.user_quick_login);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", is_user_initiative=");
        sb5.append(this.is_user_initiative);
        if (!this.login_token.isEmpty()) {
            sb5.append(", login_token=");
            sb5.append(this.login_token);
        }
        sb5.append(", use_video_server_token=");
        sb5.append(this.use_video_server_token);
        sb5.append(", user_quick_login=");
        sb5.append(this.user_quick_login);
        StringBuilder replace = sb5.replace(0, 2, "LoginRequest{");
        replace.append('}');
        return replace.toString();
    }

    public LoginRequest(boolean z16, List<CurLoginToken> list, boolean z17, boolean z18, ByteString byteString) {
        super(ADAPTER, byteString);
        this.is_user_initiative = z16;
        this.login_token = Internal.immutableCopyOf("login_token", list);
        this.use_video_server_token = z17;
        this.user_quick_login = z18;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437667a = this.is_user_initiative;
        aVar.f437668b = Internal.copyOf(this.login_token);
        aVar.f437669c = this.use_video_server_token;
        aVar.f437670d = this.user_quick_login;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
