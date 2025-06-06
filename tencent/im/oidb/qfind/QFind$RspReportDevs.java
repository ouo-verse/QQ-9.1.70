package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QFind$RspReportDevs extends MessageMicro<QFind$RspReportDevs> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90}, new String[]{"result", "report_same_dev_interval", "report_any_devs_interval", "report_often_period", "report_often_frequence", "freq_limit_report_any_devs_interval", "force_report_lbs", "force_report_lbs_period", "report_same_lost_devs_interval", "report_max_dev_num", "lost_devs"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null}, QFind$RspReportDevs.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field report_same_dev_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_any_devs_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_often_period = PBField.initUInt32(0);
    public final PBUInt32Field report_often_frequence = PBField.initUInt32(0);
    public final PBUInt32Field freq_limit_report_any_devs_interval = PBField.initUInt32(0);
    public final PBUInt32Field force_report_lbs = PBField.initUInt32(0);
    public final PBUInt32Field force_report_lbs_period = PBField.initUInt32(0);
    public final PBUInt32Field report_same_lost_devs_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_max_dev_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<QFind$DeviceInfo> lost_devs = PBField.initRepeatMessage(QFind$DeviceInfo.class);
}
