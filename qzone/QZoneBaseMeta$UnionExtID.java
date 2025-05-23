package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$UnionExtID extends MessageMicro<QZoneBaseMeta$UnionExtID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"ext_id_type", "numeric", "str"}, new Object[]{0, 0L, ""}, QZoneBaseMeta$UnionExtID.class);
    public final PBEnumField ext_id_type = PBField.initEnum(0);
    public final PBInt64Field numeric = PBField.initInt64(0);
    public final PBStringField str = PBField.initString("");
}
