package tvideo;

import com.huawei.hms.support.feature.result.CommonConstant;
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
public final class TokenInfo extends Message<TokenInfo, a> {
    public static final ProtoAdapter<TokenInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = CommonConstant.KEY_ACCESS_TOKEN, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String access_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", jsonName = "accessTokenExpireTime", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int access_token_expire_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String openid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "refreshToken", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String refresh_token;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<TokenInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437776a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437777b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437778c = "";

        /* renamed from: d, reason: collision with root package name */
        public int f437779d = 0;

        public a a(String str) {
            this.f437777b = str;
            return this;
        }

        public a b(int i3) {
            this.f437779d = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public TokenInfo build() {
            return new TokenInfo(this.f437776a, this.f437777b, this.f437778c, this.f437779d, super.buildUnknownFields());
        }

        public a d(String str) {
            this.f437776a = str;
            return this;
        }

        public a e(String str) {
            this.f437778c = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<TokenInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) TokenInfo.class, "type.googleapis.com/tvideo.TokenInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TokenInfo decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.b(ProtoAdapter.UINT32.decode(protoReader).intValue());
                                }
                            } else {
                                aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.d(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, TokenInfo tokenInfo) throws IOException {
            if (!Objects.equals(tokenInfo.openid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, tokenInfo.openid);
            }
            if (!Objects.equals(tokenInfo.access_token, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, tokenInfo.access_token);
            }
            if (!Objects.equals(tokenInfo.refresh_token, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, tokenInfo.refresh_token);
            }
            if (!Objects.equals(Integer.valueOf(tokenInfo.access_token_expire_time), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 4, Integer.valueOf(tokenInfo.access_token_expire_time));
            }
            protoWriter.writeBytes(tokenInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(TokenInfo tokenInfo) {
            int i3;
            if (!Objects.equals(tokenInfo.openid, "")) {
                i3 = ProtoAdapter.STRING.encodedSizeWithTag(1, tokenInfo.openid) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(tokenInfo.access_token, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, tokenInfo.access_token);
            }
            if (!Objects.equals(tokenInfo.refresh_token, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, tokenInfo.refresh_token);
            }
            if (!Objects.equals(Integer.valueOf(tokenInfo.access_token_expire_time), 0)) {
                i3 += ProtoAdapter.UINT32.encodedSizeWithTag(4, Integer.valueOf(tokenInfo.access_token_expire_time));
            }
            return i3 + tokenInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public TokenInfo redact(TokenInfo tokenInfo) {
            a newBuilder = tokenInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public TokenInfo(String str, String str2, String str3, int i3) {
        this(str, str2, str3, i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenInfo)) {
            return false;
        }
        TokenInfo tokenInfo = (TokenInfo) obj;
        if (unknownFields().equals(tokenInfo.unknownFields()) && Internal.equals(this.openid, tokenInfo.openid) && Internal.equals(this.access_token, tokenInfo.access_token) && Internal.equals(this.refresh_token, tokenInfo.refresh_token) && Internal.equals(Integer.valueOf(this.access_token_expire_time), Integer.valueOf(tokenInfo.access_token_expire_time))) {
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
            String str = this.openid;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.access_token;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str3 = this.refresh_token;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int i27 = ((i26 + i18) * 37) + this.access_token_expire_time;
            this.hashCode = i27;
            return i27;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.openid != null) {
            sb5.append(", openid=");
            sb5.append(Internal.sanitize(this.openid));
        }
        if (this.access_token != null) {
            sb5.append(", access_token=");
            sb5.append(Internal.sanitize(this.access_token));
        }
        if (this.refresh_token != null) {
            sb5.append(", refresh_token=");
            sb5.append(Internal.sanitize(this.refresh_token));
        }
        sb5.append(", access_token_expire_time=");
        sb5.append(this.access_token_expire_time);
        StringBuilder replace = sb5.replace(0, 2, "TokenInfo{");
        replace.append('}');
        return replace.toString();
    }

    public TokenInfo(String str, String str2, String str3, int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.openid = str;
            if (str2 != null) {
                this.access_token = str2;
                if (str3 != null) {
                    this.refresh_token = str3;
                    this.access_token_expire_time = i3;
                    return;
                }
                throw new IllegalArgumentException("refresh_token == null");
            }
            throw new IllegalArgumentException("access_token == null");
        }
        throw new IllegalArgumentException("openid == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437776a = this.openid;
        aVar.f437777b = this.access_token;
        aVar.f437778c = this.refresh_token;
        aVar.f437779d = this.access_token_expire_time;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
