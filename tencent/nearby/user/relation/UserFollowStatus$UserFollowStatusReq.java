package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UserFollowStatus$UserFollowStatusReq extends MessageMicro<UserFollowStatus$UserFollowStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "dst_uin_list"}, new Object[]{0L, 0L}, UserFollowStatus$UserFollowStatusReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatField<Long> dst_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
