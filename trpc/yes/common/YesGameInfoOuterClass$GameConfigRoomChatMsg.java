package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigRoomChatMsg extends MessageMicro<YesGameInfoOuterClass$GameConfigRoomChatMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"bubble_hue", "bubble_text_hue", "at_text_hue", "nick_text_hue", "role_nick_text_hue"}, new Object[]{"", "", "", "", ""}, YesGameInfoOuterClass$GameConfigRoomChatMsg.class);
    public final PBStringField bubble_hue = PBField.initString("");
    public final PBStringField bubble_text_hue = PBField.initString("");
    public final PBStringField at_text_hue = PBField.initString("");
    public final PBStringField nick_text_hue = PBField.initString("");
    public final PBStringField role_nick_text_hue = PBField.initString("");
}
