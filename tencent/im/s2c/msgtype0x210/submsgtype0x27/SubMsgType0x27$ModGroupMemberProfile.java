package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x27$ModGroupMemberProfile extends MessageMicro<SubMsgType0x27$ModGroupMemberProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_group_uin", "uint64_uin", "rpt_msg_group_member_profile_infos", "uint64_group_code"}, new Object[]{0L, 0L, null, 0L}, SubMsgType0x27$ModGroupMemberProfile.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<SubMsgType0x27$GroupMemberProfileInfo> rpt_msg_group_member_profile_infos = PBField.initRepeatMessage(SubMsgType0x27$GroupMemberProfileInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
