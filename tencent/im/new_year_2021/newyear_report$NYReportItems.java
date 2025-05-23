package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class newyear_report$NYReportItems extends MessageMicro<newyear_report$NYReportItems> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 58}, new String[]{"optime", "event", "action", "result", "param_array", "count", "str_action"}, new Object[]{0L, "", 0, 0, "", 0, ""}, newyear_report$NYReportItems.class);
    public final PBUInt64Field optime = PBField.initUInt64(0);
    public final PBStringField event = PBField.initString("");
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField param_array = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField str_action = PBField.initString("");
}
