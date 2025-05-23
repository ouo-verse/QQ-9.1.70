package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$OIDBGetPhoneReq extends MessageMicro<GetLocalPhone$OIDBGetPhoneReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50}, new String[]{"str_session_id", "str_phone_code", "int32_phone_data_type", "str_new_device_check_sig", "bool_compare_mibao", "msg_ldm_sig"}, new Object[]{"", "", 0, "", Boolean.FALSE, null}, GetLocalPhone$OIDBGetPhoneReq.class);
    public final PBStringField str_session_id = PBField.initString("");
    public final PBStringField str_phone_code = PBField.initString("");
    public final PBInt32Field int32_phone_data_type = PBField.initInt32(0);
    public final PBStringField str_new_device_check_sig = PBField.initString("");
    public final PBBoolField bool_compare_mibao = PBField.initBool(false);
    public GetLocalPhone$LdmSigInfo msg_ldm_sig = new GetLocalPhone$LdmSigInfo();
}
