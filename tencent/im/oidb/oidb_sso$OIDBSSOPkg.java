package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_sso$OIDBSSOPkg extends MessageMicro<oidb_sso$OIDBSSOPkg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 90}, new String[]{"uint32_command", "uint32_service_type", "uint32_result", "bytes_bodybuffer", "str_error_msg", "str_client_version", "trpc_trans_info"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY, "", "", null}, oidb_sso$OIDBSSOPkg.class);
    public final PBUInt32Field uint32_command = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_bodybuffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBStringField str_client_version = PBField.initString("");
    public final PBRepeatMessageField<oidb_sso$MetaData> trpc_trans_info = PBField.initRepeatMessage(oidb_sso$MetaData.class);
}
