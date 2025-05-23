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
public final class UserInfoExtraData extends Message<UserInfoExtraData, a> {
    public static final ProtoAdapter<UserInfoExtraData> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String value;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<UserInfoExtraData, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437783a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437784b = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoExtraData build() {
            return new UserInfoExtraData(this.f437783a, this.f437784b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437783a = str;
            return this;
        }

        public a c(String str) {
            this.f437784b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<UserInfoExtraData> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) UserInfoExtraData.class, "type.googleapis.com/tvideo.UserInfoExtraData", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfoExtraData decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, UserInfoExtraData userInfoExtraData) throws IOException {
            if (!Objects.equals(userInfoExtraData.key, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, userInfoExtraData.key);
            }
            if (!Objects.equals(userInfoExtraData.value, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, userInfoExtraData.value);
            }
            protoWriter.writeBytes(userInfoExtraData.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(UserInfoExtraData userInfoExtraData) {
            int i3 = 0;
            if (!Objects.equals(userInfoExtraData.key, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, userInfoExtraData.key);
            }
            if (!Objects.equals(userInfoExtraData.value, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, userInfoExtraData.value);
            }
            return i3 + userInfoExtraData.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public UserInfoExtraData redact(UserInfoExtraData userInfoExtraData) {
            a newBuilder = userInfoExtraData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public UserInfoExtraData(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserInfoExtraData)) {
            return false;
        }
        UserInfoExtraData userInfoExtraData = (UserInfoExtraData) obj;
        if (unknownFields().equals(userInfoExtraData.unknownFields()) && Internal.equals(this.key, userInfoExtraData.key) && Internal.equals(this.value, userInfoExtraData.value)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.key;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.value;
            if (str2 != null) {
                i17 = str2.hashCode();
            }
            int i19 = i18 + i17;
            this.hashCode = i19;
            return i19;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.key != null) {
            sb5.append(", key=");
            sb5.append(Internal.sanitize(this.key));
        }
        if (this.value != null) {
            sb5.append(", value=");
            sb5.append(Internal.sanitize(this.value));
        }
        StringBuilder replace = sb5.replace(0, 2, "UserInfoExtraData{");
        replace.append('}');
        return replace.toString();
    }

    public UserInfoExtraData(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.key = str;
            if (str2 != null) {
                this.value = str2;
                return;
            }
            throw new IllegalArgumentException("value == null");
        }
        throw new IllegalArgumentException("key == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437783a = this.key;
        aVar.f437784b = this.value;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
