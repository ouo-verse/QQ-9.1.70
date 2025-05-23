package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x920$CreateMeeting extends MessageMicro<oidb_cmd0x920$CreateMeeting> {
    public static final int RPT_MSG_MEETING_INFO1_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_meeting_info1"}, new Object[]{null}, oidb_cmd0x920$CreateMeeting.class);
    public final PBRepeatMessageField<oidb_cmd0x920$MeetingInfo> rpt_msg_meeting_info1 = PBField.initRepeatMessage(oidb_cmd0x920$MeetingInfo.class);
}
