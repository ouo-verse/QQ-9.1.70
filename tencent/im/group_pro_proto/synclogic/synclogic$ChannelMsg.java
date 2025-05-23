package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$ChannelMsg extends MessageMicro<synclogic$ChannelMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56}, new String[]{"guild_id", "channel_id", "result", "rsp_begin_seq", "rsp_end_seq", "rpt_msgs", "polling_interval"}, new Object[]{0L, 0L, 0, 0L, 0L, null, 0L}, synclogic$ChannelMsg.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt64Field rsp_begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field rsp_end_seq = PBField.initUInt64(0);
    public final PBRepeatMessageField<common$Msg> rpt_msgs = PBField.initRepeatMessage(common$Msg.class);
    public final PBUInt64Field polling_interval = PBField.initUInt64(0);
}
