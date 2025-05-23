package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d6$ReqBody extends MessageMicro<oidb_0x5d6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_seq", "rpt_msg_update_buffer", "uint32_domain"}, new Object[]{0, null, 0}, oidb_0x5d6$ReqBody.class);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x5d6$SnsUpateBuffer> rpt_msg_update_buffer = PBField.initRepeatMessage(oidb_0x5d6$SnsUpateBuffer.class);
    public final PBUInt32Field uint32_domain = PBField.initUInt32(0);
}
