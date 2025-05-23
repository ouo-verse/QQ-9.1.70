package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class GetLocalPhone$GetPhoneReq extends MessageMicro<GetLocalPhone$GetPhoneReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "msg_get_phone_req_body"}, new Object[]{null, null}, GetLocalPhone$GetPhoneReq.class);
    public GetLocalPhone$Head msg_head = new GetLocalPhone$Head();
    public GetLocalPhone$GetPhoneReqBody msg_get_phone_req_body = new MessageMicro<GetLocalPhone$GetPhoneReqBody>() { // from class: tencent.im.login.GetLocalPhone$GetPhoneReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 64, 74, 80, 90, 98, 106, 112, 122, 130, 138, 144}, new String[]{"str_app_class", "str_app_sub_id", "str_app_sub_id_ext", "str_msg_id", "str_seq_no", "int_user_id_type", "str_user_id", "int_device_id_type", "str_device_id", "int32_phone_data_type", "rpt_local_code_data", "str_cell_ip", "str_user_ip", "int64_timestamp", "str_process_cookies", "str_mask_phone", "msg_auth_device_req", "mobile_version"}, new Object[]{"", "", "", "", "", 0, "", 0, "", 0, null, "", "", 0L, "", "", null, 0}, GetLocalPhone$GetPhoneReqBody.class);
        public final PBStringField str_app_class = PBField.initString("");
        public final PBStringField str_app_sub_id = PBField.initString("");
        public final PBStringField str_app_sub_id_ext = PBField.initString("");
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBStringField str_seq_no = PBField.initString("");
        public final PBInt32Field int_user_id_type = PBField.initInt32(0);
        public final PBStringField str_user_id = PBField.initString("");
        public final PBInt32Field int_device_id_type = PBField.initInt32(0);
        public final PBStringField str_device_id = PBField.initString("");
        public final PBInt32Field int32_phone_data_type = PBField.initInt32(0);
        public final PBRepeatMessageField<GetLocalPhone$LocalPhoneCodeData> rpt_local_code_data = PBField.initRepeatMessage(GetLocalPhone$LocalPhoneCodeData.class);
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBStringField str_user_ip = PBField.initString("");
        public final PBInt64Field int64_timestamp = PBField.initInt64(0);
        public final PBStringField str_process_cookies = PBField.initString("");
        public final PBStringField str_mask_phone = PBField.initString("");
        public GetLocalPhone$AuthDeviceReqBody msg_auth_device_req = new MessageMicro<GetLocalPhone$AuthDeviceReqBody>() { // from class: tencent.im.login.GetLocalPhone$AuthDeviceReqBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"str_guid", "uint32_appid", "uint32_subappid", "str_appname"}, new Object[]{"", 0, 0, ""}, GetLocalPhone$AuthDeviceReqBody.class);
            public final PBStringField str_guid = PBField.initString("");
            public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
            public final PBUInt32Field uint32_subappid = PBField.initUInt32(0);
            public final PBStringField str_appname = PBField.initString("");
        };
        public final PBEnumField mobile_version = PBField.initEnum(0);
    };
}
