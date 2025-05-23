package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BroadcastMsgCtr$BroadcastSystemMsgReq extends MessageMicro<BroadcastMsgCtr$BroadcastSystemMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56, 64, 72, 88, 98, 138}, new String[]{"uint64_from_uin", "rpt_msg_broadcast_msg_unit", "bytes_msg", "uint32_msg_type", "uint32_msg_seq", "msg_from_inst_info", "uint64_group_code", "uint64_group_uin", "uint32_msg_time", "uint32_msg_sys_seq", "group_info_tlv", "msg_roaming_dst_insts"}, new Object[]{0L, null, ByteStringMicro.EMPTY, 0, 0, null, 0L, 0L, 0, 0, null, null}, BroadcastMsgCtr$BroadcastSystemMsgReq.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<BroadcastMsgCtr$BroadcastMsgCtrMsgUnit> rpt_msg_broadcast_msg_unit = PBField.initRepeatMessage(BroadcastMsgCtr$BroadcastMsgCtrMsgUnit.class);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public BroadcastMsgCtr$BroadcastMsgCtrInstInfo msg_from_inst_info = new BroadcastMsgCtr$BroadcastMsgCtrInstInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_sys_seq = PBField.initUInt32(0);
    public BroadcastMsgCtr$Ex2tlvGroupInfo group_info_tlv = new BroadcastMsgCtr$Ex2tlvGroupInfo();
    public final PBRepeatMessageField<BroadcastMsgCtr$BroadcastMsgCtrInstInfo> msg_roaming_dst_insts = PBField.initRepeatMessage(BroadcastMsgCtr$BroadcastMsgCtrInstInfo.class);
}
