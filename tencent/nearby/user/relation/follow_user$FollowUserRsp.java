package tencent.nearby.user.relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.nearby.common.nearby_common$ErrorInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class follow_user$FollowUserRsp extends MessageMicro<follow_user$FollowUserRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uin", "dst_uin", "result"}, new Object[]{0L, 0L, null}, follow_user$FollowUserRsp.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field dst_uin = PBField.initUInt64(0);
    public nearby_common$ErrorInfo result = new nearby_common$ErrorInfo();
}
