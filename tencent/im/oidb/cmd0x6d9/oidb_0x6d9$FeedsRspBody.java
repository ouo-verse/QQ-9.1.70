package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.group_file_common.group_file_common$FeedsResult;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d9$FeedsRspBody extends MessageMicro<oidb_0x6d9$FeedsRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "rpt_feeds_result_list", "uint32_svrbusy_wait_time"}, new Object[]{0, "", "", null, 0}, oidb_0x6d9$FeedsRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBRepeatMessageField<group_file_common$FeedsResult> rpt_feeds_result_list = PBField.initRepeatMessage(group_file_common$FeedsResult.class);
    public final PBUInt32Field uint32_svrbusy_wait_time = PBField.initUInt32(0);
}
