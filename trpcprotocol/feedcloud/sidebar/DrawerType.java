package trpcprotocol.feedcloud.sidebar;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum DrawerType implements WireEnum {
    DRAWER_TYPE_COMMON(0),
    DRAWER_TYPE_NAVBAR(1),
    DRAWER_TYPE_SPLIT(2);

    public static final ProtoAdapter<DrawerType> ADAPTER = new EnumAdapter<DrawerType>() { // from class: trpcprotocol.feedcloud.sidebar.DrawerType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            DrawerType drawerType = DrawerType.DRAWER_TYPE_COMMON;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DrawerType fromValue(int i3) {
            return DrawerType.fromValue(i3);
        }
    };
    private final int value;

    DrawerType(int i3) {
        this.value = i3;
    }

    public static DrawerType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return DRAWER_TYPE_SPLIT;
            }
            return DRAWER_TYPE_NAVBAR;
        }
        return DRAWER_TYPE_COMMON;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
