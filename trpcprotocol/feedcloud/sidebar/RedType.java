package trpcprotocol.feedcloud.sidebar;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum RedType implements WireEnum {
    RED_TYPE_NONE(0),
    RED_TYPE_SMALL(1),
    RED_TYPE_NUMBER(2),
    RED_TYPE_TEXT(3);

    public static final ProtoAdapter<RedType> ADAPTER = new EnumAdapter<RedType>() { // from class: trpcprotocol.feedcloud.sidebar.RedType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RedType redType = RedType.RED_TYPE_NONE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedType fromValue(int i3) {
            return RedType.fromValue(i3);
        }
    };
    private final int value;

    RedType(int i3) {
        this.value = i3;
    }

    public static RedType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return RED_TYPE_TEXT;
                }
                return RED_TYPE_NUMBER;
            }
            return RED_TYPE_SMALL;
        }
        return RED_TYPE_NONE;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
