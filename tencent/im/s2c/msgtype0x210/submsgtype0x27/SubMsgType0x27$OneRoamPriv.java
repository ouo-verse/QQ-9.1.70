package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x27$OneRoamPriv extends MessageMicro<SubMsgType0x27$OneRoamPriv> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_fuin", "uint32_priv_tag", "uint32_priv_value"}, new Object[]{0L, 0, 0}, SubMsgType0x27$OneRoamPriv.class);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_priv_tag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_priv_value = PBField.initUInt32(0);
}
