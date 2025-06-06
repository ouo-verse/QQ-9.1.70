package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GetLocalPhone$GetUrlReq extends MessageMicro<GetLocalPhone$GetUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "msg_get_url_req_body"}, new Object[]{null, null}, GetLocalPhone$GetUrlReq.class);
    public GetLocalPhone$Head msg_head = new GetLocalPhone$Head();
    public GetLocalPhone$GetUrlReqBody msg_get_url_req_body = new MessageMicro<GetLocalPhone$GetUrlReqBody>() { // from class: tencent.im.login.GetLocalPhone$GetUrlReqBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 64, 72, 82, 88, 98, 106, 114, 120, 136}, new String[]{"str_app_class", "str_app_sub_id", "str_app_sub_id_ext", "int_client_type", "str_seq_no", "str_mobile_phone", "int_isp_type", "int_business_type", "int_user_id_type", "str_user_id", "int_device_id_type", "str_device_id", "str_cell_ip", "str_user_ip", "int64_timestamp", "mobile_version"}, new Object[]{"", "", "", 0, "", "", 0, 0, 0, "", 0, "", "", "", 0L, 0}, GetLocalPhone$GetUrlReqBody.class);
        public final PBStringField str_app_class = PBField.initString("");
        public final PBStringField str_app_sub_id = PBField.initString("");
        public final PBStringField str_app_sub_id_ext = PBField.initString("");
        public final PBInt32Field int_client_type = PBField.initInt32(0);
        public final PBStringField str_seq_no = PBField.initString("");
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBInt32Field int_isp_type = PBField.initInt32(0);
        public final PBInt32Field int_business_type = PBField.initInt32(0);
        public final PBInt32Field int_user_id_type = PBField.initInt32(0);
        public final PBStringField str_user_id = PBField.initString("");
        public final PBInt32Field int_device_id_type = PBField.initInt32(0);
        public final PBStringField str_device_id = PBField.initString("");
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBStringField str_user_ip = PBField.initString("");
        public final PBInt64Field int64_timestamp = PBField.initInt64(0);
        public final PBEnumField mobile_version = PBField.initEnum(0);
    };
}
