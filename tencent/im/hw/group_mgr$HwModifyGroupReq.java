package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$HwModifyGroupReq extends MessageMicro<group_mgr$HwModifyGroupReq> {
    public static final int GID_FIELD_NUMBER = 1;
    public static final int INFO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{QCircleRelationGroupRequest.GROUP_ID, "info"}, new Object[]{0L, null}, group_mgr$HwModifyGroupReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0);
    public group_mgr$GroupInfo info = new group_mgr$GroupInfo();
}
