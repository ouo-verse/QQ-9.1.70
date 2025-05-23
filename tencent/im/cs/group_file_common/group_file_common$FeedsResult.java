package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_file_common$FeedsResult extends MessageMicro<group_file_common$FeedsResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"int32_ret_code", "str_detail", "str_file_id", "uint32_bus_id", "uint32_dead_time"}, new Object[]{0, "", "", 0, 0}, group_file_common$FeedsResult.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_detail = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
}
