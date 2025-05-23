package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetQQBasicRelationChange extends MessageMicro<QZIntimateProfileReader$GetQQBasicRelationChange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 32, 42}, new String[]{"initiator", "member", "is_remove_type", "spaceid"}, new Object[]{"", "", Boolean.FALSE, ""}, QZIntimateProfileReader$GetQQBasicRelationChange.class);
    public final PBStringField initiator = PBField.initString("");
    public final PBStringField member = PBField.initString("");
    public final PBBoolField is_remove_type = PBField.initBool(false);
    public final PBStringField spaceid = PBField.initString("");
}
