package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5e0$GenderFiled extends MessageMicro<Oidb_0x5e0$GenderFiled> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint32_gender"}, new Object[]{0L, 0}, Oidb_0x5e0$GenderFiled.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
}
