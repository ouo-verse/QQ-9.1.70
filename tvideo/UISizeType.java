package tvideo;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum UISizeType implements WireEnum {
    UISizeType_REGULAR(0),
    UISizeType_LARGE(1),
    UISizeType_HUGE(2),
    UISizeType_MAXIMIZE(3),
    UISizeType_XMAXIMIZE(4);

    public static final ProtoAdapter<UISizeType> ADAPTER = new EnumAdapter<UISizeType>() { // from class: tvideo.UISizeType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            UISizeType uISizeType = UISizeType.UISizeType_REGULAR;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UISizeType fromValue(int i3) {
            return UISizeType.fromValue(i3);
        }
    };
    private final int value;

    UISizeType(int i3) {
        this.value = i3;
    }

    public static UISizeType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return UISizeType_XMAXIMIZE;
                    }
                    return UISizeType_MAXIMIZE;
                }
                return UISizeType_HUGE;
            }
            return UISizeType_LARGE;
        }
        return UISizeType_REGULAR;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
