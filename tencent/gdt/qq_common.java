package tencent.gdt;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.view.FilterEnum;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import tencent.gdt.qzap_common;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qq_common {
    public static final int AD_EXTENSION_TYPE_3LINK = 12;
    public static final int AD_EXTENSION_TYPE_ADX = 14;
    public static final int AD_EXTENSION_TYPE_APP_PREORDER = 3;
    public static final int AD_EXTENSION_TYPE_CASH_REWARD = 8;
    public static final int AD_EXTENSION_TYPE_DOODLE = 10;
    public static final int AD_EXTENSION_TYPE_FULL_SCREEN_CLICK = 5;
    public static final int AD_EXTENSION_TYPE_GAME = 16;
    public static final int AD_EXTENSION_TYPE_HTTP_H5_LANDINGPAGE = 18;
    public static final int AD_EXTENSION_TYPE_IPS_NATIVE_SHORT_VIDEO = 20;
    public static final int AD_EXTENSION_TYPE_JD = 11;
    public static final int AD_EXTENSION_TYPE_MENGCENG = 15;
    public static final int AD_EXTENSION_TYPE_NON_AMS_DOMAIN_LANDINGPAGE = 19;
    public static final int AD_EXTENSION_TYPE_NOT_JUMP_OUT = 7;
    public static final int AD_EXTENSION_TYPE_OCPX = 9;
    public static final int AD_EXTENSION_TYPE_PERSONIFY = 2;
    public static final int AD_EXTENSION_TYPE_PLAYABLE = 6;
    public static final int AD_EXTENSION_TYPE_PREVIEW = 4;
    public static final int AD_EXTENSION_TYPE_REWARD = 1;
    public static final int AD_EXTENSION_TYPE_SENSITIVE = 13;
    public static final int AD_EXTENSION_TYPE_SUPPORT_PC_WX_GAME_REWORD = 21;
    public static final int AD_EXTENSION_TYPE_UNKNOWN = 0;
    public static final int AD_EXTENSION_TYPE_XIJING = 17;
    public static final int APP_TAB_DOODLE = 2;
    public static final int APP_TAB_ELSE = 99;
    public static final int APP_TAB_FEEDS = 1;
    public static final int APP_TAB_FREE_MODE = 4;
    public static final int APP_TAB_TASK_CENTER = 3;
    public static final int APP_TAB_UNKNOWN = 0;
    public static final int FLOATING_ZONE_TYPE_IMAGE_TEXT = 1;
    public static final int FLOATING_ZONE_TYPE_MULTI_BUTTON = 3;
    public static final int FLOATING_ZONE_TYPE_SINGLE_IMAGE = 2;
    public static final int FLOATING_ZONE_TYPE_UNKNOWN = 0;
    public static final int HIPPY_TYPE_MATERIAL_STITCH = 5;
    public static final int HIPPY_TYPE_REWARD_BROWSER = 4;
    public static final int HIPPY_TYPE_REWARD_TUWEN = 3;
    public static final int HIPPY_TYPE_REWARD_VIDEO = 2;
    public static final int HIPPY_TYPE_REWARD_WALL = 1;
    public static final int HIPPY_TYPE_UNKNOWN = 0;
    public static final int LINK_TYPE_DEEP_LINK = 2;
    public static final int LINK_TYPE_H5 = 1;
    public static final int LINK_TYPE_MINI_PROGRAM = 3;
    public static final int LINK_TYPE_UNKNOWN = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ArticleSessionInfo extends MessageMicro<ArticleSessionInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104}, new String[]{"latest_click_first_cid", "latest_click_second_cid", "top_click_first_cid", "top_click_second_cid", "interval_top_click_first_cid", "interval_top_click_second_cid", "click_cnt", "exposure_cnt", "duration_sec", "read_chapter", "read_page", "latest_turn_speed_ms", "top_turn_speed_ms"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, ArticleSessionInfo.class);
        public final PBUInt32Field latest_click_first_cid = PBField.initUInt32(0);
        public final PBUInt32Field latest_click_second_cid = PBField.initUInt32(0);
        public final PBUInt32Field top_click_first_cid = PBField.initUInt32(0);
        public final PBUInt32Field top_click_second_cid = PBField.initUInt32(0);
        public final PBUInt32Field interval_top_click_first_cid = PBField.initUInt32(0);
        public final PBUInt32Field interval_top_click_second_cid = PBField.initUInt32(0);
        public final PBUInt32Field click_cnt = PBField.initUInt32(0);
        public final PBUInt32Field exposure_cnt = PBField.initUInt32(0);
        public final PBUInt32Field duration_sec = PBField.initUInt32(0);
        public final PBUInt32Field read_chapter = PBField.initUInt32(0);
        public final PBUInt32Field read_page = PBField.initUInt32(0);
        public final PBUInt32Field latest_turn_speed_ms = PBField.initUInt32(0);
        public final PBUInt32Field top_turn_speed_ms = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DeviceEncryptedData extends MessageMicro<DeviceEncryptedData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"disable_interactive"}, new Object[]{0}, DeviceEncryptedData.class);
        public final PBUInt32Field disable_interactive = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DeviceExt extends MessageMicro<DeviceExt> {
        public static final int APP_DISPLAY_STATE_BACK = 2;
        public static final int APP_DISPLAY_STATE_FRONT = 1;
        public static final int APP_DISPLAY_STATE_UNKNOWN = 0;
        public static final int APP_RUNNING_STATUS_BACKGROUND = 2;
        public static final int APP_RUNNING_STATUS_FOREGROUND = 1;
        public static final int APP_RUNNING_STATUS_UNKNOWN = 0;
        public static final int MQQ_CONFIG_STATUS_FAIL = 2;
        public static final int MQQ_CONFIG_STATUS_SUCCESS = 1;
        public static final int MQQ_CONFIG_STATUS_UNKNOWN = 0;
        public static final int REPORT_SOURCE_COMMON_TANGRAM = 2;
        public static final int REPORT_SOURCE_DYNAMIC = 3;
        public static final int REPORT_SOURCE_H5_SDK_COMMON = 4;
        public static final int REPORT_SOURCE_H5_SDK_QQ = 5;
        public static final int REPORT_SOURCE_QQ_TANGRAM = 1;
        public static final int REPORT_SOURCE_UNKNOWN = 0;
        public static final int SDK_ID_DIFF_TYPE_HAS_DIFF = 4;
        public static final int SDK_ID_DIFF_TYPE_NEITHER_LOST = 1;
        public static final int SDK_ID_DIFF_TYPE_PRIVACY_HAS = 3;
        public static final int SDK_ID_DIFF_TYPE_QQB_HAS = 2;
        public static final int SDK_ID_DIFF_TYPE_SAME = 5;
        public static final int SDK_ID_DIFF_TYPE_UNKNOWN = 0;
        public static final int THUMB_PLAYER = 1;
        public static final int UNKNOWN_TYPE = 0;
        public static final int WECHAT_AUTHORIZATION_STATUS_AUTHORIZED = 1;
        public static final int WECHAT_AUTHORIZATION_STATUS_UNAUTHORIZED = 2;
        public static final int WECHAT_AUTHORIZATION_STATUS_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__;
        public AppStatus app_status = new AppStatus();
        public AttriDeviceInfo attri_info = new AttriDeviceInfo();
        public IosQaidInfo qaid_info = new IosQaidInfo();
        public WechatInstalledInfo wechat_installed_info = new WechatInstalledInfo();
        public final PBEnumField mqq_config_status = PBField.initEnum(0);

        /* renamed from: ei, reason: collision with root package name */
        public final PBStringField f435904ei = PBField.initString("");
        public ExternalExpInfo qqb_external_exp_info = new ExternalExpInfo();
        public final PBUInt32Field sdk_config_ver = PBField.initUInt32(0);
        public qzap_common.HarmonySysInfo harmony_sys_info = new qzap_common.HarmonySysInfo();
        public final PBRepeatMessageField<HevcCompatibilityInfo> hevc_compatibility_info = PBField.initRepeatMessage(HevcCompatibilityInfo.class);
        public final PBBoolField pps = PBField.initBool(false);
        public final PBStringField sdk_muid = PBField.initString("");
        public final PBUInt32Field sdk_muid_type = PBField.initUInt32(0);
        public final PBFloatField font_size = PBField.initFloat(0.0f);
        public SdkIdDiffMap sdk_id_diff_map = new SdkIdDiffMap();
        public final PBEnumField app_running_status = PBField.initEnum(0);
        public final PBEnumField report_source = PBField.initEnum(0);
        public TargetingAbility targeting_ability = new TargetingAbility();
        public ConfigureAbility configure_ability = new ConfigureAbility();
        public final PBBoolField nologin_skip_privacy_types = PBField.initBool(false);
        public final PBBoolField no_rd = PBField.initBool(false);
        public final PBStringField qi36 = PBField.initString("");
        public final PBStringField rd_tag = PBField.initString("");
        public RecommendTag nologin_user_interest_tag = new RecommendTag();
        public HippyConfigParam hippy_config_param = new HippyConfigParam();
        public final PBStringField jsbundle_info = PBField.initString("");
        public final PBStringField module_name = PBField.initString("");
        public final PBRepeatField<Integer> jump_ability = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBStringField m_os = PBField.initString("");
        public final PBStringField dynamic_info = PBField.initString("");
        public final PBBoolField nl_is = PBField.initBool(false);
        public final PBStringField de_data = PBField.initString("");
        public final PBUInt32Field device_model_type = PBField.initUInt32(0);
        public final PBEnumField wechat_authorization_status = PBField.initEnum(0);

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class AppStatus extends MessageMicro<AppStatus> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"installed", "uninstalled"}, new Object[]{"", ""}, AppStatus.class);
            public final PBRepeatField<String> installed;
            public final PBRepeatField<String> uninstalled;

            public AppStatus() {
                PBStringField pBStringField = PBStringField.__repeatHelper__;
                this.installed = PBField.initRepeat(pBStringField);
                this.uninstalled = PBField.initRepeat(pBStringField);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class AttriDeviceInfo extends MessageMicro<AttriDeviceInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"id_info", "sid_h", "uuid", "wm_h", "ua", "iv", "app_bundle_id", "wifi_name", "w_u", "ua_i"}, new Object[]{null, "", null, "", "", "", "", "", "", null}, AttriDeviceInfo.class);
            public final PBRepeatMessageField<IdInfo> id_info = PBField.initRepeatMessage(IdInfo.class);
            public final PBStringField sid_h = PBField.initString("");
            public UUID uuid = new UUID();
            public final PBStringField wm_h = PBField.initString("");

            /* renamed from: ua, reason: collision with root package name */
            public final PBStringField f435906ua = PBField.initString("");

            /* renamed from: iv, reason: collision with root package name */
            public final PBStringField f435905iv = PBField.initString("");
            public final PBStringField app_bundle_id = PBField.initString("");
            public final PBStringField wifi_name = PBField.initString("");
            public final PBStringField w_u = PBField.initString("");
            public UserAgentInfo ua_i = new UserAgentInfo();

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class UserAgentInfo extends MessageMicro<UserAgentInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"s_i", "c_i", "m_t_i"}, new Object[]{null, "", ""}, UserAgentInfo.class);
                public SystemInfo s_i = new SystemInfo();
                public final PBStringField c_i = PBField.initString("");
                public final PBStringField m_t_i = PBField.initString("");

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class SystemInfo extends MessageMicro<SystemInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"b_v_r", "b_m", "b_v_c", "b_i", "sw_s", "b_mf", "b_r_o_c", "jvm_v", "b_v_i"}, new Object[]{"", "", "", "", "", "", "", "", ""}, SystemInfo.class);
                    public final PBStringField b_v_r = PBField.initString("");
                    public final PBStringField b_m = PBField.initString("");
                    public final PBStringField b_v_c = PBField.initString("");
                    public final PBStringField b_i = PBField.initString("");
                    public final PBStringField sw_s = PBField.initString("");
                    public final PBStringField b_mf = PBField.initString("");
                    public final PBStringField b_r_o_c = PBField.initString("");
                    public final PBStringField jvm_v = PBField.initString("");
                    public final PBStringField b_v_i = PBField.initString("");
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ConfigureAbility extends MessageMicro<ConfigureAbility> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBoolField support_cdn_xj_native = PBField.initBool(false);
            public final PBBoolField support_ios_sk_adnetwork = PBField.initBool(false);
            public final PBBoolField support_sharp_picture = PBField.initBool(false);
            public final PBBoolField support_velen = PBField.initBool(false);
            public final PBBoolField support_landingpage_hippy = PBField.initBool(false);
            public final PBBoolField is_jump_inside_authorized = PBField.initBool(false);
            public final PBBoolField support_multi_product_render = PBField.initBool(false);
            public final PBRepeatField<Integer> support_hippy_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
            public final PBUInt32Field reward_max_level = PBField.initUInt32(0);
            public final PBBoolField support_mdpa = PBField.initBool(false);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"support_cdn_xj_native", "support_ios_sk_adnetwork", "support_sharp_picture", "support_velen", "support_landingpage_hippy", "is_jump_inside_authorized", "support_multi_product_render", "support_hippy_type", "reward_max_level", "support_mdpa"}, new Object[]{bool, bool, bool, bool, bool, bool, bool, 0, 0, bool}, ConfigureAbility.class);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ExternalExpInfo extends MessageMicro<ExternalExpInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"traffic_type", "exp_id"}, new Object[]{0, ""}, ExternalExpInfo.class);
            public final PBInt32Field traffic_type = PBField.initInt32(0);
            public final PBRepeatField<String> exp_id = PBField.initRepeat(PBStringField.__repeatHelper__);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class HevcCompatibilityInfo extends MessageMicro<HevcCompatibilityInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"video_player_type", "max_luma_samples", "max_fps"}, new Object[]{0, 0L, 0}, HevcCompatibilityInfo.class);
            public final PBEnumField video_player_type = PBField.initEnum(0);
            public final PBUInt64Field max_luma_samples = PBField.initUInt64(0);
            public final PBUInt32Field max_fps = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class HippyConfigParam extends MessageMicro<HippyConfigParam> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rd_wall_ad_cnt"}, new Object[]{0}, HippyConfigParam.class);
            public final PBUInt32Field rd_wall_ad_cnt = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class IdInfo extends MessageMicro<IdInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"id_h", MimeHelper.IMAGE_SUBTYPE_BITMAP}, new Object[]{"", 0}, IdInfo.class);
            public final PBStringField id_h = PBField.initString("");
            public final PBUInt32Field bitmap = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class IosQaidInfo extends MessageMicro<IosQaidInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 114}, new String[]{"st", "cy", "la", "dn_h", "ma", "pm", "hd", "sut", "dm", "tz", "mnt", "dit"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", ""}, IosQaidInfo.class);

            /* renamed from: st, reason: collision with root package name */
            public final PBStringField f435913st = PBField.initString("");

            /* renamed from: cy, reason: collision with root package name */
            public final PBStringField f435907cy = PBField.initString("");

            /* renamed from: la, reason: collision with root package name */
            public final PBStringField f435910la = PBField.initString("");
            public final PBStringField dn_h = PBField.initString("");

            /* renamed from: ma, reason: collision with root package name */
            public final PBStringField f435911ma = PBField.initString("");

            /* renamed from: pm, reason: collision with root package name */
            public final PBStringField f435912pm = PBField.initString("");

            /* renamed from: hd, reason: collision with root package name */
            public final PBStringField f435909hd = PBField.initString("");
            public final PBStringField sut = PBField.initString("");

            /* renamed from: dm, reason: collision with root package name */
            public final PBStringField f435908dm = PBField.initString("");

            /* renamed from: tz, reason: collision with root package name */
            public final PBStringField f435914tz = PBField.initString("");
            public final PBStringField mnt = PBField.initString("");
            public final PBStringField dit = PBField.initString("");
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class SdkIdDiffMap extends MessageMicro<SdkIdDiffMap> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104}, new String[]{"di", "di0", "di1", "im", "im0", "im1", "me", "me0", "me1", "ai", "si", "ads", "cs"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Boolean.FALSE}, SdkIdDiffMap.class);

            /* renamed from: di, reason: collision with root package name */
            public final PBEnumField f435917di = PBField.initEnum(0);

            /* renamed from: di0, reason: collision with root package name */
            public final PBEnumField f435918di0 = PBField.initEnum(0);

            /* renamed from: di1, reason: collision with root package name */
            public final PBEnumField f435919di1 = PBField.initEnum(0);

            /* renamed from: im, reason: collision with root package name */
            public final PBEnumField f435920im = PBField.initEnum(0);

            /* renamed from: im0, reason: collision with root package name */
            public final PBEnumField f435921im0 = PBField.initEnum(0);

            /* renamed from: im1, reason: collision with root package name */
            public final PBEnumField f435922im1 = PBField.initEnum(0);

            /* renamed from: me, reason: collision with root package name */
            public final PBEnumField f435923me = PBField.initEnum(0);

            /* renamed from: me0, reason: collision with root package name */
            public final PBEnumField f435924me0 = PBField.initEnum(0);

            /* renamed from: me1, reason: collision with root package name */
            public final PBEnumField f435925me1 = PBField.initEnum(0);

            /* renamed from: ai, reason: collision with root package name */
            public final PBEnumField f435915ai = PBField.initEnum(0);

            /* renamed from: si, reason: collision with root package name */
            public final PBEnumField f435926si = PBField.initEnum(0);
            public final PBEnumField ads = PBField.initEnum(0);

            /* renamed from: cs, reason: collision with root package name */
            public final PBBoolField f435916cs = PBField.initBool(false);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class TargetingAbility extends MessageMicro<TargetingAbility> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBoolField support_c2s = PBField.initBool(false);
            public final PBBoolField support_wechat_canvas = PBField.initBool(false);
            public final PBRepeatField<Integer> support_mini_program_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
            public final PBBoolField support_app_preorder = PBField.initBool(false);
            public final PBBoolField support_deep_link = PBField.initBool(false);
            public final PBBoolField support_quick_app_link = PBField.initBool(false);
            public final PBBoolField web_wx_mgame = PBField.initBool(false);
            public final PBBoolField web_wx_canvas = PBField.initBool(false);
            public final PBBoolField support_download = PBField.initBool(false);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72}, new String[]{"support_c2s", "support_wechat_canvas", "support_mini_program_type", "support_app_preorder", "support_deep_link", "support_quick_app_link", "web_wx_mgame", "web_wx_canvas", "support_download"}, new Object[]{bool, bool, 0, bool, bool, bool, bool, bool, bool}, TargetingAbility.class);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class UUID extends MessageMicro<UUID> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"v", "t", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO}, new Object[]{0, 0L, "", ""}, UUID.class);

            /* renamed from: v, reason: collision with root package name */
            public final PBInt32Field f435930v = PBField.initInt32(0);

            /* renamed from: t, reason: collision with root package name */
            public final PBUInt64Field f435928t = PBField.initUInt64(0);

            /* renamed from: u, reason: collision with root package name */
            public final PBStringField f435929u = PBField.initString("");

            /* renamed from: m, reason: collision with root package name */
            public final PBStringField f435927m = PBField.initString("");
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class WechatInstalledInfo extends MessageMicro<WechatInstalledInfo> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBUInt64Field api_ver = PBField.initUInt64(0);
            public final PBBoolField installed = PBField.initBool(false);
            public final PBBoolField has_universal_link = PBField.initBool(false);
            public final PBStringField ios_opensdk_ver = PBField.initString("");
            public final PBUInt64Field adr_opensdk_ver = PBField.initUInt64(0);
            public final PBStringField wmpf_sdk_version = PBField.initString("");
            public final PBBoolField is_pc_support_wx_mini_game = PBField.initBool(false);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50, 56}, new String[]{"api_ver", "installed", "has_universal_link", "ios_opensdk_ver", "adr_opensdk_ver", "wmpf_sdk_version", "is_pc_support_wx_mini_game"}, new Object[]{0L, bool, bool, "", 0L, "", bool}, WechatInstalledInfo.class);
            }
        }

        static {
            String[] strArr = {DTConstants.APPStatusConstant.APP_STATUS, "attri_info", "qaid_info", "wechat_installed_info", "mqq_config_status", "ei", "qqb_external_exp_info", "sdk_config_ver", "harmony_sys_info", "hevc_compatibility_info", "pps", "sdk_muid", "sdk_muid_type", "font_size", "sdk_id_diff_map", "app_running_status", "report_source", "targeting_ability", "configure_ability", "nologin_skip_privacy_types", "no_rd", "qi36", "rd_tag", "nologin_user_interest_tag", "hippy_config_param", "jsbundle_info", "module_name", "jump_ability", "m_os", "dynamic_info", "nl_is", "de_data", "device_model_type", "wechat_authorization_status"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 74, 82, 88, 98, 104, 117, 122, 128, 136, 146, 154, 160, 168, 178, 186, 194, 202, 210, 218, 224, 234, 242, 248, 258, 264, 272}, strArr, new Object[]{null, null, null, null, 0, "", null, 0, null, null, bool, "", 0, Float.valueOf(0.0f), null, 0, 0, null, null, bool, bool, "", "", null, null, "", "", 0, "", "", bool, "", 0, 0}, DeviceExt.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DynamicTemplateInfo extends MessageMicro<DynamicTemplateInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"template_id", "style_id"}, new Object[]{0L, 0L}, DynamicTemplateInfo.class);
        public final PBUInt64Field template_id = PBField.initUInt64(0);
        public final PBUInt64Field style_id = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FloatingTip extends MessageMicro<FloatingTip> {
        public static final int FLOATING_TIPS_APP = 1;
        public static final int FLOATING_TIPS_INDUSTRY = 2;
        public static final int FLOATING_TIPS_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "text", "icon_url"}, new Object[]{0, "", ""}, FloatingTip.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField text = PBField.initString("");
        public final PBStringField icon_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ForceCallInfo extends MessageMicro<ForceCallInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"force_ad_index_id", "force_call_crt_size", "force_call_tid_list", "force_aid", "force_style_id"}, new Object[]{0, 0, 0L, 0L, 0L}, ForceCallInfo.class);
        public final PBUInt32Field force_ad_index_id = PBField.initUInt32(0);
        public final PBUInt32Field force_call_crt_size = PBField.initUInt32(0);
        public final PBUInt64Field force_call_tid_list = PBField.initUInt64(0);
        public final PBUInt64Field force_aid = PBField.initUInt64(0);
        public final PBUInt64Field force_style_id = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GestureStageInfo extends MessageMicro<GestureStageInfo> {
        public static final int STAGE_TYPE_BIG_FINGER = 2;
        public static final int STAGE_TYPE_SMALL_FINGER = 1;
        public static final int STAGE_TYPE_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"type", "icon_url", "tips_1", "tips_2", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time"}, new Object[]{0, "", "", "", 0, 0}, GestureStageInfo.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField icon_url = PBField.initString("");
        public final PBStringField tips_1 = PBField.initString("");
        public final PBStringField tips_2 = PBField.initString("");
        public final PBUInt32Field begin_time = PBField.initUInt32(0);
        public final PBUInt32Field end_time = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LandingpageDynamicInfo extends MessageMicro<LandingpageDynamicInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"template_id", "ext_info"}, new Object[]{"", ""}, LandingpageDynamicInfo.class);
        public final PBStringField template_id = PBField.initString("");
        public final PBStringField ext_info = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LocalInfo extends MessageMicro<LocalInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField distance_description = PBField.initString("");
        public final PBStringField store_name = PBField.initString("");
        public final PBStringField store_url = PBField.initString("");
        public final PBStringField store_address = PBField.initString("");
        public final PBDoubleField store_longitude = PBField.initDouble(0.0d);
        public final PBDoubleField store_latitude = PBField.initDouble(0.0d);

        static {
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 41, 49}, new String[]{"distance_description", "store_name", "store_url", "store_address", "store_longitude", "store_latitude"}, new Object[]{"", "", "", "", valueOf, valueOf}, LocalInfo.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LocalStoreInfo extends MessageMicro<LocalStoreInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"store_name"}, new Object[]{""}, LocalStoreInfo.class);
        public final PBStringField store_name = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MultiButton extends MessageMicro<MultiButton> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "link_type", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK}, new Object[]{"", 0, ""}, MultiButton.class);
        public final PBStringField button_text = PBField.initString("");
        public final PBEnumField link_type = PBField.initEnum(0);
        public final PBStringField link = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class PlatformSessionInfo extends MessageMicro<PlatformSessionInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56}, new String[]{QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY, "sound_auto_play", "os_voice_volume", "click_area", "current_installing_pkgname", "current_installing_pkg_category", "current_installing_pkg_category_list"}, new Object[]{0, 0, 0, 0, "", 0, 0}, PlatformSessionInfo.class);
        public final PBUInt32Field video_auto_play = PBField.initUInt32(0);
        public final PBUInt32Field sound_auto_play = PBField.initUInt32(0);
        public final PBUInt32Field os_voice_volume = PBField.initUInt32(0);
        public final PBUInt32Field click_area = PBField.initUInt32(0);
        public final PBStringField current_installing_pkgname = PBField.initString("");
        public final PBUInt32Field current_installing_pkg_category = PBField.initUInt32(0);
        public final PBRepeatField<Integer> current_installing_pkg_category_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RecommendTag extends MessageMicro<RecommendTag> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{c.G, "neg"}, new Object[]{0L, 0L}, RecommendTag.class);
        public final PBRepeatField<Long> neg;
        public final PBRepeatField<Long> pos;

        public RecommendTag() {
            PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
            this.pos = PBField.initRepeat(pBUInt64Field);
            this.neg = PBField.initRepeat(pBUInt64Field);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RequestInfo extends MessageMicro<RequestInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"tl_time_interval", "video_time_interval", "is_new_user"}, new Object[]{0, 0, 0}, RequestInfo.class);
        public final PBUInt32Field tl_time_interval = PBField.initUInt32(0);
        public final PBUInt32Field video_time_interval = PBField.initUInt32(0);
        public final PBUInt32Field is_new_user = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SdkPassthroughPosInfo extends MessageMicro<SdkPassthroughPosInfo> {
        public static final int NEXT_AD_SHOW_TIME_AFTER_PLAYED = 1;
        public static final int NEXT_AD_SHOW_TIME_AFTER_REWARDED = 2;
        public static final int NEXT_AD_UNKNOWN = 0;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"enable_multi_ads_reward", "next_ad_show_time"}, new Object[]{Boolean.FALSE, 0}, SdkPassthroughPosInfo.class);
        public final PBBoolField enable_multi_ads_reward = PBField.initBool(false);
        public final PBEnumField next_ad_show_time = PBField.initEnum(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UserStatusInfo extends MessageMicro<UserStatusInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBFloatField ad_fast_slide_ratio;
        public final PBUInt32Field browsing_speed_1;
        public final PBStringField client_session_id;
        public final PBUInt32Field game_app;
        public final PBUInt32Field icon;
        public final PBUInt32Field in_yyb;
        public final PBUInt32Field laundering;
        public final PBUInt32Field search_recom;
        public final PBRepeatField<Float> uin_embedding;
        public final PBRepeatField<Float> video_playtime_embedding;
        public final PBUInt32Field scene = PBField.initUInt32(0);
        public final PBUInt32Field red_dot_status = PBField.initUInt32(0);
        public final PBUInt32Field fresh_type = PBField.initUInt32(0);
        public final PBUInt32Field today_enter_times = PBField.initUInt32(0);
        public final PBUInt32Field card_depth = PBField.initUInt32(0);
        public final PBUInt32Field fresh_times = PBField.initUInt32(0);
        public final PBUInt32Field content_flush_num_day = PBField.initUInt32(0);
        public final PBUInt32Field content_flush_num_process = PBField.initUInt32(0);
        public final PBUInt32Field ad_flush_num_day = PBField.initUInt32(0);
        public final PBUInt32Field ad_flush_num_process = PBField.initUInt32(0);
        public final PBUInt32Field enter_motivation = PBField.initUInt32(0);
        public final PBUInt32Field today_enter_app_times = PBField.initUInt32(0);
        public final PBUInt32Field feeds_slot = PBField.initUInt32(0);

        static {
            Float valueOf = Float.valueOf(0.0f);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 117, 125, 130, 136, 149, 152, 160, 168, 176, 184}, new String[]{"scene", "red_dot_status", "fresh_type", "today_enter_times", "card_depth", "fresh_times", "content_flush_num_day", "content_flush_num_process", "ad_flush_num_day", "ad_flush_num_process", "enter_motivation", "today_enter_app_times", "feeds_slot", "uin_embedding", "video_playtime_embedding", "client_session_id", "browsing_speed_1", "ad_fast_slide_ratio", "in_yyb", "laundering", "search_recom", "game_app", "icon"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, valueOf, valueOf, "", 0, valueOf, 0, 0, 0, 0, 0}, UserStatusInfo.class);
        }

        public UserStatusInfo() {
            PBFloatField pBFloatField = PBFloatField.__repeatHelper__;
            this.uin_embedding = PBField.initRepeat(pBFloatField);
            this.video_playtime_embedding = PBField.initRepeat(pBFloatField);
            this.client_session_id = PBField.initString("");
            this.browsing_speed_1 = PBField.initUInt32(0);
            this.ad_fast_slide_ratio = PBField.initFloat(0.0f);
            this.in_yyb = PBField.initUInt32(0);
            this.laundering = PBField.initUInt32(0);
            this.search_recom = PBField.initUInt32(0);
            this.game_app = PBField.initUInt32(0);
            this.icon = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class VelenPreload extends MessageMicro<VelenPreload> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"preload_page", "preload_landing_page", "preload_json_url", "preload_json_key"}, new Object[]{"", "", "", ""}, VelenPreload.class);
        public final PBRepeatField<String> preload_page = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField preload_landing_page = PBField.initString("");
        public final PBStringField preload_json_url = PBField.initString("");
        public final PBStringField preload_json_key = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class VideoSessionInfo extends MessageMicro<VideoSessionInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field latest_play_first_cid = PBField.initUInt32(0);
        public final PBUInt32Field latest_play_second_cid = PBField.initUInt32(0);
        public final PBUInt32Field latest_play_watch_duration = PBField.initUInt32(0);
        public final PBUInt32Field top_play_first_cid = PBField.initUInt32(0);
        public final PBUInt32Field top_play_second_cid = PBField.initUInt32(0);
        public final PBUInt32Field top_play_watch_duration = PBField.initUInt32(0);
        public final PBUInt32Field interval_top_play_first_cid = PBField.initUInt32(0);
        public final PBUInt32Field interval_top_play_second_cid = PBField.initUInt32(0);
        public final PBUInt32Field interval_top_skip_first_cid = PBField.initUInt32(0);
        public final PBUInt32Field interval_top_skip_second_cid = PBField.initUInt32(0);
        public final PBUInt32Field click_cnt = PBField.initUInt32(0);
        public final PBUInt32Field exposure_cnt = PBField.initUInt32(0);
        public final PBUInt32Field play_time_avg = PBField.initUInt32(0);
        public final PBUInt32Field play_time_max = PBField.initUInt32(0);
        public final PBUInt32Field play_finish_ratio = PBField.initUInt32(0);
        public final PBFloatField skip_ratio_30_mins = PBField.initFloat(0.0f);
        public final PBFloatField skip_ratio_1_hours = PBField.initFloat(0.0f);
        public final PBFloatField skip_ratio_8_hours = PBField.initFloat(0.0f);
        public final PBFloatField skip_ratio_recent_5_browse = PBField.initFloat(0.0f);
        public final PBFloatField skip_ratio_recent_20_browse = PBField.initFloat(0.0f);
        public final PBUInt32Field skip_cnt_20_browse = PBField.initUInt32(0);
        public final PBUInt32Field valid_cnt_20_browse = PBField.initUInt32(0);
        public final PBUInt32Field valid_time_20_browse = PBField.initUInt32(0);
        public final PBUInt32Field valid_cnt_30_mins = PBField.initUInt32(0);
        public final PBUInt32Field valid_time_30_mins = PBField.initUInt32(0);
        public final PBUInt32Field click_cnt_30_mins = PBField.initUInt32(0);
        public final PBUInt32Field skip_cnt_30_mins = PBField.initUInt32(0);
        public final PBUInt32Field valid_cnt_2_hours = PBField.initUInt32(0);
        public final PBUInt32Field valid_time_2_hours = PBField.initUInt32(0);
        public final PBUInt32Field click_cnt_2_hours = PBField.initUInt32(0);
        public final PBUInt32Field skip_cnt_2_hours = PBField.initUInt32(0);
        public final PBUInt32Field valid_cnt_1_days = PBField.initUInt32(0);
        public final PBUInt32Field valid_time_1_days = PBField.initUInt32(0);
        public final PBUInt32Field click_cnt_1_days = PBField.initUInt32(0);
        public final PBUInt32Field skip_cnt_1_days = PBField.initUInt32(0);
        public final PBUInt32Field valid_cnt_7_days = PBField.initUInt32(0);
        public final PBUInt32Field valid_time_7_days = PBField.initUInt32(0);
        public final PBUInt32Field click_cnt_7_days = PBField.initUInt32(0);
        public final PBUInt32Field skip_cnt_7_days = PBField.initUInt32(0);
        public final PBUInt32Field ad_expose_num = PBField.initUInt32(0);
        public final PBUInt32Field video_end_auto_slide = PBField.initUInt32(0);

        static {
            Float valueOf = Float.valueOf(0.0f);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 133, 141, 149, 157, 165, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248, 256, 264, 272, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288, 296, 304, 312, 320, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE}, new String[]{"latest_play_first_cid", "latest_play_second_cid", "latest_play_watch_duration", "top_play_first_cid", "top_play_second_cid", "top_play_watch_duration", "interval_top_play_first_cid", "interval_top_play_second_cid", "interval_top_skip_first_cid", "interval_top_skip_second_cid", "click_cnt", "exposure_cnt", "play_time_avg", "play_time_max", "play_finish_ratio", "skip_ratio_30_mins", "skip_ratio_1_hours", "skip_ratio_8_hours", "skip_ratio_recent_5_browse", "skip_ratio_recent_20_browse", "skip_cnt_20_browse", "valid_cnt_20_browse", "valid_time_20_browse", "valid_cnt_30_mins", "valid_time_30_mins", "click_cnt_30_mins", "skip_cnt_30_mins", "valid_cnt_2_hours", "valid_time_2_hours", "click_cnt_2_hours", "skip_cnt_2_hours", "valid_cnt_1_days", "valid_time_1_days", "click_cnt_1_days", "skip_cnt_1_days", "valid_cnt_7_days", "valid_time_7_days", "click_cnt_7_days", "skip_cnt_7_days", "ad_expose_num", "video_end_auto_slide"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, valueOf, valueOf, valueOf, valueOf, valueOf, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, VideoSessionInfo.class);
        }
    }

    qq_common() {
    }
}
