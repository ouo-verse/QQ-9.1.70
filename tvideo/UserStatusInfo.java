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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UserStatusInfo extends Message<UserStatusInfo, a> {
    public static final ProtoAdapter<UserStatusInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "dyeFlag", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int dye_flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "persistBackendInfo", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> persist_backend_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "previewMode", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final int preview_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "sessionCode", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String session_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "specialUser", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int special_user;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.OMIT_IDENTITY, tag = 30)
    public final long timestamp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "userStatusKey", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String user_status_key;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<UserStatusInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437785a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f437786b = 0;

        /* renamed from: c, reason: collision with root package name */
        public long f437787c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f437788d = "";

        /* renamed from: e, reason: collision with root package name */
        public int f437789e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f437790f = 0;

        /* renamed from: g, reason: collision with root package name */
        public Map<String, String> f437791g = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserStatusInfo build() {
            return new UserStatusInfo(this.f437785a, this.f437786b, this.f437787c, this.f437788d, this.f437789e, this.f437790f, this.f437791g, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437789e = i3;
            return this;
        }

        public a c(int i3) {
            this.f437790f = i3;
            return this;
        }

        public a d(String str) {
            this.f437785a = str;
            return this;
        }

        public a e(int i3) {
            this.f437786b = i3;
            return this;
        }

        public a f(long j3) {
            this.f437787c = j3;
            return this;
        }

        public a g(String str) {
            this.f437788d = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<UserStatusInfo> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, String>> f437792a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) UserStatusInfo.class, "type.googleapis.com/tvideo.UserStatusInfo", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, String>> d() {
            ProtoAdapter<Map<String, String>> protoAdapter = this.f437792a;
            if (protoAdapter == null) {
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                ProtoAdapter<Map<String, String>> newMapAdapter = ProtoAdapter.newMapAdapter(protoAdapter2, protoAdapter2);
                this.f437792a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserStatusInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 30) {
                        switch (nextTag) {
                            case 1:
                                aVar.d(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 2:
                                aVar.e(ProtoAdapter.INT32.decode(protoReader).intValue());
                                break;
                            case 3:
                                aVar.g(ProtoAdapter.STRING.decode(protoReader));
                                break;
                            case 4:
                                aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                                break;
                            case 5:
                                aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                                break;
                            case 6:
                                aVar.f437791g.putAll(d().decode(protoReader));
                                break;
                            default:
                                protoReader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        aVar.f(ProtoAdapter.INT64.decode(protoReader).longValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, UserStatusInfo userStatusInfo) throws IOException {
            if (!Objects.equals(userStatusInfo.session_code, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, userStatusInfo.session_code);
            }
            if (!Objects.equals(Integer.valueOf(userStatusInfo.special_user), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(userStatusInfo.special_user));
            }
            if (!Objects.equals(Long.valueOf(userStatusInfo.timestamp), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 30, Long.valueOf(userStatusInfo.timestamp));
            }
            if (!Objects.equals(userStatusInfo.user_status_key, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, userStatusInfo.user_status_key);
            }
            if (!Objects.equals(Integer.valueOf(userStatusInfo.dye_flag), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, Integer.valueOf(userStatusInfo.dye_flag));
            }
            if (!Objects.equals(Integer.valueOf(userStatusInfo.preview_mode), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, Integer.valueOf(userStatusInfo.preview_mode));
            }
            d().encodeWithTag(protoWriter, 6, userStatusInfo.persist_backend_info);
            protoWriter.writeBytes(userStatusInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(UserStatusInfo userStatusInfo) {
            int i3 = 0;
            if (!Objects.equals(userStatusInfo.session_code, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, userStatusInfo.session_code);
            }
            if (!Objects.equals(Integer.valueOf(userStatusInfo.special_user), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(userStatusInfo.special_user));
            }
            if (!Objects.equals(Long.valueOf(userStatusInfo.timestamp), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(30, Long.valueOf(userStatusInfo.timestamp));
            }
            if (!Objects.equals(userStatusInfo.user_status_key, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, userStatusInfo.user_status_key);
            }
            if (!Objects.equals(Integer.valueOf(userStatusInfo.dye_flag), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(userStatusInfo.dye_flag));
            }
            if (!Objects.equals(Integer.valueOf(userStatusInfo.preview_mode), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(userStatusInfo.preview_mode));
            }
            return i3 + d().encodedSizeWithTag(6, userStatusInfo.persist_backend_info) + userStatusInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public UserStatusInfo redact(UserStatusInfo userStatusInfo) {
            a newBuilder = userStatusInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public UserStatusInfo(String str, int i3, long j3, String str2, int i16, int i17, Map<String, String> map) {
        this(str, i3, j3, str2, i16, i17, map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserStatusInfo)) {
            return false;
        }
        UserStatusInfo userStatusInfo = (UserStatusInfo) obj;
        if (unknownFields().equals(userStatusInfo.unknownFields()) && Internal.equals(this.session_code, userStatusInfo.session_code) && Internal.equals(Integer.valueOf(this.special_user), Integer.valueOf(userStatusInfo.special_user)) && Internal.equals(Long.valueOf(this.timestamp), Long.valueOf(userStatusInfo.timestamp)) && Internal.equals(this.user_status_key, userStatusInfo.user_status_key) && Internal.equals(Integer.valueOf(this.dye_flag), Integer.valueOf(userStatusInfo.dye_flag)) && Internal.equals(Integer.valueOf(this.preview_mode), Integer.valueOf(userStatusInfo.preview_mode)) && this.persist_backend_info.equals(userStatusInfo.persist_backend_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.session_code;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int a16 = (((((hashCode + i3) * 37) + this.special_user) * 37) + androidx.fragment.app.a.a(this.timestamp)) * 37;
            String str2 = this.user_status_key;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int hashCode2 = ((((((a16 + i17) * 37) + this.dye_flag) * 37) + this.preview_mode) * 37) + this.persist_backend_info.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.session_code != null) {
            sb5.append(", session_code=");
            sb5.append(Internal.sanitize(this.session_code));
        }
        sb5.append(", special_user=");
        sb5.append(this.special_user);
        sb5.append(", timestamp=");
        sb5.append(this.timestamp);
        if (this.user_status_key != null) {
            sb5.append(", user_status_key=");
            sb5.append(Internal.sanitize(this.user_status_key));
        }
        sb5.append(", dye_flag=");
        sb5.append(this.dye_flag);
        sb5.append(", preview_mode=");
        sb5.append(this.preview_mode);
        if (!this.persist_backend_info.isEmpty()) {
            sb5.append(", persist_backend_info=");
            sb5.append(this.persist_backend_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "UserStatusInfo{");
        replace.append('}');
        return replace.toString();
    }

    public UserStatusInfo(String str, int i3, long j3, String str2, int i16, int i17, Map<String, String> map, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.session_code = str;
            this.special_user = i3;
            this.timestamp = j3;
            if (str2 != null) {
                this.user_status_key = str2;
                this.dye_flag = i16;
                this.preview_mode = i17;
                this.persist_backend_info = Internal.immutableCopyOf("persist_backend_info", map);
                return;
            }
            throw new IllegalArgumentException("user_status_key == null");
        }
        throw new IllegalArgumentException("session_code == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437785a = this.session_code;
        aVar.f437786b = this.special_user;
        aVar.f437787c = this.timestamp;
        aVar.f437788d = this.user_status_key;
        aVar.f437789e = this.dye_flag;
        aVar.f437790f = this.preview_mode;
        aVar.f437791g = Internal.copyOf(this.persist_backend_info);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
