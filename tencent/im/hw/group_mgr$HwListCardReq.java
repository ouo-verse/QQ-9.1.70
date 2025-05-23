package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$HwListCardReq extends MessageMicro<group_mgr$HwListCardReq> {
    public static final int GID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{QCircleRelationGroupRequest.GROUP_ID}, new Object[]{0L}, group_mgr$HwListCardReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0);
}
