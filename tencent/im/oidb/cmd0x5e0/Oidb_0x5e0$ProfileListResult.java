package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class Oidb_0x5e0$ProfileListResult extends MessageMicro<Oidb_0x5e0$ProfileListResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_result", "uint32_update_profile_id", "uint32_new_content_timestamp"}, new Object[]{0, 0, 0}, Oidb_0x5e0$ProfileListResult.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_content_timestamp = PBField.initUInt32(0);
}
