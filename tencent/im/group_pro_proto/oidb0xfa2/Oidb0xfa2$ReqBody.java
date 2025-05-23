package tencent.im.group_pro_proto.oidb0xfa2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb0xfa2$ReqBody extends MessageMicro<Oidb0xfa2$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"channel_param"}, new Object[]{null}, Oidb0xfa2$ReqBody.class);
    public Oidb0xfa2$ChannelParam channel_param = new MessageMicro<Oidb0xfa2$ChannelParam>() { // from class: tencent.im.group_pro_proto.oidb0xfa2.Oidb0xfa2$ChannelParam
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"guild_id", "channel_id", "begin_seq", "end_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME}, new Object[]{0L, 0L, 0L, 0L, 0L}, Oidb0xfa2$ChannelParam.class);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);
        public final PBUInt64Field channel_id = PBField.initUInt64(0);
        public final PBUInt64Field begin_seq = PBField.initUInt64(0);
        public final PBUInt64Field end_seq = PBField.initUInt64(0);
        public final PBUInt64Field msg_time = PBField.initUInt64(0);
    };
}
