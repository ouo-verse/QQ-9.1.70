package tencent.im.group_pro_proto.eventflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msg_event$Cookie extends MessageMicro<msg_event$Cookie> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time"}, new Object[]{0L, 0L}, msg_event$Cookie.class);
    public final PBUInt64Field begin_time = PBField.initUInt64(0);
    public final PBUInt64Field end_time = PBField.initUInt64(0);
}
