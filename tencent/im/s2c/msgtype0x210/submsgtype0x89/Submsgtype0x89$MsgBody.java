package tencent.im.s2c.msgtype0x210.submsgtype0x89;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x89$MsgBody extends MessageMicro<Submsgtype0x89$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_uiUin", "uint32_push_red_ts", "rpt_msg_num_red"}, new Object[]{0L, 0, null}, Submsgtype0x89$MsgBody.class);
    public final PBUInt64Field uint64_uiUin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_push_red_ts = PBField.initUInt32(0);
    public final PBRepeatMessageField<Submsgtype0x89$NumRedBusiInfo> rpt_msg_num_red = PBField.initRepeatMessage(Submsgtype0x89$NumRedBusiInfo.class);
}
