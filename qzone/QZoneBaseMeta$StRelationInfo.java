package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StRelationInfo extends MessageMicro<QZoneBaseMeta$StRelationInfo> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430337id = PBField.initString("");
    public final PBBoolField is_friend = PBField.initBool(false);
    public final PBBoolField is_uncare = PBField.initBool(false);
    public final PBBoolField has_right = PBField.initBool(false);
    public final PBUInt64Field part_flag = PBField.initUInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"id", "is_friend", "is_uncare", "has_right", "part_flag"}, new Object[]{"", bool, bool, bool, 0L}, QZoneBaseMeta$StRelationInfo.class);
    }
}
