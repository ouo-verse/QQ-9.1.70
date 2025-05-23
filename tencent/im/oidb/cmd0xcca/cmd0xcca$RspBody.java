package tencent.im.oidb.cmd0xcca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xcca$RspBody extends MessageMicro<cmd0xcca$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_group_members_num", "uint32_group_friends_num", "friends_uins", "uint32_status"}, new Object[]{0, 0, 0L, 0}, cmd0xcca$RspBody.class);
    public final PBUInt32Field uint32_group_members_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_friends_num = PBField.initUInt32(0);
    public final PBRepeatField<Long> friends_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
}
