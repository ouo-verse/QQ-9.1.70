package tvideo;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum RefreshSource implements WireEnum {
    SOURCE_NORMAL(0),
    SOURCE_QUICK_LOGIN(1),
    SOURCE_CHECK_TOKEN_STATE(2);

    public static final ProtoAdapter<RefreshSource> ADAPTER = new EnumAdapter<RefreshSource>() { // from class: tvideo.RefreshSource.a
        {
            Syntax syntax = Syntax.PROTO_3;
            RefreshSource refreshSource = RefreshSource.SOURCE_NORMAL;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RefreshSource fromValue(int i3) {
            return RefreshSource.fromValue(i3);
        }
    };
    private final int value;

    RefreshSource(int i3) {
        this.value = i3;
    }

    public static RefreshSource fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return SOURCE_CHECK_TOKEN_STATE;
            }
            return SOURCE_QUICK_LOGIN;
        }
        return SOURCE_NORMAL;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
