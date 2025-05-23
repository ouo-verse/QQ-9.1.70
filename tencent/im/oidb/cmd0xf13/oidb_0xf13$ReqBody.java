package tencent.im.oidb.cmd0xf13;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf13$ReqBody extends MessageMicro<oidb_0xf13$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_guidecardid", "uint32_guidecardtype", "uint32_operation"}, new Object[]{0L, 0, 0, 0}, oidb_0xf13$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_guidecardid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_guidecardtype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_operation = PBField.initUInt32(0);
}
