package tencent.im.oidb.cmd0xb77;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$ReqBody extends MessageMicro<oidb_cmd0xb77$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 80, 88, 98, 106, 114, 122, 130, 138, 146, 152}, new String[]{"appid", "app_type", "msg_style", "sender_uin", "client_info", "text_msg", "ext_info", "send_type", "recv_uin", "rich_msg_body", "ark_msg_body", "recv_openid", "arkv1_msg_body", "ark_json_body", "xml_msg_body", "mini_app_msg_body", "recv_guild_id"}, new Object[]{0L, 0, 0, 0L, null, "", null, 0, 0L, null, null, "", null, null, null, null, 0L}, oidb_cmd0xb77$ReqBody.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field msg_style = PBField.initUInt32(0);
    public final PBUInt64Field sender_uin = PBField.initUInt64(0);
    public oidb_cmd0xb77$ClientInfo client_info = new oidb_cmd0xb77$ClientInfo();
    public final PBStringField text_msg = PBField.initString("");
    public oidb_cmd0xb77$ExtInfo ext_info = new oidb_cmd0xb77$ExtInfo();
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public oidb_cmd0xb77$RichMsgBody rich_msg_body = new oidb_cmd0xb77$RichMsgBody();
    public oidb_cmd0xb77$ArkMsgBody ark_msg_body = new MessageMicro<oidb_cmd0xb77$ArkMsgBody>() { // from class: tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ArkMsgBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 82, 90, 98, 106, 114, 122, 130, 162}, new String[]{"app", "view", "prompt", "ver", "desc", "feature_id", PublicAccountMessageUtilImpl.META_NAME, "meta_url1", "meta_url2", "meta_url3", "meta_text1", "meta_text2", "meta_text3", DownloadInfo.spKey_Config}, new Object[]{"", "", "", "", "", 0, "", "", "", "", "", "", "", ""}, oidb_cmd0xb77$ArkMsgBody.class);
        public final PBStringField app = PBField.initString("");
        public final PBStringField view = PBField.initString("");
        public final PBStringField prompt = PBField.initString("");
        public final PBStringField ver = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBUInt32Field feature_id = PBField.initUInt32(0);
        public final PBStringField meta = PBField.initString("");
        public final PBStringField meta_url1 = PBField.initString("");
        public final PBStringField meta_url2 = PBField.initString("");
        public final PBStringField meta_url3 = PBField.initString("");
        public final PBStringField meta_text1 = PBField.initString("");
        public final PBStringField meta_text2 = PBField.initString("");
        public final PBStringField meta_text3 = PBField.initString("");
        public final PBStringField config = PBField.initString("");
    };
    public final PBUInt64Field recv_uin = PBField.initUInt64(0);
    public final PBStringField recv_openid = PBField.initString("");
    public oidb_cmd0xb77$ArkV1MsgBody arkv1_msg_body = new oidb_cmd0xb77$ArkV1MsgBody();
    public oidb_cmd0xb77$ArkJsonBody ark_json_body = new oidb_cmd0xb77$ArkJsonBody();
    public oidb_cmd0xb77$XmlMsgBody xml_msg_body = new MessageMicro<oidb_cmd0xb77$XmlMsgBody>() { // from class: tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$XmlMsgBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{88, 98}, new String[]{"service_id", "xml"}, new Object[]{0, ""}, oidb_cmd0xb77$XmlMsgBody.class);
        public final PBUInt32Field service_id = PBField.initUInt32(0);
        public final PBStringField xml = PBField.initString("");
    };
    public oidb_cmd0xb77$MiniAppMsgBody mini_app_msg_body = new oidb_cmd0xb77$MiniAppMsgBody();
    public final PBUInt64Field recv_guild_id = PBField.initUInt64(0);
}
