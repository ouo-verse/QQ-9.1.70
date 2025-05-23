package tencent.im.group_pro_proto.personalbox;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalBox$ReportReq extends MessageMicro<PersonalBox$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24}, new String[]{"biz_type", "report_time"}, new Object[]{0L, 0L}, PersonalBox$ReportReq.class);
    public final PBUInt64Field biz_type = PBField.initUInt64(0);
    public final PBUInt64Field report_time = PBField.initUInt64(0);
}
