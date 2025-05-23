package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$HwQueryCardReq extends MessageMicro<group_mgr$HwQueryCardReq> {
    public static final int GID_FIELD_NUMBER = 1;
    public static final int TARGET_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QCircleRelationGroupRequest.GROUP_ID, "target_uin"}, new Object[]{0L, 0L}, group_mgr$HwQueryCardReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
}
