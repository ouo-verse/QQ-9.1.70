package tencent.im.mutualmark;

import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.tav.decoder.EncoderWriter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$MutualMark extends MessageMicro<mutualmark$MutualMark> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cluster;
    public final PBBytesField bytes_grade_resource_info;
    public final PBBytesField bytes_max_ver;
    public final PBBytesField bytes_min_ver;
    public final PBBytesField bytes_resource_info;
    public final PBBytesField bytes_special_word_attribute;
    public final PBFloatField float_last_week_count;
    public final PBStringField icon_format;
    public final PBStringField icon_url;
    public final PBBoolField is_wearing;
    public final PBUInt64Field light_up_time;
    public final PBUInt32Field mark_version;
    public final PBRepeatMessageField<mutualmark$MutualActionDay> rpt_mutual_action_day;
    public final PBUInt32Field uint32_love_flag;
    public final PBUInt32Field uint32_trans_flag;
    public final PBUInt64Field uint64_add_friend_flag;
    public final PBUInt64Field uint64_add_friend_time;
    public final PBUInt64Field uint64_add_friend_time_update_time;
    public final PBUInt64Field uint64_degrade_time;
    public final PBUInt64Field uint64_level_low_version;
    public final PBUInt64Field uint64_light_day;
    public final PBUInt64Field uint64_modify_time;
    public final PBUInt64Field uint64_push_time_c2c_100;
    public final PBUInt64Field uint64_push_time_c2c_50;
    public final PBUInt64Field uint64_push_time_score_1000;
    public final PBUInt64Field uint64_push_time_score_1200;
    public final PBUInt64Field uint64_push_time_score_200;
    public final PBUInt64Field uint64_push_time_score_400;
    public final PBUInt64Field uint64_push_time_score_600;
    public final PBUInt64Field uint64_push_time_score_800;
    public final PBUInt64Field uint64_push_time_talk;
    public final PBUInt64Field uint64_sub_level;
    public final PBRepeatField<Long> wear_ids;
    public final PBUInt64Field uint64_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_level = PBField.initUInt64(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0);
    public final PBFloatField float_count = PBField.initFloat(0.0f);
    public final PBUInt64Field uint64_day = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_icon_status = PBField.initUInt64(0);
    public final PBUInt64Field uint64_icon_status_end_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);

    static {
        Float valueOf = Float.valueOf(0.0f);
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 45, 48, 56, 64, 72, 80, 90, 98, 104, 114, 120, 128, 160, 168, 178, 184, 192, 200, 208, 218, 800, 1602, 1610, 8002, MessageHandlerConstants.NOTIFY_TYPE_PC_ACTIVE_NOTIFY, 40000, BaseConstants.ERR_SVR_PROFILE_WRITE_PERMISSION_REQUIRED, 40016, 48000, 120000, 120008, 120016, EncoderWriter.OUTPUT_AUDIO_BIT_RATE, 128008, 128016, 128024, 128032, 128040, 136002}, new String[]{"uint64_type", "uint64_level", "uint64_src_uin", "uint64_dst_uin", "float_count", "uint64_day", "uint64_time", "uint64_icon_status", "uint64_icon_status_end_time", "uint32_close_flag", "bytes_resource_info", "bytes_cluster", "uint64_sub_level", "bytes_grade_resource_info", "uint64_level_low_version", "uint64_light_day", "uint32_love_flag", "uint32_trans_flag", "icon_url", "mark_version", "wear_ids", "light_up_time", "is_wearing", "icon_format", "uint64_modify_time", "bytes_min_ver", "bytes_max_ver", "rpt_mutual_action_day", "float_last_week_count", "uint64_add_friend_time", "uint64_add_friend_flag", "uint64_add_friend_time_update_time", "uint64_degrade_time", "uint64_push_time_c2c_50", "uint64_push_time_c2c_100", "uint64_push_time_talk", "uint64_push_time_score_200", "uint64_push_time_score_400", "uint64_push_time_score_600", "uint64_push_time_score_800", "uint64_push_time_score_1000", "uint64_push_time_score_1200", "bytes_special_word_attribute"}, new Object[]{0L, 0L, 0L, 0L, valueOf, 0L, 0L, 0L, 0L, 0, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0L, 0L, 0, 0, "", 0, 0L, 0L, Boolean.FALSE, "", 0L, byteStringMicro, byteStringMicro, null, valueOf, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, byteStringMicro}, mutualmark$MutualMark.class);
    }

    public mutualmark$MutualMark() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_resource_info = PBField.initBytes(byteStringMicro);
        this.bytes_cluster = PBField.initBytes(byteStringMicro);
        this.uint64_sub_level = PBField.initUInt64(0L);
        this.bytes_grade_resource_info = PBField.initBytes(byteStringMicro);
        this.uint64_level_low_version = PBField.initUInt64(0L);
        this.uint64_light_day = PBField.initUInt64(0L);
        this.uint32_love_flag = PBField.initUInt32(0);
        this.uint32_trans_flag = PBField.initUInt32(0);
        this.icon_url = PBField.initString("");
        this.mark_version = PBField.initUInt32(0);
        this.wear_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.light_up_time = PBField.initUInt64(0L);
        this.is_wearing = PBField.initBool(false);
        this.icon_format = PBField.initString("");
        this.uint64_modify_time = PBField.initUInt64(0L);
        this.bytes_min_ver = PBField.initBytes(byteStringMicro);
        this.bytes_max_ver = PBField.initBytes(byteStringMicro);
        this.rpt_mutual_action_day = PBField.initRepeatMessage(mutualmark$MutualActionDay.class);
        this.float_last_week_count = PBField.initFloat(0.0f);
        this.uint64_add_friend_time = PBField.initUInt64(0L);
        this.uint64_add_friend_flag = PBField.initUInt64(0L);
        this.uint64_add_friend_time_update_time = PBField.initUInt64(0L);
        this.uint64_degrade_time = PBField.initUInt64(0L);
        this.uint64_push_time_c2c_50 = PBField.initUInt64(0L);
        this.uint64_push_time_c2c_100 = PBField.initUInt64(0L);
        this.uint64_push_time_talk = PBField.initUInt64(0L);
        this.uint64_push_time_score_200 = PBField.initUInt64(0L);
        this.uint64_push_time_score_400 = PBField.initUInt64(0L);
        this.uint64_push_time_score_600 = PBField.initUInt64(0L);
        this.uint64_push_time_score_800 = PBField.initUInt64(0L);
        this.uint64_push_time_score_1000 = PBField.initUInt64(0L);
        this.uint64_push_time_score_1200 = PBField.initUInt64(0L);
        this.bytes_special_word_attribute = PBField.initBytes(byteStringMicro);
    }
}
