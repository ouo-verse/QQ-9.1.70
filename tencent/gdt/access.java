package tencent.gdt;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
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
import com.tencent.xweb.FileReaderHelper;
import com.tenpay.sdk.util.QWSoterConstans;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class access {
    public static final int AD_FREQCONTROL = 122;
    public static final int AD_SWITCH = 130;
    public static final int AMS_NO_AD = 140;
    public static final int AUDIT_VERSION = 103;
    public static final int BLACK_BUSI = 101;
    public static final int CHANNEL_DISCOVER_HOT_FEEDS = 53;
    public static final int CHANNEL_DISCOVER_MINE_FEEDS = 54;
    public static final int CHANNEL_OFFICIAL_ACCOUNT_DOUBLE_FEEDS = 82;
    public static final int CHANNEL_OFFICIAL_ACCOUNT_HOT_FEEDS = 55;
    public static final int CHANNEL_OFFICIAL_ACCOUNT_MINE_FEEDS = 56;
    public static final int CHANNEL_OWNER_INDEX_FEEDS = 69;
    public static final int CHANNEL_OWNER_PROFILE_HOT_FEEDS = 79;
    public static final int CHANNEL_OWNER_PROFILE_NEWEST_FEEDS = 80;
    public static final int CHANNEL_TAB_DOUBLE_FEEDS = 81;
    public static final int CLIENT_MOD = 104;
    public static final int CREATOR_SHARE_ADV_QQ_LIVE = 25;
    public static final int CREATOR_SHARE_ADV_XWORLD = 21;
    public static final int DIVIDE_EXP = 116;
    public static final int DOCUMENT_SPLASHSCREEN = 86;
    public static final int GROUP_TOP_ADV = 57;
    public static final int IDENTITY_TAG = 132;
    public static final int INSERT_FAILED = 111;
    public static final int MINI_APP_MINI_GAME = 11;
    public static final int NEW_USER = 114;
    public static final int NONE = 0;
    public static final int NO_REG_TIME = 113;
    public static final int OFFICIAL_ACCOUNT_ADV = 4;
    public static final int OFFICIAL_ACCOUNT_ADV_GAME = 8;
    public static final int OFFICIAL_ACCOUNT_ADV_SHOP = 9;
    public static final int OFFICIAL_ACCOUNT_ADV_VIP = 7;
    public static final int OFFICIAL_ACCOUNT_LAYER_MASK_ADV = 14;
    public static final int OFFICIAL_ACCOUNT_SPORT = 13;
    public static final int OFFICIAL_ACCOUNT_TIAN_QI = 10;
    public static final int PC_QQTAB_ADV = 18;
    public static final int PULLDOWN_RECENT_MINIAPP = 51;
    public static final int QIQIAOBAN_SDK = 15;
    public static final int QQ_BANNER = 70;
    public static final int QQ_CPS = 16;
    public static final int QQ_MINIGAME_DAILY_RECOMMEND_GAME = 71;
    public static final int QQ_MINIGAME_DAILY_RECOMMEND_VIDEO = 72;
    public static final int QQ_MINIGAME_DAILY_RECOMMEND_VIDEO_FLOW = 73;
    public static final int QQ_MINIGAME_OFFICIAL_ACCOUNT_GAME = 74;
    public static final int QQ_MINIGAME_OFFICIAL_ACCOUNT_VIDEO = 75;
    public static final int QQ_MINIGAME_OFFICIAL_ACCOUNT_VIDEO_FLOW = 76;
    public static final int QQ_SHOP_ACCOUNT_FIRST_PAGE = 77;
    public static final int QQ_SHOP_ACCOUNT_WATERFALL = 29;
    public static final int QQ_SHOP_ACCOUNT_WATERFALL_FIRST = 28;
    public static final int QQ_SPLASH_SCREEN = 59;
    public static final int QQ_WALLET_CPS = 17;
    public static final int QZONE_APP_SPLASH_SCREEN = 67;
    public static final int QZONE_FEEDS = 0;
    public static final int QZONE_FEEDS_DETAILPAGE = 85;
    public static final int QZONE_FEEDS_NEW = 84;
    public static final int QZONE_FEEDS_REDDOT = 83;
    public static final int QZONE_GROUP_PHOTO_TAIL = 68;
    public static final int QZONE_PHOTO_TAIL = 2;
    public static final int QZONE_SIMILAR_ADV = 78;
    public static final int QZONE_THIRD_NONSTANDARD = 62;
    public static final int QZONE_VIDEO_LAYER = 1;
    public static final int QzoneRightFlagEnum_BLACKLIST = 4;
    public static final int QzoneRightFlagEnum_FRIEND = 2;
    public static final int QzoneRightFlagEnum_ONLYSELF = 5;
    public static final int QzoneRightFlagEnum_PUBLIC = 1;
    public static final int QzoneRightFlagEnum_QUESTION = 6;
    public static final int QzoneRightFlagEnum_UNKNOW = 0;
    public static final int QzoneRightFlagEnum_WHITELIST = 3;
    public static final int REWARD_2023_SPRING_FESTIVAL = 30;
    public static final int REWARD_COMMON = 66;
    public static final int REWARD_GIFT_ADV = 6;
    public static final int REWARD_GROUPGIFT_ADV = 12;
    public static final int REWARD_NOVEL_CREATURE = 52;
    public static final int REWARD_PERSONAL_ADV = 5;
    public static final int REWARD_QQSPORT_ADV = 27;
    public static final int REWARD_QQWEATHER_ADV = 58;
    public static final int REWARD_QZONE_THIRD_ACTIVITY = 60;
    public static final int REWARD_SUPER_SHOW = 61;
    public static final int REWARD_SUPER_SHOW_AD_ACTIVITY = 63;
    public static final int REWARD_SUPER_SHOW_CREATIVE_VOUCHER = 65;
    public static final int REWARD_SUPER_SHOW_FREE_ITEM = 64;
    public static final int SHAISHAI_WATERFALL = 39;
    public static final int SPEC_APP = 119;
    public static final int SPEC_VER = 118;
    public static final int S_USER = 117;
    public static final int UNION_EXT_ID_TYPE_ALBUM_ID = 1;
    public static final int UNION_EXT_ID_TYPE_APPID = 4;
    public static final int UNION_EXT_ID_TYPE_BATCH_ID = 2;
    public static final int UNION_EXT_ID_TYPE_BLOG_ID = 7;
    public static final int UNION_EXT_ID_TYPE_CTIME = 9;
    public static final int UNION_EXT_ID_TYPE_FEED_STRKEY = 10;
    public static final int UNION_EXT_ID_TYPE_FEED_TYPEID = 11;
    public static final int UNION_EXT_ID_TYPE_LLOC = 3;
    public static final int UNION_EXT_ID_TYPE_OWNER_UIN = 8;
    public static final int UNION_EXT_ID_TYPE_SHARE_ID = 6;
    public static final int UNION_EXT_ID_TYPE_SHUOSHUO_TID = 5;
    public static final int UNION_EXT_ID_TYPE_UNKOWN = 0;
    public static final int WEISEE_OFFICIAL_ACCOUNT = 3;
    public static final int WEISEE_OFFICIAL_ACCOUNT_WATERFALL = 24;
    public static final int X_WORLD_AIO_VIDEO_ADV = 46;
    public static final int X_WORLD_AI_POSTER = 34;
    public static final int X_WORLD_COMMENT_SHARE_ADV = 50;
    public static final int X_WORLD_CREATOR_ADV = 20;
    public static final int X_WORLD_EXPLORE = 37;
    public static final int X_WORLD_EXPLORE_WATERFALL = 38;
    public static final int X_WORLD_FULLSCREEN_PAUSE = 49;
    public static final int X_WORLD_GENERAL_ACTIVITY = 36;
    public static final int X_WORLD_LANDSCAPE_LAYER_ADV = 47;
    public static final int X_WORLD_OFFICIAL_ACCOUNT_ADV = 26;
    public static final int X_WORLD_PROFILE_LAYER_ADV = 48;
    public static final int X_WORLD_PURCHASE_AD_DEMO = 45;
    public static final int X_WORLD_QZONE_FRIEND_RECOMMEND = 40;
    public static final int X_WORLD_QZONE_LAYER = 22;
    public static final int X_WORLD_QZONE_OTHER_ENTRY = 44;
    public static final int X_WORLD_QZONE_PUBLISH_SYNC = 41;
    public static final int X_WORLD_QZONE_VIDEO_TAB = 42;
    public static final int X_WORLD_QZONE_VIDEO_UGC = 43;
    public static final int X_WORLD_SEARCH_ADV = 33;
    public static final int X_WORLD_SHOP = 31;
    public static final int X_WORLD_SUG_ADV = 35;
    public static final int X_WORLD_TOPVIEW_ADV = 23;
    public static final int X_WORLD_VIDEO_ADV = 19;
    public static final int X_WORLD_WATERFALL = 32;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AdGetReq extends MessageMicro<AdGetReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 66, 74, 82, 90}, new String[]{QWSoterConstans.CGI_KEY_BUSI_TYPE, "qq_ad_get", "client_mod", "device_info", "schema_source", "video_feed_info", "last_req_cookie", "push_ad_passthrough", "exp_ids", "qzone_info"}, new Object[]{0, null, "", "", "", null, "", "", "", null}, AdGetReq.class);
        public final PBRepeatField<String> exp_ids;
        public final PBRepeatField<String> push_ad_passthrough;
        public QzoneInfo qzone_info;
        public final PBEnumField busi_type = PBField.initEnum(0);
        public qq_ad_get.QQAdGet qq_ad_get = new qq_ad_get.QQAdGet();
        public final PBStringField client_mod = PBField.initString("");
        public final PBStringField device_info = PBField.initString("");
        public final PBStringField schema_source = PBField.initString("");
        public VideoFeedInfo video_feed_info = new VideoFeedInfo();
        public final PBStringField last_req_cookie = PBField.initString("");

        public AdGetReq() {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.push_ad_passthrough = PBField.initRepeat(pBStringField);
            this.exp_ids = PBField.initRepeat(pBStringField);
            this.qzone_info = new QzoneInfo();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AdGetRsp extends MessageMicro<AdGetRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"qq_ad_get_rsp", "ret_msg", "action_report_infos", "ext", "next_req_gap_in_seconds"}, new Object[]{null, null, null, null, 0L}, AdGetRsp.class);
        public qq_ad_get.QQAdGetRsp qq_ad_get_rsp = new qq_ad_get.QQAdGetRsp();
        public RetMsg ret_msg = new RetMsg();
        public final PBRepeatMessageField<UserActionReportInfo> action_report_infos = PBField.initRepeatMessage(UserActionReportInfo.class);
        public final PBRepeatMessageField<ExpInfo> ext = PBField.initRepeatMessage(ExpInfo.class);
        public final PBInt64Field next_req_gap_in_seconds = PBField.initInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AdvFeedPos extends MessageMicro<AdvFeedPos> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBInt32Field index = PBField.initInt32(0);
        public final PBBytesField feed_model = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField support_interaction = PBField.initBool(false);
        public FeedInfo feed_info = new FeedInfo();
        public ReddotInfo reddot_info = new ReddotInfo();
        public AdvInfo adv_info = new AdvInfo();
        public final PBBoolField is_updated = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 56}, new String[]{"index", "feed_model", "support_interaction", "feed_info", "reddot_info", "adv_info", "is_updated"}, new Object[]{0, ByteStringMicro.EMPTY, bool, null, null, null, bool}, AdvFeedPos.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AdvInfo extends MessageMicro<AdvInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt64Field aid = PBField.initUInt64(0);
        public final PBUInt32Field product_type = PBField.initUInt32(0);
        public final PBFloatField ecpm = PBField.initFloat(0.0f);
        public final PBStringField advertiser_group_name = PBField.initString("");
        public final PBUInt64Field ad_first_category = PBField.initUInt64(0);
        public final PBUInt64Field ad_second_category = PBField.initUInt64(0);
        public final PBStringField trace_id = PBField.initString("");
        public final PBDoubleField pctr = PBField.initDouble(0.0d);
        public final PBFloatField etr = PBField.initFloat(0.0f);
        public final PBFloatField duration_score = PBField.initFloat(0.0f);
        public final PBBoolField is_preview_ad = PBField.initBool(false);
        public final PBRepeatField<Integer> ad_extension_type = PBField.initRepeat(PBEnumField.__repeatHelper__);
        public final PBUInt64Field advertiser_id = PBField.initUInt64(0);
        public final PBUInt32Field creative_template_id = PBField.initUInt32(0);
        public final PBUInt64Field fingerprint_product = PBField.initUInt64(0);
        public final PBUInt64Field fingerprint_tid = PBField.initUInt64(0);
        public qq_ad_get.FeatureDataGroup feature_data_group = new qq_ad_get.FeatureDataGroup();

        static {
            Float valueOf = Float.valueOf(0.0f);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 29, 34, 40, 48, 58, 65, 77, 85, 88, 96, 104, 112, 120, 128, 138}, new String[]{"aid", "product_type", "ecpm", "advertiser_group_name", "ad_first_category", "ad_second_category", "trace_id", "pctr", "etr", "duration_score", "is_preview_ad", "ad_extension_type", "advertiser_id", "creative_template_id", "fingerprint_product", "fingerprint_tid", "feature_data_group"}, new Object[]{0L, 0, valueOf, "", 0L, 0L, "", Double.valueOf(0.0d), valueOf, valueOf, Boolean.FALSE, 0, 0L, 0, 0L, 0L, null}, AdvInfo.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ChannelInfo extends MessageMicro<ChannelInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"channel_id", "channel_owner_uin", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{0L, 0L, 0}, ChannelInfo.class);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_owner_uin = PBField.initUInt64(0);
        public final PBUInt32Field tags = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ExpInfo extends MessageMicro<ExpInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"key", "value", "exp_id", "bytes_value"}, new Object[]{"", "", "", ByteStringMicro.EMPTY}, ExpInfo.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
        public final PBStringField exp_id = PBField.initString("");
        public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FeedAdGetReq extends MessageMicro<FeedAdGetReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 48, 56, 98, 114, 122, 130, 138, 146, 152}, new String[]{"ad_get_req", "feeds_count", "adv_session", "exp_ids", "user_info", "total_feeds_count", "ad_count", "new_ad_get_req", "sug_query", "request_id", "deserialized_ad_get_req", CGNonAgeReport.EVENT_CHANNEL, "unused_feedids", "page_num"}, new Object[]{"", 0, "", "", null, 0, 0, ByteStringMicro.EMPTY, "", "", null, null, "", 0}, FeedAdGetReq.class);
        public final PBInt32Field ad_count;
        public ChannelInfo channel_info;
        public AdGetReq deserialized_ad_get_req;
        public final PBRepeatField<String> exp_ids;
        public final PBBytesField new_ad_get_req;
        public final PBUInt32Field page_num;
        public final PBStringField request_id;
        public final PBStringField sug_query;
        public final PBInt32Field total_feeds_count;
        public final PBRepeatField<String> unused_feedids;
        public UserInfo user_info;
        public final PBStringField ad_get_req = PBField.initString("");
        public final PBInt32Field feeds_count = PBField.initInt32(0);
        public final PBStringField adv_session = PBField.initString("");

        public FeedAdGetReq() {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.exp_ids = PBField.initRepeat(pBStringField);
            this.user_info = new UserInfo();
            this.total_feeds_count = PBField.initInt32(0);
            this.ad_count = PBField.initInt32(0);
            this.new_ad_get_req = PBField.initBytes(ByteStringMicro.EMPTY);
            this.sug_query = PBField.initString("");
            this.request_id = PBField.initString("");
            this.deserialized_ad_get_req = new AdGetReq();
            this.channel_info = new ChannelInfo();
            this.unused_feedids = PBField.initRepeat(pBStringField);
            this.page_num = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FeedAdGetRsp extends MessageMicro<FeedAdGetRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"adv_feed_pos", "adv_session", "fiter_type", "open_id"}, new Object[]{null, "", 0, ""}, FeedAdGetRsp.class);
        public final PBRepeatMessageField<AdvFeedPos> adv_feed_pos = PBField.initRepeatMessage(AdvFeedPos.class);
        public final PBStringField adv_session = PBField.initString("");
        public final PBEnumField fiter_type = PBField.initEnum(0);
        public final PBStringField open_id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FeedInfo extends MessageMicro<FeedInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uin", "feed_id", "feed_create_time"}, new Object[]{0L, "", 0L}, FeedInfo.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField feed_id = PBField.initString("");
        public final PBUInt64Field feed_create_time = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FeedsEnv extends MessageMicro<FeedsEnv> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"nth_refresh", "expected_ad_slot", "enter_motivation"}, new Object[]{0, 0, 0}, FeedsEnv.class);
        public final PBInt32Field nth_refresh = PBField.initInt32(0);
        public final PBInt32Field expected_ad_slot = PBField.initInt32(0);
        public final PBInt32Field enter_motivation = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class QzoneInfo extends MessageMicro<QzoneInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"last_adv_position", "union_id", "feed_right_flag"}, new Object[]{0, null, 0}, QzoneInfo.class);
        public final PBInt32Field last_adv_position = PBField.initInt32(0);
        public UnionID union_id = new UnionID();
        public final PBEnumField feed_right_flag = PBField.initEnum(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReddotInfo extends MessageMicro<ReddotInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{FileReaderHelper.TXT_EXT, "logo"}, new Object[]{"", ""}, ReddotInfo.class);
        public final PBStringField txt = PBField.initString("");
        public final PBStringField logo = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RetMsg extends MessageMicro<RetMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "err_msg"}, new Object[]{0, ""}, RetMsg.class);
        public final PBInt32Field ret_code = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UnionExtID extends MessageMicro<UnionExtID> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"ext_id_type", "numeric", "str", "unsigned_numeric"}, new Object[]{0, 0L, "", 0L}, UnionExtID.class);
        public final PBEnumField ext_id_type = PBField.initEnum(0);
        public final PBInt64Field numeric = PBField.initInt64(0);
        public final PBStringField str = PBField.initString("");
        public final PBUInt64Field unsigned_numeric = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UnionID extends MessageMicro<UnionID> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"uf_key", "ugc_id", "feed_id", "ext_ids"}, new Object[]{"", "", "", null}, UnionID.class);
        public final PBStringField uf_key = PBField.initString("");
        public final PBStringField ugc_id = PBField.initString("");
        public final PBStringField feed_id = PBField.initString("");
        public final PBRepeatMessageField<UnionExtID> ext_ids = PBField.initRepeatMessage(UnionExtID.class);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UserActionReportInfo extends MessageMicro<UserActionReportInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"adv_id", "trace_id", "exposure_url", "click_url"}, new Object[]{"", "", "", ""}, UserActionReportInfo.class);
        public final PBStringField adv_id = PBField.initString("");
        public final PBStringField trace_id = PBField.initString("");
        public final PBStringField exposure_url = PBField.initString("");
        public final PBStringField click_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UserInfo extends MessageMicro<UserInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"first_login_time", "uin"}, new Object[]{0L, 0L}, UserInfo.class);
        public final PBUInt64Field first_login_time = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class VideoFeedInfo extends MessageMicro<VideoFeedInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"creator_id", "feed_id"}, new Object[]{"", ""}, VideoFeedInfo.class);
        public final PBStringField creator_id = PBField.initString("");
        public final PBStringField feed_id = PBField.initString("");
    }

    access() {
    }
}
