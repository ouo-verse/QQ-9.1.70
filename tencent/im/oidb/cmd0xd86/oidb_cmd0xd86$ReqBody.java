package tencent.im.oidb.cmd0xd86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd86$ReqBody extends MessageMicro<oidb_cmd0xd86$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uin", "blocked_uin", "source_id", "sub_sourceid", "group_uin"}, new Object[]{0L, 0L, 0, 0, 0L}, oidb_cmd0xd86$ReqBody.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field blocked_uin = PBField.initUInt64(0);
    public final PBUInt32Field source_id = PBField.initUInt32(0);
    public final PBUInt32Field sub_sourceid = PBField.initUInt32(0);
    public final PBUInt64Field group_uin = PBField.initUInt64(0);
}
