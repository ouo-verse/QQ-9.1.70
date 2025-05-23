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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class RequestHead extends Message<RequestHead, a> {
    public static final ProtoAdapter<RequestHead> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.BucketInfo#ADAPTER", jsonName = "bucketInfo", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    public final BucketInfo bucket_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String callee;

    @WireField(adapter = "tvideo.ClientReportInfo#ADAPTER", jsonName = "clientReportInfo", label = WireField.Label.OMIT_IDENTITY, tag = 19)
    public final ClientReportInfo client_report_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final Map<String, String> cookie;

    @WireField(adapter = "tvideo.DeviceInfo#ADAPTER", jsonName = "deviceInfo", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final DeviceInfo device_info;

    @WireField(adapter = "tvideo.EnvInfo#ADAPTER", jsonName = "envInfo", label = WireField.Label.OMIT_IDENTITY, tag = 18)
    public final EnvInfo env_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "extraRequestHead", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final Map<String, String> extra_request_head;

    @WireField(adapter = "tvideo.FlagInfo#ADAPTER", jsonName = "flagInfo", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final FlagInfo flag_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String func;

    @WireField(adapter = "tvideo.LocationInfo#ADAPTER", jsonName = "locationInfo", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final LocationInfo location_info;

    @WireField(adapter = "tvideo.LoginToken#ADAPTER", jsonName = "loginToken", label = WireField.Label.REPEATED, tag = 5)
    public final List<LoginToken> login_token;

    @WireField(adapter = "tvideo.NetworkInfo#ADAPTER", jsonName = "networkInfo", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final NetworkInfo network_info;

    @WireField(adapter = "tvideo.OttInfo#ADAPTER", jsonName = "ottInfo", label = WireField.Label.OMIT_IDENTITY, tag = 17)
    public final OttInfo ott_info;

    @WireField(adapter = "tvideo.PortraitInfo#ADAPTER", jsonName = "portraitInfo", label = WireField.Label.REPEATED, tag = 12)
    public final List<PortraitInfo> portrait_info;

    @WireField(adapter = "tvideo.RefreshTokenRequest#ADAPTER", jsonName = "refreshTokenRequest", label = WireField.Label.OMIT_IDENTITY, tag = 20)
    public final RefreshTokenRequest refresh_token_request;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int request_id;

    @WireField(adapter = "tvideo.SafeInfo#ADAPTER", jsonName = "safeInfo", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final SafeInfo safe_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, label = WireField.Label.OMIT_IDENTITY, tag = 13)
    public final String unique_id;

    @WireField(adapter = "tvideo.UserStatusInfo#ADAPTER", jsonName = "userStatusInfo", label = WireField.Label.OMIT_IDENTITY, tag = 14)
    public final UserStatusInfo user_status_info;

    @WireField(adapter = "tvideo.VersionInfo#ADAPTER", jsonName = "versionInfo", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final VersionInfo version_info;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<RequestHead, a> {

        /* renamed from: d, reason: collision with root package name */
        public SafeInfo f437734d;

        /* renamed from: f, reason: collision with root package name */
        public DeviceInfo f437736f;

        /* renamed from: g, reason: collision with root package name */
        public VersionInfo f437737g;

        /* renamed from: h, reason: collision with root package name */
        public NetworkInfo f437738h;

        /* renamed from: i, reason: collision with root package name */
        public LocationInfo f437739i;

        /* renamed from: j, reason: collision with root package name */
        public FlagInfo f437740j;

        /* renamed from: k, reason: collision with root package name */
        public BucketInfo f437741k;

        /* renamed from: n, reason: collision with root package name */
        public UserStatusInfo f437744n;

        /* renamed from: q, reason: collision with root package name */
        public OttInfo f437747q;

        /* renamed from: r, reason: collision with root package name */
        public EnvInfo f437748r;

        /* renamed from: s, reason: collision with root package name */
        public ClientReportInfo f437749s;

        /* renamed from: t, reason: collision with root package name */
        public RefreshTokenRequest f437750t;

        /* renamed from: a, reason: collision with root package name */
        public int f437731a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437732b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437733c = "";

        /* renamed from: e, reason: collision with root package name */
        public List<LoginToken> f437735e = Internal.newMutableList();

        /* renamed from: l, reason: collision with root package name */
        public List<PortraitInfo> f437742l = Internal.newMutableList();

        /* renamed from: m, reason: collision with root package name */
        public String f437743m = "";

        /* renamed from: o, reason: collision with root package name */
        public Map<String, String> f437745o = Internal.newMutableMap();

        /* renamed from: p, reason: collision with root package name */
        public Map<String, String> f437746p = Internal.newMutableMap();

        public a a(BucketInfo bucketInfo) {
            this.f437741k = bucketInfo;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestHead build() {
            return new RequestHead(this, super.buildUnknownFields());
        }

        public a c(String str) {
            this.f437732b = str;
            return this;
        }

        public a d(ClientReportInfo clientReportInfo) {
            this.f437749s = clientReportInfo;
            return this;
        }

        public a e(DeviceInfo deviceInfo) {
            this.f437736f = deviceInfo;
            return this;
        }

        public a f(EnvInfo envInfo) {
            this.f437748r = envInfo;
            return this;
        }

        public a g(Map<String, String> map) {
            Internal.checkElementsNotNull(map);
            this.f437745o = map;
            return this;
        }

        public a h(FlagInfo flagInfo) {
            this.f437740j = flagInfo;
            return this;
        }

        public a i(String str) {
            this.f437733c = str;
            return this;
        }

        public a j(LocationInfo locationInfo) {
            this.f437739i = locationInfo;
            return this;
        }

        public a k(List<LoginToken> list) {
            Internal.checkElementsNotNull(list);
            this.f437735e = list;
            return this;
        }

        public a l(NetworkInfo networkInfo) {
            this.f437738h = networkInfo;
            return this;
        }

        public a m(OttInfo ottInfo) {
            this.f437747q = ottInfo;
            return this;
        }

        public a n(RefreshTokenRequest refreshTokenRequest) {
            this.f437750t = refreshTokenRequest;
            return this;
        }

        public a o(int i3) {
            this.f437731a = i3;
            return this;
        }

        public a p(SafeInfo safeInfo) {
            this.f437734d = safeInfo;
            return this;
        }

        public a q(String str) {
            this.f437743m = str;
            return this;
        }

        public a r(UserStatusInfo userStatusInfo) {
            this.f437744n = userStatusInfo;
            return this;
        }

        public a s(VersionInfo versionInfo) {
            this.f437737g = versionInfo;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<RequestHead> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437751a;

        /* renamed from: b, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437752b;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RequestHead.class, "type.googleapis.com/tvideo.RequestHead", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> a() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437752b;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437752b = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        private ProtoAdapter<Map<String, String>> e() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437751a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437751a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestHead decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.o(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.i(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.p(SafeInfo.ADAPTER.decode(protoReader));
                            break;
                        case 5:
                            aVar.f437735e.add(LoginToken.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            aVar.e(DeviceInfo.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            aVar.s(VersionInfo.ADAPTER.decode(protoReader));
                            break;
                        case 8:
                            aVar.l(NetworkInfo.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            aVar.j(LocationInfo.ADAPTER.decode(protoReader));
                            break;
                        case 10:
                            aVar.h(FlagInfo.ADAPTER.decode(protoReader));
                            break;
                        case 11:
                            aVar.a(BucketInfo.ADAPTER.decode(protoReader));
                            break;
                        case 12:
                            aVar.f437742l.add(PortraitInfo.ADAPTER.decode(protoReader));
                            break;
                        case 13:
                            aVar.q(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            aVar.r(UserStatusInfo.ADAPTER.decode(protoReader));
                            break;
                        case 15:
                            aVar.f437745o.putAll(e().decode(protoReader));
                            break;
                        case 16:
                            aVar.f437746p.putAll(a().decode(protoReader));
                            break;
                        case 17:
                            aVar.m(OttInfo.ADAPTER.decode(protoReader));
                            break;
                        case 18:
                            aVar.f(EnvInfo.ADAPTER.decode(protoReader));
                            break;
                        case 19:
                            aVar.d(ClientReportInfo.ADAPTER.decode(protoReader));
                            break;
                        case 20:
                            aVar.n(RefreshTokenRequest.ADAPTER.decode(protoReader));
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
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RequestHead requestHead) throws IOException {
            if (!Objects.equals(Integer.valueOf(requestHead.request_id), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(requestHead.request_id));
            }
            if (!Objects.equals(requestHead.callee, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, requestHead.callee);
            }
            if (!Objects.equals(requestHead.func, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, requestHead.func);
            }
            if (!Objects.equals(requestHead.safe_info, null)) {
                SafeInfo.ADAPTER.encodeWithTag(protoWriter, 4, requestHead.safe_info);
            }
            LoginToken.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, requestHead.login_token);
            if (!Objects.equals(requestHead.device_info, null)) {
                DeviceInfo.ADAPTER.encodeWithTag(protoWriter, 6, requestHead.device_info);
            }
            if (!Objects.equals(requestHead.version_info, null)) {
                VersionInfo.ADAPTER.encodeWithTag(protoWriter, 7, requestHead.version_info);
            }
            if (!Objects.equals(requestHead.network_info, null)) {
                NetworkInfo.ADAPTER.encodeWithTag(protoWriter, 8, requestHead.network_info);
            }
            if (!Objects.equals(requestHead.location_info, null)) {
                LocationInfo.ADAPTER.encodeWithTag(protoWriter, 9, requestHead.location_info);
            }
            if (!Objects.equals(requestHead.flag_info, null)) {
                FlagInfo.ADAPTER.encodeWithTag(protoWriter, 10, requestHead.flag_info);
            }
            if (!Objects.equals(requestHead.bucket_info, null)) {
                BucketInfo.ADAPTER.encodeWithTag(protoWriter, 11, requestHead.bucket_info);
            }
            PortraitInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 12, requestHead.portrait_info);
            if (!Objects.equals(requestHead.unique_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, requestHead.unique_id);
            }
            if (!Objects.equals(requestHead.user_status_info, null)) {
                UserStatusInfo.ADAPTER.encodeWithTag(protoWriter, 14, requestHead.user_status_info);
            }
            e().encodeWithTag(protoWriter, 15, requestHead.extra_request_head);
            a().encodeWithTag(protoWriter, 16, requestHead.cookie);
            if (!Objects.equals(requestHead.ott_info, null)) {
                OttInfo.ADAPTER.encodeWithTag(protoWriter, 17, requestHead.ott_info);
            }
            if (!Objects.equals(requestHead.env_info, null)) {
                EnvInfo.ADAPTER.encodeWithTag(protoWriter, 18, requestHead.env_info);
            }
            if (!Objects.equals(requestHead.client_report_info, null)) {
                ClientReportInfo.ADAPTER.encodeWithTag(protoWriter, 19, requestHead.client_report_info);
            }
            if (!Objects.equals(requestHead.refresh_token_request, null)) {
                RefreshTokenRequest.ADAPTER.encodeWithTag(protoWriter, 20, requestHead.refresh_token_request);
            }
            protoWriter.writeBytes(requestHead.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RequestHead requestHead) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(requestHead.request_id), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(requestHead.request_id));
            }
            if (!Objects.equals(requestHead.callee, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, requestHead.callee);
            }
            if (!Objects.equals(requestHead.func, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, requestHead.func);
            }
            if (!Objects.equals(requestHead.safe_info, null)) {
                i3 += SafeInfo.ADAPTER.encodedSizeWithTag(4, requestHead.safe_info);
            }
            int encodedSizeWithTag = i3 + LoginToken.ADAPTER.asRepeated().encodedSizeWithTag(5, requestHead.login_token);
            if (!Objects.equals(requestHead.device_info, null)) {
                encodedSizeWithTag += DeviceInfo.ADAPTER.encodedSizeWithTag(6, requestHead.device_info);
            }
            if (!Objects.equals(requestHead.version_info, null)) {
                encodedSizeWithTag += VersionInfo.ADAPTER.encodedSizeWithTag(7, requestHead.version_info);
            }
            if (!Objects.equals(requestHead.network_info, null)) {
                encodedSizeWithTag += NetworkInfo.ADAPTER.encodedSizeWithTag(8, requestHead.network_info);
            }
            if (!Objects.equals(requestHead.location_info, null)) {
                encodedSizeWithTag += LocationInfo.ADAPTER.encodedSizeWithTag(9, requestHead.location_info);
            }
            if (!Objects.equals(requestHead.flag_info, null)) {
                encodedSizeWithTag += FlagInfo.ADAPTER.encodedSizeWithTag(10, requestHead.flag_info);
            }
            if (!Objects.equals(requestHead.bucket_info, null)) {
                encodedSizeWithTag += BucketInfo.ADAPTER.encodedSizeWithTag(11, requestHead.bucket_info);
            }
            int encodedSizeWithTag2 = encodedSizeWithTag + PortraitInfo.ADAPTER.asRepeated().encodedSizeWithTag(12, requestHead.portrait_info);
            if (!Objects.equals(requestHead.unique_id, "")) {
                encodedSizeWithTag2 += ProtoAdapter.STRING.encodedSizeWithTag(13, requestHead.unique_id);
            }
            if (!Objects.equals(requestHead.user_status_info, null)) {
                encodedSizeWithTag2 += UserStatusInfo.ADAPTER.encodedSizeWithTag(14, requestHead.user_status_info);
            }
            int encodedSizeWithTag3 = encodedSizeWithTag2 + e().encodedSizeWithTag(15, requestHead.extra_request_head) + a().encodedSizeWithTag(16, requestHead.cookie);
            if (!Objects.equals(requestHead.ott_info, null)) {
                encodedSizeWithTag3 += OttInfo.ADAPTER.encodedSizeWithTag(17, requestHead.ott_info);
            }
            if (!Objects.equals(requestHead.env_info, null)) {
                encodedSizeWithTag3 += EnvInfo.ADAPTER.encodedSizeWithTag(18, requestHead.env_info);
            }
            if (!Objects.equals(requestHead.client_report_info, null)) {
                encodedSizeWithTag3 += ClientReportInfo.ADAPTER.encodedSizeWithTag(19, requestHead.client_report_info);
            }
            if (!Objects.equals(requestHead.refresh_token_request, null)) {
                encodedSizeWithTag3 += RefreshTokenRequest.ADAPTER.encodedSizeWithTag(20, requestHead.refresh_token_request);
            }
            return encodedSizeWithTag3 + requestHead.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public RequestHead redact(RequestHead requestHead) {
            a newBuilder = requestHead.newBuilder();
            SafeInfo safeInfo = newBuilder.f437734d;
            if (safeInfo != null) {
                newBuilder.f437734d = SafeInfo.ADAPTER.redact(safeInfo);
            }
            Internal.redactElements(newBuilder.f437735e, LoginToken.ADAPTER);
            DeviceInfo deviceInfo = newBuilder.f437736f;
            if (deviceInfo != null) {
                newBuilder.f437736f = DeviceInfo.ADAPTER.redact(deviceInfo);
            }
            VersionInfo versionInfo = newBuilder.f437737g;
            if (versionInfo != null) {
                newBuilder.f437737g = VersionInfo.ADAPTER.redact(versionInfo);
            }
            NetworkInfo networkInfo = newBuilder.f437738h;
            if (networkInfo != null) {
                newBuilder.f437738h = NetworkInfo.ADAPTER.redact(networkInfo);
            }
            LocationInfo locationInfo = newBuilder.f437739i;
            if (locationInfo != null) {
                newBuilder.f437739i = LocationInfo.ADAPTER.redact(locationInfo);
            }
            FlagInfo flagInfo = newBuilder.f437740j;
            if (flagInfo != null) {
                newBuilder.f437740j = FlagInfo.ADAPTER.redact(flagInfo);
            }
            BucketInfo bucketInfo = newBuilder.f437741k;
            if (bucketInfo != null) {
                newBuilder.f437741k = BucketInfo.ADAPTER.redact(bucketInfo);
            }
            Internal.redactElements(newBuilder.f437742l, PortraitInfo.ADAPTER);
            UserStatusInfo userStatusInfo = newBuilder.f437744n;
            if (userStatusInfo != null) {
                newBuilder.f437744n = UserStatusInfo.ADAPTER.redact(userStatusInfo);
            }
            OttInfo ottInfo = newBuilder.f437747q;
            if (ottInfo != null) {
                newBuilder.f437747q = OttInfo.ADAPTER.redact(ottInfo);
            }
            EnvInfo envInfo = newBuilder.f437748r;
            if (envInfo != null) {
                newBuilder.f437748r = EnvInfo.ADAPTER.redact(envInfo);
            }
            ClientReportInfo clientReportInfo = newBuilder.f437749s;
            if (clientReportInfo != null) {
                newBuilder.f437749s = ClientReportInfo.ADAPTER.redact(clientReportInfo);
            }
            RefreshTokenRequest refreshTokenRequest = newBuilder.f437750t;
            if (refreshTokenRequest != null) {
                newBuilder.f437750t = RefreshTokenRequest.ADAPTER.redact(refreshTokenRequest);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RequestHead(a aVar, ByteString byteString) {
        super(ADAPTER, byteString);
        this.request_id = aVar.f437731a;
        String str = aVar.f437732b;
        if (str != null) {
            this.callee = str;
            String str2 = aVar.f437733c;
            if (str2 != null) {
                this.func = str2;
                this.safe_info = aVar.f437734d;
                this.login_token = Internal.immutableCopyOf("login_token", aVar.f437735e);
                this.device_info = aVar.f437736f;
                this.version_info = aVar.f437737g;
                this.network_info = aVar.f437738h;
                this.location_info = aVar.f437739i;
                this.flag_info = aVar.f437740j;
                this.bucket_info = aVar.f437741k;
                this.portrait_info = Internal.immutableCopyOf("portrait_info", aVar.f437742l);
                String str3 = aVar.f437743m;
                if (str3 != null) {
                    this.unique_id = str3;
                    this.user_status_info = aVar.f437744n;
                    this.extra_request_head = Internal.immutableCopyOf("extra_request_head", aVar.f437745o);
                    this.cookie = Internal.immutableCopyOf("cookie", aVar.f437746p);
                    this.ott_info = aVar.f437747q;
                    this.env_info = aVar.f437748r;
                    this.client_report_info = aVar.f437749s;
                    this.refresh_token_request = aVar.f437750t;
                    return;
                }
                throw new IllegalArgumentException("builder.unique_id == null");
            }
            throw new IllegalArgumentException("builder.func == null");
        }
        throw new IllegalArgumentException("builder.callee == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestHead)) {
            return false;
        }
        RequestHead requestHead = (RequestHead) obj;
        if (unknownFields().equals(requestHead.unknownFields()) && Internal.equals(Integer.valueOf(this.request_id), Integer.valueOf(requestHead.request_id)) && Internal.equals(this.callee, requestHead.callee) && Internal.equals(this.func, requestHead.func) && Internal.equals(this.safe_info, requestHead.safe_info) && this.login_token.equals(requestHead.login_token) && Internal.equals(this.device_info, requestHead.device_info) && Internal.equals(this.version_info, requestHead.version_info) && Internal.equals(this.network_info, requestHead.network_info) && Internal.equals(this.location_info, requestHead.location_info) && Internal.equals(this.flag_info, requestHead.flag_info) && Internal.equals(this.bucket_info, requestHead.bucket_info) && this.portrait_info.equals(requestHead.portrait_info) && Internal.equals(this.unique_id, requestHead.unique_id) && Internal.equals(this.user_status_info, requestHead.user_status_info) && this.extra_request_head.equals(requestHead.extra_request_head) && this.cookie.equals(requestHead.cookie) && Internal.equals(this.ott_info, requestHead.ott_info) && Internal.equals(this.env_info, requestHead.env_info) && Internal.equals(this.client_report_info, requestHead.client_report_info) && Internal.equals(this.refresh_token_request, requestHead.refresh_token_request)) {
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
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47 = this.hashCode;
        if (i47 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.request_id) * 37;
            String str = this.callee;
            int i48 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i49 = (hashCode + i3) * 37;
            String str2 = this.func;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i56 = (i49 + i16) * 37;
            SafeInfo safeInfo = this.safe_info;
            if (safeInfo != null) {
                i17 = safeInfo.hashCode();
            } else {
                i17 = 0;
            }
            int hashCode2 = (((i56 + i17) * 37) + this.login_token.hashCode()) * 37;
            DeviceInfo deviceInfo = this.device_info;
            if (deviceInfo != null) {
                i18 = deviceInfo.hashCode();
            } else {
                i18 = 0;
            }
            int i57 = (hashCode2 + i18) * 37;
            VersionInfo versionInfo = this.version_info;
            if (versionInfo != null) {
                i19 = versionInfo.hashCode();
            } else {
                i19 = 0;
            }
            int i58 = (i57 + i19) * 37;
            NetworkInfo networkInfo = this.network_info;
            if (networkInfo != null) {
                i26 = networkInfo.hashCode();
            } else {
                i26 = 0;
            }
            int i59 = (i58 + i26) * 37;
            LocationInfo locationInfo = this.location_info;
            if (locationInfo != null) {
                i27 = locationInfo.hashCode();
            } else {
                i27 = 0;
            }
            int i65 = (i59 + i27) * 37;
            FlagInfo flagInfo = this.flag_info;
            if (flagInfo != null) {
                i28 = flagInfo.hashCode();
            } else {
                i28 = 0;
            }
            int i66 = (i65 + i28) * 37;
            BucketInfo bucketInfo = this.bucket_info;
            if (bucketInfo != null) {
                i29 = bucketInfo.hashCode();
            } else {
                i29 = 0;
            }
            int hashCode3 = (((i66 + i29) * 37) + this.portrait_info.hashCode()) * 37;
            String str3 = this.unique_id;
            if (str3 != null) {
                i36 = str3.hashCode();
            } else {
                i36 = 0;
            }
            int i67 = (hashCode3 + i36) * 37;
            UserStatusInfo userStatusInfo = this.user_status_info;
            if (userStatusInfo != null) {
                i37 = userStatusInfo.hashCode();
            } else {
                i37 = 0;
            }
            int hashCode4 = (((((i67 + i37) * 37) + this.extra_request_head.hashCode()) * 37) + this.cookie.hashCode()) * 37;
            OttInfo ottInfo = this.ott_info;
            if (ottInfo != null) {
                i38 = ottInfo.hashCode();
            } else {
                i38 = 0;
            }
            int i68 = (hashCode4 + i38) * 37;
            EnvInfo envInfo = this.env_info;
            if (envInfo != null) {
                i39 = envInfo.hashCode();
            } else {
                i39 = 0;
            }
            int i69 = (i68 + i39) * 37;
            ClientReportInfo clientReportInfo = this.client_report_info;
            if (clientReportInfo != null) {
                i46 = clientReportInfo.hashCode();
            } else {
                i46 = 0;
            }
            int i75 = (i69 + i46) * 37;
            RefreshTokenRequest refreshTokenRequest = this.refresh_token_request;
            if (refreshTokenRequest != null) {
                i48 = refreshTokenRequest.hashCode();
            }
            int i76 = i75 + i48;
            this.hashCode = i76;
            return i76;
        }
        return i47;
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
        if (this.safe_info != null) {
            sb5.append(", safe_info=");
            sb5.append(this.safe_info);
        }
        if (!this.login_token.isEmpty()) {
            sb5.append(", login_token=");
            sb5.append(this.login_token);
        }
        if (this.device_info != null) {
            sb5.append(", device_info=");
            sb5.append(this.device_info);
        }
        if (this.version_info != null) {
            sb5.append(", version_info=");
            sb5.append(this.version_info);
        }
        if (this.network_info != null) {
            sb5.append(", network_info=");
            sb5.append(this.network_info);
        }
        if (this.location_info != null) {
            sb5.append(", location_info=");
            sb5.append(this.location_info);
        }
        if (this.flag_info != null) {
            sb5.append(", flag_info=");
            sb5.append(this.flag_info);
        }
        if (this.bucket_info != null) {
            sb5.append(", bucket_info=");
            sb5.append(this.bucket_info);
        }
        if (!this.portrait_info.isEmpty()) {
            sb5.append(", portrait_info=");
            sb5.append(this.portrait_info);
        }
        if (this.unique_id != null) {
            sb5.append(", unique_id=");
            sb5.append(Internal.sanitize(this.unique_id));
        }
        if (this.user_status_info != null) {
            sb5.append(", user_status_info=");
            sb5.append(this.user_status_info);
        }
        if (!this.extra_request_head.isEmpty()) {
            sb5.append(", extra_request_head=");
            sb5.append(this.extra_request_head);
        }
        if (!this.cookie.isEmpty()) {
            sb5.append(", cookie=");
            sb5.append(this.cookie);
        }
        if (this.ott_info != null) {
            sb5.append(", ott_info=");
            sb5.append(this.ott_info);
        }
        if (this.env_info != null) {
            sb5.append(", env_info=");
            sb5.append(this.env_info);
        }
        if (this.client_report_info != null) {
            sb5.append(", client_report_info=");
            sb5.append(this.client_report_info);
        }
        if (this.refresh_token_request != null) {
            sb5.append(", refresh_token_request=");
            sb5.append(this.refresh_token_request);
        }
        StringBuilder replace = sb5.replace(0, 2, "RequestHead{");
        replace.append('}');
        return replace.toString();
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437731a = this.request_id;
        aVar.f437732b = this.callee;
        aVar.f437733c = this.func;
        aVar.f437734d = this.safe_info;
        aVar.f437735e = Internal.copyOf(this.login_token);
        aVar.f437736f = this.device_info;
        aVar.f437737g = this.version_info;
        aVar.f437738h = this.network_info;
        aVar.f437739i = this.location_info;
        aVar.f437740j = this.flag_info;
        aVar.f437741k = this.bucket_info;
        aVar.f437742l = Internal.copyOf(this.portrait_info);
        aVar.f437743m = this.unique_id;
        aVar.f437744n = this.user_status_info;
        aVar.f437745o = Internal.copyOf(this.extra_request_head);
        aVar.f437746p = Internal.copyOf(this.cookie);
        aVar.f437747q = this.ott_info;
        aVar.f437748r = this.env_info;
        aVar.f437749s = this.client_report_info;
        aVar.f437750t = this.refresh_token_request;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
