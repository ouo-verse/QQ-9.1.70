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
public final class VideoRecommendReason extends Message<VideoRecommendReason, a> {
    public static final ProtoAdapter<VideoRecommendReason> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "fontColor", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String font_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "labelColor", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String label_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String text;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<VideoRecommendReason, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437847a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437848b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437849c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f437850d = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoRecommendReason build() {
            return new VideoRecommendReason(this.f437847a, this.f437848b, this.f437849c, this.f437850d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437848b = str;
            return this;
        }

        public a c(String str) {
            this.f437847a = str;
            return this;
        }

        public a d(String str) {
            this.f437849c = str;
            return this;
        }

        public a e(String str) {
            this.f437850d = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<VideoRecommendReason> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoRecommendReason.class, "type.googleapis.com/tvideo.VideoRecommendReason", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoRecommendReason decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.e(ProtoAdapter.STRING.decode(protoReader));
                                }
                            } else {
                                aVar.d(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, VideoRecommendReason videoRecommendReason) throws IOException {
            if (!Objects.equals(videoRecommendReason.icon_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, videoRecommendReason.icon_url);
            }
            if (!Objects.equals(videoRecommendReason.font_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, videoRecommendReason.font_color);
            }
            if (!Objects.equals(videoRecommendReason.label_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, videoRecommendReason.label_color);
            }
            if (!Objects.equals(videoRecommendReason.text, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, videoRecommendReason.text);
            }
            protoWriter.writeBytes(videoRecommendReason.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoRecommendReason videoRecommendReason) {
            int i3 = 0;
            if (!Objects.equals(videoRecommendReason.icon_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, videoRecommendReason.icon_url);
            }
            if (!Objects.equals(videoRecommendReason.font_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, videoRecommendReason.font_color);
            }
            if (!Objects.equals(videoRecommendReason.label_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, videoRecommendReason.label_color);
            }
            if (!Objects.equals(videoRecommendReason.text, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, videoRecommendReason.text);
            }
            return i3 + videoRecommendReason.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VideoRecommendReason redact(VideoRecommendReason videoRecommendReason) {
            a newBuilder = videoRecommendReason.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoRecommendReason(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoRecommendReason)) {
            return false;
        }
        VideoRecommendReason videoRecommendReason = (VideoRecommendReason) obj;
        if (unknownFields().equals(videoRecommendReason.unknownFields()) && Internal.equals(this.icon_url, videoRecommendReason.icon_url) && Internal.equals(this.font_color, videoRecommendReason.font_color) && Internal.equals(this.label_color, videoRecommendReason.label_color) && Internal.equals(this.text, videoRecommendReason.text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18 = this.hashCode;
        if (i18 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.icon_url;
            int i19 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i26 = (hashCode + i3) * 37;
            String str2 = this.font_color;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i27 = (i26 + i16) * 37;
            String str3 = this.label_color;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i28 = (i27 + i17) * 37;
            String str4 = this.text;
            if (str4 != null) {
                i19 = str4.hashCode();
            }
            int i29 = i28 + i19;
            this.hashCode = i29;
            return i29;
        }
        return i18;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.icon_url != null) {
            sb5.append(", icon_url=");
            sb5.append(Internal.sanitize(this.icon_url));
        }
        if (this.font_color != null) {
            sb5.append(", font_color=");
            sb5.append(Internal.sanitize(this.font_color));
        }
        if (this.label_color != null) {
            sb5.append(", label_color=");
            sb5.append(Internal.sanitize(this.label_color));
        }
        if (this.text != null) {
            sb5.append(", text=");
            sb5.append(Internal.sanitize(this.text));
        }
        StringBuilder replace = sb5.replace(0, 2, "VideoRecommendReason{");
        replace.append('}');
        return replace.toString();
    }

    public VideoRecommendReason(String str, String str2, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.icon_url = str;
            if (str2 != null) {
                this.font_color = str2;
                if (str3 != null) {
                    this.label_color = str3;
                    if (str4 != null) {
                        this.text = str4;
                        return;
                    }
                    throw new IllegalArgumentException("text == null");
                }
                throw new IllegalArgumentException("label_color == null");
            }
            throw new IllegalArgumentException("font_color == null");
        }
        throw new IllegalArgumentException("icon_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437847a = this.icon_url;
        aVar.f437848b = this.font_color;
        aVar.f437849c = this.label_color;
        aVar.f437850d = this.text;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
