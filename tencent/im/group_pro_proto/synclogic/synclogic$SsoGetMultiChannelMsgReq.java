package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$SsoGetMultiChannelMsgReq extends MessageMicro<synclogic$SsoGetMultiChannelMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"multi_channel_msg_req"}, new Object[]{null}, synclogic$SsoGetMultiChannelMsgReq.class);
    public synclogic$MultiChannelMsgReq multi_channel_msg_req = new MessageMicro<synclogic$MultiChannelMsgReq>() { // from class: tencent.im.group_pro_proto.synclogic.synclogic$MultiChannelMsgReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"rpt_channel_params", "seq", "direct_message_flag", "pull_msg_auth_flag", "pull_msg_num"}, new Object[]{null, 0, 0, 0, 0}, synclogic$MultiChannelMsgReq.class);
        public final PBRepeatMessageField<synclogic$ChannelParam> rpt_channel_params = PBField.initRepeatMessage(synclogic$ChannelParam.class);
        public final PBUInt32Field seq = PBField.initUInt32(0);
        public final PBUInt32Field direct_message_flag = PBField.initUInt32(0);
        public final PBUInt32Field pull_msg_auth_flag = PBField.initUInt32(0);
        public final PBUInt32Field pull_msg_num = PBField.initUInt32(0);
    };
}
