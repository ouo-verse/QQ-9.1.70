package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqCmd23 extends MessageMicro<GatewayVerify$ReqCmd23> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82}, new String[]{"bool_support_abolish_switch_of_phone_login", "msg_req_tim_wechat"}, new Object[]{Boolean.FALSE, null}, GatewayVerify$ReqCmd23.class);
    public final PBBoolField bool_support_abolish_switch_of_phone_login = PBField.initBool(false);
    public GatewayVerify$ReqTimWeChat msg_req_tim_wechat = new MessageMicro<GatewayVerify$ReqTimWeChat>() { // from class: tencent.im.login.GatewayVerify$ReqTimWeChat
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80}, new String[]{"uint32_support_mobile_register"}, new Object[]{0}, GatewayVerify$ReqTimWeChat.class);
        public final PBUInt32Field uint32_support_mobile_register = PBField.initUInt32(0);
    };
}
