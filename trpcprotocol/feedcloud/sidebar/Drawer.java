package trpcprotocol.feedcloud.sidebar;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class Drawer extends Message<Drawer, a> {
    public static final ProtoAdapter<Drawer> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final boolean hidden;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String icon;

    /* renamed from: id, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final int f437281id;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.JumpInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final JumpInfo jumpInfo;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.Navbar#ADAPTER", label = WireField.Label.REPEATED, tag = 8)
    public final List<Navbar> navbar;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.RedInfo#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    public final RedInfo redInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String subTitle;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String title;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.DrawerType#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final DrawerType type;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<Drawer, a> {

        /* renamed from: f, reason: collision with root package name */
        public RedInfo f437287f;

        /* renamed from: g, reason: collision with root package name */
        public JumpInfo f437288g;

        /* renamed from: a, reason: collision with root package name */
        public int f437282a = 0;

        /* renamed from: b, reason: collision with root package name */
        public DrawerType f437283b = DrawerType.DRAWER_TYPE_COMMON;

        /* renamed from: c, reason: collision with root package name */
        public String f437284c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f437285d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437286e = "";

        /* renamed from: h, reason: collision with root package name */
        public List<Navbar> f437289h = Internal.newMutableList();

        /* renamed from: i, reason: collision with root package name */
        public boolean f437290i = false;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawer build() {
            return new Drawer(this.f437282a, this.f437283b, this.f437284c, this.f437285d, this.f437286e, this.f437287f, this.f437288g, this.f437289h, this.f437290i, super.buildUnknownFields());
        }

        public a b(boolean z16) {
            this.f437290i = z16;
            return this;
        }

        public a c(String str) {
            this.f437286e = str;
            return this;
        }

        public a d(int i3) {
            this.f437282a = i3;
            return this;
        }

        public a e(JumpInfo jumpInfo) {
            this.f437288g = jumpInfo;
            return this;
        }

        public a f(RedInfo redInfo) {
            this.f437287f = redInfo;
            return this;
        }

        public a g(String str) {
            this.f437285d = str;
            return this;
        }

        public a h(String str) {
            this.f437284c = str;
            return this;
        }

        public a i(DrawerType drawerType) {
            this.f437283b = drawerType;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<Drawer> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) Drawer.class, "type.googleapis.com/trpc.feedcloud.sidebar.Drawer", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Drawer decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.d(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 2:
                            try {
                                aVar.i(DrawerType.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                aVar.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                break;
                            }
                        case 3:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.g(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.f(RedInfo.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            aVar.e(JumpInfo.ADAPTER.decode(protoReader));
                            break;
                        case 8:
                            aVar.f437289h.add(Navbar.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            aVar.b(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
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
        public void encode(ProtoWriter protoWriter, Drawer drawer) throws IOException {
            if (!Objects.equals(Integer.valueOf(drawer.f437281id), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, Integer.valueOf(drawer.f437281id));
            }
            if (!Objects.equals(drawer.type, DrawerType.DRAWER_TYPE_COMMON)) {
                DrawerType.ADAPTER.encodeWithTag(protoWriter, 2, drawer.type);
            }
            if (!Objects.equals(drawer.title, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, drawer.title);
            }
            if (!Objects.equals(drawer.subTitle, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, drawer.subTitle);
            }
            if (!Objects.equals(drawer.icon, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, drawer.icon);
            }
            if (!Objects.equals(drawer.redInfo, null)) {
                RedInfo.ADAPTER.encodeWithTag(protoWriter, 6, drawer.redInfo);
            }
            if (!Objects.equals(drawer.jumpInfo, null)) {
                JumpInfo.ADAPTER.encodeWithTag(protoWriter, 7, drawer.jumpInfo);
            }
            Navbar.ADAPTER.asRepeated().encodeWithTag(protoWriter, 8, drawer.navbar);
            if (!Objects.equals(Boolean.valueOf(drawer.hidden), Boolean.FALSE)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 9, Boolean.valueOf(drawer.hidden));
            }
            protoWriter.writeBytes(drawer.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(Drawer drawer) {
            int i3 = 0;
            if (!Objects.equals(Integer.valueOf(drawer.f437281id), 0)) {
                i3 = 0 + ProtoAdapter.INT32.encodedSizeWithTag(1, Integer.valueOf(drawer.f437281id));
            }
            if (!Objects.equals(drawer.type, DrawerType.DRAWER_TYPE_COMMON)) {
                i3 += DrawerType.ADAPTER.encodedSizeWithTag(2, drawer.type);
            }
            if (!Objects.equals(drawer.title, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, drawer.title);
            }
            if (!Objects.equals(drawer.subTitle, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, drawer.subTitle);
            }
            if (!Objects.equals(drawer.icon, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, drawer.icon);
            }
            if (!Objects.equals(drawer.redInfo, null)) {
                i3 += RedInfo.ADAPTER.encodedSizeWithTag(6, drawer.redInfo);
            }
            if (!Objects.equals(drawer.jumpInfo, null)) {
                i3 += JumpInfo.ADAPTER.encodedSizeWithTag(7, drawer.jumpInfo);
            }
            int encodedSizeWithTag = i3 + Navbar.ADAPTER.asRepeated().encodedSizeWithTag(8, drawer.navbar);
            if (!Objects.equals(Boolean.valueOf(drawer.hidden), Boolean.FALSE)) {
                encodedSizeWithTag += ProtoAdapter.BOOL.encodedSizeWithTag(9, Boolean.valueOf(drawer.hidden));
            }
            return encodedSizeWithTag + drawer.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Drawer redact(Drawer drawer) {
            a newBuilder = drawer.newBuilder();
            RedInfo redInfo = newBuilder.f437287f;
            if (redInfo != null) {
                newBuilder.f437287f = RedInfo.ADAPTER.redact(redInfo);
            }
            JumpInfo jumpInfo = newBuilder.f437288g;
            if (jumpInfo != null) {
                newBuilder.f437288g = JumpInfo.ADAPTER.redact(jumpInfo);
            }
            Internal.redactElements(newBuilder.f437289h, Navbar.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public Drawer(int i3, DrawerType drawerType, String str, String str2, String str3, RedInfo redInfo, JumpInfo jumpInfo, List<Navbar> list, boolean z16) {
        this(i3, drawerType, str, str2, str3, redInfo, jumpInfo, list, z16, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Drawer)) {
            return false;
        }
        Drawer drawer = (Drawer) obj;
        if (unknownFields().equals(drawer.unknownFields()) && Internal.equals(Integer.valueOf(this.f437281id), Integer.valueOf(drawer.f437281id)) && Internal.equals(this.type, drawer.type) && Internal.equals(this.title, drawer.title) && Internal.equals(this.subTitle, drawer.subTitle) && Internal.equals(this.icon, drawer.icon) && Internal.equals(this.redInfo, drawer.redInfo) && Internal.equals(this.jumpInfo, drawer.jumpInfo) && this.navbar.equals(drawer.navbar) && Internal.equals(Boolean.valueOf(this.hidden), Boolean.valueOf(drawer.hidden))) {
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
            int hashCode = ((unknownFields().hashCode() * 37) + this.f437281id) * 37;
            DrawerType drawerType = this.type;
            int i27 = 0;
            if (drawerType != null) {
                i3 = drawerType.hashCode();
            } else {
                i3 = 0;
            }
            int i28 = (hashCode + i3) * 37;
            String str = this.title;
            if (str != null) {
                i16 = str.hashCode();
            } else {
                i16 = 0;
            }
            int i29 = (i28 + i16) * 37;
            String str2 = this.subTitle;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i36 = (i29 + i17) * 37;
            String str3 = this.icon;
            if (str3 != null) {
                i18 = str3.hashCode();
            } else {
                i18 = 0;
            }
            int i37 = (i36 + i18) * 37;
            RedInfo redInfo = this.redInfo;
            if (redInfo != null) {
                i19 = redInfo.hashCode();
            } else {
                i19 = 0;
            }
            int i38 = (i37 + i19) * 37;
            JumpInfo jumpInfo = this.jumpInfo;
            if (jumpInfo != null) {
                i27 = jumpInfo.hashCode();
            }
            int hashCode2 = ((((i38 + i27) * 37) + this.navbar.hashCode()) * 37) + com.tencent.aio.widget.textView.param.a.a(this.hidden);
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i26;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", id=");
        sb5.append(this.f437281id);
        if (this.type != null) {
            sb5.append(", type=");
            sb5.append(this.type);
        }
        if (this.title != null) {
            sb5.append(", title=");
            sb5.append(Internal.sanitize(this.title));
        }
        if (this.subTitle != null) {
            sb5.append(", subTitle=");
            sb5.append(Internal.sanitize(this.subTitle));
        }
        if (this.icon != null) {
            sb5.append(", icon=");
            sb5.append(Internal.sanitize(this.icon));
        }
        if (this.redInfo != null) {
            sb5.append(", redInfo=");
            sb5.append(this.redInfo);
        }
        if (this.jumpInfo != null) {
            sb5.append(", jumpInfo=");
            sb5.append(this.jumpInfo);
        }
        if (!this.navbar.isEmpty()) {
            sb5.append(", navbar=");
            sb5.append(this.navbar);
        }
        sb5.append(", hidden=");
        sb5.append(this.hidden);
        StringBuilder replace = sb5.replace(0, 2, "Drawer{");
        replace.append('}');
        return replace.toString();
    }

    public Drawer(int i3, DrawerType drawerType, String str, String str2, String str3, RedInfo redInfo, JumpInfo jumpInfo, List<Navbar> list, boolean z16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.f437281id = i3;
        if (drawerType != null) {
            this.type = drawerType;
            if (str != null) {
                this.title = str;
                if (str2 != null) {
                    this.subTitle = str2;
                    if (str3 != null) {
                        this.icon = str3;
                        this.redInfo = redInfo;
                        this.jumpInfo = jumpInfo;
                        this.navbar = Internal.immutableCopyOf("navbar", list);
                        this.hidden = z16;
                        return;
                    }
                    throw new IllegalArgumentException("icon == null");
                }
                throw new IllegalArgumentException("subTitle == null");
            }
            throw new IllegalArgumentException("title == null");
        }
        throw new IllegalArgumentException("type == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437282a = this.f437281id;
        aVar.f437283b = this.type;
        aVar.f437284c = this.title;
        aVar.f437285d = this.subTitle;
        aVar.f437286e = this.icon;
        aVar.f437287f = this.redInfo;
        aVar.f437288g = this.jumpInfo;
        aVar.f437289h = Internal.copyOf(this.navbar);
        aVar.f437290i = this.hidden;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
