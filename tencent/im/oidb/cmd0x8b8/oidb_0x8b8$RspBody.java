package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b8$RspBody extends MessageMicro<oidb_0x8b8$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"uint32_result", "uint64_group_uin", "uint32_sequence", "uint32_subcmd", "uint32_default_id", "uint32_pic_cnt", "rpt_uint32_pic_list", "rpt_msg_pic_list_info"}, new Object[]{0, 0L, 0, 0, 0, 0, 0, null}, oidb_0x8b8$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0x8b8$GroupPicListInfo> rpt_msg_pic_list_info = PBField.initRepeatMessage(oidb_0x8b8$GroupPicListInfo.class);
}
