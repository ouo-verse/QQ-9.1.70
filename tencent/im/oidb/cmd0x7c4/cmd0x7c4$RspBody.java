package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c4$RspBody extends MessageMicro<cmd0x7c4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"msg_get_recommend_sn_frd_list_rsp", "msg_get_sn_frd_list_rsp", "rpt_msg_recommend_reason", "msg_box"}, new Object[]{null, null, null, null}, cmd0x7c4$RspBody.class);
    public cmd0x7c4$GetRecommendSNFrdListRsp msg_get_recommend_sn_frd_list_rsp = new MessageMicro<cmd0x7c4$GetRecommendSNFrdListRsp>() { // from class: tencent.im.oidb.cmd0x7c4.cmd0x7c4$GetRecommendSNFrdListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_uin", "uint32_sequence", "uint32_over", "uint32_next_start_idx", "rpt_msg_one_frd_data"}, new Object[]{0L, 0, 0, 0, null}, cmd0x7c4$GetRecommendSNFrdListRsp.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
        public final PBUInt32Field uint32_over = PBField.initUInt32(0);
        public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
        public final PBRepeatMessageField<cmd0x7c4$OneFrdData> rpt_msg_one_frd_data = PBField.initRepeatMessage(cmd0x7c4$OneFrdData.class);
    };
    public cmd0x7c4$GetSNFrdListRsp msg_get_sn_frd_list_rsp = new cmd0x7c4$GetSNFrdListRsp();
    public final PBRepeatMessageField<cmd0x7c4$RecommendReason> rpt_msg_recommend_reason = PBField.initRepeatMessage(cmd0x7c4$RecommendReason.class);
    public cmd0x7c4$MsgBox msg_box = new MessageMicro<cmd0x7c4$MsgBox>() { // from class: tencent.im.oidb.cmd0x7c4.cmd0x7c4$MsgBox
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_reason_id", "bytes_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0x7c4$MsgBox.class);
        public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
        public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
