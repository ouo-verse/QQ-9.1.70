package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$DoCustomPassiveReq extends MessageMicro<QZIntimateSpaceWriter$DoCustomPassiveReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 66, 74}, new String[]{"op_uid", "target_dataid", "ctime", "action_type", "mtypeid", "msg_content", "pointed_uid_list", "ext_info", "space_id"}, new Object[]{"", "", 0L, 0, 0, "", "", null, ""}, QZIntimateSpaceWriter$DoCustomPassiveReq.class);
    public final PBStringField op_uid = PBField.initString("");
    public final PBStringField target_dataid = PBField.initString("");
    public final PBUInt64Field ctime = PBField.initUInt64(0);
    public final PBInt32Field action_type = PBField.initInt32(0);
    public final PBInt32Field mtypeid = PBField.initInt32(0);
    public final PBStringField msg_content = PBField.initString("");
    public final PBRepeatField<String> pointed_uid_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public final PBStringField space_id = PBField.initString("");
}
