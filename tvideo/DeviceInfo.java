package tvideo;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.bugly.common.constants.Constants;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class DeviceInfo extends Message<DeviceInfo, a> {
    public static final ProtoAdapter<DeviceInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.UISizeType#ADAPTER", jsonName = "currentWindowUiSize", label = WireField.Label.OMIT_IDENTITY, tag = 13)
    public final UISizeType current_window_uiSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "densityDpi", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final int density_dpi;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = Constants.SP_DEVICE_ID, label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final String device_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "deviceModel", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final String device_model;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "deviceType", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final int device_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    public final String guid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String idfa;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String imei;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String imsi;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 16)
    public final String localIdfa;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 14)
    public final String manufacturer;

    @WireField(adapter = "tvideo.UISizeType#ADAPTER", jsonName = "maxUiSize", label = WireField.Label.OMIT_IDENTITY, tag = 12)
    public final UISizeType max_uiSize;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "omgId", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String omg_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 15)
    public final String qimei;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "screenHeight", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int screen_height;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "screenWidth", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int screen_width;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<DeviceInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437607a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f437608b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f437609c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f437610d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437611e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f437612f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f437613g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f437614h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f437615i = "";

        /* renamed from: j, reason: collision with root package name */
        public int f437616j = 0;

        /* renamed from: k, reason: collision with root package name */
        public String f437617k = "";

        /* renamed from: l, reason: collision with root package name */
        public UISizeType f437618l;

        /* renamed from: m, reason: collision with root package name */
        public UISizeType f437619m;

        /* renamed from: n, reason: collision with root package name */
        public String f437620n;

        /* renamed from: o, reason: collision with root package name */
        public String f437621o;

        /* renamed from: p, reason: collision with root package name */
        public String f437622p;

        public a() {
            UISizeType uISizeType = UISizeType.UISizeType_REGULAR;
            this.f437618l = uISizeType;
            this.f437619m = uISizeType;
            this.f437620n = "";
            this.f437621o = "";
            this.f437622p = "";
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceInfo build() {
            return new DeviceInfo(this, super.buildUnknownFields());
        }

        public a b(UISizeType uISizeType) {
            this.f437619m = uISizeType;
            return this;
        }

        public a c(int i3) {
            this.f437609c = i3;
            return this;
        }

        public a d(String str) {
            this.f437614h = str;
            return this;
        }

        public a e(String str) {
            this.f437615i = str;
            return this;
        }

        public a f(int i3) {
            this.f437616j = i3;
            return this;
        }

        public a g(String str) {
            this.f437617k = str;
            return this;
        }

        public a h(String str) {
            this.f437612f = str;
            return this;
        }

        public a i(String str) {
            this.f437610d = str;
            return this;
        }

        public a j(String str) {
            this.f437611e = str;
            return this;
        }

        public a k(String str) {
            this.f437622p = str;
            return this;
        }

        public a l(String str) {
            this.f437620n = str;
            return this;
        }

        public a m(UISizeType uISizeType) {
            this.f437618l = uISizeType;
            return this;
        }

        public a n(String str) {
            this.f437613g = str;
            return this;
        }

        public a o(String str) {
            this.f437621o = str;
            return this;
        }

        public a p(int i3) {
            this.f437608b = i3;
            return this;
        }

        public a q(int i3) {
            this.f437607a = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<DeviceInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) DeviceInfo.class, "type.googleapis.com/tvideo.DeviceInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.q(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.p(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.c(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 4:
                            aVar.i(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.j(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.n(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            aVar.f(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 11:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 12:
                            try {
                                aVar.m(UISizeType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 13:
                            try {
                                aVar.b(UISizeType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                break;
                            }
                        case 14:
                            aVar.l(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 15:
                            aVar.o(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            aVar.k(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, DeviceInfo deviceInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(deviceInfo.screen_width), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(deviceInfo.screen_width));
            }
            if (!Objects.equals(Integer.valueOf(deviceInfo.screen_height), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(deviceInfo.screen_height));
            }
            if (!Objects.equals(Integer.valueOf(deviceInfo.density_dpi), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, Integer.valueOf(deviceInfo.density_dpi));
            }
            if (!Objects.equals(deviceInfo.imei, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, deviceInfo.imei);
            }
            if (!Objects.equals(deviceInfo.imsi, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, deviceInfo.imsi);
            }
            if (!Objects.equals(deviceInfo.idfa, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, deviceInfo.idfa);
            }
            if (!Objects.equals(deviceInfo.omg_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, deviceInfo.omg_id);
            }
            if (!Objects.equals(deviceInfo.device_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, deviceInfo.device_id);
            }
            if (!Objects.equals(deviceInfo.device_model, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, deviceInfo.device_model);
            }
            if (!Objects.equals(Integer.valueOf(deviceInfo.device_type), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 10, Integer.valueOf(deviceInfo.device_type));
            }
            if (!Objects.equals(deviceInfo.guid, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, deviceInfo.guid);
            }
            UISizeType uISizeType = deviceInfo.max_uiSize;
            UISizeType uISizeType2 = UISizeType.UISizeType_REGULAR;
            if (!Objects.equals(uISizeType, uISizeType2)) {
                UISizeType.ADAPTER.encodeWithTag(protoWriter, 12, deviceInfo.max_uiSize);
            }
            if (!Objects.equals(deviceInfo.current_window_uiSize, uISizeType2)) {
                UISizeType.ADAPTER.encodeWithTag(protoWriter, 13, deviceInfo.current_window_uiSize);
            }
            if (!Objects.equals(deviceInfo.manufacturer, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, deviceInfo.manufacturer);
            }
            if (!Objects.equals(deviceInfo.qimei, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, deviceInfo.qimei);
            }
            if (!Objects.equals(deviceInfo.localIdfa, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, deviceInfo.localIdfa);
            }
            protoWriter.writeBytes(deviceInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(DeviceInfo deviceInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(deviceInfo.screen_width), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(deviceInfo.screen_width));
            }
            if (!Objects.equals(Integer.valueOf(deviceInfo.screen_height), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(deviceInfo.screen_height));
            }
            if (!Objects.equals(Integer.valueOf(deviceInfo.density_dpi), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(deviceInfo.density_dpi));
            }
            if (!Objects.equals(deviceInfo.imei, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, deviceInfo.imei);
            }
            if (!Objects.equals(deviceInfo.imsi, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, deviceInfo.imsi);
            }
            if (!Objects.equals(deviceInfo.idfa, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, deviceInfo.idfa);
            }
            if (!Objects.equals(deviceInfo.omg_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, deviceInfo.omg_id);
            }
            if (!Objects.equals(deviceInfo.device_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(8, deviceInfo.device_id);
            }
            if (!Objects.equals(deviceInfo.device_model, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(9, deviceInfo.device_model);
            }
            if (!Objects.equals(Integer.valueOf(deviceInfo.device_type), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(10, Integer.valueOf(deviceInfo.device_type));
            }
            if (!Objects.equals(deviceInfo.guid, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(11, deviceInfo.guid);
            }
            UISizeType uISizeType = deviceInfo.max_uiSize;
            UISizeType uISizeType2 = UISizeType.UISizeType_REGULAR;
            if (!Objects.equals(uISizeType, uISizeType2)) {
                i3 += UISizeType.ADAPTER.encodedSizeWithTag(12, deviceInfo.max_uiSize);
            }
            if (!Objects.equals(deviceInfo.current_window_uiSize, uISizeType2)) {
                i3 += UISizeType.ADAPTER.encodedSizeWithTag(13, deviceInfo.current_window_uiSize);
            }
            if (!Objects.equals(deviceInfo.manufacturer, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(14, deviceInfo.manufacturer);
            }
            if (!Objects.equals(deviceInfo.qimei, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(15, deviceInfo.qimei);
            }
            if (!Objects.equals(deviceInfo.localIdfa, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(16, deviceInfo.localIdfa);
            }
            return i3 + deviceInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DeviceInfo redact(DeviceInfo deviceInfo) {
            a newBuilder = deviceInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public DeviceInfo(a aVar, ByteString byteString) {
        super(ADAPTER, byteString);
        this.screen_width = aVar.f437607a;
        this.screen_height = aVar.f437608b;
        this.density_dpi = aVar.f437609c;
        String str = aVar.f437610d;
        if (str != null) {
            this.imei = str;
            String str2 = aVar.f437611e;
            if (str2 != null) {
                this.imsi = str2;
                String str3 = aVar.f437612f;
                if (str3 != null) {
                    this.idfa = str3;
                    String str4 = aVar.f437613g;
                    if (str4 != null) {
                        this.omg_id = str4;
                        String str5 = aVar.f437614h;
                        if (str5 != null) {
                            this.device_id = str5;
                            String str6 = aVar.f437615i;
                            if (str6 != null) {
                                this.device_model = str6;
                                this.device_type = aVar.f437616j;
                                String str7 = aVar.f437617k;
                                if (str7 != null) {
                                    this.guid = str7;
                                    UISizeType uISizeType = aVar.f437618l;
                                    if (uISizeType != null) {
                                        this.max_uiSize = uISizeType;
                                        UISizeType uISizeType2 = aVar.f437619m;
                                        if (uISizeType2 != null) {
                                            this.current_window_uiSize = uISizeType2;
                                            String str8 = aVar.f437620n;
                                            if (str8 != null) {
                                                this.manufacturer = str8;
                                                String str9 = aVar.f437621o;
                                                if (str9 != null) {
                                                    this.qimei = str9;
                                                    String str10 = aVar.f437622p;
                                                    if (str10 != null) {
                                                        this.localIdfa = str10;
                                                        return;
                                                    }
                                                    throw new IllegalArgumentException("builder.localIdfa == null");
                                                }
                                                throw new IllegalArgumentException("builder.qimei == null");
                                            }
                                            throw new IllegalArgumentException("builder.manufacturer == null");
                                        }
                                        throw new IllegalArgumentException("builder.current_window_uiSize == null");
                                    }
                                    throw new IllegalArgumentException("builder.max_uiSize == null");
                                }
                                throw new IllegalArgumentException("builder.guid == null");
                            }
                            throw new IllegalArgumentException("builder.device_model == null");
                        }
                        throw new IllegalArgumentException("builder.device_id == null");
                    }
                    throw new IllegalArgumentException("builder.omg_id == null");
                }
                throw new IllegalArgumentException("builder.idfa == null");
            }
            throw new IllegalArgumentException("builder.imsi == null");
        }
        throw new IllegalArgumentException("builder.imei == null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (unknownFields().equals(deviceInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.screen_width), Integer.valueOf(deviceInfo.screen_width)) && Internal.equals(Integer.valueOf(this.screen_height), Integer.valueOf(deviceInfo.screen_height)) && Internal.equals(Integer.valueOf(this.density_dpi), Integer.valueOf(deviceInfo.density_dpi)) && Internal.equals(this.imei, deviceInfo.imei) && Internal.equals(this.imsi, deviceInfo.imsi) && Internal.equals(this.idfa, deviceInfo.idfa) && Internal.equals(this.omg_id, deviceInfo.omg_id) && Internal.equals(this.device_id, deviceInfo.device_id) && Internal.equals(this.device_model, deviceInfo.device_model) && Internal.equals(Integer.valueOf(this.device_type), Integer.valueOf(deviceInfo.device_type)) && Internal.equals(this.guid, deviceInfo.guid) && Internal.equals(this.max_uiSize, deviceInfo.max_uiSize) && Internal.equals(this.current_window_uiSize, deviceInfo.current_window_uiSize) && Internal.equals(this.manufacturer, deviceInfo.manufacturer) && Internal.equals(this.qimei, deviceInfo.qimei) && Internal.equals(this.localIdfa, deviceInfo.localIdfa)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38 = this.hashCode;
        if (i38 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.screen_width) * 37) + this.screen_height) * 37) + this.density_dpi) * 37;
            String str = this.imei;
            int i39 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i46 = (hashCode + i3) * 37;
            String str2 = this.imsi;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i47 = (i46 + i16) * 37;
            String str3 = this.idfa;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i48 = (i47 + i17) * 37;
            String str4 = this.omg_id;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i49 = (i48 + i18) * 37;
            String str5 = this.device_id;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i56 = (i49 + i19) * 37;
            String str6 = this.device_model;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i57 = (((i56 + i26) * 37) + this.device_type) * 37;
            String str7 = this.guid;
            if (str7 != null) {
                i27 = str7.hashCode();
            } else {
                i27 = 0;
            }
            int i58 = (i57 + i27) * 37;
            UISizeType uISizeType = this.max_uiSize;
            if (uISizeType != null) {
                i28 = uISizeType.hashCode();
            } else {
                i28 = 0;
            }
            int i59 = (i58 + i28) * 37;
            UISizeType uISizeType2 = this.current_window_uiSize;
            if (uISizeType2 != null) {
                i29 = uISizeType2.hashCode();
            } else {
                i29 = 0;
            }
            int i65 = (i59 + i29) * 37;
            String str8 = this.manufacturer;
            if (str8 != null) {
                i36 = str8.hashCode();
            } else {
                i36 = 0;
            }
            int i66 = (i65 + i36) * 37;
            String str9 = this.qimei;
            if (str9 != null) {
                i37 = str9.hashCode();
            } else {
                i37 = 0;
            }
            int i67 = (i66 + i37) * 37;
            String str10 = this.localIdfa;
            if (str10 != null) {
                i39 = str10.hashCode();
            }
            int i68 = i67 + i39;
            this.hashCode = i68;
            return i68;
        }
        return i38;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", screen_width=");
        sb5.append(this.screen_width);
        sb5.append(", screen_height=");
        sb5.append(this.screen_height);
        sb5.append(", density_dpi=");
        sb5.append(this.density_dpi);
        if (this.imei != null) {
            sb5.append(", imei=");
            sb5.append(Internal.sanitize(this.imei));
        }
        if (this.imsi != null) {
            sb5.append(", imsi=");
            sb5.append(Internal.sanitize(this.imsi));
        }
        if (this.idfa != null) {
            sb5.append(", idfa=");
            sb5.append(Internal.sanitize(this.idfa));
        }
        if (this.omg_id != null) {
            sb5.append(", omg_id=");
            sb5.append(Internal.sanitize(this.omg_id));
        }
        if (this.device_id != null) {
            sb5.append(", device_id=");
            sb5.append(Internal.sanitize(this.device_id));
        }
        if (this.device_model != null) {
            sb5.append(", device_model=");
            sb5.append(Internal.sanitize(this.device_model));
        }
        sb5.append(", device_type=");
        sb5.append(this.device_type);
        if (this.guid != null) {
            sb5.append(", guid=");
            sb5.append(Internal.sanitize(this.guid));
        }
        if (this.max_uiSize != null) {
            sb5.append(", max_uiSize=");
            sb5.append(this.max_uiSize);
        }
        if (this.current_window_uiSize != null) {
            sb5.append(", current_window_uiSize=");
            sb5.append(this.current_window_uiSize);
        }
        if (this.manufacturer != null) {
            sb5.append(", manufacturer=");
            sb5.append(Internal.sanitize(this.manufacturer));
        }
        if (this.qimei != null) {
            sb5.append(", qimei=");
            sb5.append(Internal.sanitize(this.qimei));
        }
        if (this.localIdfa != null) {
            sb5.append(", localIdfa=");
            sb5.append(Internal.sanitize(this.localIdfa));
        }
        StringBuilder replace = sb5.replace(0, 2, "DeviceInfo{");
        replace.append('}');
        return replace.toString();
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437607a = this.screen_width;
        aVar.f437608b = this.screen_height;
        aVar.f437609c = this.density_dpi;
        aVar.f437610d = this.imei;
        aVar.f437611e = this.imsi;
        aVar.f437612f = this.idfa;
        aVar.f437613g = this.omg_id;
        aVar.f437614h = this.device_id;
        aVar.f437615i = this.device_model;
        aVar.f437616j = this.device_type;
        aVar.f437617k = this.guid;
        aVar.f437618l = this.max_uiSize;
        aVar.f437619m = this.current_window_uiSize;
        aVar.f437620n = this.manufacturer;
        aVar.f437621o = this.qimei;
        aVar.f437622p = this.localIdfa;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
