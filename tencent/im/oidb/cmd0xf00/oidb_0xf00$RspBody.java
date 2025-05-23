package tencent.im.oidb.cmd0xf00;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf00$RspBody extends MessageMicro<oidb_0xf00$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group_code", "int32_result"}, new Object[]{0L, 0}, oidb_0xf00$RspBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBInt32Field int32_result = PBField.initInt32(0);
}
