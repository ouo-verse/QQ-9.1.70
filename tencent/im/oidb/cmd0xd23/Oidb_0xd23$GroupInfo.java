package tencent.im.oidb.cmd0xd23;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd23$GroupInfo extends MessageMicro<Oidb_0xd23$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_code", "group_name"}, new Object[]{0L, ""}, Oidb_0xd23$GroupInfo.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBStringField group_name = PBField.initString("");
}
