package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceProfile$CreateISpacesReq extends MessageMicro<QZIntimateSpaceProfile$CreateISpacesReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"users", "type", "relation_create_time"}, new Object[]{null, 0, 0L}, QZIntimateSpaceProfile$CreateISpacesReq.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> users = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBInt64Field relation_create_time = PBField.initInt64(0);
}
