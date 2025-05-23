package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbe8$RspBody extends MessageMicro<oidb_0xbe8$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "enum_op_code", "uint32_rsp_of_popup_flag", "uint32_popup_count_now"}, new Object[]{0L, 1, 0, 0}, oidb_0xbe8$RspBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBEnumField enum_op_code = PBField.initEnum(1);
    public final PBUInt32Field uint32_rsp_of_popup_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_popup_count_now = PBField.initUInt32(0);
}
