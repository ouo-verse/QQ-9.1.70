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
public final class AttitudeInfo extends Message<AttitudeInfo, a> {
    public static final ProtoAdapter<AttitudeInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "attitudeCount", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int attitude_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "attitudeStatus", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int attitude_status;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", jsonName = "isAttitudeAvailable", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final boolean is_attitude_available;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<AttitudeInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437584a = 0;

        /* renamed from: b, reason: collision with root package name */
        public boolean f437585b = false;

        /* renamed from: c, reason: collision with root package name */
        public int f437586c = 0;

        public a a(int i3) {
            this.f437584a = i3;
            return this;
        }

        public a b(int i3) {
            this.f437586c = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AttitudeInfo build() {
            return new AttitudeInfo(this.f437584a, this.f437585b, this.f437586c, super.buildUnknownFields());
        }

        public a d(boolean z16) {
            this.f437585b = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<AttitudeInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) AttitudeInfo.class, "type.googleapis.com/tvideo.AttitudeInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AttitudeInfo decode(ProtoReader protoReader) throws IOException {
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
                                aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            }
                        } else {
                            aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
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
        public void encode(ProtoWriter protoWriter, AttitudeInfo attitudeInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(attitudeInfo.attitude_count), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(attitudeInfo.attitude_count));
            }
            if (!Objects.equals(Boolean.valueOf(attitudeInfo.is_attitude_available), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, Boolean.valueOf(attitudeInfo.is_attitude_available));
            }
            if (!Objects.equals(Integer.valueOf(attitudeInfo.attitude_status), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(attitudeInfo.attitude_status));
            }
            protoWriter.writeBytes(attitudeInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(AttitudeInfo attitudeInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(attitudeInfo.attitude_count), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(attitudeInfo.attitude_count));
            }
            if (!Objects.equals(Boolean.valueOf(attitudeInfo.is_attitude_available), Boolean.FALSE)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(2, Boolean.valueOf(attitudeInfo.is_attitude_available));
            }
            if (!Objects.equals(Integer.valueOf(attitudeInfo.attitude_status), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(attitudeInfo.attitude_status));
            }
            return i3 + attitudeInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public AttitudeInfo redact(AttitudeInfo attitudeInfo) {
            a newBuilder = attitudeInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public AttitudeInfo(int i3, boolean z16, int i16) {
        this(i3, z16, i16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttitudeInfo)) {
            return false;
        }
        AttitudeInfo attitudeInfo = (AttitudeInfo) obj;
        if (unknownFields().equals(attitudeInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.attitude_count), Integer.valueOf(attitudeInfo.attitude_count)) && Internal.equals(Boolean.valueOf(this.is_attitude_available), Boolean.valueOf(attitudeInfo.is_attitude_available)) && Internal.equals(Integer.valueOf(this.attitude_status), Integer.valueOf(attitudeInfo.attitude_status))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((unknownFields().hashCode() * 37) + this.attitude_count) * 37) + com.tencent.aio.widget.textView.param.a.a(this.is_attitude_available)) * 37) + this.attitude_status;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", attitude_count=");
        sb5.append(this.attitude_count);
        sb5.append(", is_attitude_available=");
        sb5.append(this.is_attitude_available);
        sb5.append(", attitude_status=");
        sb5.append(this.attitude_status);
        StringBuilder replace = sb5.replace(0, 2, "AttitudeInfo{");
        replace.append('}');
        return replace.toString();
    }

    public AttitudeInfo(int i3, boolean z16, int i16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.attitude_count = i3;
        this.is_attitude_available = z16;
        this.attitude_status = i16;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437584a = this.attitude_count;
        aVar.f437585b = this.is_attitude_available;
        aVar.f437586c = this.attitude_status;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
