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
import java.util.Objects;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubmitTipOffRsp extends Message<SubmitTipOffRsp, a> {
    public static final ProtoAdapter<SubmitTipOffRsp> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    public final String Code;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class a extends Message.Builder<SubmitTipOffRsp, a> {

        /* renamed from: a, reason: collision with root package name */
        public String f437233a = "";

        public a a(String str) {
            this.f437233a = str;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SubmitTipOffRsp build() {
            return new SubmitTipOffRsp(this.f437233a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class b extends ProtoAdapter<SubmitTipOffRsp> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) SubmitTipOffRsp.class, "type.googleapis.com/trpc.feedcloud.tip_off.SubmitTipOffRsp", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubmitTipOffRsp decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.a(ProtoAdapter.STRING.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, SubmitTipOffRsp submitTipOffRsp) throws IOException {
            if (!Objects.equals(submitTipOffRsp.Code, "")) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, submitTipOffRsp.Code);
            }
            protoWriter.writeBytes(submitTipOffRsp.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(SubmitTipOffRsp submitTipOffRsp) {
            int i3 = 0;
            if (!Objects.equals(submitTipOffRsp.Code, "")) {
                i3 = 0 + ProtoAdapter.STRING.encodedSizeWithTag(1, submitTipOffRsp.Code);
            }
            return i3 + submitTipOffRsp.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SubmitTipOffRsp redact(SubmitTipOffRsp submitTipOffRsp) {
            a newBuilder = submitTipOffRsp.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public SubmitTipOffRsp(String str) {
        this(str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitTipOffRsp)) {
            return false;
        }
        SubmitTipOffRsp submitTipOffRsp = (SubmitTipOffRsp) obj;
        if (unknownFields().equals(submitTipOffRsp.unknownFields()) && Internal.equals(this.Code, submitTipOffRsp.Code)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16 = this.hashCode;
        if (i16 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.Code;
            if (str != null) {
                i3 = str.hashCode();
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
        if (this.Code != null) {
            sb5.append(", Code=");
            sb5.append(Internal.sanitize(this.Code));
        }
        StringBuilder replace = sb5.replace(0, 2, "SubmitTipOffRsp{");
        replace.append('}');
        return replace.toString();
    }

    public SubmitTipOffRsp(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        if (str != null) {
            this.Code = str;
            return;
        }
        throw new IllegalArgumentException("Code == null");
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437233a = this.Code;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
