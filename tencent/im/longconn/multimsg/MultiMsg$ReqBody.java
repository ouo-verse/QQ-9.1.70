package tencent.im.longconn.multimsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MultiMsg$ReqBody extends MessageMicro<MultiMsg$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 64, 72}, new String[]{"uint32_subcmd", "uint32_term_type", "uint32_platform_type", "uint32_net_type", "bytes_build_ver", "rpt_multimsg_applyup_req", "rpt_multimsg_applydown_req", "uint32_bu_type", "uint32_req_channel_type"}, new Object[]{0, 0, 0, 0, ByteStringMicro.EMPTY, null, null, 0, 0}, MultiMsg$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_term_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<MultiMsg$MultiMsgApplyUpReq> rpt_multimsg_applyup_req = PBField.initRepeatMessage(MultiMsg$MultiMsgApplyUpReq.class);
    public final PBRepeatMessageField<MultiMsg$MultiMsgApplyDownReq> rpt_multimsg_applydown_req = PBField.initRepeatMessage(MultiMsg$MultiMsgApplyDownReq.class);
    public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_channel_type = PBField.initUInt32(0);
}
