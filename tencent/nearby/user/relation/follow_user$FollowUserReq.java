package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class follow_user$FollowUserReq extends MessageMicro<follow_user$FollowUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uin", "dst_uin", "follow_type", "source"}, new Object[]{0L, 0L, 0, 1}, follow_user$FollowUserReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0);
    public final PBEnumField follow_type = PBField.initEnum(0);
    public final PBEnumField source = PBField.initEnum(1);
}
