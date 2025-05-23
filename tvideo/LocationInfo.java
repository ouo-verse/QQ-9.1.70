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
public final class LocationInfo extends Message<LocationInfo, a> {
    public static final ProtoAdapter<LocationInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final double accuracy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "areaMode", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final int area_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "countryCode", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final int country_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "langCode", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final int lang_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final float latitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final float longitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int type;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<LocationInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437660a = 0;

        /* renamed from: b, reason: collision with root package name */
        public float f437661b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f437662c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public double f437663d = 0.0d;

        /* renamed from: e, reason: collision with root package name */
        public int f437664e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f437665f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f437666g = 0;

        public a a(double d16) {
            this.f437663d = d16;
            return this;
        }

        public a b(int i3) {
            this.f437664e = i3;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public LocationInfo build() {
            return new LocationInfo(this.f437660a, this.f437661b, this.f437662c, this.f437663d, this.f437664e, this.f437665f, this.f437666g, super.buildUnknownFields());
        }

        public a d(int i3) {
            this.f437665f = i3;
            return this;
        }

        public a e(int i3) {
            this.f437666g = i3;
            return this;
        }

        public a f(float f16) {
            this.f437661b = f16;
            return this;
        }

        public a g(float f16) {
            this.f437662c = f16;
            return this;
        }

        public a h(int i3) {
            this.f437660a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<LocationInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) LocationInfo.class, "type.googleapis.com/tvideo.LocationInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocationInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.h(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.f(ProtoAdapter.FLOAT.decode(protoReader).floatValue());
                            break;
                        case 3:
                            aVar.g(ProtoAdapter.FLOAT.decode(protoReader).floatValue());
                            break;
                        case 4:
                            aVar.a(ProtoAdapter.DOUBLE.decode(protoReader).doubleValue());
                            break;
                        case 5:
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 6:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 7:
                            aVar.e(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        default:
                            protoReader.readUnknownField(nextTag);
                            break;
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, LocationInfo locationInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(locationInfo.type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(locationInfo.type));
            }
            if (!Objects.equals(Float.valueOf(locationInfo.latitude), Float.valueOf(0.0f))) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, Float.valueOf(locationInfo.latitude));
            }
            if (!Objects.equals(Float.valueOf(locationInfo.longitude), Float.valueOf(0.0f))) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 3, Float.valueOf(locationInfo.longitude));
            }
            if (!Objects.equals(Double.valueOf(locationInfo.accuracy), Double.valueOf(0.0d))) {
                ProtoAdapter.DOUBLE.encodeWithTag(protoWriter, 4, Double.valueOf(locationInfo.accuracy));
            }
            if (!Objects.equals(Integer.valueOf(locationInfo.area_mode), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, Integer.valueOf(locationInfo.area_mode));
            }
            if (!Objects.equals(Integer.valueOf(locationInfo.country_code), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 6, Integer.valueOf(locationInfo.country_code));
            }
            if (!Objects.equals(Integer.valueOf(locationInfo.lang_code), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, Integer.valueOf(locationInfo.lang_code));
            }
            protoWriter.writeBytes(locationInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(LocationInfo locationInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(locationInfo.type), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(locationInfo.type));
            }
            if (!Objects.equals(Float.valueOf(locationInfo.latitude), Float.valueOf(0.0f))) {
                i3 += ProtoAdapter.FLOAT.encodedSizeWithTag(2, Float.valueOf(locationInfo.latitude));
            }
            if (!Objects.equals(Float.valueOf(locationInfo.longitude), Float.valueOf(0.0f))) {
                i3 += ProtoAdapter.FLOAT.encodedSizeWithTag(3, Float.valueOf(locationInfo.longitude));
            }
            if (!Objects.equals(Double.valueOf(locationInfo.accuracy), Double.valueOf(0.0d))) {
                i3 += ProtoAdapter.DOUBLE.encodedSizeWithTag(4, Double.valueOf(locationInfo.accuracy));
            }
            if (!Objects.equals(Integer.valueOf(locationInfo.area_mode), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(5, Integer.valueOf(locationInfo.area_mode));
            }
            if (!Objects.equals(Integer.valueOf(locationInfo.country_code), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(6, Integer.valueOf(locationInfo.country_code));
            }
            if (!Objects.equals(Integer.valueOf(locationInfo.lang_code), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(7, Integer.valueOf(locationInfo.lang_code));
            }
            return i3 + locationInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public LocationInfo redact(LocationInfo locationInfo) {
            a newBuilder = locationInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public LocationInfo(int i3, float f16, float f17, double d16, int i16, int i17, int i18) {
        this(i3, f16, f17, d16, i16, i17, i18, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocationInfo)) {
            return false;
        }
        LocationInfo locationInfo = (LocationInfo) obj;
        if (unknownFields().equals(locationInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.type), Integer.valueOf(locationInfo.type)) && Internal.equals(Float.valueOf(this.latitude), Float.valueOf(locationInfo.latitude)) && Internal.equals(Float.valueOf(this.longitude), Float.valueOf(locationInfo.longitude)) && Internal.equals(Double.valueOf(this.accuracy), Double.valueOf(locationInfo.accuracy)) && Internal.equals(Integer.valueOf(this.area_mode), Integer.valueOf(locationInfo.area_mode)) && Internal.equals(Integer.valueOf(this.country_code), Integer.valueOf(locationInfo.country_code)) && Internal.equals(Integer.valueOf(this.lang_code), Integer.valueOf(locationInfo.lang_code))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((((((((unknownFields().hashCode() * 37) + this.type) * 37) + Float.floatToIntBits(this.latitude)) * 37) + Float.floatToIntBits(this.longitude)) * 37) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.accuracy)) * 37) + this.area_mode) * 37) + this.country_code) * 37) + this.lang_code;
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", type=");
        sb5.append(this.type);
        sb5.append(", latitude=");
        sb5.append(this.latitude);
        sb5.append(", longitude=");
        sb5.append(this.longitude);
        sb5.append(", accuracy=");
        sb5.append(this.accuracy);
        sb5.append(", area_mode=");
        sb5.append(this.area_mode);
        sb5.append(", country_code=");
        sb5.append(this.country_code);
        sb5.append(", lang_code=");
        sb5.append(this.lang_code);
        StringBuilder replace = sb5.replace(0, 2, "LocationInfo{");
        replace.append('}');
        return replace.toString();
    }

    public LocationInfo(int i3, float f16, float f17, double d16, int i16, int i17, int i18, ByteString byteString) {
        super(ADAPTER, byteString);
        this.type = i3;
        this.latitude = f16;
        this.longitude = f17;
        this.accuracy = d16;
        this.area_mode = i16;
        this.country_code = i17;
        this.lang_code = i18;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437660a = this.type;
        aVar.f437661b = this.latitude;
        aVar.f437662c = this.longitude;
        aVar.f437663d = this.accuracy;
        aVar.f437664e = this.area_mode;
        aVar.f437665f = this.country_code;
        aVar.f437666g = this.lang_code;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
