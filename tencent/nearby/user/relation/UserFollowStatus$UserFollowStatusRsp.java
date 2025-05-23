package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.nearby.common.nearby_common$ErrorInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UserFollowStatus$UserFollowStatusRsp extends MessageMicro<UserFollowStatus$UserFollowStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "follow_status_info_list", "result"}, new Object[]{0L, null, null}, UserFollowStatus$UserFollowStatusRsp.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<UserFollowStatus$UserFollowStatusInfo> follow_status_info_list = PBField.initRepeatMessage(UserFollowStatus$UserFollowStatusInfo.class);
    public nearby_common$ErrorInfo result = new nearby_common$ErrorInfo();
}
