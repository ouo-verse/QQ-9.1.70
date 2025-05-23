package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbe8$ReqBody extends MessageMicro<oidb_0xbe8$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"uint64_uin", "enum_op_code", "uint32_req_of_popup_flag", "uint32_rst_of_popup_flag", "uint32_mqq808_welcomepage_flag", "rpt_msg_popup_result"}, new Object[]{0L, 1, 0, 0, 0, null}, oidb_0xbe8$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBEnumField enum_op_code = PBField.initEnum(1);
    public final PBUInt32Field uint32_req_of_popup_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rst_of_popup_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_mqq808_welcomepage_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xbe8$PopupResult> rpt_msg_popup_result = PBField.initRepeatMessage(oidb_0xbe8$PopupResult.class);
}
