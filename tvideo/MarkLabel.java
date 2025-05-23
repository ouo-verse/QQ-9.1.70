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
public final class MarkLabel extends Message<MarkLabel, a> {
    public static final ProtoAdapter<MarkLabel> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "markImageUrl", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String mark_image_url;

    @WireField(adapter = "tvideo.MarkLabelType#ADAPTER", jsonName = "markLabelType", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final MarkLabelType mark_label_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "primeText", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String prime_text;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<MarkLabel, a> {

        /* renamed from: a, reason: collision with root package name */
        public MarkLabelType f437689a = MarkLabelType.MARK_LABEL_TYPE_SINGLE_TEXT;

        /* renamed from: b, reason: collision with root package name */
        public int f437690b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f437691c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f437692d = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MarkLabel build() {
            return new MarkLabel(this.f437689a, this.f437690b, this.f437691c, this.f437692d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437692d = str;
            return this;
        }

        public a c(MarkLabelType markLabelType) {
            this.f437689a = markLabelType;
            return this;
        }

        public a d(int i3) {
            this.f437690b = i3;
            return this;
        }

        public a e(String str) {
            this.f437691c = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<MarkLabel> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MarkLabel.class, "type.googleapis.com/tvideo.MarkLabel", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MarkLabel decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.b(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        try {
                            aVar.c(MarkLabelType.ADAPTER.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, MarkLabel markLabel) throws IOException {
            if (!Objects.equals(markLabel.mark_label_type, MarkLabelType.MARK_LABEL_TYPE_SINGLE_TEXT)) {
                MarkLabelType.ADAPTER.encodeWithTag(protoWriter, 1, markLabel.mark_label_type);
            }
            if (!Objects.equals(Integer.valueOf(markLabel.position), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(markLabel.position));
            }
            if (!Objects.equals(markLabel.prime_text, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, markLabel.prime_text);
            }
            if (!Objects.equals(markLabel.mark_image_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, markLabel.mark_image_url);
            }
            protoWriter.writeBytes(markLabel.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(MarkLabel markLabel) {
            int i3;
            if (!Objects.equals(markLabel.mark_label_type, MarkLabelType.MARK_LABEL_TYPE_SINGLE_TEXT)) {
                i3 = MarkLabelType.ADAPTER.encodedSizeWithTag(1, markLabel.mark_label_type) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(markLabel.position), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(markLabel.position));
            }
            if (!Objects.equals(markLabel.prime_text, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, markLabel.prime_text);
            }
            if (!Objects.equals(markLabel.mark_image_url, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, markLabel.mark_image_url);
            }
            return i3 + markLabel.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MarkLabel redact(MarkLabel markLabel) {
            a newBuilder = markLabel.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MarkLabel(MarkLabelType markLabelType, int i3, String str, String str2) {
        this(markLabelType, i3, str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarkLabel)) {
            return false;
        }
        MarkLabel markLabel = (MarkLabel) obj;
        if (unknownFields().equals(markLabel.unknownFields()) && Internal.equals(this.mark_label_type, markLabel.mark_label_type) && Internal.equals(Integer.valueOf(this.position), Integer.valueOf(markLabel.position)) && Internal.equals(this.prime_text, markLabel.prime_text) && Internal.equals(this.mark_image_url, markLabel.mark_image_url)) {
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
            MarkLabelType markLabelType = this.mark_label_type;
            int i18 = 0;
            if (markLabelType != null) {
                i3 = markLabelType.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (((hashCode + i3) * 37) + this.position) * 37;
            String str = this.prime_text;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str2 = this.mark_image_url;
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
        if (this.mark_label_type != null) {
            sb5.append(", mark_label_type=");
            sb5.append(this.mark_label_type);
        }
        sb5.append(", position=");
        sb5.append(this.position);
        if (this.prime_text != null) {
            sb5.append(", prime_text=");
            sb5.append(Internal.sanitize(this.prime_text));
        }
        if (this.mark_image_url != null) {
            sb5.append(", mark_image_url=");
            sb5.append(Internal.sanitize(this.mark_image_url));
        }
        StringBuilder replace = sb5.replace(0, 2, "MarkLabel{");
        replace.append('}');
        return replace.toString();
    }

    public MarkLabel(MarkLabelType markLabelType, int i3, String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (markLabelType != null) {
            this.mark_label_type = markLabelType;
            this.position = i3;
            if (str != null) {
                this.prime_text = str;
                if (str2 != null) {
                    this.mark_image_url = str2;
                    return;
                }
                throw new IllegalArgumentException("mark_image_url == null");
            }
            throw new IllegalArgumentException("prime_text == null");
        }
        throw new IllegalArgumentException("mark_label_type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437689a = this.mark_label_type;
        aVar.f437690b = this.position;
        aVar.f437691c = this.prime_text;
        aVar.f437692d = this.mark_image_url;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
