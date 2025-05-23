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
public final class VideoHotTag extends Message<VideoHotTag, a> {
    public static final ProtoAdapter<VideoHotTag> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", jsonName = "hotTagNum", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final long hot_tag_num;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "iconUrl", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "textColor", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String text_color;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<VideoHotTag, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437826a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437827b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f437828c = "";

        /* renamed from: d, reason: collision with root package name */
        public long f437829d = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoHotTag build() {
            return new VideoHotTag(this.f437826a, this.f437827b, this.f437828c, this.f437829d, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437827b = str;
            return this;
        }

        public a c(long j3) {
            this.f437829d = j3;
            return this;
        }

        public a d(String str) {
            this.f437826a = str;
            return this;
        }

        public a e(String str) {
            this.f437828c = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<VideoHotTag> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) VideoHotTag.class, "type.googleapis.com/tvideo.VideoHotTag", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoHotTag decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.c(ProtoAdapter.INT64.decode(protoReader).longValue());
                                }
                            } else {
                                aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.b(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, VideoHotTag videoHotTag) throws IOException {
            if (!Objects.equals(videoHotTag.icon_url, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, videoHotTag.icon_url);
            }
            if (!Objects.equals(videoHotTag.desc, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, videoHotTag.desc);
            }
            if (!Objects.equals(videoHotTag.text_color, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, videoHotTag.text_color);
            }
            if (!Objects.equals(Long.valueOf(videoHotTag.hot_tag_num), 0L)) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, Long.valueOf(videoHotTag.hot_tag_num));
            }
            protoWriter.writeBytes(videoHotTag.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(VideoHotTag videoHotTag) {
            int i3 = 0;
            if (!Objects.equals(videoHotTag.icon_url, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, videoHotTag.icon_url);
            }
            if (!Objects.equals(videoHotTag.desc, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, videoHotTag.desc);
            }
            if (!Objects.equals(videoHotTag.text_color, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, videoHotTag.text_color);
            }
            if (!Objects.equals(Long.valueOf(videoHotTag.hot_tag_num), 0L)) {
                i3 += ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(videoHotTag.hot_tag_num));
            }
            return i3 + videoHotTag.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public VideoHotTag redact(VideoHotTag videoHotTag) {
            a newBuilder = videoHotTag.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public VideoHotTag(String str, String str2, String str3, long j3) {
        this(str, str2, str3, j3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoHotTag)) {
            return false;
        }
        VideoHotTag videoHotTag = (VideoHotTag) obj;
        if (unknownFields().equals(videoHotTag.unknownFields()) && Internal.equals(this.icon_url, videoHotTag.icon_url) && Internal.equals(this.desc, videoHotTag.desc) && Internal.equals(this.text_color, videoHotTag.text_color) && Internal.equals(Long.valueOf(this.hot_tag_num), Long.valueOf(videoHotTag.hot_tag_num))) {
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
            String str = this.icon_url;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            String str2 = this.desc;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            String str3 = this.text_color;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            int a16 = ((i26 + i18) * 37) + androidx.fragment.app.a.a(this.hot_tag_num);
            this.hashCode = a16;
            return a16;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.icon_url != null) {
            sb5.append(", icon_url=");
            sb5.append(Internal.sanitize(this.icon_url));
        }
        if (this.desc != null) {
            sb5.append(", desc=");
            sb5.append(Internal.sanitize(this.desc));
        }
        if (this.text_color != null) {
            sb5.append(", text_color=");
            sb5.append(Internal.sanitize(this.text_color));
        }
        sb5.append(", hot_tag_num=");
        sb5.append(this.hot_tag_num);
        StringBuilder replace = sb5.replace(0, 2, "VideoHotTag{");
        replace.append('}');
        return replace.toString();
    }

    public VideoHotTag(String str, String str2, String str3, long j3, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.icon_url = str;
            if (str2 != null) {
                this.desc = str2;
                if (str3 != null) {
                    this.text_color = str3;
                    this.hot_tag_num = j3;
                    return;
                }
                throw new IllegalArgumentException("text_color == null");
            }
            throw new IllegalArgumentException("desc == null");
        }
        throw new IllegalArgumentException("icon_url == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437826a = this.icon_url;
        aVar.f437827b = this.desc;
        aVar.f437828c = this.text_color;
        aVar.f437829d = this.hot_tag_num;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
