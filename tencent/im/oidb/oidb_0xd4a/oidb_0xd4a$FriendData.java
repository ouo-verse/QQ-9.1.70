package tencent.im.oidb.oidb_0xd4a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DateTips;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DnaInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$FriendInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$MutualMarkInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$MutualScore;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$PrefetchMutualMarkInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd4a$FriendData extends MessageMicro<oidb_0xd4a$FriendData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 82, 90, 98, 106, 114, 122, 130, 138, 146}, new String[]{"uint64_from_uin", "uint64_to_uin", "msg_cur_mutual_mark_info", "msg_friend_info", "msg_common_group_chat_info", "rpt_msg_mutual_mark_info", "rpt_msg_dna_info", "rpt_msg_prefetch_mutual_mark_info", "rpt_msg_data_tips", "rpt_msg_mutual_score", "string_reddot_data"}, new Object[]{0L, 0L, null, null, null, null, null, null, null, null, ByteStringMicro.EMPTY}, oidb_0xd4a$FriendData.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public oidb_0xcf4$MutualMarkInfo msg_cur_mutual_mark_info = new oidb_0xcf4$MutualMarkInfo();
    public oidb_0xcf4$FriendInfo msg_friend_info = new oidb_0xcf4$FriendInfo();
    public oidb_0xcf4$CommonGroupChatInfo msg_common_group_chat_info = new oidb_0xcf4$CommonGroupChatInfo();
    public final PBRepeatMessageField<oidb_0xcf4$MutualMarkInfo> rpt_msg_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4$MutualMarkInfo.class);
    public final PBRepeatMessageField<oidb_0xcf4$DnaInfo> rpt_msg_dna_info = PBField.initRepeatMessage(oidb_0xcf4$DnaInfo.class);
    public final PBRepeatMessageField<oidb_0xcf4$PrefetchMutualMarkInfo> rpt_msg_prefetch_mutual_mark_info = PBField.initRepeatMessage(oidb_0xcf4$PrefetchMutualMarkInfo.class);
    public final PBRepeatMessageField<oidb_0xcf4$DateTips> rpt_msg_data_tips = PBField.initRepeatMessage(oidb_0xcf4$DateTips.class);
    public oidb_0xcf4$MutualScore rpt_msg_mutual_score = new oidb_0xcf4$MutualScore();
    public final PBBytesField string_reddot_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
