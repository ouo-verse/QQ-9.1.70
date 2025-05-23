package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StCheckinListRsp extends MessageMicro<QZIntimateCheckIn$StCheckinListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50}, new String[]{"users", "space_create_time", "save_limit_time", "space_type", "comm_checkin_days", "ext"}, new Object[]{null, 0L, 0L, 0, 0, null}, QZIntimateCheckIn$StCheckinListRsp.class);
    public final PBRepeatMessageField<QZIntimateCheckIn$UserCheckinInfo> users = PBField.initRepeatMessage(QZIntimateCheckIn$UserCheckinInfo.class);
    public final PBUInt64Field space_create_time = PBField.initUInt64(0);
    public final PBUInt64Field save_limit_time = PBField.initUInt64(0);
    public final PBEnumField space_type = PBField.initEnum(0);
    public final PBUInt32Field comm_checkin_days = PBField.initUInt32(0);
    public QZoneBaseCommon$StCommonExt ext = new QZoneBaseCommon$StCommonExt();
}
