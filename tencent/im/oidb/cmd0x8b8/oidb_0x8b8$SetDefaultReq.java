package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8b8$SetDefaultReq extends MessageMicro<oidb_0x8b8$SetDefaultReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_default_id"}, new Object[]{0}, oidb_0x8b8$SetDefaultReq.class);
    public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
}
