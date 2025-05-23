package tencent.im.s2c.msgtype0x210.submsgtype0x111;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x111$Color extends MessageMicro<SubMsgType0x111$Color> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_r", "uint32_g", "uint32_b"}, new Object[]{0, 0, 0}, SubMsgType0x111$Color.class);
    public final PBUInt32Field uint32_r = PBField.initUInt32(0);
    public final PBUInt32Field uint32_g = PBField.initUInt32(0);
    public final PBUInt32Field uint32_b = PBField.initUInt32(0);
}
