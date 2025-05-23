package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QFind$ReqReportDevs extends MessageMicro<QFind$ReqReportDevs> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"dev_infos", "dev_loc"}, new Object[]{null, null}, QFind$ReqReportDevs.class);
    public final PBRepeatMessageField<QFind$DeviceInfo> dev_infos = PBField.initRepeatMessage(QFind$DeviceInfo.class);
    public QFind$DeviceLoc dev_loc = new QFind$DeviceLoc();
}
