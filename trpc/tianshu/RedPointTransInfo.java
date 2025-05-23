package trpc.tianshu;

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

/* loaded from: classes29.dex */
public final class RedPointTransInfo extends Message<RedPointTransInfo, a> {
    public static final ProtoAdapter<RedPointTransInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String feedID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final ByteString feedTransInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String reportTransInfo;

    /* loaded from: classes29.dex */
    public static final class a extends Message.Builder<RedPointTransInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437238a = "";

        /* renamed from: b, reason: collision with root package name */
        public ByteString f437239b = ByteString.EMPTY;

        /* renamed from: c, reason: collision with root package name */
        public String f437240c = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedPointTransInfo build() {
            return new RedPointTransInfo(this.f437238a, this.f437239b, this.f437240c, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437240c = str;
            return this;
        }

        public a c(ByteString byteString) {
            this.f437239b = byteString;
            return this;
        }

        public a d(String str) {
            this.f437238a = str;
            return this;
        }
    }

    /* loaded from: classes29.dex */
    private static final class b extends ProtoAdapter<RedPointTransInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) RedPointTransInfo.class, "type.googleapis.com/trpc.tianshu.RedPointTransInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedPointTransInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.c(ProtoAdapter.BYTES.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, RedPointTransInfo redPointTransInfo) throws IOException {
            if (!Objects.equals(redPointTransInfo.reportTransInfo, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, redPointTransInfo.reportTransInfo);
            }
            if (!Objects.equals(redPointTransInfo.feedTransInfo, ByteString.EMPTY)) {
                ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, redPointTransInfo.feedTransInfo);
            }
            if (!Objects.equals(redPointTransInfo.feedID, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, redPointTransInfo.feedID);
            }
            protoWriter.writeBytes(redPointTransInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(RedPointTransInfo redPointTransInfo) {
            int i3 = 0;
            if (!Objects.equals(redPointTransInfo.reportTransInfo, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, redPointTransInfo.reportTransInfo);
            }
            if (!Objects.equals(redPointTransInfo.feedTransInfo, ByteString.EMPTY)) {
                i3 += ProtoAdapter.BYTES.encodedSizeWithTag(2, redPointTransInfo.feedTransInfo);
            }
            if (!Objects.equals(redPointTransInfo.feedID, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, redPointTransInfo.feedID);
            }
            return i3 + redPointTransInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public RedPointTransInfo redact(RedPointTransInfo redPointTransInfo) {
            a newBuilder = redPointTransInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public RedPointTransInfo(String str, ByteString byteString, String str2) {
        this(str, byteString, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RedPointTransInfo)) {
            return false;
        }
        RedPointTransInfo redPointTransInfo = (RedPointTransInfo) obj;
        if (unknownFields().equals(redPointTransInfo.unknownFields()) && Internal.equals(this.reportTransInfo, redPointTransInfo.reportTransInfo) && Internal.equals(this.feedTransInfo, redPointTransInfo.feedTransInfo) && Internal.equals(this.feedID, redPointTransInfo.feedID)) {
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
            String str = this.reportTransInfo;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            ByteString byteString = this.feedTransInfo;
            if (byteString != null) {
                i16 = byteString.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str2 = this.feedID;
            if (str2 != null) {
                i18 = str2.hashCode();
            }
            int i27 = i26 + i18;
            this.hashCode = i27;
            return i27;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.reportTransInfo != null) {
            sb5.append(", reportTransInfo=");
            sb5.append(Internal.sanitize(this.reportTransInfo));
        }
        if (this.feedTransInfo != null) {
            sb5.append(", feedTransInfo=");
            sb5.append(this.feedTransInfo);
        }
        if (this.feedID != null) {
            sb5.append(", feedID=");
            sb5.append(Internal.sanitize(this.feedID));
        }
        StringBuilder replace = sb5.replace(0, 2, "RedPointTransInfo{");
        replace.append('}');
        return replace.toString();
    }

    public RedPointTransInfo(String str, ByteString byteString, String str2, ByteString byteString2) {
        super(ADAPTER, byteString2);
        if (str != null) {
            this.reportTransInfo = str;
            if (byteString != null) {
                this.feedTransInfo = byteString;
                if (str2 != null) {
                    this.feedID = str2;
                    return;
                }
                throw new IllegalArgumentException("feedID == null");
            }
            throw new IllegalArgumentException("feedTransInfo == null");
        }
        throw new IllegalArgumentException("reportTransInfo == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437238a = this.reportTransInfo;
        aVar.f437239b = this.feedTransInfo;
        aVar.f437240c = this.feedID;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
