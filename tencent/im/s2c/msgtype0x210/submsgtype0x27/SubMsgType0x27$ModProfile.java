package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x27$ModProfile extends MessageMicro<SubMsgType0x27$ModProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "rpt_msg_profile_infos"}, new Object[]{0L, null}, SubMsgType0x27$ModProfile.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<SubMsgType0x27$ProfileInfo> rpt_msg_profile_infos = PBField.initRepeatMessage(SubMsgType0x27$ProfileInfo.class);
}
