package tencent.im.oidb.cmd0xaf6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xaf6$GroupMember extends MessageMicro<cmd0xaf6$GroupMember> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "uins"}, new Object[]{0L, 0L}, cmd0xaf6$GroupMember.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
