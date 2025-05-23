package trpcprotocol.feedcloud.sidebar;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum JumpType implements WireEnum {
    JUMP_TYPE_SCHEMA(0),
    JUMP_TYPE_H5(1);

    public static final ProtoAdapter<JumpType> ADAPTER = new EnumAdapter<JumpType>() { // from class: trpcprotocol.feedcloud.sidebar.JumpType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            JumpType jumpType = JumpType.JUMP_TYPE_SCHEMA;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JumpType fromValue(int i3) {
            return JumpType.fromValue(i3);
        }
    };
    private final int value;

    JumpType(int i3) {
        this.value = i3;
    }

    public static JumpType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return JUMP_TYPE_H5;
        }
        return JUMP_TYPE_SCHEMA;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
