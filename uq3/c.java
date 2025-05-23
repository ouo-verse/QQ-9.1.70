package uq3;

import android.text.TextUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.config.impl.QCircleDynamicNameApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f439797a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f439798b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f439799c = "";

    /* renamed from: d, reason: collision with root package name */
    public static int f439800d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static String f439801e = "";

    public static boolean A() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_gallery_page_translucent_theme", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean A0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_error_color_print", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String A1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_praised_owner", "\u53bb\u5e7f\u573a\u4e3a\u559c\u6b22\u7684\u4f5c\u54c1\u70b9\u8d5e\u5427\uff5e");
    }

    public static String A2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_publish_public_account_subtitle", "\u7b2c\u4e00\u65f6\u95f4\u63a5\u6536\u70ed\u95e8\u6d3b\u52a8\u3001\u529f\u80fd\u66f4\u65b0\u3001\u6210\u5c31\u5956\u52b1\u63d0\u9192");
    }

    public static String A3() {
        return com.dataline.util.j.d(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_homepage_guest_list_empty_text", "\u8fd9\u4e2a\u5c0f\u4e16\u754c\u5c1a\u672a\u542f\u52a8\n\u4f60\u7684\u76ee\u5149\u65e9\u5df2\u542f\u7a0b"));
    }

    public static String A4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_valid_h5_url_domain", ".qq.com,.tencent.com");
    }

    public static boolean A5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_all_page_full_screen_scroll", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean A6(boolean z16) {
        int config;
        if (z16) {
            config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_profile_card_on_children_mode", 0);
        } else {
            config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_profile_card", 0);
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.e("QCircleConfigHelper", 1, "isQQCircleShowProfileCardEntrance:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config != 1) {
            return false;
        }
        return true;
    }

    public static boolean B() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_get_adload_backup_new", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean B0(String str) {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_force_native_plugin_" + str, 0) != 1) {
            return false;
        }
        return true;
    }

    public static String B1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_praised_client", "\u8be5\u7528\u6237\u8fd8\u6ca1\u6709\u8d5e\u8fc7\u4f5c\u54c1");
    }

    public static String B2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_publish_public_account_subtitle_for_aigc", "\u7b2c\u4e00\u65f6\u95f4\u83b7\u53d6\u54c1\u68c0\u8fdb\u5ea6\u901a\u77e5");
    }

    public static long B3() {
        long config = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_qqcircle_jump_to_publish_delay_time", 2000);
        QLog.d("QCircleConfigHelper", 1, "getQQCircleJumpToNewPublishDelayTime... delayTime:", Long.valueOf(config));
        return config;
    }

    public static String B4(String str) {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_view_pager_cubic_bezier_val", str);
    }

    public static boolean B5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_android_10_main_draw_barrage", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean B6() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_publish_save_grid_selected", 1);
        if (QLog.isColorLevel()) {
            QLog.e("QCircleConfigHelper", 1, "isQQCircleShowPublishSaveGridSelected:" + config);
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean C() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_get_box_count_request", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean C0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_publish_red_packet_free_limit", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String C1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_praised_owner", "\u6682\u65e0\u8d5e\u8fc7\u7684\u4f5c\u54c1");
    }

    public static String C2() {
        return com.dataline.util.j.d(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_publish_public_account_title", "\u5173\u6ce8\"QQ\u77ed\u89c6\u9891\u521b\u4f5c\u8005\u670d\u52a1\u53f7\""));
    }

    public static int C3() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_max_push_count", 400);
        if (QLog.isColorLevel()) {
            QLog.e("QCircleConfigHelper", 1, "getQQCircleMaxPushCount:" + config);
        }
        return config;
    }

    public static float C4(float f16) {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_view_pager_scroll_animation_per_inch", f16);
    }

    public static boolean C5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_android_9_main_draw_barrage", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean C6() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_group_toolbar", ((IAppSettingApi) e.b().a(IAppSettingApi.class)).isDebugVersion() ? 1 : 0);
        if (QLog.isColorLevel()) {
            QLog.e("QCircleConfigHelper", 1, "isQQCircleShowTroopToolBarEntrance:" + config);
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean D() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enbale_hack_on_resume", 1) == 1) {
            return true;
        }
        return false;
    }

    public static int D0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_preload_video_count", 2);
    }

    public static String D1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_product_owner", "\u53d1\u8868\u4f5c\u54c1\uff0c\u8ba9\u66f4\u591a\u540c\u597d\u627e\u5230\u4f60\uff5e");
    }

    public static String D2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_publish_public_account_title_for_aigc", "\u5173\u6ce8\"\u521b\u4f5c\u8005\u670d\u52a1\u53f7\"\u83b7\u53d6\u54c1\u68c0\u901a\u77e5");
    }

    public static String D3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_message_second_new_friends_empty_jump_title", "\u53bb\u53d1\u8868");
    }

    public static String D4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_visit_count_suffix", "\u6d4f\u89c8");
    }

    public static boolean D5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_back_up_url_append", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean D6() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_quic_open", true);
    }

    public static boolean E() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_need_jump_friend_tab_after_publish", 0, false) != 1) {
            return false;
        }
        return true;
    }

    public static long E0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_ams_memroy_report_delay_time_ms", 2000);
    }

    public static String E1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_product_owner", "\u6682\u65e0\u4f60\u7684\u4f5c\u54c1");
    }

    public static String E2(String str, String str2) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_use_new_wns_config", true)) {
            return com.tencent.mobileqq.rfw.common.api.b.a(str, str2);
        }
        return str2;
    }

    public static String E3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_message_second_new_friends_empty_text", "\u53d1\u8868\u4f18\u8d28\u4f5c\u54c1\u66f4\u5bb9\u6613\u6da8\u7c89\u5662~");
    }

    public static int E4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_visitor_effort_frequency", 0);
    }

    public static boolean E5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_check_and_start_splash_before_launch", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean E6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_autoslide_user_switch_show", 0, false) != 1) {
            return false;
        }
        return true;
    }

    public static boolean F() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_jump_to_qq_bottom_setting", 1) == 1) {
            return true;
        }
        return false;
    }

    public static long F0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_cpu_tracker_sample_time", 1000);
    }

    public static String F1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_product_owner_v2", "\u6682\u65e0\u4f60\u7684\u4f5c\u54c1");
    }

    public static String F2() {
        String h16 = k.a().h("sp_key_user_nickname", "");
        QLog.d("QCircleConfigHelper", 1, "getNickname... nickName:" + h16);
        return h16;
    }

    public static String F3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_message_empty_jump_title", "\u5feb\u53bb\u770b\u770b");
    }

    public static long F4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_watched_history_push_interval", 600000L);
    }

    public static boolean F5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_check_lock_screen", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean F6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_zone_show_comment_toast_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean G() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_layer_specify_can_loop_min_data_size", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String G0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_av1_hardward_dedoce_whitelist", "HPB-AN00;22041211AC;PGJM10;M2104K10AC;RMX2121;V2227A");
    }

    public static String G1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_pushed_client", "\u5148\u53bb\u5e7f\u573a\u770b\u770b\u5427\uff5e");
    }

    public static String G2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", i.f439807a, "X40;T6;TablePC;X20L;V11Pro;X12MAX;T106;");
    }

    public static String G3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_messagelist_host_messag_empty_text", "\u591a\u5728\u5e7f\u573a\u4e92\u52a8\u5c31\u4f1a\u6536\u5230\u6d88\u606f\u5594");
    }

    public static int G4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_watched_history_max_size", 100);
    }

    public static boolean G5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_clip_limit_to_head_out", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean G6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_dynamic_avatar", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean H() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_load_more_clear_red_trans", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean H0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_user_ai_comment_setting_status", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String H1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_pushed_owner", "\u53bb\u5e7f\u573a\u4e3a\u4f60\u559c\u6b22\u7684\u4f5c\u54c1\u52a9\u63a8\u5427\uff5e");
    }

    public static int H2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_once_enter_share_guide_showed_times", 3);
    }

    public static String H3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_gpsinfo_jump_title", "\u70b9\u51fb\u91cd\u8bd5");
    }

    public static long H4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_weak_network_emergency_time", 15);
    }

    public static boolean H5() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_IMAGE_EDIT_MODE_CONTROLLER, 0);
    }

    public static boolean H6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_first_comment_guide_text", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean I() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_middle_ensure_empty_status", 1) == 1) {
            return true;
        }
        return false;
    }

    public static int I0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_auto_open_comment_panel_delay", 200);
    }

    public static String I1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_pushed_client", "\u8be5\u7528\u6237\u8fd8\u6ca1\u63a8\u8fc7\u4f5c\u54c1");
    }

    public static long I2(long j3) {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_first_frame_rendered_interval", j3);
    }

    public static String I3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_gpsinfo_text", "\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\n\u67e5\u770b\u66f4\u591a\u9644\u8fd1\u7684\u4f5c\u54c1");
    }

    public static long I4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_weak_network_safe_play_time", 25);
    }

    private static boolean I5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", QCircleDynamicNameApiImpl.SECONDARY_DYNAMIC_ICON_SWITCH, 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean I6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_first_comment_toast_text", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean J() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_mute_when_release", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String J0() {
        String h16 = k.a().h("sp_key_user_avatar_url", "");
        QLog.d("QCircleConfigHelper", 1, "getAvatarUrl... url:" + h16);
        return h16;
    }

    public static String J1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_pushed_owner", "\u6682\u65e0\u63a8\u8fc7\u7684\u4f5c\u54c1");
    }

    public static long J2(long j3) {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_orientation_intercept_z_angle", j3);
    }

    public static String J3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_permission_jump_title", "\u53bb\u8bbe\u7f6e");
    }

    public static long J4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_compress_bitrate_check", IoUtils.DEFAULT_IMAGE_TOTAL_SIZE);
    }

    public static boolean J5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_options_sub_thread", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean J6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_hot_topic_view", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean K() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_cmt_enable_new_friend_selector_style", 1) == 1) {
            return true;
        }
        return false;
    }

    public static float K0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_use_video_bitrate_devide_bandwidth", 0.4f);
    }

    public static String K1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_praised_private", "\u8d5e\u8fc7\u7684\u4f5c\u54c1\u6682\u4e0d\u53ef\u89c1\u54e6\uff5e");
    }

    public static String K2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_guild_feed_default_cover", "https://qq-video.cdn-go.cn/ios/latest/defaultmode/8953/pindao/qvideo_pindao_cover.png");
    }

    public static String K3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_permission_text", "\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\n\u67e5\u770b\u66f4\u591a\u9644\u8fd1\u7684\u4f5c\u54c1");
    }

    public static long K4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_export_bitrate_check", 204800);
    }

    public static boolean K5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_fix_requested_orientation_crash", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean K6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_publish_service_error_toast", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean L() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_av1_prender_new", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String L0(String str) {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_vip_barrage_jump_url", str);
    }

    public static String L1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_praised_private", "\u8be5\u7528\u6237\u8bbe\u7f6e\u4e86\u79c1\u5bc6");
    }

    public static int L2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_personal_group_share_show_count", 3);
    }

    public static String L3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_works_jump_title", "\u53bb\u53d1\u5e03");
    }

    public static boolean L4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_export_use_qzone_path", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean L5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_force_clear_not_attach_data_bitmap_result", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean L6(boolean z16) {
        if (x6(z16) && w6(z16)) {
            return true;
        }
        return false;
    }

    public static boolean M() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_type_pymk_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int M0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_send_barrage_threshold", 3000);
    }

    public static String M1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_pushed_private", "\u8be5\u7528\u6237\u8bbe\u7f6e\u4e86\u79c1\u5bc6\n\u63a8\u8fc7\u7684\u4f5c\u54c1\u6682\u4e0d\u53ef\u89c1\u54e6\uff5e");
    }

    public static int M2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_urge_action_day_max_count", 50);
    }

    public static String M3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nearby_no_works_text", "\u9644\u8fd1\u6682\u65e0\u5185\u5bb9\n\u6210\u4e3a\u8fd9\u91cc\u7684\u7b2c\u4e00\u4e2a\u53d1\u5e03\u8005\u5427");
    }

    public static long M4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_upload_origin_filesize", 1572864000);
    }

    public static boolean M5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_full_feed_insert_to_parent_list", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean M6() {
        if (TabDataHelper.isOnceFetchFromServer(RFWApplication.getApplication(), RFWApplication.getAccountId())) {
            if (!f439798b) {
                QLog.e("QCircleConfigHelper", 1, "initQCircleTab user tabDataHelper:true");
                f439798b = true;
            }
            return TabDataHelper.isExtendTabShow(RFWApplication.getApplication(), RFWApplication.getAccountId(), TabDataHelper.TAB_NEW_WORLD);
        }
        return false;
    }

    public static boolean N() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_present_enbale_onstart", 1) == 1) {
            return true;
        }
        return false;
    }

    public static long N0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qfs_buffer_timeout_ms", 30000);
    }

    public static String N1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_server_exception", "\u68c0\u67e5\u4e00\u4e0b\u7f51\u7edc\u8bbe\u7f6e\u518d\u8bd5\u5427");
    }

    public static String N2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_personalized_recommendation_algorithm_explain_url", "https://rule.tencent.com/rule/preview/ff2737d7-cb62-4fac-b7f7-54d5df1c5bed");
    }

    public static String N3() {
        return com.dataline.util.j.d(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_nonet_error_text", "\u65e0\u6cd5\u8fde\u63a5\u5c0f\u4e16\u754c\n\u68c0\u67e5\u4e00\u4e0b\u7f51\u7edc\u518d\u8bd5\u5427"));
    }

    public static long N4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_video_black_check_bitrate_check", IoUtils.DEFAULT_IMAGE_TOTAL_SIZE);
    }

    public static boolean N5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_main_thread_wait", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean N6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_tab_mode_auto_refresh_enable", 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean O() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_dc_report_device_info_intercept", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static String O0() {
        String configSync = QzoneConfig.getInstance().getConfigSync("qqcircle", "qqcircle_capture_buffer_size_config", "https://downv6.qq.com/shadow_qqcamera/Android/capture_buffer_size.json");
        QLog.d("QCircleConfigHelper", 1, "getCaptureBufferSizeConfig url :" + configSync);
        return configSync;
    }

    public static String O1() {
        return com.dataline.util.j.d(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_server_exception", "\u65e0\u6cd5\u8fde\u63a5\u5c0f\u4e16\u754c"));
    }

    public static long O2() {
        return X0("qqcircle", "qqcircle_auto_play_picture_interval", 1500).intValue();
    }

    public static String O3() {
        if (h6()) {
            return a3();
        }
        if (!com.dataline.util.j.b()) {
            return X6();
        }
        String config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_production_name", Constants.Business.QQCIRCLE, false);
        if (TextUtils.isEmpty(config)) {
            config = X6();
        }
        if (!TextUtils.isEmpty(f439799c) && !TextUtils.equals(config, f439799c)) {
            QLog.d("QCircleConfigHelper", 1, "[getQQCircleProductName] appName: " + config + " | sPreAppName: " + f439799c);
        }
        return config;
    }

    public static int O4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_compress_cap", 3);
    }

    public static boolean O5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_modify_holder_new_tag_compare", 1) == 1) {
            return true;
        }
        return false;
    }

    public static int O6() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_export_enable_merge_gray", 5);
    }

    public static boolean P() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_dc_report_intercept", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean P0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_single_follow_limit_switch", 1) == 1) {
            return true;
        }
        return false;
    }

    public static int P1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_fast_reply_count_continue", 5);
    }

    public static long P2() {
        return X0("qqcircle", "qqcircle_auto_play_exposure_time", 700).intValue();
    }

    public static int P3() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_qcircle_nearby_publish_banner_show_offset_multiplier", 1);
        QLog.i("QCircleConfigHelper", 1, "getQQCirclePublishBannerShowPosition:" + config);
        return config;
    }

    public static long P4() {
        return o.V(15000L);
    }

    public static boolean P5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_page_orientation_v2", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean P6() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_load_skin_switch", 1);
        QLog.d("QCircleConfigHelper", 1, "DoWinkLoadSkin:" + config);
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean Q() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_personal_collect_box", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int Q0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_daily_checkin_toast_duration", 5000);
    }

    public static int Q1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_fast_reply_count_one_day", 2);
    }

    public static int Q2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_log_clr_gap_time", 5000);
    }

    public static int Q3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_can_show_type_cell", 0);
    }

    public static boolean Q4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_ae_intercept_download", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean Q5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_picture_limit_preload", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean Q6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_tag_cell_style", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean R() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_enable_pic_flow_report", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static long R0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_prefetch_friend_feed_delay", 500);
    }

    public static double R1() {
        return Double.parseDouble(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_first_frame_monitor_ratio", "0.05"));
    }

    public static int R2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "player_packet_min_total_duration", 3000);
    }

    public static String R3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_hint_text", "\u5199\u4e0b\u5408\u9002\u7684\u8bdd\u9898\u548c\u63cf\u8ff0\uff0c\u80fd\u83b7\u5f97\u66f4\u591a\u63a8\u8350\u54e6\uff5e");
    }

    public static boolean R4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_zhenyan_switch_open", 1) == 0) {
            return true;
        }
        return false;
    }

    public static boolean R5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_play_scene_append_to_url_v1", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean R6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_auto_next_fast_scroll", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean S() {
        if (X0("qqcircle", "qqcircle_video_rate_control_enable", 1).intValue() > 0) {
            return true;
        }
        return false;
    }

    public static String S0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_product_clinet", "\u6682\u65e0\u5185\u5bb9\u54e6");
    }

    public static String S1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_floating_qfs_polymerize_detail_scheme", "mqqapi://qcircle/openpolymerizedetail?is_middle_page=1&getfeedlist=1&sourcetype=10&xsj_main_entrance=qzone&xsj_sub_entrance=video_ugc&xsj_custom_pgid=pg_xsj_small_window_play_page&is_from_third_party=1");
    }

    public static int S2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qfs_player_retry_count", 3);
    }

    public static String S3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_hint_text_for_friends", "\u70b9\u540d@\u4f60\u7684\u8d85\u7ea7\u597d\u53cb\uff0c\u9080\u8bf7\u4ed6\u4e00\u8d77\u53c2\u4e0e\u53d1\u8868\uff0c\u4f20\u9012\u5feb\u4e50\uff5e");
    }

    public static boolean S4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_adfeed_rerank_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean S5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "player_buffer_update_enabled", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean S6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcirlce_enabled_error_change_level_replay", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean T() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_gesture_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String T0(String str, String str2, String str3) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_use_new_wns_config", true)) {
            return com.tencent.mobileqq.rfw.common.api.b.a(str + "." + str2, str3);
        }
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    public static int T1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_follow_button_group_display_count_author", 3);
    }

    public static String T2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_web_preload_offline_package_url_list", "https://m.xsj.qq.com/h5/qqzz/home?_wwv=8768&_wv=16777217&_bid=5104&loadFinishCallback=1");
    }

    public static int T3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_page_num_limit", 500);
    }

    public static boolean T4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_select_ai_face", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean T5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_player_net_flow_report", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean T6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_low_memory_cover_option", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean U() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_driver_by_lifecycle", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String U0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_config_low_level_device", "P10-S|");
    }

    public static int U1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_follow_button_group_display_count_expired_time", 30);
    }

    public static long U2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qfs_prepare_timeout_ms", 30000);
    }

    public static String U3() {
        String config = QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_publish_share_guide_experiment", "", false);
        QLog.d("QCircleConfigHelper", 1, "getQQCirclePublishShareABExperiment:" + config);
        return config;
    }

    public static boolean U4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_circle_tab_lazy_load_switch", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean U5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_preload_folder_tab", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean U6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_intercept_teen_mode_folder_schema", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean V() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_preload_polymerize_detail", 1) == 1) {
            return true;
        }
        return false;
    }

    public static long V0() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_config_progress_period", 100);
    }

    public static int V1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_friend_selector_open_experiment_min_at_user_count", 3);
    }

    public static String V2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_profile_edit_select_school", "https://m.xsj.qq.com/h5/school-select/index?_wv=3&_wwv=8193");
    }

    public static int V3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "quality_quality_report_buffer_length", 5);
    }

    public static boolean V4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_prefetch_friend_feed_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean V5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_enabled_req_quality_report", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean V6(long j3) {
        if (j3 % 10 < QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_video_export_upload_mix_user_config", 10)) {
            return true;
        }
        return false;
    }

    public static boolean W() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_popup_comment_keyboard", 0) != 1) {
            return false;
        }
        return true;
    }

    public static Boolean W0(String str, String str2, Boolean bool) {
        return Boolean.valueOf(QzoneConfig.getInstance().getConfig(str, str2, bool.booleanValue()));
    }

    public static int W1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_friend_selector_visible_user_count", 30);
    }

    public static String W2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_public_account_navi_title", "QQ\u77ed\u89c6\u9891\u7cbe\u9009");
    }

    public static long W3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_quality_report_interval", 60);
    }

    public static boolean W4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_community_enable_subtab_slide", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean W5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_change_tab_to_tpcore_destory", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean W6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_video_upload_cover_async_config", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean X() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_preload_valid_leak_player", 1) == 1) {
            return true;
        }
        return false;
    }

    public static Integer X0(String str, String str2, Integer num) {
        return Integer.valueOf(QzoneConfig.getInstance().getConfig(str, str2, num.intValue()));
    }

    public static String X1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_had_push_update_more_hint", "\u5df2\u7ecf\u50ac\u8fc7\u5566\uff0c\u8010\u5fc3\u7b49\u5f85\u5427");
    }

    public static int X2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_publish_button_daily_animation_threshold", 10);
    }

    public static int X3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_dc_report_quality_sample_rate", 10);
    }

    public static boolean X4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_create_mediacodec_byformat", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean X5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_enabled_video_select_filter_f0", 1) == 1) {
            return true;
        }
        return false;
    }

    private static String X6() {
        boolean isEmpty = TextUtils.isEmpty(f439799c);
        String str = Constants.Business.QQCIRCLE;
        if (isEmpty) {
            f439799c = k.a().h("sp_key_app_name", Constants.Business.QQCIRCLE);
        }
        if (!TextUtils.isEmpty(f439799c)) {
            str = f439799c;
        }
        if (!TextUtils.equals(str, f439799c) && !TextUtils.equals(f439801e, f439799c)) {
            QLog.d("QCircleConfigHelper", 1, "[obtainLocalAppNameCache] defAppName: " + str + " | sPreAppName: " + f439799c);
            f439801e = f439799c;
        }
        return str;
    }

    public static boolean Y() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_publish_inmultiwindow", 0) != 1) {
            return false;
        }
        return true;
    }

    public static Integer Y0(String str, String str2, Integer num, boolean z16) {
        return Integer.valueOf(QzoneConfig.getInstance().getConfig(str, str2, num.intValue(), z16));
    }

    public static long Y1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_history_auto_next_safe_time_ms", 3000L);
    }

    public static String Y2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_push_update_more_hint", "\u4f5c\u8005\u5df2\u6536\u5230\u63d0\u9192\uff0c\u6709\u65b0\u52a8\u6001\u4f1a\u901a\u77e5\u4f60");
    }

    public static int Y3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_report_buffer_length", 10);
    }

    public static boolean Y4() {
        boolean z16;
        if (!I5()) {
            return false;
        }
        if (f439800d == 0) {
            int e16 = k.a().e("sp_key_icon_exp_name", 0);
            f439800d = e16;
            if (e16 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.dataline.util.j.e(z16);
        }
        int i3 = f439800d;
        if (i3 != 0) {
            if (i3 != 2) {
                return false;
            }
            return true;
        }
        boolean b16 = com.dataline.util.j.b();
        com.dataline.util.j.e(b16);
        return b16;
    }

    public static boolean Y5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_view_force_layer_hardware", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean Y6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_middle_page_login_second_report", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean Z() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_vip_like_disabled", 0) != 0) {
            return false;
        }
        return true;
    }

    public static Long Z0(String str, String str2, Long l3) {
        return Long.valueOf(QzoneConfig.getInstance().getConfig(str, str2, l3.longValue()));
    }

    public static int Z1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_home_banner_animation_interval", 24);
    }

    public static int Z2() {
        try {
            return Integer.valueOf(X0("QZoneSetting", QzoneConfig.SECONDARY_QCIRCLR_ATUSER_MAX, 10).intValue()).intValue();
        } catch (NumberFormatException unused) {
            return 10;
        }
    }

    public static long Z3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_report_interval", 10);
    }

    public static boolean Z4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_enable_ams_memory_tracker", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean Z5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_weak_network_play_param_v2", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean Z6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_progress_report_switch", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean a() {
        if (M6()) {
            QLog.i("QCircleConfigHelper", 4, "canShowAddQQCircleMainTabGuideUI, QCircle is added.");
            return false;
        }
        if (TabDataHelper.isTabFull(RFWApplication.getApplication(), RFWApplication.getAccountId())) {
            QLog.i("QCircleConfigHelper", 4, "canShowAddQQCircleMainTabGuideUI, tab is full.");
            return false;
        }
        return true;
    }

    public static boolean a0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_reuse_player_decoder", 0) != 1) {
            return false;
        }
        return true;
    }

    public static String a1(String str, String str2) {
        return QzoneConfig.getInstance().getConfig(str, str2, "");
    }

    public static String a2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_hint_in_black_list_client", "\u4f60\u5728\u8be5\u7528\u6237\u7684\u9ed1\u540d\u5355\u4e2d");
    }

    public static String a3() {
        String config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_production_name", Constants.Business.QQCIRCLE);
        try {
            QLog.e("QCircleConfigHelper", 1, "getQCircleExpName:" + config);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return config;
    }

    public static boolean a4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_report_outbox_switch", 0, false) != 0) {
            return false;
        }
        return true;
    }

    public static boolean a5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_player_av1", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean a6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_white_list_main_draw_barrage", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean a7() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_recover_decorview", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_video_view_attach", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean b0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_recover_empty_tab_frame", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String b1(String str, String str2, String str3) {
        return QzoneConfig.getInstance().getConfig(str, str2, str3);
    }

    public static String b2() {
        return com.dataline.util.j.d(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_hint_in_black_list_title", "\u8be5\u7528\u6237\u5728\u4f60\u7684\u5c0f\u4e16\u754c\u9ed1\u540d\u5355\u4e2d"));
    }

    public static int b3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_folder_lazy_load_wait_time", 2000);
    }

    public static int b4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_search_history_max_num", 15);
    }

    public static boolean b5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_add_qfriend_guide", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean b6() {
        return "1".equals(T0("qqcircle", "qqcircle_feed_orientation_switch", "1"));
    }

    public static boolean b7() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_check_feed_un_selected", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_player_pre_active", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean c0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_recover_fast_click_in_pad", 1) == 1) {
            return true;
        }
        return false;
    }

    public static double c1() {
        return Double.parseDouble(QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_cpu_tracker_report_ratio", "0.001"));
    }

    public static String c2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_hint_in_black_list_owner", "\u6682\u65e0\u5185\u5bb9");
    }

    public static int c3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_layer_right_profile_lazy_load_wait_time", 2000);
    }

    public static String c4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_server_error_text", "\u7f51\u7edc\u5f00\u5c0f\u5dee\u513f\u5566");
    }

    public static boolean c5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_fix_auto_player", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean c6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_filter_preload_adfeed_disable", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean c7() {
        return false;
    }

    public static boolean d() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_ai_comment", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean d0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_refactor_main_tab_page_id", 1) == 1) {
            return true;
        }
        return false;
    }

    public static int d1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_memory_tracker_report_ratio", 60);
    }

    public static boolean d2() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_intercept_middle_page_seek_switch", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String d3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_low_level_publish_label_content", "\u6765QQ\u8d44\u6599\u5361\u56f4\u89c2\u6211\u7684\u9177\u70ab\u6807\u7b7e #\u6211\u7684\u4e2a\u6027\u6807\u7b7e");
    }

    public static int d4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_main_tab_tips_time", 5000);
    }

    public static boolean d5() {
        return "1".equals(T0("qqcircle", "qqcircle_autoslide_user_switch", "1"));
    }

    public static boolean d6() {
        return H5();
    }

    public static void d7(String str) {
        QLog.d("QCircleConfigHelper", 1, "updateAvatar... url:" + str);
        k.a().p("sp_key_user_avatar_url", str);
    }

    public static boolean e() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_always_reset_video_view", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean e0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_refresh_notify_selected", 1) == 1) {
            return true;
        }
        return false;
    }

    public static double e1() {
        return Double.parseDouble(QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_cpu_tracker_report_ratio", "0.01"));
    }

    public static boolean e2() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_readinjoy_disable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String e3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_low_level_publish_photo_wall_content", "\u6211\u7528\u7cbe\u9009\u7167\u7247\u751f\u6210\u4e86\u7cbe\u5f69\u89c6\u9891\uff0c\u5feb\u6765\u56f4\u89c2   #\u6211\u7684\u7cbe\u9009\u7167\u7247");
    }

    public static boolean e4() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_verified_switch", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean e5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_autoslide_imgtype", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean e6() {
        if (X0("qqcircle", "qcircle_nearby_tab_switch", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static void e7(String str, String str2, String str3) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_use_new_wns_config", true)) {
            com.tencent.mobileqq.rfw.common.api.b.c(str + "." + str2, str3);
            return;
        }
        QzoneConfig.getInstance().updateOneConfigAndDB(str, str2, str3);
    }

    public static boolean f() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_loaded_apk_leak", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean f0() {
        if (X0("qqcircle", "qqcircle_req_share_info_toast_enable", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static long f1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_cpu_tracker_sample_time", 1000);
    }

    public static String f2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "show_readinjoy_disable_oepration_toast", "\u529f\u80fd\u5347\u7ea7\u4e2d\uff0c\u8bf7\u4ee5\u540e\u518d\u8bd5\u8bd5\u5427~");
    }

    public static int f3() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_max_crash_count", 2);
        if (QLog.isColorLevel()) {
            QLog.e("QCircleConfigHelper", 1, "SECONDARY_QQCIRCLE_DISABLE_PLUGIN:" + config);
        }
        return config;
    }

    public static String f4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wallet_url", "https://m.xsj.qq.com/h5/card/wallet?_wwv=1&_wv=3");
    }

    public static boolean f5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_cpu_tracker", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean f6() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_preload_light_bundle_when_launch", false);
    }

    public static void f7() {
        int i3;
        boolean z16;
        String config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_production_name", Constants.Business.QQCIRCLE);
        k.a().p("sp_key_app_name", config);
        if (com.dataline.util.j.b()) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        f439800d = i3;
        k.a().m("sp_key_icon_exp_name", f439800d);
        if (f439800d == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.dataline.util.j.e(z16);
        f439799c = config;
        QLog.d("QCircleConfigHelper", 1, "[updateLocalAppNameCache] currentProductName: " + config + " | sPreAppName: " + f439799c + " | sPreIconExp: " + f439800d);
    }

    public static boolean g() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_appena_exp_to_player_report", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean g0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_rightbar_collect_btn", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int g1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_default_mute_guide_max_count", 0);
    }

    public static int g2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "show_readinjoy_disable_oepration_toast_duration", 3000);
    }

    public static boolean g3() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_compare_team_test", 0) != 1) {
            return false;
        }
        return true;
    }

    public static String g4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_vip_comment_like_resource_url", "https://downv6.qq.com/video_story/wezone_url/defaultmode/8953/feed_svip_like_icon/qvideo_icon_comment_like_svip_v2.zip");
    }

    public static boolean g5() {
        if (!f439797a) {
            if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_hotcomment_user_switch", f439797a ? 1 : 0) != 1) {
                return false;
            }
            return true;
        }
        Object d16 = g.d("sp_key_user_hot_comment_enable", Boolean.TRUE);
        if (d16 instanceof Boolean) {
            f439797a = ((Boolean) d16).booleanValue();
        }
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_hotcomment_user_switch", f439797a ? 1 : 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean g6() {
        return true;
    }

    public static void g7(String str) {
        QLog.d("QCircleConfigHelper", 1, "updateNickname... nickName:" + str);
        k.a().p("sp_key_user_nickname", str);
    }

    public static boolean h() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_av1_hardward_dedoce_whitlist", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean h0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_send_video_play_event", 0) != 1) {
            return false;
        }
        return true;
    }

    public static long h1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_device_low_memory_size", 4294967296L);
    }

    public static long h2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_pos_interval", 100, false);
    }

    public static long h3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_minimum_file_size_for_video_export_upload_4m", 4) * 1024 * 1024;
    }

    public static String h4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcricle_tag_medal_image_url_colour", "https://sola.gtimg.cn/aoi/sola/20200819105021_dQGv8tIe5a.png");
    }

    public static boolean h5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_init_in_main_thread_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean h6() {
        return !TextUtils.isEmpty(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_production_expid", "", false));
    }

    public static void h7(String str, String str2, String str3) {
        QzoneConfig.getInstance().updateOneConfig(str, str2, str3);
    }

    public static boolean i() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_av1_min_sdk_interceptor", 0, false) != 1) {
            return false;
        }
        return true;
    }

    public static boolean i0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_replace_readinjoy", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int i1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcir_video_trigger_downgrade_buffer_count", 3);
    }

    public static String i2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_jump_to_qq_profile_beated_hint", "\u6d89\u53ca\u8fdd\u53cd\u300a\u793e\u533a\u516c\u7ea6\u300b\uff0c\u8d44\u6599\u5361\u65e0\u6cd5\u8bbf\u95ee");
    }

    public static long i3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_request_busiInfo_delay_seconds", 1) * 1000;
    }

    public static String i4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_qzone_qfs_polymerize_detail_scheme", "mqqapi://qcircle/openpolymerizedetail?is_middle_page=1&getfeedlist=1&sourcetype=10&xsj_main_entrance=qzone&xsj_sub_entrance=video_ugc&xsj_custom_pgid=pg_xsj_qzone_video_ugc_mid_page&is_from_third_party=1&is_force_login_report=1");
    }

    public static boolean i5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_enable_memory_tracker", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean i6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_avatar_adjust", 1) == 1) {
            return true;
        }
        return false;
    }

    public static void i7(String str, String str2, String str3) {
        QzoneConfig.getInstance().updateOneConfigAndDB(str, str2, str3);
    }

    public static boolean j() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_check_feed_un_selected", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean j0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_can_show_mainpage_aigc_qrcode_share", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int j1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcir_video_trigger_downgrade_buffer_duration", 5) * 1000;
    }

    public static String j2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_lite_banner_qq_group_icon_url", "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8968/qqgroup/feed_icon_qqgroup_v2.png");
    }

    public static int j3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_preload_max_consume_count", 100);
    }

    public static int j4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_log_clr_duration", 180000);
    }

    public static boolean j5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_middle_page_preload", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean j6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_layout_inflater_clone", 1) == 1) {
            return true;
        }
        return false;
    }

    public static void j7(boolean z16) {
        QLog.d("QCircleConfigHelper", 1, "[updateRecentlyShareExpInfo] inExpGroup:" + z16);
        k.a().j("sp_key_recently_share_exp", z16);
    }

    public static boolean k() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_clear_un_selected_tag", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean k0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_can_show_mainpage_qrcode_share", 1) == 1 && !u4()) {
            return true;
        }
        return false;
    }

    public static long k1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_drop_frame_detect_min_playTime", 10000);
    }

    public static int k2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "local_player_packet_min_total_duration", 6000);
    }

    public static String k3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_aggre_school_editprofile_guide_text", "\u586b\u5199\u5b66\u6821\u4fe1\u606f\n\u9047\u89c1\u66f4\u591a\u6709\u8da3\u7684\u540c\u5b66");
    }

    public static int k4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_sr_side_long_lower", 600);
    }

    public static boolean k5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_mix_feed_tab_update", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean k6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_first_frame_rendered_switch", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static void k7(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        QLog.d("QCircleConfigHelper", 1, "updateUserVipInfo... qq_vip byte.length:" + bArr.length);
        if (bArr.length == 0) {
            return;
        }
        k.a().k("sp_key_user_vip_info", bArr);
    }

    public static boolean l() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_cmt_new_friend_selector_enable_search_reomte", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean l0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_skin_resource_mapping_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static long l1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_drop_frame_detect_time_ms", 1000);
    }

    public static int l2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qfs_load_more_preload_num", 2);
    }

    public static String l3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_aggre_school_publish_guide_text", "\u8bb0\u5f55\u6821\u56ed\u751f\u6d3b\n\u9047\u89c1\u66f4\u591a\u6709\u8da3\u7684\u540c\u5b66");
    }

    public static int l4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_sr_side_long_upper", 1280);
    }

    public static boolean l5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_play_local_video_after_publish", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean l6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_video_full_screen_anim", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String l7() {
        String configSync = QzoneConfig.getInstance().getConfigSync("qqcircle", "qqcircle_enable_use_eglcontext_version", "https://downv6.qq.com/shadow_qqcamera/Android/res/opengl_version.json");
        QLog.d("QCircleConfigHelper", 1, "useEGLContextVersion url :" + configSync);
        return configSync;
    }

    public static boolean m() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_cmt_enable_addtional_tab", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean m0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_splash_pymk_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int m1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "edge_rerank_test_count", 10);
    }

    public static int m2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_share_mode_max_length", 200);
    }

    public static String m3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_aggreagte_empty_jump_title", "\u53d1\u5e03\u7b2c\u4e00\u4e2a\u4f5c\u54c1");
    }

    public static int m4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_sr_side_short_lower", 480);
    }

    public static boolean m5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_enable_player_direct_ip", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean m6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_hardware_decode", 0, false) != 1) {
            return false;
        }
        return true;
    }

    public static boolean m7() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_use_new_public_last_msg_method", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean n() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_insert_fake_video", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean n0() {
        if (k.a().c("sp_key_personal_recommend_switch_open", true) && X0("qqcircle", "qqcircle_enable_tedgers_rerank_v2", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean n1() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_folder_funnel_report_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static int n2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_load_more_tab_feed_max_length", 200);
    }

    public static String n3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_aggreagte_empty_text", "\u8fd9\u7247\u6c83\u571f\u7a7a\u7a7a\u5982\u4e5f\n\u7b49\u5f85\u4f60\u6765\u5f00\u57a6");
    }

    public static int n4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_sr_side_short_upper", 720);
    }

    public static boolean n5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_ebable_player_release_callback", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean n6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_video_recognize_content_anim", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean n7() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_use_new_top_activity_judge", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean o() {
        boolean z16;
        boolean z17;
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_can_reply_video", 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_in_black_list", 0) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || !z16) {
            return false;
        }
        return true;
    }

    public static boolean o0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_tab_red_dot_jump_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String o1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_not_enable_player_spr_hardware", "qcom;kirin;");
    }

    public static String o2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_magic_vip_request_url", "mqqapi://kuikly/open?aid=mvip.g.a.txsc_aigxsj&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMTAwIn0%3D&version=1&kr_turbo_display=!svip&src_type=web&qqmc_config=vas_kuikly_config&page_name=vas_qqvip_pay&bundle_name=vas_qqvip_pay&pay_type=!svip&business_type=svip%2Cvip&half_pay=1&modal_mode=1&month=1");
    }

    public static String o3() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_album_create_url", "https://m.xsj.qq.com/h5/compilation/create?_wwv=4&_disablePadCompact=1");
    }

    public static String o4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_server_ab_test_name_1", "", false);
    }

    public static boolean o5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_enable_player_direct_ipv4", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean o6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_open_region_3", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean o7() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_use_public_cached_msg_for_report", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean p() {
        boolean z16;
        boolean z17;
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_can_reply_image", 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_in_black_list", 0) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || !z16) {
            return false;
        }
        return true;
    }

    public static boolean p0() {
        if (X0("qqcircle", "qqcir_enableVideoAdjust", 1).intValue() > 0) {
            return true;
        }
        return false;
    }

    public static boolean p1() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_update_feedscount", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String p2(String str) {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_main_draw_barrage_mode_list", str);
    }

    public static String p3(String str, boolean z16) {
        String str2 = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_album_info_edit_url", "https://m.xsj.qq.com/h5/compilation/detail?albumID=") + str;
        if (z16) {
            return str2 + "&xsj_album_source=draft";
        }
        return str2;
    }

    public static String p4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_server_ab_test_name_2", "", false);
    }

    public static boolean p5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_enable_player_direct_ipv6", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean p6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_publish_open_lru_cache", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean p7() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_use_avatar", 1);
        if (QLog.isColorLevel()) {
            QLog.e("QCircleConfigHelper", 1, "use qcircle avatar:" + config);
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean q() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_drop_frame_detect", true);
    }

    public static boolean q0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_use_comment_panel_height", 1) == 1) {
            return true;
        }
        return false;
    }

    public static long q1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enabled_global_history_duration_ms", 0L, false);
    }

    public static int q2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_av1_drop_frame_max_paly_count", 3, false);
    }

    public static String q3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_album_feedback_url", "https://ti.qq.com/tucao/index.html?productId=342658&_wv=2");
    }

    public static String q4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_server_ab_test_name_3", "");
    }

    public static boolean q5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_preload_video_de_init", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean q6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_eevee_prefetch_feed_enable", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean q7() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_ues_surfaceview_player", 1) == 0) {
            return true;
        }
        return false;
    }

    public static boolean r() {
        boolean z16 = true;
        if (X0("qqcircle", "qqcir_enableEditWithTemplateLocalPath", 1).intValue() <= 0) {
            z16 = false;
        }
        QLog.d("QCircleConfigHelper", 2, "enableEditWithTemplateLocalPath:" + z16);
        return z16;
    }

    public static boolean r0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_use_default_player", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String r1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_collect_private", "\u6536\u85cf\u7684\u5185\u5bb9\u6682\u4e0d\u53ef\u89c1\u54e6\uff5e");
    }

    public static int r2() {
        return X0("qqcircle", "qqcircle_max_black_list_num", 1000).intValue();
    }

    public static String r3(String str, boolean z16) {
        String str2 = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_album_works_add_url", "https://m.xsj.qq.com/h5/compilation/add?albumID=") + str;
        if (z16) {
            return str2 + "&xsj_album_source=draft";
        }
        return str2;
    }

    public static long r4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_share_guide_time_interval", 259200L);
    }

    public static boolean r5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_print_play_view_w_h", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean r6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_low_level_publish_open_label", 0) != 1) {
            return false;
        }
        return true;
    }

    public static int r7() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_export_enable_merge_check", 1000);
    }

    public static boolean s() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_ditto_may_interest_person_in_data_new_v3", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean s0() {
        boolean z16;
        boolean i06 = i0();
        boolean t65 = t6();
        if (!i06 && !t65 && e2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QCircleConfigHelper", 1, "enableUserInterceptMiddlePage  enableShowEntranceReplaceReadinjoy:" + i06 + "  isQCircleUser:" + t65 + "   isUserIntercept:" + z16);
        if (com.tencent.qcircle.cooperation.config.debug.c.f()) {
            if (com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLED_OPEN_INTERCEPT_MIDDLE_PAGE, 0) || z16) {
                return true;
            }
            return false;
        }
        return z16;
    }

    public static String s1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_collect_private", "\u8be5\u7528\u6237\u8bbe\u7f6e\u4e86\u79c1\u5bc6");
    }

    public static int s2() {
        String config = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_get_devices_for_maxduration", "");
        if (!TextUtils.isEmpty(config)) {
            for (String str : config.split(",")) {
                if (DeviceInfoMonitor.getModel().toLowerCase().equals(str.toLowerCase())) {
                    return 60000;
                }
            }
        }
        return QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_get_max_video_duration", 180000);
    }

    public static String s3(String str, String str2, boolean z16) {
        String str3 = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_album_works_edit_url", "https://m.xsj.qq.com/h5/compilation/edit?albumID=") + str + "&version=" + str2;
        if (z16) {
            return str3 + "&xsj_album_source=draft";
        }
        return str3;
    }

    public static int s4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_share_guide_show_max_count", 3);
    }

    public static boolean s5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_dynamic_table_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean s6() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_low_level_publish_open_photo_wall", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean t() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_fit_vas_dark_theme", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean t0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_player_background_intercept_x", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String t1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_album_owner", "");
    }

    public static double t2() {
        return Double.parseDouble(QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_memory_tracker_ratio", "0.001"));
    }

    public static int t3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_cache_invalidate_time_interval_after_exit", 600);
    }

    public static int t4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_product_layer_share_guide_text_test", 0);
    }

    public static boolean t5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_player_spr_experiment", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean t6() {
        boolean u46 = u4();
        if (!M6() && !L6(u46) && !y6(u46)) {
            return false;
        }
        return true;
    }

    public static boolean u() {
        if (X0("qqcircle", "qqcircle_fix_pad_cover_error_enable", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean u0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_enable_video_flow_report", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String u1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_album_owner", "");
    }

    public static double u2() {
        return Double.parseDouble(QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_memory_tracker_report_ratio", "0.01"));
    }

    public static int u3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_comment_max_words_limit", 100);
    }

    public static boolean u4() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.d("QCircleConfigHelper", 1, "appRuntime is null");
            return false;
        }
        try {
            return ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        } catch (Exception e16) {
            QLog.e("QCircleConfigHelper", 1, "getStudyMode error", e16.getMessage());
            return false;
        }
    }

    public static boolean u5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "wink_enable_skip_no_service", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean u6() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_is_open_page_interactive_param_collect", 1);
        if (QLog.isColorLevel()) {
            QLog.e("QCircleConfigHelper", 1, "isQQCircleOpenPageInteractiveParamCollect:" + config);
        }
        if (config == 1) {
            return true;
        }
        return false;
    }

    public static boolean v() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_fix_effect_comment_anim", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean v0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_enable_video_mix_flow_report", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String v1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_album_owner", "\u8be5\u7528\u6237\u6682\u672a\u6536\u85cf\u5408\u96c6");
    }

    public static boolean v2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_userhome_need_web_preload", true);
    }

    public static int v3(int i3) {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_default_show_tab_type", i3);
    }

    public static int v4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_subscribe_fetch_data", 0);
    }

    public static boolean v5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_export_enable_snapshot", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean v6() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_drawer_tab", 0);
        try {
            if (QLog.isColorLevel()) {
                QLog.e("QCircleConfigHelper", 1, "isQQCircleShowDrawTabEntrance:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config != 1) {
            return false;
        }
        return true;
    }

    public static boolean w() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_fix_softkeyboard_listener", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean w0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_enable_video_preload_flow_report", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String w1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_title_no_album_owner", "\u6ca1\u6709\u6536\u85cf\u7684\u5408\u96c6\n\u53bb\u5e7f\u573a\u6536\u85cf\u559c\u6b22\u7684\u5408\u96c6\u5427\uff5e");
    }

    public static int w2() {
        return 3;
    }

    public static String w3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_detail_error_content_deleted_text", "\u5bb3\uff01\u6765\u665a\u4e00\u6b65\n\u8fd9\u4e2a\u5185\u5bb9\u5df2\u4e0b\u843d\u4e0d\u660e");
    }

    public static float w4() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qfs_player_report_rate", 0.1f);
    }

    public static boolean w5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_switch_export_mode", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean w6(boolean z16) {
        return "1".equals(QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_entrance_enable", "1", false));
    }

    public static boolean x() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_fix_local_activity_memory_leak", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean x0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_enable_split_video_flow_report", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String x1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_collected_feed_hint_clinet", "\u8be5\u7528\u6237\u6682\u672a\u6536\u85cf\u4f5c\u54c1");
    }

    public static String x2() {
        return String.valueOf(w2());
    }

    public static String x3() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_empty_comment_hint", "\u6682\u65e0\u8bc4\u8bba\uff0c\u6765\u62a2\u6c99\u53d1\u5427");
    }

    public static long x4() {
        return X0("qqcircle", "qqcircle_rerank_getitem_error_interval", 600000).intValue();
    }

    public static boolean x5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_teen_mode_anti_addiction_tips", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean x6(boolean z16) {
        boolean z17;
        boolean z18;
        boolean M6 = M6();
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_recommend_tab", 0, false) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_recommend_tab_entrance_enable_teenmode", 1, false) == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (M6 || !z17 || !z18) {
                return false;
            }
            return true;
        }
        if (M6 || !z17) {
            return false;
        }
        return true;
    }

    public static boolean y() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qfs_enable_flow_report", 1, false) == 1) {
            return true;
        }
        return false;
    }

    public static boolean y0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_qqcircle_mute_interceptor", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String y1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_collected_feed_hint_owner", "\u6ca1\u6709\u6536\u85cf\u7684\u4f5c\u54c1\n\u53bb\u5e7f\u573a\u6536\u85cf\u559c\u6b22\u7684\u4f5c\u54c1\u5427\uff5e");
    }

    public static long y2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_publish_public_account_clear_time", 1000L);
    }

    public static boolean y3() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_folder_cache", 1) > 0) {
            return true;
        }
        return false;
    }

    public static long y4() {
        return X0("qqcircle", "qqcircle_rerank_getitem_interval", 2000).intValue();
    }

    public static boolean y5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_export_enable_merge", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean y6(boolean z16) {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_message_tab", 0, false);
        try {
            if (QLog.isColorLevel()) {
                QLog.e("QCircleConfigHelper", 1, "isQQCircleShowMessageEntrance:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config != 1 || M6()) {
            return false;
        }
        return true;
    }

    public static boolean z() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_font_size_change_follow_qq", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean z0() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_watched_history_auto_push", 1) == 1) {
            return true;
        }
        return false;
    }

    public static String z1() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_error_hint_no_praised_client", "\u5148\u53bb\u5e7f\u573a\u770b\u770b\u5427\uff5e");
    }

    public static int z2() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_new_publish_public_account_close_threshold", 3);
    }

    public static boolean z3() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_reuse_option", 0) != 1) {
            return false;
        }
        return true;
    }

    public static byte[] z4() {
        byte[] d16 = k.a().d("sp_key_user_vip_info", new byte[0]);
        QLog.d("QCircleConfigHelper", 1, "getUserVipInfo... qq_vip byte.length:" + d16.length);
        return d16;
    }

    public static boolean z5() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_wink_export_enable_quickclip", 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean z6() {
        int config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_mood_sync_circle", ((IAppSettingApi) e.b().a(IAppSettingApi.class)).isDebugVersion() ? 1 : 0);
        try {
            if (QLog.isColorLevel()) {
                QLog.e("QCircleConfigHelper", 1, "isQQCircleShowMoodSyncEntrance:" + config);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (config == 1) {
            return true;
        }
        return false;
    }
}
