package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x90$MsgBody extends MessageMicro<SubMsgType0x90$MsgBody> {
    public static final int MSG_BODY_FIELD_NUMBER = 2;
    public static final int MSG_HEAD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_head", "msg_body"}, new Object[]{null, null}, SubMsgType0x90$MsgBody.class);
    public SubMsgType0x90$Head msg_head = new MessageMicro<SubMsgType0x90$Head>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90$Head
        public static final int UINT32_CMD_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_cmd"}, new Object[]{0}, SubMsgType0x90$Head.class);
        public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    };
    public SubMsgType0x90$PushBody msg_body = new MessageMicro<SubMsgType0x90$PushBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90$PushBody
        public static final int MSG_DP_NOTIFY_BODY_FIELD_NUMBER = 1;
        public static final int MSG_OCCUPY_MICROPHONE_BODY_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_dp_notify_body", "msg_occupy_microphone_body"}, new Object[]{null, null}, SubMsgType0x90$PushBody.class);
        public SubMsgType0x90$DpNotifyMsgBdoy msg_dp_notify_body = new MessageMicro<SubMsgType0x90$DpNotifyMsgBdoy>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90$DpNotifyMsgBdoy
            public static final int RPT_MSG_NOTIFY_INFO_FIELD_NUMBER = 3;
            public static final int STRING_EXTEND_INFO_FIELD_NUMBER = 4;
            public static final int UINT32_PID_FIELD_NUMBER = 1;
            public static final int UINT64_DIN_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_pid", "uint64_din", "rpt_msg_notify_info", "string_extend_info"}, new Object[]{0, 0L, null, ""}, SubMsgType0x90$DpNotifyMsgBdoy.class);
            public final PBUInt32Field uint32_pid = PBField.initUInt32(0);
            public final PBUInt64Field uint64_din = PBField.initUInt64(0);
            public final PBRepeatMessageField<SubMsgType0x90$NotifyItem> rpt_msg_notify_info = PBField.initRepeatMessage(SubMsgType0x90$NotifyItem.class);
            public final PBStringField string_extend_info = PBField.initString("");
        };
        public SubMsgType0x90$OccupyMicrophoneNotifyMsgBody msg_occupy_microphone_body = new MessageMicro<SubMsgType0x90$OccupyMicrophoneNotifyMsgBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90$OccupyMicrophoneNotifyMsgBody
            public static final int UINT32_UIN_FIELD_NUMBER = 1;
            public static final int UINT64_DIN_FIELD_NUMBER = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_uin", "uint64_din"}, new Object[]{0, 0L}, SubMsgType0x90$OccupyMicrophoneNotifyMsgBody.class);
            public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
            public final PBUInt64Field uint64_din = PBField.initUInt64(0);
        };
    };
}
