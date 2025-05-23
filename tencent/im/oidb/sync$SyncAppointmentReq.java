package tencent.im.oidb;

import appoint.define.appoint_define$AppointContent;
import appoint.define.appoint_define$GPS;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sync$SyncAppointmentReq extends MessageMicro<sync$SyncAppointmentReq> {
    public static final int MSG_APPOINTMENT_FIELD_NUMBER = 2;
    public static final int MSG_GPS_INFO_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint64_uin", "msg_appointment", "msg_gps_info"}, new Object[]{0L, null, null}, sync$SyncAppointmentReq.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public appoint_define$AppointContent msg_appointment = new appoint_define$AppointContent();
    public appoint_define$GPS msg_gps_info = new appoint_define$GPS();
}
