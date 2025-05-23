package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e7$UserZanInfo extends MessageMicro<oidb_0x8e7$UserZanInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uint64_uin", "uint64_tinyid", "uint64_free_zan", "uint64_pay_zan", "uint64_pay_stock"}, new Object[]{0L, 0L, 0L, 0L, 0L}, oidb_0x8e7$UserZanInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_free_zan = PBField.initUInt64(0);
    public final PBUInt64Field uint64_pay_zan = PBField.initUInt64(0);
    public final PBUInt64Field uint64_pay_stock = PBField.initUInt64(0);
}
