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
public final class RefreshTokenResponse extends Message<RefreshTokenResponse, a> {
    public static final ProtoAdapter<RefreshTokenResponse> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "errCode", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int err_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "errMsg", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String err_msg;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "extendData", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> extend_data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isPlatformOverdue", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final boolean is_platform_overdue;

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
    public static final class a extends Message.Builder<RefreshTokenResponse, a> {

        /* renamed from: c, reason: collision with root package name */
        public UserInfo f437724c;

        /* renamed from: d, reason: collision with root package name */
        public TokenInfo f437725d;

        /* renamed from: e, reason: collision with root package name */
        public VideoToken f437726e;

        /* renamed from: g, reason: collision with root package name */
        public VideoToken f437728g;

        /* renamed from: a, reason: collision with root package name */
        public int f437722a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437723b = "";

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f437727f = Internal.newMutableMap();

        /* renamed from: h, reason: collision with root package name */
        public boolean f437729h = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RefreshTokenResponse build() {
            return new RefreshTokenResponse(this.f437722a, this.f437723b, this.f437724c, this.f437725d, this.f437726e, this.f437727f, this.f437728g, this.f437729h, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437722a = i3;
            return this;
        }

        public a c(String str) {
            this.f437723b = str;
            return this;
        }

        public a d(boolean z16) {
            this.f437729h = z16;
            return this;
        }

        public a e(TokenInfo tokenInfo) {
            this.f437725d = tokenInfo;
            return this;
        }

        public a f(UserInfo userInfo) {
            this.f437724c = userInfo;
            return this;
        }

        public a g(VideoToken videoToken) {
            this.f437726e = videoToken;
            return this;
        }

        public a h(VideoToken videoToken) {
            this.f437728g = videoToken;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<RefreshTokenResponse> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437730a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RefreshTokenResponse.class, "type.googleapis.com/tvideo.RefreshTokenResponse", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437730a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437730a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RefreshTokenResponse decode(ProtoReader protoReader) throws IOException {
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
                            aVar.f(UserInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            aVar.e(TokenInfo.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.g(VideoToken.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.f437727f.putAll(d().decode(protoReader));
                            break;
                        case 7:
                            aVar.h(VideoToken.ADAPTER.decode(protoReader));
                            break;
                        case 8:
                            aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
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
        public void encode(ProtoWriter protoWriter, RefreshTokenResponse refreshTokenResponse) throws IOException {
            if (!Objects.equals(Integer.valueOf(refreshTokenResponse.err_code), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 1, Integer.valueOf(refreshTokenResponse.err_code));
            }
            if (!Objects.equals(refreshTokenResponse.err_msg, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, refreshTokenResponse.err_msg);
            }
            if (!Objects.equals(refreshTokenResponse.user_info, null)) {
                UserInfo.ADAPTER.encodeWithTag(protoWriter, 3, refreshTokenResponse.user_info);
            }
            if (!Objects.equals(refreshTokenResponse.token_info, null)) {
                TokenInfo.ADAPTER.encodeWithTag(protoWriter, 4, refreshTokenResponse.token_info);
            }
            if (!Objects.equals(refreshTokenResponse.video_token, null)) {
                VideoToken.ADAPTER.encodeWithTag(protoWriter, 5, refreshTokenResponse.video_token);
            }
            d().encodeWithTag(protoWriter, 6, refreshTokenResponse.extend_data);
            if (!Objects.equals(refreshTokenResponse.vu_server_token, null)) {
                VideoToken.ADAPTER.encodeWithTag(protoWriter, 7, refreshTokenResponse.vu_server_token);
            }
            if (!Objects.equals(Boolean.valueOf(refreshTokenResponse.is_platform_overdue), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 8, Boolean.valueOf(refreshTokenResponse.is_platform_overdue));
            }
            protoWriter.writeBytes(refreshTokenResponse.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RefreshTokenResponse refreshTokenResponse) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(refreshTokenResponse.err_code), 0)) {
                i3 = 0 + ProtoAdapter.UINT32.encodedSizeWithTag(1, Integer.valueOf(refreshTokenResponse.err_code));
            }
            if (!Objects.equals(refreshTokenResponse.err_msg, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, refreshTokenResponse.err_msg);
            }
            if (!Objects.equals(refreshTokenResponse.user_info, null)) {
                i3 += UserInfo.ADAPTER.encodedSizeWithTag(3, refreshTokenResponse.user_info);
            }
            if (!Objects.equals(refreshTokenResponse.token_info, null)) {
                i3 += TokenInfo.ADAPTER.encodedSizeWithTag(4, refreshTokenResponse.token_info);
            }
            if (!Objects.equals(refreshTokenResponse.video_token, null)) {
                i3 += VideoToken.ADAPTER.encodedSizeWithTag(5, refreshTokenResponse.video_token);
            }
            int encodedSizeWithTag = i3 + d().encodedSizeWithTag(6, refreshTokenResponse.extend_data);
            if (!Objects.equals(refreshTokenResponse.vu_server_token, null)) {
                encodedSizeWithTag += VideoToken.ADAPTER.encodedSizeWithTag(7, refreshTokenResponse.vu_server_token);
            }
            if (!Objects.equals(Boolean.valueOf(refreshTokenResponse.is_platform_overdue), Boolean.FALSE)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(8, Boolean.valueOf(refreshTokenResponse.is_platform_overdue));
            }
            return encodedSizeWithTag + refreshTokenResponse.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public RefreshTokenResponse redact(RefreshTokenResponse refreshTokenResponse) {
            a newBuilder = refreshTokenResponse.newBuilder();
            UserInfo userInfo = newBuilder.f437724c;
            if (userInfo != null) {
                newBuilder.f437724c = UserInfo.ADAPTER.redact(userInfo);
            }
            TokenInfo tokenInfo = newBuilder.f437725d;
            if (tokenInfo != null) {
                newBuilder.f437725d = TokenInfo.ADAPTER.redact(tokenInfo);
            }
            VideoToken videoToken = newBuilder.f437726e;
            if (videoToken != null) {
                newBuilder.f437726e = VideoToken.ADAPTER.redact(videoToken);
            }
            VideoToken videoToken2 = newBuilder.f437728g;
            if (videoToken2 != null) {
                newBuilder.f437728g = VideoToken.ADAPTER.redact(videoToken2);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RefreshTokenResponse(int i3, String str, UserInfo userInfo, TokenInfo tokenInfo, VideoToken videoToken, Map<String, String> map, VideoToken videoToken2, boolean z16) {
        this(i3, str, userInfo, tokenInfo, videoToken, map, videoToken2, z16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefreshTokenResponse)) {
            return false;
        }
        RefreshTokenResponse refreshTokenResponse = (RefreshTokenResponse) obj;
        if (unknownFields().equals(refreshTokenResponse.unknownFields()) && Internal.equals(Integer.valueOf(this.err_code), Integer.valueOf(refreshTokenResponse.err_code)) && Internal.equals(this.err_msg, refreshTokenResponse.err_msg) && Internal.equals(this.user_info, refreshTokenResponse.user_info) && Internal.equals(this.token_info, refreshTokenResponse.token_info) && Internal.equals(this.video_token, refreshTokenResponse.video_token) && this.extend_data.equals(refreshTokenResponse.extend_data) && Internal.equals(this.vu_server_token, refreshTokenResponse.vu_server_token) && Internal.equals(Boolean.valueOf(this.is_platform_overdue), Boolean.valueOf(refreshTokenResponse.is_platform_overdue))) {
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
            int a16 = ((hashCode2 + i26) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_platform_overdue);
            this.hashCode = a16;
            return a16;
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
        sb5.append(", is_platform_overdue=");
        sb5.append(this.is_platform_overdue);
        StringBuilder replace = sb5.replace(0, 2, "RefreshTokenResponse{");
        replace.append('}');
        return replace.toString();
    }

    public RefreshTokenResponse(int i3, String str, UserInfo userInfo, TokenInfo tokenInfo, VideoToken videoToken, Map<String, String> map, VideoToken videoToken2, boolean z16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.err_code = i3;
        if (str != null) {
            this.err_msg = str;
            this.user_info = userInfo;
            this.token_info = tokenInfo;
            this.video_token = videoToken;
            this.extend_data = Internal.immutableCopyOf("extend_data", map);
            this.vu_server_token = videoToken2;
            this.is_platform_overdue = z16;
            return;
        }
        throw new IllegalArgumentException("err_msg == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437722a = this.err_code;
        aVar.f437723b = this.err_msg;
        aVar.f437724c = this.user_info;
        aVar.f437725d = this.token_info;
        aVar.f437726e = this.video_token;
        aVar.f437727f = Internal.copyOf(this.extend_data);
        aVar.f437728g = this.vu_server_token;
        aVar.f437729h = this.is_platform_overdue;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
