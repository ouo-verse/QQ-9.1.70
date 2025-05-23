package tencent.im.oidb.cmd0x920;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x920$CancleMeeting extends MessageMicro<oidb_cmd0x920$CancleMeeting> {
    public static final int RPT_MSG_MEETING_INFO2_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_meeting_info2"}, new Object[]{null}, oidb_cmd0x920$CancleMeeting.class);
    public final PBRepeatMessageField<oidb_cmd0x920$MeetingInfo> rpt_msg_meeting_info2 = PBField.initRepeatMessage(oidb_cmd0x920$MeetingInfo.class);
}
