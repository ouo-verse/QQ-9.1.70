package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class nearfield_discuss$UserProfile extends MessageMicro<nearfield_discuss$UserProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"uint64_uin", "int32_face_id", "int32_sex", "int32_age", "str_nick"}, new Object[]{0L, 0, 0, 0, ""}, nearfield_discuss$UserProfile.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBInt32Field int32_face_id = PBField.initInt32(0);
    public final PBInt32Field int32_sex = PBField.initInt32(0);
    public final PBInt32Field int32_age = PBField.initInt32(0);
    public final PBStringField str_nick = PBField.initString("");
}
