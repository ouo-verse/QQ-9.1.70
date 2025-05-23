package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$RspBody extends MessageMicro<MultiMsg$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_subcmd", "rpt_multimsg_applyup_rsp", "rpt_multimsg_applydown_rsp"}, new Object[]{0, null, null}, MultiMsg$RspBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBRepeatMessageField<MultiMsg$MultiMsgApplyUpRsp> rpt_multimsg_applyup_rsp = PBField.initRepeatMessage(MultiMsg$MultiMsgApplyUpRsp.class);
    public final PBRepeatMessageField<MultiMsg$MultiMsgApplyDownRsp> rpt_multimsg_applydown_rsp = PBField.initRepeatMessage(MultiMsg$MultiMsgApplyDownRsp.class);
}
