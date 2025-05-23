package tencent.im.oidb.cmd0x8bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8bb$WriteReq extends MessageMicro<oidb_0x8bb$WriteReq> {
    public static final int RPT_MSG_GROUP_CONCERNED_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_group_concerned"}, new Object[]{null}, oidb_0x8bb$WriteReq.class);
    public final PBRepeatMessageField<oidb_0x8bb$GroupConcernedInfo> rpt_msg_group_concerned = PBField.initRepeatMessage(oidb_0x8bb$GroupConcernedInfo.class);
}
