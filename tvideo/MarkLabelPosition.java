package tvideo;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* loaded from: classes30.dex */
public enum MarkLabelPosition implements WireEnum {
    MARK_LABEL_POSITION_LEFT_TOP(0),
    MARK_LABEL_POSITION_RIGHT_TOP(1),
    MARK_LABEL_POSITION_LEFT_BOTTOM(2),
    MARK_LABEL_POSITION_RIGHT_BOTTOM(3);

    public static final ProtoAdapter<MarkLabelPosition> ADAPTER = new EnumAdapter<MarkLabelPosition>() { // from class: tvideo.MarkLabelPosition.a
        {
            Syntax syntax = Syntax.PROTO_3;
            MarkLabelPosition markLabelPosition = MarkLabelPosition.MARK_LABEL_POSITION_LEFT_TOP;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MarkLabelPosition fromValue(int i3) {
            return MarkLabelPosition.fromValue(i3);
        }
    };
    private final int value;

    MarkLabelPosition(int i3) {
        this.value = i3;
    }

    public static MarkLabelPosition fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return MARK_LABEL_POSITION_RIGHT_BOTTOM;
                }
                return MARK_LABEL_POSITION_LEFT_BOTTOM;
            }
            return MARK_LABEL_POSITION_RIGHT_TOP;
        }
        return MARK_LABEL_POSITION_LEFT_TOP;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
