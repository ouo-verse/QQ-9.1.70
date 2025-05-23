package tencent.im.oidb.cmd0xed1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xed1$ReqBody extends MessageMicro<oidb_0xed1$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{338280, 338896, 339424, 339432, 339440, 339920, 360816}, new String[]{"uint32_simple_mode", "uint32_learn_mode", "uint32_other_can_search", "uint32_can_join_group", "uint32_can_search", "uint32_need_verify", "uint32_elder_mode"}, new Object[]{0, 0, 0, 0, 0, 0, 0}, oidb_0xed1$ReqBody.class);
    public final PBUInt32Field uint32_simple_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_learn_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_other_can_search = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_join_group = PBField.initUInt32(0);
    public final PBUInt32Field uint32_can_search = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_verify = PBField.initUInt32(0);
    public final PBUInt32Field uint32_elder_mode = PBField.initUInt32(0);
}
