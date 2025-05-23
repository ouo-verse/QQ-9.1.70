package tencent.im.oidb.cmd0x6e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6e7$RspBody extends MessageMicro<oidb_0x6e7$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_is_white", "uint32_interval", "int64_data"}, new Object[]{0, 0, 0L}, oidb_0x6e7$RspBody.class);
    public final PBUInt32Field uint32_is_white = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
    public final PBInt64Field int64_data = PBField.initInt64(0);
}
