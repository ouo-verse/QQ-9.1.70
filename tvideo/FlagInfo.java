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
public final class FlagInfo extends Message<FlagInfo, a> {
    public static final ProtoAdapter<FlagInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "autoRetryFlag", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int auto_retry_flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "checkFlag", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int check_flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "debugFlag", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int debug_flag;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "needRetryFlag", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final int need_retry_flag;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<FlagInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437631a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f437632b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f437633c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f437634d = 0;

        public a a(int i3) {
            this.f437633c = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FlagInfo build() {
            return new FlagInfo(this.f437631a, this.f437632b, this.f437633c, this.f437634d, super.buildUnknownFields());
        }

        public a c(int i3) {
            this.f437631a = i3;
            return this;
        }

        public a d(int i3) {
            this.f437632b = i3;
            return this;
        }

        public a e(int i3) {
            this.f437634d = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<FlagInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) FlagInfo.class, "type.googleapis.com/tvideo.FlagInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FlagInfo decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.e(ProtoAdapter.INT32.decode(protoReader).intValue());
                                }
                            } else {
                                aVar.a(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
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
        public void encode(ProtoWriter protoWriter, FlagInfo flagInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(flagInfo.check_flag), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(flagInfo.check_flag));
            }
            if (!Objects.equals(Integer.valueOf(flagInfo.debug_flag), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(flagInfo.debug_flag));
            }
            if (!Objects.equals(Integer.valueOf(flagInfo.auto_retry_flag), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(flagInfo.auto_retry_flag));
            }
            if (!Objects.equals(Integer.valueOf(flagInfo.need_retry_flag), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, Integer.valueOf(flagInfo.need_retry_flag));
            }
            protoWriter.writeBytes(flagInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(FlagInfo flagInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(flagInfo.check_flag), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(flagInfo.check_flag));
            }
            if (!Objects.equals(Integer.valueOf(flagInfo.debug_flag), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(flagInfo.debug_flag));
            }
            if (!Objects.equals(Integer.valueOf(flagInfo.auto_retry_flag), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(flagInfo.auto_retry_flag));
            }
            if (!Objects.equals(Integer.valueOf(flagInfo.need_retry_flag), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(4, Integer.valueOf(flagInfo.need_retry_flag));
            }
            return i3 + flagInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public FlagInfo redact(FlagInfo flagInfo) {
            a newBuilder = flagInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public FlagInfo(int i3, int i16, int i17, int i18) {
        this(i3, i16, i17, i18, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlagInfo)) {
            return false;
        }
        FlagInfo flagInfo = (FlagInfo) obj;
        if (unknownFields().equals(flagInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.check_flag), Integer.valueOf(flagInfo.check_flag)) && Internal.equals(Integer.valueOf(this.debug_flag), Integer.valueOf(flagInfo.debug_flag)) && Internal.equals(Integer.valueOf(this.auto_retry_flag), Integer.valueOf(flagInfo.auto_retry_flag)) && Internal.equals(Integer.valueOf(this.need_retry_flag), Integer.valueOf(flagInfo.need_retry_flag))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((unknownFields().hashCode() * 37) + this.check_flag) * 37) + this.debug_flag) * 37) + this.auto_retry_flag) * 37) + this.need_retry_flag;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", check_flag=");
        sb5.append(this.check_flag);
        sb5.append(", debug_flag=");
        sb5.append(this.debug_flag);
        sb5.append(", auto_retry_flag=");
        sb5.append(this.auto_retry_flag);
        sb5.append(", need_retry_flag=");
        sb5.append(this.need_retry_flag);
        StringBuilder replace = sb5.replace(0, 2, "FlagInfo{");
        replace.append('}');
        return replace.toString();
    }

    public FlagInfo(int i3, int i16, int i17, int i18, ByteString byteString) {
        super(ADAPTER, byteString);
        this.check_flag = i3;
        this.debug_flag = i16;
        this.auto_retry_flag = i17;
        this.need_retry_flag = i18;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437631a = this.check_flag;
        aVar.f437632b = this.debug_flag;
        aVar.f437633c = this.auto_retry_flag;
        aVar.f437634d = this.need_retry_flag;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
