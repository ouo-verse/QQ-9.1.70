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
public final class MedalWallInfo extends Message<MedalWallInfo, a> {
    public static final ProtoAdapter<MedalWallInfo> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String jumpURL;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.MedalInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<MedalInfo> medalInfos;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final boolean needRedPoint;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final boolean needShowEntrance;

    @WireField(adapter = "trpcprotocol.feedcloud.sidebar.MedalInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<MedalInfo> newMedalInfos;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<MedalWallInfo, a> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f437307a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f437308b = false;

        /* renamed from: c, reason: collision with root package name */
        public String f437309c = "";

        /* renamed from: d, reason: collision with root package name */
        public List<MedalInfo> f437310d = Internal.newMutableList();

        /* renamed from: e, reason: collision with root package name */
        public List<MedalInfo> f437311e = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MedalWallInfo build() {
            return new MedalWallInfo(this.f437307a, this.f437308b, this.f437309c, this.f437310d, this.f437311e, super.buildUnknownFields());
        }

        public a b(String str) {
            this.f437309c = str;
            return this;
        }

        public a c(boolean z16) {
            this.f437307a = z16;
            return this;
        }

        public a d(boolean z16) {
            this.f437308b = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<MedalWallInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MedalWallInfo.class, "type.googleapis.com/trpc.feedcloud.sidebar.MedalWallInfo", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MedalWallInfo decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        if (nextTag != 2) {
                            if (nextTag != 3) {
                                if (nextTag != 4) {
                                    if (nextTag != 5) {
                                        protoReader.readUnknownField(nextTag);
                                    } else {
                                        aVar.f437311e.add(MedalInfo.ADAPTER.decode(protoReader));
                                    }
                                } else {
                                    aVar.f437310d.add(MedalInfo.ADAPTER.decode(protoReader));
                                }
                            } else {
                                aVar.b(ProtoAdapter.STRING.decode(protoReader));
                            }
                        } else {
                            aVar.d(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                        }
                    } else {
                        aVar.c(ProtoAdapter.BOOL.decode(protoReader).booleanValue());
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, MedalWallInfo medalWallInfo) throws IOException {
            Boolean valueOf = Boolean.valueOf(medalWallInfo.needRedPoint);
            Boolean bool = Boolean.FALSE;
            if (!Objects.equals(valueOf, bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, Boolean.valueOf(medalWallInfo.needRedPoint));
            }
            if (!Objects.equals(Boolean.valueOf(medalWallInfo.needShowEntrance), bool)) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, Boolean.valueOf(medalWallInfo.needShowEntrance));
            }
            if (!Objects.equals(medalWallInfo.jumpURL, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, medalWallInfo.jumpURL);
            }
            ProtoAdapter<MedalInfo> protoAdapter = MedalInfo.ADAPTER;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 4, medalWallInfo.medalInfos);
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 5, medalWallInfo.newMedalInfos);
            protoWriter.writeBytes(medalWallInfo.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(MedalWallInfo medalWallInfo) {
            Boolean valueOf = Boolean.valueOf(medalWallInfo.needRedPoint);
            Boolean bool = Boolean.FALSE;
            int i3 = 0;
            if (!Objects.equals(valueOf, bool)) {
                i3 = 0 + ProtoAdapter.BOOL.encodedSizeWithTag(1, Boolean.valueOf(medalWallInfo.needRedPoint));
            }
            if (!Objects.equals(Boolean.valueOf(medalWallInfo.needShowEntrance), bool)) {
                i3 += ProtoAdapter.BOOL.encodedSizeWithTag(2, Boolean.valueOf(medalWallInfo.needShowEntrance));
            }
            if (!Objects.equals(medalWallInfo.jumpURL, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, medalWallInfo.jumpURL);
            }
            ProtoAdapter<MedalInfo> protoAdapter = MedalInfo.ADAPTER;
            return i3 + protoAdapter.asRepeated().encodedSizeWithTag(4, medalWallInfo.medalInfos) + protoAdapter.asRepeated().encodedSizeWithTag(5, medalWallInfo.newMedalInfos) + medalWallInfo.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MedalWallInfo redact(MedalWallInfo medalWallInfo) {
            a newBuilder = medalWallInfo.newBuilder();
            List<MedalInfo> list = newBuilder.f437310d;
            ProtoAdapter<MedalInfo> protoAdapter = MedalInfo.ADAPTER;
            Internal.redactElements(list, protoAdapter);
            Internal.redactElements(newBuilder.f437311e, protoAdapter);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MedalWallInfo(boolean z16, boolean z17, String str, List<MedalInfo> list, List<MedalInfo> list2) {
        this(z16, z17, str, list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MedalWallInfo)) {
            return false;
        }
        MedalWallInfo medalWallInfo = (MedalWallInfo) obj;
        if (unknownFields().equals(medalWallInfo.unknownFields()) && Internal.equals(Boolean.valueOf(this.needRedPoint), Boolean.valueOf(medalWallInfo.needRedPoint)) && Internal.equals(Boolean.valueOf(this.needShowEntrance), Boolean.valueOf(medalWallInfo.needShowEntrance)) && Internal.equals(this.jumpURL, medalWallInfo.jumpURL) && this.medalInfos.equals(medalWallInfo.medalInfos) && this.newMedalInfos.equals(medalWallInfo.newMedalInfos)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + com.tencent.aio.widget.textView.param.a.a(this.needRedPoint)) * 37) + com.tencent.aio.widget.textView.param.a.a(this.needShowEntrance)) * 37;
            String str = this.jumpURL;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int hashCode2 = ((((hashCode + i3) * 37) + this.medalInfos.hashCode()) * 37) + this.newMedalInfos.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i16;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(", needRedPoint=");
        sb5.append(this.needRedPoint);
        sb5.append(", needShowEntrance=");
        sb5.append(this.needShowEntrance);
        if (this.jumpURL != null) {
            sb5.append(", jumpURL=");
            sb5.append(Internal.sanitize(this.jumpURL));
        }
        if (!this.medalInfos.isEmpty()) {
            sb5.append(", medalInfos=");
            sb5.append(this.medalInfos);
        }
        if (!this.newMedalInfos.isEmpty()) {
            sb5.append(", newMedalInfos=");
            sb5.append(this.newMedalInfos);
        }
        StringBuilder replace = sb5.replace(0, 2, "MedalWallInfo{");
        replace.append('}');
        return replace.toString();
    }

    public MedalWallInfo(boolean z16, boolean z17, String str, List<MedalInfo> list, List<MedalInfo> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.needRedPoint = z16;
        this.needShowEntrance = z17;
        if (str != null) {
            this.jumpURL = str;
            this.medalInfos = Internal.immutableCopyOf("medalInfos", list);
            this.newMedalInfos = Internal.immutableCopyOf("newMedalInfos", list2);
            return;
        }
        throw new IllegalArgumentException("jumpURL == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437307a = this.needRedPoint;
        aVar.f437308b = this.needShowEntrance;
        aVar.f437309c = this.jumpURL;
        aVar.f437310d = Internal.copyOf(this.medalInfos);
        aVar.f437311e = Internal.copyOf(this.newMedalInfos);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
