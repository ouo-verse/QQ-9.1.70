package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class GatewayVerify$ReqBodySelfPhone extends MessageMicro<GatewayVerify$ReqBodySelfPhone> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 106, 114}, new String[]{"msg_req_check_phone", "msg_req_get_url", "msg_req_check_phone_v4", "msg_req_get_url_v4", "msg_req_phone_login"}, new Object[]{null, null, null, null, null}, GatewayVerify$ReqBodySelfPhone.class);
    public GatewayVerify$ReqBodySelfPhoneCheck msg_req_check_phone = new MessageMicro<GatewayVerify$ReqBodySelfPhoneCheck>() { // from class: tencent.im.login.GatewayVerify$ReqBodySelfPhoneCheck
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 104, 114}, new String[]{"str_upurl", "str_token", "str_msg_id", "int32_channel_id", "str_cell_ip"}, new Object[]{"", "", "", 0, ""}, GatewayVerify$ReqBodySelfPhoneCheck.class);
        public final PBStringField str_upurl = PBField.initString("");
        public final PBStringField str_token = PBField.initString("");
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
        public final PBStringField str_cell_ip = PBField.initString("");
    };
    public GatewayVerify$ReqBodySelfPhoneGetUrl msg_req_get_url = new MessageMicro<GatewayVerify$ReqBodySelfPhoneGetUrl>() { // from class: tencent.im.login.GatewayVerify$ReqBodySelfPhoneGetUrl
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 98, 104}, new String[]{"uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type"}, new Object[]{0, "", "", 0}, GatewayVerify$ReqBodySelfPhoneGetUrl.class);
        public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
    };
    public GatewayVerify$ReqBodySelfPhoneCheckV4 msg_req_check_phone_v4 = new MessageMicro<GatewayVerify$ReqBodySelfPhoneCheckV4>() { // from class: tencent.im.login.GatewayVerify$ReqBodySelfPhoneCheckV4
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"str_msg_id", "str_cell_ip", "rpt_self_phone_token"}, new Object[]{"", "", null}, GatewayVerify$ReqBodySelfPhoneCheckV4.class);
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBRepeatMessageField<GatewayVerify$SelfPhoneToken> rpt_self_phone_token = PBField.initRepeatMessage(GatewayVerify$SelfPhoneToken.class);
    };
    public GatewayVerify$ReqBodySelfPhoneGetUrlV4 msg_req_get_url_v4 = new MessageMicro<GatewayVerify$ReqBodySelfPhoneGetUrlV4>() { // from class: tencent.im.login.GatewayVerify$ReqBodySelfPhoneGetUrlV4
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80, 90, 98, 104}, new String[]{"uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type"}, new Object[]{0, "", "", 0}, GatewayVerify$ReqBodySelfPhoneGetUrlV4.class);
        public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
        public final PBStringField str_mobile_phone = PBField.initString("");
        public final PBStringField str_cell_ip = PBField.initString("");
        public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
    };
    public GatewayVerify$ReqBodySelfPhoneLogin msg_req_phone_login = new GatewayVerify$ReqBodySelfPhoneLogin();
}
