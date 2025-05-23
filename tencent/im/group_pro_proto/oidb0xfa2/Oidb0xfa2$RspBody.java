package tencent.im.group_pro_proto.oidb0xfa2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb0xfa2$RspBody extends MessageMicro<Oidb0xfa2$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"result", "err_msg", "channel_msg"}, new Object[]{0, ByteStringMicro.EMPTY, null}, Oidb0xfa2$RspBody.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public Oidb0xfa2$ChannelMsg channel_msg = new MessageMicro<Oidb0xfa2$ChannelMsg>() { // from class: tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2$ChannelMsg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50}, new String[]{"guild_id", "channel_id", "result", "rsp_begin_seq", "rsp_end_seq", "rpt_msgs"}, new Object[]{0L, 0L, 0, 0L, 0L, null}, Oidb0xfa2$ChannelMsg.class);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt32Field result = PBField.initUInt32(0);
        public final PBUInt64Field rsp_begin_seq = PBField.initUInt64(0);
        public final PBUInt64Field rsp_end_seq = PBField.initUInt64(0);
        public final PBRepeatMessageField<common$Msg> rpt_msgs = PBField.initRepeatMessage(common$Msg.class);
    };
}
