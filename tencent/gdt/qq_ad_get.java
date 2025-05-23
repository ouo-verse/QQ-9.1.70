package tencent.gdt;

import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qwallet.impl.QWalletPreferenceApiImpl;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqmini.sdk.plugins.BannerAdPlugin;
import com.tencent.state.map.MapItemKt;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.view.FilterEnum;
import com.tencent.xweb.FileReaderHelper;
import tencent.gdt.cps_info;
import tencent.gdt.indicator;
import tencent.gdt.qq_common;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qq_ad_get {
    public static final int AIR_QUALITY_EXCELLENT = 1;
    public static final int AIR_QUALITY_GOOD = 2;
    public static final int AIR_QUALITY_HEAVYPOLLUTION = 5;
    public static final int AIR_QUALITY_LIGHTPOLLUTION = 3;
    public static final int AIR_QUALITY_MEDIUMPOLLUTION = 4;
    public static final int AIR_QUALITY_SERIOUSPOLLUTION = 6;
    public static final int AIR_QUALITY_UNKNOWN = 0;
    public static final int IMAGE_FORMAT_PAG = 1;
    public static final int IMAGE_FORMAT_PNG = 2;
    public static final int IMAGE_FORMAT_UNKNOWN = 0;
    public static final int WARNING_TYPE_BLIZZAED = 12;
    public static final int WARNING_TYPE_COLD = 4;
    public static final int WARNING_TYPE_DROUGHT = 9;
    public static final int WARNING_TYPE_FROST = 14;
    public static final int WARNING_TYPE_GALE = 5;
    public static final int WARNING_TYPE_HAIL = 7;
    public static final int WARNING_TYPE_HAZE = 10;
    public static final int WARNING_TYPE_HEATWAVE = 3;
    public static final int WARNING_TYPE_HEAVYFOG = 6;
    public static final int WARNING_TYPE_ICYROAD = 15;
    public static final int WARNING_TYPE_LIGHTING = 8;
    public static final int WARNING_TYPE_RAINSTORM = 2;
    public static final int WARNING_TYPE_SANDSTORM = 13;
    public static final int WARNING_TYPE_TYPHOON = 1;
    public static final int WARNING_TYPE_UNKNOWN = 0;
    public static final int WARNING_TYPE_WILDFIRE = 11;
    public static final int WEATHER_TYPE_CLOUDY = 2;
    public static final int WEATHER_TYPE_DUST = 7;
    public static final int WEATHER_TYPE_FINE = 1;
    public static final int WEATHER_TYPE_FOG = 6;
    public static final int WEATHER_TYPE_HAZE = 8;
    public static final int WEATHER_TYPE_OVERCAST = 3;
    public static final int WEATHER_TYPE_RAIN = 4;
    public static final int WEATHER_TYPE_SNOW = 5;
    public static final int WEATHER_TYPE_UNKNOWN = 0;
    public static final int WECHAT_MINI_PROGRAM_OPEN_TYPE_INSIDE_FALLBACK_TO_AUTH = 2;
    public static final int WECHAT_MINI_PROGRAM_OPEN_TYPE_INSIDE_FALLBACK_TO_OUTSIDE = 1;
    public static final int WECHAT_MINI_PROGRAM_OPEN_TYPE_OUTSIDE = 3;
    public static final int WECHAT_MINI_PROGRAM_OPEN_TYPE_UNKNOWN = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FeatureDataBuffer extends MessageMicro<FeatureDataBuffer> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"compress_algorithm", "decompressed_size", "data"}, new Object[]{"", 0L, ByteStringMicro.EMPTY}, FeatureDataBuffer.class);
        public final PBStringField compress_algorithm = PBField.initString("");
        public final PBUInt64Field decompressed_size = PBField.initUInt64(0);
        public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FeatureDataGroup extends MessageMicro<FeatureDataGroup> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ad_feature_data", "creative_feature_data", "material_feature_data"}, new Object[]{null, null, null}, FeatureDataGroup.class);
        public FeatureDataBuffer ad_feature_data = new FeatureDataBuffer();
        public FeatureDataBuffer creative_feature_data = new FeatureDataBuffer();
        public final PBRepeatMessageField<FeatureDataBuffer> material_feature_data = PBField.initRepeatMessage(FeatureDataBuffer.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class QQAdGet extends MessageMicro<QQAdGet> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74, 80, 90, 98, 16010}, new String[]{"user_info", "position_info", "device_info", "context_info", SPReportHelper.KEY_DEBUG_INFO, "gdt_cookie", "support_https", "external_exp_info", "version_info", "dynamic_timeout_in_ms", "weather_info", "request_id", "busi_cookie"}, new Object[]{null, null, null, null, null, "", Boolean.FALSE, null, null, 0, null, "", ""}, QQAdGet.class);
        public UserInfo user_info = new UserInfo();
        public final PBRepeatMessageField<PositionInfo> position_info = PBField.initRepeatMessage(PositionInfo.class);
        public DeviceInfo device_info = new DeviceInfo();
        public ContextInfo context_info = new ContextInfo();
        public DebugInfo debug_info = new DebugInfo();
        public final PBStringField gdt_cookie = PBField.initString("");
        public final PBBoolField support_https = PBField.initBool(false);
        public ExternalExpInfo external_exp_info = new ExternalExpInfo();
        public VersionInfo version_info = new VersionInfo();
        public final PBUInt32Field dynamic_timeout_in_ms = PBField.initUInt32(0);
        public WeatherInfo weather_info = new WeatherInfo();
        public final PBStringField request_id = PBField.initString("");
        public final PBStringField busi_cookie = PBField.initString("");

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ContextInfo extends MessageMicro<ContextInfo> {
            public static final int CALL_TYPE_EXTERNAL_CALL = 3;
            public static final int CALL_TYPE_ICON = 1;
            public static final int CALL_TYPE_PUSH = 2;
            public static final int CALL_TYPE_UNKNOWN = 0;
            public static final int LOAD_TYPE_DEFAULT = 0;
            public static final int LOAD_TYPE_PRELOAD = 3;
            public static final int LOAD_TYPE_REAR = 4;
            public static final int LOAD_TYPE_TIMEOUT = 2;
            public static final int LOAD_TYPE_TOP = 1;
            public static final int REQ_SCENE_TYPE_BACKEND = 3;
            public static final int REQ_SCENE_TYPE_BACK_FROM_OHTER_PAGE = 5;
            public static final int REQ_SCENE_TYPE_LOGIN = 1;
            public static final int REQ_SCENE_TYPE_SWTICH_TAB = 4;
            public static final int REQ_SCENE_TYPE_SWTICH_TO_FRONT = 2;
            public static final int REQ_SCENE_TYPE_UNKNOWN = 0;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66, 74, 80, 88, 98, 104, 114, 130, 138, 146, 152, 162, 170, 178, 184, 194, 200}, new String[]{"public_id", AppConstants.Key.SHARE_REQ_ARTICLE_ID, "tribe_tag", "tribe_id_tag", "source_from", "page_url", "existed_mini_program_ids", "str_source_from", "qq_public_category", "load_type", "mini_program_status", IPublicAccountBrowser.KEY_CALL_FROM, "launch_channel", AppConstants.Key.SESSION_INFO, "user_status_info", "video_session", "platform_session", "channel_enum", "external_host", "invalid_last_ads", "req_info", "qq_group_category", "push_ad_info", "req_scene_type"}, new Object[]{0L, 0L, 0, 0, 0, ByteStringMicro.EMPTY, 0L, "", null, 0, 0, "", 0, null, null, null, null, 0, "", null, null, 0, null, 0}, ContextInfo.class);
            public final PBUInt64Field public_id = PBField.initUInt64(0);
            public final PBUInt64Field article_id = PBField.initUInt64(0);
            public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
            public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
            public final PBUInt32Field source_from = PBField.initUInt32(0);
            public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBRepeatField<Long> existed_mini_program_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
            public final PBStringField str_source_from = PBField.initString("");
            public final PBRepeatMessageField<QQPublicCategoryInfo> qq_public_category = PBField.initRepeatMessage(QQPublicCategoryInfo.class);
            public final PBEnumField load_type = PBField.initEnum(0);
            public final PBUInt32Field mini_program_status = PBField.initUInt32(0);
            public final PBStringField call_from = PBField.initString("");
            public final PBEnumField launch_channel = PBField.initEnum(0);
            public SessionInfo session_info = new SessionInfo();
            public final PBFloatField linear_reward_ratio = PBField.initFloat(0.0f);
            public qq_common.UserStatusInfo user_status_info = new qq_common.UserStatusInfo();
            public qq_common.VideoSessionInfo video_session = new qq_common.VideoSessionInfo();
            public qq_common.PlatformSessionInfo platform_session = new qq_common.PlatformSessionInfo();
            public final PBUInt32Field channel_enum = PBField.initUInt32(0);
            public final PBStringField external_host = PBField.initString("");
            public InvalidLastAds invalid_last_ads = new InvalidLastAds();
            public qq_common.RequestInfo req_info = new qq_common.RequestInfo();
            public final PBUInt32Field qq_group_category = PBField.initUInt32(0);
            public PushAdInfo push_ad_info = new PushAdInfo();
            public final PBEnumField req_scene_type = PBField.initEnum(0);

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class InvalidLastAds extends MessageMicro<InvalidLastAds> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ads"}, new Object[]{null}, InvalidLastAds.class);
                public final PBRepeatMessageField<Ad> ads = PBField.initRepeatMessage(Ad.class);

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class Ad extends MessageMicro<Ad> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"adgroup_id"}, new Object[]{0L}, Ad.class);
                    public final PBUInt64Field adgroup_id = PBField.initUInt64(0);
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class PlatformSessionInfo extends MessageMicro<PlatformSessionInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY, "sound_auto_play", "os_voice_volume", "click_area"}, new Object[]{0, 0, 0, 0}, PlatformSessionInfo.class);
                public final PBUInt32Field video_auto_play = PBField.initUInt32(0);
                public final PBUInt32Field sound_auto_play = PBField.initUInt32(0);
                public final PBUInt32Field os_voice_volume = PBField.initUInt32(0);
                public final PBUInt32Field click_area = PBField.initUInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class PushAdInfo extends MessageMicro<PushAdInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"points"}, new Object[]{null}, PushAdInfo.class);
                public final PBRepeatMessageField<Point> points = PBField.initRepeatMessage(Point.class);

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class Point extends MessageMicro<Point> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"id", WebRTCSDK.PRIVILEGE_PASSTHROUGH}, new Object[]{"", ""}, Point.class);

                    /* renamed from: id, reason: collision with root package name */
                    public final PBStringField f435898id = PBField.initString("");
                    public final PBStringField passthrough = PBField.initString("");
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class RequestInfo extends MessageMicro<RequestInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"tl_time_interval"}, new Object[]{0}, RequestInfo.class);
                public final PBUInt32Field tl_time_interval = PBField.initUInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class UserStatusInfo extends MessageMicro<UserStatusInfo> {
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBFloatField ad_fast_slide_ratio;
                public final PBUInt32Field browsing_speed_1;
                public final PBRepeatField<Float> uin_embedding;
                public final PBRepeatField<Float> video_playtime_embedding;
                public final PBUInt32Field scene = PBField.initUInt32(0);
                public final PBUInt32Field red_dot_status = PBField.initUInt32(0);
                public final PBUInt32Field fresh_type = PBField.initUInt32(0);
                public final PBUInt32Field today_enter_times = PBField.initUInt32(0);
                public final PBUInt32Field card_depth = PBField.initUInt32(0);
                public final PBUInt32Field fresh_times = PBField.initUInt32(0);
                public final PBUInt32Field enter_motivation = PBField.initUInt32(0);
                public final PBUInt32Field feeds_slot = PBField.initUInt32(0);

                static {
                    Float valueOf = Float.valueOf(0.0f);
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 88, 104, 117, 125, 136, 149}, new String[]{"scene", "red_dot_status", "fresh_type", "today_enter_times", "card_depth", "fresh_times", "enter_motivation", "feeds_slot", "uin_embedding", "video_playtime_embedding", "browsing_speed_1", "ad_fast_slide_ratio"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, valueOf, valueOf, 0, valueOf}, UserStatusInfo.class);
                }

                public UserStatusInfo() {
                    PBFloatField pBFloatField = PBFloatField.__repeatHelper__;
                    this.uin_embedding = PBField.initRepeat(pBFloatField);
                    this.video_playtime_embedding = PBField.initRepeat(pBFloatField);
                    this.browsing_speed_1 = PBField.initUInt32(0);
                    this.ad_fast_slide_ratio = PBField.initFloat(0.0f);
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class VideoSessionInfo extends MessageMicro<VideoSessionInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE}, new String[]{"latest_play_first_cid", "latest_play_second_cid", "latest_play_watch_duration", "top_play_first_cid", "top_play_second_cid", "top_play_watch_duration", "interval_top_play_first_cid", "interval_top_play_second_cid", "interval_top_skip_first_cid", "interval_top_skip_second_cid", "click_cnt", "exposure_cnt", "video_end_auto_slide"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, VideoSessionInfo.class);
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
                public final PBUInt32Field video_end_auto_slide = PBField.initUInt32(0);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class DebugInfo extends MessageMicro<DebugInfo> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBUInt32Field debug_adindexid = PBField.initUInt32(0);
            public final PBBoolField nomatch = PBField.initBool(false);
            public final PBBoolField debug = PBField.initBool(false);
            public final PBBoolField qq_broswer_debug = PBField.initBool(false);
            public final PBRepeatField<String> force_style_rule_list = PBField.initRepeat(PBStringField.__repeatHelper__);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42}, new String[]{"debug_adindexid", "nomatch", "debug", "qq_broswer_debug", "force_style_rule_list"}, new Object[]{0, bool, bool, bool, ""}, DebugInfo.class);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class DeviceInfo extends MessageMicro<DeviceInfo> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBStringField muid = PBField.initString("");
            public final PBUInt32Field muid_type = PBField.initUInt32(0);
            public final PBUInt32Field conn = PBField.initUInt32(0);
            public final PBUInt32Field carrier_code = PBField.initUInt32(0);
            public final PBStringField os_ver = PBField.initString("");
            public final PBStringField qq_ver = PBField.initString("");
            public final PBUInt32Field os_type = PBField.initUInt32(0);
            public final PBStringField client_ip = PBField.initString("");
            public final PBStringField ios_qidfa = PBField.initString("");
            public Location location = new Location();
            public final PBBoolField is_wk_webview = PBField.initBool(false);
            public final PBStringField manufacturer = PBField.initString("");
            public final PBStringField device_brand_and_model = PBField.initString("");
            public final PBStringField qadid = PBField.initString("");
            public final PBUInt32Field app_version_id = PBField.initUInt32(0);
            public final PBStringField imei = PBField.initString("");
            public final PBStringField idfa = PBField.initString("");
            public final PBStringField android_id = PBField.initString("");
            public final PBStringField mac = PBField.initString("");
            public final PBBoolField is_googleplay_version = PBField.initBool(false);
            public final PBUInt32Field device_orientation = PBField.initUInt32(0);
            public final PBBoolField is_ios_review_state = PBField.initBool(false);
            public final PBStringField oaid = PBField.initString("");
            public final PBStringField taid_ticket = PBField.initString("");
            public final PBStringField md5_mac = PBField.initString("");
            public final PBStringField md5_android_id = PBField.initString("");
            public final PBStringField client_ipv4 = PBField.initString("");
            public final PBStringField aid_ticket = PBField.initString("");
            public final PBUInt64Field wx_api_ver = PBField.initUInt64(0);
            public final PBBoolField wx_installed = PBField.initBool(false);
            public final PBBoolField wx_ul = PBField.initBool(false);
            public final PBUInt32Field origin_network_type = PBField.initUInt32(0);
            public final PBStringField brand = PBField.initString("");
            public final PBStringField device_ext = PBField.initString("");
            public final PBStringField cached_idfa = PBField.initString("");
            public final PBUInt32Field hw_level = PBField.initUInt32(0);
            public final PBUInt32Field av1_flag = PBField.initUInt32(0);

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class Location extends MessageMicro<Location> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"latitude", "longitude", "coordinates_type"}, new Object[]{0, 0, 0}, Location.class);
                public final PBInt32Field latitude = PBField.initInt32(0);
                public final PBInt32Field longitude = PBField.initInt32(0);
                public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
            }

            static {
                int[] iArr = {10, 16, 24, 32, 42, 50, 56, 66, 74, 82, 88, 98, 106, 114, 120, 130, 138, 146, 154, 160, 168, 176, 186, 194, 202, 210, 218, 226, 232, 240, 248, 256, 266, 274, FilterEnum.MIC_PTU_BAIXI, 288, 296};
                String[] strArr = {"muid", "muid_type", "conn", "carrier_code", "os_ver", "qq_ver", "os_type", "client_ip", "ios_qidfa", "location", "is_wk_webview", "manufacturer", "device_brand_and_model", "qadid", "app_version_id", "imei", "idfa", SharedPreferencedUtil.SP_KEY_ANDROID_ID, "mac", "is_googleplay_version", "device_orientation", "is_ios_review_state", "oaid", "taid_ticket", "md5_mac", "md5_android_id", "client_ipv4", "aid_ticket", "wx_api_ver", "wx_installed", "wx_ul", "origin_network_type", "brand", "device_ext", "cached_idfa", "hw_level", "av1_flag"};
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", 0, 0, 0, "", "", 0, "", "", null, bool, "", "", "", 0, "", "", "", "", bool, 0, bool, "", "", "", "", "", "", 0L, bool, bool, 0, "", "", "", 0, 0}, DeviceInfo.class);
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
        public static final class PositionInfo extends MessageMicro<PositionInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{SsoReporter.POS_ID_KEY, "ad_count", "pos_ext"}, new Object[]{"", 0, null}, PositionInfo.class);
            public final PBStringField pos_id = PBField.initString("");
            public final PBUInt32Field ad_count = PBField.initUInt32(0);
            public PositionExt pos_ext = new PositionExt();

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class PositionExt extends MessageMicro<PositionExt> {
                public static final int FETCH_TYPE_PREFETCH = 1;
                public static final int FETCH_TYPE_REAL_TIME = 0;
                public static final int FETCH_TYPE_SPECIFY_AD = 2;
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 56, 66, 74, 82, 90, 96, 104, 114, 120, 128}, new String[]{"share_info", "deep_link_version", "get_ad_type", "specified_ads", "sub_position_id", "black_category_list", "debug_adindexid_list", "cps_req_info", "video_req_info", "context_info", "search_content_info", "soft_ad_aid", "related_keys", "force_call_infos", "disable_recall_mengceng_ad", "expect_wechat_mini_program_open_type"}, new Object[]{null, 0, 0, null, "", 0, 0, null, null, null, null, 0L, 0L, null, Boolean.FALSE, 0}, PositionExt.class);
                public final PBRepeatField<Integer> black_category_list;
                public PositionContextInfo context_info;
                public final PBRepeatMessageField<CpsReqInfo> cps_req_info;
                public final PBRepeatField<Integer> debug_adindexid_list;
                public final PBBoolField disable_recall_mengceng_ad;
                public final PBEnumField expect_wechat_mini_program_open_type;
                public final PBRepeatMessageField<qq_common.ForceCallInfo> force_call_infos;
                public final PBRepeatField<Long> related_keys;
                public SearchContentInfo search_content_info;
                public final PBRepeatField<Long> soft_ad_aid;
                public VideoReqInfo video_req_info;
                public ShareInfo share_info = new ShareInfo();
                public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
                public final PBEnumField get_ad_type = PBField.initEnum(0);
                public final PBRepeatMessageField<SpecifiedAdsItem> specified_ads = PBField.initRepeatMessage(SpecifiedAdsItem.class);
                public final PBStringField sub_position_id = PBField.initString("");

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class CpsReqInfo extends MessageMicro<CpsReqInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "catelog_id", "product_link_info", "pcg_media_trace_info", "product_share_info"}, new Object[]{0L, 0L, null, null, null}, CpsReqInfo.class);
                    public final PBRepeatField<Long> product_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
                    public final PBUInt64Field catelog_id = PBField.initUInt64(0);
                    public final PBRepeatMessageField<ProductLinkInfo> product_link_info = PBField.initRepeatMessage(ProductLinkInfo.class);
                    public final PBRepeatMessageField<cps_info.PcgMediaTraceInfo> pcg_media_trace_info = PBField.initRepeatMessage(cps_info.PcgMediaTraceInfo.class);
                    public final PBRepeatMessageField<ProductShareInfo> product_share_info = PBField.initRepeatMessage(ProductShareInfo.class);

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class PcgMediaTraceInfo extends MessageMicro<PcgMediaTraceInfo> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82}, new String[]{"timestamp", "media_type", ReportDataBuilder.KEY_PRODUCT_ID, "scene", "content_id", "trace_id", "buyer_id", "seller_id", "ext_info", "seller_grade"}, new Object[]{0L, 0, 0L, 0, "", "", "", "", "", ""}, PcgMediaTraceInfo.class);
                        public final PBUInt64Field timestamp = PBField.initUInt64(0);
                        public final PBInt32Field media_type = PBField.initInt32(0);
                        public final PBUInt64Field product_id = PBField.initUInt64(0);
                        public final PBInt32Field scene = PBField.initInt32(0);
                        public final PBStringField content_id = PBField.initString("");
                        public final PBStringField trace_id = PBField.initString("");
                        public final PBStringField buyer_id = PBField.initString("");
                        public final PBStringField seller_id = PBField.initString("");
                        public final PBStringField ext_info = PBField.initString("");
                        public final PBStringField seller_grade = PBField.initString("");
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class ProductLinkInfo extends MessageMicro<ProductLinkInfo> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "h5_page", "wx_miniprogram_link", "qq_miniprogram_link"}, new Object[]{0L, "", null, null}, ProductLinkInfo.class);
                        public final PBUInt64Field product_id = PBField.initUInt64(0);
                        public final PBStringField h5_page = PBField.initString("");
                        public MiniProgramLink wx_miniprogram_link = new MiniProgramLink();
                        public MiniProgramLink qq_miniprogram_link = new MiniProgramLink();
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class ProductShareInfo extends MessageMicro<ProductShareInfo> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "share_rate"}, new Object[]{0L, 0}, ProductShareInfo.class);
                        public final PBUInt64Field product_id = PBField.initUInt64(0);
                        public final PBUInt32Field share_rate = PBField.initUInt32(0);
                    }
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class MiniProgramLink extends MessageMicro<MiniProgramLink> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"app_id", "page_path", "schema_link", AudienceReportConst.USER_NAME}, new Object[]{"", "", "", ""}, MiniProgramLink.class);
                    public final PBStringField app_id = PBField.initString("");
                    public final PBStringField page_path = PBField.initString("");
                    public final PBStringField schema_link = PBField.initString("");
                    public final PBStringField user_name = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class PositionContextInfo extends MessageMicro<PositionContextInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56}, new String[]{"seq", "abs_seq", "wesee_feeds_id", "wesee_first_category", "wesee_second_category", "screen_num", "allowed_category"}, new Object[]{0, 0, "", "", "", 0, 0}, PositionContextInfo.class);
                    public final PBUInt32Field seq = PBField.initUInt32(0);
                    public final PBUInt32Field abs_seq = PBField.initUInt32(0);
                    public final PBStringField wesee_feeds_id = PBField.initString("");
                    public final PBStringField wesee_first_category = PBField.initString("");
                    public final PBStringField wesee_second_category = PBField.initString("");
                    public final PBUInt32Field screen_num = PBField.initUInt32(0);
                    public final PBRepeatField<Integer> allowed_category = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ProductLinkInfo extends MessageMicro<ProductLinkInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "h5_page", "wx_miniprogram_link", "qq_miniprogram_link"}, new Object[]{0L, "", null, null}, ProductLinkInfo.class);
                    public final PBUInt64Field product_id = PBField.initUInt64(0);
                    public final PBStringField h5_page = PBField.initString("");
                    public MiniProgramLink wx_miniprogram_link = new MiniProgramLink();
                    public MiniProgramLink qq_miniprogram_link = new MiniProgramLink();
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ProductShareInfo extends MessageMicro<ProductShareInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "share_info"}, new Object[]{0L, null}, ProductShareInfo.class);
                    public final PBUInt64Field product_id = PBField.initUInt64(0);
                    public ShareInfo share_info = new ShareInfo();
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class SearchContentInfo extends MessageMicro<SearchContentInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"query_tag", "query_info"}, new Object[]{null, null}, SearchContentInfo.class);
                    public final PBRepeatMessageField<Tag> query_tag = PBField.initRepeatMessage(Tag.class);
                    public final PBRepeatMessageField<QueryInfo> query_info = PBField.initRepeatMessage(QueryInfo.class);

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class QueryInfo extends MessageMicro<QueryInfo> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"word", "type", "terms"}, new Object[]{"", 0, null}, QueryInfo.class);
                        public final PBStringField word = PBField.initString("");
                        public final PBUInt32Field type = PBField.initUInt32(0);
                        public final PBRepeatMessageField<Term> terms = PBField.initRepeatMessage(Term.class);

                        /* compiled from: P */
                        /* loaded from: classes29.dex */
                        public static final class Synonym extends MessageMicro<Synonym> {
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21}, new String[]{"word", "weight"}, new Object[]{"", Float.valueOf(0.0f)}, Synonym.class);
                            public final PBStringField word = PBField.initString("");
                            public final PBFloatField weight = PBField.initFloat(0.0f);
                        }

                        /* compiled from: P */
                        /* loaded from: classes29.dex */
                        public static final class Term extends MessageMicro<Term> {
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 24, 34}, new String[]{"word", "weight", "is_core_term", "synonyms"}, new Object[]{"", Float.valueOf(0.0f), Boolean.FALSE, null}, Term.class);
                            public final PBStringField word = PBField.initString("");
                            public final PBFloatField weight = PBField.initFloat(0.0f);
                            public final PBBoolField is_core_term = PBField.initBool(false);
                            public final PBRepeatMessageField<Synonym> synonyms = PBField.initRepeatMessage(Synonym.class);
                        }
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class Tag extends MessageMicro<Tag> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"text", "type"}, new Object[]{"", 0}, Tag.class);
                        public final PBStringField text = PBField.initString("");
                        public final PBUInt32Field type = PBField.initUInt32(0);
                    }
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ShareInfo extends MessageMicro<ShareInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"share_rate", "share_check"}, new Object[]{0, ""}, ShareInfo.class);
                    public final PBUInt32Field share_rate = PBField.initUInt32(0);
                    public final PBStringField share_check = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class SpecifiedAdsItem extends MessageMicro<SpecifiedAdsItem> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"aid", "creative_id", "prefetch_timestamp", "version"}, new Object[]{0L, 0L, 0, 0L}, SpecifiedAdsItem.class);
                    public final PBUInt64Field aid = PBField.initUInt64(0);
                    public final PBUInt64Field creative_id = PBField.initUInt64(0);
                    public final PBUInt32Field prefetch_timestamp = PBField.initUInt32(0);
                    public final PBUInt64Field version = PBField.initUInt64(0);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class VideoReqInfo extends MessageMicro<VideoReqInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"video_min_duration", "video_max_duration"}, new Object[]{0, 0}, VideoReqInfo.class);
                    public final PBUInt32Field video_min_duration = PBField.initUInt32(0);
                    public final PBUInt32Field video_max_duration = PBField.initUInt32(0);
                }

                public PositionExt() {
                    PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
                    this.black_category_list = PBField.initRepeat(pBUInt32Field);
                    this.debug_adindexid_list = PBField.initRepeat(pBUInt32Field);
                    this.cps_req_info = PBField.initRepeatMessage(CpsReqInfo.class);
                    this.video_req_info = new VideoReqInfo();
                    this.context_info = new PositionContextInfo();
                    this.search_content_info = new SearchContentInfo();
                    PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
                    this.soft_ad_aid = PBField.initRepeat(pBUInt64Field);
                    this.related_keys = PBField.initRepeat(pBUInt64Field);
                    this.force_call_infos = PBField.initRepeatMessage(qq_common.ForceCallInfo.class);
                    this.disable_recall_mengceng_ad = PBField.initBool(false);
                    this.expect_wechat_mini_program_open_type = PBField.initEnum(0);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class QQPublicCategoryInfo extends MessageMicro<QQPublicCategoryInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"qq_public_category_id", "qq_public_category_level"}, new Object[]{"", 0}, QQPublicCategoryInfo.class);
            public final PBStringField qq_public_category_id = PBField.initString("");
            public final PBUInt32Field qq_public_category_level = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class SessionInfo extends MessageMicro<SessionInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"session_num", "session_time"}, new Object[]{0, 0}, SessionInfo.class);
            public final PBUInt32Field session_num = PBField.initUInt32(0);
            public final PBUInt32Field session_time = PBField.initUInt32(0);
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class UserInfo extends MessageMicro<UserInfo> {
            public static final int USER_GROUP_COMMON = 2;
            public static final int USER_GROUP_DEFAULT = 0;
            public static final int USER_GROUP_WELFARE = 1;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 64, 72, 80, 88, 98}, new String[]{"qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid", "wuid", "is_study_mode", VipFunCallConstants.KEY_GROUP, "is_active_user", "is_frequency_limit", "ams_qq_openid"}, new Object[]{0L, "", "", "", 0L, "", "", Boolean.FALSE, 0, 0, 0, ""}, UserInfo.class);

            /* renamed from: qq, reason: collision with root package name */
            public final PBUInt64Field f435899qq = PBField.initUInt64(0);
            public final PBStringField wx_appid = PBField.initString("");
            public final PBStringField wx_openid = PBField.initString("");
            public final PBStringField media_specified_id = PBField.initString("");
            public final PBUInt64Field qq_appid = PBField.initUInt64(0);
            public final PBStringField qq_openid = PBField.initString("");
            public final PBStringField wuid = PBField.initString("");
            public final PBBoolField is_study_mode = PBField.initBool(false);
            public final PBEnumField group = PBField.initEnum(0);
            public final PBUInt32Field is_active_user = PBField.initUInt32(0);
            public final PBUInt32Field is_frequency_limit = PBField.initUInt32(0);
            public final PBStringField ams_qq_openid = PBField.initString("");
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class VersionInfo extends MessageMicro<VersionInfo> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBoolField support_c2s = PBField.initBool(false);
            public final PBBoolField support_dpa = PBField.initBool(false);
            public final PBBoolField support_mixed_sort = PBField.initBool(false);
            public final PBBoolField support_mixed_feature = PBField.initBool(false);

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"support_c2s", "support_dpa", "support_mixed_sort", "support_mixed_feature"}, new Object[]{bool, bool, bool, bool}, VersionInfo.class);
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class WeatherInfo extends MessageMicro<WeatherInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"temperature", WidgetCacheWeatherData.HUMIDITY, CustomImageProps.QUALITY, "weather_type", "warning_type"}, new Object[]{0, 0, 0, 0, 0}, WeatherInfo.class);
            public final PBInt32Field temperature = PBField.initInt32(0);
            public final PBInt32Field humidity = PBField.initInt32(0);
            public final PBInt32Field quality = PBField.initInt32(0);
            public final PBInt32Field weather_type = PBField.initInt32(0);
            public final PBInt32Field warning_type = PBField.initInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class QQAdGetRsp extends MessageMicro<QQAdGetRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 82, 90, 98}, new String[]{"ret", "msg", "pos_ads_info", "gdt_cookie", "busi_cookie", SPReportHelper.KEY_DEBUG_INFO, "ip_ping_url", "net_log_req_id", "passthrough_req_info", "trace_id", "user_feature_data"}, new Object[]{0, "", null, "", "", "", "", "", ByteStringMicro.EMPTY, "", null}, QQAdGetRsp.class);
        public final PBInt32Field ret = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f435900msg = PBField.initString("");
        public final PBRepeatMessageField<PosAdInfo> pos_ads_info = PBField.initRepeatMessage(PosAdInfo.class);
        public final PBStringField gdt_cookie = PBField.initString("");
        public final PBStringField busi_cookie = PBField.initString("");
        public final PBStringField debug_info = PBField.initString("");
        public final PBStringField ip_ping_url = PBField.initString("");
        public final PBStringField net_log_req_id = PBField.initString("");
        public final PBBytesField passthrough_req_info = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField trace_id = PBField.initString("");
        public FeatureDataBuffer user_feature_data = new FeatureDataBuffer();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class AdInfo extends MessageMicro<AdInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122}, new String[]{"product_type", "display_info", QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "dest_info", j.T0, "exp_info", "ext", "ext_json", "cps_rsp_info", "wechat_app_info", "reward_info", "dynamic_info", "passthrough_ad_info", "feature_data_group", "passthrough_push_ad_info"}, new Object[]{0, null, null, null, null, null, null, "", null, null, null, null, ByteStringMicro.EMPTY, null, ""}, AdInfo.class);
            public final PBUInt32Field product_type = PBField.initUInt32(0);
            public DisplayInfo display_info = new DisplayInfo();
            public ReportInfo report_info = new ReportInfo();
            public DestInfo dest_info = new DestInfo();
            public AppInfo app_info = new AppInfo();
            public ExpInfo exp_info = new ExpInfo();
            public Ext ext = new Ext();
            public final PBStringField ext_json = PBField.initString("");
            public final PBRepeatMessageField<CpsRspInfo> cps_rsp_info = PBField.initRepeatMessage(CpsRspInfo.class);
            public WeChatAppInfo wechat_app_info = new WeChatAppInfo();
            public RewardInfo reward_info = new RewardInfo();
            public DynamicInfo dynamic_info = new DynamicInfo();
            public final PBBytesField passthrough_ad_info = PBField.initBytes(ByteStringMicro.EMPTY);
            public FeatureDataGroup feature_data_group = new FeatureDataGroup();
            public final PBStringField passthrough_push_ad_info = PBField.initString("");

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class AppChannelInfo extends MessageMicro<AppChannelInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"author_name", "package_size_bytes", "version_name", "permissions_url", "privacy_agreement_url", "app_name", "description_url", "permissions_web_url", "icp_number", "developer", "suitable_age", "icp_info_url"}, new Object[]{"", 0L, "", "", "", "", "", "", "", "", "", ""}, AppChannelInfo.class);
                public final PBStringField author_name = PBField.initString("");
                public final PBInt64Field package_size_bytes = PBField.initInt64(0);
                public final PBStringField version_name = PBField.initString("");
                public final PBStringField permissions_url = PBField.initString("");
                public final PBStringField privacy_agreement_url = PBField.initString("");
                public final PBStringField app_name = PBField.initString("");
                public final PBStringField description_url = PBField.initString("");
                public final PBStringField permissions_web_url = PBField.initString("");
                public final PBStringField icp_number = PBField.initString("");
                public final PBStringField developer = PBField.initString("");
                public final PBStringField suitable_age = PBField.initString("");
                public final PBStringField icp_info_url = PBField.initString("");
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class AppInfo extends MessageMicro<AppInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 112, 122}, new String[]{"app_name", "app_score", "app_package_name", "app_package_size", "app_package_version", "app_logo_url", "pkg_url", "ios_app_id", "android_app_id", "pkg_download_schema", "customized_invoke_url", "channel_id", "app_score_num", "download_num", "app_standard_info_url"}, new Object[]{"", "", "", 0L, "", "", "", "", "", "", "", "", 0, 0L, ""}, AppInfo.class);
                public final PBStringField app_name = PBField.initString("");
                public final PBStringField app_score = PBField.initString("");
                public final PBStringField app_package_name = PBField.initString("");
                public final PBUInt64Field app_package_size = PBField.initUInt64(0);
                public final PBStringField app_package_version = PBField.initString("");
                public final PBStringField app_logo_url = PBField.initString("");
                public final PBStringField pkg_url = PBField.initString("");
                public final PBStringField ios_app_id = PBField.initString("");
                public final PBStringField android_app_id = PBField.initString("");
                public final PBStringField pkg_download_schema = PBField.initString("");
                public final PBStringField customized_invoke_url = PBField.initString("");
                public final PBStringField channel_id = PBField.initString("");
                public final PBUInt32Field app_score_num = PBField.initUInt32(0);
                public final PBUInt64Field download_num = PBField.initUInt64(0);
                public final PBStringField app_standard_info_url = PBField.initString("");
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class ChosenButton extends MessageMicro<ChosenButton> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{26}, new String[]{"button_infos"}, new Object[]{null}, ChosenButton.class);
                public final PBRepeatMessageField<ButtonInfo> button_infos = PBField.initRepeatMessage(ButtonInfo.class);

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ButtonInfo extends MessageMicro<ButtonInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50}, new String[]{AppDownloadCallback.BUTTON_TXT, "langing_page", "click_url", MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE, "wechat_app_info", "wechat_canvas_info"}, new Object[]{"", "", "", 0, null, null}, ButtonInfo.class);
                    public final PBStringField button_txt = PBField.initString("");
                    public final PBStringField langing_page = PBField.initString("");
                    public final PBStringField click_url = PBField.initString("");
                    public final PBInt32Field mini_program_type = PBField.initInt32(0);
                    public WeChatAppInfo wechat_app_info = new WeChatAppInfo();
                    public WeChatCanvasInfo wechat_canvas_info = new WeChatCanvasInfo();
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class WeChatCanvasInfo extends MessageMicro<WeChatCanvasInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"wechat_app_id", "wechat_appid_in_ios", "wechat_canvas_ext_info"}, new Object[]{"", 0L, ""}, WeChatCanvasInfo.class);
                    public final PBStringField wechat_app_id = PBField.initString("");
                    public final PBUInt64Field wechat_appid_in_ios = PBField.initUInt64(0);
                    public final PBStringField wechat_canvas_ext_info = PBField.initString("");
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class CpsRspInfo extends MessageMicro<CpsRspInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 88, 98, 106, 112, 122}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "img_list", "product_name", "product_price", "sales_tips", "h5_page", "deep_link", "apurl", "rl", "catelog_id", "source", "wechat_app_info", "qq_app_info", "product_original_price", "chantag"}, new Object[]{0L, "", "", 0, "", "", "", "", "", 0L, 0, null, null, 0, ""}, CpsRspInfo.class);
                public final PBUInt64Field product_id = PBField.initUInt64(0);
                public final PBRepeatField<String> img_list = PBField.initRepeat(PBStringField.__repeatHelper__);
                public final PBStringField product_name = PBField.initString("");
                public final PBUInt32Field product_price = PBField.initUInt32(0);
                public final PBStringField sales_tips = PBField.initString("");
                public final PBStringField h5_page = PBField.initString("");
                public final PBStringField deep_link = PBField.initString("");
                public final PBStringField apurl = PBField.initString("");

                /* renamed from: rl, reason: collision with root package name */
                public final PBStringField f435901rl = PBField.initString("");
                public final PBUInt64Field catelog_id = PBField.initUInt64(0);
                public final PBUInt32Field source = PBField.initUInt32(0);
                public WeChatAppInfo wechat_app_info = new WeChatAppInfo();
                public QQAppInfo qq_app_info = new QQAppInfo();
                public final PBUInt32Field product_original_price = PBField.initUInt32(0);
                public final PBStringField chantag = PBField.initString("");
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class DestInfo extends MessageMicro<DestInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 64, 74, 80, 90, 98}, new String[]{"dest_url_display_type", "landing_page", "canvas_json", "dest_type", "pop_sheet", "universal_link", "native_link", "interaction_type", "landingpage_dynamic_info", "need_olympic_middle_page", "reward_landing_page_url", "half_screen_card_config"}, new Object[]{0, "", "", 0, "", "", "", 0, null, Boolean.FALSE, "", null}, DestInfo.class);
                public final PBUInt32Field dest_url_display_type = PBField.initUInt32(0);
                public final PBStringField landing_page = PBField.initString("");
                public final PBStringField canvas_json = PBField.initString("");
                public final PBUInt32Field dest_type = PBField.initUInt32(0);
                public final PBStringField pop_sheet = PBField.initString("");
                public final PBStringField universal_link = PBField.initString("");
                public final PBStringField native_link = PBField.initString("");
                public final PBUInt32Field interaction_type = PBField.initUInt32(0);
                public qq_common.LandingpageDynamicInfo landingpage_dynamic_info = new qq_common.LandingpageDynamicInfo();
                public final PBBoolField need_olympic_middle_page = PBField.initBool(false);
                public final PBStringField reward_landing_page_url = PBField.initString("");
                public HalfScreenCardConfig half_screen_card_config = new HalfScreenCardConfig();

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class HalfScreenCardConfig extends MessageMicro<HalfScreenCardConfig> {
                    public static final int HALF_SCREEN_CARD_TYPE_CONSULTING = 1;
                    public static final int HALF_SCREEN_CARD_TYPE_UNKNOWN = 0;
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"half_screen_card_type", "additional_txt", "consulting_question", "consulting_txt", "consulting_question_urls", "support_auto_send_question"}, new Object[]{0, "", "", "", "", Boolean.FALSE}, HalfScreenCardConfig.class);
                    public final PBRepeatField<String> consulting_question;
                    public final PBRepeatField<String> consulting_question_urls;
                    public final PBStringField consulting_txt;
                    public final PBBoolField support_auto_send_question;
                    public final PBEnumField half_screen_card_type = PBField.initEnum(0);
                    public final PBStringField additional_txt = PBField.initString("");

                    public HalfScreenCardConfig() {
                        PBStringField pBStringField = PBStringField.__repeatHelper__;
                        this.consulting_question = PBField.initRepeat(pBStringField);
                        this.consulting_txt = PBField.initString("");
                        this.consulting_question_urls = PBField.initRepeat(pBStringField);
                        this.support_auto_send_question = PBField.initBool(false);
                    }
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class DisplayInfo extends MessageMicro<DisplayInfo> {
                public static final int FLOATING_ZONE_TYPE_IMAGE_TEXT = 1;
                public static final int FLOATING_ZONE_TYPE_MULTI_BUTTON = 3;
                public static final int FLOATING_ZONE_TYPE_SINGLE_IMAGE = 2;
                public static final int FLOATING_ZONE_TYPE_UNKNOWN = 0;
                public static final int LINK_TYPE_DEEP_LINK = 2;
                public static final int LINK_TYPE_H5 = 1;
                public static final int LINK_TYPE_MINI_PROGRAM = 3;
                public static final int LINK_TYPE_UNKNOWN = 0;
                public static final int OUTER_LAYER_DOWNLOAD_ENABLE = 1;
                public static final int OUTER_LAYER_DOWNLOAD_UNKNOWN = 0;
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBUInt32Field pattern_type = PBField.initUInt32(0);
                public final PBUInt32Field creative_size = PBField.initUInt32(0);
                public final PBUInt32Field animation_effect = PBField.initUInt32(0);
                public BasicInfo basic_info = new BasicInfo();
                public final PBRepeatMessageField<ButtonInfo> button_info = PBField.initRepeatMessage(ButtonInfo.class);
                public MutiPicTextInfo muti_pic_text_info = new MutiPicTextInfo();
                public AdvertiserInfo advertiser_info = new AdvertiserInfo();
                public VideoInfo video_info = new VideoInfo();
                public qq_common.LocalInfo local_info = new qq_common.LocalInfo();
                public final PBUInt32Field mini_program_type = PBField.initUInt32(0);
                public final PBFloatField ecpm = PBField.initFloat(0.0f);
                public final PBUInt32Field inner_adshowtype = PBField.initUInt32(0);
                public VideoInfo video_info2 = new VideoInfo();
                public final PBStringField mini_program_name = PBField.initString("");
                public final PBStringField mini_program_id = PBField.initString("");
                public final PBRepeatMessageField<ContainerAdItem> container_ad_item = PBField.initRepeatMessage(ContainerAdItem.class);
                public final PBRepeatField<String> screenshot_url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
                public final PBUInt32Field pctr = PBField.initUInt32(0);
                public BidInfo bid_info = new BidInfo();
                public final PBFloatField next_total_ecpm = PBField.initFloat(0.0f);
                public ConversionData conversion_data = new ConversionData();
                public FloatingZone floating_zone = new FloatingZone();
                public final PBRepeatMessageField<ActionAreaItem> action_area_item = PBField.initRepeatMessage(ActionAreaItem.class);
                public VideoInfo low_bitrate_video_info = new VideoInfo();
                public Interactive interactive = new Interactive();
                public final PBUInt32Field ad_holdtime_ms = PBField.initUInt32(0);
                public final PBStringField pic_to_video_template_url = PBField.initString("");
                public BannerInfo banner_info = new BannerInfo();
                public final PBRepeatMessageField<MultiClickAreaInfo> multi_click_area_info = PBField.initRepeatMessage(MultiClickAreaInfo.class);
                public final PBRepeatMessageField<BannerInfo> multi_banner_info = PBField.initRepeatMessage(BannerInfo.class);
                public qq_common.LocalStoreInfo local_store_info = new qq_common.LocalStoreInfo();
                public PopupPosterInfo popup_poster_info = new PopupPosterInfo();
                public final PBStringField native_feed_id = PBField.initString("");
                public final PBEnumField outer_layer_download = PBField.initEnum(0);
                public AdSpaceInfo ad_space_info = new AdSpaceInfo();

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ActionAreaItem extends MessageMicro<ActionAreaItem> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"area_type", "area_boundary"}, new Object[]{0, null}, ActionAreaItem.class);
                    public final PBInt32Field area_type = PBField.initInt32(0);
                    public AreaBoundary area_boundary = new AreaBoundary();

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class AreaBoundary extends MessageMicro<AreaBoundary> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{LayoutAttrDefine.MARGIN_LEFT, LayoutAttrDefine.MARGIN_RIGHT, LayoutAttrDefine.MARGIN_TOP, LayoutAttrDefine.MARGIN_BOTTOM}, new Object[]{0, 0, 0, 0}, AreaBoundary.class);
                        public final PBInt32Field margin_left = PBField.initInt32(0);
                        public final PBInt32Field margin_right = PBField.initInt32(0);
                        public final PBInt32Field margin_top = PBField.initInt32(0);
                        public final PBInt32Field margin_bottom = PBField.initInt32(0);
                    }
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class AdSpaceInfo extends MessageMicro<AdSpaceInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"frequency_time", "background_img_url", "slide_threshold"}, new Object[]{0, "", 0}, AdSpaceInfo.class);
                    public final PBUInt32Field frequency_time = PBField.initUInt32(0);
                    public final PBStringField background_img_url = PBField.initString("");
                    public final PBUInt32Field slide_threshold = PBField.initUInt32(0);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class AdvertiserInfo extends MessageMicro<AdvertiserInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 66}, new String[]{"corporation_name", "corporate_image_name", "corporate_logo", "advertiser_id", "ad_first_category", "ad_second_category", "ad_industry_id", "advertiser_group_name"}, new Object[]{"", "", "", 0L, 0L, 0L, 0L, ""}, AdvertiserInfo.class);
                    public final PBStringField corporation_name = PBField.initString("");
                    public final PBStringField corporate_image_name = PBField.initString("");
                    public final PBStringField corporate_logo = PBField.initString("");
                    public final PBUInt64Field advertiser_id = PBField.initUInt64(0);
                    public final PBUInt64Field ad_first_category = PBField.initUInt64(0);
                    public final PBUInt64Field ad_second_category = PBField.initUInt64(0);
                    public final PBUInt64Field ad_industry_id = PBField.initUInt64(0);
                    public final PBStringField advertiser_group_name = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class BannerInfo extends MessageMicro<BannerInfo> {
                    public static final int TYPE_NATIVE_AD_STAGE_1 = 1;
                    public static final int TYPE_NATIVE_AD_STAGE_2 = 3;
                    public static final int TYPE_NATIVE_AD_STAGE_3 = 4;
                    public static final int TYPE_UNKNOWN = 0;
                    public static final int TYPE_WECHAT_MINI_GAME = 2;
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 56}, new String[]{"icon_url", "icon_title", "adv_tips_url", "type", AppDownloadCallback.BUTTON_TXT, "begin_showtime", "showtime"}, new Object[]{"", "", "", 0, "", 0, 0}, BannerInfo.class);
                    public final PBStringField icon_url = PBField.initString("");
                    public final PBStringField icon_title = PBField.initString("");
                    public final PBStringField adv_tips_url = PBField.initString("");
                    public final PBEnumField type = PBField.initEnum(0);
                    public final PBStringField button_txt = PBField.initString("");
                    public final PBUInt32Field begin_showtime = PBField.initUInt32(0);
                    public final PBUInt32Field showtime = PBField.initUInt32(0);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class BasicInfo extends MessageMicro<BasicInfo> {
                    static final MessageMicro.FieldMap __fieldMap__;
                    public final PBStringField img = PBField.initString("");
                    public final PBStringField img_s = PBField.initString("");
                    public final PBStringField txt = PBField.initString("");
                    public final PBStringField desc = PBField.initString("");
                    public final PBUInt32Field pic_width = PBField.initUInt32(0);
                    public final PBUInt32Field pic_height = PBField.initUInt32(0);
                    public final PBUInt32Field ad_type = PBField.initUInt32(0);
                    public CreativeElementStructureContent element_structure_content = new CreativeElementStructureContent();
                    public final PBStringField marketing_pendant = PBField.initString("");
                    public final PBRepeatField<String> hit_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
                    public final PBRepeatMessageField<MaterialInfo> materials = PBField.initRepeatMessage(MaterialInfo.class);
                    public QQBrowserExternalInfo qq_browser_ext_info = new QQBrowserExternalInfo();
                    public final PBBoolField is_preview_ad = PBField.initBool(false);
                    public final PBBoolField is_mdpa_ad = PBField.initBool(false);
                    public final PBBoolField is_contract_ad = PBField.initBool(false);
                    public final PBStringField top_left_icon_url = PBField.initString("");
                    public final PBStringField card_background_url = PBField.initString("");
                    public final PBRepeatField<Integer> ad_extension_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
                    public final PBUInt32Field creative_template_id = PBField.initUInt32(0);
                    public final PBUInt64Field fingerprint_product = PBField.initUInt64(0);
                    public final PBUInt64Field fingerprint_tid = PBField.initUInt64(0);
                    public final PBEnumField card_background_img_format = PBField.initEnum(0);
                    public final PBStringField img3_url = PBField.initString("");
                    public final PBStringField left_bottom_txt = PBField.initString("");
                    public final PBStringField mask_image_url = PBField.initString("");
                    public final PBUInt32Field mdpa_render_type = PBField.initUInt32(0);

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class CreativeElementStructureContent extends MessageMicro<CreativeElementStructureContent> {
                        public static final int LABEL_DIRECTION_LEFT = 1;
                        public static final int LABEL_DIRECTION_RIGHT = 2;
                        public static final int LABEL_DIRECTION_UNKONWN = 0;
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"label"}, new Object[]{null}, CreativeElementStructureContent.class);
                        public final PBRepeatMessageField<Label> label = PBField.initRepeatMessage(Label.class);

                        /* compiled from: P */
                        /* loaded from: classes29.dex */
                        public static final class Label extends MessageMicro<Label> {
                            public static final int LABEL_TYPE_COMMON = 1;
                            public static final int LABEL_TYPE_CUSTOMIZETEXT = 3;
                            public static final int LABEL_TYPE_ICON = 4;
                            public static final int LABEL_TYPE_PROMOTIONAL = 2;
                            public static final int LABEL_TYPE_UNKNOWN = 0;
                            public static final int LABEL_TYPE_WECHAT_GAME = 1000;
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 56, 64, 72}, new String[]{"coordinate_x", "coordinate_y", "content", "direction", "landing_page_url", "angle", "percent", "order", "type"}, new Object[]{0, 0, "", 0, "", 0, 0, 0, 0}, Label.class);
                            public final PBUInt32Field coordinate_x = PBField.initUInt32(0);
                            public final PBUInt32Field coordinate_y = PBField.initUInt32(0);
                            public final PBStringField content = PBField.initString("");
                            public final PBEnumField direction = PBField.initEnum(0);
                            public final PBStringField landing_page_url = PBField.initString("");
                            public final PBUInt32Field angle = PBField.initUInt32(0);
                            public final PBUInt32Field percent = PBField.initUInt32(0);
                            public final PBUInt32Field order = PBField.initUInt32(0);
                            public final PBEnumField type = PBField.initEnum(0);
                        }
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class MaterialInfo extends MessageMicro<MaterialInfo> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104, 112, 122}, new String[]{"search_txt", "search_desc", "image_url", "click_url", "price", "title", "template_image_url", "original_price", QZoneAdTianshuFeedData.KEY_SCHEMA_URL, "universal_link", "wx_mini_program_path", "landingpage_url", "purchase", "is_new_product", "attributes"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", "", 0L, Boolean.FALSE, ""}, MaterialInfo.class);
                        public final PBStringField search_txt = PBField.initString("");
                        public final PBStringField search_desc = PBField.initString("");
                        public final PBStringField image_url = PBField.initString("");
                        public final PBStringField click_url = PBField.initString("");
                        public final PBStringField price = PBField.initString("");
                        public final PBStringField title = PBField.initString("");
                        public final PBStringField template_image_url = PBField.initString("");
                        public final PBStringField original_price = PBField.initString("");
                        public final PBStringField schema_url = PBField.initString("");
                        public final PBStringField universal_link = PBField.initString("");
                        public final PBStringField wx_mini_program_path = PBField.initString("");
                        public final PBStringField landingpage_url = PBField.initString("");
                        public final PBUInt64Field purchase = PBField.initUInt64(0);
                        public final PBBoolField is_new_product = PBField.initBool(false);
                        public final PBRepeatField<String> attributes = PBField.initRepeat(PBStringField.__repeatHelper__);
                    }

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class QQBrowserExternalInfo extends MessageMicro<QQBrowserExternalInfo> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 58}, new String[]{"ad_timeout", "qq_browser_ext", "domain", "trl", "pos_pic_h", "pos_pic_w", "floating_red_string"}, new Object[]{0L, "", "", "", 0, 0, ""}, QQBrowserExternalInfo.class);
                        public final PBUInt64Field ad_timeout = PBField.initUInt64(0);
                        public final PBStringField qq_browser_ext = PBField.initString("");
                        public final PBStringField domain = PBField.initString("");
                        public final PBStringField trl = PBField.initString("");
                        public final PBUInt32Field pos_pic_h = PBField.initUInt32(0);
                        public final PBUInt32Field pos_pic_w = PBField.initUInt32(0);
                        public final PBStringField floating_red_string = PBField.initString("");
                    }

                    static {
                        String[] strArr = {"img", "img_s", FileReaderHelper.TXT_EXT, "desc", "pic_width", "pic_height", "ad_type", "element_structure_content", "marketing_pendant", "hit_keywords", "materials", "qq_browser_ext_info", "is_preview_ad", "is_mdpa_ad", "is_contract_ad", "top_left_icon_url", "card_background_url", "ad_extension_type", "creative_template_id", "fingerprint_product", "fingerprint_tid", "card_background_img_format", "img3_url", "left_bottom_txt", "mask_image_url", "mdpa_render_type"};
                        Boolean bool = Boolean.FALSE;
                        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 66, 74, 82, 90, 98, 104, 112, 120, 130, 138, 144, 152, 160, 168, 176, 186, 194, 202, 208}, strArr, new Object[]{"", "", "", "", 0, 0, 0, null, "", "", null, null, bool, bool, bool, "", "", 0, 0, 0L, 0L, 0, "", "", "", 0}, BasicInfo.class);
                    }
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class BidInfo extends MessageMicro<BidInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 41, 53}, new String[]{"cost_type", "expect_cost", "ad_cost", "fixed_pctr", "raw_fixed_pctr", "pctr_petr_weight"}, new Object[]{0, 0, 0, "", Double.valueOf(0.0d), Float.valueOf(0.0f)}, BidInfo.class);
                    public final PBUInt32Field cost_type = PBField.initUInt32(0);
                    public final PBUInt32Field expect_cost = PBField.initUInt32(0);
                    public final PBUInt32Field ad_cost = PBField.initUInt32(0);
                    public final PBStringField fixed_pctr = PBField.initString("");
                    public final PBDoubleField raw_fixed_pctr = PBField.initDouble(0.0d);
                    public final PBFloatField pctr_petr_weight = PBField.initFloat(0.0f);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ButtonInfo extends MessageMicro<ButtonInfo> {
                    public static final int BUTTON_POS_LEFT_BOTTOM_CORNER = 1;
                    public static final int BUTTON_POS_RIGHT_BOTTOM_CORNER = 2;
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{FileReaderHelper.TXT_EXT, "url", c.G}, new Object[]{"", "", 1}, ButtonInfo.class);
                    public final PBStringField txt = PBField.initString("");
                    public final PBStringField url = PBField.initString("");
                    public final PBEnumField pos = PBField.initEnum(1);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ContainerAdItem extends MessageMicro<ContainerAdItem> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"img_url_list", "desc", "dest_url", "rl", AppDownloadCallback.BUTTON_TXT}, new Object[]{"", "", "", "", ""}, ContainerAdItem.class);
                    public final PBRepeatField<String> img_url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
                    public final PBStringField desc = PBField.initString("");
                    public final PBStringField dest_url = PBField.initString("");

                    /* renamed from: rl, reason: collision with root package name */
                    public final PBStringField f435902rl = PBField.initString("");
                    public final PBStringField button_txt = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ConversionData extends MessageMicro<ConversionData> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"conversion_desc", "conversion_target_type"}, new Object[]{"", 0}, ConversionData.class);
                    public final PBStringField conversion_desc = PBField.initString("");
                    public final PBInt32Field conversion_target_type = PBField.initInt32(0);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class FloatingZone extends MessageMicro<FloatingZone> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74}, new String[]{"image_url", "name", "tag", "price", "discount", QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "floating_desc", "type", "multi_buttons"}, new Object[]{"", "", "", "", "", "", "", 1, null}, FloatingZone.class);
                    public final PBStringField image_url = PBField.initString("");
                    public final PBStringField name = PBField.initString("");
                    public final PBRepeatField<String> tag = PBField.initRepeat(PBStringField.__repeatHelper__);
                    public final PBStringField price = PBField.initString("");
                    public final PBStringField discount = PBField.initString("");
                    public final PBStringField button_text = PBField.initString("");
                    public final PBStringField floating_desc = PBField.initString("");
                    public final PBEnumField type = PBField.initEnum(1);
                    public final PBRepeatMessageField<qq_common.MultiButton> multi_buttons = PBField.initRepeatMessage(qq_common.MultiButton.class);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class Interactive extends MessageMicro<Interactive> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66, 74, 82, 90, 98, 104, 114, 120, 128, 138}, new String[]{"sensitivity", "shake_times", "x_axis_acceleration_rate", "y_axis_acceleration_rate", "z_axis_acceleration_rate", "display_code_list", "icon_transparency", "icon_url", "icon_title", "title", "description", "shake_lottie_animation_url", "shake_animation_time", "transition_animation_url", "component_position", "mask_appear_time", "timeline_widget"}, new Object[]{0, 0, 0, 0, 0, "", 0, "", "", "", "", "", 0, "", 0, 0, null}, Interactive.class);
                    public final PBUInt32Field sensitivity = PBField.initUInt32(0);
                    public final PBUInt32Field shake_times = PBField.initUInt32(0);
                    public final PBUInt32Field x_axis_acceleration_rate = PBField.initUInt32(0);
                    public final PBUInt32Field y_axis_acceleration_rate = PBField.initUInt32(0);
                    public final PBUInt32Field z_axis_acceleration_rate = PBField.initUInt32(0);
                    public final PBRepeatField<String> display_code_list = PBField.initRepeat(PBStringField.__repeatHelper__);
                    public final PBUInt32Field icon_transparency = PBField.initUInt32(0);
                    public final PBStringField icon_url = PBField.initString("");
                    public final PBStringField icon_title = PBField.initString("");
                    public final PBStringField title = PBField.initString("");
                    public final PBStringField description = PBField.initString("");
                    public final PBStringField shake_lottie_animation_url = PBField.initString("");
                    public final PBUInt32Field shake_animation_time = PBField.initUInt32(0);
                    public final PBStringField transition_animation_url = PBField.initString("");
                    public final PBUInt32Field component_position = PBField.initUInt32(0);
                    public final PBUInt32Field mask_appear_time = PBField.initUInt32(0);
                    public TimelineWidget timeline_widget = new TimelineWidget();

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class TimelineWidget extends MessageMicro<TimelineWidget> {
                        public static final int COMPONENT_TYPE_NORMAL = 1;
                        public static final int COMPONENT_TYPE_UNKNOWN = 0;
                        public static final int COMPONENT_TYPE_WITH_BOOKING = 2;
                        public static final int THEME_TEMPLATE_BLUE = 1;
                        public static final int THEME_TEMPLATE_GOLDEN = 2;
                        public static final int THEME_TEMPLATE_GREEN = 3;
                        public static final int THEME_TEMPLATE_GREY = 5;
                        public static final int THEME_TEMPLATE_ORANGE = 4;
                        public static final int THEME_TEMPLATE_UNKNOWN = 0;
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"component_list"}, new Object[]{null}, TimelineWidget.class);
                        public final PBRepeatMessageField<Component> component_list = PBField.initRepeatMessage(Component.class);

                        /* compiled from: P */
                        /* loaded from: classes29.dex */
                        public static final class Component extends MessageMicro<Component> {
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 98, 106}, new String[]{"text", "theme_color", "image_url", "brand_image_url", "button_image_url", AppDownloadCallback.BUTTON_TXT, "count_down_anchor", "is_show_count_down", "duration", "component_type", "theme_template", "night_image_url", "theme_color_list"}, new Object[]{"", "", "", "", "", "", 0, 0, null, 0, 0, "", ""}, Component.class);
                            public final PBStringField text = PBField.initString("");
                            public final PBStringField theme_color = PBField.initString("");
                            public final PBStringField image_url = PBField.initString("");
                            public final PBStringField brand_image_url = PBField.initString("");
                            public final PBStringField button_image_url = PBField.initString("");
                            public final PBStringField button_txt = PBField.initString("");
                            public final PBUInt32Field count_down_anchor = PBField.initUInt32(0);
                            public final PBUInt32Field is_show_count_down = PBField.initUInt32(0);
                            public DisplayDuration duration = new DisplayDuration();
                            public final PBEnumField component_type = PBField.initEnum(0);
                            public final PBEnumField theme_template = PBField.initEnum(0);
                            public final PBStringField night_image_url = PBField.initString("");
                            public final PBRepeatField<String> theme_color_list = PBField.initRepeat(PBStringField.__repeatHelper__);
                        }

                        /* compiled from: P */
                        /* loaded from: classes29.dex */
                        public static final class DisplayDuration extends MessageMicro<DisplayDuration> {
                            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"begin", "end"}, new Object[]{0, 0}, DisplayDuration.class);
                            public final PBUInt32Field begin = PBField.initUInt32(0);
                            public final PBUInt32Field end = PBField.initUInt32(0);
                        }
                    }
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
                public static final class MultiButton extends MessageMicro<MultiButton> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{QZoneAdTianshuFeedData.KEY_BUTTON_TEXT, "link_type", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK}, new Object[]{"", 0, ""}, MultiButton.class);
                    public final PBStringField button_text = PBField.initString("");
                    public final PBEnumField link_type = PBField.initEnum(0);
                    public final PBStringField link = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class MultiClickAreaInfo extends MessageMicro<MultiClickAreaInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"begin_play_percent", "end_play_percent", "click_area_from_bottom", "tips"}, new Object[]{0, 0, 0, ""}, MultiClickAreaInfo.class);
                    public final PBUInt32Field begin_play_percent = PBField.initUInt32(0);
                    public final PBUInt32Field end_play_percent = PBField.initUInt32(0);
                    public final PBUInt32Field click_area_from_bottom = PBField.initUInt32(0);
                    public final PBStringField tips = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class MutiPicTextInfo extends MessageMicro<MutiPicTextInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{FileReaderHelper.TXT_EXT, "image", "url"}, new Object[]{"", "", ""}, MutiPicTextInfo.class);
                    public final PBRepeatField<String> image;
                    public final PBRepeatField<String> txt;
                    public final PBRepeatField<String> url;

                    public MutiPicTextInfo() {
                        PBStringField pBStringField = PBStringField.__repeatHelper__;
                        this.txt = PBField.initRepeat(pBStringField);
                        this.image = PBField.initRepeat(pBStringField);
                        this.url = PBField.initRepeat(pBStringField);
                    }
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class PopupPosterInfo extends MessageMicro<PopupPosterInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"img", "appear_time", "disappear_time", "background_color", "font_color", "text"}, new Object[]{"", 0, 0, "", "", ""}, PopupPosterInfo.class);
                    public final PBStringField img = PBField.initString("");
                    public final PBUInt32Field appear_time = PBField.initUInt32(0);
                    public final PBUInt32Field disappear_time = PBField.initUInt32(0);
                    public final PBStringField background_color = PBField.initString("");
                    public final PBStringField font_color = PBField.initString("");
                    public final PBStringField text = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class VideoInfo extends MessageMicro<VideoInfo> {
                    public static final int VIDEO_CODEC_AV1 = 2;
                    public static final int VIDEO_CODEC_H264 = 0;
                    public static final int VIDEO_CODEC_H265_HVC1 = 1;
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50, 56, 64, 74, 80, 88, 96}, new String[]{"video_url", "media_duration", "tencent_video_id", "video_file_size", "no_auto_play", "endcard", "endcard_load_time", "endcard_direction", "bottom_card_url", "height", "width", "codec"}, new Object[]{"", 0, "", 0, Boolean.FALSE, "", 0, 0, "", 0, 0, 0}, VideoInfo.class);
                    public final PBStringField video_url = PBField.initString("");
                    public final PBUInt32Field media_duration = PBField.initUInt32(0);
                    public final PBStringField tencent_video_id = PBField.initString("");
                    public final PBUInt32Field video_file_size = PBField.initUInt32(0);
                    public final PBBoolField no_auto_play = PBField.initBool(false);
                    public final PBStringField endcard = PBField.initString("");
                    public final PBUInt32Field endcard_load_time = PBField.initUInt32(0);
                    public final PBUInt32Field endcard_direction = PBField.initUInt32(0);
                    public final PBStringField bottom_card_url = PBField.initString("");
                    public final PBUInt32Field height = PBField.initUInt32(0);
                    public final PBUInt32Field width = PBField.initUInt32(0);
                    public final PBEnumField codec = PBField.initEnum(0);
                }

                static {
                    int[] iArr = {8, 16, 24, 34, 42, 50, 58, 66, 74, 80, 93, 96, 106, 114, 122, 130, 138, 144, 154, 165, 170, 178, 186, 194, 202, 208, 218, 226, 234, 242, 250, 258, 266, 272, FilterEnum.MIC_PTU_BAIXI};
                    String[] strArr = {"pattern_type", "creative_size", "animation_effect", "basic_info", "button_info", "muti_pic_text_info", "advertiser_info", "video_info", SearchConfig.ENGINE_LOCAL_INFO, MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE, "ecpm", "inner_adshowtype", "video_info2", "mini_program_name", "mini_program_id", "container_ad_item", "screenshot_url_list", "pctr", "bid_info", "next_total_ecpm", "conversion_data", "floating_zone", "action_area_item", "low_bitrate_video_info", "interactive", "ad_holdtime_ms", "pic_to_video_template_url", "banner_info", "multi_click_area_info", "multi_banner_info", "local_store_info", "popup_poster_info", "native_feed_id", "outer_layer_download", "ad_space_info"};
                    Float valueOf = Float.valueOf(0.0f);
                    __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0, 0, 0, null, null, null, null, null, null, 0, valueOf, 0, null, "", "", null, "", 0, null, valueOf, null, null, null, null, null, 0, "", null, null, null, null, null, "", 0, null}, DisplayInfo.class);
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class DynamicInfo extends MessageMicro<DynamicInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"hippy_type", "module_id", "template_id"}, new Object[]{0, "", ""}, DynamicInfo.class);
                public final PBEnumField hippy_type = PBField.initEnum(0);
                public final PBStringField module_id = PBField.initString("");
                public final PBStringField template_id = PBField.initString("");
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class ExpInfo extends MessageMicro<ExpInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"qq_game_video_ad_style", "reward_video_download_type", "video_countdown", "video_volume", "video_countdown_style", "interstitial_ad_style"}, new Object[]{0, 0, 0, 0, 0, 0}, ExpInfo.class);
                public final PBInt32Field qq_game_video_ad_style = PBField.initInt32(0);
                public final PBInt32Field reward_video_download_type = PBField.initInt32(0);
                public final PBInt32Field video_countdown = PBField.initInt32(0);
                public final PBInt32Field video_volume = PBField.initInt32(0);
                public final PBInt32Field video_countdown_style = PBField.initInt32(0);
                public final PBInt32Field interstitial_ad_style = PBField.initInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class ExpParam extends MessageMicro<ExpParam> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"key", "value"}, new Object[]{0, ""}, ExpParam.class);
                public final PBUInt32Field key = PBField.initUInt32(0);
                public final PBStringField value = PBField.initString("");
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class Ext extends MessageMicro<Ext> {
                public static final int COUNTDOWN_TYPE_FINISH = 1;
                public static final int COUNTDOWN_TYPE_START = 2;
                public static final int COUNTDOWN_TYPE_UNKNOWN = 0;
                public static final int LANDINGPAGE_OPEN_TYPE_DEEPLINK_AND_H5 = 1;
                public static final int LANDINGPAGE_OPEN_TYPE_DEEPLINK_FALLBACK_TO_H5 = 2;
                public static final int LANDINGPAGE_OPEN_TYPE_UNKNOWN = 0;
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBUInt32Field ad_auto_refresh_interval;
                public final PBUInt32Field ad_auto_request_interval;
                public final PBBoolField allow_external_download;
                public AppChannelInfo app_channel_info;
                public final PBUInt32Field auto_open_endcard_after_reward;
                public final PBInt32Field bottom_style_id;
                public final PBUInt32Field bottomcard_click_mode;
                public final PBUInt32Field bottomcard_show_delay_time;
                public final PBRepeatField<String> bullet_screen;
                public final PBUInt32Field button_color_change_delay_time;
                public final PBUInt32Field button_delay_time;
                public final PBUInt32Field card_show_delay_time;
                public final PBRepeatMessageField<CarouselAdItem> carousel_ad_items;
                public ChosenButton chosen_button;
                public final PBUInt32Field click_area_from_bottom;
                public final PBUInt32Field countdown_end_time;
                public final PBEnumField countdown_type;
                public final PBBoolField disable_jump_app_home;
                public final PBBoolField disable_video_on_top;
                public final PBUInt32Field disbale_dialog_before_reward;
                public final PBStringField download_api_url;
                public final PBUInt32Field enable_half_card;
                public final PBUInt32Field endcard_click_mode;
                public final PBInt32Field endcard_style_id;
                public ExtraButtonTxt extra_button_txt;
                public final PBRepeatMessageField<qq_common.FloatingTip> floating_tips;
                public final PBUInt32Field fullscreen_click_mode;
                public final PBBoolField has_reward_quit_tips;
                public final PBStringField icon_url;
                public final PBStringField img2;
                public final PBUInt32Field inner_adshowtype;
                public final PBStringField interactive_tip_txt;
                public final PBBoolField is_app_preorder;
                public final PBBoolField is_reward_page;
                public final PBUInt32Field is_show_dialog_before_reward;
                public final PBUInt32Field is_third_link_ad;
                public JumpAndroidMarket jump_android_market_info;
                public final PBEnumField landingpage_open_type;
                public final PBFloatField linear_reward_ratio;
                public qq_common.LocalStoreInfo local_store_info;
                public final PBBoolField need_outer_jump_dest;
                public final PBStringField portrait_video_top_player_proportion;
                public final PBStringField quick_app_link;
                public RedDotControl red_dot_control;
                public final PBRepeatField<String> screenshot_url_list;
                public SkAdNetwork sk_ad_network;
                public final PBInt64Field timestamp;
                public final PBStringField web_ext_data;
                public final PBUInt64Field wechat_appid_in_ios;
                public final PBStringField wechat_canvas_ext_info;
                public final PBEnumField wechat_mini_program_open_type;
                public final PBUInt32Field wx_minigame_jump_type;
                public final PBStringField zip_url;
                public final PBUInt32Field mini_program_preload = PBField.initUInt32(0);
                public final PBBoolField no_clkcgi_jump = PBField.initBool(false);
                public final PBInt32Field landing_page_style = PBField.initInt32(0);
                public final PBStringField market_deep_link = PBField.initString("");
                public final PBBoolField disable_auto_download = PBField.initBool(false);
                public final PBStringField market_package_name = PBField.initString("");
                public final PBEnumField render_pos_type = PBField.initEnum(0);
                public final PBRepeatMessageField<ExpParam> exp_map = PBField.initRepeatMessage(ExpParam.class);
                public OfflinePageInfo xj_offline = new OfflinePageInfo();
                public final PBUInt32Field relation_target = PBField.initUInt32(0);

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class CarouselAdItem extends MessageMicro<CarouselAdItem> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98}, new String[]{"image_url", "video_url", "click_url", "wechat_app_path", "universal_link", "deep_link", "view_id", "interactive_url", "creative_element_id", "video_duration", "desc", "landingpage_url"}, new Object[]{"", "", "", "", "", "", "", "", 0L, 0, "", ""}, CarouselAdItem.class);
                    public final PBStringField image_url = PBField.initString("");
                    public final PBStringField video_url = PBField.initString("");
                    public final PBStringField click_url = PBField.initString("");
                    public final PBStringField wechat_app_path = PBField.initString("");
                    public final PBStringField universal_link = PBField.initString("");
                    public final PBStringField deep_link = PBField.initString("");
                    public final PBStringField view_id = PBField.initString("");
                    public final PBStringField interactive_url = PBField.initString("");
                    public final PBUInt64Field creative_element_id = PBField.initUInt64(0);
                    public final PBUInt32Field video_duration = PBField.initUInt32(0);
                    public final PBStringField desc = PBField.initString("");
                    public final PBStringField landingpage_url = PBField.initString("");
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ExtraButtonTxt extends MessageMicro<ExtraButtonTxt> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"app_not_download", "app_download_paused", "app_downloaded", "app_installed", "customized_txt", "app_downloading"}, new Object[]{"", "", "", "", "", ""}, ExtraButtonTxt.class);
                    public final PBStringField app_not_download = PBField.initString("");
                    public final PBStringField app_download_paused = PBField.initString("");
                    public final PBStringField app_downloaded = PBField.initString("");
                    public final PBStringField app_installed = PBField.initString("");
                    public final PBStringField customized_txt = PBField.initString("");
                    public final PBStringField app_downloading = PBField.initString("");
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
                public static final class RedDotControl extends MessageMicro<RedDotControl> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"pop_mask_type", "auto_jump_countdown"}, new Object[]{0, 0}, RedDotControl.class);
                    public final PBUInt32Field pop_mask_type = PBField.initUInt32(0);
                    public final PBUInt32Field auto_jump_countdown = PBField.initUInt32(0);
                }

                static {
                    int[] iArr = {8, 16, 24, 34, 40, 50, 56, 66, 74, 80, 90, 98, 104, 112, 120, 128, 136, 144, 154, 160, 170, 178, 186, 192, 202, 208, 216, 224, 237, 240, 248, 258, 266, 272, FilterEnum.MIC_PTU_BAIXI, 290, 296, 304, 312, 320, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 336, a.CTRL_INDEX, g.CTRL_INDEX, 362, 370, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, 386, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 400, 408, 418, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 432, 440, TroopInfo.PAY_PRIVILEGE_ALL, 458, 464, 474, 480, 488, w.CTRL_INDEX, 504};
                    String[] strArr = {"mini_program_preload", "no_clkcgi_jump", "landing_page_style", "market_deep_link", "disable_auto_download", "market_package_name", "render_pos_type", "exp_map", "xj_offline", "relation_target", "screenshot_url_list", "sk_ad_network", "is_app_preorder", "countdown_end_time", "timestamp", "allow_external_download", "bottom_style_id", "endcard_style_id", "bullet_screen", "disable_video_on_top", "floating_tips", "app_channel_info", "download_api_url", "wechat_appid_in_ios", "wechat_canvas_ext_info", "inner_adshowtype", "button_delay_time", "disable_jump_app_home", "linear_reward_ratio", "has_reward_quit_tips", "need_outer_jump_dest", QWalletPreferenceApiImpl.PREF_KEY_ZIP_URL, "portrait_video_top_player_proportion", "is_reward_page", "extra_button_txt", "chosen_button", "fullscreen_click_mode", "bottomcard_click_mode", "endcard_click_mode", "disbale_dialog_before_reward", "icon_url", "auto_open_endcard_after_reward", "button_color_change_delay_time", "card_show_delay_time", "jump_android_market_info", "quick_app_link", "carousel_ad_items", "img2", "wx_minigame_jump_type", BannerAdPlugin.AD_AUTO_REFRESH_INTERVAL, "ad_auto_request_interval", "interactive_tip_txt", "web_ext_data", "click_area_from_bottom", "countdown_type", "bottomcard_show_delay_time", "red_dot_control", "enable_half_card", "local_store_info", "is_third_link_ad", "is_show_dialog_before_reward", "landingpage_open_type", "wechat_mini_program_open_type"};
                    Boolean bool = Boolean.FALSE;
                    __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0, bool, 0, "", bool, "", 0, null, null, 0, "", null, bool, 0, 0L, bool, 0, 0, "", bool, null, null, "", 0L, "", 0, 0, bool, Float.valueOf(0.0f), bool, bool, "", "", bool, null, null, 0, 0, 0, 0, "", 0, 0, 0, null, "", null, "", 0, 0, 0, "", "", 0, 0, 0, null, 0, null, 0, 0, 0, 0}, Ext.class);
                }

                public Ext() {
                    PBStringField pBStringField = PBStringField.__repeatHelper__;
                    this.screenshot_url_list = PBField.initRepeat(pBStringField);
                    this.sk_ad_network = new SkAdNetwork();
                    this.is_app_preorder = PBField.initBool(false);
                    this.countdown_end_time = PBField.initUInt32(0);
                    this.timestamp = PBField.initInt64(0L);
                    this.allow_external_download = PBField.initBool(false);
                    this.bottom_style_id = PBField.initInt32(0);
                    this.endcard_style_id = PBField.initInt32(0);
                    this.bullet_screen = PBField.initRepeat(pBStringField);
                    this.disable_video_on_top = PBField.initBool(false);
                    this.floating_tips = PBField.initRepeatMessage(qq_common.FloatingTip.class);
                    this.app_channel_info = new AppChannelInfo();
                    this.download_api_url = PBField.initString("");
                    this.wechat_appid_in_ios = PBField.initUInt64(0L);
                    this.wechat_canvas_ext_info = PBField.initString("");
                    this.inner_adshowtype = PBField.initUInt32(0);
                    this.button_delay_time = PBField.initUInt32(0);
                    this.disable_jump_app_home = PBField.initBool(false);
                    this.linear_reward_ratio = PBField.initFloat(0.0f);
                    this.has_reward_quit_tips = PBField.initBool(false);
                    this.need_outer_jump_dest = PBField.initBool(false);
                    this.zip_url = PBField.initString("");
                    this.portrait_video_top_player_proportion = PBField.initString("");
                    this.is_reward_page = PBField.initBool(false);
                    this.extra_button_txt = new ExtraButtonTxt();
                    this.chosen_button = new ChosenButton();
                    this.fullscreen_click_mode = PBField.initUInt32(0);
                    this.bottomcard_click_mode = PBField.initUInt32(0);
                    this.endcard_click_mode = PBField.initUInt32(0);
                    this.disbale_dialog_before_reward = PBField.initUInt32(0);
                    this.icon_url = PBField.initString("");
                    this.auto_open_endcard_after_reward = PBField.initUInt32(0);
                    this.button_color_change_delay_time = PBField.initUInt32(0);
                    this.card_show_delay_time = PBField.initUInt32(0);
                    this.jump_android_market_info = new JumpAndroidMarket();
                    this.quick_app_link = PBField.initString("");
                    this.carousel_ad_items = PBField.initRepeatMessage(CarouselAdItem.class);
                    this.img2 = PBField.initString("");
                    this.wx_minigame_jump_type = PBField.initUInt32(0);
                    this.ad_auto_refresh_interval = PBField.initUInt32(0);
                    this.ad_auto_request_interval = PBField.initUInt32(0);
                    this.interactive_tip_txt = PBField.initString("");
                    this.web_ext_data = PBField.initString("");
                    this.click_area_from_bottom = PBField.initUInt32(0);
                    this.countdown_type = PBField.initEnum(0);
                    this.bottomcard_show_delay_time = PBField.initUInt32(0);
                    this.red_dot_control = new RedDotControl();
                    this.enable_half_card = PBField.initUInt32(0);
                    this.local_store_info = new qq_common.LocalStoreInfo();
                    this.is_third_link_ad = PBField.initUInt32(0);
                    this.is_show_dialog_before_reward = PBField.initUInt32(0);
                    this.landingpage_open_type = PBField.initEnum(0);
                    this.wechat_mini_program_open_type = PBField.initEnum(0);
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class JumpAndroidMarket extends MessageMicro<JumpAndroidMarket> {
                public static final int MARKET_JUMP_TYPE_NOT_JUMP = 0;
                public static final int MARKET_JUMP_TYPE_TERMINAL_JUMP = 1;
                public static final int MARKET_JUMP_TYPE_XIJING_JUMP = 2;
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"market_deep_link", "market_package_name", "market_jump_type"}, new Object[]{"", "", 0}, JumpAndroidMarket.class);
                public final PBStringField market_deep_link = PBField.initString("");
                public final PBRepeatField<String> market_package_name = PBField.initRepeat(PBStringField.__repeatHelper__);
                public final PBEnumField market_jump_type = PBField.initEnum(0);
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class LocalStoreInfo extends MessageMicro<LocalStoreInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"store_name"}, new Object[]{""}, LocalStoreInfo.class);
                public final PBStringField store_name = PBField.initString("");
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class OfflinePageInfo extends MessageMicro<OfflinePageInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"offline_landing_page", "offline_json_url", "offline_json_key", "offline_id"}, new Object[]{"", "", "", 0}, OfflinePageInfo.class);
                public final PBStringField offline_landing_page = PBField.initString("");
                public final PBStringField offline_json_url = PBField.initString("");
                public final PBStringField offline_json_key = PBField.initString("");
                public final PBInt32Field offline_id = PBField.initInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class QQAppInfo extends MessageMicro<QQAppInfo> {
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField app_id;
                public final PBBytesField app_path;
                public final PBBytesField app_schema;

                static {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"app_id", "app_path", "app_schema"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, QQAppInfo.class);
                }

                public QQAppInfo() {
                    ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                    this.app_id = PBField.initBytes(byteStringMicro);
                    this.app_path = PBField.initBytes(byteStringMicro);
                    this.app_schema = PBField.initBytes(byteStringMicro);
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class ReportInfo extends MessageMicro<ReportInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114}, new String[]{"exposure_url", "click_url", "effect_url", "landing_page_report_url", Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO, "trace_info", "video_report_url", "thirdparty_monitor_urls", "original_exposure_url", "complaint_url", "neg_fb_items", TVKDataBinder.KEY_REPORT_TYPE, "imp_stay_report_url", "pre_exposure_action_report_url"}, new Object[]{"", "", "", "", "", null, "", null, "", "", null, 0, "", ""}, ReportInfo.class);
                public final PBStringField exposure_url = PBField.initString("");
                public final PBStringField click_url = PBField.initString("");
                public final PBStringField effect_url = PBField.initString("");
                public final PBStringField landing_page_report_url = PBField.initString("");
                public final PBStringField negative_feedback_url = PBField.initString("");
                public TraceInfo trace_info = new TraceInfo();
                public final PBStringField video_report_url = PBField.initString("");
                public ThirdPartyMonitorUrls thirdparty_monitor_urls = new ThirdPartyMonitorUrls();
                public final PBStringField original_exposure_url = PBField.initString("");
                public final PBStringField complaint_url = PBField.initString("");
                public final PBRepeatMessageField<NegativeFeedbackItem> neg_fb_items = PBField.initRepeatMessage(NegativeFeedbackItem.class);
                public final PBInt32Field report_type = PBField.initInt32(0);
                public final PBStringField imp_stay_report_url = PBField.initString("");
                public final PBStringField pre_exposure_action_report_url = PBField.initString("");

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class NegativeFeedbackItem extends MessageMicro<NegativeFeedbackItem> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48}, new String[]{"icon_url", "text", TVKDataBinder.KEY_REPORT_TYPE, "jump_url", "jump_title", "action_type"}, new Object[]{"", "", 0, "", "", 0}, NegativeFeedbackItem.class);
                    public final PBStringField icon_url = PBField.initString("");
                    public final PBStringField text = PBField.initString("");
                    public final PBUInt32Field report_type = PBField.initUInt32(0);
                    public final PBStringField jump_url = PBField.initString("");
                    public final PBStringField jump_title = PBField.initString("");
                    public final PBUInt32Field action_type = PBField.initUInt32(0);
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class ThirdPartyMonitorUrls extends MessageMicro<ThirdPartyMonitorUrls> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66}, new String[]{"api_exposure_monitor_url", "sdk_exposure_monitor_url", "api_click_monitor_url", "sdk_click_monitor_url", "video_play_monitor_url", "video_play_duration", "active_view_tracking_url", "multi_video_play_monitor_urls"}, new Object[]{"", "", "", "", "", 0, "", null}, ThirdPartyMonitorUrls.class);
                    public final PBRepeatField<String> active_view_tracking_url;
                    public final PBRepeatField<String> api_click_monitor_url;
                    public final PBRepeatField<String> api_exposure_monitor_url;
                    public final PBRepeatMessageField<VideoPlayMonitorUrl> multi_video_play_monitor_urls;
                    public final PBRepeatField<String> sdk_click_monitor_url;
                    public final PBRepeatField<String> sdk_exposure_monitor_url;
                    public final PBUInt32Field video_play_duration;
                    public final PBRepeatField<String> video_play_monitor_url;

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class VideoPlayMonitorUrl extends MessageMicro<VideoPlayMonitorUrl> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_PLAY_TIME, "report_url"}, new Object[]{0, ""}, VideoPlayMonitorUrl.class);
                        public final PBUInt32Field play_time = PBField.initUInt32(0);
                        public final PBRepeatField<String> report_url = PBField.initRepeat(PBStringField.__repeatHelper__);
                    }

                    public ThirdPartyMonitorUrls() {
                        PBStringField pBStringField = PBStringField.__repeatHelper__;
                        this.api_exposure_monitor_url = PBField.initRepeat(pBStringField);
                        this.sdk_exposure_monitor_url = PBField.initRepeat(pBStringField);
                        this.api_click_monitor_url = PBField.initRepeat(pBStringField);
                        this.sdk_click_monitor_url = PBField.initRepeat(pBStringField);
                        this.video_play_monitor_url = PBField.initRepeat(pBStringField);
                        this.video_play_duration = PBField.initUInt32(0);
                        this.active_view_tracking_url = PBField.initRepeat(pBStringField);
                        this.multi_video_play_monitor_urls = PBField.initRepeatMessage(VideoPlayMonitorUrl.class);
                    }
                }

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class TraceInfo extends MessageMicro<TraceInfo> {
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 64, 72, 80}, new String[]{"aid", "traceid", "via", "view_id", ReportDataBuilder.KEY_PRODUCT_ID, "noco_id", "net_log_req_id", "creative_id", "quality_product_id", "matched_style_rule_list"}, new Object[]{0L, "", "", "", "", 0L, "", 0L, 0, 0}, TraceInfo.class);
                    public final PBUInt64Field aid = PBField.initUInt64(0);
                    public final PBStringField traceid = PBField.initString("");
                    public final PBStringField via = PBField.initString("");
                    public final PBStringField view_id = PBField.initString("");
                    public final PBStringField product_id = PBField.initString("");
                    public final PBInt64Field noco_id = PBField.initInt64(0);
                    public final PBStringField net_log_req_id = PBField.initString("");
                    public final PBUInt64Field creative_id = PBField.initUInt64(0);
                    public final PBUInt32Field quality_product_id = PBField.initUInt32(0);
                    public final PBRepeatField<Integer> matched_style_rule_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class RewardInfo extends MessageMicro<RewardInfo> {
                public static final int PLAY_TYPE_IMAGE_TXT = 3;
                public static final int PLAY_TYPE_LANDING_PAGE = 2;
                public static final int PLAY_TYPE_UNKNOWN = 0;
                public static final int PLAY_TYPE_VIDEO = 1;
                public static final int RENDER_TYPE_DYNAMIC = 2;
                public static final int RENDER_TYPE_NATIVE = 1;
                public static final int RENDER_TYPE_UNKNOW = 0;
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 58}, new String[]{"reward_time", "sdk_report_url", "sdk_report_interval", "pass_through_data", ThirdPartyMiniApiImpl.KEY_RENDER_TYPE, PlayParamConst.ParamKey.PLAY_TYPE, "customized_reward_txt"}, new Object[]{0, "", 0, "", 0, 0, ""}, RewardInfo.class);
                public final PBUInt32Field reward_time = PBField.initUInt32(0);
                public final PBStringField sdk_report_url = PBField.initString("");
                public final PBUInt32Field sdk_report_interval = PBField.initUInt32(0);
                public final PBStringField pass_through_data = PBField.initString("");
                public final PBEnumField render_type = PBField.initEnum(0);
                public final PBEnumField play_type = PBField.initEnum(0);
                public final PBStringField customized_reward_txt = PBField.initString("");

                /* compiled from: P */
                /* loaded from: classes29.dex */
                public static final class PassThroughData extends MessageMicro<PassThroughData> {
                    public static final int REWARD_TYPE_CLICK = 2;
                    public static final int REWARD_TYPE_DOWNLOAD = 1;
                    public static final int REWARD_TYPE_INTERACTIVE = 4;
                    public static final int REWARD_TYPE_LEVEL = 3;
                    public static final int REWARD_TYPE_VIEW = 0;
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58}, new String[]{"reward_type", "bottomcard_hot_size", "bottomcard_hot_direction", "endcard_hot_direction", "endcard_hot_size", "bullet_screen", "dynamic_template_info"}, new Object[]{0, 0, 0, 0, 0, "", null}, PassThroughData.class);
                    public final PBEnumField reward_type = PBField.initEnum(0);
                    public final PBUInt32Field bottomcard_hot_size = PBField.initUInt32(0);
                    public final PBUInt32Field bottomcard_hot_direction = PBField.initUInt32(0);
                    public final PBUInt32Field endcard_hot_direction = PBField.initUInt32(0);
                    public final PBUInt32Field endcard_hot_size = PBField.initUInt32(0);
                    public final PBRepeatField<String> bullet_screen = PBField.initRepeat(PBStringField.__repeatHelper__);
                    public qq_common.DynamicTemplateInfo dynamic_template_info = new qq_common.DynamicTemplateInfo();

                    /* compiled from: P */
                    /* loaded from: classes29.dex */
                    public static final class DynamicTemplateInfo extends MessageMicro<DynamicTemplateInfo> {
                        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"template_id", "style_id"}, new Object[]{0L, 0L}, DynamicTemplateInfo.class);
                        public final PBUInt64Field template_id = PBField.initUInt64(0);
                        public final PBUInt64Field style_id = PBField.initUInt64(0);
                    }
                }
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class SkAdNetwork extends MessageMicro<SkAdNetwork> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58}, new String[]{"campaign_id", "timestamp_ms", "ad_network_id", "nonce", "source_app_id", "version", "signature"}, new Object[]{0, 0L, "", "", 0L, "", ""}, SkAdNetwork.class);
                public final PBUInt32Field campaign_id = PBField.initUInt32(0);
                public final PBUInt64Field timestamp_ms = PBField.initUInt64(0);
                public final PBStringField ad_network_id = PBField.initString("");
                public final PBStringField nonce = PBField.initString("");
                public final PBUInt64Field source_app_id = PBField.initUInt64(0);
                public final PBStringField version = PBField.initString("");
                public final PBStringField signature = PBField.initString("");
            }

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class WeChatAppInfo extends MessageMicro<WeChatAppInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66}, new String[]{"app_username", "app_path", "app_token", "app_id", "ad_trace_data", SsoReporter.POS_ID_KEY, "wx_plugin_middle_page", "wechat_appid"}, new Object[]{"", "", "", "", "", 0L, "", ""}, WeChatAppInfo.class);
                public final PBStringField app_username = PBField.initString("");
                public final PBStringField app_path = PBField.initString("");
                public final PBStringField app_token = PBField.initString("");
                public final PBStringField app_id = PBField.initString("");
                public final PBStringField ad_trace_data = PBField.initString("");
                public final PBUInt64Field pos_id = PBField.initUInt64(0);
                public final PBStringField wx_plugin_middle_page = PBField.initString("");
                public final PBStringField wechat_appid = PBField.initString("");
            }
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class ContractEmptyAdResponse extends MessageMicro<ContractEmptyAdResponse> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"trace_id", "type", "slot_index", "report_url"}, new Object[]{"", 0, 0, ""}, ContractEmptyAdResponse.class);
            public final PBStringField trace_id = PBField.initString("");
            public final PBUInt32Field type = PBField.initUInt32(0);
            public final PBUInt32Field slot_index = PBField.initUInt32(0);
            public final PBStringField report_url = PBField.initString("");
        }

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class PosAdInfo extends MessageMicro<PosAdInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 66, 802}, new String[]{"ret", "msg", SsoReporter.POS_ID_KEY, "ads_info", "no_ad_indicator", TVKDataBinder.KEY_REPORT_TYPE, "frequency_info", "passthrough_pos_info", "contract_empty_ad_response"}, new Object[]{0, "", "", null, null, 0, null, ByteStringMicro.EMPTY, null}, PosAdInfo.class);
            public final PBInt32Field ret = PBField.initInt32(0);

            /* renamed from: msg, reason: collision with root package name */
            public final PBStringField f435903msg = PBField.initString("");
            public final PBStringField pos_id = PBField.initString("");
            public final PBRepeatMessageField<AdInfo> ads_info = PBField.initRepeatMessage(AdInfo.class);
            public indicator.NoAdIndicator no_ad_indicator = new indicator.NoAdIndicator();
            public final PBInt32Field report_type = PBField.initInt32(0);
            public FrequencyInfo frequency_info = new FrequencyInfo();
            public final PBBytesField passthrough_pos_info = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBRepeatMessageField<ContractEmptyAdResponse> contract_empty_ad_response = PBField.initRepeatMessage(ContractEmptyAdResponse.class);

            /* compiled from: P */
            /* loaded from: classes29.dex */
            public static final class FrequencyInfo extends MessageMicro<FrequencyInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"exposure_frequency_time", "request_frequency_time", "request_frequency_time_adlimit"}, new Object[]{0, 0, 0}, FrequencyInfo.class);
                public final PBUInt32Field exposure_frequency_time = PBField.initUInt32(0);
                public final PBUInt32Field request_frequency_time = PBField.initUInt32(0);
                public final PBUInt32Field request_frequency_time_adlimit = PBField.initUInt32(0);
            }
        }
    }

    qq_ad_get() {
    }
}
