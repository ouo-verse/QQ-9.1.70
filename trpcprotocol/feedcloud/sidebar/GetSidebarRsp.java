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
import java.util.Map;
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GetSidebarRsp extends Message<GetSidebarRsp, a> {
    public static final ProtoAdapter<GetSidebarRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.Bottom#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<Bottom> bottoms;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.Drawer#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Drawer> drawers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, ByteString> ext;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.Header#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final Header header;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<GetSidebarRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<Drawer> f437293a = Internal.newMutableList();

        /* renamed from: b, reason: collision with root package name */
        public List<Bottom> f437294b = Internal.newMutableList();

        /* renamed from: c, reason: collision with root package name */
        public Map<String, ByteString> f437295c = Internal.newMutableMap();

        /* renamed from: d, reason: collision with root package name */
        public Header f437296d;

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSidebarRsp build() {
            return new GetSidebarRsp(this.f437293a, this.f437294b, this.f437295c, this.f437296d, super.buildUnknownFields());
        }

        public a b(Header header) {
            this.f437296d = header;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<GetSidebarRsp> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, ByteString>> f437297a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetSidebarRsp.class, "type.googleapis.com/trpc.feedcloud.sidebar.GetSidebarRsp", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, ByteString>> d() {
            ProtoAdapter<Map<String, ByteString>> protoAdapter = this.f437297a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<String, ByteString>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
                this.f437297a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSidebarRsp decode(ProtoReader protoReader) throws IOException {
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
                                    aVar.b(Header.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.f437295c.putAll(d().decode(protoReader));
                            }
                        } else {
                            aVar.f437294b.add(Bottom.ADAPTER.decode(protoReader));
                        }
                    } else {
                        aVar.f437293a.add(Drawer.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetSidebarRsp getSidebarRsp) throws IOException {
            Drawer.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, getSidebarRsp.drawers);
            Bottom.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, getSidebarRsp.bottoms);
            d().encodeWithTag(protoWriter, 3, getSidebarRsp.ext);
            if (!Objects.equals(getSidebarRsp.header, null)) {
                Header.ADAPTER.encodeWithTag(protoWriter, 4, getSidebarRsp.header);
            }
            protoWriter.writeBytes(getSidebarRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetSidebarRsp getSidebarRsp) {
            int encodedSizeWithTag = Drawer.ADAPTER.asRepeated().encodedSizeWithTag(1, getSidebarRsp.drawers) + 0 + Bottom.ADAPTER.asRepeated().encodedSizeWithTag(2, getSidebarRsp.bottoms) + d().encodedSizeWithTag(3, getSidebarRsp.ext);
            if (!Objects.equals(getSidebarRsp.header, null)) {
                encodedSizeWithTag += Header.ADAPTER.encodedSizeWithTag(4, getSidebarRsp.header);
            }
            return encodedSizeWithTag + getSidebarRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public GetSidebarRsp redact(GetSidebarRsp getSidebarRsp) {
            a newBuilder = getSidebarRsp.newBuilder();
            Internal.redactElements(newBuilder.f437293a, Drawer.ADAPTER);
            Internal.redactElements(newBuilder.f437294b, Bottom.ADAPTER);
            Header header = newBuilder.f437296d;
            if (header != null) {
                newBuilder.f437296d = Header.ADAPTER.redact(header);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetSidebarRsp(List<Drawer> list, List<Bottom> list2, Map<String, ByteString> map, Header header) {
        this(list, list2, map, header, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSidebarRsp)) {
            return false;
        }
        GetSidebarRsp getSidebarRsp = (GetSidebarRsp) obj;
        if (unknownFields().equals(getSidebarRsp.unknownFields()) && this.drawers.equals(getSidebarRsp.drawers) && this.bottoms.equals(getSidebarRsp.bottoms) && this.ext.equals(getSidebarRsp.ext) && Internal.equals(this.header, getSidebarRsp.header)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((((unknownFields().hashCode() * 37) + this.drawers.hashCode()) * 37) + this.bottoms.hashCode()) * 37) + this.ext.hashCode()) * 37;
            Header header = this.header;
            if (header != null) {
                i3 = header.hashCode();
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
        if (!this.drawers.isEmpty()) {
            sb5.append(", drawers=");
            sb5.append(this.drawers);
        }
        if (!this.bottoms.isEmpty()) {
            sb5.append(", bottoms=");
            sb5.append(this.bottoms);
        }
        if (!this.ext.isEmpty()) {
            sb5.append(", ext=");
            sb5.append(this.ext);
        }
        if (this.header != null) {
            sb5.append(", header=");
            sb5.append(this.header);
        }
        StringBuilder replace = sb5.replace(0, 2, "GetSidebarRsp{");
        replace.append('}');
        return replace.toString();
    }

    public GetSidebarRsp(List<Drawer> list, List<Bottom> list2, Map<String, ByteString> map, Header header, ByteString byteString) {
        super(ADAPTER, byteString);
        this.drawers = Internal.immutableCopyOf("drawers", list);
        this.bottoms = Internal.immutableCopyOf("bottoms", list2);
        this.ext = Internal.immutableCopyOf("ext", map);
        this.header = header;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437293a = Internal.copyOf(this.drawers);
        aVar.f437294b = Internal.copyOf(this.bottoms);
        aVar.f437295c = Internal.copyOf(this.ext);
        aVar.f437296d = this.header;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
