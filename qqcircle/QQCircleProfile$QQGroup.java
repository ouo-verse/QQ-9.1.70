package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleProfile$QQGroup extends MessageMicro<QQCircleProfile$QQGroup> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f429310id = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBBoolField is_full = PBField.initBool(false);
    public final PBStringField head_url = PBField.initString("");
    public final PBBoolField is_join = PBField.initBool(false);
    public final PBBytesField join_auth = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field member_num = PBField.initUInt32(0);
    public final PBBoolField is_active = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 48, 58, 66, 72, 80}, new String[]{"id", "name", "is_full", "head_url", "is_join", "join_auth", "desc", "member_num", "is_active"}, new Object[]{0L, "", bool, "", bool, ByteStringMicro.EMPTY, "", 0, bool}, QQCircleProfile$QQGroup.class);
    }
}
