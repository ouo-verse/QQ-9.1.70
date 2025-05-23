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
public final class SubmitCommentForRanCommentReviewRsp extends Message<SubmitCommentForRanCommentReviewRsp, a> {
    public static final ProtoAdapter<SubmitCommentForRanCommentReviewRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "leftTimes", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int left_times;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "totalTimes", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int total_times;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<SubmitCommentForRanCommentReviewRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437277a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f437278b = 0;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubmitCommentForRanCommentReviewRsp build() {
            return new SubmitCommentForRanCommentReviewRsp(this.f437277a, this.f437278b, super.buildUnknownFields());
        }

        public a b(int i3) {
            this.f437278b = i3;
            return this;
        }

        public a c(int i3) {
            this.f437277a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<SubmitCommentForRanCommentReviewRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SubmitCommentForRanCommentReviewRsp.class, "type.googleapis.com/trpc.feedcloud.comment.SubmitCommentForRanCommentReviewRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubmitCommentForRanCommentReviewRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            protoReader.readUnknownField(nextTag);
                        } else {
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SubmitCommentForRanCommentReviewRsp submitCommentForRanCommentReviewRsp) throws IOException {
            if (!Objects.equals(Integer.valueOf(submitCommentForRanCommentReviewRsp.total_times), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(submitCommentForRanCommentReviewRsp.total_times));
            }
            if (!Objects.equals(Integer.valueOf(submitCommentForRanCommentReviewRsp.left_times), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(submitCommentForRanCommentReviewRsp.left_times));
            }
            protoWriter.writeBytes(submitCommentForRanCommentReviewRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SubmitCommentForRanCommentReviewRsp submitCommentForRanCommentReviewRsp) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(submitCommentForRanCommentReviewRsp.total_times), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(submitCommentForRanCommentReviewRsp.total_times));
            }
            if (!Objects.equals(Integer.valueOf(submitCommentForRanCommentReviewRsp.left_times), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(submitCommentForRanCommentReviewRsp.left_times));
            }
            return i3 + submitCommentForRanCommentReviewRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SubmitCommentForRanCommentReviewRsp redact(SubmitCommentForRanCommentReviewRsp submitCommentForRanCommentReviewRsp) {
            a newBuilder = submitCommentForRanCommentReviewRsp.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SubmitCommentForRanCommentReviewRsp(int i3, int i16) {
        this(i3, i16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitCommentForRanCommentReviewRsp)) {
            return false;
        }
        SubmitCommentForRanCommentReviewRsp submitCommentForRanCommentReviewRsp = (SubmitCommentForRanCommentReviewRsp) obj;
        if (unknownFields().equals(submitCommentForRanCommentReviewRsp.unknownFields()) && Internal.equals(Integer.valueOf(this.total_times), Integer.valueOf(submitCommentForRanCommentReviewRsp.total_times)) && Internal.equals(Integer.valueOf(this.left_times), Integer.valueOf(submitCommentForRanCommentReviewRsp.left_times))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((unknownFields().hashCode() * 37) + this.total_times) * 37) + this.left_times;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", total_times=");
        sb5.append(this.total_times);
        sb5.append(", left_times=");
        sb5.append(this.left_times);
        StringBuilder replace = sb5.replace(0, 2, "SubmitCommentForRanCommentReviewRsp{");
        replace.append('}');
        return replace.toString();
    }

    public SubmitCommentForRanCommentReviewRsp(int i3, int i16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.total_times = i3;
        this.left_times = i16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437277a = this.total_times;
        aVar.f437278b = this.left_times;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
