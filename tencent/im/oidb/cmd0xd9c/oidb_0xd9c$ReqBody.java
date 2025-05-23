package tencent.im.oidb.cmd0xd9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd9c$ReqBody extends MessageMicro<oidb_0xd9c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"uint64_uin", "uint32_start", "uint32_want", "rpt_frd_uins", "uint32_need_wording", "uint32_need_desc", "uint32_basic_source"}, new Object[]{0L, 0, 0, 0L, 0, 0, 0}, oidb_0xd9c$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_frd_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_need_wording = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_desc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_basic_source = PBField.initUInt32(0);
}
