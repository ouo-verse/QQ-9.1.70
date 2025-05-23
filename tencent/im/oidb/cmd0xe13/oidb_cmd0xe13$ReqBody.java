package tencent.im.oidb.cmd0xe13;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe13$ReqBody extends MessageMicro<oidb_cmd0xe13$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"msg_report_info", "uint32_seq"}, new Object[]{null, 0}, oidb_cmd0xe13$ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xe13$ReportInfo> msg_report_info = PBField.initRepeatMessage(oidb_cmd0xe13$ReportInfo.class);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}
