package tvideo;

import com.squareup.wire.EnumAdapter;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;

/* compiled from: P */
/* loaded from: classes30.dex */
public enum TokenKeyType implements WireEnum {
    TOKEN_KEY_TYPE_UNSPECIFIED(0),
    TOKEN_KEY_TYPE_QQ_STRONG(1),
    TOKEN_KEY_TYPE_QQ_WEAK(7),
    TOKEN_KEY_TYPE_QQ_VASKEY(8),
    TOKEN_KEY_TYPE_VUID(9),
    TOKEN_KEY_TYPE_QQ_HULIAN(10),
    TOKEN_KEY_TYPE_QQ_CODE(11),
    TOKEN_KEY_TYPE_QQTINY(12),
    TOKEN_KEY_TYPE_QQ_APPLET(13),
    TOKEN_KEY_TYPE_QQ_FAKE_STRONG(21),
    TOKEN_KEY_TYPE_QQ_FAKE_WEAK(27),
    TOKEN_KEY_TYPE_321KEY(50),
    TOKEN_KEY_TYPE_WX_TOKEN(100),
    TOKEN_KEY_TYPE_WX_CODE(101),
    TOKEN_KEY_TYPE_TV_TOKEN(102),
    TOKEN_KEY_TYPE_OPEN_TOKEN(103),
    TOKEN_KEY_TYPE_TEL_PHONE(104),
    TOKEN_KEY_TYPE_WX_OTHER_TOKEN(105),
    TOKEN_KEY_TYPE_OM_TOKEN(106),
    TOKEN_KEY_TYPE_BROWSER_TOKEN(107),
    TOKEN_KEY_TYPE_HUAWEI_TOKEN(108),
    TOKEN_KEY_TYPE_RTX_TOKEN(109),
    TOKEN_KEY_TYPE_VIDEO_PHONE(110),
    TOKEN_KEY_TYPE_VIDEO_SAFE(111),
    TOKEN_KEY_TYPE_UIN_OPENID(112),
    TOKEN_KEY_TYPE_UIN_WT_OPENID(113),
    TOKEN_KEY_TYPE_WX_CODE_CAR(114),
    TOKEN_KEY_TYPE_VIDEO_SERVER_TOKEN(115),
    TOKEN_KEY_TYPE_SIG_TOKEN(116),
    TOKEN_KEY_TYPE_SELF_CHECKING_TOKEN(120);

    public static final ProtoAdapter<TokenKeyType> ADAPTER = new EnumAdapter<TokenKeyType>() { // from class: tvideo.TokenKeyType.a
        {
            Syntax syntax = Syntax.PROTO_3;
            TokenKeyType tokenKeyType = TokenKeyType.TOKEN_KEY_TYPE_UNSPECIFIED;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.squareup.wire.EnumAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TokenKeyType fromValue(int i3) {
            return TokenKeyType.fromValue(i3);
        }
    };
    private final int value;

    TokenKeyType(int i3) {
        this.value = i3;
    }

    public static TokenKeyType fromValue(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 21) {
                    if (i3 != 27) {
                        if (i3 != 50) {
                            if (i3 != 120) {
                                switch (i3) {
                                    case 7:
                                        return TOKEN_KEY_TYPE_QQ_WEAK;
                                    case 8:
                                        return TOKEN_KEY_TYPE_QQ_VASKEY;
                                    case 9:
                                        return TOKEN_KEY_TYPE_VUID;
                                    case 10:
                                        return TOKEN_KEY_TYPE_QQ_HULIAN;
                                    case 11:
                                        return TOKEN_KEY_TYPE_QQ_CODE;
                                    case 12:
                                        return TOKEN_KEY_TYPE_QQTINY;
                                    case 13:
                                        return TOKEN_KEY_TYPE_QQ_APPLET;
                                    default:
                                        switch (i3) {
                                            case 100:
                                                return TOKEN_KEY_TYPE_WX_TOKEN;
                                            case 101:
                                                return TOKEN_KEY_TYPE_WX_CODE;
                                            case 102:
                                                return TOKEN_KEY_TYPE_TV_TOKEN;
                                            case 103:
                                                return TOKEN_KEY_TYPE_OPEN_TOKEN;
                                            case 104:
                                                return TOKEN_KEY_TYPE_TEL_PHONE;
                                            case 105:
                                                return TOKEN_KEY_TYPE_WX_OTHER_TOKEN;
                                            case 106:
                                                return TOKEN_KEY_TYPE_OM_TOKEN;
                                            case 107:
                                                return TOKEN_KEY_TYPE_BROWSER_TOKEN;
                                            case 108:
                                                return TOKEN_KEY_TYPE_HUAWEI_TOKEN;
                                            case 109:
                                                return TOKEN_KEY_TYPE_RTX_TOKEN;
                                            case 110:
                                                return TOKEN_KEY_TYPE_VIDEO_PHONE;
                                            case 111:
                                                return TOKEN_KEY_TYPE_VIDEO_SAFE;
                                            case 112:
                                                return TOKEN_KEY_TYPE_UIN_OPENID;
                                            case 113:
                                                return TOKEN_KEY_TYPE_UIN_WT_OPENID;
                                            case 114:
                                                return TOKEN_KEY_TYPE_WX_CODE_CAR;
                                            case 115:
                                                return TOKEN_KEY_TYPE_VIDEO_SERVER_TOKEN;
                                            case 116:
                                                return TOKEN_KEY_TYPE_SIG_TOKEN;
                                            default:
                                                return null;
                                        }
                                }
                            }
                            return TOKEN_KEY_TYPE_SELF_CHECKING_TOKEN;
                        }
                        return TOKEN_KEY_TYPE_321KEY;
                    }
                    return TOKEN_KEY_TYPE_QQ_FAKE_WEAK;
                }
                return TOKEN_KEY_TYPE_QQ_FAKE_STRONG;
            }
            return TOKEN_KEY_TYPE_QQ_STRONG;
        }
        return TOKEN_KEY_TYPE_UNSPECIFIED;
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }
}
