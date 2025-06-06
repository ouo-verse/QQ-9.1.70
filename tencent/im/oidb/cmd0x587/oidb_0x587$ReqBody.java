package tencent.im.oidb.cmd0x587;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x587$ReqBody extends MessageMicro<oidb_0x587$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 34, 40, 160018, 160072, 160248, 216480, 220066, 220082, 322176, 322504, 322512, 324328, 324336, 332856, 332872, 332880, 332888, 332904, 332912, 332944, 332952, 332976, 332984, 336600, 336712, 337024, 337376, 338312, 338584, 338664, 338720, 338848, 338888, 338936, 339016, 339336, 339352, 339400, 339904, 339912, 340040, 340256, 360824, 360864, 360872, 360952, 360960, 360968, 360976, 360984, 360992, 361096, 361232, 361256, 361280, 361288, 377368, 377376, 377416, 377440, 377472, 377480, 377488, 377496, 377528, 377560, 377568, 377584, 377608, 377624, 377632, 377640, 377648, 377656, 377664, 377704, 377712, 377720, 377728, 377776}, new String[]{"rpt_uint64_uins", "uint32_max_package_size", "rpt_bytes_openid", "uint32_appid", "str_nick", "uint32_gender", "uint32_birthday", "uint32_kid_mode_child_birthday", "phone_type", "str_zplanphoto_url", "uint32_profile_company_visible", "uint32_profile_interest_switch", "uint32_profile_music_switch", "uint32_ueflag", "uint32_parent_allow_flag", "uint32_profile_birthday_visible", "uint32_profile_constellation_visible", "uint32_profile_age_visible", "uint32_profile_sex_visible", "uint32_profile_hometown_visible", "uint32_profile_location_visible", "uint32_profile_profession_visible", "uint32_profile_college_visible", "uint32_profile_email_visible", "uint32_profile_personal_note_visible", "uint32_req_medalwall_flag", "uint32_may_know_person_switch", "uint32_profile_personality_label_switch", "uint32_extend_friend_card_shown", "uint32_profile_present_switch", "uint32_profile_miniapp_switch", "user_login_guard_face", "uint32_profile_musicbox_switch", "uint32_profile_sticky_note_switch", "uint32_profile_qqcircle_switch", "uint32_flag_profile_life_achievement_switch", "uint32_flag_profile_weishi_switch", "uint32_c2c_aio_shortcut_switch", "uint32_qq_assistant_switch", "uint32_profile_anonymous_answer_switch", "uint32_profile_show_idol_switch", "uint32_file_assist_top", "uint32_profile_wz_game_card_switch", "uint32_zplan_add_frd", "uint32_zplan_qzone_show", "unit32_hide_cm_show_emoticon_flag", "unit32_hide_camera_emoticon_flag", "uint32_zplan_message_notice_switch", "uint32_zplan_operators_network_switch", "uint32_zplan_samestyle_package_switch", "uint32_zplan_samestyle_asset_switch", "uint32_zplan_profile_card_show", "uint32_zplan_master_show", "uint32_normal_night_mode_flag", "uint32_profile_splendid_switch", "uint32_flag_use_mobile_net_switch", "uint32_profile_privilege", "uint32_profile_membership_and_rank", "uint32_online_status_avatar_switch", "uint32_profile_wz_game_skin_switch", "uint32_profile_dressup_switch", "uint32_profile_qqcard_switch", "uint32_profile_q_cub_switch", "uint32_qzone_receive_notify_push_switch", "uint32_profile_yuan_meng_card_switch", "uint32_profile_music_data_switch", "uint32_assisted_chat_c2c_switch", "uint32_kid_mode_can_net_search", "uint32_profile_game_info_switch", "uint32_intimate_notification_push_switch", "uint32_profile_meta_farm_switch", "uint32_assisted_chat_auto_polish_c2c", "uint32_assisted_chat_auto_polish_jieban", "uint32_assisted_chat_auto_polish_nearby", "uint32_assisted_chat_auto_topic_c2c", "uint32_assisted_chat_auto_topic_jieban", "uint32_assisted_chat_auto_topic_nearby", "uint32_assisted_chat_ai_assistant", "uint32_assisted_chat_reply_suggestion_c2c", "uint32_assisted_chat_reply_suggestion_jieban", "uint32_assisted_chat_reply_suggestion_nearby", "uint32_kid_mode_can_filter_url"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0, "", 0, 0, 0, "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, oidb_0x587$ReqBody.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_max_package_size = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_openid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBStringField str_nick = PBField.initString("");
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ueflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_parent_allow_flag = PBField.initUInt32(0);
    public final PBUInt32Field user_login_guard_face = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_sex_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_age_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_birthday_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_constellation_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_profession_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_college_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_location_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_hometown_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_email_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_personal_note_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_company_visible = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_medalwall_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_personality_label_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_profile_life_achievement_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_interest_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_music_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_present_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_miniapp_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_musicbox_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_sticky_note_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_qqcircle_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_profile_weishi_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_extend_friend_card_shown = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_anonymous_answer_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_wz_game_card_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_membership_and_rank = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_privilege = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_splendid_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_c2c_aio_shortcut_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qq_assistant_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_show_idol_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_assist_top = PBField.initUInt32(0);
    public final PBUInt32Field unit32_hide_cm_show_emoticon_flag = PBField.initUInt32(0);
    public final PBUInt32Field unit32_hide_camera_emoticon_flag = PBField.initUInt32(0);
    public final PBStringField phone_type = PBField.initString("");
    public final PBUInt32Field uint32_zplan_add_frd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zplan_qzone_show = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zplan_master_show = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zplan_profile_card_show = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zplan_samestyle_asset_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zplan_samestyle_package_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zplan_operators_network_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_zplan_message_notice_switch = PBField.initUInt32(0);
    public final PBStringField str_zplanphoto_url = PBField.initString("");
    public final PBUInt32Field uint32_normal_night_mode_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_use_mobile_net_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_status_avatar_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_wz_game_skin_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_dressup_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_qqcard_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_q_cub_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qzone_receive_notify_push_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_yuan_meng_card_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_music_data_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_c2c_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_kid_mode_can_net_search = PBField.initUInt32(0);
    public final PBUInt32Field uint32_kid_mode_child_birthday = PBField.initUInt32(0);
    public final PBUInt32Field uint32_kid_mode_can_filter_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_game_info_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_intimate_notification_push_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_profile_meta_farm_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_auto_polish_c2c = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_auto_polish_jieban = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_auto_polish_nearby = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_auto_topic_c2c = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_auto_topic_jieban = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_auto_topic_nearby = PBField.initUInt32(0);
    public final PBUInt32Field uint32_may_know_person_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_ai_assistant = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_reply_suggestion_c2c = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_reply_suggestion_jieban = PBField.initUInt32(0);
    public final PBUInt32Field uint32_assisted_chat_reply_suggestion_nearby = PBField.initUInt32(0);
}
