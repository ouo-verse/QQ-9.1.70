package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopJoinQunAutoSwitch$RetrieveSubGroupReq extends MessageMicro<TroopJoinQunAutoSwitch$RetrieveSubGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"group_id", "scene"}, new Object[]{"", 0}, TroopJoinQunAutoSwitch$RetrieveSubGroupReq.class);
    public final PBStringField group_id = PBField.initString("");
    public final PBUInt32Field scene = PBField.initUInt32(0);
}
