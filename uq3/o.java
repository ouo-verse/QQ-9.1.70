package uq3;

import android.text.TextUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class o {
    public static boolean A() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebable_release_other_player_when_tab_selected", true);
    }

    public static int A0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_report_quality_sample_rate", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean A1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_preload_personal_switch", true);
    }

    public static boolean B() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_send_rain_bow_request", false);
    }

    public static int B0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_resend_max_count", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean B1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_public_account_preload_first", true);
    }

    public static boolean C() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_share_panel_float", true);
    }

    public static String C0(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_resend_white_list", str);
    }

    public static boolean C1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_quic_receive_timeout_intercept", true);
    }

    public static boolean D() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_play_direct_when_prepared", true);
    }

    public static String D0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_sandbox_activity_white_list", "com.hello.sandbox.proxy.ProxyActivity|");
    }

    public static boolean D1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_quic_upper_limit_fail_rollback", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean E() {
        if ((!AppSetting.isPublicVersion() && k.a().c("QCircleLocalActivityModeController", false)) || ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isAllowLandscape()) {
            return false;
        }
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_use_native_fragment_v3", false) && AppSetting.isPublicVersion() && !F()) {
            return false;
        }
        return true;
    }

    public static int E0() {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enable_auto_show_float", "-1");
            if (TextUtils.equals(loadAsString, "-1")) {
                return Integer.MAX_VALUE;
            }
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.d("QFSUnitedConfigHelper", 4, e16, new Object[0]);
            return Integer.MAX_VALUE;
        }
    }

    public static boolean E1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_quic_ipv4_priority", true);
    }

    public static boolean F() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_use_native_fragment_gray_v3", false) || !AppSetting.isGrayVersion()) {
            return false;
        }
        return true;
    }

    public static int F0(int i3) {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_update_load_more_back_up_residue_num", "");
            if (TextUtils.isEmpty(loadAsString)) {
                return i3;
            }
            return Integer.parseInt(loadAsString);
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean F1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_quic_ip_strategy", true);
    }

    public static int G() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_1505_tab_report_max_retry_times", "3");
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.e("QFSUnitedConfigHelper", 1, "[get1505ReportMaxRetryTimes] error: " + e16 + ",maxRetryTimes:" + loadAsString);
            return 3;
        }
    }

    public static int G0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_weak_net_cmd_max_report_cost", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean G1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_quic_zstd_dictionary", true);
    }

    public static long H() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_1505_tab_retry_duration", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID);
        try {
            return Long.parseLong(loadAsString);
        } catch (Exception e16) {
            QLog.e("QFSUnitedConfigHelper", 1, "[get1505ReportRetryDuration] error: " + e16 + ",retryDuration:" + loadAsString);
            return 2000L;
        }
    }

    public static boolean H0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_all_business_page_full", true);
    }

    public static boolean H1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_recover_small_window", true);
    }

    public static int I() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_571_tab_report_max_retry_times", "3");
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            QLog.e("QFSUnitedConfigHelper", 1, "[get571ReportMaxRetryTimes] error: " + e16 + ",maxRetryTimes:" + loadAsString);
            return 3;
        }
    }

    public static boolean I0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_1505_report_when_open_qq", true);
    }

    public static boolean I1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_refresh_small_window_click_selected", true);
    }

    public static long J() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_571_tab_retry_duration", TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID);
        try {
            return Long.parseLong(loadAsString);
        } catch (Exception e16) {
            QLog.e("QFSUnitedConfigHelper", 1, "[get571ReportRetryDuration] error: " + e16 + ",retryDuration:" + loadAsString);
            return 2000L;
        }
    }

    public static boolean J0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_571_report_when_enter_qcircle", true);
    }

    public static boolean J1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enabled_release_small_window", true);
    }

    public static long K(long j3) {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_av1_drop_frame_back_rate", String.valueOf(j3)));
        } catch (Throwable unused) {
            return j3;
        }
    }

    public static boolean K0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_float_fix_player_release", true);
    }

    public static boolean K1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_report_sample_rate", true);
    }

    public static long L(long j3) {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_av1_low_device_drop_frame_back_rate", String.valueOf(j3)));
        } catch (Throwable unused) {
            return j3;
        }
    }

    public static boolean L0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_float_exp_report", false);
    }

    public static boolean L1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_request_resend", true);
    }

    public static Map<String, String> M(String str, Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
            if (loadRawConfig.length == 0) {
                return map;
            }
            String str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(str2)) {
                return map;
            }
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                for (String str3 : map.keySet()) {
                    if (!TextUtils.isEmpty(str3)) {
                        hashMap.put(str3, jSONObject.optString(str3, map.get(str3)));
                    }
                }
            } catch (Exception e16) {
                QLog.e("QFSUnitedConfigHelper", 1, "[getBatchRawConfigValue] exception: " + e16);
            }
            return hashMap;
        }
        return map;
    }

    public static boolean M0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_full_screen_share", true);
    }

    public static boolean M1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_reset_density", false);
    }

    public static Long N(Long l3) {
        try {
            return Long.valueOf(Long.parseLong(z0("105499", "overtime_second", String.valueOf(l3))) * 1000);
        } catch (Throwable unused) {
            return l3;
        }
    }

    public static boolean N0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_page_back_open_folder", true);
    }

    public static boolean N1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_retry_ping_quic_req", true);
    }

    public static int O(int i3) {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_chat_history_load_more_page_max_count", "");
            if (TextUtils.isEmpty(loadAsString)) {
                return i3;
            }
            return Integer.parseInt(loadAsString);
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean O0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_player_reuse_1", true);
    }

    public static boolean O1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_show_drawer_panel_player_control", true);
    }

    public static int P(int i3) {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_chat_history_load_more_req_count", "");
            if (TextUtils.isEmpty(loadAsString)) {
                return i3;
            }
            return Integer.parseInt(loadAsString);
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean P0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_quality_resend_event_report", true);
    }

    public static boolean P1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_simple_exchange", true);
    }

    public static String Q() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_adjust_full_screen_pic_select_page_height_model", "Lenovo L78011");
    }

    public static boolean Q0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_reset_seek_bar_mock_down_event", true);
    }

    public static boolean Q1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_skin_load_success_checked", true);
    }

    public static int R(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_congestion_control_type", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean R0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_seek_bar_enable", true);
    }

    public static boolean R1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_skin_release_inflater_enabled_8890", true);
    }

    public static int S(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_device_usage_interval_time", String.valueOf(i3)));
        } catch (Throwable th5) {
            QLog.e("QFSUnitedConfigHelper", 1, th5, new Object[0]);
            return i3;
        }
    }

    public static boolean S0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_seek_bar_reset_when_focus_change", true);
    }

    public static boolean S1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enabled_small_window_jump_red_point_intercept", true);
    }

    public static int T(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_first_play_min_report_cost", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean T0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_sys_player_get_poi_on_back_thread", true);
    }

    public static boolean T1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_theme_video_pause", true);
    }

    public static String U(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_flow_peak_rule_json", str);
    }

    public static boolean U0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_video_fluency_exp_v2", true);
    }

    public static boolean U1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_upgrade_high_device", true);
    }

    public static long V(long j3) {
        try {
            if (TextUtils.isEmpty(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_request_feed_list_timeout_duration", ""))) {
                return j3;
            }
            return Integer.parseInt(r0);
        } catch (Throwable unused) {
            return j3;
        }
    }

    public static boolean V0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enabled_to_app_front_check_task", true);
    }

    public static boolean V1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_window_mode_status", true);
    }

    public static String W(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_hdr_video_black_list", str);
    }

    public static boolean W0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_async_request_orientation", true);
    }

    public static boolean W1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_init_571_when_enter_qcircle", true);
    }

    public static int X(int i3) {
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_local_read_device_info_interval", "");
            if (TextUtils.isEmpty(loadAsString)) {
                return i3;
            }
            return Integer.parseInt(loadAsString);
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean X0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_bluetooth_latency_optimize", true);
    }

    public static boolean X1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_support_data_center_weak_live_data", true);
    }

    public static int Y(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_low_device_max_av1_bad_case_count", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean Y0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_cancel_xiaomi_bg_floating_anim", true);
    }

    public static boolean Y1(String str, boolean z16) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, z16);
    }

    public static int Z(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_max_av1_bad_case_count", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean Z0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enabled_chat_history_position_change", true);
    }

    public static boolean Z1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_window_animations_bugfix", false);
    }

    public static boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_close_plugin_bean_fetch", true);
    }

    public static long a0() {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_media_scan_start_interval", "30000"));
        } catch (Throwable th5) {
            QLog.e("QFSUnitedConfigHelper", 1, th5, new Object[0]);
            return Long.parseLong("30000");
        }
    }

    public static boolean a1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_log_color_whilt_list", false);
    }

    public static boolean a2() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_peak_hight_adjust_preload_time", true);
    }

    public static boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_disable_request_set_share_message", false);
    }

    public static String b0(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_moon_cake_chat_no_limit_white_list", str);
    }

    public static boolean b1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_delayed_update_skin_package_state", true);
    }

    public static boolean b2() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("QQCIRCLE_ENABLE_EXP_REPORT_FILTER_571", true);
    }

    public static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebable_finish_activit_when_login_out", true);
    }

    public static String c0(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_moon_cake_client_report_success_rate_cmd", str);
    }

    public static boolean c1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_device_usage_info_print", true);
    }

    public static boolean c2() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_exp_report_filter", true);
    }

    public static boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_localactivity_release_android_15", true);
    }

    public static long d0(long j3) {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_moon_cake_feature_mask", String.valueOf(j3)));
        } catch (Throwable unused) {
            return j3;
        }
    }

    public static boolean d1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_dis_patch_video_event", false);
    }

    public static boolean e() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_support_url_append_exp_name", true);
    }

    public static int e0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_moon_cake_video_allow_long", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean e1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_display_pinned_comment", true);
    }

    public static boolean f() {
        try {
            if (TextUtils.equals(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_enable_auto_show_float", "-1"), "-1")) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.d("QFSUnitedConfigHelper", 4, e16, new Object[0]);
            return false;
        }
    }

    public static int f0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_moon_cake_video_length", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean f1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_empty_cmd_list_checked", true);
    }

    public static boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_close_layer_page_by_float_event", true);
    }

    public static String g0(String str) {
        String str2;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("qqcircle_new_friend_thank_action_text_8988", new byte[0]);
        if (loadRawConfig.length == 0) {
            str2 = "{\"msgThankNoneTxt\":\"\u8c22\u8c22\",\"msgThankConfirmTxt\":\"\u5df2\u611f\u8c22\",\"msgAllThanksNoneTxt\":\"\u5168\u90e8\u611f\u8c22\",\"msgAllThanksConfirmTxt\":\"\u5df2\u5168\u90e8\u611f\u8c22\"}";
        } else {
            str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
        }
        try {
            return new JSONObject(str2).optString(str, "");
        } catch (JSONException e16) {
            QLog.e("QFSUnitedConfigHelper", 1, "[getConfigValue] exception: " + e16);
            return "";
        }
    }

    public static boolean g1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enter_out_anim_finish", true);
    }

    public static boolean h() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qfs_close_lbs_cache_base_request", true);
    }

    public static int h0(int i3) {
        try {
            return Integer.parseInt(z0("qqcircle_new_config_direct_ip_max_size", "max_count_total", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean h1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_flow_peak_rule", true);
    }

    public static boolean i() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qfs_close_lbs_cache_base_business", true);
    }

    public static String i0(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_old_flow_orientation_device_list", str);
    }

    public static boolean i1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_fold_update_home_resident", true);
    }

    public static boolean j() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_deep_use_memory_optimize", true);
    }

    public static String j0(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_one_key_defend_detail", str);
    }

    public static boolean j1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_frame_screen_state_update", true);
    }

    public static boolean k() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_qcircle_av1_mediacodec_detect", false);
    }

    public static String k0(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_one_key_defend_title", str);
    }

    public static boolean k1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enabled_full_screen_orientation_destroyed_checked", true);
    }

    public static boolean l() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_exchange_url_when_no_dist_new", true);
    }

    public static String l0(String str) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_pcdn_black_list", str);
    }

    public static boolean l1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_get_pre_page_id", true);
    }

    public static boolean m() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_video_duration_fix", true);
    }

    public static int m0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_pcdn_protect_buff_time", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean m1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_global_page_id_fix", true);
    }

    public static boolean n() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_localactivity_null", true);
    }

    public static int n0() {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_peak_hight_adjust_preload_time", "2000"));
        } catch (Throwable unused) {
            return 2000;
        }
    }

    public static boolean n1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_jump_small_to_home_page_release", true);
    }

    public static boolean o() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebable_fix_play_type", true);
    }

    public static int o0(int i3) {
        try {
            return Integer.parseInt(z0("qqcircle_personal_collect_box_add_content_max_count_910", "max_count_once", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean o1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_layer_album_config_change_close", true);
    }

    public static boolean p() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_float_data_insert", true);
    }

    public static int p0(int i3) {
        try {
            return Integer.parseInt(z0("qqcircle_personal_collect_box_add_content_max_count_910", "max_count_total", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean p1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_load_more_optimize_exp", true);
    }

    public static boolean q() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_float_data_replcae_current_data", true);
    }

    public static int q0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_quic_fail_max_range_count", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean q1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_medium_device_fix", true);
    }

    public static boolean r() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_fuzzy_sensitive_log", true);
    }

    public static long r0(long j3) {
        try {
            return Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qcircle_quic_fail_max_range_time", String.valueOf(j3)));
        } catch (Throwable unused) {
            return j3;
        }
    }

    public static boolean r1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_mix_feed_sub_tab_quic_protocol", true);
    }

    public static boolean s() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_hdr_new_capability", true);
    }

    public static int s0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_quality_resend_limit_count", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean s1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_new_bottom_comment_layout", false);
    }

    public static boolean t() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_process_async_inteceptor_when_release", true);
    }

    public static int t0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_congestion_initial_window", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean t1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_new_config_direct_ip", true);
    }

    public static boolean u() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("QQCIRCLE_ENABLE_LOW_DEVICE_REMAIN_PLAYER_TAB_CHANGE", false);
    }

    public static float u0(float f16) {
        try {
            return Float.parseFloat(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_engine_connect_timeout", String.valueOf(f16)));
        } catch (Throwable unused) {
            return f16;
        }
    }

    public static boolean u1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enabled_new_device_level", true);
    }

    public static boolean v() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_ebable_player_adaptive_framerate", true);
    }

    public static float v0(float f16) {
        try {
            return Float.parseFloat(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_engine_idle_timeout", String.valueOf(f16)));
        } catch (Throwable unused) {
            return f16;
        }
    }

    public static boolean v1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enabled_new_obtain_color_res", true);
    }

    public static boolean w() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_poi_in_new_pic_content_detail", false);
    }

    public static float w0(float f16) {
        try {
            return Float.parseFloat(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_engine_recv_timeout", String.valueOf(f16)));
        } catch (Throwable unused) {
            return f16;
        }
    }

    public static boolean w1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_personal_quic_protocol", false);
    }

    public static boolean x() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_re_notify_resume_interceptor_player", true);
    }

    public static int x0(int i3) {
        try {
            return Integer.parseInt(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_ping_keep_alive_sec", String.valueOf(i3)));
        } catch (Throwable unused) {
            return i3;
        }
    }

    public static boolean x1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_picture_preload", true);
    }

    public static boolean y() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_all_video_history_recorder", true);
    }

    public static float y0(float f16) {
        try {
            return Float.parseFloat(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_quic_request_timeout", String.valueOf(f16)));
        } catch (Throwable unused) {
            return f16;
        }
    }

    public static boolean y1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_ping_keep_alive", true);
    }

    public static boolean z() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_close_player_by_window_event", true);
    }

    public static String z0(String str, String str2, String str3) {
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
        if (loadRawConfig.length == 0) {
            return str3;
        }
        String str4 = new String(loadRawConfig, StandardCharsets.UTF_8);
        if (TextUtils.isEmpty(str4)) {
            return str3;
        }
        try {
            return new JSONObject(str4).optString(str2, str3);
        } catch (JSONException e16) {
            QLog.e("QFSUnitedConfigHelper", 1, "[getConfigValue] exception: " + e16);
            return str3;
        }
    }

    public static boolean z1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabled_close_preload_ad_feed", true);
    }
}
