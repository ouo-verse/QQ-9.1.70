package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd68$ForwardGroupRspBody extends MessageMicro<oidb_cmd0xd68$ForwardGroupRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "bytes_save_file_path", "uint32_bus_id"}, new Object[]{0, "", "", ByteStringMicro.EMPTY, 0}, oidb_cmd0xd68$ForwardGroupRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBBytesField bytes_save_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
}
