package tencent.im.s2c.msgtype0x210.submsgtype0x76;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x76$BirthdayNotify extends MessageMicro<SubMsgType0x76$BirthdayNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"rpt_msg_one_friend", "uint32_reserved", "rpt_gift_msg", "str_top_pic_url", "str_extend"}, new Object[]{null, 0, null, "", ""}, SubMsgType0x76$BirthdayNotify.class);
    public final PBRepeatMessageField<SubMsgType0x76$OneBirthdayFriend> rpt_msg_one_friend = PBField.initRepeatMessage(SubMsgType0x76$OneBirthdayFriend.class);
    public final PBUInt32Field uint32_reserved = PBField.initUInt32(0);
    public final PBRepeatMessageField<SubMsgType0x76$OneGiftMessage> rpt_gift_msg = PBField.initRepeatMessage(SubMsgType0x76$OneGiftMessage.class);
    public final PBStringField str_top_pic_url = PBField.initString("");
    public final PBStringField str_extend = PBField.initString("");
}
