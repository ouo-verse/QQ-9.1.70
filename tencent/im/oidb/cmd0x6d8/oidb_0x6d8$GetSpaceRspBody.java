package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6d8$GetSpaceRspBody extends MessageMicro<oidb_0x6d8$GetSpaceRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48}, new String[]{"int32_ret_code", "str_ret_msg", "str_client_wording", "uint64_total_space", "uint64_used_space", "bool_all_upload"}, new Object[]{0, "", "", 0L, 0L, Boolean.FALSE}, oidb_0x6d8$GetSpaceRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0);
    public final PBBoolField bool_all_upload = PBField.initBool(false);
}
