package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x27$PraiseRankNotify extends MessageMicro<SubMsgType0x27$PraiseRankNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88, 96, 106}, new String[]{"uint32_is_champion", "uint32_rank_num", "str_msg"}, new Object[]{0, 0, ""}, SubMsgType0x27$PraiseRankNotify.class);
    public final PBUInt32Field uint32_is_champion = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rank_num = PBField.initUInt32(0);
    public final PBStringField str_msg = PBField.initString("");
}
