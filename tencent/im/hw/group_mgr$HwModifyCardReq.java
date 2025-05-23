package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class group_mgr$HwModifyCardReq extends MessageMicro<group_mgr$HwModifyCardReq> {
    public static final int CARD_INFO_FIELD_NUMBER = 3;
    public static final int GID_FIELD_NUMBER = 1;
    public static final int TARGET_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{QCircleRelationGroupRequest.GROUP_ID, "target_uin", "card_info"}, new Object[]{0L, 0L, null}, group_mgr$HwModifyCardReq.class);
    public final PBUInt64Field gid = PBField.initUInt64(0);
    public final PBUInt64Field target_uin = PBField.initUInt64(0);
    public group_mgr$CardInfo card_info = new group_mgr$CardInfo();
}
