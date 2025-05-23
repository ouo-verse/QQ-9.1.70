package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf26$RevokeReq extends MessageMicro<oidb_0xf26$RevokeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16}, new String[]{"auth_group_id"}, new Object[]{0}, oidb_0xf26$RevokeReq.class);
    public final PBRepeatField<Integer> auth_group_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
