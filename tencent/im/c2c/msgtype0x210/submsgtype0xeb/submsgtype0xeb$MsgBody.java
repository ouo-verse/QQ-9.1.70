package tencent.im.c2c.msgtype0x210.submsgtype0xeb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xeb$MsgBody extends MessageMicro<submsgtype0xeb$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"rpt_msg_info", "uint32_app_id", "uint32_inst_id", "uint32_long_message_flag", "bytes_reserved"}, new Object[]{null, 0, 0, 0, ByteStringMicro.EMPTY}, submsgtype0xeb$MsgBody.class);
    public final PBRepeatMessageField<submsgtype0xeb$MsgInfo> rpt_msg_info = PBField.initRepeatMessage(submsgtype0xeb$MsgInfo.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inst_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
}
