package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BroadcastMsgCtr$BroadcastMsgCtrMsgUnit extends MessageMicro<BroadcastMsgCtr$BroadcastMsgCtrMsgUnit> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64, 72, 80, 88}, new String[]{"uint64_uin", "bytes_tlv", "uint32_msg_ctr_cmd", "uint32_msg_mask", "uint32_intelligent_terminal_flag", "uint32_online_bits", "uint32_mobile_flag", "uint32_new_msg_mask", "bsavemsgdb", "uint32_group_member_flag_ex2", "uint32_read_msg_seq"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0, 0, Boolean.FALSE, 0, 0}, BroadcastMsgCtr$BroadcastMsgCtrMsgUnit.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_tlv = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_msg_ctr_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_mask = PBField.initUInt32(0);
    public final PBUInt32Field uint32_intelligent_terminal_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_bits = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mobile_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_msg_mask = PBField.initUInt32(0);
    public final PBBoolField bsavemsgdb = PBField.initBool(false);
    public final PBUInt32Field uint32_group_member_flag_ex2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_msg_seq = PBField.initUInt32(0);
}
