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
public final class NetworkInfo extends Message<NetworkInfo, a> {
    public static final ProtoAdapter<NetworkInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "bssId", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String bss_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "ethMac", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String eth_mac;

    /* renamed from: ip, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String f437694ip;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String ipv4;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final String ipv6;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final int mcc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "mobileIsp", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int mobile_isp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", jsonName = "networkMode", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int network_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final int port;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "wifiMac", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final String wifi_mac;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<NetworkInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public int f437695a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f437696b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f437697c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f437698d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437699e = "";

        /* renamed from: f, reason: collision with root package name */
        public String f437700f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f437701g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f437702h = "";

        /* renamed from: i, reason: collision with root package name */
        public int f437703i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f437704j = 0;

        public a a(String str) {
            this.f437698d = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NetworkInfo build() {
            return new NetworkInfo(this.f437695a, this.f437696b, this.f437697c, this.f437698d, this.f437699e, this.f437700f, this.f437701g, this.f437702h, this.f437703i, this.f437704j, super.buildUnknownFields());
        }

        public a c(String str) {
            this.f437699e = str;
            return this;
        }

        public a d(String str) {
            this.f437697c = str;
            return this;
        }

        public a e(String str) {
            this.f437701g = str;
            return this;
        }

        public a f(String str) {
            this.f437702h = str;
            return this;
        }

        public a g(int i3) {
            this.f437703i = i3;
            return this;
        }

        public a h(int i3) {
            this.f437696b = i3;
            return this;
        }

        public a i(int i3) {
            this.f437695a = i3;
            return this;
        }

        public a j(int i3) {
            this.f437704j = i3;
            return this;
        }

        public a k(String str) {
            this.f437700f = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<NetworkInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) NetworkInfo.class, "type.googleapis.com/tvideo.NetworkInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NetworkInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.i(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            aVar.h(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.k(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.e(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            aVar.g(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 10:
                            aVar.j(ProtoAdapter.INT32.decode(protoReader).intValue());
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
        public void encode(ProtoWriter protoWriter, NetworkInfo networkInfo) throws IOException {
            if (!Objects.equals(Integer.valueOf(networkInfo.network_mode), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(networkInfo.network_mode));
            }
            if (!Objects.equals(Integer.valueOf(networkInfo.mobile_isp), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(networkInfo.mobile_isp));
            }
            if (!Objects.equals(networkInfo.f437694ip, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, networkInfo.f437694ip);
            }
            if (!Objects.equals(networkInfo.bss_id, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, networkInfo.bss_id);
            }
            if (!Objects.equals(networkInfo.eth_mac, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, networkInfo.eth_mac);
            }
            if (!Objects.equals(networkInfo.wifi_mac, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, networkInfo.wifi_mac);
            }
            if (!Objects.equals(networkInfo.ipv4, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, networkInfo.ipv4);
            }
            if (!Objects.equals(networkInfo.ipv6, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, networkInfo.ipv6);
            }
            if (!Objects.equals(Integer.valueOf(networkInfo.mcc), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 9, Integer.valueOf(networkInfo.mcc));
            }
            if (!Objects.equals(Integer.valueOf(networkInfo.port), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 10, Integer.valueOf(networkInfo.port));
            }
            protoWriter.writeBytes(networkInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(NetworkInfo networkInfo) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(networkInfo.network_mode), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(networkInfo.network_mode));
            }
            if (!Objects.equals(Integer.valueOf(networkInfo.mobile_isp), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(networkInfo.mobile_isp));
            }
            if (!Objects.equals(networkInfo.f437694ip, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, networkInfo.f437694ip);
            }
            if (!Objects.equals(networkInfo.bss_id, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, networkInfo.bss_id);
            }
            if (!Objects.equals(networkInfo.eth_mac, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, networkInfo.eth_mac);
            }
            if (!Objects.equals(networkInfo.wifi_mac, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(6, networkInfo.wifi_mac);
            }
            if (!Objects.equals(networkInfo.ipv4, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(7, networkInfo.ipv4);
            }
            if (!Objects.equals(networkInfo.ipv6, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(8, networkInfo.ipv6);
            }
            if (!Objects.equals(Integer.valueOf(networkInfo.mcc), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(9, Integer.valueOf(networkInfo.mcc));
            }
            if (!Objects.equals(Integer.valueOf(networkInfo.port), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(10, Integer.valueOf(networkInfo.port));
            }
            return i3 + networkInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public NetworkInfo redact(NetworkInfo networkInfo) {
            a newBuilder = networkInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public NetworkInfo(int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, int i17, int i18) {
        this(i3, i16, str, str2, str3, str4, str5, str6, i17, i18, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkInfo)) {
            return false;
        }
        NetworkInfo networkInfo = (NetworkInfo) obj;
        if (unknownFields().equals(networkInfo.unknownFields()) && Internal.equals(Integer.valueOf(this.network_mode), Integer.valueOf(networkInfo.network_mode)) && Internal.equals(Integer.valueOf(this.mobile_isp), Integer.valueOf(networkInfo.mobile_isp)) && Internal.equals(this.f437694ip, networkInfo.f437694ip) && Internal.equals(this.bss_id, networkInfo.bss_id) && Internal.equals(this.eth_mac, networkInfo.eth_mac) && Internal.equals(this.wifi_mac, networkInfo.wifi_mac) && Internal.equals(this.ipv4, networkInfo.ipv4) && Internal.equals(this.ipv6, networkInfo.ipv6) && Internal.equals(Integer.valueOf(this.mcc), Integer.valueOf(networkInfo.mcc)) && Internal.equals(Integer.valueOf(this.port), Integer.valueOf(networkInfo.port))) {
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
        int i26 = this.hashCode;
        if (i26 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.network_mode) * 37) + this.mobile_isp) * 37;
            String str = this.f437694ip;
            int i27 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str2 = this.bss_id;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str3 = this.eth_mac;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str4 = this.wifi_mac;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            String str5 = this.ipv4;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            String str6 = this.ipv6;
            if (str6 != null) {
                i27 = str6.hashCode();
            }
            int i39 = ((((i38 + i27) * 37) + this.mcc) * 37) + this.port;
            this.hashCode = i39;
            return i39;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", network_mode=");
        sb5.append(this.network_mode);
        sb5.append(", mobile_isp=");
        sb5.append(this.mobile_isp);
        if (this.f437694ip != null) {
            sb5.append(", ip=");
            sb5.append(Internal.sanitize(this.f437694ip));
        }
        if (this.bss_id != null) {
            sb5.append(", bss_id=");
            sb5.append(Internal.sanitize(this.bss_id));
        }
        if (this.eth_mac != null) {
            sb5.append(", eth_mac=");
            sb5.append(Internal.sanitize(this.eth_mac));
        }
        if (this.wifi_mac != null) {
            sb5.append(", wifi_mac=");
            sb5.append(Internal.sanitize(this.wifi_mac));
        }
        if (this.ipv4 != null) {
            sb5.append(", ipv4=");
            sb5.append(Internal.sanitize(this.ipv4));
        }
        if (this.ipv6 != null) {
            sb5.append(", ipv6=");
            sb5.append(Internal.sanitize(this.ipv6));
        }
        sb5.append(", mcc=");
        sb5.append(this.mcc);
        sb5.append(", port=");
        sb5.append(this.port);
        StringBuilder replace = sb5.replace(0, 2, "NetworkInfo{");
        replace.append('}');
        return replace.toString();
    }

    public NetworkInfo(int i3, int i16, String str, String str2, String str3, String str4, String str5, String str6, int i17, int i18, ByteString byteString) {
        super(ADAPTER, byteString);
        this.network_mode = i3;
        this.mobile_isp = i16;
        if (str != null) {
            this.f437694ip = str;
            if (str2 != null) {
                this.bss_id = str2;
                if (str3 != null) {
                    this.eth_mac = str3;
                    if (str4 != null) {
                        this.wifi_mac = str4;
                        if (str5 != null) {
                            this.ipv4 = str5;
                            if (str6 != null) {
                                this.ipv6 = str6;
                                this.mcc = i17;
                                this.port = i18;
                                return;
                            }
                            throw new IllegalArgumentException("ipv6 == null");
                        }
                        throw new IllegalArgumentException("ipv4 == null");
                    }
                    throw new IllegalArgumentException("wifi_mac == null");
                }
                throw new IllegalArgumentException("eth_mac == null");
            }
            throw new IllegalArgumentException("bss_id == null");
        }
        throw new IllegalArgumentException("ip == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437695a = this.network_mode;
        aVar.f437696b = this.mobile_isp;
        aVar.f437697c = this.f437694ip;
        aVar.f437698d = this.bss_id;
        aVar.f437699e = this.eth_mac;
        aVar.f437700f = this.wifi_mac;
        aVar.f437701g = this.ipv4;
        aVar.f437702h = this.ipv6;
        aVar.f437703i = this.mcc;
        aVar.f437704j = this.port;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
