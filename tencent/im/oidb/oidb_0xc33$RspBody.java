package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc33$RspBody extends MessageMicro<oidb_0xc33$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_result", "uint32_next_gap", "uint32_new_user"}, new Object[]{0, 0, 0}, oidb_0xc33$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_gap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_user = PBField.initUInt32(0);
}
