package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$SpaceTypeWithJumpUrl extends MessageMicro<QZIntimateProfileReader$SpaceTypeWithJumpUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"space_type", "space_status", "space_id", QZoneDTLoginReporter.SCHEMA, "uids"}, new Object[]{0, 0, "", "", ""}, QZIntimateProfileReader$SpaceTypeWithJumpUrl.class);
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBEnumField space_status = PBField.initEnum(0);
    public final PBStringField space_id = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
    public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
