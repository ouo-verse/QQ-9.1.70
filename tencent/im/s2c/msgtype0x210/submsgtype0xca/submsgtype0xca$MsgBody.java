package tencent.im.s2c.msgtype0x210.submsgtype0xca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xca$MsgBody extends MessageMicro<submsgtype0xca$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "rpt_msg_list"}, new Object[]{0L, null}, submsgtype0xca$MsgBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<submsgtype0xca$MsgContent> rpt_msg_list = PBField.initRepeatMessage(submsgtype0xca$MsgContent.class);
}
