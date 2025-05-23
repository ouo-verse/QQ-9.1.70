package tencent.im.s2c.msgtype0x210.submsgtype0xdc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xdc$MsgBody extends MessageMicro<submsgtype0xdc$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"rpt_msg_list", "uint32_msg_type", "rpt_msg_list_0x02", "minQqVer"}, new Object[]{null, 0, null, ""}, submsgtype0xdc$MsgBody.class);
    public final PBRepeatMessageField<submsgtype0xdc$MsgContent> rpt_msg_list = PBField.initRepeatMessage(submsgtype0xdc$MsgContent.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<submsgtype0xdc$MsgContent> rpt_msg_list_0x02 = PBField.initRepeatMessage(submsgtype0xdc$MsgContent.class);
    public final PBStringField minQqVer = PBField.initString("");
}
