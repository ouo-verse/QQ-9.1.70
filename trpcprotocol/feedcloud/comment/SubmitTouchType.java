package trpcprotocol.feedcloud.comment;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum SubmitTouchType implements WireEnum {
    UNKNOWN(0),
    SHARE_PANNEL(1),
    AFTER_LIKE(2);

    public static final ProtoAdapter<SubmitTouchType> ADAPTER = new EnumAdapter<SubmitTouchType>() { // from class: trpcprotocol.feedcloud.comment.SubmitTouchType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            SubmitTouchType submitTouchType = SubmitTouchType.UNKNOWN;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SubmitTouchType fromValue(int i3) {
            return SubmitTouchType.fromValue(i3);
        }
    };
    private final int value;

    SubmitTouchType(int i3) {
        this.value = i3;
    }

    public static SubmitTouchType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return AFTER_LIKE;
            }
            return SHARE_PANNEL;
        }
        return UNKNOWN;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
