package tencent.im.oidb;

import com.tencent.luggage.wxa.uf.h;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqconnect$Appinfo extends MessageMicro<qqconnect$Appinfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 58, 66, 74, 82, 90, 98, 106, 168, 176, 184, 194, 202, 208, 218, 226, 232, 240, 248, 258, 264, 802, 810, 818, BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO, 834, h.CTRL_INDEX, 850}, new String[]{"appid", "app_type", "platform", "app_name", "app_key", TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_APP_STATE, "iphone_url_scheme", "android_pack_name", "icon_url", AppConstants.Key.SHARE_SOURCE_URL, "icon_small_url", "icon_middle_url", "tencent_docs_appinfo", "developer_uin", "app_class", "app_subclass", "remark", "icon_mini_url", "auth_time", "app_url", "universal_link", "qqconnect_feature", "is_hatchery", "test_uin_list", "edit_universal_link", "company_id", "template_msg_config", "mini_app_info", "web_app_info", "mobile_app_info", "windows_app_info", "robot_app_info", "qun_pro_robot_app_info"}, new Object[]{0, 0, 0, "", "", 0, "", "", "", "", "", "", null, 0L, 0, 0, "", "", 0L, "", "", 0, 0, 0L, "", 0L, null, null, null, null, null, null, null}, qqconnect$Appinfo.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField app_name = PBField.initString("");
    public final PBStringField app_key = PBField.initString("");
    public final PBUInt32Field app_state = PBField.initUInt32(0);
    public final PBStringField iphone_url_scheme = PBField.initString("");
    public final PBStringField android_pack_name = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField source_url = PBField.initString("");
    public final PBStringField icon_small_url = PBField.initString("");
    public final PBStringField icon_middle_url = PBField.initString("");
    public qqconnect$TencentDocsAppinfo tencent_docs_appinfo = new MessageMicro<qqconnect$TencentDocsAppinfo>() { // from class: tencent.im.oidb.qqconnect$TencentDocsAppinfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"open_types", "opts", "ejs", "callback_url_test", "callback_url", "domain", "userinfo_callback", "userinfo_callback_test"}, new Object[]{"", "", "", "", "", "", "", ""}, qqconnect$TencentDocsAppinfo.class);
        public final PBStringField open_types = PBField.initString("");
        public final PBStringField opts = PBField.initString("");
        public final PBStringField ejs = PBField.initString("");
        public final PBStringField callback_url_test = PBField.initString("");
        public final PBStringField callback_url = PBField.initString("");
        public final PBStringField domain = PBField.initString("");
        public final PBStringField userinfo_callback = PBField.initString("");
        public final PBStringField userinfo_callback_test = PBField.initString("");
    };
    public final PBUInt64Field developer_uin = PBField.initUInt64(0);
    public final PBUInt32Field app_class = PBField.initUInt32(0);
    public final PBUInt32Field app_subclass = PBField.initUInt32(0);
    public final PBStringField remark = PBField.initString("");
    public final PBStringField icon_mini_url = PBField.initString("");
    public final PBUInt64Field auth_time = PBField.initUInt64(0);
    public final PBStringField app_url = PBField.initString("");
    public final PBStringField universal_link = PBField.initString("");
    public final PBUInt32Field qqconnect_feature = PBField.initUInt32(0);
    public final PBInt32Field is_hatchery = PBField.initInt32(0);
    public final PBRepeatField<Long> test_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField edit_universal_link = PBField.initString("");
    public final PBUInt64Field company_id = PBField.initUInt64(0);
    public qqconnect$TemplateMsgConfig template_msg_config = new MessageMicro<qqconnect$TemplateMsgConfig>() { // from class: tencent.im.oidb.qqconnect$TemplateMsgConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"service_msg_uin", "public_msg_uin", "camp_msg_uin", "helper_msg_uin"}, new Object[]{0L, 0L, 0L, 0L}, qqconnect$TemplateMsgConfig.class);
        public final PBUInt64Field service_msg_uin = PBField.initUInt64(0);
        public final PBUInt64Field public_msg_uin = PBField.initUInt64(0);
        public final PBUInt64Field camp_msg_uin = PBField.initUInt64(0);
        public final PBUInt64Field helper_msg_uin = PBField.initUInt64(0);
    };
    public qqconnect$MiniAppInfo mini_app_info = new MessageMicro<qqconnect$MiniAppInfo>() { // from class: tencent.im.oidb.qqconnect$MiniAppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 88, 98, 104, 114, 120}, new String[]{"super_uin", "owner_type", "owner_name", "owner_id_card_type", "owner_id_card", "owner_status"}, new Object[]{0L, 0, "", 0, "", 0}, qqconnect$MiniAppInfo.class);
        public final PBUInt64Field super_uin = PBField.initUInt64(0);
        public final PBUInt32Field owner_type = PBField.initUInt32(0);
        public final PBStringField owner_name = PBField.initString("");
        public final PBUInt32Field owner_id_card_type = PBField.initUInt32(0);
        public final PBStringField owner_id_card = PBField.initString("");
        public final PBUInt32Field owner_status = PBField.initUInt32(0);
    };
    public qqconnect$WebAppInfo web_app_info = new MessageMicro<qqconnect$WebAppInfo>() { // from class: tencent.im.oidb.qqconnect$WebAppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"website_url", "provider", "icp", "callback_url", "hw_open_config"}, new Object[]{"", "", "", "", ""}, qqconnect$WebAppInfo.class);
        public final PBStringField website_url = PBField.initString("");
        public final PBStringField provider = PBField.initString("");
        public final PBStringField icp = PBField.initString("");
        public final PBStringField callback_url = PBField.initString("");
        public final PBStringField hw_open_config = PBField.initString("");
    };
    public qqconnect$MobileAppInfo mobile_app_info = new qqconnect$MobileAppInfo();
    public qqconnect$WindowsAppInfo windows_app_info = new MessageMicro<qqconnect$WindowsAppInfo>() { // from class: tencent.im.oidb.qqconnect$WindowsAppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"windows_thumbprints"}, new Object[]{""}, qqconnect$WindowsAppInfo.class);
        public final PBRepeatField<String> windows_thumbprints = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public qqconnect$RobotAppInfo robot_app_info = new MessageMicro<qqconnect$RobotAppInfo>() { // from class: tencent.im.oidb.qqconnect$RobotAppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114}, new String[]{"callback_url", "callback_addr", "callback_url_test", "callback_addr_test"}, new Object[]{"", "", "", ""}, qqconnect$RobotAppInfo.class);
        public final PBStringField callback_url = PBField.initString("");
        public final PBStringField callback_addr = PBField.initString("");
        public final PBStringField callback_url_test = PBField.initString("");
        public final PBStringField callback_addr_test = PBField.initString("");
    };
    public qqconnect$QunProRobotAppInfo qun_pro_robot_app_info = new MessageMicro<qqconnect$QunProRobotAppInfo>() { // from class: tencent.im.oidb.qqconnect$QunProRobotAppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98}, new String[]{"token", "callback_url"}, new Object[]{"", ""}, qqconnect$QunProRobotAppInfo.class);
        public final PBStringField token = PBField.initString("");
        public final PBStringField callback_url = PBField.initString("");
    };
}
