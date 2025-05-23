package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$UinEvent extends MessageMicro<MsgBox$UinEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"to_uin", "channel_event"}, new Object[]{0L, null}, MsgBox$UinEvent.class);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public MsgBox$ChannelEvent channel_event = new MsgBox$ChannelEvent();
}
