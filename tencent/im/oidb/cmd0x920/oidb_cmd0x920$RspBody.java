package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x920$RspBody extends MessageMicro<oidb_cmd0x920$RspBody> {
    public static final int MSG_CANCLE_MEETING_FIELD_NUMBER = 3;
    public static final int MSG_CREATE_MEETING_FIELD_NUMBER = 2;
    public static final int RPT_MSG_MEETING_INFO_FIELD_NUMBER = 4;
    public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_subcmd", "msg_create_meeting", "msg_cancle_meeting", "rpt_msg_meeting_info"}, new Object[]{0, null, null, null}, oidb_cmd0x920$RspBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public oidb_cmd0x920$CreateMeeting msg_create_meeting = new oidb_cmd0x920$CreateMeeting();
    public oidb_cmd0x920$CancleMeeting msg_cancle_meeting = new oidb_cmd0x920$CancleMeeting();
    public final PBRepeatMessageField<oidb_cmd0x920$MeetingInfo> rpt_msg_meeting_info = PBField.initRepeatMessage(oidb_cmd0x920$MeetingInfo.class);
}
