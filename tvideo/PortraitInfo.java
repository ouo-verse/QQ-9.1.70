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

/* loaded from: classes30.dex */
public final class PortraitInfo extends Message<PortraitInfo, a> {
    public static final ProtoAdapter<PortraitInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "valueInfo", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> value_info;

    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<PortraitInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437708a = "";

        /* renamed from: b, reason: collision with root package name */
        public List<String> f437709b = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PortraitInfo build() {
            return new PortraitInfo(this.f437708a, this.f437709b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437708a = str;
            return this;
        }
    }

    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<PortraitInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) PortraitInfo.class, "type.googleapis.com/tvideo.PortraitInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PortraitInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.f437709b.add(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, PortraitInfo portraitInfo) throws IOException {
            if (!Objects.equals(portraitInfo.key, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, portraitInfo.key);
            }
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 2, portraitInfo.value_info);
            protoWriter.writeBytes(portraitInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(PortraitInfo portraitInfo) {
            int i3 = 0;
            if (!Objects.equals(portraitInfo.key, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, portraitInfo.key);
            }
            return i3 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, portraitInfo.value_info) + portraitInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public PortraitInfo redact(PortraitInfo portraitInfo) {
            a newBuilder = portraitInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public PortraitInfo(String str, List<String> list) {
        this(str, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PortraitInfo)) {
            return false;
        }
        PortraitInfo portraitInfo = (PortraitInfo) obj;
        if (unknownFields().equals(portraitInfo.unknownFields()) && Internal.equals(this.key, portraitInfo.key) && this.value_info.equals(portraitInfo.value_info)) {
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
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((hashCode + i3) * 37) + this.value_info.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
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
        if (!this.value_info.isEmpty()) {
            sb5.append(", value_info=");
            sb5.append(Internal.sanitize(this.value_info));
        }
        StringBuilder replace = sb5.replace(0, 2, "PortraitInfo{");
        replace.append('}');
        return replace.toString();
    }

    public PortraitInfo(String str, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.key = str;
            this.value_info = Internal.immutableCopyOf("value_info", list);
            return;
        }
        throw new IllegalArgumentException("key == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437708a = this.key;
        aVar.f437709b = Internal.copyOf(this.value_info);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
