package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac6$operate_result extends MessageMicro<cmd0xac6$operate_result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_id", "int32_result", "str_errmsg"}, new Object[]{0, 0, ""}, cmd0xac6$operate_result.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBStringField str_errmsg = PBField.initString("");
}
