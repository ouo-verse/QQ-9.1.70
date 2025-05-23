package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleBase$StudentInfo extends MessageMicro<QQCircleBase$StudentInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 58, 66, 72, 82, 90, 98, 104}, new String[]{"name", "schoolName", "collegeName", "education", "degree", "enrollmentTime", "email", "evidencePicturies", "optime", "id", "schoolLogo", "collegeID", "graduationTime"}, new Object[]{"", "", "", 1, 1, 0, "", "", 0L, "", "", "", 0}, QQCircleBase$StudentInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField schoolName = PBField.initString("");
    public final PBStringField collegeName = PBField.initString("");
    public final PBEnumField education = PBField.initEnum(1);
    public final PBEnumField degree = PBField.initEnum(1);
    public final PBUInt32Field enrollmentTime = PBField.initUInt32(0);
    public final PBStringField email = PBField.initString("");
    public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt64Field optime = PBField.initInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429292id = PBField.initString("");
    public final PBStringField schoolLogo = PBField.initString("");
    public final PBStringField collegeID = PBField.initString("");
    public final PBUInt32Field graduationTime = PBField.initUInt32(0);
}
