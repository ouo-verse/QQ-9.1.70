package tencent.im.oidb.cmd0xb67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb67$ReqBody extends MessageMicro<oidb_0xb67$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_shield_uin", "int64_expire_time"}, new Object[]{0L, 0L}, oidb_0xb67$ReqBody.class);
    public final PBUInt64Field uint64_shield_uin = PBField.initUInt64(0);
    public final PBInt64Field int64_expire_time = PBField.initInt64(0);
}
