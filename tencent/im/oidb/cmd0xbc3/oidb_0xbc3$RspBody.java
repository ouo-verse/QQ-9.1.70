package tencent.im.oidb.cmd0xbc3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbc3$RspBody extends MessageMicro<oidb_0xbc3$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_cur_count", "uint32_total_count"}, new Object[]{0, 0}, oidb_0xbc3$RspBody.class);
    public final PBUInt32Field uint32_cur_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
}
