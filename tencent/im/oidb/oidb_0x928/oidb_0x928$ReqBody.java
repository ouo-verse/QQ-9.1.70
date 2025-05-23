package tencent.im.oidb.oidb_0x928;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x928$ReqBody extends MessageMicro<oidb_0x928$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"group_id", "platform", "version"}, new Object[]{0L, 0, ""}, oidb_0x928$ReqBody.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
}
