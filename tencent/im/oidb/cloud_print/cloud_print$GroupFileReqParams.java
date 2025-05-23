package tencent.im.oidb.cloud_print;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class cloud_print$GroupFileReqParams extends MessageMicro<cloud_print$GroupFileReqParams> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "str_file_name"}, new Object[]{0L, 0, 0, "", ""}, cloud_print$GroupFileReqParams.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
}
