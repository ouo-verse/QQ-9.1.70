package tencent.im.oidb.cmd0x8db;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8db$ReqBody extends MessageMicro<oidb_0x8db$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_user_type", "uint32_from_type"}, new Object[]{0, 0}, oidb_0x8db$ReqBody.class);
    public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_type = PBField.initUInt32(0);
}
