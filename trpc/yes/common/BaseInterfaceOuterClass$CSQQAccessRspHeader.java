package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class BaseInterfaceOuterClass$CSQQAccessRspHeader extends MessageMicro<BaseInterfaceOuterClass$CSQQAccessRspHeader> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"error_code", "error_message", "disply_error_message", "system_error_sub_code", "seq"}, new Object[]{0, "", "", 0, 0L}, BaseInterfaceOuterClass$CSQQAccessRspHeader.class);
    public final PBInt32Field error_code = PBField.initInt32(0);
    public final PBStringField error_message = PBField.initString("");
    public final PBStringField disply_error_message = PBField.initString("");
    public final PBInt32Field system_error_sub_code = PBField.initInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
}
