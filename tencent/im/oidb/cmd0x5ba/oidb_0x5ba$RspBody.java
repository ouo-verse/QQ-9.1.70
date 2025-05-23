package tencent.im.oidb.cmd0x5ba;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5ba$RspBody extends MessageMicro<oidb_0x5ba$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"uint32_result", "bytes_errmsg", "msg_rewards", "msg_resource", "uint32_reward_privilege", "string_privilege_desc"}, new Object[]{0, ByteStringMicro.EMPTY, null, null, 0, ""}, oidb_0x5ba$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x5ba$Reward msg_rewards = new MessageMicro<oidb_0x5ba$Reward>() { // from class: tencent.im.oidb.cmd0x5ba.oidb_0x5ba$Reward
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_myreward_totalincome", "uint32_myreward_totalcount", "uint32_is_end", "rpt_rewards"}, new Object[]{0, 0, 0, null}, oidb_0x5ba$Reward.class);
        public final PBUInt32Field uint32_myreward_totalincome = PBField.initUInt32(0);
        public final PBUInt32Field uint32_myreward_totalcount = PBField.initUInt32(0);
        public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
        public final PBRepeatMessageField<oidb_0x5ba$RewardItem> rpt_rewards = PBField.initRepeatMessage(oidb_0x5ba$RewardItem.class);
    };
    public oidb_0x5ba$RewardItem msg_resource = new MessageMicro<oidb_0x5ba$RewardItem>() { // from class: tencent.im.oidb.cmd0x5ba.oidb_0x5ba$RewardItem
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 80, 88, 98, 106, 114, 122, 130, 138, 144, 152, 162, 168, 176}, new String[]{"uint64_request_uin", "uint32_request_time", "uint64_pay_uin", "uint32_pay_time", "uint32_pay_count", "uint32_punish_left_time", "uint32_shootscreen_punish_time", "string_punish_warning_info", "uint32_reward_type", "uint32_reward_fee", "uint32_reward_status", "string_reward_text", "string_reward_id", "string_blur_pic_url", "string_clear_pic_url", "string_vid", "string_cookie", "uint32_reward_expire", "uint32_video_duration", "string_ckey", "uint32_close_time", "uint64_request_gc"}, new Object[]{0L, 0, 0L, 0, 0, 0, 0, "", 0, 0, 0, "", "", "", "", "", "", 0, 0, "", 0, 0L}, oidb_0x5ba$RewardItem.class);
        public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_request_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_pay_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_pay_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pay_count = PBField.initUInt32(0);
        public final PBUInt32Field uint32_punish_left_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_shootscreen_punish_time = PBField.initUInt32(0);
        public final PBStringField string_punish_warning_info = PBField.initString("");
        public final PBUInt32Field uint32_reward_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_reward_fee = PBField.initUInt32(0);
        public final PBUInt32Field uint32_reward_status = PBField.initUInt32(0);
        public final PBStringField string_reward_text = PBField.initString("");
        public final PBStringField string_reward_id = PBField.initString("");
        public final PBStringField string_blur_pic_url = PBField.initString("");
        public final PBStringField string_clear_pic_url = PBField.initString("");
        public final PBStringField string_vid = PBField.initString("");
        public final PBStringField string_cookie = PBField.initString("");
        public final PBUInt32Field uint32_reward_expire = PBField.initUInt32(0);
        public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
        public final PBStringField string_ckey = PBField.initString("");
        public final PBUInt32Field uint32_close_time = PBField.initUInt32(0);
        public final PBUInt64Field uint64_request_gc = PBField.initUInt64(0);
    };
    public final PBUInt32Field uint32_reward_privilege = PBField.initUInt32(0);
    public final PBStringField string_privilege_desc = PBField.initString("");
}
