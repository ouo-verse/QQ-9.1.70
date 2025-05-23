package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe03$RspBody extends MessageMicro<oidb_0xe03$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBEnumField enum_matchopcode = PBField.initEnum(1);
    public final PBEnumField enum_matchopretcode = PBField.initEnum(0);
    public oidb_0xe03$MatchInfo msg_match_info = new oidb_0xe03$MatchInfo();
    public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_default_tag_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0xe03$TagInfo> rpt_tag = PBField.initRepeatMessage(oidb_0xe03$TagInfo.class);
    public final PBRepeatField<ByteStringMicro> rpt_tips_wording = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_match_fail_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBRepeatField<Long> uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_time_out = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_voice_match_flag = PBField.initUInt64(0);
    public final PBUInt32Field uint32_flare_switch = PBField.initUInt32(0);
    public oidb_0xe03$matchTaskInfo msg_task_info = new oidb_0xe03$matchTaskInfo();
    public final PBUInt64Field uint64_max_match_times = PBField.initUInt64(0);
    public final PBUInt64Field uint64_matched_times = PBField.initUInt64(0);
    public final PBUInt64Field uint64_black_times = PBField.initUInt64(0);
    public final PBUInt64Field uint64_be_blacked_times = PBField.initUInt64(0);
    public final PBUInt64Field uint64_left_punish_time = PBField.initUInt64(0);
    public final PBStringField str_black_times_tips = PBField.initString("");
    public final PBStringField str_black_times_used_up_tips = PBField.initString("");
    public final PBStringField str_black_times_used_up_title = PBField.initString("");
    public final PBStringField str_be_black_tips = PBField.initString("");
    public final PBUInt32Field uint32_show_gray_tips = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 72, 82, 90, 98, 104, 112, 120, 128, 136, 144, 154, 160, 168, 184, 192, 200, 210, 218, 226, 234, 240}, new String[]{"uint64_uin", "enum_matchopcode", "enum_matchopretcode", "msg_match_info", "uint32_switch", "uint32_default_tag_id", "rpt_tag", "rpt_tips_wording", "bytes_match_fail_wording", "uint32_count", "uint64_uin_list", "uint32_time_out", "uint32_voice_count", "uint64_voice_match_flag", "uint32_flare_switch", "msg_task_info", "uint64_max_match_times", "uint64_matched_times", "uint64_black_times", "uint64_be_blacked_times", "uint64_left_punish_time", "str_black_times_tips", "str_black_times_used_up_tips", "str_black_times_used_up_title", "str_be_black_tips", "uint32_show_gray_tips"}, new Object[]{0L, 1, 0, null, 0, 0, null, byteStringMicro, byteStringMicro, 0, 0L, 0, 0, 0L, 0, null, 0L, 0L, 0L, 0L, 0L, "", "", "", "", 0}, oidb_0xe03$RspBody.class);
    }
}
