package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$DelReq extends MessageMicro<MsgBox$DelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"guild_id", "channel_id", "msg_seq", "to_uins"}, new Object[]{0L, 0L, 0L, 0L}, MsgBox$DelReq.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBRepeatField<Long> to_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
