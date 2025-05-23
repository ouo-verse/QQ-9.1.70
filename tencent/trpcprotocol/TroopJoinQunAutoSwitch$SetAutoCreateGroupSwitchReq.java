package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq extends MessageMicro<TroopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_id", "switch_value"}, new Object[]{0L, 0}, TroopJoinQunAutoSwitch$SetAutoCreateGroupSwitchReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBUInt32Field switch_value = PBField.initUInt32(0);
}
