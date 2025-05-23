package seal_recommend;

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
/* loaded from: classes29.dex */
public final class AdvertRepullStrategy extends Message<AdvertRepullStrategy, a> {
    public static final ProtoAdapter<AdvertRepullStrategy> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "adRepullOffset", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int ad_repull_offset;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "adRepullUnexposeMaxTime", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int ad_repull_unexpose_max_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "enableAdRepull", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean enable_ad_repull;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class a extends Message.Builder<AdvertRepullStrategy, a> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f433758a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f433759b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f433760c = 0;

        public a a(int i3) {
            this.f433760c = i3;
            return this;
        }

        public a b(int i3) {
            this.f433759b = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdvertRepullStrategy build() {
            return new AdvertRepullStrategy(this.f433758a, this.f433759b, this.f433760c, super.buildUnknownFields());
        }

        public a d(boolean z16) {
            this.f433758a = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class b extends ProtoAdapter<AdvertRepullStrategy> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AdvertRepullStrategy.class, "type.googleapis.com/seal_recommend.AdvertRepullStrategy", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdvertRepullStrategy decode(ProtoReader protoReader) throws IOException {
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
                                aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                        }
                    } else {
                        aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, AdvertRepullStrategy advertRepullStrategy) throws IOException {
            if (!Objects.equals(Boolean.valueOf(advertRepullStrategy.enable_ad_repull), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(advertRepullStrategy.enable_ad_repull));
            }
            if (!Objects.equals(Integer.valueOf(advertRepullStrategy.ad_repull_unexpose_max_time), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(advertRepullStrategy.ad_repull_unexpose_max_time));
            }
            if (!Objects.equals(Integer.valueOf(advertRepullStrategy.ad_repull_offset), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(advertRepullStrategy.ad_repull_offset));
            }
            protoWriter.writeBytes(advertRepullStrategy.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AdvertRepullStrategy advertRepullStrategy) {
            int i3 = 0;
            if (!Objects.equals(Boolean.valueOf(advertRepullStrategy.enable_ad_repull), Boolean.FALSE)) {
                i3 = 0 + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(advertRepullStrategy.enable_ad_repull));
            }
            if (!Objects.equals(Integer.valueOf(advertRepullStrategy.ad_repull_unexpose_max_time), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(advertRepullStrategy.ad_repull_unexpose_max_time));
            }
            if (!Objects.equals(Integer.valueOf(advertRepullStrategy.ad_repull_offset), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(advertRepullStrategy.ad_repull_offset));
            }
            return i3 + advertRepullStrategy.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AdvertRepullStrategy redact(AdvertRepullStrategy advertRepullStrategy) {
            a newBuilder = advertRepullStrategy.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AdvertRepullStrategy(boolean z16, int i3, int i16) {
        this(z16, i3, i16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdvertRepullStrategy)) {
            return false;
        }
        AdvertRepullStrategy advertRepullStrategy = (AdvertRepullStrategy) obj;
        if (unknownFields().equals(advertRepullStrategy.unknownFields()) && Internal.equals(Boolean.valueOf(this.enable_ad_repull), Boolean.valueOf(advertRepullStrategy.enable_ad_repull)) && Internal.equals(Integer.valueOf(this.ad_repull_unexpose_max_time), Integer.valueOf(advertRepullStrategy.ad_repull_unexpose_max_time)) && Internal.equals(Integer.valueOf(this.ad_repull_offset), Integer.valueOf(advertRepullStrategy.ad_repull_offset))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.enable_ad_repull)) * 37) + this.ad_repull_unexpose_max_time) * 37) + this.ad_repull_offset;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", enable_ad_repull=");
        sb5.append(this.enable_ad_repull);
        sb5.append(", ad_repull_unexpose_max_time=");
        sb5.append(this.ad_repull_unexpose_max_time);
        sb5.append(", ad_repull_offset=");
        sb5.append(this.ad_repull_offset);
        StringBuilder replace = sb5.replace(0, 2, "AdvertRepullStrategy{");
        replace.append('}');
        return replace.toString();
    }

    public AdvertRepullStrategy(boolean z16, int i3, int i16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.enable_ad_repull = z16;
        this.ad_repull_unexpose_max_time = i3;
        this.ad_repull_offset = i16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f433758a = this.enable_ad_repull;
        aVar.f433759b = this.ad_repull_unexpose_max_time;
        aVar.f433760c = this.ad_repull_offset;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
