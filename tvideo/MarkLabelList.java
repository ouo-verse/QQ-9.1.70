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
import java.util.List;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MarkLabelList extends Message<MarkLabelList, a> {
    public static final ProtoAdapter<MarkLabelList> ADAPTER = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "tvideo.MarkLabel#ADAPTER", jsonName = "markLabelList", label = WireField.Label.REPEATED, tag = 1)
    public final List<MarkLabel> mark_label_list;

    /* compiled from: P */
    /* loaded from: classes30.dex */
    public static final class a extends Message.Builder<MarkLabelList, a> {

        /* renamed from: a, reason: collision with root package name */
        public List<MarkLabel> f437693a = Internal.newMutableList();

        @Override // com.squareup.wire.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MarkLabelList build() {
            return new MarkLabelList(this.f437693a, super.buildUnknownFields());
        }
    }

    /* compiled from: P */
    /* loaded from: classes30.dex */
    private static final class b extends ProtoAdapter<MarkLabelList> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, (Class<?>) MarkLabelList.class, "type.googleapis.com/tvideo.MarkLabelList", Syntax.PROTO_3, (Object) null);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MarkLabelList decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    if (nextTag != 1) {
                        protoReader.readUnknownField(nextTag);
                    } else {
                        aVar.f437693a.add(MarkLabel.ADAPTER.decode(protoReader));
                    }
                } else {
                    aVar.addUnknownFields(protoReader.endMessageAndGetUnknownFields(beginMessage));
                    return aVar.build();
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(ProtoWriter protoWriter, MarkLabelList markLabelList) throws IOException {
            MarkLabel.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, markLabelList.mark_label_list);
            protoWriter.writeBytes(markLabelList.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(MarkLabelList markLabelList) {
            return MarkLabel.ADAPTER.asRepeated().encodedSizeWithTag(1, markLabelList.mark_label_list) + 0 + markLabelList.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MarkLabelList redact(MarkLabelList markLabelList) {
            a newBuilder = markLabelList.newBuilder();
            Internal.redactElements(newBuilder.f437693a, MarkLabel.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    public MarkLabelList(List<MarkLabel> list) {
        this(list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarkLabelList)) {
            return false;
        }
        MarkLabelList markLabelList = (MarkLabelList) obj;
        if (unknownFields().equals(markLabelList.unknownFields()) && this.mark_label_list.equals(markLabelList.mark_label_list)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (unknownFields().hashCode() * 37) + this.mark_label_list.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (!this.mark_label_list.isEmpty()) {
            sb5.append(", mark_label_list=");
            sb5.append(this.mark_label_list);
        }
        StringBuilder replace = sb5.replace(0, 2, "MarkLabelList{");
        replace.append('}');
        return replace.toString();
    }

    public MarkLabelList(List<MarkLabel> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.mark_label_list = Internal.immutableCopyOf("mark_label_list", list);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a aVar = new a();
        aVar.f437693a = Internal.copyOf(this.mark_label_list);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
