package trpcprotocol.feedcloud.sidebar;

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
public final class JumpInfo extends Message<JumpInfo, a> {
    public static final ProtoAdapter<JumpInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.JumpType#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final JumpType jumpType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String link;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<JumpInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public JumpType f437300a = JumpType.JUMP_TYPE_SCHEMA;

        /* renamed from: b, reason: collision with root package name */
        public String f437301b = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JumpInfo build() {
            return new JumpInfo(this.f437300a, this.f437301b, super.buildUnknownFields());
        }

        public a b(JumpType jumpType) {
            this.f437300a = jumpType;
            return this;
        }

        public a c(String str) {
            this.f437301b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<JumpInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) JumpInfo.class, "type.googleapis.com/trpc.feedcloud.sidebar.JumpInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JumpInfo decode(ProtoReader protoReader) throws IOException {
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
                        try {
                            aVar.b(JumpType.ADAPTER.decode(protoReader));
                        } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                            aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                        }
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, JumpInfo jumpInfo) throws IOException {
            if (!Objects.equals(jumpInfo.jumpType, JumpType.JUMP_TYPE_SCHEMA)) {
                JumpType.ADAPTER.encodeWithTag(protoWriter, 1, jumpInfo.jumpType);
            }
            if (!Objects.equals(jumpInfo.link, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, jumpInfo.link);
            }
            protoWriter.writeBytes(jumpInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(JumpInfo jumpInfo) {
            int i3 = 0;
            if (!Objects.equals(jumpInfo.jumpType, JumpType.JUMP_TYPE_SCHEMA)) {
                i3 = 0 + JumpType.ADAPTER.encodedSizeWithTag(1, jumpInfo.jumpType);
            }
            if (!Objects.equals(jumpInfo.link, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, jumpInfo.link);
            }
            return i3 + jumpInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public JumpInfo redact(JumpInfo jumpInfo) {
            a newBuilder = jumpInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public JumpInfo(JumpType jumpType, String str) {
        this(jumpType, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JumpInfo)) {
            return false;
        }
        JumpInfo jumpInfo = (JumpInfo) obj;
        if (unknownFields().equals(jumpInfo.unknownFields()) && Internal.equals(this.jumpType, jumpInfo.jumpType) && Internal.equals(this.link, jumpInfo.link)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            JumpType jumpType = this.jumpType;
            int i17 = 0;
            if (jumpType != null) {
                i3 = jumpType.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str = this.link;
            if (str != null) {
                i17 = str.hashCode();
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
        if (this.jumpType != null) {
            sb5.append(", jumpType=");
            sb5.append(this.jumpType);
        }
        if (this.link != null) {
            sb5.append(", link=");
            sb5.append(Internal.sanitize(this.link));
        }
        StringBuilder replace = sb5.replace(0, 2, "JumpInfo{");
        replace.append('}');
        return replace.toString();
    }

    public JumpInfo(JumpType jumpType, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        if (jumpType != null) {
            this.jumpType = jumpType;
            if (str != null) {
                this.link = str;
                return;
            }
            throw new IllegalArgumentException("link == null");
        }
        throw new IllegalArgumentException("jumpType == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437300a = this.jumpType;
        aVar.f437301b = this.link;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
