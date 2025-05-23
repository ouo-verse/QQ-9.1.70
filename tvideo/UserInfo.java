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
public final class UserInfo extends Message<UserInfo, a> {
    public static final ProtoAdapter<UserInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.UserInfoExtraData#ADAPTER", jsonName = "extraInfo", label = WireField.Label.REPEATED, tag = 3)
    public final List<UserInfoExtraData> extra_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "faceImageUrl", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String face_image_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "nickName", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String nick_name;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<UserInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437780a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437781b = "";

        /* renamed from: c, reason: collision with root package name */
        public List<UserInfoExtraData> f437782c = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfo build() {
            return new UserInfo(this.f437780a, this.f437781b, this.f437782c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437781b = str;
            return this;
        }

        public a c(String str) {
            this.f437780a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<UserInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) UserInfo.class, "type.googleapis.com/tvideo.UserInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                protoReader.readUnknownField(nextTag);
                            } else {
                                aVar.f437782c.add(UserInfoExtraData.ADAPTER.decode(protoReader));
                            }
                        } else {
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
                        }
                    } else {
                        aVar.c(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, UserInfo userInfo) throws IOException {
            if (!Objects.equals(userInfo.nick_name, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, userInfo.nick_name);
            }
            if (!Objects.equals(userInfo.face_image_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, userInfo.face_image_url);
            }
            UserInfoExtraData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, userInfo.extra_info);
            protoWriter.writeBytes(userInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(UserInfo userInfo) {
            int i3 = 0;
            if (!Objects.equals(userInfo.nick_name, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, userInfo.nick_name);
            }
            if (!Objects.equals(userInfo.face_image_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, userInfo.face_image_url);
            }
            return i3 + UserInfoExtraData.ADAPTER.asRepeated().encodedSizeWithTag(3, userInfo.extra_info) + userInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public UserInfo redact(UserInfo userInfo) {
            a newBuilder = userInfo.newBuilder();
            Internal.redactElements(newBuilder.f437782c, UserInfoExtraData.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public UserInfo(String str, String str2, List<UserInfoExtraData> list) {
        this(str, str2, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (unknownFields().equals(userInfo.unknownFields()) && Internal.equals(this.nick_name, userInfo.nick_name) && Internal.equals(this.face_image_url, userInfo.face_image_url) && this.extra_info.equals(userInfo.extra_info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.nick_name;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.face_image_url;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int hashCode2 = ((i18 + i17) * 37) + this.extra_info.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.nick_name != null) {
            sb5.append(", nick_name=");
            sb5.append(Internal.sanitize(this.nick_name));
        }
        if (this.face_image_url != null) {
            sb5.append(", face_image_url=");
            sb5.append(Internal.sanitize(this.face_image_url));
        }
        if (!this.extra_info.isEmpty()) {
            sb5.append(", extra_info=");
            sb5.append(this.extra_info);
        }
        StringBuilder replace = sb5.replace(0, 2, "UserInfo{");
        replace.append('}');
        return replace.toString();
    }

    public UserInfo(String str, String str2, List<UserInfoExtraData> list, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.nick_name = str;
            if (str2 != null) {
                this.face_image_url = str2;
                this.extra_info = Internal.immutableCopyOf("extra_info", list);
                return;
            }
            throw new IllegalArgumentException("face_image_url == null");
        }
        throw new IllegalArgumentException("nick_name == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437780a = this.nick_name;
        aVar.f437781b = this.face_image_url;
        aVar.f437782c = Internal.copyOf(this.extra_info);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
