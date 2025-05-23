package tencent.im.oidb.cmd0x91b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x91b$ReqBody extends MessageMicro<cmd0x91b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"uint64_group_code", "info", "uint32_source", "uint32_notify_aio_flag", "str_user_data"}, new Object[]{0L, null, 0, 0, ""}, cmd0x91b$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public oidb_0x88d$GroupInfo info = new oidb_0x88d$GroupInfo();
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notify_aio_flag = PBField.initUInt32(0);
    public final PBStringField str_user_data = PBField.initString("");
}
