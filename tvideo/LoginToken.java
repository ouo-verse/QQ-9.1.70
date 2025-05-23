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
public final class LoginToken extends Message<LoginToken, a> {
    public static final ProtoAdapter<LoginToken> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String account;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "appId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String app_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isMainLogin", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final boolean is_main_login;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final ByteString token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int type;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<LoginToken, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437679a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f437680b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f437681c = "";

        /* renamed from: d, reason: collision with root package name */
        public ByteString f437682d = ByteString.EMPTY;

        /* renamed from: e, reason: collision with root package name */
        public boolean f437683e = false;

        public a a(String str) {
            this.f437681c = str;
            return this;
        }

        public a b(String str) {
            this.f437679a = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public LoginToken build() {
            return new LoginToken(this.f437679a, this.f437680b, this.f437681c, this.f437682d, this.f437683e, super.buildUnknownFields());
        }

        public a d(boolean z16) {
            this.f437683e = z16;
            return this;
        }

        public a e(ByteString byteString) {
            this.f437682d = byteString;
            return this;
        }

        public a f(int i3) {
            this.f437680b = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<LoginToken> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LoginToken.class, "type.googleapis.com/tvideo.LoginToken", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginToken decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 5) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                    }
                                } else {
                                    aVar.e(ProtoAdapter.BYTES.decode(protoReader));
                                }
                            } else {
                                aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.f(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.b(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, LoginToken loginToken) throws IOException {
            if (!Objects.equals(loginToken.app_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, loginToken.app_id);
            }
            if (!Objects.equals(Integer.valueOf(loginToken.type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(loginToken.type));
            }
            if (!Objects.equals(loginToken.account, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, loginToken.account);
            }
            if (!Objects.equals(loginToken.token, ByteString.EMPTY)) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 4, loginToken.token);
            }
            if (!Objects.equals(Boolean.valueOf(loginToken.is_main_login), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, Boolean.valueOf(loginToken.is_main_login));
            }
            protoWriter.writeBytes(loginToken.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(LoginToken loginToken) {
            int i3;
            if (!Objects.equals(loginToken.app_id, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, loginToken.app_id) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(loginToken.type), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(loginToken.type));
            }
            if (!Objects.equals(loginToken.account, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, loginToken.account);
            }
            if (!Objects.equals(loginToken.token, ByteString.EMPTY)) {
                i3 += ProtoAdapter.BYTES.encodedSizeWithTag(4, loginToken.token);
            }
            if (!Objects.equals(Boolean.valueOf(loginToken.is_main_login), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(5, Boolean.valueOf(loginToken.is_main_login));
            }
            return i3 + loginToken.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public LoginToken redact(LoginToken loginToken) {
            a newBuilder = loginToken.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LoginToken(String str, int i3, String str2, ByteString byteString, boolean z16) {
        this(str, i3, str2, byteString, z16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginToken)) {
            return false;
        }
        LoginToken loginToken = (LoginToken) obj;
        if (unknownFields().equals(loginToken.unknownFields()) && Internal.equals(this.app_id, loginToken.app_id) && Internal.equals(Integer.valueOf(this.type), Integer.valueOf(loginToken.type)) && Internal.equals(this.account, loginToken.account) && Internal.equals(this.token, loginToken.token) && Internal.equals(Boolean.valueOf(this.is_main_login), Boolean.valueOf(loginToken.is_main_login))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.app_id;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (((hashCode + i3) * 37) + this.type) * 37;
            String str2 = this.account;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            ByteString byteString = this.token;
            if (byteString != null) {
                i18 = byteString.hashCode();
            }
            int a16 = ((i26 + i18) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_main_login);
            this.hashCode = a16;
            return a16;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.app_id != null) {
            sb5.append(", app_id=");
            sb5.append(Internal.sanitize(this.app_id));
        }
        sb5.append(", type=");
        sb5.append(this.type);
        if (this.account != null) {
            sb5.append(", account=");
            sb5.append(Internal.sanitize(this.account));
        }
        if (this.token != null) {
            sb5.append(", token=");
            sb5.append(this.token);
        }
        sb5.append(", is_main_login=");
        sb5.append(this.is_main_login);
        StringBuilder replace = sb5.replace(0, 2, "LoginToken{");
        replace.append('}');
        return replace.toString();
    }

    public LoginToken(String str, int i3, String str2, ByteString byteString, boolean z16, ByteString byteString2) {
        super(ADAPTER, byteString2);
        if (str != null) {
            this.app_id = str;
            this.type = i3;
            if (str2 != null) {
                this.account = str2;
                if (byteString != null) {
                    this.token = byteString;
                    this.is_main_login = z16;
                    return;
                }
                throw new IllegalArgumentException("token == null");
            }
            throw new IllegalArgumentException("account == null");
        }
        throw new IllegalArgumentException("app_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437679a = this.app_id;
        aVar.f437680b = this.type;
        aVar.f437681c = this.account;
        aVar.f437682d = this.token;
        aVar.f437683e = this.is_main_login;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
