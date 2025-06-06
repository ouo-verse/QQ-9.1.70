package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6cd$ReqBody extends MessageMicro<cmd0x6cd$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"rpt_last_pull_redpoint", "rpt_unfinished_redpoint", "msg_pull_single_task", "uint32_ret_msg_rec"}, new Object[]{null, null, null, 0}, cmd0x6cd$ReqBody.class);
    public final PBRepeatMessageField<cmd0x6cd$PullRedpointReq> rpt_last_pull_redpoint = PBField.initRepeatMessage(cmd0x6cd$PullRedpointReq.class);
    public final PBRepeatMessageField<cmd0x6cd$PullRedpointReq> rpt_unfinished_redpoint = PBField.initRepeatMessage(cmd0x6cd$PullRedpointReq.class);
    public cmd0x6cd$PullRedpointReq msg_pull_single_task = new cmd0x6cd$PullRedpointReq();
    public final PBUInt32Field uint32_ret_msg_rec = PBField.initUInt32(0);
}
