package tencent.im.oidb.cmd0x89e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x89e$ReqBody extends MessageMicro<oidb_0x89e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_group_code", "uint64_old_owner", "uint64_new_owner"}, new Object[]{0L, 0L, 0L}, oidb_0x89e$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_old_owner = PBField.initUInt64(0);
    public final PBUInt64Field uint64_new_owner = PBField.initUInt64(0);
}
