package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopJoinQunAutoSwitch$RetrieveSubGroupRsp extends MessageMicro<TroopJoinQunAutoSwitch$RetrieveSubGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"group_id", "group_name", "member_num", "member_max_num", "group_face", "auth_sign"}, new Object[]{"", "", 0, 0, "", ""}, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp.class);
    public final PBStringField group_id = PBField.initString("");
    public final PBStringField group_name = PBField.initString("");
    public final PBUInt32Field member_num = PBField.initUInt32(0);
    public final PBUInt32Field member_max_num = PBField.initUInt32(0);
    public final PBStringField group_face = PBField.initString("");
    public final PBStringField auth_sign = PBField.initString("");
}
