package tencent.im.group_pro_proto.common;

import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.msg.im_msg_body$MsgBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Msg extends MessageMicro<common$Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"head", "ctrl_head", "body", "ext_info", "msg_core"}, new Object[]{null, null, null, null, null}, common$Msg.class);
    public common$MsgHead head = new common$MsgHead();
    public common$MsgCtrlHead ctrl_head = new MessageMicro<common$MsgCtrlHead>() { // from class: tencent.im.group_pro_proto.common.common$MsgCtrlHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64, 74, 80, 88, 96, 104, 112, 128, 138}, new String[]{"include_uin", "exclude_uin", "rpt_featureid", "offline_flag", "visibility", "ctrl_flag", LinkReportConstant$GlobalKey.EVENTS, "level", "personal_levels", "guild_sync_seq", "member_num", "channel_type", "private_type", "feature_action", "channel_visible_type", "s2c_msg_info"}, new Object[]{0L, 0L, 0L, 0, 0, 0L, null, 0L, null, 0L, 0, 0, 0, 0, 0, null}, common$MsgCtrlHead.class);
        public final PBUInt32Field channel_type;
        public final PBUInt32Field channel_visible_type;
        public final PBUInt64Field ctrl_flag;
        public final PBRepeatMessageField<common$Event> events;
        public final PBRepeatField<Long> exclude_uin;
        public final PBUInt32Field feature_action;
        public final PBUInt64Field guild_sync_seq;
        public final PBRepeatField<Long> include_uin;
        public final PBUInt64Field level;
        public final PBUInt32Field member_num;
        public final PBUInt32Field offline_flag;
        public final PBRepeatMessageField<common$PersonalLevel> personal_levels;
        public final PBUInt32Field private_type;
        public final PBRepeatField<Long> rpt_featureid;
        public common$S2CMsgInfo s2c_msg_info;
        public final PBUInt32Field visibility;

        {
            PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
            this.include_uin = PBField.initRepeat(pBUInt64Field);
            this.exclude_uin = PBField.initRepeat(pBUInt64Field);
            this.rpt_featureid = PBField.initRepeat(pBUInt64Field);
            this.offline_flag = PBField.initUInt32(0);
            this.visibility = PBField.initUInt32(0);
            this.ctrl_flag = PBField.initUInt64(0L);
            this.events = PBField.initRepeatMessage(common$Event.class);
            this.level = PBField.initUInt64(0L);
            this.personal_levels = PBField.initRepeatMessage(common$PersonalLevel.class);
            this.guild_sync_seq = PBField.initUInt64(0L);
            this.member_num = PBField.initUInt32(0);
            this.channel_type = PBField.initUInt32(0);
            this.private_type = PBField.initUInt32(0);
            this.feature_action = PBField.initUInt32(0);
            this.channel_visible_type = PBField.initUInt32(0);
            this.s2c_msg_info = new common$S2CMsgInfo();
        }
    };
    public im_msg_body$MsgBody body = new im_msg_body$MsgBody();
    public common$ExtInfo ext_info = new common$ExtInfo();
    public common$MsgCoreInfo msg_core = new common$MsgCoreInfo();
}
