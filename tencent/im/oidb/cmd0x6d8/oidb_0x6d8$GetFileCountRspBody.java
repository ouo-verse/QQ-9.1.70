package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d8$GetFileCountRspBody extends MessageMicro<oidb_0x6d8$GetFileCountRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBBoolField bool_file_too_many = PBField.initBool(false);
    public final PBUInt32Field uint32_limit_count = PBField.initUInt32(0);
    public final PBBoolField bool_is_full = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "uint32_all_file_count", "bool_file_too_many", "uint32_limit_count", "bool_is_full"}, new Object[]{0, "", "", 0, bool, 0, bool}, oidb_0x6d8$GetFileCountRspBody.class);
    }
}
