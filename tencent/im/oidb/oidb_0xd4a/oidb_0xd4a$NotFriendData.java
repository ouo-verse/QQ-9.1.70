package tencent.im.oidb.oidb_0xd4a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DnaInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd4a$NotFriendData extends MessageMicro<oidb_0xd4a$NotFriendData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 98, 114}, new String[]{"uint64_from_uin", "uint64_to_uin", "msg_common_group_chat_info", "rpt_msg_dna_info"}, new Object[]{0L, 0L, null, null}, oidb_0xd4a$NotFriendData.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public oidb_0xcf4$CommonGroupChatInfo msg_common_group_chat_info = new oidb_0xcf4$CommonGroupChatInfo();
    public final PBRepeatMessageField<oidb_0xcf4$DnaInfo> rpt_msg_dna_info = PBField.initRepeatMessage(oidb_0xcf4$DnaInfo.class);
}
