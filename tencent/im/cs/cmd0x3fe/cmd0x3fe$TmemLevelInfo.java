package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$TmemLevelInfo extends MessageMicro<cmd0x3fe$TmemLevelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 122, 128, 136, 144, 152, 160, 168, 176, 186, 192, 200, 208, 216, 226}, new String[]{"uint32_time_stamp", "uint32_day_socre", "uint32_online_time", "uint32_online_score", "uint32_send_flowers_score", "uint32_recv_flowers_score", "uint32_send_gift_score", "uint32_recv_gift_score", "uint32_upgrade_score", "msg_level_info", "uint32_send_flower_num", "uint32_recv_flower_num", "uint32_send_gift_num", "uint32_recv_gift_num", "uint32_recv_gift_total", "uint32_send_gift_total", "uint32_recv_flower_total", "recent_days", "uint32_identity_score", "uint32_identity_level", "uint32_identity_upgrade_score", "uint32_days_to_downgrade", "rpt_msg_event_medal"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, null}, cmd0x3fe$TmemLevelInfo.class);
    public final PBRepeatMessageField<cmd0x3fe$event_medal> rpt_msg_event_medal;
    public final PBRepeatField<Integer> uint32_days_to_downgrade;
    public final PBRepeatField<Integer> uint32_identity_upgrade_score;
    public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_day_socre = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_flowers_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flowers_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upgrade_score = PBField.initUInt32(0);
    public cmd0x3fe$LevelInfo msg_level_info = new cmd0x3fe$LevelInfo();
    public final PBUInt32Field uint32_send_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flower_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_gift_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_gift_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_flower_total = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x3fe$qun_video_identity_score> recent_days = PBField.initRepeatMessage(cmd0x3fe$qun_video_identity_score.class);
    public final PBUInt32Field uint32_identity_score = PBField.initUInt32(0);
    public final PBUInt32Field uint32_identity_level = PBField.initUInt32(0);

    public cmd0x3fe$TmemLevelInfo() {
        PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
        this.uint32_identity_upgrade_score = PBField.initRepeat(pBUInt32Field);
        this.uint32_days_to_downgrade = PBField.initRepeat(pBUInt32Field);
        this.rpt_msg_event_medal = PBField.initRepeatMessage(cmd0x3fe$event_medal.class);
    }
}
