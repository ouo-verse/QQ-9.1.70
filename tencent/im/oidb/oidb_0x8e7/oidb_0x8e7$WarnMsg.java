package tencent.im.oidb.oidb_0x8e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8e7$WarnMsg extends MessageMicro<oidb_0x8e7$WarnMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rpt_msg_first_info", "rpt_msg_user_num_limit_info", "rpt_msg_zan_limit_info"}, new Object[]{null, null, null}, oidb_0x8e7$WarnMsg.class);
    public final PBRepeatMessageField<oidb_0x8e7$Text> rpt_msg_first_info = PBField.initRepeatMessage(oidb_0x8e7$Text.class);
    public final PBRepeatMessageField<oidb_0x8e7$Text> rpt_msg_user_num_limit_info = PBField.initRepeatMessage(oidb_0x8e7$Text.class);
    public final PBRepeatMessageField<oidb_0x8e7$Text> rpt_msg_zan_limit_info = PBField.initRepeatMessage(oidb_0x8e7$Text.class);
}
