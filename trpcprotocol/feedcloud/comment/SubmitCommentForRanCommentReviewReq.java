package trpcprotocol.feedcloud.comment;

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
public final class SubmitCommentForRanCommentReviewReq extends Message<SubmitCommentForRanCommentReviewReq, a> {
    public static final ProtoAdapter<SubmitCommentForRanCommentReviewReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "trpcprotocol.feedcloud.comment.SimpleComment#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final SimpleComment comment;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "submitTouchType", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int submit_touch_type;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<SubmitCommentForRanCommentReviewReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public SimpleComment f437275a;

        /* renamed from: b, reason: collision with root package name */
        public int f437276b = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubmitCommentForRanCommentReviewReq build() {
            return new SubmitCommentForRanCommentReviewReq(this.f437275a, this.f437276b, super.buildUnknownFields());
        }

        public a b(SimpleComment simpleComment) {
            this.f437275a = simpleComment;
            return this;
        }

        public a c(int i3) {
            this.f437276b = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<SubmitCommentForRanCommentReviewReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SubmitCommentForRanCommentReviewReq.class, "type.googleapis.com/trpc.feedcloud.comment.SubmitCommentForRanCommentReviewReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubmitCommentForRanCommentReviewReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.b(SimpleComment.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SubmitCommentForRanCommentReviewReq submitCommentForRanCommentReviewReq) throws IOException {
            if (!Objects.equals(submitCommentForRanCommentReviewReq.comment, null)) {
                SimpleComment.ADAPTER.encodeWithTag(protoWriter, 1, submitCommentForRanCommentReviewReq.comment);
            }
            if (!Objects.equals(Integer.valueOf(submitCommentForRanCommentReviewReq.submit_touch_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(submitCommentForRanCommentReviewReq.submit_touch_type));
            }
            protoWriter.writeBytes(submitCommentForRanCommentReviewReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SubmitCommentForRanCommentReviewReq submitCommentForRanCommentReviewReq) {
            int i3;
            if (!Objects.equals(submitCommentForRanCommentReviewReq.comment, null)) {
                i3 = SimpleComment.ADAPTER.encodedSizeWithTag(1, submitCommentForRanCommentReviewReq.comment) + 0;
            } else {
                i3 = 0;
            }
            if (!Objects.equals(Integer.valueOf(submitCommentForRanCommentReviewReq.submit_touch_type), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(submitCommentForRanCommentReviewReq.submit_touch_type));
            }
            return i3 + submitCommentForRanCommentReviewReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SubmitCommentForRanCommentReviewReq redact(SubmitCommentForRanCommentReviewReq submitCommentForRanCommentReviewReq) {
            a newBuilder = submitCommentForRanCommentReviewReq.newBuilder();
            SimpleComment simpleComment = newBuilder.f437275a;
            if (simpleComment != null) {
                newBuilder.f437275a = SimpleComment.ADAPTER.redact(simpleComment);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SubmitCommentForRanCommentReviewReq(SimpleComment simpleComment, int i3) {
        this(simpleComment, i3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitCommentForRanCommentReviewReq)) {
            return false;
        }
        SubmitCommentForRanCommentReviewReq submitCommentForRanCommentReviewReq = (SubmitCommentForRanCommentReviewReq) obj;
        if (unknownFields().equals(submitCommentForRanCommentReviewReq.unknownFields()) && Internal.equals(this.comment, submitCommentForRanCommentReviewReq.comment) && Internal.equals(Integer.valueOf(this.submit_touch_type), Integer.valueOf(submitCommentForRanCommentReviewReq.submit_touch_type))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            SimpleComment simpleComment = this.comment;
            if (simpleComment != null) {
                i3 = simpleComment.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = ((hashCode + i3) * 37) + this.submit_touch_type;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.comment != null) {
            sb5.append(", comment=");
            sb5.append(this.comment);
        }
        sb5.append(", submit_touch_type=");
        sb5.append(this.submit_touch_type);
        StringBuilder replace = sb5.replace(0, 2, "SubmitCommentForRanCommentReviewReq{");
        replace.append('}');
        return replace.toString();
    }

    public SubmitCommentForRanCommentReviewReq(SimpleComment simpleComment, int i3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.comment = simpleComment;
        this.submit_touch_type = i3;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437275a = this.comment;
        aVar.f437276b = this.submit_touch_type;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
