package tvideo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class LoginResponse extends Message<LoginResponse, a> {
    public static final ProtoAdapter<LoginResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "errCode", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int err_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "errMsg", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String err_msg;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "extendData", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> extend_data;

    @WireField(adapter = "tvideo.TokenInfo#ADAPTER", jsonName = "tokenInfo", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final TokenInfo token_info;

    @WireField(adapter = "tvideo.UserInfo#ADAPTER", jsonName = ITVKPlayerEventListener.KEY_USER_INFO, label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final UserInfo user_info;

    @WireField(adapter = "tvideo.VideoToken#ADAPTER", jsonName = "videoToken", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final VideoToken video_token;

    @WireField(adapter = "tvideo.VideoToken#ADAPTER", jsonName = "vuServerToken", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final VideoToken vu_server_token;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<LoginResponse, a> {

        /* renamed from: c, reason: collision with root package name */
        public UserInfo f437673c;

        /* renamed from: d, reason: collision with root package name */
        public TokenInfo f437674d;

        /* renamed from: e, reason: collision with root package name */
        public VideoToken f437675e;

        /* renamed from: g, reason: collision with root package name */
        public VideoToken f437677g;

        /* renamed from: a, reason: collision with root package name */
        public int f437671a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437672b = "";

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f437676f = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginResponse build() {
            return new LoginResponse(this.f437671a, this.f437672b, this.f437673c, this.f437674d, this.f437675e, this.f437676f, this.f437677g, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437671a = i3;
            return this;
        }

        public a c(String str) {
            this.f437672b = str;
            return this;
        }

        public a d(TokenInfo tokenInfo) {
            this.f437674d = tokenInfo;
            return this;
        }

        public a e(UserInfo userInfo) {
            this.f437673c = userInfo;
            return this;
        }

        public a f(VideoToken videoToken) {
            this.f437675e = videoToken;
            return this;
        }

        public a g(VideoToken videoToken) {
            this.f437677g = videoToken;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<LoginResponse> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437678a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LoginResponse.class, "type.googleapis.com/tvideo.LoginResponse", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437678a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437678a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginResponse decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.b(ProtoAdapter.UINT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.e(UserInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.d(TokenInfo.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.f(VideoToken.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.f437676f.putAll(d().decode(protoReader));
                            break;
                        case 7:
                            aVar.g(VideoToken.ADAPTER.decode(protoReader));
                            break;
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, LoginResponse loginResponse) throws IOException {
            if (!Objects.equals(Integer.valueOf(loginResponse.err_code), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, Integer.valueOf(loginResponse.err_code));
            }
            if (!Objects.equals(loginResponse.err_msg, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, loginResponse.err_msg);
            }
            if (!Objects.equals(loginResponse.user_info, null)) {
                UserInfo.ADAPTER.encodeWithTag(protoWriter, 3, loginResponse.user_info);
            }
            if (!Objects.equals(loginResponse.token_info, null)) {
                TokenInfo.ADAPTER.encodeWithTag(protoWriter, 4, loginResponse.token_info);
            }
            if (!Objects.equals(loginResponse.video_token, null)) {
                VideoToken.ADAPTER.encodeWithTag(protoWriter, 5, loginResponse.video_token);
            }
            d().encodeWithTag(protoWriter, 6, loginResponse.extend_data);
            if (!Objects.equals(loginResponse.vu_server_token, null)) {
                VideoToken.ADAPTER.encodeWithTag(protoWriter, 7, loginResponse.vu_server_token);
            }
            protoWriter.writeBytes(loginResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(LoginResponse loginResponse) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(loginResponse.err_code), 0)) {
                i3 = 0 + ProtoAdapter.UINT32.encodedSizeWithTag(1, Integer.valueOf(loginResponse.err_code));
            }
            if (!Objects.equals(loginResponse.err_msg, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, loginResponse.err_msg);
            }
            if (!Objects.equals(loginResponse.user_info, null)) {
                i3 += UserInfo.ADAPTER.encodedSizeWithTag(3, loginResponse.user_info);
            }
            if (!Objects.equals(loginResponse.token_info, null)) {
                i3 += TokenInfo.ADAPTER.encodedSizeWithTag(4, loginResponse.token_info);
            }
            if (!Objects.equals(loginResponse.video_token, null)) {
                i3 += VideoToken.ADAPTER.encodedSizeWithTag(5, loginResponse.video_token);
            }
            int encodedSizeWithTag = i3 + d().encodedSizeWithTag(6, loginResponse.extend_data);
            if (!Objects.equals(loginResponse.vu_server_token, null)) {
                encodedSizeWithTag += VideoToken.ADAPTER.encodedSizeWithTag(7, loginResponse.vu_server_token);
            }
            return encodedSizeWithTag + loginResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public LoginResponse redact(LoginResponse loginResponse) {
            a newBuilder = loginResponse.newBuilder();
            UserInfo userInfo = newBuilder.f437673c;
            if (userInfo != null) {
                newBuilder.f437673c = UserInfo.ADAPTER.redact(userInfo);
            }
            TokenInfo tokenInfo = newBuilder.f437674d;
            if (tokenInfo != null) {
                newBuilder.f437674d = TokenInfo.ADAPTER.redact(tokenInfo);
            }
            VideoToken videoToken = newBuilder.f437675e;
            if (videoToken != null) {
                newBuilder.f437675e = VideoToken.ADAPTER.redact(videoToken);
            }
            VideoToken videoToken2 = newBuilder.f437677g;
            if (videoToken2 != null) {
                newBuilder.f437677g = VideoToken.ADAPTER.redact(videoToken2);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LoginResponse(int i3, String str, UserInfo userInfo, TokenInfo tokenInfo, VideoToken videoToken, Map<String, String> map, VideoToken videoToken2) {
        this(i3, str, userInfo, tokenInfo, videoToken, map, videoToken2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginResponse)) {
            return false;
        }
        LoginResponse loginResponse = (LoginResponse) obj;
        if (unknownFields().equals(loginResponse.unknownFields()) && Internal.equals(Integer.valueOf(this.err_code), Integer.valueOf(loginResponse.err_code)) && Internal.equals(this.err_msg, loginResponse.err_msg) && Internal.equals(this.user_info, loginResponse.user_info) && Internal.equals(this.token_info, loginResponse.token_info) && Internal.equals(this.video_token, loginResponse.video_token) && this.extend_data.equals(loginResponse.extend_data) && Internal.equals(this.vu_server_token, loginResponse.vu_server_token)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.hashCode;
        if (i19 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.err_code) * 37;
            String str = this.err_msg;
            int i26 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i27 = (hashCode + i3) * 37;
            UserInfo userInfo = this.user_info;
            if (userInfo != null) {
                i16 = userInfo.hashCode();
            } else {
                i16 = 0;
            }
            int i28 = (i27 + i16) * 37;
            TokenInfo tokenInfo = this.token_info;
            if (tokenInfo != null) {
                i17 = tokenInfo.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (i28 + i17) * 37;
            VideoToken videoToken = this.video_token;
            if (videoToken != null) {
                i18 = videoToken.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode2 = (((i29 + i18) * 37) + this.extend_data.hashCode()) * 37;
            VideoToken videoToken2 = this.vu_server_token;
            if (videoToken2 != null) {
                i26 = videoToken2.hashCode();
            }
            int i36 = hashCode2 + i26;
            this.hashCode = i36;
            return i36;
        }
        return i19;
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
        if (this.user_info != null) {
            sb5.append(", user_info=");
            sb5.append(this.user_info);
        }
        if (this.token_info != null) {
            sb5.append(", token_info=");
            sb5.append(this.token_info);
        }
        if (this.video_token != null) {
            sb5.append(", video_token=");
            sb5.append(this.video_token);
        }
        if (!this.extend_data.isEmpty()) {
            sb5.append(", extend_data=");
            sb5.append(this.extend_data);
        }
        if (this.vu_server_token != null) {
            sb5.append(", vu_server_token=");
            sb5.append(this.vu_server_token);
        }
        StringBuilder replace = sb5.replace(0, 2, "LoginResponse{");
        replace.append('}');
        return replace.toString();
    }

    public LoginResponse(int i3, String str, UserInfo userInfo, TokenInfo tokenInfo, VideoToken videoToken, Map<String, String> map, VideoToken videoToken2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.err_code = i3;
        if (str != null) {
            this.err_msg = str;
            this.user_info = userInfo;
            this.token_info = tokenInfo;
            this.video_token = videoToken;
            this.extend_data = Internal.immutableCopyOf("extend_data", map);
            this.vu_server_token = videoToken2;
            return;
        }
        throw new IllegalArgumentException("err_msg == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437671a = this.err_code;
        aVar.f437672b = this.err_msg;
        aVar.f437673c = this.user_info;
        aVar.f437674d = this.token_info;
        aVar.f437675e = this.video_token;
        aVar.f437676f = Internal.copyOf(this.extend_data);
        aVar.f437677g = this.vu_server_token;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
