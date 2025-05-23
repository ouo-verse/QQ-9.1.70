package tencent.im.group_pro_proto.msg_responses_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgResponsesSvr$EmojiReaction extends MessageMicro<MsgResponsesSvr$EmojiReaction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"emoji_id", "emoji_type", "cnt", "is_clicked"}, new Object[]{"", 0L, 0L, Boolean.FALSE}, MsgResponsesSvr$EmojiReaction.class);
    public final PBStringField emoji_id = PBField.initString("");
    public final PBUInt64Field emoji_type = PBField.initUInt64(0);
    public final PBUInt64Field cnt = PBField.initUInt64(0);
    public final PBBoolField is_clicked = PBField.initBool(false);
}
