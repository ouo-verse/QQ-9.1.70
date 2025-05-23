package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$CheckInGrayIntimateSpaceReq extends MessageMicro<QZIntimateSpaceProfile$CheckInGrayIntimateSpaceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"users"}, new Object[]{null}, QZIntimateSpaceProfile$CheckInGrayIntimateSpaceReq.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> users = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
}
