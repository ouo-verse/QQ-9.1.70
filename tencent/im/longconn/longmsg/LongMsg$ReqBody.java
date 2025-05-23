package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LongMsg$ReqBody extends MessageMicro<LongMsg$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 80, 88}, new String[]{"uint32_subcmd", "uint32_term_type", "uint32_platform_type", "rpt_msg_up_req", "rpt_msg_down_req", "rpt_msg_del_req", "uint32_agent_type", "uint32_busi_type"}, new Object[]{0, 0, 0, null, null, null, 0, 0}, LongMsg$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<LongMsg$MsgUpReq> rpt_msg_up_req = PBField.initRepeatMessage(LongMsg$MsgUpReq.class);
    public final PBRepeatMessageField<LongMsg$MsgDownReq> rpt_msg_down_req = PBField.initRepeatMessage(LongMsg$MsgDownReq.class);
    public final PBRepeatMessageField<LongMsg$MsgDeleteReq> rpt_msg_del_req = PBField.initRepeatMessage(LongMsg$MsgDeleteReq.class);
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
}
