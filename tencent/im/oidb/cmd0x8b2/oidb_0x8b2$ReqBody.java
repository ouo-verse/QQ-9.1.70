package tencent.im.oidb.cmd0x8b2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b2$ReqBody extends MessageMicro<oidb_0x8b2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"string_hot_group_id", "uint64_administrator_uin", "bool_clear_all_administrator", "uint64_group_code"}, new Object[]{ByteStringMicro.EMPTY, 0L, Boolean.FALSE, 0L}, oidb_0x8b2$ReqBody.class);
    public final PBBytesField string_hot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> uint64_administrator_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBoolField bool_clear_all_administrator = PBField.initBool(false);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
