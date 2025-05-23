package tencent.im.oidb.cmd0x46f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x46f$RspBody extends MessageMicro<oidb_cmd0x46f$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 90}, new String[]{"uint32_fail_count", "rpt_result_list"}, new Object[]{0, null}, oidb_cmd0x46f$RspBody.class);
    public final PBUInt32Field uint32_fail_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0x46f$DislikeResult> rpt_result_list = PBField.initRepeatMessage(oidb_cmd0x46f$DislikeResult.class);
}
