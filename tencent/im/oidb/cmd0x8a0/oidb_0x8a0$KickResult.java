package tencent.im.oidb.cmd0x8a0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8a0$KickResult extends MessageMicro<oidb_0x8a0$KickResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint32_result", "opt_uint64_member_uin"}, new Object[]{0, 0L}, oidb_0x8a0$KickResult.class);
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field opt_uint64_member_uin = PBField.initUInt64(0);
}
