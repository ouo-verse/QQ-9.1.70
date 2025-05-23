package tencent.im.oidb.cmd0x48b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x48b$RspBody extends MessageMicro<oidb_0x48b$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_get_blocklist_rsp"}, new Object[]{null}, oidb_0x48b$RspBody.class);
    public oidb_0x48b$GetblockListRsp msg_get_blocklist_rsp = new MessageMicro<oidb_0x48b$GetblockListRsp>() { // from class: tencent.im.oidb.cmd0x48b.oidb_0x48b$GetblockListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_over", "uint32_next_start_idx", "uint32_get_time", "rpt_msg_get_total_block_info"}, new Object[]{0, 0, 0, null}, oidb_0x48b$GetblockListRsp.class);
        public final PBUInt32Field uint32_over = PBField.initUInt32(0);
        public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
        public final PBUInt32Field uint32_get_time = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0x48b$GetTotalblockInfo> rpt_msg_get_total_block_info = PBField.initRepeatMessage(oidb_0x48b$GetTotalblockInfo.class);
    };
}
