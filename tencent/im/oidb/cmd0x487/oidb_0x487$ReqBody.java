package tencent.im.oidb.cmd0x487;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x487$ReqBody extends MessageMicro<oidb_0x487$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_channel", "uint64_group", "uint64_subscribe_code"}, new Object[]{0, 0L, 0L}, oidb_0x487$ReqBody.class);
    public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0);
    public final PBUInt64Field uint64_subscribe_code = PBField.initUInt64(0);
}
