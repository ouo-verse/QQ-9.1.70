package tvideo;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum MarkLabelType implements WireEnum {
    MARK_LABEL_TYPE_SINGLE_TEXT(0),
    MARK_LABEL_TYPE_IMAGE(1);

    public static final ProtoAdapter<MarkLabelType> ADAPTER = new EnumAdapter<MarkLabelType>() { // from class: tvideo.MarkLabelType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            MarkLabelType markLabelType = MarkLabelType.MARK_LABEL_TYPE_SINGLE_TEXT;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MarkLabelType fromValue(int i3) {
            return MarkLabelType.fromValue(i3);
        }
    };
    private final int value;

    MarkLabelType(int i3) {
        this.value = i3;
    }

    public static MarkLabelType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return MARK_LABEL_TYPE_IMAGE;
        }
        return MARK_LABEL_TYPE_SINGLE_TEXT;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
