package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetIntimateRelationChangeReq extends MessageMicro<QZIntimateProfileReader$GetIntimateRelationChangeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"initiator", "member", "type", "action", "anniversary"}, new Object[]{"", "", 0, 0, 0L}, QZIntimateProfileReader$GetIntimateRelationChangeReq.class);
    public final PBStringField initiator = PBField.initString("");
    public final PBStringField member = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBEnumField action = PBField.initEnum(0);
    public final PBInt64Field anniversary = PBField.initInt64(0);
}
