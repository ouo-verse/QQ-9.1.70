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
public final class CurLoginToken extends Message<CurLoginToken, a> {
    public static final ProtoAdapter<CurLoginToken> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "refreshValue", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String refresh_value;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "tokenAppid", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String token_appid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "tokenCode", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String token_code;

    @WireField(adapter = "tvideo.TokenKeyType#ADAPTER", jsonName = "tokenKeyType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final TokenKeyType token_key_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "tokenUin", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final long token_uin;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "tokenValue", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String token_value;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String tokenid;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<CurLoginToken, a> {

        /* renamed from: a, reason: collision with root package name */
        public TokenKeyType f437600a = TokenKeyType.TOKEN_KEY_TYPE_UNSPECIFIED;

        /* renamed from: b, reason: collision with root package name */
        public String f437601b = "";

        /* renamed from: c, reason: collision with root package name */
        public long f437602c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f437603d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437604e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f437605f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f437606g = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CurLoginToken build() {
            return new CurLoginToken(this.f437600a, this.f437601b, this.f437602c, this.f437603d, this.f437604e, this.f437605f, this.f437606g, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437606g = str;
            return this;
        }

        public a c(String str) {
            this.f437601b = str;
            return this;
        }

        public a d(String str) {
            this.f437605f = str;
            return this;
        }

        public a e(TokenKeyType tokenKeyType) {
            this.f437600a = tokenKeyType;
            return this;
        }

        public a f(long j3) {
            this.f437602c = j3;
            return this;
        }

        public a g(String str) {
            this.f437604e = str;
            return this;
        }

        public a h(String str) {
            this.f437603d = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<CurLoginToken> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) CurLoginToken.class, "type.googleapis.com/tvideo.CurLoginToken", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CurLoginToken decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            try {
                                aVar.e(TokenKeyType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 2:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            aVar.f(ProtoAdapter.INT64.decode(protoReader).longValue());
                            break;
                        case 4:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, CurLoginToken curLoginToken) throws IOException {
            if (!Objects.equals(curLoginToken.token_key_type, TokenKeyType.TOKEN_KEY_TYPE_UNSPECIFIED)) {
                TokenKeyType.ADAPTER.encodeWithTag(protoWriter, 1, curLoginToken.token_key_type);
            }
            if (!Objects.equals(curLoginToken.token_appid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, curLoginToken.token_appid);
            }
            if (!Objects.equals(Long.valueOf(curLoginToken.token_uin), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, Long.valueOf(curLoginToken.token_uin));
            }
            if (!Objects.equals(curLoginToken.tokenid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, curLoginToken.tokenid);
            }
            if (!Objects.equals(curLoginToken.token_value, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, curLoginToken.token_value);
            }
            if (!Objects.equals(curLoginToken.token_code, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, curLoginToken.token_code);
            }
            if (!Objects.equals(curLoginToken.refresh_value, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, curLoginToken.refresh_value);
            }
            protoWriter.writeBytes(curLoginToken.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(CurLoginToken curLoginToken) {
            int i3 = 0;
            if (!Objects.equals(curLoginToken.token_key_type, TokenKeyType.TOKEN_KEY_TYPE_UNSPECIFIED)) {
                i3 = 0 + TokenKeyType.ADAPTER.encodedSizeWithTag(1, curLoginToken.token_key_type);
            }
            if (!Objects.equals(curLoginToken.token_appid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, curLoginToken.token_appid);
            }
            if (!Objects.equals(Long.valueOf(curLoginToken.token_uin), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(3, Long.valueOf(curLoginToken.token_uin));
            }
            if (!Objects.equals(curLoginToken.tokenid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, curLoginToken.tokenid);
            }
            if (!Objects.equals(curLoginToken.token_value, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, curLoginToken.token_value);
            }
            if (!Objects.equals(curLoginToken.token_code, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, curLoginToken.token_code);
            }
            if (!Objects.equals(curLoginToken.refresh_value, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, curLoginToken.refresh_value);
            }
            return i3 + curLoginToken.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public CurLoginToken redact(CurLoginToken curLoginToken) {
            a newBuilder = curLoginToken.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public CurLoginToken(TokenKeyType tokenKeyType, String str, long j3, String str2, String str3, String str4, String str5) {
        this(tokenKeyType, str, j3, str2, str3, str4, str5, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurLoginToken)) {
            return false;
        }
        CurLoginToken curLoginToken = (CurLoginToken) obj;
        if (unknownFields().equals(curLoginToken.unknownFields()) && Internal.equals(this.token_key_type, curLoginToken.token_key_type) && Internal.equals(this.token_appid, curLoginToken.token_appid) && Internal.equals(Long.valueOf(this.token_uin), Long.valueOf(curLoginToken.token_uin)) && Internal.equals(this.tokenid, curLoginToken.tokenid) && Internal.equals(this.token_value, curLoginToken.token_value) && Internal.equals(this.token_code, curLoginToken.token_code) && Internal.equals(this.refresh_value, curLoginToken.refresh_value)) {
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
        int i26 = this.hashCode;
        if (i26 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            TokenKeyType tokenKeyType = this.token_key_type;
            int i27 = 0;
            if (tokenKeyType != null) {
                i3 = tokenKeyType.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str = this.token_appid;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int a16 = (((i28 + i16) * 37) + androidx.fragment.app.a.a(this.token_uin)) * 37;
            String str2 = this.tokenid;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i29 = (a16 + i17) * 37;
            String str3 = this.token_value;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int i36 = (i29 + i18) * 37;
            String str4 = this.token_code;
            if (str4 != null) {
                i19 = str4.hashCode();
            } else {
                i19 = 0;
            }
            int i37 = (i36 + i19) * 37;
            String str5 = this.refresh_value;
            if (str5 != null) {
                i27 = str5.hashCode();
            }
            int i38 = i37 + i27;
            this.hashCode = i38;
            return i38;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.token_key_type != null) {
            sb5.append(", token_key_type=");
            sb5.append(this.token_key_type);
        }
        if (this.token_appid != null) {
            sb5.append(", token_appid=");
            sb5.append(Internal.sanitize(this.token_appid));
        }
        sb5.append(", token_uin=");
        sb5.append(this.token_uin);
        if (this.tokenid != null) {
            sb5.append(", tokenid=");
            sb5.append(Internal.sanitize(this.tokenid));
        }
        if (this.token_value != null) {
            sb5.append(", token_value=");
            sb5.append(Internal.sanitize(this.token_value));
        }
        if (this.token_code != null) {
            sb5.append(", token_code=");
            sb5.append(Internal.sanitize(this.token_code));
        }
        if (this.refresh_value != null) {
            sb5.append(", refresh_value=");
            sb5.append(Internal.sanitize(this.refresh_value));
        }
        StringBuilder replace = sb5.replace(0, 2, "CurLoginToken{");
        replace.append('}');
        return replace.toString();
    }

    public CurLoginToken(TokenKeyType tokenKeyType, String str, long j3, String str2, String str3, String str4, String str5, ByteString byteString) {
        super(ADAPTER, byteString);
        if (tokenKeyType != null) {
            this.token_key_type = tokenKeyType;
            if (str != null) {
                this.token_appid = str;
                this.token_uin = j3;
                if (str2 != null) {
                    this.tokenid = str2;
                    if (str3 != null) {
                        this.token_value = str3;
                        if (str4 != null) {
                            this.token_code = str4;
                            if (str5 != null) {
                                this.refresh_value = str5;
                                return;
                            }
                            throw new IllegalArgumentException("refresh_value == null");
                        }
                        throw new IllegalArgumentException("token_code == null");
                    }
                    throw new IllegalArgumentException("token_value == null");
                }
                throw new IllegalArgumentException("tokenid == null");
            }
            throw new IllegalArgumentException("token_appid == null");
        }
        throw new IllegalArgumentException("token_key_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437600a = this.token_key_type;
        aVar.f437601b = this.token_appid;
        aVar.f437602c = this.token_uin;
        aVar.f437603d = this.tokenid;
        aVar.f437604e = this.token_value;
        aVar.f437605f = this.token_code;
        aVar.f437606g = this.refresh_value;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
