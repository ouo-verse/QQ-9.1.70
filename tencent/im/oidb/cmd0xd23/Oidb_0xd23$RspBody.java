package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd23$RspBody extends MessageMicro<Oidb_0xd23$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"bind_flag", "group_code"}, new Object[]{0, 0L}, Oidb_0xd23$RspBody.class);
    public final PBUInt32Field bind_flag = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
