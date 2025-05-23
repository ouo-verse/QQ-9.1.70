package tencent.im.oidb.cmd0x989;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x989$ReqBody extends MessageMicro<oidb_0x989$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"group_code", "svip_level", "group_level"}, new Object[]{0L, 0L, 0L}, oidb_0x989$ReqBody.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field svip_level = PBField.initUInt64(0);
    public final PBUInt64Field group_level = PBField.initUInt64(0);
}
