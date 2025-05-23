package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$RspTipsInfo extends MessageMicro<GatewayVerify$RspTipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 74}, new String[]{"uint32_scene_id", "str_review_protect_url", "uint32_guid_to_main_login_flag", "str_guid_to_main_login_wording", "msg_left_button", "msg_right_button", "str_title", "str_content", "msg_buttons"}, new Object[]{0, "", 0, "", null, null, "", "", null}, GatewayVerify$RspTipsInfo.class);
    public final PBUInt32Field uint32_scene_id = PBField.initUInt32(0);
    public final PBStringField str_review_protect_url = PBField.initString("");
    public final PBUInt32Field uint32_guid_to_main_login_flag = PBField.initUInt32(0);
    public final PBStringField str_guid_to_main_login_wording = PBField.initString("");
    public GatewayVerify$Button msg_left_button = new GatewayVerify$Button();
    public GatewayVerify$Button msg_right_button = new GatewayVerify$Button();
    public final PBStringField str_title = PBField.initString("");
    public final PBStringField str_content = PBField.initString("");
    public final PBRepeatMessageField<GatewayVerify$Button> msg_buttons = PBField.initRepeatMessage(GatewayVerify$Button.class);
}
