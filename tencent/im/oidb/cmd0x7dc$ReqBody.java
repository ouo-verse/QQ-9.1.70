package tencent.im.oidb;

import appoint.define.appoint_define$AppointContent;
import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7dc$ReqBody extends MessageMicro<cmd0x7dc$ReqBody> {
    public static final int MSG_APPOINTMENT_FIELD_NUMBER = 2;
    public static final int MSG_LBS_INFO_FIELD_NUMBER = 3;
    public static final int UINT32_OVERWRITE_FIELD_NUMBER = 4;
    public static final int UINT32_SEQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_seq", "msg_appointment", "msg_lbs_info", "uint32_overwrite"}, new Object[]{0, null, null, 0}, cmd0x7dc$ReqBody.class);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public appoint_define$AppointContent msg_appointment = new appoint_define$AppointContent();
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBUInt32Field uint32_overwrite = PBField.initUInt32(0);
}
