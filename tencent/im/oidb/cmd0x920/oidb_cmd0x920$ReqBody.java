package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x920$ReqBody extends MessageMicro<oidb_cmd0x920$ReqBody> {
    public static final int MSG_CANCLE_MEETING_FIELD_NUMBER = 3;
    public static final int MSG_CREATE_MEETING_FIELD_NUMBER = 2;
    public static final int MSG_GET_DISCUSS_MEETING_FIELD_NUMBER = 4;
    public static final int MSG_GET_SPECIFIED_MEETING_FIELD_NUMBER = 6;
    public static final int MSG_GET_USER_MEETING_FIELD_NUMBER = 5;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"uint32_subcmd", "msg_create_meeting", "msg_cancle_meeting", "msg_get_discuss_meeting", "msg_get_user_meeting", "msg_get_specified_meeting"}, new Object[]{0, null, null, null, null, null}, oidb_cmd0x920$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public oidb_cmd0x920$CreateMeeting msg_create_meeting = new oidb_cmd0x920$CreateMeeting();
    public oidb_cmd0x920$CancleMeeting msg_cancle_meeting = new oidb_cmd0x920$CancleMeeting();
    public oidb_cmd0x920$GetDiscussMeeting msg_get_discuss_meeting = new MessageMicro<oidb_cmd0x920$GetDiscussMeeting>() { // from class: tencent.im.oidb.cmd0x920.oidb_cmd0x920$GetDiscussMeeting
        public static final int UINT64_DISCUSS_UIN_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_discuss_uin"}, new Object[]{0L}, oidb_cmd0x920$GetDiscussMeeting.class);
        public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
    };
    public oidb_cmd0x920$GetUserMeeting msg_get_user_meeting = new MessageMicro<oidb_cmd0x920$GetUserMeeting>() { // from class: tencent.im.oidb.cmd0x920.oidb_cmd0x920$GetUserMeeting
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0x920$GetUserMeeting.class);
    };
    public oidb_cmd0x920$GetSpecifiedMeeting msg_get_specified_meeting = new MessageMicro<oidb_cmd0x920$GetSpecifiedMeeting>() { // from class: tencent.im.oidb.cmd0x920.oidb_cmd0x920$GetSpecifiedMeeting
        public static final int RPT_MSG_MEETING_INFO3_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_meeting_info3"}, new Object[]{null}, oidb_cmd0x920$GetSpecifiedMeeting.class);
        public final PBRepeatMessageField<oidb_cmd0x920$MeetingInfo> rpt_msg_meeting_info3 = PBField.initRepeatMessage(oidb_cmd0x920$MeetingInfo.class);
    };
}
