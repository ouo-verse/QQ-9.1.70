package tencent.im.msgrevoke;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class msgrevoke_userdef$UinTypeUserDef extends MessageMicro<msgrevoke_userdef$UinTypeUserDef> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_from_uin_type", "uint64_from_group_code", "str_file_uuid"}, new Object[]{0, 0L, ""}, msgrevoke_userdef$UinTypeUserDef.class);
    public final PBUInt32Field uint32_from_uin_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_group_code = PBField.initUInt64(0);
    public final PBRepeatField<String> str_file_uuid = PBField.initRepeat(PBStringField.__repeatHelper__);
}
