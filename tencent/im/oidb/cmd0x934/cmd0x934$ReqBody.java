package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x934$ReqBody extends MessageMicro<cmd0x934$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"cmd", "group_id", "version", "keyword", "robot_uin"}, new Object[]{0, 0L, 0, "", 0L}, cmd0x934$ReqBody.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBStringField keyword = PBField.initString("");
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
}
