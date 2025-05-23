package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$ExtSnsFrdData;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b$MutualMarkData;
import tencent.intimate_relation.intimate_relation$IntimateInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5e0$ContentItem extends MessageMicro<Oidb_0x5e0$ContentItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106}, new String[]{"uint32_update_profile_id", "msg_nicknamefiled", "msg_genderfiled", "msg_friendremark", "msg_longnick", "msg_groupname", "msg_friend_teamlist", "msg_value_bit", "msg_general_buffer", "msg_profile_info", "msg_intimate_info", "msg_ext_sns_frd_data", "msg_mutual_mark_data"}, new Object[]{0, null, null, null, null, null, null, null, null, null, null, null, null}, Oidb_0x5e0$ContentItem.class);
    public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
    public Oidb_0x5e0$NickNameFiled msg_nicknamefiled = new Oidb_0x5e0$NickNameFiled();
    public Oidb_0x5e0$GenderFiled msg_genderfiled = new Oidb_0x5e0$GenderFiled();
    public Oidb_0x5e0$FriendRemark msg_friendremark = new Oidb_0x5e0$FriendRemark();
    public Oidb_0x5e0$LongNick msg_longnick = new MessageMicro<Oidb_0x5e0$LongNick>() { // from class: tencent.im.oidb.cmd0x5e0.Oidb_0x5e0$LongNick
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "bytes_value"}, new Object[]{0L, ByteStringMicro.EMPTY}, Oidb_0x5e0$LongNick.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public Oidb_0x5e0$GroupName msg_groupname = new Oidb_0x5e0$GroupName();
    public Oidb_0x5e0$FriendTeamList msg_friend_teamlist = new Oidb_0x5e0$FriendTeamList();
    public Oidb_0x5e0$ValueBit msg_value_bit = new Oidb_0x5e0$ValueBit();
    public Oidb_0x5e0$GeneralBuffer msg_general_buffer = new Oidb_0x5e0$GeneralBuffer();
    public Oidb_0x5e0$ProfileInfo msg_profile_info = new Oidb_0x5e0$ProfileInfo();
    public intimate_relation$IntimateInfo msg_intimate_info = new intimate_relation$IntimateInfo();
    public Oidb_0xd50$ExtSnsFrdData msg_ext_sns_frd_data = new Oidb_0xd50$ExtSnsFrdData();
    public Oidb_0xd6b$MutualMarkData msg_mutual_mark_data = new Oidb_0xd6b$MutualMarkData();
}
