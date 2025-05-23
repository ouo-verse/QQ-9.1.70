package trpc.feedcloud.tip_off;

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
/* loaded from: classes29.dex */
public final class SubmitTipOffReq extends Message<SubmitTipOffReq, a> {
    public static final ProtoAdapter<SubmitTipOffReq> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    public final String CommentID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    public final int DataType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    public final String Desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 6)
    public final List<String> Evidence;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String FeedID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    public final long HandleRecID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    public final String MainType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    public final int Opt;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    public final String OriginLink;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    public final String ReplyID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    public final String SubType;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class a extends Message.Builder<SubmitTipOffReq, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437222a = "";

        /* renamed from: b, reason: collision with root package name */
        public int f437223b = 0;

        /* renamed from: c, reason: collision with root package name */
        public String f437224c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f437225d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f437226e = "";

        /* renamed from: f, reason: collision with root package name */
        public List<String> f437227f = Internal.newMutableList();

        /* renamed from: g, reason: collision with root package name */
        public String f437228g = "";

        /* renamed from: h, reason: collision with root package name */
        public long f437229h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f437230i = 0;

        /* renamed from: j, reason: collision with root package name */
        public String f437231j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f437232k = "";

        public a a(String str) {
            this.f437231j = str;
            return this;
        }

        public a b(int i3) {
            this.f437230i = i3;
            return this;
        }

        public a c(String str) {
            this.f437226e = str;
            return this;
        }

        public a d(String str) {
            this.f437222a = str;
            return this;
        }

        public a e(long j3) {
            this.f437229h = j3;
            return this;
        }

        public a f(String str) {
            this.f437224c = str;
            return this;
        }

        public a g(int i3) {
            this.f437223b = i3;
            return this;
        }

        public a h(String str) {
            this.f437228g = str;
            return this;
        }

        public a i(String str) {
            this.f437232k = str;
            return this;
        }

        public a j(String str) {
            this.f437225d = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public SubmitTipOffReq build() {
            return new SubmitTipOffReq(this.f437222a, this.f437223b, this.f437224c, this.f437225d, this.f437226e, this.f437227f, this.f437228g, this.f437229h, this.f437230i, this.f437231j, this.f437232k, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class b extends ProtoAdapter<SubmitTipOffReq> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SubmitTipOffReq.class, "type.googleapis.com/trpc.feedcloud.tip_off.SubmitTipOffReq", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubmitTipOffReq decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            aVar.d(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            aVar.g(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 3:
                            aVar.f(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            aVar.j(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            aVar.c(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            aVar.f437227f.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            aVar.h(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 8:
                            aVar.e(ProtoAdapter.UINT64.decode(protoReader).longValue());
                            break;
                        case 9:
                            aVar.b(ProtoAdapter.INT32.decode(protoReader).intValue());
                            break;
                        case 10:
                            aVar.a(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            aVar.i(ProtoAdapter.STRING.decode(protoReader));
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
        public void encode(ProtoWriter protoWriter, SubmitTipOffReq submitTipOffReq) throws IOException {
            if (!Objects.equals(submitTipOffReq.FeedID, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, submitTipOffReq.FeedID);
            }
            if (!Objects.equals(Integer.valueOf(submitTipOffReq.Opt), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(submitTipOffReq.Opt));
            }
            if (!Objects.equals(submitTipOffReq.MainType, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, submitTipOffReq.MainType);
            }
            if (!Objects.equals(submitTipOffReq.SubType, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, submitTipOffReq.SubType);
            }
            if (!Objects.equals(submitTipOffReq.Desc, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, submitTipOffReq.Desc);
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.asRepeated().encodeWithTag(protoWriter, 6, submitTipOffReq.Evidence);
            if (!Objects.equals(submitTipOffReq.OriginLink, "")) {
                protoAdapter.encodeWithTag(protoWriter, 7, submitTipOffReq.OriginLink);
            }
            if (!Objects.equals(Long.valueOf(submitTipOffReq.HandleRecID), 0L)) {
                ProtoAdapter.UINT64.encodeWithTag(protoWriter, 8, Long.valueOf(submitTipOffReq.HandleRecID));
            }
            if (!Objects.equals(Integer.valueOf(submitTipOffReq.DataType), 0)) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 9, Integer.valueOf(submitTipOffReq.DataType));
            }
            if (!Objects.equals(submitTipOffReq.CommentID, "")) {
                protoAdapter.encodeWithTag(protoWriter, 10, submitTipOffReq.CommentID);
            }
            if (!Objects.equals(submitTipOffReq.ReplyID, "")) {
                protoAdapter.encodeWithTag(protoWriter, 11, submitTipOffReq.ReplyID);
            }
            protoWriter.writeBytes(submitTipOffReq.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SubmitTipOffReq submitTipOffReq) {
            int i3 = 0;
            if (!Objects.equals(submitTipOffReq.FeedID, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, submitTipOffReq.FeedID);
            }
            if (!Objects.equals(Integer.valueOf(submitTipOffReq.Opt), 0)) {
                i3 += ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(submitTipOffReq.Opt));
            }
            if (!Objects.equals(submitTipOffReq.MainType, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(3, submitTipOffReq.MainType);
            }
            if (!Objects.equals(submitTipOffReq.SubType, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(4, submitTipOffReq.SubType);
            }
            if (!Objects.equals(submitTipOffReq.Desc, "")) {
                i3 += ProtoAdapter.STRING.encodedSizeWithTag(5, submitTipOffReq.Desc);
            }
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = i3 + protoAdapter.asRepeated().encodedSizeWithTag(6, submitTipOffReq.Evidence);
            if (!Objects.equals(submitTipOffReq.OriginLink, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(7, submitTipOffReq.OriginLink);
            }
            if (!Objects.equals(Long.valueOf(submitTipOffReq.HandleRecID), 0L)) {
                encodedSizeWithTag += ProtoAdapter.UINT64.encodedSizeWithTag(8, Long.valueOf(submitTipOffReq.HandleRecID));
            }
            if (!Objects.equals(Integer.valueOf(submitTipOffReq.DataType), 0)) {
                encodedSizeWithTag += ProtoAdapter.INT32.encodedSizeWithTag(9, Integer.valueOf(submitTipOffReq.DataType));
            }
            if (!Objects.equals(submitTipOffReq.CommentID, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(10, submitTipOffReq.CommentID);
            }
            if (!Objects.equals(submitTipOffReq.ReplyID, "")) {
                encodedSizeWithTag += protoAdapter.encodedSizeWithTag(11, submitTipOffReq.ReplyID);
            }
            return encodedSizeWithTag + submitTipOffReq.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SubmitTipOffReq redact(SubmitTipOffReq submitTipOffReq) {
            a newBuilder = submitTipOffReq.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SubmitTipOffReq(String str, int i3, String str2, String str3, String str4, List<String> list, String str5, long j3, int i16, String str6, String str7) {
        this(str, i3, str2, str3, str4, list, str5, j3, i16, str6, str7, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitTipOffReq)) {
            return false;
        }
        SubmitTipOffReq submitTipOffReq = (SubmitTipOffReq) obj;
        if (unknownFields().equals(submitTipOffReq.unknownFields()) && Internal.equals(this.FeedID, submitTipOffReq.FeedID) && Internal.equals(Integer.valueOf(this.Opt), Integer.valueOf(submitTipOffReq.Opt)) && Internal.equals(this.MainType, submitTipOffReq.MainType) && Internal.equals(this.SubType, submitTipOffReq.SubType) && Internal.equals(this.Desc, submitTipOffReq.Desc) && this.Evidence.equals(submitTipOffReq.Evidence) && Internal.equals(this.OriginLink, submitTipOffReq.OriginLink) && Internal.equals(Long.valueOf(this.HandleRecID), Long.valueOf(submitTipOffReq.HandleRecID)) && Internal.equals(Integer.valueOf(this.DataType), Integer.valueOf(submitTipOffReq.DataType)) && Internal.equals(this.CommentID, submitTipOffReq.CommentID) && Internal.equals(this.ReplyID, submitTipOffReq.ReplyID)) {
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
        int i27 = this.hashCode;
        if (i27 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.FeedID;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (((hashCode + i3) * 37) + this.Opt) * 37;
            String str2 = this.MainType;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 37;
            String str3 = this.SubType;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 37;
            String str4 = this.Desc;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int hashCode2 = (((i37 + i18) * 37) + this.Evidence.hashCode()) * 37;
            String str5 = this.OriginLink;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int a16 = (((((hashCode2 + i19) * 37) + androidx.fragment.app.a.a(this.HandleRecID)) * 37) + this.DataType) * 37;
            String str6 = this.CommentID;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i38 = (a16 + i26) * 37;
            String str7 = this.ReplyID;
            if (str7 != null) {
                i28 = str7.hashCode();
            }
            int i39 = i38 + i28;
            this.hashCode = i39;
            return i39;
        }
        return i27;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.FeedID != null) {
            sb5.append(", FeedID=");
            sb5.append(Internal.sanitize(this.FeedID));
        }
        sb5.append(", Opt=");
        sb5.append(this.Opt);
        if (this.MainType != null) {
            sb5.append(", MainType=");
            sb5.append(Internal.sanitize(this.MainType));
        }
        if (this.SubType != null) {
            sb5.append(", SubType=");
            sb5.append(Internal.sanitize(this.SubType));
        }
        if (this.Desc != null) {
            sb5.append(", Desc=");
            sb5.append(Internal.sanitize(this.Desc));
        }
        if (!this.Evidence.isEmpty()) {
            sb5.append(", Evidence=");
            sb5.append(Internal.sanitize(this.Evidence));
        }
        if (this.OriginLink != null) {
            sb5.append(", OriginLink=");
            sb5.append(Internal.sanitize(this.OriginLink));
        }
        sb5.append(", HandleRecID=");
        sb5.append(this.HandleRecID);
        sb5.append(", DataType=");
        sb5.append(this.DataType);
        if (this.CommentID != null) {
            sb5.append(", CommentID=");
            sb5.append(Internal.sanitize(this.CommentID));
        }
        if (this.ReplyID != null) {
            sb5.append(", ReplyID=");
            sb5.append(Internal.sanitize(this.ReplyID));
        }
        StringBuilder replace = sb5.replace(0, 2, "SubmitTipOffReq{");
        replace.append('}');
        return replace.toString();
    }

    public SubmitTipOffReq(String str, int i3, String str2, String str3, String str4, List<String> list, String str5, long j3, int i16, String str6, String str7, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.FeedID = str;
            this.Opt = i3;
            if (str2 != null) {
                this.MainType = str2;
                if (str3 != null) {
                    this.SubType = str3;
                    if (str4 != null) {
                        this.Desc = str4;
                        this.Evidence = Internal.immutableCopyOf("Evidence", list);
                        if (str5 != null) {
                            this.OriginLink = str5;
                            this.HandleRecID = j3;
                            this.DataType = i16;
                            if (str6 != null) {
                                this.CommentID = str6;
                                if (str7 != null) {
                                    this.ReplyID = str7;
                                    return;
                                }
                                throw new IllegalArgumentException("ReplyID == null");
                            }
                            throw new IllegalArgumentException("CommentID == null");
                        }
                        throw new IllegalArgumentException("OriginLink == null");
                    }
                    throw new IllegalArgumentException("Desc == null");
                }
                throw new IllegalArgumentException("SubType == null");
            }
            throw new IllegalArgumentException("MainType == null");
        }
        throw new IllegalArgumentException("FeedID == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437222a = this.FeedID;
        aVar.f437223b = this.Opt;
        aVar.f437224c = this.MainType;
        aVar.f437225d = this.SubType;
        aVar.f437226e = this.Desc;
        aVar.f437227f = Internal.copyOf(this.Evidence);
        aVar.f437228g = this.OriginLink;
        aVar.f437229h = this.HandleRecID;
        aVar.f437230i = this.DataType;
        aVar.f437231j = this.CommentID;
        aVar.f437232k = this.ReplyID;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
