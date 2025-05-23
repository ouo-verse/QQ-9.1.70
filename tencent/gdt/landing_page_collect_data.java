package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class landing_page_collect_data {
    public static final int ACTION_ARK_LOAD_START = 61;
    public static final int ACTION_ARK_LOAD_SUCCESS = 62;
    public static final int ACTION_CLICK_CGI_REDIRECT_FAIL = 2;
    public static final int ACTION_CLICK_CGI_REDIRECT_SUCCESS = 1;
    public static final int ACTION_CLOSE_POPSHEET = 49;
    public static final int ACTION_FOREIGN_APP_STORE_FAILED = 38;
    public static final int ACTION_FOREIGN_IOS_DOWNLOAD_WINDOW_CLICK_ABANDON = 41;
    public static final int ACTION_FOREIGN_IOS_DOWNLOAD_WINDOW_CLICK_ALLOW = 40;
    public static final int ACTION_FOREIGN_IOS_DOWNLOAD_WINDOW_IMPRESSION = 39;
    public static final int ACTION_INFOFLOW_VIEW_NUM = 47;
    public static final int ACTION_LANDINGPAGE_APP_DATA_FAILED = 37;
    public static final int ACTION_LANDINGPAGE_APP_DATA_SUCCESS = 36;
    public static final int ACTION_LANDINGPAGE_APP_DOWNLOAD_CLICK = 33;
    public static final int ACTION_LANDINGPAGE_BOUNCE = 83;
    public static final int ACTION_LANDINGPAGE_BROWSE_PERCENTAGE = 95;
    public static final int ACTION_LANDINGPAGE_BROWSING_PERCENT = 11;
    public static final int ACTION_LANDINGPAGE_BROWSING_TIME = 10;
    public static final int ACTION_LANDINGPAGE_CLOSE = 103;
    public static final int ACTION_LANDINGPAGE_CORE_CONTENT_LOADED = 93;
    public static final int ACTION_LANDINGPAGE_DOM_COMPLETE = 91;
    public static final int ACTION_LANDINGPAGE_DWELL_TIME = 42;
    public static final int ACTION_LANDINGPAGE_FETCH_START = 88;
    public static final int ACTION_LANDINGPAGE_FIRST_SCREEN = 92;
    public static final int ACTION_LANDINGPAGE_FORMS_COMMIT_FAILED = 23;
    public static final int ACTION_LANDINGPAGE_FORMS_COMMIT_SUCCESS = 22;
    public static final int ACTION_LANDINGPAGE_LANDING_USER_EXIT = 6;
    public static final int ACTION_LANDINGPAGE_LANDING_USER_RETURN = 5;
    public static final int ACTION_LANDINGPAGE_LOAD_EVENT_END = 94;
    public static final int ACTION_LANDINGPAGE_LOAD_FAIL = 4;
    public static final int ACTION_LANDINGPAGE_LOAD_SUCCESS = 3;
    public static final int ACTION_LANDINGPAGE_MORE_CONTENT_CLICK = 35;
    public static final int ACTION_LANDINGPAGE_OPEN = 102;
    public static final int ACTION_LANDINGPAGE_PRODUCT_CLICK = 13;
    public static final int ACTION_LANDINGPAGE_PRODUCT_DEEPLINK = 14;
    public static final int ACTION_LANDINGPAGE_PRODUCT_DELAY_DEEPLINK = 16;
    public static final int ACTION_LANDINGPAGE_PRODUCT_DOWNLOAD = 15;
    public static final int ACTION_LANDINGPAGE_PRODUCT_VIEW = 12;
    public static final int ACTION_LANDINGPAGE_RECOMMEND_CLICK = 18;
    public static final int ACTION_LANDINGPAGE_RECOMMEND_DEEPLINK = 19;
    public static final int ACTION_LANDINGPAGE_RECOMMEND_DELAY_DEEPLINK = 21;
    public static final int ACTION_LANDINGPAGE_RECOMMEND_DOWNLOAD = 20;
    public static final int ACTION_LANDINGPAGE_RECOMMEND_VIEW = 17;
    public static final int ACTION_LANDINGPAGE_RESPONSE_END = 90;
    public static final int ACTION_LANDINGPAGE_RESPONSE_START = 89;
    public static final int ACTION_LANDINGPAGE_USER_CLICK = 8;
    public static final int ACTION_LANDINGPAGE_USER_EXIT = 7;
    public static final int ACTION_LANDINGPAGE_VIEW = 9;
    public static final int ACTION_LANDINGPAGE_ZHEDIE_BROWSING_PERCENT = 34;
    public static final int ACTION_MINI_PROGRAM_OPEN_FAILED = 52;
    public static final int ACTION_MINI_PROGRAM_OPEN_SUCCESS = 51;
    public static final int ACTION_NEWS_LOAD_IMAGE = 25;
    public static final int ACTION_NEWS_LOAD_IOS_APPSTORE = 29;
    public static final int ACTION_NEWS_LOAD_LANDINGPAGE = 28;
    public static final int ACTION_NEWS_LOAD_VIDEO = 26;
    public static final int ACTION_NEWS_PLAY_VIDEO = 27;
    public static final int ACTION_NEWS_REPORT_CLICK_CGI = 30;
    public static final int ACTION_NEWS_REPORT_CONV_CGI = 32;
    public static final int ACTION_NEWS_REPORT_IMPRESSION_CGI = 31;
    public static final int ACTION_SUBMIT_POPSHEET = 48;
    public static final int ACTION_SUBMIT_POPSHEET_FAILED = 50;
    public static final int ACTION_XJ_LANDINGPAGE_BOTTOM_IMAGE = 71;
    public static final int ACTION_XJ_LANDINGPAGE_BOTTOM_IMAGE_BUTTON = 73;
    public static final int ACTION_XJ_LANDINGPAGE_BROWSING_PERCENT = 44;
    public static final int ACTION_XJ_LANDINGPAGE_BROWSING_TIME = 45;
    public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_FETCH_START = 74;
    public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_FETCH_SUCC = 75;
    public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_READ_CACHE_START = 76;
    public static final int ACTION_XJ_LANDINGPAGE_CANVAS_JSON_READ_CACHE_SUCC = 77;
    public static final int ACTION_XJ_LANDINGPAGE_DEEPLINK_FAIL = 105;
    public static final int ACTION_XJ_LANDINGPAGE_DEEPLINK_TRIGGER = 104;
    public static final int ACTION_XJ_LANDINGPAGE_DIALOG_MOUNT = 101;
    public static final int ACTION_XJ_LANDINGPAGE_DIALOG_TRIGGER = 100;
    public static final int ACTION_XJ_LANDINGPAGE_DOWNLOAD_AFTER_GAME_END = 87;
    public static final int ACTION_XJ_LANDINGPAGE_DOWNLOAD_CAN_USE_CUSTOM_MANAGER = 81;
    public static final int ACTION_XJ_LANDINGPAGE_DOWNLOAD_CUSTOM_MANAGER = 78;
    public static final int ACTION_XJ_LANDINGPAGE_DOWNLOAD_FAILURE = 80;
    public static final int ACTION_XJ_LANDINGPAGE_DOWNLOAD_REDIRECT_THIRDPARTY_APP = 82;
    public static final int ACTION_XJ_LANDINGPAGE_DOWNLOAD_YYB_MANAGER = 79;
    public static final int ACTION_XJ_LANDINGPAGE_FIRSTSCREEN = 54;
    public static final int ACTION_XJ_LANDINGPAGE_FORM_AUTO_FILL_SUCCESS = 58;
    public static final int ACTION_XJ_LANDINGPAGE_GAME_CLICK_CHOOSE_CARD_1 = 96;
    public static final int ACTION_XJ_LANDINGPAGE_GAME_CLICK_CHOOSE_CARD_2 = 97;
    public static final int ACTION_XJ_LANDINGPAGE_GAME_CLICK_CHOOSE_CARD_3 = 98;
    public static final int ACTION_XJ_LANDINGPAGE_GAME_CLICK_CHOOSE_CARD_4 = 99;
    public static final int ACTION_XJ_LANDINGPAGE_GAME_END = 86;
    public static final int ACTION_XJ_LANDINGPAGE_GAME_RESOURCE_LOAD_COMPLETED = 84;
    public static final int ACTION_XJ_LANDINGPAGE_GAME_START = 85;
    public static final int ACTION_XJ_LANDINGPAGE_INITEND = 53;
    public static final int ACTION_XJ_LANDINGPAGE_LIVE_VIEW = 70;
    public static final int ACTION_XJ_LANDINGPAGE_LIVE_VIEW_BUTTON = 72;
    public static final int ACTION_XJ_LANDINGPAGE_ONLOAD = 55;
    public static final int ACTION_XJ_LANDINGPAGE_OPPO_MARKET_VIEW_CONTENT = 63;
    public static final int ACTION_XJ_LANDINGPAGE_OPPO_YYB_VIEW_CONTENT = 64;
    public static final int ACTION_XJ_LANDINGPAGE_PAGE_LOAD_TIME = 60;
    public static final int ACTION_XJ_LANDINGPAGE_QUICAPP_FAILED = 57;
    public static final int ACTION_XJ_LANDINGPAGE_QUICAPP_SUCCESS = 56;
    public static final int ACTION_XJ_LANDINGPAGE_USER_CLICK = 43;
    public static final int ACTION_XJ_LANDINGPAGE_USER_EXIT = 46;
    public static final int ACTION_XJ_LANDINGPAGE_VIEW_CONTENT = 69;
    public static final int ACTION_XJ_LANDINGPAGE_VIVO_JUMP_MARKET = 67;
    public static final int ACTION_XJ_LANDINGPAGE_VIVO_JUMP_YYB = 68;
    public static final int ACTION_XJ_LANDINGPAGE_VIVO_MARKET_VIEW_CONTENT = 65;
    public static final int ACTION_XJ_LANDINGPAGE_VIVO_YYB_VIEW_CONTENT = 66;
    public static final int ACTION_XJ_LANDINGPAGE_WEBVIEW_INIT_TIME = 59;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LandingPageCollectData extends MessageMicro<LandingPageCollectData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 146}, new String[]{"landing_page_action_type", "latency_ms", "landing_error_code", "browsing_time", "schemeid", "browsing_percent", "screen_height", "screen_width", "avail_height", "client_height", "scroll_top", "click_offset_x", "click_offset_y", "browsing_percent_start", "browsing_percent_end", "browsing_time_on_area", "xj_page_id", "subordinate_product_info"}, new Object[]{0, 0L, 0, 0, "", 0, "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, null}, LandingPageCollectData.class);
        public final PBUInt32Field landing_page_action_type = PBField.initUInt32(0);
        public final PBUInt64Field latency_ms = PBField.initUInt64(0);
        public final PBUInt32Field landing_error_code = PBField.initUInt32(0);
        public final PBUInt32Field browsing_time = PBField.initUInt32(0);
        public final PBStringField schemeid = PBField.initString("");
        public final PBUInt32Field browsing_percent = PBField.initUInt32(0);
        public final PBStringField screen_height = PBField.initString("");
        public final PBStringField screen_width = PBField.initString("");
        public final PBUInt32Field avail_height = PBField.initUInt32(0);
        public final PBUInt32Field client_height = PBField.initUInt32(0);
        public final PBUInt32Field scroll_top = PBField.initUInt32(0);
        public final PBUInt32Field click_offset_x = PBField.initUInt32(0);
        public final PBUInt32Field click_offset_y = PBField.initUInt32(0);
        public final PBUInt32Field browsing_percent_start = PBField.initUInt32(0);
        public final PBUInt32Field browsing_percent_end = PBField.initUInt32(0);
        public final PBUInt32Field browsing_time_on_area = PBField.initUInt32(0);
        public final PBUInt32Field xj_page_id = PBField.initUInt32(0);
        public SubordinateProductInfo subordinate_product_info = new SubordinateProductInfo();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class SubordinateProductInfo extends MessageMicro<SubordinateProductInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"id", "real_id", "pkg_url", "pkg_md5"}, new Object[]{"", "", "", ""}, SubordinateProductInfo.class);

            /* renamed from: id, reason: collision with root package name */
            public final PBStringField f435897id = PBField.initString("");
            public final PBStringField real_id = PBField.initString("");
            public final PBStringField pkg_url = PBField.initString("");
            public final PBStringField pkg_md5 = PBField.initString("");
        }
    }

    landing_page_collect_data() {
    }
}
