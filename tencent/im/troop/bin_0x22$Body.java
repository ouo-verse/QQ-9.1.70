package tencent.im.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class bin_0x22$Body extends MessageMicro<bin_0x22$Body> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"group_code", "group_type", "member_uid", "opt", "msg_body"}, new Object[]{0L, 0L, "", 0L, ""}, bin_0x22$Body.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field group_type = PBField.initUInt64(0);
    public final PBStringField member_uid = PBField.initString("");
    public final PBUInt64Field opt = PBField.initUInt64(0);
    public final PBStringField msg_body = PBField.initString("");
}
