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
public final class BucketInfo extends Message<BucketInfo, a> {
    public static final ProtoAdapter<BucketInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "bucketId", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int bucket_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final String extra;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<BucketInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437587a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f437588b = "";

        public a a(int i3) {
            this.f437587a = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BucketInfo build() {
            return new BucketInfo(this.f437587a, this.f437588b, super.buildUnknownFields());
        }

        public a c(String str) {
            this.f437588b = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<BucketInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) BucketInfo.class, "type.googleapis.com/tvideo.BucketInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BucketInfo decode(ProtoReader protoReader) throws IOException {
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
                        aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, BucketInfo bucketInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(bucketInfo.bucket_id), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(bucketInfo.bucket_id));
            }
            if (!Objects.equals(bucketInfo.extra, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, bucketInfo.extra);
            }
            protoWriter.writeBytes(bucketInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(BucketInfo bucketInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(bucketInfo.bucket_id), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(bucketInfo.bucket_id));
            }
            if (!Objects.equals(bucketInfo.extra, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(2, bucketInfo.extra);
            }
            return i3 + bucketInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BucketInfo redact(BucketInfo bucketInfo) {
            a newBuilder = bucketInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public BucketInfo(int i3, String str) {
        this(i3, str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BucketInfo)) {
            return false;
        }
        BucketInfo bucketInfo = (BucketInfo) obj;
        if (unknownFields().equals(bucketInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.bucket_id), Integer.valueOf(bucketInfo.bucket_id)) && Internal.equals(this.extra, bucketInfo.extra)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((unknownFields().hashCode() * 37) + this.bucket_id) * 37;
            String str = this.extra;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = hashCode + i3;
            this.hashCode = i17;
            return i17;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", bucket_id=");
        sb5.append(this.bucket_id);
        if (this.extra != null) {
            sb5.append(", extra=");
            sb5.append(Internal.sanitize(this.extra));
        }
        StringBuilder replace = sb5.replace(0, 2, "BucketInfo{");
        replace.append('}');
        return replace.toString();
    }

    public BucketInfo(int i3, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.bucket_id = i3;
        if (str != null) {
            this.extra = str;
            return;
        }
        throw new IllegalArgumentException("extra == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437587a = this.bucket_id;
        aVar.f437588b = this.extra;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
