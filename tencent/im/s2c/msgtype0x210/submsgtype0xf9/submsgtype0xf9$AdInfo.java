package tencent.im.s2c.msgtype0x210.submsgtype0xf9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xf9$AdInfo extends MessageMicro<submsgtype0xf9$AdInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90, 96, 104, 112}, new String[]{"uint64_from_uin", "str_nick", "str_head_url", "str_brief", "str_action", "uint32_flag", "uint32_serviceID", "uint32_templateID", "str_url", "msg_msgCommonData", "rpt_msg_video", "uint32_pushTime", "uint32_invalidTime", "uint32_maxExposureTime"}, new Object[]{0L, "", "", "", "", 0, 0, 0, "", null, null, 0, 0, 0}, submsgtype0xf9$AdInfo.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBStringField str_nick = PBField.initString("");
    public final PBStringField str_head_url = PBField.initString("");
    public final PBStringField str_brief = PBField.initString("");
    public final PBStringField str_action = PBField.initString("");
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_serviceID = PBField.initUInt32(0);
    public final PBUInt32Field uint32_templateID = PBField.initUInt32(0);
    public final PBStringField str_url = PBField.initString("");
    public submsgtype0xf9$MsgCommonData msg_msgCommonData = new MessageMicro<submsgtype0xf9$MsgCommonData>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9$MsgCommonData
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField str_adId = PBField.initString("");
        public final PBStringField str_adPosId = PBField.initString("");
        public final PBBoolField bool_bannerShow = PBField.initBool(false);
        public final PBUInt32Field uint32_bannertype = PBField.initUInt32(0);
        public final PBUInt32Field uint32_jumpType = PBField.initUInt32(0);
        public final PBStringField str_jumpUrl = PBField.initString("");
        public final PBStringField str_appId = PBField.initString("");
        public final PBStringField str_appName = PBField.initString("");
        public final PBStringField str_packagename = PBField.initString("");
        public final PBStringField str_androidDownloadUrl = PBField.initString("");
        public final PBStringField str_scheme = PBField.initString("");
        public final PBStringField str_iosDownloadUrl = PBField.initString("");
        public final PBStringField str_bannerImgUrl = PBField.initString("");
        public final PBStringField str_bannerText = PBField.initString("");
        public final PBStringField str_bannerButtonText = PBField.initString("");
        public final PBBoolField bool_silentDownload = PBField.initBool(false);
        public final PBUInt32Field uint32_audioSwitchType = PBField.initUInt32(0);
        public final PBUInt32Field uint32_preDownloadType = PBField.initUInt32(0);
        public final PBStringField str_reportLink = PBField.initString("");
        public final PBBoolField bool_horizontalVideo = PBField.initBool(false);
        public final PBUInt32Field uint32_audioFadeinDuration = PBField.initUInt32(0);
        public final PBStringField str_openJumpUrlGuide = PBField.initString("");
        public final PBStringField str_myappDownloadUrl = PBField.initString("");
        public final PBStringField str_jumpTypeParams = PBField.initString("");
        public final PBUInt32Field uint32_scrollUpToJump = PBField.initUInt32(0);
        public final PBUInt32Field uint32_controlVariable = PBField.initUInt32(0);
        public final PBUInt32Field uint32_autoJump = PBField.initUInt32(0);
        public final PBStringField str_clickLink = PBField.initString("");
        public final PBUInt32Field uint32_monitorType = PBField.initUInt32(0);
        public final PBStringField str_share_nick = PBField.initString("");
        public final PBStringField str_share_ad_head_url = PBField.initString("");
        public final PBStringField str_share_ad_brief = PBField.initString("");
        public final PBStringField str_share_ad_txt = PBField.initString("");
        public final PBStringField str_share_ad_icon_url = PBField.initString("");
        public final PBStringField str_share_jump_url = PBField.initString("");
        public final PBUInt32Field uint32_control_plugin_time = PBField.initUInt32(0);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 128, 136, 144, 154, 160, 168, 178, 186, 194, 200, 208, 216, 226, 232, 242, 250, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, 288}, new String[]{"str_adId", "str_adPosId", "bool_bannerShow", "uint32_bannertype", "uint32_jumpType", "str_jumpUrl", "str_appId", "str_appName", "str_packagename", "str_androidDownloadUrl", "str_scheme", "str_iosDownloadUrl", "str_bannerImgUrl", "str_bannerText", "str_bannerButtonText", "bool_silentDownload", "uint32_audioSwitchType", "uint32_preDownloadType", "str_reportLink", "bool_horizontalVideo", "uint32_audioFadeinDuration", "str_openJumpUrlGuide", "str_myappDownloadUrl", "str_jumpTypeParams", "uint32_scrollUpToJump", "uint32_controlVariable", "uint32_autoJump", "str_clickLink", "uint32_monitorType", "str_share_nick", "str_share_ad_head_url", "str_share_ad_brief", "str_share_ad_txt", "str_share_ad_icon_url", "str_share_jump_url", "uint32_control_plugin_time"}, new Object[]{"", "", bool, 0, 0, "", "", "", "", "", "", "", "", "", "", bool, 0, 0, "", bool, 0, "", "", "", 0, 0, 0, "", 0, "", "", "", "", "", "", 0}, submsgtype0xf9$MsgCommonData.class);
        }
    };
    public final PBRepeatMessageField<submsgtype0xf9$Video> rpt_msg_video = PBField.initRepeatMessage(submsgtype0xf9$Video.class);
    public final PBUInt32Field uint32_pushTime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_invalidTime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_maxExposureTime = PBField.initUInt32(0);
}
