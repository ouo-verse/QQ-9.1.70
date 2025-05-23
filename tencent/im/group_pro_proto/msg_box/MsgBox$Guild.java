package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$Guild extends MessageMicro<MsgBox$Guild> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"guild_id", "channels"}, new Object[]{0L, null}, MsgBox$Guild.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<MsgBox$Channel> channels = PBField.initRepeatMessage(MsgBox$Channel.class);
}
