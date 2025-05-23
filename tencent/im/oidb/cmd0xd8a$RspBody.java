package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xd8a$RspBody extends MessageMicro<cmd0xd8a$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_retcode", "str_res"}, new Object[]{0, ""}, cmd0xd8a$RspBody.class);
    public final PBUInt32Field uint32_retcode = PBField.initUInt32(0);
    public final PBStringField str_res = PBField.initString("");
}
