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
public final class RefreshTokenRequest extends Message<RefreshTokenRequest, a> {
    public static final ProtoAdapter<RefreshTokenRequest> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int dispatchPriority;

    @WireField(adapter = "tvideo.CurLoginToken#ADAPTER", jsonName = "loginToken", label = WireField.Label.REPEATED, tag = 1)
    public final List<CurLoginToken> login_token;

    @WireField(adapter = "tvideo.RefreshSource#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final RefreshSource source;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "useVideoServerToken", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final boolean use_video_server_token;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "userQuickLogin", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final boolean user_quick_login;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<RefreshTokenRequest, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<CurLoginToken> f437717a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public int f437718b = 0;

        /* renamed from: c, reason: collision with root package name */
        public boolean f437719c = false;

        /* renamed from: d, reason: collision with root package name */
        public boolean f437720d = false;

        /* renamed from: e, reason: collision with root package name */
        public RefreshSource f437721e = RefreshSource.SOURCE_NORMAL;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RefreshTokenRequest build() {
            return new RefreshTokenRequest(this.f437717a, this.f437718b, this.f437719c, this.f437720d, this.f437721e, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437718b = i3;
            return this;
        }

        public a c(List<CurLoginToken> list) {
            Internal.checkElementsNotNull(list);
            this.f437717a = list;
            return this;
        }

        public a d(RefreshSource refreshSource) {
            this.f437721e = refreshSource;
            return this;
        }

        public a e(boolean z16) {
            this.f437719c = z16;
            return this;
        }

        public a f(boolean z16) {
            this.f437720d = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<RefreshTokenRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RefreshTokenRequest.class, "type.googleapis.com/tvideo.RefreshTokenRequest", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RefreshTokenRequest decode(ProtoReader protoReader) throws IOException {
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
                                        try {
                                            aVar.d(RefreshSource.ADAPTER.decode(protoReader));
                                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                        }
                                    }
                                } else {
                                    aVar.f(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                                }
                            } else {
                                aVar.e(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                            }
                        } else {
                            aVar.b(ProtoAdapter.UINT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.f437717a.add(CurLoginToken.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, RefreshTokenRequest refreshTokenRequest) throws IOException {
            CurLoginToken.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, refreshTokenRequest.login_token);
            if (!Objects.equals(Integer.valueOf(refreshTokenRequest.dispatchPriority), 0)) {
                ProtoAdapter.UINT32.encodeWithTag(protoWriter, 2, Integer.valueOf(refreshTokenRequest.dispatchPriority));
            }
            Boolean valueOf = Boolean.valueOf(refreshTokenRequest.use_video_server_token);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, Boolean.valueOf(refreshTokenRequest.use_video_server_token));
            }
            if (!Objects.equals(Boolean.valueOf(refreshTokenRequest.user_quick_login), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, Boolean.valueOf(refreshTokenRequest.user_quick_login));
            }
            if (!Objects.equals(refreshTokenRequest.source, RefreshSource.SOURCE_NORMAL)) {
                RefreshSource.ADAPTER.encodeWithTag(protoWriter, 5, refreshTokenRequest.source);
            }
            protoWriter.writeBytes(refreshTokenRequest.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RefreshTokenRequest refreshTokenRequest) {
            int encodedSizeWithTag = CurLoginToken.ADAPTER.asRepeated().encodedSizeWithTag(1, refreshTokenRequest.login_token) + 0;
            if (!Objects.equals(Integer.valueOf(refreshTokenRequest.dispatchPriority), 0)) {
                encodedSizeWithTag += ProtoAdapter.UINT32.encodedSizeWithTag(2, Integer.valueOf(refreshTokenRequest.dispatchPriority));
            }
            Boolean valueOf = Boolean.valueOf(refreshTokenRequest.use_video_server_token);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(refreshTokenRequest.use_video_server_token));
            }
            if (!Objects.equals(Boolean.valueOf(refreshTokenRequest.user_quick_login), bool)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(4, Boolean.valueOf(refreshTokenRequest.user_quick_login));
            }
            if (!Objects.equals(refreshTokenRequest.source, RefreshSource.SOURCE_NORMAL)) {
                encodedSizeWithTag += RefreshSource.ADAPTER.encodedSizeWithTag(5, refreshTokenRequest.source);
            }
            return encodedSizeWithTag + refreshTokenRequest.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RefreshTokenRequest redact(RefreshTokenRequest refreshTokenRequest) {
            a newBuilder = refreshTokenRequest.newBuilder();
            Internal.redactElements(newBuilder.f437717a, CurLoginToken.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RefreshTokenRequest(List<CurLoginToken> list, int i3, boolean z16, boolean z17, RefreshSource refreshSource) {
        this(list, i3, z16, z17, refreshSource, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefreshTokenRequest)) {
            return false;
        }
        RefreshTokenRequest refreshTokenRequest = (RefreshTokenRequest) obj;
        if (unknownFields().equals(refreshTokenRequest.unknownFields()) && this.login_token.equals(refreshTokenRequest.login_token) && Internal.equals(Integer.valueOf(this.dispatchPriority), Integer.valueOf(refreshTokenRequest.dispatchPriority)) && Internal.equals(Boolean.valueOf(this.use_video_server_token), Boolean.valueOf(refreshTokenRequest.use_video_server_token)) && Internal.equals(Boolean.valueOf(this.user_quick_login), Boolean.valueOf(refreshTokenRequest.user_quick_login)) && Internal.equals(this.source, refreshTokenRequest.source)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((((unknownFields().hashCode() * 37) + this.login_token.hashCode()) * 37) + this.dispatchPriority) * 37) + com.tencent.aio.widget.textView.param.a.a(this.use_video_server_token)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.user_quick_login)) * 37;
            RefreshSource refreshSource = this.source;
            if (refreshSource != null) {
                i3 = refreshSource.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.login_token.isEmpty()) {
            sb5.append(", login_token=");
            sb5.append(this.login_token);
        }
        sb5.append(", dispatchPriority=");
        sb5.append(this.dispatchPriority);
        sb5.append(", use_video_server_token=");
        sb5.append(this.use_video_server_token);
        sb5.append(", user_quick_login=");
        sb5.append(this.user_quick_login);
        if (this.source != null) {
            sb5.append(", source=");
            sb5.append(this.source);
        }
        StringBuilder replace = sb5.replace(0, 2, "RefreshTokenRequest{");
        replace.append('}');
        return replace.toString();
    }

    public RefreshTokenRequest(List<CurLoginToken> list, int i3, boolean z16, boolean z17, RefreshSource refreshSource, ByteString byteString) {
        super(ADAPTER, byteString);
        this.login_token = Internal.immutableCopyOf("login_token", list);
        this.dispatchPriority = i3;
        this.use_video_server_token = z16;
        this.user_quick_login = z17;
        if (refreshSource != null) {
            this.source = refreshSource;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437717a = Internal.copyOf(this.login_token);
        aVar.f437718b = this.dispatchPriority;
        aVar.f437719c = this.use_video_server_token;
        aVar.f437720d = this.user_quick_login;
        aVar.f437721e = this.source;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
