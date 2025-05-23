package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleBase$StaffInfo extends MessageMicro<QQCircleBase$StaffInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66, 72, 80}, new String[]{"name", "companyName", "position", "email", "evidencePicturies", "optime", "id", "companyLogo", "onboardingTime", "leaveTime"}, new Object[]{"", "", "", "", "", 0L, "", "", 0, 0}, QQCircleBase$StaffInfo.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField companyName = PBField.initString("");
    public final PBStringField position = PBField.initString("");
    public final PBStringField email = PBField.initString("");
    public final PBRepeatField<String> evidencePicturies = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt64Field optime = PBField.initInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f429291id = PBField.initString("");
    public final PBStringField companyLogo = PBField.initString("");
    public final PBUInt32Field onboardingTime = PBField.initUInt32(0);
    public final PBUInt32Field leaveTime = PBField.initUInt32(0);
}
