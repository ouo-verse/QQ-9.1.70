package tencent.im.oidb.cmd0xd6b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xd6b$ReqBody extends MessageMicro<Oidb_0xd6b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 88}, new String[]{"max_pkg_size", "start_time", "cmd_version", "rpt_uin_list"}, new Object[]{0, 0, "", 0L}, Oidb_0xd6b$ReqBody.class);
    public final PBUInt32Field max_pkg_size = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBStringField cmd_version = PBField.initString("");
    public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
