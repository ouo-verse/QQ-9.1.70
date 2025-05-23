package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x59f$ReqBody extends MessageMicro<oidb_0x59f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_contact_right", "uint32_from_pad"}, new Object[]{0, 0}, oidb_0x59f$ReqBody.class);
    public final PBUInt32Field uint32_contact_right = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_pad = PBField.initUInt32(0);
}
