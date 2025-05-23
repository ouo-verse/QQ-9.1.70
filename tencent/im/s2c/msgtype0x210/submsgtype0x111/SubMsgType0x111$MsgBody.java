package tencent.im.s2c.msgtype0x210.submsgtype0x111;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x111$MsgBody extends MessageMicro<SubMsgType0x111$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_type", "rpt_msg_add_recommend_persons", "rpt_uint64_del_uins"}, new Object[]{0L, null, 0L}, SubMsgType0x111$MsgBody.class);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0);
    public final PBRepeatMessageField<SubMsgType0x111$MayKnowPerson> rpt_msg_add_recommend_persons = PBField.initRepeatMessage(SubMsgType0x111$MayKnowPerson.class);
    public final PBRepeatField<Long> rpt_uint64_del_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
