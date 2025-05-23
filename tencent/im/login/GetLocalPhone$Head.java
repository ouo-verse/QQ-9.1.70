package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class GetLocalPhone$Head extends MessageMicro<GetLocalPhone$Head> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 56, 64, 74}, new String[]{"uint32_appid", "str_account", "uint32_err_code", "str_err_msg", "str_guid", "uint32_client_version", "uint32_account_type", "uint32_service_type", "msg_client_info"}, new Object[]{0, "", 0, "", "", 0, 0, 0, null}, GetLocalPhone$Head.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBStringField str_account = PBField.initString("");
    public final PBUInt32Field uint32_err_code = PBField.initUInt32(0);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_guid = PBField.initString("");
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
    public GetLocalPhone$ClientInfo msg_client_info = new MessageMicro<GetLocalPhone$ClientInfo>() { // from class: tencent.im.login.GetLocalPhone$ClientInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 88, 98, 106}, new String[]{"uint32_appid", "uint32_subappid", "str_appname", "str_client_plat_form"}, new Object[]{0, 0, "", ""}, GetLocalPhone$ClientInfo.class);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        public final PBUInt32Field uint32_subappid = PBField.initUInt32(0);
        public final PBStringField str_appname = PBField.initString("");
        public final PBStringField str_client_plat_form = PBField.initString("");
    };
}
