package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$CheckinSpaceInfo extends MessageMicro<QZIntimateCheckIn$CheckinSpaceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"space_id", "uid"}, new Object[]{"", ""}, QZIntimateCheckIn$CheckinSpaceInfo.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBRepeatField<String> uid = PBField.initRepeat(PBStringField.__repeatHelper__);
}
