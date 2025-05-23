package tencent.im.oidb.cmd0x8a7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8a7$ReqBody extends MessageMicro<cmd0x8a7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint32_sub_cmd", "uint32_limit_interval_type_for_uin", "uint32_limit_interval_type_for_group", "uint64_uin", "uint64_group_code"}, new Object[]{0, 0, 0, 0L, 0L}, cmd0x8a7$ReqBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_limit_interval_type_for_uin = PBField.initUInt32(0);
    public final PBUInt32Field uint32_limit_interval_type_for_group = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
