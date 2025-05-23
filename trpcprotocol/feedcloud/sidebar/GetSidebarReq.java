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
import java.util.Map;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class GetSidebarReq extends Message<GetSidebarReq, a> {
    public static final ProtoAdapter<GetSidebarReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, ByteString> ext;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<GetSidebarReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, ByteString> f437291a = Internal.newMutableMap();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSidebarReq build() {
            return new GetSidebarReq(this.f437291a, super.buildUnknownFields());
        }

        public a b(Map<String, ByteString> map) {
            Internal.checkElementsNotNull(map);
            this.f437291a = map;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<GetSidebarReq> {

        /* renamed from: a, reason: collision with root package name */
        private ProtoAdapter<Map<String, ByteString>> f437292a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) GetSidebarReq.class, "type.googleapis.com/trpc.feedcloud.sidebar.GetSidebarReq", Syntax.PROTO_3, (Object) null);
        }

        private ProtoAdapter<Map<String, ByteString>> d() {
            ProtoAdapter<Map<String, ByteString>> protoAdapter = this.f437292a;
            if (protoAdapter == null) {
                ProtoAdapter<Map<String, ByteString>> newMapAdapter = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
                this.f437292a = newMapAdapter;
                return newMapAdapter;
            }
            return protoAdapter;
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GetSidebarReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f437291a.putAll(d().decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, GetSidebarReq getSidebarReq) throws IOException {
            d().encodeWithTag(protoWriter, 1, getSidebarReq.ext);
            protoWriter.writeBytes(getSidebarReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(GetSidebarReq getSidebarReq) {
            return d().encodedSizeWithTag(1, getSidebarReq.ext) + 0 + getSidebarReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public GetSidebarReq redact(GetSidebarReq getSidebarReq) {
            a newBuilder = getSidebarReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public GetSidebarReq(Map<String, ByteString> map) {
        this(map, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GetSidebarReq)) {
            return false;
        }
        GetSidebarReq getSidebarReq = (GetSidebarReq) obj;
        if (unknownFields().equals(getSidebarReq.unknownFields()) && this.ext.equals(getSidebarReq.ext)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.ext.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.ext.isEmpty()) {
            sb5.append(", ext=");
            sb5.append(this.ext);
        }
        StringBuilder replace = sb5.replace(0, 2, "GetSidebarReq{");
        replace.append('}');
        return replace.toString();
    }

    public GetSidebarReq(Map<String, ByteString> map, ByteString byteString) {
        super(ADAPTER, byteString);
        this.ext = Internal.immutableCopyOf("ext", map);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437291a = Internal.copyOf(this.ext);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
