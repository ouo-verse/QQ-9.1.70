package tencent.im.oidb.cmd0x79a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x88d.oidb_0x88d$GroupInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x79a$RspBody extends MessageMicro<oidb_0x79a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 32, 40, 48, 58}, new String[]{"info", "uint32_tribe_status", "uint64_tribe_id", "uint32_modify_countdown", "str_tribe_name"}, new Object[]{null, 0, 0L, 0, ""}, oidb_0x79a$RspBody.class);
    public oidb_0x88d$GroupInfo info = new oidb_0x88d$GroupInfo();
    public final PBUInt32Field uint32_tribe_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tribe_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_modify_countdown = PBField.initUInt32(0);
    public final PBStringField str_tribe_name = PBField.initString("");
}
