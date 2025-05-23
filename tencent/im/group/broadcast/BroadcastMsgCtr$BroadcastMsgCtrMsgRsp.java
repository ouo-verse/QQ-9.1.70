package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BroadcastMsgCtr$BroadcastMsgCtrMsgRsp extends MessageMicro<BroadcastMsgCtr$BroadcastMsgCtrMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_group_uin", "uint64_from_uin", "uint32_msg_seq", "uint32_msg_type", "uint32_succ_count", "uint32_fail_count"}, new Object[]{0L, 0L, 0, 0, 0, 0}, BroadcastMsgCtr$BroadcastMsgCtrMsgRsp.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_succ_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_fail_count = PBField.initUInt32(0);
}
