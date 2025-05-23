package tencent.im.user.set;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class NewMsgNotifySwitchPb$ReqBody extends MessageMicro<NewMsgNotifySwitchPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_notify_switch", "uint32_bind_uin_notify_switch"}, new Object[]{0, 1}, NewMsgNotifySwitchPb$ReqBody.class);
    public final PBUInt32Field uint32_notify_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bind_uin_notify_switch = PBField.initUInt32(1);
}
