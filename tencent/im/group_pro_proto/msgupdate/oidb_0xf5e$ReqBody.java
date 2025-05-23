package tencent.im.group_pro_proto.msgupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf5e$ReqBody extends MessageMicro<oidb_0xf5e$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"guild_id", "channel_id", "msg_seqs", "msg_keys", "direct_message_flag"}, new Object[]{0L, 0L, 0L, null, 0}, oidb_0xf5e$ReqBody.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> msg_seqs = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0xf5e$MsgKey> msg_keys = PBField.initRepeatMessage(oidb_0xf5e$MsgKey.class);
    public final PBUInt32Field direct_message_flag = PBField.initUInt32(0);
}
