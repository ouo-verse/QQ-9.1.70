package tvideo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class ResponseHead extends Message<ResponseHead, a> {
    public static final ProtoAdapter<ResponseHead> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String callee;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "errCode", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int err_code;

    @WireField(adapter = "tvideo.FlagInfo#ADAPTER", jsonName = "flagInfo", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final FlagInfo flag_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String func;

    @WireField(adapter = "tvideo.PortraitInfo#ADAPTER", jsonName = "portraitInfo", label = WireField.Label.REPEATED, tag = 7)
    public final List<PortraitInfo> portrait_info;

    @WireField(adapter = "tvideo.RefreshTokenResponse#ADAPTER", jsonName = "refreshTokenResponse", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final RefreshTokenResponse refresh_token_response;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int request_id;

    @WireField(adapter = "tvideo.SafeInfo#ADAPTER", jsonName = "safeInfo", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final SafeInfo safe_info;

    @WireField(adapter = "tvideo.ServerReportInfo#ADAPTER", jsonName = "serverReportInfo", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final ServerReportInfo server_report_info;

    @WireField(adapter = "tvideo.UserStatusInfo#ADAPTER", jsonName = "userStatusInfo", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final UserStatusInfo user_status_info;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<ResponseHead, a> {

        /* renamed from: e, reason: collision with root package name */
        public SafeInfo f437757e;

        /* renamed from: f, reason: collision with root package name */
        public FlagInfo f437758f;

        /* renamed from: h, reason: collision with root package name */
        public UserStatusInfo f437760h;

        /* renamed from: i, reason: collision with root package name */
        public ServerReportInfo f437761i;

        /* renamed from: j, reason: collision with root package name */
        public RefreshTokenResponse f437762j;

        /* renamed from: a, reason: collision with root package name */
        public int f437753a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437754b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437755c = "";

        /* renamed from: d, reason: collision with root package name */
        public int f437756d = 0;

        /* renamed from: g, reason: collision with root package name */
        public List<PortraitInfo> f437759g = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseHead build() {
            return new ResponseHead(this.f437753a, this.f437754b, this.f437755c, this.f437756d, this.f437757e, this.f437758f, this.f437759g, this.f437760h, this.f437761i, this.f437762j, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437754b = str;
            return this;
        }

        public a c(int i3) {
            this.f437756d = i3;
            return this;
        }

        public a d(FlagInfo flagInfo) {
            this.f437758f = flagInfo;
            return this;
        }

        public a e(String str) {
            this.f437755c = str;
            return this;
        }

        public a f(RefreshTokenResponse refreshTokenResponse) {
            this.f437762j = refreshTokenResponse;
            return this;
        }

        public a g(int i3) {
            this.f437753a = i3;
            return this;
        }

        public a h(SafeInfo safeInfo) {
            this.f437757e = safeInfo;
            return this;
        }

        public a i(ServerReportInfo serverReportInfo) {
            this.f437761i = serverReportInfo;
            return this;
        }

        public a j(UserStatusInfo userStatusInfo) {
            this.f437760h = userStatusInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<ResponseHead> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) ResponseHead.class, "type.googleapis.com/tvideo.ResponseHead", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResponseHead decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.g(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 5:
                            aVar.h(SafeInfo.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.d(FlagInfo.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            aVar.f437759g.add(PortraitInfo.ADAPTER.decode(protoReader));
                            break;
                        case 8:
                            aVar.j(UserStatusInfo.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            aVar.i(ServerReportInfo.ADAPTER.decode(protoReader));
                            break;
                        case 10:
                            aVar.f(RefreshTokenResponse.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, ResponseHead responseHead) throws IOException {
            if (!Objects.equals(Integer.valueOf(responseHead.request_id), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(responseHead.request_id));
            }
            if (!Objects.equals(responseHead.callee, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, responseHead.callee);
            }
            if (!Objects.equals(responseHead.func, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, responseHead.func);
            }
            if (!Objects.equals(Integer.valueOf(responseHead.err_code), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, Integer.valueOf(responseHead.err_code));
            }
            if (!Objects.equals(responseHead.safe_info, null)) {
                SafeInfo.ADAPTER.encodeWithTag(protoWriter, 5, responseHead.safe_info);
            }
            if (!Objects.equals(responseHead.flag_info, null)) {
                FlagInfo.ADAPTER.encodeWithTag(protoWriter, 6, responseHead.flag_info);
            }
            PortraitInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 7, responseHead.portrait_info);
            if (!Objects.equals(responseHead.user_status_info, null)) {
                UserStatusInfo.ADAPTER.encodeWithTag(protoWriter, 8, responseHead.user_status_info);
            }
            if (!Objects.equals(responseHead.server_report_info, null)) {
                ServerReportInfo.ADAPTER.encodeWithTag(protoWriter, 9, responseHead.server_report_info);
            }
            if (!Objects.equals(responseHead.refresh_token_response, null)) {
                RefreshTokenResponse.ADAPTER.encodeWithTag(protoWriter, 10, responseHead.refresh_token_response);
            }
            protoWriter.writeBytes(responseHead.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(ResponseHead responseHead) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(responseHead.request_id), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(responseHead.request_id));
            }
            if (!Objects.equals(responseHead.callee, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, responseHead.callee);
            }
            if (!Objects.equals(responseHead.func, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, responseHead.func);
            }
            if (!Objects.equals(Integer.valueOf(responseHead.err_code), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(responseHead.err_code));
            }
            if (!Objects.equals(responseHead.safe_info, null)) {
                i3 += SafeInfo.ADAPTER.encodedSizeWithTag(5, responseHead.safe_info);
            }
            if (!Objects.equals(responseHead.flag_info, null)) {
                i3 += FlagInfo.ADAPTER.encodedSizeWithTag(6, responseHead.flag_info);
            }
            int encodedSizeWithTag = i3 + PortraitInfo.ADAPTER.asRepeated().encodedSizeWithTag(7, responseHead.portrait_info);
            if (!Objects.equals(responseHead.user_status_info, null)) {
                encodedSizeWithTag += UserStatusInfo.ADAPTER.encodedSizeWithTag(8, responseHead.user_status_info);
            }
            if (!Objects.equals(responseHead.server_report_info, null)) {
                encodedSizeWithTag += ServerReportInfo.ADAPTER.encodedSizeWithTag(9, responseHead.server_report_info);
            }
            if (!Objects.equals(responseHead.refresh_token_response, null)) {
                encodedSizeWithTag += RefreshTokenResponse.ADAPTER.encodedSizeWithTag(10, responseHead.refresh_token_response);
            }
            return encodedSizeWithTag + responseHead.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ResponseHead redact(ResponseHead responseHead) {
            a newBuilder = responseHead.newBuilder();
            SafeInfo safeInfo = newBuilder.f437757e;
            if (safeInfo != null) {
                newBuilder.f437757e = SafeInfo.ADAPTER.redact(safeInfo);
            }
            FlagInfo flagInfo = newBuilder.f437758f;
            if (flagInfo != null) {
                newBuilder.f437758f = FlagInfo.ADAPTER.redact(flagInfo);
            }
            Internal.redactElements(newBuilder.f437759g, PortraitInfo.ADAPTER);
            UserStatusInfo userStatusInfo = newBuilder.f437760h;
            if (userStatusInfo != null) {
                newBuilder.f437760h = UserStatusInfo.ADAPTER.redact(userStatusInfo);
            }
            ServerReportInfo serverReportInfo = newBuilder.f437761i;
            if (serverReportInfo != null) {
                newBuilder.f437761i = ServerReportInfo.ADAPTER.redact(serverReportInfo);
            }
            RefreshTokenResponse refreshTokenResponse = newBuilder.f437762j;
            if (refreshTokenResponse != null) {
                newBuilder.f437762j = RefreshTokenResponse.ADAPTER.redact(refreshTokenResponse);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public ResponseHead(int i3, String str, String str2, int i16, SafeInfo safeInfo, FlagInfo flagInfo, List<PortraitInfo> list, UserStatusInfo userStatusInfo, ServerReportInfo serverReportInfo, RefreshTokenResponse refreshTokenResponse) {
        this(i3, str, str2, i16, safeInfo, flagInfo, list, userStatusInfo, serverReportInfo, refreshTokenResponse, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResponseHead)) {
            return false;
        }
        ResponseHead responseHead = (ResponseHead) obj;
        if (unknownFields().equals(responseHead.unknownFields()) && Internal.equals(Integer.valueOf(this.request_id), Integer.valueOf(responseHead.request_id)) && Internal.equals(this.callee, responseHead.callee) && Internal.equals(this.func, responseHead.func) && Internal.equals(Integer.valueOf(this.err_code), Integer.valueOf(responseHead.err_code)) && Internal.equals(this.safe_info, responseHead.safe_info) && Internal.equals(this.flag_info, responseHead.flag_info) && this.portrait_info.equals(responseHead.portrait_info) && Internal.equals(this.user_status_info, responseHead.user_status_info) && Internal.equals(this.server_report_info, responseHead.server_report_info) && Internal.equals(this.refresh_token_response, responseHead.refresh_token_response)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27 = this.hashCode;
        if (i27 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.request_id) * 37;
            String str = this.callee;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (hashCode + i3) * 37;
            String str2 = this.func;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (((i29 + i16) * 37) + this.err_code) * 37;
            SafeInfo safeInfo = this.safe_info;
            if (safeInfo != null) {
                i17 = safeInfo.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 37;
            FlagInfo flagInfo = this.flag_info;
            if (flagInfo != null) {
                i18 = flagInfo.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode2 = (((i37 + i18) * 37) + this.portrait_info.hashCode()) * 37;
            UserStatusInfo userStatusInfo = this.user_status_info;
            if (userStatusInfo != null) {
                i19 = userStatusInfo.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (hashCode2 + i19) * 37;
            ServerReportInfo serverReportInfo = this.server_report_info;
            if (serverReportInfo != null) {
                i26 = serverReportInfo.hashCode();
            } else {
                i26 = 0;
            }
            int i39 = (i38 + i26) * 37;
            RefreshTokenResponse refreshTokenResponse = this.refresh_token_response;
            if (refreshTokenResponse != null) {
                i28 = refreshTokenResponse.hashCode();
            }
            int i46 = i39 + i28;
            this.hashCode = i46;
            return i46;
        }
        return i27;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", request_id=");
        sb5.append(this.request_id);
        if (this.callee != null) {
            sb5.append(", callee=");
            sb5.append(Internal.sanitize(this.callee));
        }
        if (this.func != null) {
            sb5.append(", func=");
            sb5.append(Internal.sanitize(this.func));
        }
        sb5.append(", err_code=");
        sb5.append(this.err_code);
        if (this.safe_info != null) {
            sb5.append(", safe_info=");
            sb5.append(this.safe_info);
        }
        if (this.flag_info != null) {
            sb5.append(", flag_info=");
            sb5.append(this.flag_info);
        }
        if (!this.portrait_info.isEmpty()) {
            sb5.append(", portrait_info=");
            sb5.append(this.portrait_info);
        }
        if (this.user_status_info != null) {
            sb5.append(", user_status_info=");
            sb5.append(this.user_status_info);
        }
        if (this.server_report_info != null) {
            sb5.append(", server_report_info=");
            sb5.append(this.server_report_info);
        }
        if (this.refresh_token_response != null) {
            sb5.append(", refresh_token_response=");
            sb5.append(this.refresh_token_response);
        }
        StringBuilder replace = sb5.replace(0, 2, "ResponseHead{");
        replace.append('}');
        return replace.toString();
    }

    public ResponseHead(int i3, String str, String str2, int i16, SafeInfo safeInfo, FlagInfo flagInfo, List<PortraitInfo> list, UserStatusInfo userStatusInfo, ServerReportInfo serverReportInfo, RefreshTokenResponse refreshTokenResponse, ByteString byteString) {
        super(ADAPTER, byteString);
        this.request_id = i3;
        if (str != null) {
            this.callee = str;
            if (str2 != null) {
                this.func = str2;
                this.err_code = i16;
                this.safe_info = safeInfo;
                this.flag_info = flagInfo;
                this.portrait_info = Internal.immutableCopyOf("portrait_info", list);
                this.user_status_info = userStatusInfo;
                this.server_report_info = serverReportInfo;
                this.refresh_token_response = refreshTokenResponse;
                return;
            }
            throw new IllegalArgumentException("func == null");
        }
        throw new IllegalArgumentException("callee == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437753a = this.request_id;
        aVar.f437754b = this.callee;
        aVar.f437755c = this.func;
        aVar.f437756d = this.err_code;
        aVar.f437757e = this.safe_info;
        aVar.f437758f = this.flag_info;
        aVar.f437759g = Internal.copyOf(this.portrait_info);
        aVar.f437760h = this.user_status_info;
        aVar.f437761i = this.server_report_info;
        aVar.f437762j = this.refresh_token_response;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
