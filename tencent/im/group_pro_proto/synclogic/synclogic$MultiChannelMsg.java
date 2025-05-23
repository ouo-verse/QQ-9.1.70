package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$MultiChannelMsg extends MessageMicro<synclogic$MultiChannelMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"push_flag", "seq", "rpt_channel_msgs", "get_msg_time"}, new Object[]{0, 0, null, 0L}, synclogic$MultiChannelMsg.class);
    public final PBUInt32Field push_flag = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<synclogic$ChannelMsg> rpt_channel_msgs = PBField.initRepeatMessage(synclogic$ChannelMsg.class);
    public final PBUInt64Field get_msg_time = PBField.initUInt64(0);
}
