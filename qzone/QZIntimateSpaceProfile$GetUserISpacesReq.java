package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$GetUserISpacesReq extends MessageMicro<QZIntimateSpaceProfile$GetUserISpacesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"uid", "fields", "verify_intimate_relation"}, new Object[]{"", null, Boolean.FALSE}, QZIntimateSpaceProfile$GetUserISpacesReq.class);
    public final PBRepeatField<String> uid = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> fields = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
    public final PBBoolField verify_intimate_relation = PBField.initBool(false);
}
