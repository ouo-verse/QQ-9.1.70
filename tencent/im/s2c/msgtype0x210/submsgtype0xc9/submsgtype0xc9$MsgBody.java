package tencent.im.s2c.msgtype0x210.submsgtype0xc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xc9$MsgBody extends MessageMicro<submsgtype0xc9$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"uint32_type", "uint64_from_uin", "uint64_action_uin", "source", "rpt_msg_business_msg", "bool_new_friend"}, new Object[]{0, 0L, 0L, 0, null, Boolean.FALSE}, submsgtype0xc9$MsgBody.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_action_uin = PBField.initUInt64(0);
    public final PBEnumField source = PBField.initEnum(0);
    public final PBRepeatMessageField<submsgtype0xc9$BusinessMsg> rpt_msg_business_msg = PBField.initRepeatMessage(submsgtype0xc9$BusinessMsg.class);
    public final PBBoolField bool_new_friend = PBField.initBool(false);
}
