package tencent.im.oidb.cmd0xede;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xede$ReqBody extends MessageMicro<oidb_0xede$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_group_code", "uint32_op_type", "uint64_start_group_code"}, new Object[]{0L, 0, 0L}, oidb_0xede$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_start_group_code = PBField.initUInt64(0);
}
