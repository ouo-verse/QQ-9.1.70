package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class GatewayVerify$RspBodySelfPhone extends MessageMicro<GatewayVerify$RspBodySelfPhone> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98, 106}, new String[]{"msg_rsp_check_phone", "msg_rsp_get_url", "msg_rsp_get_url_v4", "msg_rsp_phone_login"}, new Object[]{null, null, null, null}, GatewayVerify$RspBodySelfPhone.class);
    public GatewayVerify$RspBodySelfPhoneCheck msg_rsp_check_phone = new MessageMicro<GatewayVerify$RspBodySelfPhoneCheck>() { // from class: tencent.im.login.GatewayVerify$RspBodySelfPhoneCheck
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 96, 104}, new String[]{"str_upload_redirect_url", "str_msg_id", "int32_channel_id", "int32_channel_carrier_type"}, new Object[]{"", "", 0, 0}, GatewayVerify$RspBodySelfPhoneCheck.class);
        public final PBStringField str_upload_redirect_url = PBField.initString("");
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
        public final PBInt32Field int32_channel_carrier_type = PBField.initInt32(0);
    };
    public GatewayVerify$RspBodySelfPhoneGetUrl msg_rsp_get_url = new MessageMicro<GatewayVerify$RspBodySelfPhoneGetUrl>() { // from class: tencent.im.login.GatewayVerify$RspBodySelfPhoneGetUrl
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 96}, new String[]{"str_upload_url", "str_msg_id", "int32_channel_id"}, new Object[]{"", "", 0}, GatewayVerify$RspBodySelfPhoneGetUrl.class);
        public final PBStringField str_upload_url = PBField.initString("");
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBInt32Field int32_channel_id = PBField.initInt32(0);
    };
    public GatewayVerify$RspBodySelfPhoneGetUrlV4 msg_rsp_get_url_v4 = new MessageMicro<GatewayVerify$RspBodySelfPhoneGetUrlV4>() { // from class: tencent.im.login.GatewayVerify$RspBodySelfPhoneGetUrlV4
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90}, new String[]{"str_msg_id", "rpt_self_phone_url"}, new Object[]{"", null}, GatewayVerify$RspBodySelfPhoneGetUrlV4.class);
        public final PBStringField str_msg_id = PBField.initString("");
        public final PBRepeatMessageField<GatewayVerify$SelfPhoneUrl> rpt_self_phone_url = PBField.initRepeatMessage(GatewayVerify$SelfPhoneUrl.class);
    };
    public GatewayVerify$RspBodySelfPhoneLogin msg_rsp_phone_login = new GatewayVerify$RspBodySelfPhoneLogin();
}
