package tencent.im.oidb;

import appoint.define.appoint_define$LocaleInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cb$RspBody extends MessageMicro<cmd0x7cb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104}, new String[]{"uint32_time_stamp", "uint32_time_gap", "rpt_comment_configs", "str_attend_tips_to_A", "str_first_msg_tips", "rpt_cancle_config", "msg_date_request", "rpt_msg_hot_locale", "rpt_msg_topic_list", "str_travel_msg_tips", "str_travel_profile_tips", "str_travel_atten_tips", "uint32_topic_default"}, new Object[]{0, 0, null, "", "", null, null, null, null, "", "", "", 0}, cmd0x7cb$RspBody.class);
    public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_gap = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x7cb$CommentConfig> rpt_comment_configs = PBField.initRepeatMessage(cmd0x7cb$CommentConfig.class);
    public final PBStringField str_attend_tips_to_A = PBField.initString("");
    public final PBStringField str_first_msg_tips = PBField.initString("");
    public final PBRepeatMessageField<cmd0x7cb$ConfigItem> rpt_cancle_config = PBField.initRepeatMessage(cmd0x7cb$ConfigItem.class);
    public cmd0x7cb$DateRequest msg_date_request = new MessageMicro<cmd0x7cb$DateRequest>() { // from class: tencent.im.oidb.cmd0x7cb$DateRequest
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_time", "str_err_msg"}, new Object[]{0, ""}, cmd0x7cb$DateRequest.class);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
        public final PBStringField str_err_msg = PBField.initString("");
    };
    public final PBRepeatMessageField<appoint_define$LocaleInfo> rpt_msg_hot_locale = PBField.initRepeatMessage(appoint_define$LocaleInfo.class);
    public final PBRepeatMessageField<cmd0x7cb$TopicConfig> rpt_msg_topic_list = PBField.initRepeatMessage(cmd0x7cb$TopicConfig.class);
    public final PBStringField str_travel_msg_tips = PBField.initString("");
    public final PBStringField str_travel_profile_tips = PBField.initString("");
    public final PBStringField str_travel_atten_tips = PBField.initString("");
    public final PBUInt32Field uint32_topic_default = PBField.initUInt32(0);
}
