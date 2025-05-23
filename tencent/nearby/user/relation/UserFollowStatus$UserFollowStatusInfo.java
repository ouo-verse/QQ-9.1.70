package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UserFollowStatus$UserFollowStatusInfo extends MessageMicro<UserFollowStatus$UserFollowStatusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"dst_uin", "follow_status"}, new Object[]{0L, 0}, UserFollowStatus$UserFollowStatusInfo.class);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0);
    public final PBEnumField follow_status = PBField.initEnum(0);
}
