package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6cd$RspBody extends MessageMicro<cmd0x6cd$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_redpoint", "rpt_unfinished_redpoint"}, new Object[]{null, null}, cmd0x6cd$RspBody.class);
    public final PBRepeatMessageField<cmd0x6cd$RedpointInfo> rpt_msg_redpoint = PBField.initRepeatMessage(cmd0x6cd$RedpointInfo.class);
    public final PBRepeatMessageField<cmd0x6cd$PullRedpointReq> rpt_unfinished_redpoint = PBField.initRepeatMessage(cmd0x6cd$PullRedpointReq.class);
}
