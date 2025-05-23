package tencent.im.oidb.oidb_0xdc9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdc9$ReqBody extends MessageMicro<oidb_0xdc9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", "group_user"}, new Object[]{0L, null}, oidb_0xdc9$ReqBody.class);
    public final PBRepeatField<Long> group_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_0xdc9$GroupUser group_user = new MessageMicro<oidb_0xdc9$GroupUser>() { // from class: tencent.im.oidb.oidb_0xdc9.oidb_0xdc9$GroupUser
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "uin"}, new Object[]{0L, 0L}, oidb_0xdc9$GroupUser.class);
        public final PBUInt64Field group_id = PBField.initUInt64(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
    };
}
