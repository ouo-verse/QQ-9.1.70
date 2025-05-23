package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$ClientCreateISpacesReq extends MessageMicro<QZIntimateProfileReader$ClientCreateISpacesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48}, new String[]{"users", "type", "anniversary", "ext_info", "user_with_uin", "anniversary_v2"}, new Object[]{null, 0, 0L, null, 0L, 0L}, QZIntimateProfileReader$ClientCreateISpacesReq.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> users = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBUInt64Field anniversary = PBField.initUInt64(0);
    public QZoneBaseCommon$StCommonExt ext_info = new QZoneBaseCommon$StCommonExt();
    public final PBRepeatField<Long> user_with_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBInt64Field anniversary_v2 = PBField.initInt64(0);
}
