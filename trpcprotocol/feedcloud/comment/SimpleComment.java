package trpcprotocol.feedcloud.comment;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class SimpleComment extends Message<SimpleComment, a> {
    public static final ProtoAdapter<SimpleComment> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = WSAutoShowCommentParams.KEY_COMMENT_ID, label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String comment_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "feedId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String feed_id;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<SimpleComment, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437273a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f437274b = "";

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleComment build() {
            return new SimpleComment(this.f437273a, this.f437274b, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437274b = str;
            return this;
        }

        public a c(String str) {
            this.f437273a = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<SimpleComment> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SimpleComment.class, "type.googleapis.com/trpc.feedcloud.comment.SimpleComment", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleComment decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
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
        public void encode(ProtoWriter protoWriter, SimpleComment simpleComment) throws IOException {
            if (!Objects.equals(simpleComment.feed_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, simpleComment.feed_id);
            }
            if (!Objects.equals(simpleComment.comment_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, simpleComment.comment_id);
            }
            protoWriter.writeBytes(simpleComment.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SimpleComment simpleComment) {
            int i3 = 0;
            if (!Objects.equals(simpleComment.feed_id, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, simpleComment.feed_id);
            }
            if (!Objects.equals(simpleComment.comment_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, simpleComment.comment_id);
            }
            return i3 + simpleComment.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SimpleComment redact(SimpleComment simpleComment) {
            a newBuilder = simpleComment.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SimpleComment(String str, String str2) {
        this(str, str2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleComment)) {
            return false;
        }
        SimpleComment simpleComment = (SimpleComment) obj;
        if (unknownFields().equals(simpleComment.unknownFields()) && Internal.equals(this.feed_id, simpleComment.feed_id) && Internal.equals(this.comment_id, simpleComment.comment_id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.feed_id;
            int i17 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i18 = (hashCode + i3) * 37;
            String str2 = this.comment_id;
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
        if (this.feed_id != null) {
            sb5.append(", feed_id=");
            sb5.append(Internal.sanitize(this.feed_id));
        }
        if (this.comment_id != null) {
            sb5.append(", comment_id=");
            sb5.append(Internal.sanitize(this.comment_id));
        }
        StringBuilder replace = sb5.replace(0, 2, "SimpleComment{");
        replace.append('}');
        return replace.toString();
    }

    public SimpleComment(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.feed_id = str;
            if (str2 != null) {
                this.comment_id = str2;
                return;
            }
            throw new IllegalArgumentException("comment_id == null");
        }
        throw new IllegalArgumentException("feed_id == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437273a = this.feed_id;
        aVar.f437274b = this.comment_id;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
