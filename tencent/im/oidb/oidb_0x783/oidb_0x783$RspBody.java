package tencent.im.oidb.oidb_0x783;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x783$RspBody extends MessageMicro<oidb_0x783$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 29, 34}, new String[]{"uint32_result", "str_errmsg", "uint32_server_time", "rpt_remark_infos"}, new Object[]{0, "", 0, null}, oidb_0x783$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBFixed32Field uint32_server_time = PBField.initFixed32(0);
    public final PBRepeatMessageField<oidb_0x783$RemarkInfo> rpt_remark_infos = PBField.initRepeatMessage(oidb_0x783$RemarkInfo.class);
}
