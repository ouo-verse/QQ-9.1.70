package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* loaded from: classes29.dex */
public final class synclogic$ChannelParam extends MessageMicro<synclogic$ChannelParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 64}, new String[]{"guild_id", "channel_id", "begin_seq", "end_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "rpt_version", "seqs", "max_seq_local"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, null, 0L}, synclogic$ChannelParam.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field begin_seq = PBField.initUInt64(0);
    public final PBUInt64Field end_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_version = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<synclogic$MsgCond> seqs = PBField.initRepeatMessage(synclogic$MsgCond.class);
    public final PBUInt64Field max_seq_local = PBField.initUInt64(0);
}
